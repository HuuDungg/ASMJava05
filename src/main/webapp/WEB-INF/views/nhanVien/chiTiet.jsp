<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Chi tiết Nhân Viên</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optionally, you can also include your custom CSS file if needed -->
    <link href="path/to/your/custom.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <form:form method="post" action="/nhanVien/update" modelAttribute="nhanVien">
        <form:input type="text" path="id" id="id" class="form-control"/> <form:errors path="id"/> <br>
        <br>
        <label for="ten">Tên:</label>
        <form:input type="text" path="ten" id="ten" class="form-control"/> <form:errors path="ten"/> <br>
        <label for="maNV">Mã NV:</label>
        <form:input type="text" path="maNV" id="maNV" class="form-control"/> <form:errors path="maNV"/> <br>
        <label for="tenDangNhap">Tên đăng nhập:</label>
        <form:input type="text" path="tenDangNhap" id="tenDangNhap" class="form-control"/> <form:errors path="tenDangNhap"/> <br>
        <label for="matKhau">Mật khẩu:</label>
        <form:input type="password" path="matKhau" id="matKhau" class="form-control"/> <form:errors path="matKhau"/> <br>
        <label>Trạng thái:</label>
        <c:choose>
            <c:when test="${nhanVien.trangThai}">
                <form:radiobutton path="trangThai" value="true" label="hoạt động" checked="checked"/>
                <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động" />
            </c:when>
            <c:otherwise>
                <form:radiobutton path="trangThai" value="true" label="hoạt động"/>
                <form:radiobutton path="trangThai" value="false" label="ngưng hoạt động" checked="checked"/>
            </c:otherwise>
        </c:choose>
        <br>
        <input type="submit" value="Submit" class="btn btn-primary">
    </form:form>
</div>

<!-- Bootstrap JS and any other custom scripts can be included at the end of the body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
