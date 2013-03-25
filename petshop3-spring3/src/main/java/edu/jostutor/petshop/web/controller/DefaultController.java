package edu.jostutor.petshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 上午12:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class DefaultController {

    @RequestMapping("/Default.aspx")
    public String main() {
        return "default";
    }

    @RequestMapping("/Help.aspx")
    public String help() {
        return "help";
    }

}
