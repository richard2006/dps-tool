package cn.rongcapital.dps.tool.handler.rft;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

import static cn.rongcapital.dps.tool.common.HandleFilter.filterN;

import cn.rongcapital.dps.tool.handler.Handler;

/**
 * RTF file parse
 * 
 * @author lipeng
 *
 *         2016年6月7日
 */
public class RtfHandler implements Handler {

	@Override
	public String doHandle(String path) {
		// TODO Auto-generated method stub
		try (InputStream is = new FileInputStream(path)) {
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
		try{
			DefaultStyledDocument styledDoc = new DefaultStyledDocument();
			new RTFEditorKit().read(input, styledDoc, 0);
			// 提取文本，读取中文需要使用ISO8859_1编码，否则会出现乱码
			String sf = styledDoc.getText(0, styledDoc.getLength());
			byte[] all  = sf.getBytes("ISO8859_1");
			if(all[0] == 10 && all[1] == -96){//处理格式化样本
				for (int i = 0; i < all.length; i++) {
					if((i+1) < all.length){
						//处理特殊字符·
						if (all[i] == -73){
							byte tmp = all[i + 1];
							if(tmp == -56 || tmp == -42 || (all[i-1] != -51 && tmp == -43)){
								all[i] = '.';
							}
						}
						//处理特殊空格： 简历编号
						if(all[i]==-96){
							all[i] =  ' ';
						}
					}
				}
			}
			result = new String(all,"gbk");
			return filterN(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String res = new RtfHandler().doHandle("/home/files/rtf/980.rtf");
		System.out.println("【rtf】 \n" + res);

	}
}
