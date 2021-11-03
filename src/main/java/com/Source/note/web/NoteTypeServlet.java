package com.Source.note.web;

import com.Source.note.po.NoteType;
import com.Source.note.po.User;
import com.Source.note.service.NoteTypeService;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/type")
public class NoteTypeServlet extends HttpServlet {
    private NoteTypeService noteTypeService = new NoteTypeService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置首页导航高亮
        request.setAttribute("menu_Page","type");

        //得到用户行为
        String actionName = request.getParameter("actionName");
        //判断用户行为
        if ("list".equals(actionName)) {
            //查询类型列表
            typeList(request, response);
        }


    }

    private void typeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       User user= (User) request.getSession().getAttribute("user");
       List<NoteType> typeList=noteTypeService.findTypeLists(user.getUserId());
       request.setAttribute("typeList",typeList);
       request.setAttribute("changePage","type/list.jsp");
       request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
