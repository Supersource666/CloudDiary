/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2021-11-02 05:02:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class info_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"col-md-9\">\r\n");
      out.write("    <div class=\"data_list\">\r\n");
      out.write("        <div class=\"data_list_title\"><span class=\"glyphicon glyphicon-edit\"></span>&nbsp;个人中心</div>\r\n");
      out.write("            <div class=\"container-fluid\">\r\n");
      out.write("                <div class=\"row\" style=\"padding-top: 20px;\">\r\n");
      out.write("                    <div class=\"col-md-8\">\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <div class=\"form-horizontal\" method=\"post\" action=\"user\" enctype=\"multipart/form-data\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                    ");
      out.write("\r\n");
      out.write("                                   <input type=\"hidden\" name=\"actionName\" value=\"updateUser\">\r\n");
      out.write("                                   <label for=\"nickName\" class=\"col-sm-2 control-label\">昵称</label>\r\n");
      out.write("                                   <div class=\"col-sm-3\">\r\n");
      out.write("                                       <input class=\"form-control\" name=\"nick\" id=\"nickName\" placeholder=\"昵称\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.nick}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                                   </div>\r\n");
      out.write("                                  <label for=\"img\" class=\"col-sm-2 control-label\">头像:</label>\r\n");
      out.write("                             <div class=\"col-sm-5\">\r\n");
      out.write("                                <input type=\"file\" id=\"img\" name=\"img\">\r\n");
      out.write("                            </div>\r\n");
      out.write("                           </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <label for=\"mood\" class=\"col-sm-2 control-label\">心情</label>\r\n");
      out.write("                            <div class=\"col-sm-10\">\r\n");
      out.write("                            <textarea class=\"form-control\" name=\"mood\" id=\"mood\" rows=\"3\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.mood}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</textarea>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"form-group\">\r\n");
      out.write("                            <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("                               <button type=\"submit\" id=\"btn\" class=\"btn btn-success\" onclick=\"return updateUser();\">修改</button>&nbsp;&nbsp;\r\n");
      out.write("                                <span style=\"color:red;font-size: 12px\" id=\"msg\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("        <div class=\"col-md-4\"><img style=\"width:240px;height:180px\" src=\"user?actionName=userHead&imageName=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.head}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    //验证用户昵称唯一性\r\n");
      out.write("    /**\r\n");
      out.write("     * 昵称文本框的失焦事件\r\n");
      out.write("     */\r\n");
      out.write("    $(\"#nickName\").blur(function(){\r\n");
      out.write("        //1.获取文本边框的值\r\n");
      out.write("        var nickName=$(\"#nickName\").val();\r\n");
      out.write("        //2.判断值是否为空\r\n");
      out.write("\r\n");
      out.write("        if (isEmpty(nickName)){\r\n");
      out.write("            //如果为空，提示用户，禁用按钮，并return\r\n");
      out.write("            $(\"#msg\").html(\"用户昵称不能为空！\")\r\n");
      out.write("            $(\"#btn\").prop(\"disabled\",true)\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        //3.判断昵称是否做了修改\r\n");
      out.write("        //从session作用域中获取用户信息\r\n");
      out.write("        var nick='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.nick}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("';\r\n");
      out.write("        //如果用户昵称与session作用域中的昵称一致，则return\r\n");
      out.write("        if(nickName==nick){\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        //如果用户昵称做了修改\r\n");
      out.write("        //发送ajax请求后台，验证昵称是否可用\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            type:\"get\",\r\n");
      out.write("            url:\"user\",\r\n");
      out.write("            data:{\r\n");
      out.write("                actionName:\"checkNick\",\r\n");
      out.write("                nick:nickName\r\n");
      out.write("            },\r\n");
      out.write("            success:function(code){\r\n");
      out.write("                //如果可用，清空提示信息，按钮可用\r\n");
      out.write("                if(code==1){\r\n");
      out.write("                    //1.清空提示信息\r\n");
      out.write("                    $(\"#msg\").html(\"\")\r\n");
      out.write("                    //2.按钮可用\r\n");
      out.write("                    $(\"#btn\").prop(\"disabled\",false);\r\n");
      out.write("                }else{\r\n");
      out.write("                    //如果不可用，提示用户，并禁用按钮\r\n");
      out.write("                    // 1.清空提示信息\r\n");
      out.write("                    $(\"#msg\").html(\"该昵称已存在，请重新输入！\")\r\n");
      out.write("                    //2.按钮可用\r\n");
      out.write("                    $(\"#btn\").prop(\"disabled\",true);\r\n");
      out.write("\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        }\r\n");
      out.write("    ).focus(function(){\r\n");
      out.write("            //清空提示信息\r\n");
      out.write("        $(\"#msg\").html(\"\")\r\n");
      out.write("\r\n");
      out.write("        //按钮可用\r\n");
      out.write("        $(\"#btn\").prop(\"disabled\",false)\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    /**\r\n");
      out.write("     * 表单提交校验\r\n");
      out.write("     *  满足条件，返回true,提交表单\r\n");
      out.write("     *  不满足条件，返回 FALSE，表示不提交表单\r\n");
      out.write("     * @returns {boolean}\r\n");
      out.write("     */\r\n");
      out.write("    function updateUser(){\r\n");
      out.write("        //获取文本边框的值\r\n");
      out.write("        var nickName=$(\"#nickName\").val();\r\n");
      out.write("        //判断值是否为空\r\n");
      out.write("\r\n");
      out.write("        if (isEmpty(nickName)){\r\n");
      out.write("            //如果为空，提示用户，禁用按钮，并return\r\n");
      out.write("            $(\"#msg\").html(\"用户昵称不能为空！\")\r\n");
      out.write("            $(\"#btn\").prop(\"disabled\",true)\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("        //唯一性TODO\r\n");
      out.write("\r\n");
      out.write("    return true;\r\n");
      out.write("   }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
