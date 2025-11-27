<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách bài hát</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f2f2f2; }
        .btn { text-decoration: none; padding: 5px 10px; background-color: #ddd; color: black; border: 1px solid #999; }
        .btn-red { background-color: #ffcccc; }
        .nav-bar { margin-bottom: 20px; padding: 10px; background-color: #eee; }
        .search-box { margin-bottom: 15px; }
    </style>
</head>
<body>

    <!-- Menu điều hướng -->
    <div class="nav-bar">
        <a href="songs">Trang chủ</a> |
        
        <c:choose>
            <c:when test="${not empty sessionScope.account}">
                <span>Xin chào: <b>${sessionScope.account.username}</b></span> |
                <a href="add-song">Thêm bài hát</a> |
                <a href="logout" style="color: red;">Đăng xuất</a>
            </c:when>
            <c:otherwise>
                <a href="login">Đăng nhập</a> |
                <a href="register">Đăng ký</a>
            </c:otherwise>
        </c:choose>
    </div>

    <h1>Danh sách bài hát</h1>

    <!-- Tìm kiếm -->
    <div class="search-box">
        <form action="search" method="get">
            <input type="text" name="q" placeholder="Nhập tên bài hoặc nghệ sĩ..." value="${searchKeyword}">
            <button type="submit">Tìm kiếm</button>
        </form>
    </div>

    <!-- Bảng dữ liệu -->
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Hình ảnh</th>
                <th>Tên bài hát</th>
                <th>Thể loại</th>
                <th>Năm</th>
                <th>Nghệ sĩ</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listSongs}" var="s">
                <tr>
                    <td>${s.songId}</td>
                    <td><img src="${s.thumbnail}" width="50" height="50" style="object-fit: cover;"></td>
                    <td><b>${s.title}</b></td>
                    <td>${s.genre}</td>
                    <td>${s.year}</td>
                    <td>${s.artistNames}</td>
                    <td>
                        <a href="song-detail?id=${s.songId}" class="btn">Xem</a>
                        
                        <!-- Chỉ hiện nút Sửa/Xóa nếu đã đăng nhập -->
                        <c:if test="${not empty sessionScope.account}">
                            <a href="edit-song?id=${s.songId}" class="btn">Sửa</a>
                            <a href="delete-song?id=${s.songId}" class="btn btn-red" onclick="return confirm('Bạn có chắc muốn xóa?');">Xóa</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            
            <c:if test="${empty listSongs}">
                <tr>
                    <td colspan="7" style="text-align: center;">Không có dữ liệu.</td>
                </tr>
            </c:if>
        </tbody>
    </table>

</body>
</html>