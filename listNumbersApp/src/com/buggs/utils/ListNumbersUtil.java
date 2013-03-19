package com.buggs.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ListNumbersUtil {

	public static String generateOddOrEvenNumbersXml() {

		StringBuffer sb = new StringBuffer();
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<numbers>");
		for (int i = 1; i <= 100; i++) {
			String type = checkIfOddOrEven(i);
			sb.append("<value>");
			sb.append("<number>" + i + "</number>");
			sb.append("<type>" + type + "</type>");
			sb.append("</value>");
		}
		sb.append("</numbers>");
		return sb.toString();
	}

	public static String checkIfOddOrEven(int number) {

		String type = null;

		if (number % 2 == 0) {
			type = "even";
		} else {
			type = "odd";
		}
		return type;
	}

	public static void writeFile(String yourXML) {
		try {
			BufferedWriter out1 = new BufferedWriter(new FileWriter("OddAndEvenNumbers.xml"));
			out1.write(yourXML);
			out1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String formatXml(String unformattedXml) {
		try {

			final Document document = parseXmlFile(unformattedXml);

			OutputFormat unFormattedXml = new OutputFormat(document);
			unFormattedXml.setLineWidth(65);
			unFormattedXml.setIndenting(true);
			unFormattedXml.setIndent(2);
			Writer out = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(out, unFormattedXml);
			serializer.serialize(document);
			return out.toString();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static Document parseXmlFile(String in) {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(in));
			return db.parse(is);
		} catch (ParserConfigurationException e) {
			throw new RuntimeException(e);
		} catch (SAXException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
