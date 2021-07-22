package com.petpet.product;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petpet.bean.ProductBean;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	public ProductBean insert(ProductBean productbean) {
		return productDao.insert(productbean);
	}
	
	public ProductBean selectById(String productid) {
		return productDao.selectById(productid);
	}
	
	public ProductBean update(String productid, ProductBean productBean) {
		return productDao.update(productid, productBean);
	}
	
	public ProductBean delete(String productid) {
		return productDao.delete(productid);
	}
	
	public List<ProductBean> selectall() {
		return productDao.selectall();
	}
}
