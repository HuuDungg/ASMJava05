<!doctype html>
<html lang="vi">
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Chi Tiết Hóa Đơn</title>
</head>
<body class="container mt-4">
<h2>Chi Tiết Hóa Đơn</h2>
<form:form modelAttribute="hoaDon" action="/hoaDon/update" method="post">
    <div class="form-group">
        <label for="id">ID:</label>
        <form:input path="id" id="id" class="form-control" readonly="readonly"/>
        <form:errors path="id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="nhanVien">Nhân Viên:</label>
        <form:select path="nhanVien.id" id="nhanVien" class="form-control">
            <form:options items="${nhanVienList}" itemLabel="ten" itemValue="id"/>
        </form:select>
        <form:errors path="nhanVien.id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="khachHang">Khách Hàng:</label>
        <form:select path="khachHang.id" id="khachHang" class="form-control">
            <form:options items="${khachHangList}" itemLabel="ten" itemValue="id"/>
        </form:select>
        <form:errors path="khachHang.id" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <label for="ngayMuaHang">Ngày Mua Hàng:</label>
        <form:input path="ngayMuaHang" id="ngayMuaHang" class="form-control"/>
        <form:errors path="ngayMuaHang" cssClass="text-danger"/>
    </div>
    <div class="form-group">
        <c:choose>
            <c:when test="${hoaDon.trangThai}">
                <form:radiobutton path="trangThai" value="true" label="Đã thanh " checked="checked"/>
                <form:radiobutton path="trangThai" value="false" label="Chưa thanh toán" />
            </c:when>
            <c:otherwise>
                <form:radiobutton path="trangThai" value="true" label="Đã thanh toán"/>
                <form:radiobutton path="trangThai" value="false" label="Chưa thanh toán" checked="checked"/>
            </c:otherwise>
        </c:choose>
    </div>
    <button type="submit" class="btn btn-primary">Cập Nhật</button>
</form:form>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
