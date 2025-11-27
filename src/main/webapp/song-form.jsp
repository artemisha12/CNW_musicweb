<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${isEdit ? 'Sửa bài hát' : 'Thêm bài hát'}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; }
        .form-container { max-width: 500px; margin: 0 auto; border: 1px solid #ccc; padding: 20px; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="text"], input[type="number"], textarea { width: 100%; padding: 8px; box-sizing: border-box; }
        button { padding: 10px 20px; background-color: #4CAF50; color: white; border: none; cursor: pointer; }
        button:hover { background-color: #45a049; }
        .cancel { text-decoration: none; margin-left: 10px; color: red; }
    </style>
</head>
<body>

    <div class="form-container">
        <h2>${isEdit ? 'Chỉnh Sửa Bài Hát' : 'Thêm Bài Hát Mới'}</h2>

        <form action="${isEdit ? 'edit-song' : 'add-song'}" method="post">
            
            <!-- Nếu là sửa thì cần gửi kèm ID -->
            <c:if test="${isEdit}">
                <input type="hidden" name="id" value="${song.songId}">
            </c:if>

            <div class="form-group">
                <label>Tên bài hát:</label>
                <input type="text" name="title" value="${song.title}" required>
            </div>

            <div class="form-group">
                <label>Thể loại:</label>
                <input type="text" name="genre" value="${song.genre}">
            </div>

            <div class="form-group">
                <label>Năm phát hành:</label>
                <input type="number" name="year" value="${song.year != 0 ? song.year : 2025}">
            </div>

            <div class="form-group">
                <label>Link Youtube:</label>
                <input type="text" name="link" value="${song.link}">
            </div>
            
            <div class="form-group">
                <label>Mô tả:</label>
                <textarea name="description" rows="4">${song.description}</textarea>
            </div>

            <!-- Demo nhập nghệ sĩ (thực tế sẽ là checkbox) -->
            <div class="form-group">
                <label>Tên nghệ sĩ (Nhập tay):</label>
                <input type="text" name="artist" value="${song.artistNames}" placeholder="Ví dụ: Sơn Tùng M-TP">
            </div>

            <button type="submit">Lưu lại</button>
            <a href="songs" class="cancel">Hủy bỏ</a>
        </form>
    </div>

</body>
</html>