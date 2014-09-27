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
@WebServlet("/StorageEditor")
public class StorageEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StorageEditor() {
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

		String action = request.getParameter("action");
		if (action != null && action.length() > 0) {
			String instance = request.getParameter("instance");
			String ipn = request.getParameter("ipn");

			switch (action) {
			case "delete":
				if (instance.equals("customer")) {
					Storage.getCusts().remove((int)Storage.findCustomerIndex(Long.parseLong(ipn)));
				} else if (instance.equals("account")) {
					String number = request.getParameter("number");
					Storage.getAccs().remove(Integer.parseInt(number));
				}
				break;
			case "edit":
				if (instance.equals("customer")) {
					Customer customer = Storage.findCustomer(Long.parseLong(ipn));
					request.setAttribute("firstName", customer.getFirstName());
					request.setAttribute("lastName", customer.getLastName());
					request.setAttribute("ipn", customer.getIpn());
					request.setAttribute("address", customer.getAddress());
					request.setAttribute("phone", customer.getPhone());
					request.setAttribute("email", customer.getEmail());
					request.getRequestDispatcher("/editCustomer.jsp").forward(request,response);
				} else if (instance.equals("account")) {
					String number = request.getParameter("number");
			//		request.setAttribute("account", Storage.findAccount(Long.parseLong(number)).toString());
			//		request.getRequestDispatcher("/editAccount.jsp").forward(request,response);
				}
				break;
			case "save":
				if (instance.equals("customer")) {
					Customer customer = Storage.findCustomer(Long.parseLong(request.getParameter("ipn")));
					customer.setFirstName(request.getParameter("firstName"));
					customer.setLastName(request.getParameter("lastName"));
					customer.setAddress(request.getParameter("address"));
					customer.setPhone(request.getParameter("phone"));
					customer.setEmail(request.getParameter("email"));
				}
				break;				
			case "add":
				if (instance.equals("customer")) {
					Storage.custs.add(new Customer(
							request.getParameter("firstName"),
							request.getParameter("lastName"),
							Long.parseLong(request.getParameter("ipn")),
							request.getParameter("address"),
							request.getParameter("phone"),
							request.getParameter("email"))							
							);
				}
				break;
/*			case "refresh":
				request.setAttribute("customers", Storage.getCusts());
				request.getRequestDispatcher("/customers.jsp").forward(request,
						response);*/
			}

		}
		request.setAttribute("customers", Storage.getCusts());
		request.getRequestDispatcher("/customers.jsp").forward(request,
				response);
	}

}
