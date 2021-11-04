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
                                <div class="col-sm-12">
<%--                                    判断类型列表是否为空，如果为空，提示用户先添加类型--%>
<%--                                    <c:if test="${empty typeList}">--%>
<%--                                        <h2>暂未查询到用户</h2>--%>
<%--                                        <h4><a href="type?actionName=note">添加类型</a></h4>--%>
<%--                                    </c:if>--%>
<%--                                    <c:if test="${!empty typeList}">--%>
                                       <form class="form-horizontal" method="post" action="note">
<%--                                           设置隐藏域，用来存放用户行为actionName--%>
<%--                                           <input type ="hidden" name="actionName" value="addOrUpdate">--%>
                                           <div class="form-group">
                                               <label for="typeId" class="col-sm-2 control-label">类别</label>
                                               <div class="col-sm-8">
                                                   <select id="typeId" class="form-control" name="typeId">
                                                       <option value="">请选择云记类别...</option>
<%--                                                       <c:forEach var="item" items="${typeList}">--%>
<%--                                                           <option value="${item.typeId}">${item.typeName}</option>--%>
                                                       <option value="1">私人日记</option>
<%--                                                       </c:forEach>--%>
                                                   </select>
                                               </div>
                                           </div>
                                           <div class="form-group">
                                               <label for="title" class="col-sm-2 control-label">标题</label>
                                               <div class="col-sm-8">
                                                   <input class="form-control" name="title" id="title" placeholder="云记标题" value="12">
                                               </div>
                                           </div>
                                <div class="form-group">
                                    <label for="title" class="col-sm-2 control-label">内容</label>
                                    <div class="col-sm-8">
                                        <%-- 加载富文本编辑器--%>
                                        <textarea id ="content" name="content"></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-4 col-sm-4"></div>
                                    <input type="submit" class="btn btn-primary" onclick="return CheckForm();" value="保存">
                                    &nbsp;<span id="msg" style="font-size:12px;color:red"></span>
                                    <font id="error" color="red"></font>
                                </div>
                               </div>
                            </form>
<%--                        </c:if>--%>
                    </div>
                 </div>
            </div>
        </div>
     </div>
</div>
<script type="text/javascript">
 // $(function(){
 //     var editor =new UE.ui.Editor({initialFrameHeight:'100%',initialFrameWidth:'100%'});
 //     editor.render("Editor");
 // });
    var ue;
    $(function (){
    //加载富文本编辑器
         ue =UE.getEditor('content');
    });

    function CheckForm(){
      var typeId=$("#typeId").val();
      var title=$("#title").val();
      var content=ue.getContent();
      /*参数非空判断*/
        if(isEmpty(typeId)){
    $("#msg").html("请选择云记类型！")
     return false;
     }
        if(isEmpty(title)){
            $("#msg").html("云集标题不能够为空！")
            return false;
        }
        if(isEmpty(content)){
            $("#msg").html("云集内容不能够为空！")
            return false;
        }
      return true;
    }
</script>