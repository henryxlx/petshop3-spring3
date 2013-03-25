package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-17
 * Time: 下午12:46
 * To change this template use File | Settings | File Templates.
 */
@Repository("productsBySearchQueryPager")
public class ProductsBySearchQueryPager extends AbstractPagerQuery<Product> {

    private static final String SQL_SELECT_PRODUCTS_BY_SEARCH1 = "SELECT ProductId, Name, Descn FROM Product WHERE ((";
    private static final String SQL_SELECT_PRODUCTS_BY_SEARCH2 = "LOWER(Name) LIKE '%%%s%%' OR LOWER(Category) LIKE '%%%s%%'";
    private static final String SQL_SELECT_PRODUCTS_BY_SEARCH3 = ") OR (";
    private static final String SQL_SELECT_PRODUCTS_BY_SEARCH4 = "))";

    @Autowired
    public ProductsBySearchQueryPager(DataSource ds) {
        super(ds);
    }

    @Override
    protected String defineSql() {
        return "";  //没有设置SQL语句，由于查询关键字生成的语句在execute方法中完成.
    }

    @Override
    protected Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getString("ProductId"));
        product.setName(rs.getString("Name"));
        product.setDescription(rs.getString("Descn"));
        return product;
    }

    public PagedListContainer execute(Integer pageIndex, Integer pageSize, Object... args) {
        if (args == null || args.length < 1) {
            return null;
        }
        Object[] keywords = args;
        int numKeywords = keywords.length;
        //Create a new query string
        StringBuilder buf = new StringBuilder(SQL_SELECT_PRODUCTS_BY_SEARCH1);

        //Add each keyword to the query
        for (int i = 0; i < numKeywords; i++) {
            buf.append(String.format(SQL_SELECT_PRODUCTS_BY_SEARCH2, keywords[i], keywords[i]));
            buf.append(i + 1 < numKeywords ? SQL_SELECT_PRODUCTS_BY_SEARCH3 : SQL_SELECT_PRODUCTS_BY_SEARCH4);
        }
        saveSql(buf.toString());
        int count = jdbcTemplate.queryForInt(this.countSql);
        PageOption pageOption = new PageOption(pageIndex, count, pageSize);
        RowMapper<Product> rowMapper = new RowMapperImpl();
        StringBuilder buffer = new StringBuilder(this.sql).append(" ")
                .append("limit ").append(pageOption.getStartingIndex()).append(",").append(pageOption.getEndingIndex());
        List<Product> list = jdbcTemplate.query(buffer.toString(), rowMapper);
        return new PagedListContainer<Product>(pageOption, list);
    }
}
