package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class SachAdminController
 */
@WebServlet("/SachAdminController")
public class SachAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SachAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    loaibo lbo = new loaibo();
    sachbo sbo = new sachbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8"); 

			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			
			if(request.getParameter("them")!=null) {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				 
				try {
					List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
					//duyệt qua các đối tượng gửi lên từ client gồm file và các control
					for (FileItem fileItem : fileItems) {
				 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
								// xử lý file
								String nameimg = fileItem.getName();
								if (!nameimg.equals("")) {
							           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
									String dirUrl = request.getServletContext().getRealPath("") + "image_sach";
									File dir = new File(dirUrl);
									if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
										dir.mkdir();
									}
								           String fileImg = dirUrl + File.separator + nameimg;
								           File file = new File(fileImg);//tạo file
								            try {
								               fileItem.write(file);//lưu file
								              System.out.println("UPLOAD THÀNH CÔNG...!");
								              System.out.println("Đường dẫn lưu file là: "+dirUrl);
								 } catch (Exception e) {
								    e.printStackTrace();
								}
							}
						 }
//						else//Neu la control
//						{
//							String tentk=fileItem.getFieldName();
//							if(tentk.equals("txthoten"))
//								response.getWriter().println(fileItem.getString());
//							if(tentk.equals("txtdiachi"))
//								response.getWriter().println(fileItem.getString());
//						}
					}
				
				} catch (FileUploadException e) {
					e.printStackTrace();
				}
				
				String maloai = request.getParameter("txtml");
				String masach = request.getParameter("txtms");
				String tensach = request.getParameter("txtts");
				String tacgia = request.getParameter("txttg");
				String anh = request.getParameter("txta");
				String sotap = request.getParameter("txtst");
				if(request.getParameter("txtgia")!=null && request.getParameter("txtsl")!=null && request.getParameter("txtnn")!=null) {
					long gia = Long.parseLong(request.getParameter("txtgia"));
					long soluong = Long.parseLong(request.getParameter("txtsl"));
					Date ngaynhap = f.parse(request.getParameter("txtnn"));
	
					int n = sbo.Them(masach, tensach, tacgia, gia, soluong, ngaynhap, "image_sach/" + anh, sotap, maloai);
					if(n==0) 
						request.setAttribute("ktnhap", 0);
				}
			}
			if(request.getParameter("sua")!=null) {
				
				 DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				 ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				 String dirUrl1 = request.getServletContext().getRealPath("") + "image_sach";
				 response.getWriter().println(dirUrl1);
				 
				try {
					List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
					//duyệt qua các đối tượng gửi lên từ client gồm file và các control
					for (FileItem fileItem : fileItems) {
				 			 if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
								// xử lý file
								String nameimg = fileItem.getName();
								if (!nameimg.equals("")) {
							           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
									String dirUrl = request.getServletContext().getRealPath("") + "image_sach";
									File dir = new File(dirUrl);
									if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
										dir.mkdir();
									}
								           String fileImg = dirUrl + File.separator + nameimg;
								           File file = new File(fileImg);//tạo file
								            try {
								               fileItem.write(file);//lưu file
								              System.out.println("UPLOAD THÀNH CÔNG...!");
								              System.out.println("Đường dẫn lưu file là: "+dirUrl);
								 } catch (Exception e) {
								    e.printStackTrace();
								}
							}
						 }
//						else//Neu la control
//						{
//							String tentk=fileItem.getFieldName();
//							if(tentk.equals("txthoten"))
//								response.getWriter().println(fileItem.getString());
//							if(tentk.equals("txtdiachi"))
//								response.getWriter().println(fileItem.getString());
//						}
					}
				
				} catch (FileUploadException e) {
					e.printStackTrace();
				}

				String maloai = request.getParameter("txtml");
				String masach = request.getParameter("txtms");
				String tensach = request.getParameter("txtts");
				String tacgia = request.getParameter("txttg");
				String anh = request.getParameter("txta");
				String sotap = request.getParameter("txtst");
				if(request.getParameter("txtgia")!=null && request.getParameter("txtsl")!=null && request.getParameter("txtnn")!=null) {
					long gia = Long.parseLong(request.getParameter("txtgia"));
					long soluong = Long.parseLong(request.getParameter("txtsl"));
					Date ngaynhap = f.parse(request.getParameter("txtnn"));
	
					int n = sbo.Sua(masach, tensach, tacgia, gia, soluong, ngaynhap, "image_sach/"+ anh, sotap, maloai);
					if(n==0) 
						request.setAttribute("ktsua", 0);
				}
			}
			if(request.getParameter("mschon")!=null) {
				request.setAttribute("chon", sbo.TimMaSach(request.getParameter("mschon")));
			}
			if(request.getParameter("msxoa")!=null) {
				int n = sbo.Xoa(request.getParameter("msxoa"));
				if(n==0) 
					request.setAttribute("ktxoa", 0);
			}
			
			request.setAttribute("dssach", sbo.getsach());
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("qlSach.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
