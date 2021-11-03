

<%--
  Created by IntelliJ IDEA.
  User: Supersource
  Date: 2021/10/31
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-9">
    <div class="data_list">
        <div class="data_list_title">
            <span class="glyphicon  glyphicon-list">类型列表</span>
            <span class="noteType_add">
                <button class="btn btn-sm btn_success" type="button" id="addBtn">添加类别</button>
            </span>
        </div>
    </div>

    <div>
        <c:if test="${empty typeList}">
            <h2>暂未查询到数据！</h2>
        </c:if>
        <c:if test="${!empty typeList}">
           <table class="table table-hover table-striped">
            </tbody>
                   <tr>
                       <th>编号</th>
                       <th>类型</th>
                       <th>操作</th>
                   </tr>
                   <%--遍历类型集合--%>
                    <c:forEach items="${typeList}" var="item">
                        <tr id="tr_${item.typeId}">
                        <td>${item.typeId}</td>
                        <td>${item.typeName}</td>
                        <td>
                            <button class="btn btn-primary" type="button" onclick="openUpdateDialog(${item.typeId})">修改</button>
                            <button class="btn btn-danger del" type="button" onlick="deleteType(${item.typeId})">删除</button>
                        </td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td>2</td>
                        <td>技术</td>
                        <td>
                            <button class="btn btn-primary" type="button" >修改</button>
                            <button class="btn btn-danger del" type="button">删除</button>
                        </td>
                    </tr>
               </tbody>
           </table>
        </c:if>
    </div>
</div>
<%--添加/修改模态框--%>
<div class="modal fade" id="myModal" tableindex="-1" role="dialog" arial-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" arial-label="Close">
            <span arial-hidden="true">x</span>
        </button>
            <h4 class="modal-title" id="myModalLabel">新增</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <label for= "typename">类型名称</label>
                <input type="hidden" name="typeId">
                <input type="text" name="typename" id="typename" class="form-control" placeholder="昵称" value="${user.nick}">
            </div>
        </div>
        <div class="modal-footer">
            <div class="form-group">
                <button type="button" class="btn btn-default" data-dismiss="modal" >
                    <span class="glyphicon glyphicon-remove"></span>关闭</button>
                <button type="button" id="btn_submit" class="btn btn-primary" >
                    <span class="glyphicon glyphicon-floppy-disk"></span>保存</button>
            </div>
        </div>
    </div>
</div>