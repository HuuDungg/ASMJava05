<html>
<head>
  <title>Danh sách khách hàng</title>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Optionally, you can also include your custom CSS file if needed -->
  <link href="path/to/your/custom.css" rel="stylesheet">
</head>
<body>

<div class="container">
  <form:form method="post" action="/khachHang/them" modelAttribute="khachHang">
    <label for="ten">Tên:</label>
    <form:input type="text" path="ten" id="ten" class="form-control"/> <form:errors path="ten"/> <br>
    <label for="sdt">Số điện thoại:</label>
    <form:input type="text" path="sdt" id="sdt" class="form-control"/> <form:errors path="sdt"/> <br>
    <label for="maKH">Mã KH:</label>
    <form:input type="text" path="maKH" id="maKH" class="form-control"/> <form:errors path="maKH"/> <br>
    <label>Trạng thái:</label>
    <form:radiobutton path="trangThai" value="true" label="hoạt động"/>
    <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động"/>
    <br>
    <input type="submit" value="Submit" class="btn btn-primary">
  </form:form>

  <br>
  <form action="/khachHang/search" method="post" class="mb-3">
    <label for="id">Tìm kiếm:</label>
    <input type="number" name="id" id="id" class="form-control"/>
    <input type="submit" value="Tìm kiếm" class="btn btn-primary">
  </form>

  <table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
      <th>STT</th>
      <th>ID</th>
      <th>Tên</th>
      <th>Số điện thoại</th>
      <th>Mã KH</th>
      <th>Trạng thái</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listKH.content}" var="kh" varStatus="status">
      <tr>
        <td>${status.index+1}</td>
        <td>${kh.id}</td>
        <td>${kh.ten}</td>
        <td>${kh.sdt}</td>
        <td>${kh.maKH}</td>
        <td>${kh.trangThai ? "hoạt động": "ngưng hoạt động"}</td>
        <td>
          <a href="/khachHang/xoa?id=${kh.id}" class="btn btn-danger">Xóa</a>
          <a href="/khachHang/chiTiet?id=${kh.id}" class="btn btn-info">Chi Tiết</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a class="btn btn-dark" href="/khachHang/list">First</a>
  <a class="btn btn-dark" href="/khachHang/list?page=${listKH.first? 0 : listKH.number -1}">Privious</a>
  <a class="btn btn-dark" href="/khachHang/list?page=${listKH.last? listKH.totalPages -1 : listKH.number + 1}">Next</a>
  <a class="btn btn-dark" href="/khachHang/list?page=${listKH.totalPages -1}">Last</a>
</div>

<!-- Bootstrap JS and any other custom scripts can be included at the end of the body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
