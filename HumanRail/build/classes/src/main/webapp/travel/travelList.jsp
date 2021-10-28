<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<%@ page import="com.rail.*" %>
<%
	int nowpage=((Integer)request.getAttribute("page")).intValue();
	int maxpage=((Integer)request.getAttribute("maxpage")).intValue();
	int startpage=((Integer)request.getAttribute("startpage")).intValue();
	int endpage=((Integer)request.getAttribute("endpage")).intValue();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HumanRail</title>
	<link rel="stylesheet" type="text/css" href="./css/all.css">
	<link rel="stylesheet" type="text/css" href="./css/travel.css" >
	<script>
		function goPage(pageNum) {
			document.getElementById("page").value = pageNum;
			travelform.submit();
		};
	</script>
</head>
<body>
	<jsp:include page="../Menu/header.jsp"></jsp:include>
	<div id="content">
	<form name = "travelform" id = "travelform" method = "post" action = "RailServlet?command=travellist">
	<input type="hidden" name="page" id="page">
		<div id= "traveltitle"><p><img src="./Image/travel/travel.png" class = "traveltitle" />&nbsp;&nbsp;여행지</p>| 기차 여행하기 좋은 여행지를 추천합니다. |</div><br>
		<table id = "traveltable">
			<c:choose>
				<c:when test = "${listcount == 0}">
					<td>
						<p style = "text-size : 15px">등록된 글이 없습니다.</p>
					</td>
				 </c:when>
				<c:otherwise>
					<tr>
						<td colspan = "2">
							<p>전체 ${listcount}개의 게시물이 있습니다.</p>
						</td>
						<!-- SEARCH START-->
						<td colspan = "3"  align = "right" valign = "middle">
						<select name="searchCondition">
						    <c:if test = "${searchCondition == 'CONTENT'}">
								<option value="TITLE">제목</option>
								<option value="CONTENT" selected>내용</option>
							</c:if>
							<c:if test = "${searchCondition == 'TITLE'}">
								<option value="TITLE" selected>제목</option>
								<option value="CONTENT">내용</option>
							</c:if>
						</select>&nbsp;<input name="searchKeyword" type="text" value = "${searchKeyword}">
						<input type="submit" value="검색 "><br></td>
						<!-- SEARCH END-->
					</tr>
					<tr>
					    <td colspan = "5">&nbsp;</td>
				    </tr>
					<tr>
						<th width = "8%" height = "26"><div align = "center">번호</div></th>
						<th width = "50%" height = "26"><div align = "center">제목</div></th>
						<th width = "14%" height = "26"><div align = "center">작성자</div></th>
						<th width = "17%" height = "26"><div align = "center">날짜</div></th>
						<th width = "11%" height = "26"><div align = "center">조회수</div></th>
					</tr>
					<tr bgcolor = "AAAAAA">
						<td colspan="5" style = "height : 1px">
						</td>
					</tr>
					<c:forEach var="travel" items="${travelList }">
						<tr>
							<td width = "8%" height = "26" align = "center">${travel.seq } </td>
							<td width = "50%" height = "26">
								<a href = "RailServlet?command=traveldetail&seq=${travel.seq }">${travel.title }</a>
							</td>
							<td width = "14%" height = "26" align = "center">${travel.writer } </td>
							<td width = "17%" height = "26" align = "center"><fmt:formatDate value = "${travel.write_date}"/></td>
							<td width = "11%" height = "26" align = "center">${travel.cnt } </td>
						</tr>
						<tr>
						<tr>
						    <td colspan="5" align="center"><hr></td>
						</tr>
					</c:forEach>
					<tr height="70">
						<!-- PAGING START -->
						<td colspan="5" align="center">
							<%if(nowpage<=1){%>
								[PREV]&nbsp;
							<%}else{ %>
								<a href="#" onclick = "javascript:goPage('${page-1}');">[PREV]</a>&nbsp;
							<%} %>
							<%for(int a=startpage;a<=endpage;a++){
								if(a==nowpage){%>
									[<%=a %>]&nbsp;
								<%}else{%>
									<a href="#" onclick = "javascript:goPage('<%=a%>');">[<%=a%>]</a>&nbsp;
								<%}%>
							<%}%>
							<%if(nowpage>=maxpage){%>
								[NEXT]
							<%}else{ %>
								<a href="#" onclick = "javascript:goPage('${page+1}');">[NEXT]</a>
							<%}%>
						</td>
						<!-- PAGING END -->
					</tr>
				</c:otherwise>
			</c:choose>
			<c:if test="${loginUser.adminnum == 1}">
			    <tr>
					<td colspan = "5">&nbsp;</td>
				</tr>
				<tr>
					<td colspan = "5"  align = "right" valign = "middle" >
						<input type="button" value="글쓰기" onclick="location.href='RailServlet?command=travelinsertform';" class = "button">
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan = "5">&nbsp;</td>
			</tr>
			<tr>
				<td colspan = "5">&nbsp;</td>
			</tr>
		</table>
	</form>
	</div>
	<jsp:include page="../Menu/footer.jsp"></jsp:include>
</body>
</html>