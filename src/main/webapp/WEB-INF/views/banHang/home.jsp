<head>
    <title>JSP - Hello World</title>
    <%@ page contentType="text/html; charset=UTF-8" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div class="container">
<h1>Trang chủ bán hàng</h1>
<div class="row">
    <div class="row col-md-7">
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
            <c:forEach items="${listHD}" var="l" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${l.id}</td>
                    <td>${l.nhanVien.ten}</td>
                    <td>${l.khachHang.ten}</td>
                    <td>${l.ngayMuaHang}</td>
                    <td>${l.trangThai ? "Đã thanh toán" : "Chưa thanh toán"}</td>
                    <td>
                        <a href="/banHang/chonHoaDon?id=${l.id}" class="btn btn-info btn-sm">Chọn</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row col-md-1">

    </div>

    <div class="row col-md-4">

        <form action="/banHang/taoHoaDon" method="post">
            <div class="form-group">
                <label for="idInput">ID:</label>
                <input type="text" class="form-control" id="idInput" placeholder="Enter ID" value="${hoaDonSelct.id}">
            </div>
            <div class="form-group">
                <label for="customerSelect">Khach Hang:</label>
                <select class="form-control" id="customerSelect" name="khachHang">
                    <c:forEach items="${listKH}" var="l">
                        <option <c:if test="${hoaDonSelct.khachHang.id == l.id}">selected</c:if>  value="${l.id}">${l.ten}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="form-group">
                <label for="amountInput">Thanh tien:</label>
                <input type="text" class="form-control" id="amountInput" placeholder="Enter amount" value="${totalPrice}">
            </div>
            <div>
                <input  class="btn btn-primary" type="submit" value="Tạo mới" />
                <a href="/banHang/thanhToan?id=${hoaDonSelct.id}" class="btn btn-success">Thanh Toán</a>
            </div>
        </form>


    </div>
</div>

<h1>Chi tiết hoá đơn</h1>
<div>
    <table class="table table-bordered table-hover">
        <thead class="thead-light">
        <tr>
            <th scope="col">STT</th>
            <th scope="col">ID</th>
            <th scope="col">Sản Phẩm Chi Tiết</th>
            <th scope="col">Số Lượng</th>
            <th scope="col">Đơn Giá</th>
            <th scope="col">Thành tiền</th>
            <th scope="col">Hành Động</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listHDCTByIDHD}" var="l" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${l.spChiTiet.id}</td>
                <td>${l.spChiTiet.maSPCT}</td>
                <td>${l.soLuong}</td>
                <td>${l.donGia}</td>
                <td>${l.donGia*l.soLuong}</td>
                <td>
                    <a href="/banHang/deleteSanPhamSelect?id=${l.id}&idHoaDon=${hoaDonSelct.id}&idSPCT=${l.spChiTiet.id}" class="btn btn-danger btn-sm">Xoá</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<h1>Danh sách chi tiết sản phẩm</h1>
<div>
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
                    <a href="/banHang/chonSanPham?id=${hoaDonSelct.id}&idSanPham=${l.id}" class="btn btn-info btn-sm">Chọn mua</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</div>
</body>
</html>