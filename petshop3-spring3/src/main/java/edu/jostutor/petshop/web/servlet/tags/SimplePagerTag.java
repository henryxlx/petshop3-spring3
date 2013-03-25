package edu.jostutor.petshop.web.servlet.tags;

import edu.jostutor.dataset.support.PageOption;
import edu.jostutor.dataset.support.PagedListContainer;
import edu.jostutor.petshop.dao.jdbc.pagerquery.PagerQuery;
import org.springframework.beans.BeansException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-13
 * Time: 上午5:35
 */
public class SimplePagerTag extends SimpleTagSupport {

    protected String id;

    protected String beanName;

    protected Integer pageSize = 10;

    protected String emptyText;

    protected JspFragment headerTemplate;
    protected JspFragment itemTemplate;
    protected JspFragment footerTemplate;

    protected static final String HTML1 = "<table cellpadding=0 cellspacing=0><tr><td colspan=2>";
    protected static final String HTML2 = "</td></tr><tr class=gridNav><td>";
    protected static final String HTML3 = "</td><td align=right>";
    protected static final String HTML4 = "</td></tr></table>";

    private static final String LINK_PREV = "<a href=?%s><img src=images/buttonPrev.gif alt=Previous border=\"0\"></a>";
    private static final String LINK_MORE = "<a href=?%s><img src=images/buttonMore.gif alt=More border=\"0\"></a>";
    private static final String KEY_PAGE = "page";
    private static final String COMMA = "\\?";
    private static final String AMP = "&";

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = this.getJspContext().getOut();

        if (beanName == null || "".equals(beanName.trim())) {
            out.write("attribute beanName is null for tag SimplePager");
            return;
        }

        PageContext pageContext = (PageContext) this.getJspContext();
        PagerQuery pagerQuery = null;
        try {
            pagerQuery = (PagerQuery) WebApplicationContextUtils.getWebApplicationContext(
                    pageContext.getServletContext()).getBean(beanName);
        } catch (BeansException e) {
            out.write(e.getMessage());
        }

        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        int currentPageIndex = ServletRequestUtils.getIntParameter(request, getPageIndexParameterName(), 1);

        PagedListContainer container = null;
        if (pagerQuery != null) {
            // 获取JSP页面内脚本建立的传递参数的对象数组
            Object[] queryArguments = (Object[]) getJspContext().getAttribute(beanName);
            container = pagerQuery.execute(currentPageIndex, pageSize, queryArguments);
        }

        if (container == null || container.getPageOption().getMaxPages() == 0) {
            out.write(emptyText);
            return;  //不处理标签体
        }

        PageOption pageOption = container.getPageOption();

        // Write out the first part of the control, the table header
        out.write(HTML1);

        render(out, container);

        // Write out a table row closure
        out.write(HTML2);

        //Mask the query
        String query = request.getQueryString();
        if (query != null) {
            if (!query.startsWith("?")) {
                query = "?" + query;
            }
            query = query.replaceAll(COMMA, AMP);
            StringBuilder sbRegex = new StringBuilder("&").append(getPageIndexParameterName()).append("=").append("\\d+");
            query = query.replaceAll(sbRegex.toString(), "");
        }

        //Determin whether next and previous buttons are required
        //Previous button?
        if (currentPageIndex > 1) {
            StringBuilder sbQueryString = new StringBuilder().append(getPageIndexParameterName())
                    .append("=").append(currentPageIndex - 1).append(query);
            out.write(String.format(LINK_PREV, sbQueryString.toString()));
        }

        //Close the table data tag
        out.write(HTML3);

        //Next button?
        if (currentPageIndex < pageOption.getMaxPages()) {
            StringBuilder sbQueryString = new StringBuilder().append(getPageIndexParameterName())
                    .append("=").append(currentPageIndex + 1).append(query);
            out.write(String.format(LINK_MORE, sbQueryString.toString()));
        }

        //Close the table
        out.write(HTML4);
    }

    protected String getPageIndexParameterName() {
        return KEY_PAGE;
    }

    private void render(JspWriter out, PagedListContainer container) throws JspException, IOException {
        if (headerTemplate != null) {
            headerTemplate.invoke(out);
        }

        List<Object> dataItems = container.getList();
        for (Object dataItem : dataItems) {
            getJspContext().setAttribute(getVarName(), dataItem);
            itemTemplate.invoke(out);
        }

        if (footerTemplate != null) {
            footerTemplate.invoke(out);
        }
    }

    // 从集合中获取对象时的变量名称
    private String varName = null;

    /**
     * 通过标签的id值指定单个变量的名称，
     * 如果是复数名词以S结尾，则去掉s作为单个变量名称
     */
    private String getVarName() {
        if (varName == null) {
            if (id != null && !"".equals(id.trim())) {
                varName = id.trim();
                if (varName.endsWith("s") || varName.endsWith("S")) {
                    varName = varName.substring(0, id.length() - 1);
                }
            } else {
                varName = "dataItem";
            }
        }
        return varName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setEmptyText(String emptyText) {
        this.emptyText = emptyText;
    }

    public void setHeaderTemplate(JspFragment headerTemplate) {
        this.headerTemplate = headerTemplate;
    }

    public void setItemTemplate(JspFragment itemTemplate) {
        this.itemTemplate = itemTemplate;
    }

    public void setFooterTemplate(JspFragment footerTemplate) {
        this.footerTemplate = footerTemplate;
    }
}
