<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>
<%@ include file = "sub_img.html" %>
<%@ include file = "sub_menu.html" %>
<article>
    <form name = "formm" method = "post">
        <h2>My Page(${title })</h2>
                <table id = "cartList">
                    <tr>
                        <th>상품일자</th><th>주문번호</th><th>상품명</th><th>결제 금액</th><th>주문 상세</th>
                    </tr>
                    <c:forEach items = "${orderList }" var = "orderVO">
                        <tr>
                            <td><fmt:formatDate value="${orderVO.indate}" type="date"/></td>
                            <td>${orderVO.oseq }</td>
                            <td>${orderVO.pname }</td>
                            <td><fmt:formatNumber value="${orderVO.price2 }" type="currency"/></td>
                            <td><a href="NonageServlet?command=order_detail&oseq=${orderVO.oseq }">
                            <h3 style = "color: red; text-align:center;">조회</h3>
                            </a></td>
                        </tr>
                    </c:forEach>
                </table>
        <div class = "clear"></div>
        <div id = "button" style = "float:right">
            <input type = "button" value="쇼핑 계속하기" class = "cancel" onclick = "location.href = 'NonageServlet?command=index'">
        </div>
    </form>
</article>
<%@ include file = "../footer.jsp"%>