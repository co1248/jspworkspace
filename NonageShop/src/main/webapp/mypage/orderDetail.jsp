<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../header.jsp"%>
<%@ include file = "sub_img.html" %>
<%@ include file = "sub_menu.html" %>
<article>
    <form name = "formm" method = "post">
        <h2>My Page(${title })</h2>
                <h3>주문자 정보</h3>
                <table id = "cartList">
                    <tr>
                        <th>주문일자</th><th>주문번호</th><th>주문자</th><th>주문 총액</th>
                    </tr>
                    <tr>
                        <td><fmt:formatDate value="${orderDetail.indate}" type="date"/></td>
                        <td>${orderDetail.oseq}</td>
                        <td>${orderDetail.mname}</td>
                        <td>${totalPrice}</td>
                    </tr>
                 </table>
                 <h3>주문 상세 정보</h3>
                 <table id = "cartList">   
                    <tr>
                        <th>상품명</th><th>상품별주문번호</th><th>수량</th><th>가격</th><th>처리 상태</th>
                    </tr>
                    <c:forEach items = "${orderList }" var = "orderVO">
                        <tr>
                            <td>${orderVO.pname }</td>
                            <td>${orderVO.odseq }</td>
                            <td>${orderVO.quantity }</td>
                            <td><fmt:formatNumber value="${orderVO.price2*orderVO.quantity}" type="currency"/></td>
                            <td>
                                <c:if test = "${orderVO.result == '1'}">진행중</c:if>
                                <c:if test = "${orderVO.result == '2'}">배송중</c:if>
                            </td>
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