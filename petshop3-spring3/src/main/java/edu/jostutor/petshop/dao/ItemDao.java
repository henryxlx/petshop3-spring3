/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jostutor.petshop.dao;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.entity.Item;

/**
 *
 * @author xulixin
 */
public interface ItemDao {

    public Item getItem(String itemId);

    public boolean isItemInStock(String itemId);
    
}
