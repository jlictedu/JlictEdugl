/**
 * 
 */
package com.jlict.edu.core.util;

/**
 * <p>Title: com.jlict.hrgl.core.util.FormatHTMLLayout.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */

import java.text.SimpleDateFormat;   
  
import org.apache.log4j.HTMLLayout;   
import org.apache.log4j.Layout;   
import org.apache.log4j.Level;  
import org.apache.log4j.helpers.Transform;   
import org.apache.log4j.spi.LocationInfo;   
import org.apache.log4j.spi.LoggingEvent;   
  
  
public class FormatHTMLLayout extends HTMLLayout {   
  
    public FormatHTMLLayout() {   
    }   
       
  
    /**  
     * A string constant used in naming the option for setting the the HTML  
     * document title. Current value of this string constant is <b>Title</b>.  
     */ 
    
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  
    // Print no location info by default   
    boolean locationInfo = false;   
       
    public String format(LoggingEvent event) {   
           
        StringBuilder sbuf = new StringBuilder(100);
        
        sbuf.append(Layout.LINE_SEP + "<tr>" + Layout.LINE_SEP);        
        sbuf.append("<td>");   
        sbuf.append(df.format(new java.util.Date()));   
        sbuf.append("</td>" + Layout.LINE_SEP);   
        
        sbuf.append("<td title=\"级别\">");   
        if (event.getLevel().equals(Level.FATAL)) {   
            sbuf.append("<font color=\"#339933\">");   
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));   
            sbuf.append("</font>");   
        } else if (event.getLevel().isGreaterOrEqual(Level.WARN)) {   
            sbuf.append("<font color=\"#993300\"><strong>");   
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));   
            sbuf.append("</strong></font>");   
        } else {   
            sbuf.append("<font color=\"green\">");   
            sbuf.append(Transform.escapeTags(String.valueOf(event.getLevel())));   
            sbuf.append("</font>");   
        }   
        sbuf.append("</td>" + Layout.LINE_SEP);   
           

        if (locationInfo) {   
            LocationInfo locInfo = event.getLocationInformation();   
            sbuf.append("<td title=\"行号\">");
            sbuf.append(Transform.escapeTags(locInfo.getFileName()));  
            sbuf.append(':');  
            sbuf.append(locInfo.getLineNumber());  
            sbuf.append("</td>" + Layout.LINE_SEP);  
        }  
        
        sbuf.append("<td title=\"日志信息\" class=\"break\" >");   
        sbuf.append(Transform.escapeTags(event.getRenderedMessage()));   
        sbuf.append("</td>" + Layout.LINE_SEP); 
          
        String name = (String)event.getMDC("name");
        String jobNumber = (String)event.getMDC("id");
        if(name!=null){  
	            sbuf.append("<td title=\"操作人\">");
	            sbuf.append(name);
	            sbuf.append("</td>");  
        }else{  
            sbuf.append("<td title=\"操作人\">系统</td>");  
        }
        sbuf.append(Layout.LINE_SEP);
        if(name!=null){  
            sbuf.append("<td title=\"操作人id\">");
            sbuf.append(jobNumber);
            sbuf.append("</td>"); 
        }else{  
        	sbuf.append("<td title=\"操作人id\">系统</td>");  
        }
        sbuf.append(Layout.LINE_SEP);
        sbuf.append("</tr>");  
        sbuf.append(Layout.LINE_SEP);
  
        return sbuf.toString();   
    }   
  
    
  
    /**  
     * Returns appropriate HTML headers.  
     */  
    public String getHeader() {
    	return null;       
    }



	@Override
	public String getFooter() {
		// TODO Auto-generated method stub
		return null;
	}   
  
}  