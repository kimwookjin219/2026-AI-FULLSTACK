<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>THE JOA 703</title>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
    <link href="./css/board.css" rel="stylesheet">
</head>
<body>
    <!-- header -->
    <header>
        <h1 class="myhidden">board</h1>
        <nav class="navbar navbar-expand-sm navbar-dark" style="background-color: skyblue;">
            <h2 class="myhidden">주메뉴</h2>
            <div class="container-fluid">
                <a class="navbar-brand" href="list.jsp">R</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mynavbar">
                <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                        <a class="nav-link" href="login.jsp">Login</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="join.jsp">Join</a>
                        </li>
                        <li class="nav-item">
                        <a class="nav-link" href="mypage.jsp">Mypage</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>