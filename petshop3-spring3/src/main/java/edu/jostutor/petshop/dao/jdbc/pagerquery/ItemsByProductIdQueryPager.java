package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.petshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-17
 * Time: 下午12:27
 * To change this template use File | Settings | File Templates.
 */
@Repository("itemsByProductIdQueryPager")
public class ItemsByProductIdQueryPager extends AbstractPagerQuery<Item> {

    @Autowired
    public ItemsByProductIdQueryPager(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    protected String defineSql() {
        return "SELECT ItemId, Attr1, ListPrice, Name FROM Item "
                + " INNER JOIN Product ON Item.ProductId = Product.ProductId "
                + " WHERE Item.ProductId = ?";
    }

    @Override
    protected Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getString("ItemId"));
        item.setName(rs.getString("Attr1"));
        item.setPrice(rs.getBigDecimal("ListPrice"));
        item.setProductName(rs.getString("Name"));
        return item;
    }
}
