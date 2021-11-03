package com.Source.note.web;

import com.Source.note.po.User;
import com.Source.note.service.UserService;
import com.Source.note.vo.ResultInfo;
import org.apache.commons.io.FileUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.File;
import java.io.IOException;

@WebServlet("/user")
@MultipartConfig
public class UserServlet extends HttpServlet{
   private UserService userService=new UserService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //设置首页导航高亮
        request.setAttribute("menu_page","user");
        //接收用户行为
    String actionName=request.getParameter("actionName");
    //判断用户行为，调用对应方法
    if("login".equals(actionName)){
        //用户登录
        userLogin(request,response);
    }else if("logout".equals(actionName)){
        //用户退出
        userLogout(request,response);
    }else if("userCenter".equals(actionName)){
        //进入个人中心
        userCenter(request,response);
    }else if("userHead".equals(actionName)){
        //  加载头像
        userHead(request,response);
    }else if("checkNick".equals(actionName)){
        //验证用户唯一性
        checkNick(request,response);
    }else if("updateUser".equals(actionName)){
        //修改用户信息
        updateUser(request,response);
    }

    }

    /**
     * 修改用户信息
     * 注：文件上传必须在servlet上加注解@
     *         1.调用Service层的方法，传递request对象作为参数，返回resultInfo对象
     *         2.将resultInfo对象传到request作用域中
     *         3.请求转发跳转到个人中心页面(user?actionName=userCenter)
     *     service层：
     * @param request
     * @param response
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 1.调用Service层的方法，传递request对象作为参数，返回resultInfo对象
        ResultInfo<User> resultInfo=userService.updateUser(request);

        //2.将resultInfo对象传到request作用域中
        request.setAttribute("resultInfo",resultInfo);
        //请求转发跳转到个人中心页面(user?actionName=userCenter)
        request.getRequestDispatcher("user?actionName=userCenter").forward(request,response);
    }

    /**
     * 检验昵称
     *  1.获取参数（昵称）
     *  2.从sess作用域中获取用户对象，得到用户ID
     *  3.调用Service层的方法，得到返回的结果
     *  4.通过字符输出流将结果响应给前台的ajax的回调函数
     *  5.关闭资源
     * @param request
     * @param response
     */
    private void checkNick(HttpServletRequest request, HttpServletResponse response) throws IOException {
            //获取参数（昵称）
        String nick=request.getParameter("nick");
        //从session作用域获取用户对象，得到用户ID
        User user =(User)request.getSession().getAttribute("user");
        //调用Service方法，得到返回的结果
        Integer code =userService.checkNick(nick,user.getUserId());
        //通过字符串输出流将结果响应给前台的ajax的回调函数
        response.getWriter().write(code+"");
        //关闭资源
        response.getWriter().close();
    }

    /**
     *加载头像
     * 1.获取参数
     * 2.得到图片的存放路径（request.getServletContext().getRealPath('/')）
     * 3.通过图片的完整路径，得到file对象
     * 4.通过截取，获得图片后缀
     * 5.通过不同图片后缀，设置不同响应类型
     * 6.利用FileUtils的copy工具将图片传至浏览器
     * @param request
     * @param response
     */
    private void userHead(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取图像名称
        String head=request.getParameter("imageName");
        //得到图片的存放路径(得到项目真实路径)
        String realpath=request.getServletContext().getRealPath("/WEB-INF/upload/");
        //通过图片的完整路径，得到file对象
        File file=new File(realpath+"/"+head);
        //通过截取，获得图片后缀
        String pic=head.substring(head.lastIndexOf(".")+1);
        //通过不同图片后缀，设置不同响应类型
        if("PNG".equalsIgnoreCase(pic)){
            response.setContentType("image/png");
        }else if("JPG".equalsIgnoreCase(pic)||"JPEG".equalsIgnoreCase(pic)){
            response.setContentType("image/jpeg");
        }else if("GIF".equalsIgnoreCase(pic)){
            response.setContentType("image/gif");
        }
        //利用FileUtils的copy工具将图片传至浏览器
        FileUtils.copyFile(file,response.getOutputStream());
    }

    /**
     * 进入个人中心
     * 1.设置首页动态包含页面至
     * 2.请求转发跳到index
     * @param request
     * @param response
     */
    private void userCenter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 1.设置首页动态包含页面值
        request.setAttribute("changePage","user/info.jsp");
        //2.请求转发跳到index
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    /**
     * 用户退出
     * 销毁session对象
     * 清空cookie对象
     * 重定向到登录界面
     * @param request
     * @param response
     */
    private void userLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //销毁session对象
        request.getSession().invalidate();
        //清空cookie对象
        Cookie cookie=new Cookie("user", null);
        cookie.setMaxAge(0);//设置有效时间
        response.addCookie(cookie);
        //重定向到登录界面
        response.sendRedirect("login.jsp");
    }

    /**
     * 用户登录
     * 1. 获取参数 （姓名、密码）
     *2. 参数的非空校验  （ResultInfo的封装类，用来封装响应结果  状态码、提示信息、返回的对象）
     *    如果为空
     *        设置ResultInfo对象的状态码和提示信息
     *        将ResultInfo对象设置request作用域中
     *        请求转发跳转到登录页面
     *        return
     *3. 如果不为空，通过用户名查询用户对象
     *4. 判断用户对象是否为空
     *    如果为空
     *        设置ResultInfo对象的状态码和提示信息
     *        将ResultInfo对象设置request作用域中
     *        请求转发跳转到登录页面
     *        return
     *5. 如果用户对象不为空，将数据库中查询到的用户对象的密码与前台传递的密码作比较 （将密码加密后再比较）
     *    如果密码不正确
     *        设置ResultInfo对象的状态码和提示信息
     *        将ResultInfo对象设置request作用域中
     *        请求转发跳转到登录页面
     *        return
     *6. 如果密码正确
     *    将用户信息存到session作用域中
     *    判断用户是否选择记住密码（rem的值是1）
     *        如果是，将用户姓名与密码存到cookie中，设置失效时间，并响应给客户端
     *        如果否，清空原有的cookie对象
     *    重定向跳转到index页面
     * @param request
     * @param response
     */
    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName=request.getParameter("userName");
        String userPwd=request.getParameter("userPwd");
        //2.调用service层
        ResultInfo<User> resultInfo=userService.userLogin(userName,userPwd);
        //3.判断登录成功
        if (resultInfo.getCode() == 1) {
        //如果成功
            request.getSession().setAttribute("user",resultInfo.getResult());
            //判断用户是否选择记住密码（rem的值是1）

            String rem=request.getParameter("rem");
            //如果是，将用户姓名与密码存到cookie，设置失效时间并响应给客户
            if("1".equals(rem)){
                //得到cookie对象
                Cookie cookie=new Cookie("user",userName+"-"+userPwd);
                //设置失效时间
                cookie.setMaxAge(3*24*60*60);
                //响应给客户端
                response.addCookie(cookie);
            }else{
                //如果否，清空原有的cookie对象
                Cookie cookie=new Cookie("user",null);
                // 删除cookie,设置maxAge为0
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            //重定向跳转到index页面
            response.sendRedirect("index");

        }else{//失败
            // 将用户信息存到session作用域中
            request.setAttribute("resultInfo",resultInfo);
            //请求转发跳转到登录页面
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }
        }
    }

