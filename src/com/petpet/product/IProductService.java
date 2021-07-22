package com.petpet.product;

import java.util.List;

import com.petpet.bean.ProductBean;

public interface IProductService {
	
	public ProductBean insert(ProductBean productBean);
	public ProductBean selectById(String productid);
	public ProductBean update(String productid, ProductBean productBean);
	public ProductBean delete(String productid);
	public List<ProductBean> selectall();
}
