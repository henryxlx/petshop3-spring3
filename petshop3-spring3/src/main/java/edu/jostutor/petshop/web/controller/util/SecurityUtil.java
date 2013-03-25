package edu.jostutor.petshop.web.controller.util;

import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-19
 * Time: 上午7:57
 * To change this template use File | Settings | File Templates.
 */
public abstract class SecurityUtil {

    public static final String getUsername(HttpServletRequest request) {
        String username = "";
        try {
            username = SecurityUtils.getSubject().getPrincipal().toString();
        } catch (Exception e) {
            // noops.
        }
        return username;
    }
}
