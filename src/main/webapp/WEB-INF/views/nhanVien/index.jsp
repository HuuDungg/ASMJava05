<html>
<head>
  <title>Danh sách nhân viên</title>
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
  <form:form method="post" action="/nhanVien/them" modelAttribute="nhanVien">
    <label for="ten">Tên:</label>
    <form:input type="text" path="ten" id="ten" class="form-control"/> <form:errors path="ten"/> <br>
    <label for="maNV">Mã NV:</label>
    <form:input type="text" path="maNV" id="maNV" class="form-control"/> <form:errors path="maNV"/> <br>
    <label for="tenDangNhap">Tên đăng nhập:</label>
    <form:input type="text" path="tenDangNhap" id="tenDangNhap" class="form-control"/> <form:errors path="tenDangNhap"/> <br>
    <label for="matKhau">Mật khẩu:</label>
    <form:input type="password" path="matKhau" id="matKhau" class="form-control"/> <form:errors path="matKhau"/> <br>
    <label>Trạng thái:</label>
    <form:radiobutton path="trangThai" value="true" label="hoạt động"/>
    <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động"/>
    <br>
    <input type="submit" value="Submit" class="btn btn-primary">
  </form:form>

  <br>
  <form action="/nhanVien/search" method="post" class="mb-3">
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
      <th>Mã NV</th>
      <th>Tên đăng nhập</th>
      <th>Trạng thái</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNV.content}" var="nv" varStatus="status">
      <tr>
        <td>${status.index+1}</td>
        <td>${nv.id}</td>
        <td>${nv.ten}</td>
        <td>${nv.maNV}</td>
        <td>${nv.tenDangNhap}</td>
        <td>${nv.trangThai ? "hoạt động": "ngưng hoạt động"}</td>
        <td>
          <a href="/nhanVien/xoa?id=${nv.id}" class="btn btn-danger">Xóa</a>
          <a href="/nhanVien/chiTiet?id=${nv.id}" class="btn btn-info">Chi Tiết</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a class="btn btn-dark" href="/nhanVien/list">First</a>
  <a class="btn btn-dark" href="/nhanVien/list?page=${listNV.first? 0 : listNV.number -1}">Privious</a>
  <a class="btn btn-dark" href="/nhanVien/list?page=${listNV.last? listNV.totalPages -1 : listNV.number + 1}">Next</a>
  <a class="btn btn-dark" href="/nhanVien/list?page=${listNV.totalPages -1}">Last</a>
</div>

<!-- Bootstrap JS and any other custom scripts can be included at the end of the body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
