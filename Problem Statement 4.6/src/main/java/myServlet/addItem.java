package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myBeans.Book;
import myBeans.User;
import myDao.UserDao;
import myPackage.ShoppingCart;
import myService.UserException;
import myService.UserService;

public class addItem extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public addItem() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html);charset=utf-8");
		
		String path = request.getParameter("uri");//è¯·æ±‚é¡µé¢çš„uri
		String bookId = request.getParameter("bookId");

		//èŽ·å¾—å…¨å±€ä¸­çš„bookDBï¼Œcartç­‰javaBeanå¯¹è±¡
		UserDao bookDB = new UserDao();
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		
		//æ·»åŠ ç‰©å“åˆ°è´­ç‰©è½¦ä¸­
	    try {
		   Book book = bookDB.getBookDetails(bookId);
		   cart.add(bookId,book);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	    //æ ¹æ®keywordè¿”å›žè¯·æ±‚é¡µé¢åŽŸæ¥çš„çŠ¶æ€
		String keyword = new String(request.getParameter("keyword").getBytes("ISO-8859-1"),"utf-8");
	    //å¦‚æžœæ˜¯bookdetails.jspå‘å‡ºçš„è¯·æ±‚ï¼Œè¦è¿”å›žåŽŸæ¥æœç´¢çš„å›¾ä¹¦ä¿¡æ¯
		if(path.equals("/bookdetails.jsp")){
		    UserService s=new UserService();
			try {
				List<Book> books = s.BookSearch(keyword);
				request.setAttribute("books", books);
				request.setAttribute("booksName", keyword);
				request.setAttribute("msg", "æ·»åŠ è´­ç‰©è½¦æˆåŠŸ");
				request.getRequestDispatcher(path).forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//å¦‚æžœæ˜¯catalog.jspå‘å‡ºçš„è¯·æ±‚ï¼Œè¦è¿”å›žåŽŸæ¥æŸ¥çœ‹çš„å›¾ä¹¦ä¿¡æ¯
		else {
			//ã€‚ã€‚ã€‚å¾…å®Œæˆ
			request.setAttribute("msg", "æ·»åŠ è´­ç‰©è½¦æˆåŠŸ");
			request.getRequestDispatcher(path).forward(request, response);
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
	}

}
