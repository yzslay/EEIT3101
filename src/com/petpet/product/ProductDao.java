package com.petpet.product;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.petpet.bean.ProductBean;

@Repository("productDao")
@Transactional
public class ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductBean insert(ProductBean productBean) {
		Session session = sessionFactory.getCurrentSession();
		session.save(productBean);
		return productBean;
	}
	
	public ProductBean selectById(String productid) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean productBean = session.get(ProductBean.class, productid);
		return productBean;
	}
	
	public ProductBean update(String productid, ProductBean productBean) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean result = session.get(ProductBean.class, productid);
		if(result != null) {
			result.setProductname(productBean.getProductname());
			result.setPrice(productBean.getPrice());
			result.setProductdescription(productBean.getProductdescription());
		}
		return result;
	}
	
	public ProductBean delete(String productid) {
		Session session = sessionFactory.getCurrentSession();
		ProductBean productBean = session.get(ProductBean.class, productid);
		session.delete(productBean);
		return productBean;
	}
	
	public List<ProductBean> selectall() {
		Session session = sessionFactory.getCurrentSession();
		Query<ProductBean> query = session.createQuery("from EventBean",ProductBean.class);
		return query.list();
	};
}
