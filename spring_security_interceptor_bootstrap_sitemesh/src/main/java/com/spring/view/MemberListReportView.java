package com.spring.view;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.web.servlet.view.AbstractView;

import com.spring.service.ExporterService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class MemberListReportView extends AbstractView{
	
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	private ExporterService exporter;
	public void setExporter(ExporterService exporter) {
		this.exporter=exporter;
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, 
										   HttpServletRequest request, 
										   HttpServletResponse response)
												   	throws Exception {
		
		String type=(String)model.get("type");
		String fileName=(String)model.get("fileName");
		
		String jrFileName="memberList.jrxml";
		
		//1. jrxml 템플릿 결정/로딩
		InputStream	reportStream=
		this.getClass().getResourceAsStream("/com/spring/jrxml/"+jrFileName);
		
		//2. 템플릿을 JasperDesign으로 변환
		JasperDesign jd=JRXmlLoader.load(reportStream);
		
		//3. jrxml 컴파일
		JasperReport jr=JasperCompileManager.compileReport(jd);
		
		//4. JasperPrint 생성
		JasperPrint jp=JasperFillManager.fillReport(jr,null,dataSource.getConnection());
		//5. outputstream 생성
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		//6.Exporter 지정
		exporter.export(type, fileName, jp, response, baos);
		
		// 8.response 이용한 전송.
		write(response, baos);
	}
	
	private void write(HttpServletResponse response, ByteArrayOutputStream baos) {
		try {

			logger.debug(baos.size());

			ServletOutputStream outputStream = response.getOutputStream();
			baos.writeTo(outputStream);
			outputStream.flush();

		} catch (Exception e) {
			logger.error("Unable to write report to the" + " output steam");
			throw new RuntimeException(e);
		}
	}
	

}
