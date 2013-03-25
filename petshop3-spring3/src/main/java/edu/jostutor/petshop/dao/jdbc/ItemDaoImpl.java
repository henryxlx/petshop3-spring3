/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jostutor.petshop.dao.jdbc;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.entity.Item;
import org.jetwinner.spring.jdbc.support.AnnotationJdbcDaoSupport;
import edu.jostutor.petshop.dao.ItemDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author xulixin
 */
@Repository("itemDao")
public class ItemDaoImpl extends AnnotationJdbcDaoSupport implements ItemDao {

    public Item getItem(String itemId) {
        final String sql = "SELECT Item.ItemId, Item.Attr1, Inventory.Qty, "
                + " Item.ListPrice, Product.Name, Product.Descn "
                + " FROM Item INNER JOIN Inventory ON Item.ItemId = Inventory.ItemId "
                + " INNER JOIN Product ON Item.ProductId = Product.ProductId "
                + " WHERE Item.ItemId = ?";
        
        return getJdbcTemplate().queryForObject(sql, new Object[]{itemId},
                new RowMapper<Item>() {

                    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Item item = new Item();
                        item.setId(rs.getString("ItemId"));
                        item.setName(rs.getString("Attr1"));
                        item.setQuantity(rs.getInt("Qty"));
                        item.setPrice(rs.getBigDecimal("ListPrice"));
                        item.setProductName(rs.getString("Name"));
                        item.setProductDesc(rs.getString("Descn"));
                        return item;
                    }
                });
    }

    public boolean isItemInStock(String itemId) {
        String sql = "SELECT Qty FROM Inventory WHERE ItemId = ?";
        int quantity = getJdbcTemplate().queryForInt(sql, itemId);
        return quantity > 0;
    }
}
