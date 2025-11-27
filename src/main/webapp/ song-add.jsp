<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm Bài Hát</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <div class="card mx-auto" style="max-width: 600px;">
        <div class="card-header bg-success text-white">
            <h4>Thêm Bài Hát Mới</h4>
        </div>
        <div class="card-body">
            <form action="add-song" method="post">
                <div class="mb-3">
                    <label>Tên bài hát:</label>
                    <input type="text" name="title" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Ca sĩ:</label>
                    <input type="text" name="artist" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label>Link ảnh (URL):</label>
                    <input type="text" name="image" class="form-control">
                </div>
                <div class="mb-3">
                    <label>Link nhạc:</label>
                    <input type="text" name="link" class="form-control">
                </div>
                <div class="mb-3">
                    <label>Mô tả:</label>
                    <textarea name="desc" class="form-control"></textarea>
                </div>
                <button type="submit" class="btn btn-success w-100">Lưu Bài Hát</button>
                <a href="songs" class="btn btn-secondary w-100 mt-2">Quay lại</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>