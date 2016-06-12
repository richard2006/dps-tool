package cn.rongcapital.dps.tool.handler.doc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hwpf.extractor.WordExtractor;

import static cn.rongcapital.dps.tool.common.HandleFilter.filterRN;
import cn.rongcapital.dps.tool.handler.Handler;
/**
 * DOC file parse
 * @author lipeng
 *
 * 2016年6月7日
 */
public class DocHandler implements Handler {

	@Override
	public String doHandle(String path) {
		// TODO Auto-generated method stub
		try (FileInputStream file = new FileInputStream(path);){
			return doHandle(file);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String doHandle(InputStream input) {
		// TODO Auto-generated method stub
		try(WordExtractor wordExtractor = new WordExtractor(input)){
			String res = wordExtractor.getText();
			return filterRN(res);
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		Handler handler = new DocHandler();
		String res = handler.doHandle("/home/files/word/990.doc");
		System.out.println(res);
		File d = new File("/home/t.txt");
		try (FileWriter w = new FileWriter(d)){
			w.write(res);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
