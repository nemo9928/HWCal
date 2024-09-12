package hwcal;

import java.io.IOException;

import bean.EPListDTO;
import dao.RegisterDAO;
import dao.SearchDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
/**
 * Servlet implementation class RegisterEP
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String enterprise = request.getParameter("enterprise");
		double mWage = Double.parseDouble(request.getParameter("mWage"));
		request.setAttribute("mWage", mWage);
		double holiday = Double.parseDouble(request.getParameter("holiday"));
		request.setAttribute("holiday", holiday);
		double bonus = Double.parseDouble(request.getParameter("bonus"));
		request.setAttribute("bonus", bonus);
		//database,requestScope用データ
		
		//登録済みでなければ登録
		SearchDAO sdao = new SearchDAO();
		EPListDTO dto = new EPListDTO();
		dto = sdao.select(enterprise);
		String msg = enterprise + "はすでに登録されています";
		if(dto.size() == 0) {
			RegisterDAO rdao = new RegisterDAO();
			rdao.insert(enterprise,mWage, holiday, bonus);
			//databese接続クラスへデータを転送
			msg = enterprise + "を登録しました。";
		}
		request.setAttribute("msg", msg);
		
		double gPayment = Double.parseDouble(request.getParameter("gPayment"));
		request.setAttribute("gPayment", gPayment);
		double restraintTime = Double.parseDouble(request.getParameter("restraintTime"));
		request.setAttribute("restraintTime", restraintTime);
		double hWage = gPayment / restraintTime;
		request.setAttribute("hWage", hWage);
		//jsp内表示データ
		
		RequestDispatcher rd = request.getRequestDispatcher("/clcResult.jsp");
		rd.forward(request, response);
	}

}
