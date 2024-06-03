<!doctype html>
<html lang="vi">
<head>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
  <title>Trang Chủ Hóa Đơn Chi Tiết</title>
</head>
<body class="container mt-4">

<form method="post" action="/admin/hoaDonChiTiet/search" class="mb-4 form-inline">
  <label for="id" class="mr-2">Tìm Kiếm:</label>
  <input type="text" name="id" id="id" class="form-control mr-2"/>
  <input type="submit" value="Tìm" class="btn btn-primary">
</form>

<table class="table table-bordered table-hover">
  <thead class="thead-light">
  <tr>
    <th scope="col">STT</th>
    <th scope="col">ID</th>
    <th scope="col">Hóa Đơn</th>
    <th scope="col">Sản Phẩm Chi Tiết</th>
    <th scope="col">Số Lượng</th>
    <th scope="col">Đơn Giá</th>
    <th scope="col">Hành Động</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${listHDCT}" var="l" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${l.id}</td>
      <td>${l.hoaDon.id}</td>
      <td>${l.spChiTiet.maSPCT}</td>
      <td>${l.soLuong}</td>
      <td>${l.donGia}</td>
      <td>
        <a href="/admin/hoaDonChiTiet/chiTiet?id=${l.id}" class="btn btn-info btn-sm">Chi Tiết</a>
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
