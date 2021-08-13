<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nonage Shop</title>
<link rel = "stylesheet" type = "text/css" href = "css/shopping.css">
</head>
<body>
    <div id="wrap">
        <header>
            <div id = "logo">
                <a href = "NonageServlet?command=index">
                    <img src = "images/logo.gif" width = "180" height = "100" alt = "nonageshop">
                </a>
            </div>
            <nav id = "category_menu">
                <ul>
                <c:choose>
                    <c:when test = "${empty sessionScope.loginUser.id }">
						<!-- 로그인 전 start -->
						<li>
							<a href = "NonageServlet?command=login_form" style = "width : 110px;">LOGIN(CUSTOMER</a>
							<a href = "NonageServlet?command=admin_login_form" style = "width : 110px;">| ADMIN)</a>
						</li>
						<li> / </li>
						<li><a href = "NonageServlet?command=contract">JOIN</a></li>
						<!-- 로그인 전 end -->
                    </c:when>
                    <c:otherwise>
						<!-- 로그인 후 start -->
						<li style = "color:orange">
							${sessionScope.loginUser.name }(${sessionScope.loginUser.id })
						</li>
						<li><a href = "NonageServlet?command=logout" >LOGOUT</a></li>
						<!-- 로그인 후 end -->
                    </c:otherwise>
                </c:choose>
                    <li> / </li>
                    <li><a href = "NonageServlet?command=cart_list">CART</a></li>
                    <li> / </li>
                    <li><a href = "NonageServlet?command=mypage">MY PAGE</a></li>
                    <li> / </li>
                    <li><a href = "NonageServlet?command=qna_list">Q&amp;A(1:1)</a></li>
                </ul>
            </nav>
            <nav id = "top_menu">
                <ul>
                    <li><a href = "NonageServlet?command=category&kind=1">Heels</a></li>
                    <li><a href = "NonageServlet?command=category&kind=2">Boots</a></li>
                    <li><a href = "NonageServlet?command=category&kind=3">Sandals</a></li>
                    <li><a href = "NonageServlet?command=category&kind=4">Sneakers</a></li>
                    <li><a href = "NonageServlet?command=category&kind=5">On Sale</a></li>
                </ul>
            </nav>
            <div class = "clear"></div>
            <hr>
        </header>