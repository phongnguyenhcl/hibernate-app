package app.hibernate.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ProductFilter
 */
@WebFilter("/addProduct")
public class ProductFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		PrintWriter out = response.getWriter();

		String productName = request.getParameter("product_name");
		int size = Integer.parseInt(request.getParameter("product_size"));

		if (request.getParameter("product_name") == null 
			|| request.getParameter("product_name").isEmpty()
			|| size < 0)
			out.println("Invalid: Check your inputs again!");
		else
			chain.doFilter(request, response);
	}

}
