package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.petshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 下午3:57
 * To change this template use File | Settings | File Templates.
 */
@Repository("productsByCategoryQueryPager")
public class ProductsByCategoryQueryPager extends AbstractPagerQuery<Product> {

    @Autowired
    public ProductsByCategoryQueryPager(DataSource ds) {
        super(ds);
    }

    @Override
    protected String defineSql() {
        return "SELECT productid, name FROM product WHERE category = ?";
    }

    @Override
    protected Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getString("productid"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("name"));
        return product;
    }
}
