package hwcal;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/calculate")
/**
 * Servlet implementation class HWCalculation
 */
public class CalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculationServlet() {
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
		request.setAttribute("mWage", mWage);
		double yearWage = mWage * 10000 * 12;
		
		double holiday = Double.parseDouble(request.getParameter("holiday"));
		request.setAttribute("holiday", holiday);
		double workDay = 365 - holiday;
		
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		request.setAttribute("bonus", bonus);
		double bonusSum = bonus * mWage * 10000;
		//requestScopeでの値送信のため
		
		double allowance = Double.parseDouble(request.getParameter("allowance"));
		double alSum = allowance * 12 * 10000;
		
		double workTime = Double.parseDouble(request.getParameter("workTime")) * workDay;
		
		double gPayment = yearWage + bonusSum + alSum;
		double restraintTime = workDay * 8.0 + workTime;
		double hWage = gPayment / restraintTime;
		String msg = "";
		
		request.setAttribute("msg", msg);
		request.setAttribute("hWage", hWage);
		request.setAttribute("gPayment", gPayment);
		request.setAttribute("restraintTime", restraintTime);
		RequestDispatcher rd = request.getRequestDispatcher("/clcResult.jsp");
		rd.forward(request, response);
	}

}
