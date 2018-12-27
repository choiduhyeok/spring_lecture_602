package com.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.dao.ProductDAO;
import com.spring.dto.ProductVO;

public class ProductDAOMain {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new GenericXmlApplicationContext(
						"classpath:application-context.xml");
		
		ProductDAO productDAO=(ProductDAO)ctx.getBean("productDAO");
		
		List<ProductVO> productList=productDAO.selectProductList();
		
		for(ProductVO product:productList){
			System.out.println(product);
		}

	}

}






