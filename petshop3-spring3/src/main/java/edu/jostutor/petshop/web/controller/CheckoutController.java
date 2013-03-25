package edu.jostutor.petshop.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 上午9:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class CheckoutController {

    @RequestMapping("/Checkout.aspx")
    public String process() throws Exception {

        return "checkout";
    }
}
