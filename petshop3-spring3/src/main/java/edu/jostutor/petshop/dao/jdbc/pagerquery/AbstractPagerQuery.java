package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 下午7:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractPagerQuery<T> implements PagerQuery {

    protected String sql;

    protected String countSql;

    protected JdbcTemplate jdbcTemplate;

    public AbstractPagerQuery(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        saveSql(defineSql());
    }

    protected void saveSql(String sql) {
        this.sql = sql;
        this.countSql = getCountSql(sql);
    }

    protected abstract String defineSql();

    protected abstract T mapRow(ResultSet rs, int rowNum) throws SQLException;

    public PagedListContainer execute(Integer pageIndex, Integer pageSize, Object... args) {
        int count = jdbcTemplate.queryForInt(this.countSql, args);
        PageOption pageOption = new PageOption(pageIndex, count, pageSize);
        RowMapper<T> rowMapper = new RowMapperImpl();
        StringBuilder buf = new StringBuilder(this.sql).append(" ")
                .append("limit ").append(pageOption.getStartingIndex()).append(",").append(pageOption.getEndingIndex());
        List<T> list = jdbcTemplate.query(buf.toString(), args, rowMapper);
        return new PagedListContainer<T>(pageOption, list);
    }

    protected String getCountSql(String sql) {
        String regex = "(^select)(.*?)( from .*)";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(sql);
        boolean isValid = m.find();
        if (!isValid) {
            return null;
        }
        return new StringBuilder().append(m.group(1)).append(" COUNT(*) ").append(m.group(3)).toString();
    }

    protected class RowMapperImpl implements RowMapper<T> {

        @Override
        public T mapRow(ResultSet rs, int rowNum) throws SQLException {
            return AbstractPagerQuery.this.mapRow(rs, rowNum);
        }
    }

}
