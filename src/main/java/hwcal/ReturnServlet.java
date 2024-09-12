package hwcal;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/return")
/**
 * Servlet implementation class ReturnServlet
 */
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		double mWage = Double.parseDouble(request.getParameter("mWage"));
		double holiday = Double.parseDouble(request.getParameter("holiday"));
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		String msg = "読み込みました";

		request.setAttribute("msg", msg);
		request.setAttribute("holiday", holiday);
		request.setAttribute("bonus", bonus);
		request.setAttribute("mWage", mWage);
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
