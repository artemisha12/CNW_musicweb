<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .login-box { border: 1px solid #ccc; padding: 30px; width: 300px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        input[type="text"], input[type="password"] { width: 100%; padding: 10px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #007BFF; color: white; border: none; }
        .error { color: red; margin-bottom: 10px; font-size: 14px; }
        .success { color: green; margin-bottom: 10px; font-size: 14px; }
    </style>
</head>
<body>

    <div class="login-box">
        <h2 style="text-align: center;">Đăng Nhập</h2>
        
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty mess}">
            <div class="success">${mess}</div>
        </c:if>

        <form action="login" method="post">
            <div class="form-group">
                <label>Tài khoản:</label>
                <input type="text" name="username" value="${username}" required>
            </div>
            <div class="form-group">
                <label>Mật khẩu:</label>
                <input type="password" name="password" required>
            </div>
            <button type="submit">Đăng nhập</button>
        </form>
        
        <p style="text-align: center; margin-top: 15px;">
            Chưa có tài khoản? <a href="register">Đăng ký</a> <br>
            <a href="songs">Về trang chủ</a>
        </p>
    </div>

</body>
</html>