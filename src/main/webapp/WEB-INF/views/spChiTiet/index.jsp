<!doctype html>
<html lang="vi">
<head>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <title>Trang Chủ SPCT</title>
  <!-- Bootstrap CSS -->
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">

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
    <label>Trạng Thái:</label> <br>
    <form:radiobutton path="trangThai" value="true"  class="form-check-input"/>
    <label for="trangThaiHoatDong" class="form-check-label">Hoạt Động</label> <br>
    <form:radiobutton path="trangThai" value="false"  class="form-check-input"/>
    <label for="trangThaiNgungHoatDong" class="form-check-label">Ngừng Hoạt Động</label>
    <form:errors path="trangThai" cssClass="text-danger"/>
  </div>
  <button type="submit" class="btn btn-primary">Gửi</button>
</form:form>

<form method="post" action="/spChiTiet/search" class="mb-4 form-inline">
  <label for="maSPCT" class="mr-2">Tìm Kiếm:</label>
  <input type="text" name="maSPCT" id="maSPCT" class="form-control mr-2"/>
  <input type="submit" value="Tìm" class="btn btn-primary">
</form>

<table class="table table-bordered table-hover">
  <thead class="thead-light">
  <tr>
    <th scope="col">STT</th>
    <th scope="col">ID</th>
    <th scope="col">Mã SPCT</th>
    <th scope="col">Kích Thước</th>
    <th scope="col">Màu Sắc</th>
    <th scope="col">Sản Phẩm</th>
    <th scope="col">Số Lượng</th>
    <th scope="col">Đơn Giá</th>
    <th scope="col">Trạng Thái</th>
    <th scope="col">Hành Động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listSPCT}" var="l" varStatus="haha">
    <tr>
      <td>${haha.index+1}</td>
      <td>${l.id}</td>
      <td>${l.maSPCT}</td>
      <td>${l.kichThuoc.ten}</td>
      <td>${l.mauSac.ten}</td>
      <td>${l.sanPham.ten}</td>
      <td>${l.soLuong}</td>
      <td>${l.donGia}</td>
      <td>${l.trangThai ? "Hoạt Động" : "Ngừng Hoạt Động"}</td>
      <td>
        <a href="/spChiTiet/xoa?id=${l.id}" class="btn btn-danger btn-sm">Xóa</a>
        <a href="/spChiTiet/chiTiet?id=${l.id}" class="btn btn-info btn-sm">Chi Tiết</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
