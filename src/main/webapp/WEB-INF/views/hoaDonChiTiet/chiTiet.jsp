<!doctype html>
<html lang="vi">
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Chi Tiết Hóa Đơn Chi Tiết</title>
</head>
<body class="container mt-4">
<h2>Chi Tiết Hóa Đơn Chi Tiết</h2>
<form:form modelAttribute="hoaDonChiTiet" action="/admin/hoaDonChiTiet/update" method="post">
    <div class="form-group">
        <label for="id">ID:</label>
        <form:input path="id" id="id" class="form-control" readonly="readonly"/>
        <form:errors path="id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="hoaDon">Hóa Đơn:</label>
        <form:select path="hoaDon.id" id="hoaDon" class="form-control">
            <form:options items="${hoaDonList}" itemLabel="id" itemValue="id"/>
        </form:select>
        <form:errors path="hoaDon.id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="spChiTiet">Sản Phẩm Chi Tiết:</label>
        <form:select path="spChiTiet.id" id="spChiTiet" class="form-control">
            <form:options items="${spChiTietList}" itemLabel="maSPCT" itemValue="id"/>
        </form:select>
        <form:errors path="spChiTiet.id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="soLuong">Số Lượng:</label>
        <form:input path="soLuong" id="soLuong" class="form-control"/>
        <form:errors path="soLuong" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="donGia">Đơn Giá:</label>
        <form:input path="donGia" id="donGia" class="form-control"/>
        <form:errors path="donGia" cssClass="text-danger"/>
    </div>

    <button type="submit" class="btn btn-primary">Cập Nhật</button>
</form:form>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
