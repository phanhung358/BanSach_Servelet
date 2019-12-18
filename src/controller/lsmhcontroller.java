package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.chitiethoadonbean;
import bean.hoadonbean;
import bo.chitiethoadonbo;
import bo.hoadonbo;
import bo.loaibo;
import bo.sachbo;

/**
 * Servlet implementation class lsmhcontroller
 */
@WebServlet("/lsmhcontroller")
public class lsmhcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lsmhcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    sachbo sbo = new sachbo();
    loaibo lbo = new loaibo();
    hoadonbo hbo = new hoadonbo();
    chitiethoadonbo ctbo = new chitiethoadonbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			ArrayList<chitiethoadonbean> dsct = new ArrayList<chitiethoadonbean>();
			HttpSession session = request.getSession();
			
			if(session.getAttribute("makh") != null) {
				
				ArrayList<hoadonbean> dshd = new ArrayList<hoadonbean>();
				for(hoadonbean h:hbo.gethoadon()) {
					if(h.getMakh() == (long)session.getAttribute("makh"))
						dshd.add(h);
				}
				request.setAttribute("dshd", dshd);
				if(request.getParameter("machon") != null) {
					for(chitiethoadonbean c:ctbo.getchitiet())	{
						if(c.getMahoadon() == Long.parseLong(request.getParameter("machon"))) {
							dsct.add(c);
						}
					}
					request.setAttribute("dsct", dsct);
				}
			}
			
			request.setAttribute("dsloai", lbo.getloai());
			request.setAttribute("dssach", sbo.getsach());
			
			RequestDispatcher rd = request.getRequestDispatcher("lichsumuahang.jsp");
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
