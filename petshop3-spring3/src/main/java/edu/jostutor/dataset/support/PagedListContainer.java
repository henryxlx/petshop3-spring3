package edu.jostutor.dataset.support;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: xulixin
 * Date: 2011-12-10
 * Time: 上午10:35
 */
public class PagedListContainer<E> {

    public static final String DATA_SOURCE_KEY = "PagedListContainer.DataSourceKey";

	/** the page option */
	private PageOption pageOption;

	/** the list over which this class is paging */
	private List<E> list;

    public PagedListContainer(PageOption myPageOption, List<E> myList) {
        this.pageOption = myPageOption;
        this.list = myList;
    }

    public PageOption getPageOption() {
        return pageOption;
    }

    public void setPageOption(PageOption myPageOption) {
        this.pageOption = myPageOption;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> myList) {
        this.list = myList;
    }

    public boolean isNotEmpty() {
        return this.list != null && this.list.size() > 0;
    }
}