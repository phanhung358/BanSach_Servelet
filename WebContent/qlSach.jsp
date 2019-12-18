<%@page import="bean.sachbean"%>
<%@page import="bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
	if(request.getAttribute("ktnhap")!=null)
		out.print("<script>alert('Trùng mã!')</script>");
	if(request.getAttribute("ktsua")!=null)
		out.print("<script>alert('Lỗi: Không sửa được!')</script>");
	if(request.getAttribute("ktxoa")!=null)
		out.print("<script>alert('Lỗi: Không thể xóa!')</script>");
	sachbean ss= (sachbean) request.getAttribute("chon");
	
	%>
	<div class="offset-3 col-lg-6">
		<div class="container">
			<form action="SachAdminController" method="post" class="shadow p-3 my-3" enctype="multipart/form-data">
			  <div class="form-group">
			    <label for="email">Mã sách:</label>
			    <input type="text" class="form-control" name="txtms" value="<%=ss!=null?ss.getMasach():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Tên sách:</label>
			    <input type="text" class="form-control" name="txtts" value="<%=ss!=null?ss.getTensach():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Tác giả:</label>
			    <input type="text" class="form-control" name="txttg" value="<%=ss!=null?ss.getTacgia():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Giá:</label>
			    <input type="number" min="0" class="form-control" name="txtgia" value="<%=ss!=null?ss.getGia():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Số lượng:</label>
			    <input type="number" min="0" class="form-control" name="txtsl" value="<%=ss!=null?ss.getSoluong():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Ngày nhập:</label>
			    <input type="date" class="form-control" name="txtnn" value="<%=ss!=null?ss.getNgaynhap():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Ảnh:</label>
			    <input type="file" class="form-control" name="txta" value="<%=ss!=null?ss.getAnh():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Số tập:</label>
			    <input type="text" class="form-control" name="txtst" value="<%=ss!=null?ss.getSotap():""%>">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Mã loại:</label>
			    <select name="txtml">
			    <%
				ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
				for(loaibean l:dsloai){
				%>
				  <option value="<%=l.getMaloai()%>" <%=(ss!=null && ss.getMaloai().equals(l.getMaloai()))?"selected":"" %>><%=l.getTenloai() %></option>
				<%} %>
				</select>
			  </div>
			  <input type="submit" class="btn btn-outline-success" name="them" value="Thêm">
			  <input type="submit" class="btn btn-outline-primary" name="sua" value="Sửa">
			</form>
		</div>
	</div>
	
	<table class="table-bordered table-hover" width="100%" align="center">
	<%
	ArrayList<sachbean> dssach = (ArrayList<sachbean>)request.getAttribute("dssach");
	for(sachbean s:dssach){
	%>
		<tr align="center">
			<td><%=s.getMasach() %></td>
			<td><%=s.getTensach() %></td>
			<td><%=s.getTacgia() %></td>
			<td><%=s.getGia() %></td>
			<td><%=s.getSoluong() %></td>
			<td><%=s.getNgaynhap() %></td>
			<td><img alt="Ảnh mặt hàng" src="<%=s.getAnh() %>" height="90" width="60"></td>
			<td><%=s.getMaloai() %></td>
			<td><button class="btn btn-primary"><a class="text-light" href="SachAdminController?mschon=<%=s.getMasach() %>"> Chọn </a></button></td>
			<td><button class="btn btn-danger"><a class="text-light" href="SachAdminController?msxoa=<%=s.getMasach() %>"> Xóa </a></button></td>
		</tr>
	<%} %>
	</table>
</body>
</html>