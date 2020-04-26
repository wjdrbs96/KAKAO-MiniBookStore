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
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="navbar-brand mb-0 h1 logo-color logo-font-size" href="http://localhost:8080/book/default">KAKAO IX</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/cart/list">login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/cart/list">logout</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/best/book">베스트셀러</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://localhost:8080/cart/list">장바구니</a>
                </li>
            </ul>
        </div>

    </nav>
    <!-- ./ 메뉴바 -->
    <form action="http://localhost:8080/rest/book/all" method="GET" class="form-inline">
        <div id="margin" class="form-group">
            <select name="searchType" class="form-control">
                <option value="title"}>제목</option>
                <option value="authors">저자</option>
                <option value="isbn">isbn</option>
            </select>
            <input type="text" size=20 class="form-control" name="searchKeyword"  placeholder="검색" >
            <button type="submit" class="navbar-brand mb-0 h1 logo-color logo-font-size">Q</button>
        </div>

    </form>

</div>
</body>
</html>