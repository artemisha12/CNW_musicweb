<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết bài hát</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .container { max-width: 600px; border: 1px solid #ccc; padding: 20px; margin: 0 auto; }
        .img-preview { width: 100%; max-height: 300px; object-fit: cover; margin-bottom: 15px; }
        .label { font-weight: bold; }
        .btn { text-decoration: none; padding: 8px 15px; background-color: #eee; border: 1px solid #ccc; color: black; }
    </style>
</head>
<body>

    <div class="container">
        <h2>${song.title}</h2>
        
        <img src="${song.thumbnail}" class="img-preview" alt="Thumbnail">
        
        <p><span class="label">Nghệ sĩ:</span> ${song.artistNames}</p>
        <p><span class="label">Thể loại:</span> ${song.genre}</p>
        <p><span class="label">Năm phát hành:</span> ${song.year}</p>
        <p><span class="label">Mô tả:</span><br> ${song.description}</p>
        
        <p>
            <span class="label">Link:</span> 
            <a href="${song.link}" target="_blank">Nghe trên Youtube</a>
        </p>

        <hr>
        <a href="songs" class="btn">Quay lại danh sách</a>
        
        <c:if test="${not empty sessionScope.account}">
            <a href="edit-song?id=${song.songId}" class="btn">Sửa bài hát</a>
        </c:if>
    </div>

</body>
</html>