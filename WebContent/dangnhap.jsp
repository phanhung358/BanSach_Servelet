<%@page import="bean.dangnhapbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="bean.sachbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.loaibean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Books</title>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap Core CSS -->
<link href="Content/bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="Content/shop-homepage.css" rel="stylesheet">

</head>
<body>
	<%
	if(request.getAttribute("ktdn")!=null)
		out.print("<script>alert('Lỗi: Tên đăng nhập hoặc mật khẩu không đúng!')</script>");
	
	long soluong, tongtien;
	giohangbo gh = null;
	if(session.getAttribute("gh")==null){
		soluong = tongtien = 0;
	}
	else{
		gh = (giohangbo) session.getAttribute("gh");
		soluong = gh.ds.size();
		tongtien = gh.Tong();
	}%>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Start Bootstrap</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="sachcontroller">TRANG CHỦ</a>
                    </li>
                    <li>
                        <a href="dkcontroller">ĐĂNG K&#221;</a>
                    </li>
                    
                    <%
                    String un = (String)session.getAttribute("un");
            		if(un != null){
                    %>
                    <li>
                        <a href="lsmhcontroller">LỊCH SỬ MUA HÀNG</a>
                    </li>
                    <li>
                        <a href=""><%=un %></a>
                    </li>
                    <%}
                    else {%>
                    <li>
                        <a href="dncontroller">ĐĂNG NHẬP</a>
                    </li>
                    <%} %>
                    <li>
                        <a href="giohangcontroller" style="color: white; font-weight: bold; text-decoration: none;">
                            <img src="images/giohang.gif" />Giỏ Hàng (<%=soluong %>:<%=tongtien %>)
                        </a>

                    </li>
                </ul>
                <form class="navbar-form navbar-right" action="sachcontroller">
			      <div class="form-group">
			        <input type="text" class="form-control" placeholder="Search" name="search">
			      </div>
			      <button type="submit" class="btn btn-success">Submit</button>
			    </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-3">

                <p class="lead"> CHỦ ĐỀ SÁCH</p>
                <div class="list-group">
                	<a href="sachcontroller" class="list-group-item">
                        Tất cả
                    </a>
                <%
                ArrayList<loaibean> dsloai = new ArrayList<loaibean>();
                dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
                for(loaibean loai:dsloai){
                %>
                    <a href="sachcontroller?ml=<%=loai.getMaloai() %>" class="list-group-item">
                        <%=loai.getTenloai() %>
                    </a>
                <%} %> 
                </div>


                <p class="lead"> NHÀ XUẤT BẢN </p>
                <div class="list-group">
                    <a href="/BookStore/SPTheoNXB/1" class="list-group-item">
                        Nh&#224; xuất bản Trẻ
                    </a>
                    <a href="/BookStore/SPTheoNXB/2" class="list-group-item">
                        NXB Thống k&#234;
                    </a>
                    <a href="/BookStore/SPTheoNXB/3" class="list-group-item">
                        Kim đồng
                    </a>
                    <a href="/BookStore/SPTheoNXB/4" class="list-group-item">
                        Đại học quốc gia
                    </a>
                    <a href="/BookStore/SPTheoNXB/5" class="list-group-item">
                        Văn h&#243;a nghệ thuật
                    </a>
                    <a href="/BookStore/SPTheoNXB/6" class="list-group-item">
                        Văn h&#243;a
                    </a>
                    <a href="/BookStore/SPTheoNXB/7" class="list-group-item">
                        Lao động - X&#227; hội
                    </a>
                    <a href="/BookStore/SPTheoNXB/8" class="list-group-item">
                        Khoa Học &amp; Kỹ Thuật
                    </a>
                </div>




            </div>
            <div class="col-md-9">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="5"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="6"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="7"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="8"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="9"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="image_sach/a3.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/a4.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/a5.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b1.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b11.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b12.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b14.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b16.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b17.jpg" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="image_sach/b18.jpg" alt="">
                                </div>


                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                    </div>
                </div>
				<div>



                    <h4 style="color:red; text-align:center"> </h4>
                    <h3 style="text-align:center">ĐĂNG NHẬP</h3>
                    <table align="center">

                        <form action="dncontroller" method="post">
                        <tbody>
                            <tr style="height:40px">
                                <td> Tên đăng nhập:</td>
                                <td>
                                    <input name="txtun" type="text" value="">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td align="right">  Mật khẩu:</td>
                                <td>
                                    <input name="pass" type="password">

                                </td>
                            </tr>
                            <tr style="height:40px">
                                <td></td>
                                <td>
                                    <button type="submit">Đăng nhập</button>
                                </td>
                            </tr>
                        </tbody>
                        </form>
                    </table>


             	</div>
             </div>
        </div>
    </div>
    <!-- /.container -->
    <div class="container">
        <hr>
        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; MVC 5</p>
                </div>
            </div>
        </footer>
    </div>
    <!-- /.container -->
    <!-- jQuery -->
    <script src="Scripts/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="Scripts/bootstrap.min.js"></script>

</body>
</html>