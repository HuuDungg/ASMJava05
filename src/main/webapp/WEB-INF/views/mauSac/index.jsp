<html>
<head>
  <title>Danh sách màu sắc</title>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <!-- Optionally, you can also include your custom CSS file if needed -->
  <link href="path/to/your/custom.css" rel="stylesheet">
</head>
<body>content

<div class="container">
  <form:form method="post" action="/mauSac/them" modelAttribute="mauSac">
    <label for="ma">Mã:</label>
    <form:input type="text" path="ma" id="ma" class="form-control"/> <form:errors path="ma"/> <br>
    <label for="ten">Tên:</label>
    <form:input type="text" path="ten" id="ten" class="form-control"/> <form:errors path="ten"/> <br>
    <label>Trạng thái:</label>
    <form:radiobutton path="trangThai" value="true" label="hoạt động"/>
    <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động"/>
    <br>
    <input type="submit" value="Submit" class="btn btn-primary">
  </form:form>

  <br>
  <form action="/mauSac/search" method="post" class="mb-3">
    <label for="id">Tìm kiếm:</label>
    <input type="number" name="id" id="id" class="form-control"/>
    <input type="submit" value="Tìm kiếm" class="btn btn-primary">
  </form>

  <table class="table table-bordered">
    <thead class="thead-dark">
    <tr>
      <th>STT</th>
      <th>ID</th>
      <th>Mã</th>
      <th>Tên</th>
      <th>Trạng thái</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listMS.content}" var="ms" varStatus="status">
      <tr>
        <td>${status.index+1}</td>
        <td>${ms.id}</td>
        <td>${ms.ma}</td>
        <td>${ms.ten}</td>
        <td>${ms.trangThai ? "hoạt động": "ngưng hoạt động"}</td>
        <td>
          <a href="/mauSac/xoa?id=${ms.id}" class="btn btn-danger">Xóa</a>
          <a href="/mauSac/chiTiet?id=${ms.id}" class="btn btn-info">Chi Tiết</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <a class="btn btn-dark" href="/mauSac/list">First</a>
  <a class="btn btn-dark" href="/mauSac/list?page=${listMS.first? 0 : listMS.number -1}">Privious</a>
  <a class="btn btn-dark" href="/mauSac/list?page=${listMS.last? listMS.totalPages -1 : listMS.number + 1}">Next</a>
  <a class="btn btn-dark" href="/mauSac/list?page=${listMS.totalPages -1}">Last</a>
</div>

<!-- Bootstrap JS and any other custom scripts can be included at the end of the body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
