package com.spring.dataSource;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dto.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/spring/context/dataSource-context.xml")
@TransactionConfiguration(transactionManager="transactionManager",
						  defaultRollback=false)
@Transactional
public class SqlSessionTest {
	
	@Autowired
	private SqlSession session;
	
		
	@Test
	public void list_member_test() {
		List<MemberVO> memberList=
				(List<MemberVO>)session.selectList("MemberMapper.selectMemberList",null);
		
		assertThat(session,not(nullValue()));
		assertEquals(4,memberList.size());
		
		//assertNotNull(session)		
		
	}
	
	@Test
	@Rollback
	public void insert_member_test() throws SQLException{
		MemberVO member=new MemberVO();
		member.setId("mumu");
		member.setPwd("mumu");
		member.setName("mumu");	
		member.setAddress("");
		member.setEmail("");
		member.setPhone("");
		member.setZipNum("");
		int result=session.update("MemberMapper.insertMember",member);
	
		assertEquals(1,result);
	}
	
	@Test
	public void get_member_by_id_test(){
		String id="one";
		
		MemberVO member=
				(MemberVO)session.selectOne("MemberMapper.selectMemberById",id);
		
		assertEquals(id,member.getId());
	}
	

}






