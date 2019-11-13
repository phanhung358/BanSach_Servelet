package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bean.sachbean;
import bo.giohangbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class giohangcontroller
 */
@WebServlet("/giohangcontroller")
public class giohangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public giohangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    sachbo sbo = new sachbo();
    loaibo lbo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String masach = request.getParameter("ms");
			String nut = request.getParameter("btn");
			String soluong = request.getParameter("txtSoluong");
			
			giohangbo gh = null;
			//Kiểm tra xem đã tạo session chưa
			if(session.getAttribute("gh")==null){
				//Nếu chưa thì tạo ra 1 session de luu sach
				gh = new giohangbo();
				session.setAttribute("gh", gh);
			}
			//b1: lấy session luu vào biến gh
			gh = (giohangbo) session.getAttribute("gh");
			
			if(nut != null) {
				if(nut.equals("xoatatca"))
					session.setAttribute("gh", null);
				if(nut.equals("xoa")) {
					for(giohangbean g:gh.ds){
						if(g.getMasach().equals(masach)){
							gh.ds.remove(g);
							session.setAttribute("gh", gh);
							break;
						}
					}
					if(gh.ds.size() == 0)
						session.setAttribute("gh", null);
				}
				if(nut.equals("sua")) {
					if(soluong != null) {
						long sl = Long.parseLong(soluong);
						for(giohangbean g:gh.ds){
							if(g.getMasach().equals(masach)){
								g.setSoluong(sl);
								g.setThanhtien();
								session.setAttribute("gh", gh);
							}		
						}
					}
				}
			}
			else {
				 
				//b2: thay đổi gh
				
				for(sachbean sach:sbo.getsach()) {
					if(sach.getMasach().equals(masach)) {
						gh.Them(sach.getMasach(), sach.getTensach(), sach.getTacgia(), sach.getGia(), sach.getAnh(), sach.getNgaynhap(), sach.getMaloai(), 1);
						break;
					}
				}
				//b3: luu biến vào session
				session.setAttribute("gh", gh);
			}
			//Hiển thị giỏ hàng
			request.setAttribute("dsloai", lbo.getloai());
			RequestDispatcher rd = request.getRequestDispatcher("htGio.jsp");
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
