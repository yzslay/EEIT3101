package com.petpet.bean;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "product")
@Component("productBean")
public class ProductBean {
	
	@Id @Column(name = "PRODUCTID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String productid;
	
	@Column(name = "PRODUCTNAME")
	private String productname;
	
	@Column(name = "PRICE")
	private String price;
	
	@Column(name = "PRODUCTDESCRIPTION")
	private String productdescription;
	
	Timestamp createTime;
	
	public ProductBean() {
		
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getProductdescription() {
		return productdescription;
	}
	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
