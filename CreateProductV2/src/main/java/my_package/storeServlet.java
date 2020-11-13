package my_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class storeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Configuration con = new Configuration().configure().addAnnotatedClass(productv2.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		
		
	    List<productv2> batabase_products =new  ArrayList<productv2>();
		
	    hib_session.beginTransaction();
	    
	    batabase_products = hib_session.createQuery("from productv2", productv2.class).getResultList();
	    
	    hib_session.getTransaction().commit();
	    
	    
	    req.setAttribute("batabase_products", batabase_products);
	 
	    req.getRequestDispatcher("DatabaseProducts.jsp").forward(req, res);
	}
}
