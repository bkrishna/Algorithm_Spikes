package com.buggs.controller;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buggs.utils.ListNumbersUtil;

@Controller
public class ListNumbersController {
	
	@RequestMapping("/getOddAndEvenNumberTable")
	public void getOddAndEvenNumberTable(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ApplicationContext context = ApplicationContextProvider.getApplicationContext();
		
		String xml = ListNumbersUtil.generateOddOrEvenNumbersXml();
		request.getSession().setAttribute("generatedOddOrEvenNumberXml", xml);
		InputStream xmlSource = new ByteArrayInputStream(xml.getBytes());
		
		Resource xslResource = context.getResource("/WEB-INF/files/OddAndEvenNumbers.xsl");
		InputStream xslSource = new FileInputStream(xslResource.getFile().getAbsolutePath());
		
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(xslSource));
		StringWriter writer = new StringWriter();
		transformer.transform(new StreamSource(xmlSource), new StreamResult(writer));
	
		response.setContentType("text/html");
		response.getWriter().write(writer.toString());
		response.flushBuffer();
	}
	
	@RequestMapping("/getGeneratedXml")
	public void getGeneratedXml(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 
		System.out.println("Inside Controller");
		String xml = (String) request.getSession().getAttribute("generatedOddOrEvenNumberXml");
		
	//	String xml = generateOddOrEvenNumbersXml();
		response.getWriter().write(ListNumbersUtil.formatXml(xml));
		response.setHeader("Content-Disposition","attachment; filename=OddAndEvenNumbers.xml");
		response.flushBuffer();
	}
}
