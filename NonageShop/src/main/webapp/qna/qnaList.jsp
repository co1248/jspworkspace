<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>
<%@ include file = "sub_img.html" %>
<%@ include file = "sub_menu.html" %>
<article>
    <form name = "formm" method = "post">
        <h2> 1:1 고객 게시판 </h2>
        <h3> 고객님의 질문에 대하여 운영자가 1:1 답변을 드립니다.</h3>
                <table id = "cartList">
                    <tr>
                        <th>번호</th><th>제목</th><th>등록일</th><th>답변여부</th>
                    </tr>
                    <c:forEach items = "${qnaList }" var = "qn        aVO">
                        <tr>
                            <td>${qnaVO.qseq }</td>
                            <td><a href = "NonageServlet?command=qna_view&qsep=${qnaVO.qseq }">${qnaVO.subject }</a></td>
                            <td><fmt:formatDate value="${qnaVO.indate}" type="date"/></td>
                            <td>
								<c:choose>
                                    <c:when test = "${qnaVO.rep == 1}">no</c:when>
                                    <c:otherwise>yes</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        <div class = "clear"></div>
        <div id = "buttons" style = "float:right">
			<input type = "button" value="1:1 질문하기" class = "submit" onclick = "location.href = 'NonageServlet?command=qna_write_form'">
            <input type = "button" value="쇼핑 계속하기" class = "cancel" onclick = "location.href = 'NonageServlet?command=index'">
        </div>
    </form>
</article>
<%@ include file = "../footer.jsp"%>