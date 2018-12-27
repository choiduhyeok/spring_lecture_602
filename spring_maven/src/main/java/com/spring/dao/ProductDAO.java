package com.spring.dao;

import java.util.List;

import com.spring.dto.ProductVO;

public interface ProductDAO {
		
	List<ProductVO> selectProductList();
}
