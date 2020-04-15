<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kakao IX</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <!-- font -->
    <link href="https://fonts.googleapis.com/css?family=Jua" rel="stylesheet">
    <link href="/res/application.css" rel="stylesheet">
</head>
<body>
<div class="container div-margin-bottom">
    <!-- 메뉴바 -->
    <nav class="navbar sticky-top navbar-expand-lg navbar-light">
        <form action="http://localhost:8080/book/all" method="post" class="form-inline">
            <div id="margin" class="form-group">
                <a class="navbar-brand mb-0 h1 logo-color logo-font-size" href="http://localhost:8080/book/default">KAKAO IX</a>
                <select name="select" class="form-control">
                    <option value="title"}>제목</option>
                    <option value="authors">저자</option>
                    <option value="isbn">isbn</option>
                </select>
                <input type="text" size=20 class="form-control" name="search"  placeholder="검색" >
                <button type="submit" class="navbar-brand mb-0 h1 logo-color logo-font-size">Q</button>
                <a href="http://localhost:8080/cart/list">
                    <div class="margin-tag">
                        장바구니
                    </div>
                </a>
            </div>

        </form>

    </nav>
    <!-- ./ 메뉴바 -->
    <hr/>

    <!-- 전체 상품 목록 -->
    <div class="row text-center">
        <c:forEach var="book" items="${ BookList}">
            <div class="col-sm">
                <div class="card custom-card">
                    <a href="http://localhost:8080/book/detail?isbn=${book.isbn}" class="product-font-color">
                        <img src="${book.url}" alt="KAKAO" class="card-img-top">
                    </a>
                </div>
                <div class="card-body">
                    <h5 class="card-title">${book.title}</h5>
                    <p>${book.authors}</p>
                    <p>${book.price}원</p>
                </div>
            </div>
        </c:forEach>
    </div>
    <!-- ./ 전체 상품 목록 -->

    <hr/>
    <div>
        <div class="text-center">
            <h4>used Spring Boot & JSP</h4>
            <h4>contact : wjdrbs966@naver.com</h4>
            <h3>&copy; 2020 Wjdrbs-Dev & KAKAO IX. All Rights Reserved.</h3>
        </div>
    </div>
</div>
</body>
</html>