<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <style>
        body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0; }
        .register-box { border: 1px solid #ccc; padding: 30px; width: 350px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        .form-group { margin-bottom: 15px; }
        input[type="text"], input[type="password"] { width: 100%; padding: 10px; box-sizing: border-box; }
        button { width: 100%; padding: 10px; background-color: #28a745; color: white; border: none; }
        .error { color: red; margin-bottom: 10px; font-size: 14px; }
    </style>
</head>
<body>

    <div class="register-box">
        <h2 style="text-align: center;">Đăng Ký Tài Khoản</h2>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="register" method="post">
            <div class="form-group">
                <label>Tên đăng nhập:</label>
                <input type="text" name="username" required>
            </div>
            <div class="form-group">
                <label>Mật khẩu:</label>
                <input type="password" name="password" required>
            </div>
            <div class="form-group">
                <label>Nhập lại mật khẩu:</label>
                <input type="password" name="confirm_password" required>
            </div>
            <button type="submit">Đăng ký</button>
        </form>
        
        <p style="text-align: center; margin-top: 15px;">
            Đã có tài khoản? <a href="login">Đăng nhập</a>
        </p>
    </div>

</body>
</html>