package cn.rongcapital.dps.tool.handler.doc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import static cn.rongcapital.dps.tool.common.HandleFilter.filterN;
import cn.rongcapital.dps.tool.handler.Handler;
/**
 * docx file parse
 * @author lipeng
 *
 * 2016年6月7日
 */
public class DocxHandler implements Handler {

	@Override
	public String doHandle(String path) {
		// TODO Auto-generated method stub
		XWPFWordExtractor extractor = null;
		try (InputStream is = new FileInputStream(path)){
			return doHandle(is);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(extractor != null)
				try {
					extractor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}

	@Override
	public String doHandle(InputStream input) {
		// TODO Auto-generated method stub
		String res = "";
		XWPFWordExtractor extractor = null;
		try{
			XWPFDocument doc = new XWPFDocument(input);
			extractor = new XWPFWordExtractor(doc);
			res = extractor.getText().trim();
			return filterN(res);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(extractor != null)
				try {
					extractor.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return null;
	}


}
