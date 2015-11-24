<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sysresources.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="/js/jquery-1.9.1.min.js" ></script>
	<script type="text/javascript">
	  	function submit(){
	  		$("#sys").submit();
	  	}
	</script>
  </head>
  
  <body>
    	<form action="userResourcesController/insert.do" id="sys" method="post" enctype="multipart/form-data">
    		时长:<input type="text" name="duration" /><br/>
    		用户ID:<input type="text" name="userId" /><br/>
    		资源ID:<input type="text" name="originalId" /><br/>
    		图片:<input type="file" name="userpic" /><br/>
    		视频:<input type="file" name="uservedio" />
    		<input type="button" onclick="submit()">
    	</form>
  </body>
</html>
