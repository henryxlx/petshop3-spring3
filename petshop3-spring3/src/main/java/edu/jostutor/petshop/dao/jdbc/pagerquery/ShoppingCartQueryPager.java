package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.entity.CartItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-17
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
@Repository("shoppingCartQueryPager")
public class ShoppingCartQueryPager implements PagerQuery {

    @Override
    public PagedListContainer execute(Integer pageIndex, Integer pageSize, Object... args) {
        try {
            List<CartItem> carts = (List<CartItem>) args[0];
            PageOption pageOption = new PageOption(pageIndex, carts.size(), pageSize);
            List<CartItem> newCarts = new ArrayList<CartItem>();
            for (int i = pageOption.getStartingIndex(); i < pageOption.getEndingIndex(); i++) {
                newCarts.add(carts.get(i));
            }
            return new PagedListContainer<CartItem>(pageOption, newCarts);
        } catch (Exception e) {
            return null;
        }
    }
}
