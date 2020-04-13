<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kakao IX - 로그인</title>
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
<div class="container text-center login-margin-top">
    <h1 style="color: #ffc107;">KAKAO IX</h1>
    <hr/>
    <form:form method="post">
        <div class="form-group">
            <label>아이디</label>
            <input width="50px" class="form-control margin-auto login-input-width" type="text" name="loginId"
                   placeholder="아이디를 입력하세요."/>
        </div>
        <div class="form-group">
            <label>비밀번호</label>
            <input class="form-control margin-auto login-input-width" type="password" name="password"
                   placeholder="비밀번호를 입력하세요."/>
        </div>

        <div>
            <button type="submit" class="btn btn-warning">로그인</button>
        </div>
        <div class="div-margin-top">
            <a href="/register" class="logo-color">회원가입</a>
        </div>
    </form:form>

    <hr/>

    <%-- query string에 error가 포함되어 있으면 (예: guest/login?error) 로그인 실패를 출력 --%>
    <c:if test="${ param.error != null }">
        <div>로그인 실패</div>
    </c:if>
</div>
</body>
</html>