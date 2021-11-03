<%--
  Created by IntelliJ IDEA.
  User: Supersource
  Date: 2021/11/2
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon  glyphicon-list"></span>&nbsp;添加云记
        </div>
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="row" style="padding-top: 20px;">
                    <div class="col-md-12">
                        <form class="form-horizontal" method="post" action="note" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="typeId" class="col-sm-2 control-label">类别</label>
                                <div class="col-sm-6">
                                    <select id="typeId"class="form-control" name="typeId">
                                        <option value="1">请选择云集类别...</option>
                                        <option value="2">技术</option>
                                        <option value="3">笔记</option>
                                        <option value="4" selected="">语录</option>
                                        <option value="5" selected="">test</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <input type="hidden" name="noteId" value="28">
                                <input type="hidden" name="act" value="save">
                                <label for="typeId" class="col-sm-2 control-label">标题</label>
                                <div class="col-sm-8">
                                    <input class="form-control" name="title" id="title" placeholder="云记标题" value="12">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">
<%--                                    判断类型列表是否为空，如果为空，提示用户先添加类型--%>
                                    <c:if test="${empty typeList}">
                                        <h2>暂未查询到用户</h2>
                                        <h4><a href="type?actionName=list">添加类型</a></h4>
                                    </c:if>
                                    <c:if test="${empty typeList}">
                                       <form class="form-horizontal" method="post" action="note">
                                           <div class="form-group">
                                               <label for="typeId" class="col-sm-2 control-label">类别</label>
                                               <div class="col-sm-8">
                                                   <select id="typeId" class="form-control" name="typeId">
                                                       <option value="-1">请选择云记类别...</option>
                                                       <c:forEach var="item" items="${typeList}">
                                                           <option value="${item.typeId}">${item.typeName}</option>
                                                       </c:forEach>
                                                       <option value="2">技术</option>
                                                   </select>
                                               </div>
                                           </div>

                                    </c:if>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-6 col-sm-4"></div>
                                    <input type="submit" class="btn btn-primary" onclick="return_saveNote();" value="保存">
                                </div>
                            </div>
                         </form>
                    </div>
                 </div>
            </div>
        </div>
     </div>
</div>