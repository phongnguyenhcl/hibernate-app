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

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		
		int size = Integer.parseInt(request.getParameter("product_size"));
		
		if (size>0)
			chain.doFilter(request, response);
		else
			out.println("Invalid: Negative weight");
	}

}
