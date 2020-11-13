package my_package;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class createServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String barcode_string = req.getParameter("barcode");
		String name_=req.getParameter("name");
		String color_=req.getParameter("color");
		String des_=req.getParameter("description");
		
		boolean check_res = false; 	
		
		Configuration con = new Configuration().configure().addAnnotatedClass(productv2.class);
		SessionFactory sf = con.buildSessionFactory();
		Session hib_session = sf.openSession();
		
		productv2 product_check=null;
		Transaction tx = hib_session.beginTransaction();
		product_check = (productv2) hib_session.get(productv2.class, barcode_string);
		tx.commit();
		
		if(product_check!=null) {
			check_res = true;
		}
		
		if(barcode_string.equals("")) {
			res.sendRedirect("EmptyBarcode.jsp");
		}else {
			if (check_res==true){
				req.setAttribute("batabase_products_", product_check);
			    req.getRequestDispatcher("Barcode_Exist.jsp").forward(req, res);
			}else {
				
				if(name_==null || name_.equals("")) {
					name_ = "No_Name";
				}
				if(color_==null || color_.equals("")) {
					color_= "No_Color";
				}
				if(des_==null || des_.equals("")) {
					des_ = "No_Description";
				}
				
				productv2 save_product=new productv2();
				save_product.setBarcode(barcode_string);
				save_product.setSname(name_);
				save_product.setColor(color_);
				save_product.setPdescription(des_);	
				
				tx = hib_session.beginTransaction();
				hib_session.save(save_product);
				tx.commit();
				
				req.setAttribute("Saved", save_product);
			    req.getRequestDispatcher("Product.jsp").forward(req, res);
			
			}
		}
	}
}




