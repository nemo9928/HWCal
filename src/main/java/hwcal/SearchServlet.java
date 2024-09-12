package hwcal;

import java.io.IOException;

import bean.EPListDTO;
import dao.SearchDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/search")
/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("enterprise");
		SearchDAO sdao = new SearchDAO();
		EPListDTO dto = new EPListDTO();
		dto = sdao.select(name);
		String msg = dto.size() + "件みつかりました";
		request.setAttribute("dto", dto);
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("/epSearch.jsp");
		rd.forward(request, response);
	}

}
