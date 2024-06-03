<!doctype html>
<html lang="vi">
<head>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <title>Trang Chủ Hóa Đơn</title>
</head>
<body class="container mt-4">
<form method="post" action="/admin/hoaDon/search" class="mb-4 form-inline">
  <label for="id" class="mr-2">Tìm Kiếm:</label>
  <input type="text" name="id" id="id" class="form-control mr-2"/>
  <input type="submit" value="Tìm" class="btn btn-primary">
</form>

<table class="table table-bordered table-hover">
  <thead class="thead-light">
  <tr>
    <th scope="col">STT</th>
    <th scope="col">ID</th>
    <th scope="col">Nhân Viên</th>
    <th scope="col">Khách Hàng</th>
    <th scope="col">Ngày Mua Hàng</th>
    <th scope="col">Trạng Thái</th>
    <th scope="col">Hành Động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listHD.content}" var="l" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${l.id}</td>
      <td>${l.nhanVien.ten}</td>
      <td>${l.khachHang.ten}</td>
      <td>${l.ngayMuaHang}</td>
      <td>${l.trangThai ? "Đã thanh toán" : "Chưa thanh toán"}</td>
      <td>
        <a href="/admin/hoaDonChiTiet/list?id=${l.id}" class="btn btn-info btn-sm">Chi Tiết</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a class="btn btn-dark" href="/admin/hoaDon/list">First</a>
<a class="btn btn-dark" href="/admin/hoaDon/list?page=${listHD.first? 0 : listHD.number -1}">Privious</a>
<a class="btn btn-dark" href="/admin/hoaDon/list?page=${listHD.last? listHD.totalPages -1 : listHD.number + 1}">Next</a>
<a class="btn btn-dark" href="/admin/hoaDon/list?page=${listHD.totalPages -1}">Last</a>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
