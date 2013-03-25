package edu.jostutor.petshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 上午8:54
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SearchController {

    @RequestMapping("Search.aspx")
    public String doSearch(String keywords) {
        return "search";
    }
}
