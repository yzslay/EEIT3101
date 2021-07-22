package com.petpet.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petpet.bean.ProductBean;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/selectall.controller")
	public String selectAll(Model m) {
		List<ProductBean> product = productService.selectall();
		m.addAttribute("products", product);
		return "SelectAll";
	}

	@GetMapping("/selectid.controller")
	public String selectById(@RequestParam("productid") String productid, Model m) {
		ProductBean product = productService.selectById(productid);
		m.addAttribute("product", product);
		return "SelectId";
	}
	
	@GetMapping("/insert.controller")
	public String insert(HttpServletRequest request, Model m) {
		ProductBean productbean = new ProductBean();
		productbean.setProductname(request.getParameter("productname"));
		productbean.setPrice(request.getParameter("price"));
		productbean.setProductdescription(request.getParameter("productdescription"));
		productService.insert(productbean);
		m.addAttribute("product", productbean);
		return "Insert";
	}
	
	@GetMapping("/delete.controller")
	public String delete(@RequestParam(name = "productid") String productid, HttpServletRequest request, Model m) {
		ProductBean productbean = productService.delete(productid);
		m.addAttribute("product", productbean);
		return "Delete";
	}
	
	@GetMapping("/update.controller")
	public String update(@RequestParam(name = "productid") String productid, HttpServletRequest request, Model m) {
		ProductBean productbean = new ProductBean();
		productbean.setProductname(request.getParameter("productname"));
		productbean.setPrice(request.getParameter("price"));
		productbean.setProductdescription(request.getParameter("productdescription"));
		productService.update(productid, productbean);
		ProductBean product = productService.selectById(productid);
		m.addAttribute("product", product);
		return "Update";
	}
}
