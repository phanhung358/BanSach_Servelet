package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangbean;
import bo.chitiethoadonbo;
import bo.giohangbo;
import bo.hoadonbo;
import bo.loaibo;

/**
 * Servlet implementation class dathangcontroller
 */
@WebServlet("/dathangcontroller")
public class dathangcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dathangcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    loaibo lbo = new loaibo();
    hoadonbo hbo = new hoadonbo();
    chitiethoadonbo ctbo = new chitiethoadonbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			
			if(session.getAttribute("un") == null && session.getAttribute("makh") == null) {
				request.setAttribute("dsloai", lbo.getloai());
				RequestDispatcher rd = request.getRequestDispatcher("dncontroller");
				rd.forward(request, response);
			}
			else {
				giohangbo gh = (giohangbo) session.getAttribute("gh");
				long makh = (long)session.getAttribute("makh");
				long mahoadon = 0;
				if(hbo.Max() > 0)
					mahoadon = hbo.Max() + 1;
				else
					mahoadon = 1;
				
				Date date = new Date();

				if(hbo.Them(mahoadon, makh, date, false) != 0) {
					for(giohangbean g:gh.ds) {
						long machitiethd = 0;
						if(ctbo.Max() > 0)
							machitiethd = ctbo.Max() + 1;
						else
							machitiethd = 1;
						int m = ctbo.Them(machitiethd, g.getMasach(), (int)g.getSoluong(), mahoadon);
					}
					session.setAttribute("gh", null);
				}
					
				response.getWriter().println("WTF");
				RequestDispatcher rd = request.getRequestDispatcher("sachcontroller");
				rd.forward(request, response);
			}
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
