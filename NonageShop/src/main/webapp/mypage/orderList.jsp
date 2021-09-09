<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>
<%@ include file = "sub_img.html" %>
<%@ include file = "sub_menu.html" %>
<article>
    <form name = "formm" method = "post">
        <h2>Order List</h2>
        <c:choose>
            <c:when test = "{orderList.size() == 0 }">
                <h3 style = "color: red; text-align:center;">주문내역이 없습니다.</h3>
            </c:when>
            <c:otherwise>
                <table id = "cartList">
                    <tr>
                        <th>상품명</th><th>수량</th><th>가격</th><th>주문일</th><th>진행상태</th>
                    </tr>
                    <c:forEach items = "${orderList }" var = "orderVO">
                        <tr>
                            <td><a href="NonageServlet?command=product_detail&pseq=${orderVO.pseq}">
                            <h3>${orderVO.pname }</h3></a></td>
                            <td>${orderVO.quantity }</td>
                            <td><fmt:formatNumber value="${orderVO.price2*orderVO.quantity}" type="currency"/></td>
                            <td><fmt:formatDate value="${orderVO.indate}" type="date"/></td>
                            <td>
                                <c:if test = "${orderVO.result == '1'}">처리 진행 중</c:if>
                                <c:if test = "${orderVO.result == '2'}">배송 중</c:if>
                            </td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th colspan = "2">총액</th>
                        <th colspan = "2"><fmt:formatNumber value="${totalPrice}" type="currency"/></th>
                        <th><<h3>주문 처리가 완료되었습니다.</h3></th>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
        <div class = "clear"></div>
        <div id = "button" style = "float:right">
            <input type = "button" value="쇼핑 계속하기" class = "cancel" onclick = "location.href = 'NonageServlet?command=index'">
        </div>
    </form>
</article>
<%@ include file = "../footer.jsp"%>