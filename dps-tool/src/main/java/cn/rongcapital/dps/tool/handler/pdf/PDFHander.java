package cn.rongcapital.dps.tool.handler.pdf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import static cn.rongcapital.dps.tool.common.HandleFilter.filterRN;
import cn.rongcapital.dps.tool.handler.Handler;

/**
 * PDF file parser
 * 
 * @author lipeng
 *
 *         2016年6月7日
 */
public class PDFHander implements Handler {

	@Override
	public String doHandle(String path) {
		// TODO Auto-generated method stub
		try (FileInputStream is = new FileInputStream(path);) {
			return doHandle(is);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}

	@Override
	public String doHandle(InputStream input) {
		// TODO Auto-generated method stub
		String result = null;
		PDDocument document = null;
		try{
			PDFParser parser = new PDFParser(input);
			parser.parse();
			document = parser.getPDDocument();
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
			return  filterRN(result);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
