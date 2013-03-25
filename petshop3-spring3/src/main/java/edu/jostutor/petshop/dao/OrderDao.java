package edu.jostutor.petshop.dao;

import edu.jostutor.petshop.entity.Order;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public interface OrderDao {

    int insertObject(Order newOrder);
}
