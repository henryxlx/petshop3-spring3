package edu.jostutor.petshop.web.controller;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-14
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/SignIn.aspx")
public class SignInController {

    @RequestMapping(method = RequestMethod.GET)
    public String signIn() throws Exception {
        return "signIn";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signInFailed(HttpServletRequest request, @ModelAttribute String emptyText, BindingResult result) throws Exception {
        new UsernamePasswordValidator().validate(request, result);

        return "signIn";
    }


    private class UsernamePasswordValidator {

        public void validate(HttpServletRequest request, Errors errors) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username == null || "".equals(username.trim())) {
                errors.reject("signin.username", "Please enter user ID.");
            }
            if (password == null || "".equals(password.trim())) {
                errors.reject("signin.password", "Please enter password.");
            }
        }
    }
}
