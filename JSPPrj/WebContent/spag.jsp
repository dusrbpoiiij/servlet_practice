<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("result", "hello");
%>
<body>
	<%=request.getAttribute("result") %>입니다.
	${requestScope.result}입니다.
	<br> 
	${names[1]} <!-- 배열 값 뽑기 -->
	${notice.title}  <!-- Map 값 뽑기 -->
	${result}
	<br>
	${not empty param.n ?  param.n : "값이 비어 있습니다."}<br>  <!-- 파라미터 출력  -->
	${param.n/2}<br>
	${header.Host}<br>  <!-- header 출력 -->
	${pageContext.request.method}
</body>
</html>