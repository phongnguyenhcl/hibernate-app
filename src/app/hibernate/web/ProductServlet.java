package app.hibernate.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.hibernate.dao.ProductDAO;
import app.hibernate.model.Product;

@WebServlet("/addProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDAO productDao;
	
	public void init() {
		productDao = new ProductDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("product_name");
		int size = Integer.parseInt(request.getParameter("product_size"));
		productDao.addProduct(new Product(productName, size));
		
		PrintWriter out = response.getWriter();
		out.println("Product has been added successfully");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
