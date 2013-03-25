package edu.jostutor.petshop.dao;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import org.springframework.dao.DataAccessException;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 下午12:00
 * To change this template use File | Settings | File Templates.
 */
public interface ProductDao {

    String getProductNameById(String productId);
}
