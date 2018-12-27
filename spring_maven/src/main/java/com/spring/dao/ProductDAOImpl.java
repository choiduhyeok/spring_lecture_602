package com.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.spring.dto.ProductVO;

public class ProductDAOImpl implements ProductDAO {
	
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	
	@Override
	public List<ProductVO> selectProductList() {
		List<ProductVO> productList=
				(List<ProductVO>)session.selectList(
						"ProductMapper.selectProductAll",null);
		return productList;
	}

}






