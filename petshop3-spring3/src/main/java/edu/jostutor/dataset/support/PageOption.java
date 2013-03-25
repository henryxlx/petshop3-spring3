package edu.jostutor.dataset.support;

/**
 * Created with IntelliJ IDEA.
 * Author: xulixin
 * Date: 2011-12-10
 * Time: 上午9:27
 */
public class PageOption {

	/** the default page size */
	public static final int DEFAULT_PAGE_SIZE = 10;

	/** the page size */
	private int pageSize = DEFAULT_PAGE_SIZE;

	/** the current page */
	private int page;

	/** the starting index */
	private int startingIndex;

	/** the ending index */
	private int endingIndex;

	/** the maximum number of pages */
	private int maxPages;

	private int totalCount;

    public PageOption(int a_page) {
        this.maxPages = 1;
        setPage(a_page);
    }

	/**
	 * Creates a new instance with the specified record count.
	 *
	 * @param a_totalCount Dataset record count
	 */
	public PageOption(int a_page, int a_totalCount, int a_pageSize) {
		this.totalCount = a_totalCount;
        this.pageSize = a_pageSize;
		calculatePages();
        setPage(a_page);
	}

	private void calculatePages() {
		// calculate how many pages there are
		if (totalCount % pageSize == 0) {
			maxPages = totalCount / pageSize;
		} else {
			maxPages = (totalCount / pageSize) + 1;
		}
	}

    private void calculateRecordScope() {
        startingIndex = pageSize * (page - 1);
        if (startingIndex < 0) {
            startingIndex = 0;
        }
        endingIndex = startingIndex + pageSize;
        if (endingIndex > totalCount) {
            endingIndex = totalCount;
        }
    }

	/**
	 * Gets the page size.
	 * 
	 * @return the page size as an int
	 */
	public int getPageSize() {
		return this.pageSize;
	}

	/**
	 * Sets the page size.
	 * 
	 * @param pageSize the page size as an int
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		calculatePages();
	}

	/**
	 * Gets the page.
	 * 
	 * @return the page as an int
	 */
	public int getPage() {
		return this.page;
	}

	/**
	 * Sets the page size.
	 * 
	 * @param p the page as an int
	 */
	public void setPage(int p) {
		if (p >= maxPages) {
			this.page = maxPages;
		} else if (p <= 1) {
			this.page = 1;
		} else {
			this.page = p;
		}

		// now work out where the sub-list should start and end
        calculateRecordScope();
	}

	/**
	 * Gets the total count.
	 *
	 * @return the page as an int
	 */
    public int getTotalCount() {
		return totalCount;
	}

	/**
	 * Sets the total count.
	 *
	 * @param a_totalCount as an int
	 */
    public void setTotalCount(int a_totalCount) {
        this.totalCount = a_totalCount;
        calculatePages();
        calculateRecordScope();
    }

    /**
	 * Gets the maximum number of pages.
	 * 
	 * @return the maximum number of pages as an int
	 */
	public int getMaxPages() {
		return this.maxPages;
	}

	/**
	 * Determines whether there is a previous page and gets the page number.
	 * 
	 * @return the previous page number, or zero
	 */
	public int getPreviousPage() {
		if (page > 1) {
			return page - 1;
		} else {
			return 0;
		}
	}

	/**
	 * Determines whether there is a next page and gets the page number.
	 * 
	 * @return the next page number, or 0
	 */
	public int getNextPage() {
		if (page < maxPages) {
			return page + 1;
		} else {
			return 0;
		}
	}

	public int getStartingIndex() {
		return startingIndex;
	}

	public int getEndingIndex() {
		return endingIndex;
	}

}