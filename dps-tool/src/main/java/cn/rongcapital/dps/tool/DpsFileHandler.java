package cn.rongcapital.dps.tool;


import cn.rongcapital.dps.tool.handler.Handler;
import cn.rongcapital.dps.tool.handler.doc.DocHandler;
import cn.rongcapital.dps.tool.handler.doc.DocxHandler;
import cn.rongcapital.dps.tool.handler.html.HtmlHandler;
import cn.rongcapital.dps.tool.handler.pdf.PDFHander;
import cn.rongcapital.dps.tool.handler.rft.RtfHandler;
import static cn.rongcapital.dps.tool.common.ToolAssert.notEmpty;
import static cn.rongcapital.dps.tool.common.ToolAssert.notNull;
import static cn.rongcapital.dps.tool.common.ToolAssert.warning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * file parse handler
 * @author lipeng
 *
 * 2016年6月7日
 */
public class DpsFileHandler {
	/**
	 * <pre class="code">DpsFileHandler.parse("/home/files/word/990.docx","DOCX");</pre>
	 * @param path
	 * @param type DOC/DOCX/PDF/HTML/RTF
	 * @return string of the result
	 */
	public static String parse(String path,String type){
		notEmpty(path, "'path' must not be null or empty");
		notEmpty(type, "'type' must not be null or empty");
		try(InputStream input = new FileInputStream(path)){
			return parse(input,type);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * <pre class="code">DpsFileHandler.parse(new FileInputStream("/home/files/rtf/975.rtf"),"DOCX");</pre>
	 * @param input
	 * @param type DOC/DOCX/PDF/HTML/RTF
	 * @return string of the result
	 */
	public static String parse(InputStream input,String type){
		notNull(input, "'input' must not be null");
		notEmpty(type, "'type' must not be null or empty");
		Handler handler = null;
		switch(type.toUpperCase()){
			case "DOC":
				handler = new DocHandler();break;
			case "DOCX":
				handler = new DocxHandler();break;
			case "PDF":
				handler = new PDFHander();break;
			case "HTML":
				handler = new HtmlHandler();break;
			case "RTF":
				handler = new RtfHandler();break;
			default:
				warning("type is not in (DOC/DOCX/PDF/HTML/RTF)");
		}
		return handler.doHandle(input);
	}
	
	public static void main(String[] args) {
		String res = DpsFileHandler.parse("/home/files/rtf/975.rtf","rtf");
		System.out.println("【rtf】 \n" + res);
		res = DpsFileHandler.parse("/home/files/word/990.doc","doc");
		System.out.println("【doc】 \n" + res);
		res = DpsFileHandler.parse("/home/files/html/1001.html","html");
		System.out.println("【html】 \n" + res);
		res = DpsFileHandler.parse("/home/files/pdf/957.pdf","pdf");
		System.out.println("【pdf】 \n" + res);
		res = DpsFileHandler.parse("/home/files/word/990.docx", "docx");
		System.out.println("【docx】 \n" + res);
		try {
			res = DpsFileHandler.parse(new FileInputStream("/home/files/rtf/975.rtf"),"rtf");
			System.out.println("【rtf】 \n" + res);
			res = DpsFileHandler.parse(new FileInputStream("/home/files/word/990.doc"),"doc");
			System.out.println("【doc】 \n" + res);
			res = DpsFileHandler.parse(new FileInputStream("/home/files/html/1001.html"),"html");
			System.out.println("【html】 \n" + res);
			res = DpsFileHandler.parse(new FileInputStream("/home/files/pdf/957.pdf"),"pdf");
			System.out.println("【pdf】 \n" + res);
			res = DpsFileHandler.parse(new FileInputStream("/home/files/word/990.docx"), "docx");
			System.out.println("【docx】 \n" + res);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
