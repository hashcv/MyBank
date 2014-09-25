package test3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNew
 */
@WebServlet("/AddNew")
public class AddNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Storage storage = Storage.getInstance();
	private static List<Customer> custs = storage.getCusts();
	private static List<Account> accs = storage.getAccs();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNew() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String ipn = request.getParameter("ipn");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");

		custs.add(new Customer(firstName, lastName, Long.parseLong(ipn),
				address, phone, email));

		request.setAttribute("list", custs);
		request.getRequestDispatcher("/servletWelcome.jsp").forward(request,
				response);

	}

}
