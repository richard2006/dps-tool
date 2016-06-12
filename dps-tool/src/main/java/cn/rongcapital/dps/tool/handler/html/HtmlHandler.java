package cn.rongcapital.dps.tool.handler.html;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import cn.rongcapital.dps.tool.handler.Handler;
/**
 * HTML file parse
 * @author lipeng
 *
 * 2016年6月7日
 */
public class HtmlHandler implements Handler{

	@Override
	public String doHandle(String path) {
		// TODO Auto-generated method stub
		try(InputStream in = new FileInputStream(path)) {
			return doHandle(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String doHandle(InputStream input) {
		// TODO Auto-generated method stub
		try {
			Document doc = Jsoup.parse(input, "gbk","http://dps.dataengine.com/");
			return doc.body().text();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
