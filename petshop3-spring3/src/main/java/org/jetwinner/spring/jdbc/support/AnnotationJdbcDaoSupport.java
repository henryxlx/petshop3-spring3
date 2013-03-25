/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jetwinner.spring.jdbc.support;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author xulixin
 */
public abstract class AnnotationJdbcDaoSupport extends JdbcDaoSupport {

    @Autowired
    public void setSuperDataSource(DataSource dataSource) {
        setDataSource(dataSource);
    }
}
