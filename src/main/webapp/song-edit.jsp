<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa Bài Hát</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="card-header bg-warning text-dark">
            <h4>Chỉnh Sửa Bài Hát</h4>
        </div>
        <div class="card-body">
            <form action="edit-song" method="post">
                <!-- ID bị ẩn đi để gửi về Server biết sửa bài nào -->
                <input type="hidden" name="id" value="${st.id}">

                <div class="mb-3">
                    <label>Tên bài hát:</label>
                    <input type="text" name="title" class="form-control" value="${st.title}" required>
                </div>
                <div class="mb-3">
                    <label>Ca sĩ:</label>
                    <input type="text" name="artist" class="form-control" value="${st.artist}" required>
                </div>
                <div class="mb-3">
                    <label>Link ảnh:</label>
                    <input type="text" name="image" class="form-control" value="${st.image}">
                </div>
                <div class="mb-3">
                    <label>Link nhạc:</label>
                    <input type="text" name="link" class="form-control" value="${st.link}">
                </div>
                <div class="mb-3">
                    <label>Mô tả:</label>
                    <textarea name="desc" class="form-control">${st.description}</textarea>
                </div>
                <button type="submit" class="btn btn-warning w-100">Cập Nhật</button>
                <a href="songs" class="btn btn-secondary w-100 mt-2">Quay lại</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>