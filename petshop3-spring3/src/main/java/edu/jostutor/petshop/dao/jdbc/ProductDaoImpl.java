package edu.jostutor.petshop.dao.jdbc;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.dao.ProductDao;
import edu.jostutor.petshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
@Repository("productDao")
public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public String getProductNameById(String productId) {
        return jdbcTemplate.queryForObject("SELECT name FROM product WHERE productId = ?", String.class, productId);
    }
}
