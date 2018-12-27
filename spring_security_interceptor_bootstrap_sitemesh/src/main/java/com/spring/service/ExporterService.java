package com.spring.service;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ExporterService {
	
	public HttpServletResponse export(String type,
									  String fileName,
			  					      JasperPrint jp,
			  						  HttpServletResponse response,
			  						  ByteArrayOutputStream baos)
											throws JRException;
}








