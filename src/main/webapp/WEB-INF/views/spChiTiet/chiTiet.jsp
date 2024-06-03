<!doctype html>
<html lang="en">
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
    <title>Document</title>
</head>
<body>
<div class="container">
    <form:form modelAttribute="spChiTiet" action="/spChiTiet/them" method="post" class="mb-4">
        <div class="form-group">
            <label for="id">ID:</label>
            <form:input path="id" id="id" class="form-control"/>
            <form:errors path="id" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="maSPCT">Mã SPCT:</label>
            <form:input path="maSPCT" id="maSPCT" class="form-control"/>
            <form:errors path="maSPCT" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="sanPham">Sản Phẩm:</label>
            <form:select path="sanPham.id" id="sanPham" class="form-control">
                <form:options items="${sanPhamList}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <form:errors path="sanPham.id" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="mauSac">Màu Sắc:</label>
            <form:select path="mauSac.id" id="mauSac" class="form-control">
                <form:options items="${mauSacList}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <form:errors path="mauSac.id" cssClass="text-danger"/>
        </div>
        <div class="form-group">
            <label for="kichThuoc">Kích Thước:</label>
            <form:select path="kichThuoc.id" id="kichThuoc" class="form-control">
                <form:options items="${kichThuocList}" itemLabel="ten" itemValue="id"/>
            </form:select>
            <form:errors path="kichThuoc.id" cssClass="text-danger"/>
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
        <div class="form-group">
            <c:choose>
                <c:when test="${spChiTiet.trangThai}">
                    <form:radiobutton path="trangThai" value="true" label="hoạt động" checked="checked"/>
                    <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động" />
                </c:when>
                <c:otherwise>
                    <form:radiobutton path="trangThai" value="true" label="hoạt động"/>
                    <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động" checked="checked"/>
                </c:otherwise>
            </c:choose>
        </div>
        <button type="submit" class="btn btn-primary">Gửi</button>
    </form:form>
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
