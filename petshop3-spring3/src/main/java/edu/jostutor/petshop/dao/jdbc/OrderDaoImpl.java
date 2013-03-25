package edu.jostutor.petshop.dao.jdbc;

import edu.jostutor.petshop.dao.OrderDao;
import edu.jostutor.petshop.entity.LineItem;
import edu.jostutor.petshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 下午4:41
 * To change this template use File | Settings | File Templates.
 */
@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public int insertObject(Order newOrder) {
        final String SQL_INSERT_ORDER = "INSERT INTO orders(UserId, OrderDate, ShipAddr1, ShipAddr2, " +
                " ShipCity, ShipState, ShipZip, ShipCountry, BillAddr1, BillAddr2, BillCity, BillState, BillZip, " +
                " BillCountry, TotalPrice, BillToFirstName, BillToLastName, ShipToFirstName, ShipToLastName, " +
                " CreditCard, ExprDate, CardType) " +
                " VALUES (:userId, :orderDate, :shipAddress1, :shipAddress2, :shipCity, :shipState, :shipZip, " +
                " :shipCountry, :billAddress1, :billAddress2, :billCity, :billState, :billZip, :billCountry, " +
                " :totalPrice, :billToFirstName, :billToLastName, :shipToFirstName, :shipToLastName, " +
                " :creditCard, :exprDate, :cardType)";

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userId", newOrder.getUserId());
        paramMap.put("orderDate", new Date());
        paramMap.put("shipAddress1", newOrder.getShippingAddress().getAddress1());
        paramMap.put("shipAddress2", newOrder.getShippingAddress().getAddress2());
        paramMap.put("shipCity", newOrder.getShippingAddress().getCity());
        paramMap.put("shipState", newOrder.getShippingAddress().getState());
        paramMap.put("shipZip", newOrder.getShippingAddress().getZip());
        paramMap.put("shipCountry", newOrder.getShippingAddress().getCountry());
        paramMap.put("billAddress1", newOrder.getBillingAddress().getAddress1());
        paramMap.put("billAddress2", newOrder.getBillingAddress().getAddress2());
        paramMap.put("billCity", newOrder.getBillingAddress().getCity());
        paramMap.put("billState", newOrder.getBillingAddress().getState());
        paramMap.put("billZip", newOrder.getBillingAddress().getZip());
        paramMap.put("billCountry", newOrder.getBillingAddress().getCountry());

        paramMap.put("totalPrice", newOrder.getOrderTotal());
        paramMap.put("billToFirstName", newOrder.getBillingAddress().getFirstName());
        paramMap.put("billToLastName", newOrder.getBillingAddress().getLastName());
        paramMap.put("shipToFirstName", newOrder.getShippingAddress().getFirstName());
        paramMap.put("shipToLastName", newOrder.getShippingAddress().getLastName());
        paramMap.put("creditCard", newOrder.getCreditCard().getCardNumber());
        paramMap.put("exprDate", newOrder.getCreditCard().getCardExpiration());
        paramMap.put("cardType", newOrder.getCreditCard().getCardType());
        SqlParameterSource paramSource = new MapSqlParameterSource(paramMap);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int nums = namedParameterJdbcTemplate.update(SQL_INSERT_ORDER, paramSource, keyHolder);
        Integer orderId = keyHolder.getKey().intValue();
        newOrder.setOrderId(orderId);

        final String SQL_INSERT_LINE_ITEM = "INSERT INTO LineItem(OrderId, LineNum, ItemId, Quantity, UnitPrice) " +
                " VALUES (:orderId, :lineNum, :itemId, :quantity, :unitPrice)";

        LineItem[] items = newOrder.getLineItems();
        SqlParameterSource[] sqlParameterSources = new SqlParameterSource[items.length];
        for (int i = 0; i < items.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("orderId", orderId);
            map.put("lineNum", items[i].getLine());
            map.put("itemId", items[i].getId());
            map.put("quantity", items[i].getQuantity());
            map.put("unitPrice", items[i].getPrice());
            sqlParameterSources[i] = new MapSqlParameterSource(map);
        }
        namedParameterJdbcTemplate.batchUpdate(SQL_INSERT_LINE_ITEM, sqlParameterSources);

        return nums;
    }
}
