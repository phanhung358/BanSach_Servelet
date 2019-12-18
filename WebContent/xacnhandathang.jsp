<%@page import="bean.sachbean"%>
<%@page import="bean.chitiethoadonbean"%>
<%@page import="bean.hoadonbean"%>
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
if(request.getAttribute("ktxn") != null)
	out.print("<script>alert('Lỗi rồi!')</script>");
if(request.getAttribute("ktxoa") != null)
	out.print("<script>alert('Lỗi: Không thể xóa hóa đơn!')</script>");
%>
<div class="row">
	<table class="table-bordered table-hover shadow p-3 my-3" width="80%" align="center">
	<%
	String ms = null;
	long tong = 0;
	ArrayList<sachbean> dssach = (ArrayList<sachbean>)request.getAttribute("dssach");
	ArrayList<chitiethoadonbean> dsct = (ArrayList<chitiethoadonbean>)request.getAttribute("dsct");
	if(dsct != null && dsct.size() != 0){ %>
		<tr align="center">
			<td> Mã CT </td>
			<td> Mã sách </td>
			<td> Tên Sách </td>
			<td> Ảnh </td>
			<td> Giá </td>
			<td> Số lượng mua </td>
			<td> Mã HĐ </td>
		</tr>
	<%
	for(chitiethoadonbean c:dsct){
	%>
		<tr align="center">
			<td><%=c.getMachitiethd() %></td>
			<td><%=c.getMasach() %></td>
			<%
			for(sachbean s:dssach){
				if(s.getMasach().equals(c.getMasach())){
			%>
				<td><%=s.getTensach() %></td>
				<td><img alt="" src="<%=s.getAnh() %>"></td>
				<td><%=s.getGia() %></td>
			<%tong = tong + s.getGia() * c.getSoluongmua();
			ms = s.getMasach();
			} }%>
			<td><%=c.getSoluongmua() %></td>
			<td><%=c.getMahoadon() %></td>
		</tr>
	<%}%>
		<tr style="color: red">
			<td align="right" colspan="4"> Tổng tiền </td>
			<td colspan="3"><%=tong %> VNĐ</td>
		</tr>
	<%} %>
	</table>
</div>
<div class="row">
	<table class="table-bordered table-hover" width="100%" align="center">
		<tr align="center">
			<td> Mã HĐ </td>
			<td> Mã KH </td>
			<td> Ngày mua(Ngày đặt hàng) </td>
			<td> Tình trạng </td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	<%
	ArrayList<hoadonbean> dshd = (ArrayList<hoadonbean>)request.getAttribute("dshd");
	for(hoadonbean h:dshd){
	%>
		<tr align="center">
			<td><%=h.getMahoadon() %></td>
			<td><%=h.getMakh() %></td>
			<td><%=h.getNgaymua() %></td>
			<%if(h.isDamua()){ %>
			<td> Đã xác nhận </td>
			<td><button class="btn btn-success" disabled> Xác nhận ĐH </button></td>
			<%} else { %>
			<td> Chưa xác nhận </td>
			<td><button class="btn btn-success"><a class="text-light" href="xndhAdminController?maxn=<%=h.getMahoadon()%>"> Xác nhận ĐH </a></button></td>
			<%} %>
			<td><button class="btn btn-primary"><a class="text-light" href="xndhAdminController?machon=<%=h.getMahoadon()%>"> Xem chi tiết </a></button></td>
			<td><button class="btn btn-danger"><a class="text-light" href="xndhAdminController?maxoa=<%=h.getMahoadon()%>"> Xóa </a></button></td>
		</tr>
	<%} %>
	</table>
</div>
</body>
</html>