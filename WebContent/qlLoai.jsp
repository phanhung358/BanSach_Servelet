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
	loaibean ll = (loaibean) request.getAttribute("chon");
	
	%>
	<div class="offset-3 col-lg-6">
		<div class="container">
			<form action="LoaiAdminController" method="post" class="shadow p-3 my-3">
			  <div class="form-group">
			    <label for="email">Mã loại:</label>
			    <input type="text" class="form-control" name="txtml" value="<%=ll!=null?ll.getMaloai():"" %>"  placeholder="Mã loại">
			  </div>
			  <div class="form-group">
			    <label for="pwd">Tên loại:</label>
			    <input type="text" class="form-control" name="txttl" value="<%=ll!=null?ll.getTenloai():"" %>"  placeholder="Tên loại">
			  </div>
			  <button type="submit" class="btn btn-outline-success" name="butthem">Thêm</button>
			  <button type="submit" class="btn btn-outline-primary" name="butsua">Sửa</button>
			</form>
		</div>
	</div>
	
	<table class="table-bordered table-hover" width="50%" align="center">
	<%
	ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
	for(loaibean l:dsloai){
	%>
		<tr align="center">
			<td><%=l.getMaloai() %></td>
			<td><%=l.getTenloai() %></td>
			<td><button class="btn btn-primary"><a class="text-light" href="LoaiAdminController?mlchon=<%=l.getMaloai() %>"> Chọn </a></button></td>
			<td><button class="btn btn-danger"><a class="text-light" href="LoaiAdminController?mlxoa=<%=l.getMaloai() %>"> Xóa </a></button></td>
		</tr>
	<%} %>
	</table>
</body>
</html>