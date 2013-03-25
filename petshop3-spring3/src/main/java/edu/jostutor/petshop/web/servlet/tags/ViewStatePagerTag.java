package edu.jostutor.petshop.web.servlet.tags;

import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: xulixin
 * Date: 2013-3-15
 * Time: 上午9:10
 * A class derived from Simplepager which uses viewstate to maintain the current page counts
 * The advantage of this is that you can have several ViewStatePagers on a single page ans each will
 * maintain it's own page numbers, avoiding conflicts with controls reading each other's page number
 * 必须设置id，因为id作为分页参数名的前缀以区别不同分页页签当前页码
 */
public class ViewStatePagerTag extends SimplePagerTag {

    private Boolean visible;

    @Override
    public void doTag() throws JspException, IOException {
        if (visible!= null && !visible) {
            return;
        }
        super.doTag();
    }

    @Override
    protected String getPageIndexParameterName() {
        return id + "_page";
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
