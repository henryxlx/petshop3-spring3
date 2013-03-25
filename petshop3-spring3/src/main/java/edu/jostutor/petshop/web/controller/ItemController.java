package edu.jostutor.petshop.web.controller;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.dao.ItemDao;
import edu.jostutor.petshop.dao.ProductDao;
import edu.jostutor.petshop.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 下午11:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("Items.aspx")
    public String main(String productId, Model model) {
        String productName = productDao.getProductNameById(productId);
        model.addAttribute("productName", productName);
        return "items";
    }

    @RequestMapping("/ItemDetails.aspx")
    public String process(String itemId, Model model) throws Exception {
        model.addAttribute("item", itemDao.getItem(itemId));
        return "itemDetails";
    }
}
