package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.chitiethoadonbean;
import bo.chitiethoadonbo;
import bo.hoadonbo;
import bo.sachbo;

/**
 * Servlet implementation class xndhAdminController
 */
@WebServlet("/xndhAdminController")
public class xndhAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xndhAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    sachbo sbo = new sachbo();
    hoadonbo hbo = new hoadonbo();
    chitiethoadonbo ctbo = new chitiethoadonbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			ArrayList<chitiethoadonbean> dsct = new ArrayList<chitiethoadonbean>();
			
			if(request.getParameter("machon") != null) {
				for(chitiethoadonbean c:ctbo.getchitiet())	{
					if(c.getMahoadon() == Long.parseLong(request.getParameter("machon"))) {
						dsct.add(c);
					}
				}
				request.setAttribute("dsct", dsct);
			}
			if(request.getParameter("maxn") != null) {
//				response.getWriter().println("WTF");
				int n = hbo.XacNhan(Long.parseLong(request.getParameter("maxn")));
				if(n == 0)
					request.setAttribute("ktxn", 0);
			}
			if(request.getParameter("maxoa") != null) {
				int n = hbo.Xoa(Long.parseLong(request.getParameter("maxoa")));
				if(n == 0)
					request.setAttribute("ktxoa", 0);
			}
			
			request.setAttribute("dssach", sbo.getsach());
			request.setAttribute("dshd", hbo.gethoadon());
			RequestDispatcher rd = request.getRequestDispatcher("xacnhandathang.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
