/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-02 10:25:57 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html >\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("    <title>云R记</title>\r\n");
      out.write("    <link href=\"statics/css/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("    <script src=\"statics/js/jquery-1.11.3.js\" type=text/javascript></script>\r\n");
      out.write("    <script src=\"statics/js/util.js\" type=text/javascript></script>\r\n");
      out.write("    <script src=\"statics/js/config.js\" type=text/javascript></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<!--head-->\r\n");
      out.write("<div id=\"head\">\r\n");
      out.write("    <div class=\"top\">\r\n");
      out.write("        <div class=\"fl yahei18\">开启移动办公新时代！</div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--login box-->\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <div id=\"box\">\r\n");
      out.write("        <div class=\"loginbar\">用户登录</div>\r\n");
      out.write("        <div id=\"tabcon\">\r\n");
      out.write("            <div class=\"box show\">\r\n");
      out.write("                <form action=\"user\" method=\"post\" id=\"loginForm\">\r\n");
      out.write("                    ");
      out.write("\r\n");
      out.write("                    <input type=\"hidden\" name=\"actionName\" value=\"login\"/>\r\n");
      out.write("                    <input type=\"text\" class=\"user yahei16\" id=\"userName\" name=\"userName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${resultInfo.result.userName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /><br /><br />\r\n");
      out.write("                    <input type=\"password\" class=\"pwd yahei16\" id=\"userPwd\" name=\"userPwd\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${resultInfo.result.upwd}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\" /><br /><br />\r\n");
      out.write("                    <input name=\"rem\" type=\"checkbox\" value=\"1\"  class=\"inputcheckbox\"/> <label>记住我</label>&nbsp; &nbsp;\r\n");
      out.write("                    <span id=\"msg\" style=\"color: red;font-size: 12px;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${resultInfo.msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</span><br /><br />\r\n");
      out.write("                    <input type=\"button\" class=\"log jc yahei16\" value=\"登 录\" onclick=\"checkLogin()\" />&nbsp; &nbsp; &nbsp; <input type=\"reset\" value=\"取 消\" class=\"reg jc yahei18\" />\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"flash\">\r\n");
      out.write("    <div class=\"pos\">\r\n");
      out.write("        <a bgUrl=\"statics/images/banner-bg1.jpg\" id=\"flash1\" style=\"display:block;\"><img src=\"statics/images/banner_pic1.png\"></a>\r\n");
      out.write("        <a bgUrl=\"statics/images/banner-bg2.jpg\" id=\"flash2\"                       ><img src=\"statics/images/banner-pic2.jpg\"></a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"flash_bar\">\r\n");
      out.write("        <div class=\"dq\" id=\"f1\" onclick=\"changeflash(1)\"></div>\r\n");
      out.write("        <div class=\"no\" id=\"f2\" onclick=\"changeflash(2)\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--bottom-->\r\n");
      out.write("<div id=\"bottom\">\r\n");
      out.write("    <div id=\"copyright\">\r\n");
      out.write("        <div class=\"quick\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><input type=\"button\" class=\"quickbd iphone\" onclick=\"location.href='http://lezijie.com'\" /></li>\r\n");
      out.write("                <li><input type=\"button\" class=\"quickbd android\" onclick=\"location.href='http://lezijie.com'\" /></li>\r\n");
      out.write("                <li><input type=\"button\" class=\"quickbd pc\" onclick=\"location.href='http://lezijie.com'\" /></li>\r\n");
      out.write("                <div class=\"clr\"></div>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"clr\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"text\">\r\n");
      out.write("            Copyright © 2006-2026  <a href=\"http://www.shsxt.com\">上海乐字节</a>  All Rights Reserved\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}