package edu.jostutor.petshop.dao.jdbc.pagerquery;

import edu.jostutor.dataset.support.PagedListContainer;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 下午8:35
 * To change this template use File | Settings | File Templates.
 */
public interface PagerQuery {

    public PagedListContainer execute(Integer pageIndex, Integer pageSize, Object... args);
}
