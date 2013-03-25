package edu.jostutor.petshop.dao;

import edu.jostutor.petshop.entity.Account;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-12
 * Time: 下午11:44
 * To change this template use File | Settings | File Templates.
 */
public interface AccountDao {

    Account signIn(String userId, String password);

    Account getAccountByUsername(String username);

    int insertObject(Account account);

    int updateObject(Account account);
}
