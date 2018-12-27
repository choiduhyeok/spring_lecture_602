package com.spring.mail;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.spring.dto.MemberVO;

public class MimeAttachNotifier {
	
	private JavaMailSender mailSender;
	public void setMailSender(JavaMailSender mailSender){
		this.mailSender=mailSender;
	}
	
	public void sendMail(MemberVO receiver,String attachPath){
		MimeMessage message=mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper=
					new MimeMessageHelper(message,true,"utf-8");
			
			messageHelper.setSubject("가입 확인 안내 메일");
			
			String htmlContent="<h2>왕대박 이벤트 행사 안내</h2>"
					   + "<ul>"
					   + "	<li>이름 : "+receiver.getName()+"님 가입을 환영합니다.</li>"							   
					   + "	<li>이번 기회를 놓치지마시고 바로 응모하세요.</li>"
					   + "	<li>행사 안내</li>"
					   + "	<li>아래 배너를 클릭하세요.</li>"
					   + "	<li>"
					   + "		<a href='http://www.ssfshop.com/special/42560/view?utag=ref_ptn:24370' >"
					   + "			<img src='cid:banner' />"
					   + "		</a>"
					   + "	</li>"
					   + "</ul>";
			
			messageHelper.setText(htmlContent,true);
			messageHelper.addInline("banner", new FileDataSource(attachPath+"/img.PNG"));
			messageHelper.setFrom("nimicosara@naver.com", "운영자");
			messageHelper.setTo(new InternetAddress(receiver.getEmail(),"utf-8"));
			
			DataSource dataSource = new FileDataSource(attachPath+"/이용약관.pdf");
			messageHelper.addAttachment(
					MimeUtility.encodeText("이용약관.pdf","utf-8","B"),dataSource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mailSender.send(message);
	}
}









