

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Calendar;
import java.lang.Object;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
import java.util.Vector;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
@WebServlet(
        description = "Login Servlet", 
        urlPatterns = { "/LoginServlet" }, 
        initParams = { 
                @WebInitParam(name = "user", value = "jessica"), 
                @WebInitParam(name = "password", value = "chen")
        })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HTML_START="<html><body>";
    public static final String HTML_END="</body></html>";
    public static String result;
  
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		 PrintWriter out = response.getWriter();
//	     Date date = new Date();
//	     out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
		log("\n\n\nBACK!!\n\n\n");
		String op = request.getParameter("op");
		if("back".equals(op)) {
			log("BACK!!");
			String url = "/hello.html";
		    request.getRequestDispatcher(url).forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		if("back".equals(op)) {
			log("BACK!!");
			String url = "/hello.html";
		    request.getRequestDispatcher(url).forward(request,response);
		}
		else if("view_result".equals(op)) {
	        //get request parameters for userID and password
	        String url_1 = request.getParameter("view_url");
			String date_time = request.getParameter("view_date_time");
			String url = HTML_START + "<h2>Hi There!</h2><br/><h3>Url="+url_1 +"</h3><h3>Date="+ date_time +"</h3>"+HTML_END;
	         
	        //logging example
	        log("url="+url+"::date_time="+date_time);
	        get_page(url, date_time);
	        request.setAttribute("url", url);
	        request.setAttribute("original_url", url_1);
	        request.setAttribute("date_time", date_time);
	        //Servlet JSP communication
			RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/jsps/hello.jsp");
			reqDispatcher.forward(request,response);
	        
		}
         
    }
	public void get_page(String url, String date_time) {
		String date[] = date_time.split("/");
		String month = date[0];
		String day = date[1];
		String year = date[2];
		String next_date = date_time;
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		try {
			c.setTime(format.parse(next_date));
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		c.add(Calendar.DATE, 1);  // number of days to add
		next_date = format.format(c.getTime());
		log("month="+month+"::day="+day+"::year="+year);
		log("next date=" + next_date);
//		Statement stmt = oracleConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//	    ResultSet rst = stmt.executeQuery("select content from CrawlerTable where url = " + url + "year = " + year + " and month = " + month + " and day = " + day );
//	    	    
//	    while (!rst.wasNull()){
//	    	c = Calendar.getInstance();
//			c.setTime(format.parse(next_date));
//			c.add(Calendar.DATE, -1);  // number of days to add
//			next_date = format.format(c.getTime());
//	    	date = next_date.split("/");
//			month = date[0];
//			day = date[1];
//			year = date[2];
//
//		    ResultSet rst = stmt.executeQuery("select content from CrawlerTable where url = " + url + "year = " + year + " and month = " + month + " and day = " + day );
//	        
//	    }

		
	}

}
