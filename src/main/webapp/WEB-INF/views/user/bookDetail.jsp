<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kakao IX - 상품정보</title>
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
        <a class="navbar-brand mb-0 h1 logo-color logo-font-size" href="http://localhost:8080/book/default">KAKAO IX</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item dropdown active">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                       data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        My Menu
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/kakao/cart">장바구니</a>
                        <a class="dropdown-item" href="/kakao/orders">구매내역</a>
                    </div>
                </li>
            </ul>

            <!-- ./ 현재 로그인 사용자 표시 -->
        </div>
    </nav>
    <!-- ./ 메뉴바 -->
    <hr/>

    <!-- 개별 상품 -->
    <div>
        <h4>${ Book.title }</h4>
        <img src="${ Book.url }" class="product-detail-card text-center">
    </div>
    <hr/>
    <div class="row text-center">
        <div class="col"></div>
        <div class="col-6">
            <form:form action="http://localhost:8080/cart/add?isbn=${Book.isbn}" method="post">
                <h5>개당 ${ Book.price } 원</h5>
                <div class="form-group product-num-input-width">
                    <input class="form-control text-center" id="number" name="number"
                           placeholder="개수를 입력하세요.">
                </div>
                <button class="btn btn-success" type="submit">장바구니 추가</button>
            </form:form>
        </div>
        <div class="col"></div>
    </div>
    <!-- ./ 개별 상품 -->
</div>
</body>
</html>