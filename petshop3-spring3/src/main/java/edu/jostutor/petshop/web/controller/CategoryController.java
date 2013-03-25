package edu.jostutor.petshop.web.controller;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 上午8:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CategoryController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/Category.aspx")
    public String main() {
        return "category";
    }
}
