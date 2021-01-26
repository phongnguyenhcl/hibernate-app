package app.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.hibernate.model.Product;
import app.hibernate.util.HibernateUtil;

public class ProductDAO {

	public void addProduct(Product product) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		Transaction transaction = null;
		List<Product> listOfProduct = null;
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
			transaction = session.beginTransaction();
			
			listOfProduct = session.createQuery("from Product").getResultList();

			transaction.commit();
		
		}

		return listOfProduct;
	}

}
