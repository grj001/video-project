<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
     <%@ taglib prefix="lyb" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主讲人列表 - 课程管理</title>
<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/static/css/jquery-confirm.min.css" rel="stylesheet">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-confirm.min.js"></script>
<script type="text/javascript">

function deleteSpeaker(id){
	 $.confirm({
		    title: '警告',
		    content: '确认删除么?',
		    type: 'green',
		    buttons: {   
		        ok: {
		            text: "确认",
		            btnClass: 'btn-primary',
		            action: function(){
		               location.href = "${pageContext.request.contextPath }/admin/speaker/delete.action?id="+id;
		            }
		        },
		        cancel:{
		        	text: "取消"
		        }
		    }
		});
}

</script>
</head>
<body>
	<!-- 引入公用的导航信息 -->
	<jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="speaker" name="fromJsp"/>
	</jsp:include>

	<div class="container">
		<div class="jumbotron">
  			<h2>主讲人列表 - 主讲人管理</h2>
		</div>
		<div class="row"><a href="${pageContext.request.contextPath }/admin/speaker/add.action" class="btn btn-primary">添加主讲人</a>
		<div style="float: right;">
			<form class="form-inline" action="${pageContext.request.contextPath }/admin/speaker/list.action" method="post">
			  <div class="form-group">
			    <label for="exampleInputName2">名称</label>
			    <input type="text" class="form-control" name="queryName" id="exampleInputName2" value="${queryName }" placeholder="主讲人名称">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputEmail2">职位</label>
			    <input type="text" class="form-control" name="queryJob" id="exampleInputEmail2" value="${queryJob }" placeholder="主讲人职位">
			  </div>
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th>序号</th>
 					<th>名称</th>
 					<th>职位</th>
 					<th>简介</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
 					<c:forEach items="${page.rows }" var="sp" varStatus="i">
		 				<tr>
		 					<td>${i.count }</td>
		 					<td>${sp.speakerName }</td>
		 					<td>${sp.speakerJob }</td>
		 					<td>${sp.speakerDescr}</td>
		 					<td><a href="${pageContext.request.contextPath }/admin/speaker/update.action?id=${sp.id }"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
            		<td><a  onclick="deleteSpeaker(${sp.id})" href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
		 				</tr>
	 				</c:forEach>
 			</tbody>
		</table>
		<lyb:page url="${pageContext.request.contextPath }/admin/speaker/list.action"></lyb:page>
	</div>



</body>
</html>