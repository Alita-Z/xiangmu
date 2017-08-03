<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript" src="../js/jquery-3.2.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function del(id) {
		$.get("/test_ssh/user/delUser?id=" + id, 
				function(data) {
					if ("success" == data.result) {
					alert("删除成功");
					window.location.reload();
					} else {
						alert("删除失败");
					}
				});
	}
    
	//获取User对象  
	function getJsonObject(id) {
		$.ajax({
			type : "POST",
			url : "/test_ssh/user/json1",
			dataType : "json",
			success : function(json) {
				alert(id);
				alert(json.username);
				alert(json.password);
			},
			error : function() {
				alert("网络错误！");
			}
		});
	}
	
	$(document).ready(function(){  
        $("#resolveJsonObject").click(function(){  
            var userName =encodeURI($("#username").attr("value"));  
            var age = encodeURI($("#password").attr("value"));  
              
            var user = {username:username, password:password};  
            var aMenu  = encodeURI(JSON.stringify(user));  
  
            $.ajax({  
                 url:"/test_ssh/user/json2" ,  
                 data:"orderJson=" + aMenu,    
                 success:function(data){  
                	 alert(data.username);
                }  
            }); 
            
        }); 
	});
</script>
</head>
<body>
	<h6>
		<a href="/test_ssh/user/toAddUser">添加用户</a>
	</h6>
	<table border="1">
		<tbody>
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>操作</th>
			</tr>
			<c:if test="${not empty userList }">
				<c:forEach items="${userList}" var="user">
					<tr>
						<td id=>${user.username }</td>
						<td id=>${user.password }</td>
						<td><a href="/test_ssh/user/getUser?id=${user.id }">编辑</a>
						 	<a href="javascript:del('${user.id }')">删除</a>
							<a href="javascript:getJsonObject('${user.id }')">json</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	 姓名:<input id="username" type="text" name="username">  
   	 密码:<input id="password" type="text" name="password"><br> 
	<input type="button" id="resolveJsonObject" value="json对象"> 
</body>
</html>