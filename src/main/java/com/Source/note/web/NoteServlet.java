package com.Source.note.web;

import com.Source.note.po.NoteType;
import com.Source.note.po.User;
import com.Source.note.service.NoteTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String actionName=request.getParameter("actionName");
        //设置首页导航高亮
        request.setAttribute("menu_page","note");
    if("view".equals(actionName)){
        noteView(request,response);
    }
    }

    /**
     * 进入发布云记
     * @param request
     * @param response
     */
    private void noteView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    User user= (User) request.getSession().getAttribute("user");
    List<NoteType> typeList=new NoteTypeService().findTypeLists(user.getUserId());
    request.getAttribute("typeList");
    request.setAttribute("changePage","note/view.jsp");
    request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
