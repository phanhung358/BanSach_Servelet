package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.dangnhapbo;
import bo.loaibo;

/**
 * Servlet implementation class dncontroller
 */
@WebServlet("/dncontroller")
public class dncontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dncontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    dangnhapbo dn = new dangnhapbo();
    loaibo lbo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			
			String un =request.getParameter("txtun");
			String pass =request.getParameter("pass");
			
			if(un == null && pass == null && session.getAttribute("un") == null) {//Chạy lần đầu thì mở trang dangnhap.jsp
				request.setAttribute("dsloai", lbo.getloai());
				RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
				rd.forward(request, response);
			}
			else {
				if(dn.getDangNhap(un, pass) == null) {
					request.setAttribute("ktdn", 0);
					request.setAttribute("dsloai", lbo.getloai());
					RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
					rd.forward(request, response);
				}
				else {
					session.setAttribute("un", un);
					session.setAttribute("makh", dn.getDangNhap(un, pass).getMakh());
					RequestDispatcher rd = request.getRequestDispatcher("sachcontroller");
					rd.forward(request, response);
				}
			}
			
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
