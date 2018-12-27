package com.spring.dao;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.MemberVO;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/root-context.xml")
@TransactionConfiguration(transactionManager="transactionManager",
						  defaultRollback=false)
@Transactional
public class MemberDAOImplTest {	
	
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	@Before
	public void init(){
		/*dataSource.setUrl("jdbc:oracle:thin:@192.168.0.1147:1521:XE");*/
	}
	
	@Test
	public void select_member_list_test() throws Exception{
		List<MemberVO> memberList = (List<MemberVO>)memberDAO.selectMemberList();
		assertEquals(4,memberList.size());
	}
	
	@Test
	public void select_member_by_id_test() throws Exception{
		String id="one";
		MemberVO member = memberDAO.selectMemberById(id);
		
		assertEquals(id,member.getId());
	}
	
	@Test
	@Rollback
	public void insert_member_test()throws Exception{
		MemberVO member=new MemberVO();
		member.setId("mumu");
		member.setPwd("mumu");
		member.setName("mumu");	
		member.setAddress("");
		member.setEmail("");
		member.setPhone("");
		member.setZipNum("");
		
		Exception result=null;
		try{
			memberDAO.insertMember(member);
		}catch(SQLException e){
			result=e;
			throw e;
		}
		
		assertThat(result,nullValue());
		
	}
	
	
}


