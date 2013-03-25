package edu.jostutor.petshop.service;

import edu.jostutor.petshop.dao.AccountDao;
import edu.jostutor.petshop.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-12
 * Time: 下午11:49
 * To change this template use File | Settings | File Templates.
 */
@Component
@Transactional(readOnly = true)
public class AccountManager {

    @Autowired
    private AccountDao accountDao;

    public Account getUserByUsername(String username) {
        return accountDao.getAccountByUsername(username);
    }
}
