package cn.rongcapital.dps.tool.handler.rft;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;

public class RTFExtractor {
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		String result = null;
		try (InputStream is = new FileInputStream(new File("/home/files/rtf/983.rtf"));) {
			DefaultStyledDocument styledDoc = new DefaultStyledDocument();
			new RTFEditorKit().read(is, styledDoc, 0);
			// 提取文本，读取中文需要使用ISO8859_1编码，否则会出现乱码
//			byte[] ttd = styledDoc.getText(0, styledDoc.getLength()).getBytes("ISO-8859-1");
//			System.out.println(Arrays.toString(ttd));
//			// System.out.println(styledDoc.getText(0, styledDoc.getLength()));
//			byte[] tttt = styledDoc.getText(0, 2).getBytes("ISO8859_1");
//			System.out.println(Arrays.toString(tttt));
//			result = new String(tttt, "gb2312");
//			System.out.println(result);
			String sf = styledDoc.getText(0, styledDoc.getLength());
//			sf = sf.replace("·", ".").replace("", " ").replace("、", ",");
			byte[] all = sf.getBytes("ISO8859_1");
			System.out.println(Arrays.toString(all));
			if(all[0] == 10 && all[1] == -96){
				for (int i = 0; i < all.length; i++) {
//					result = new String(all[i], "gbk");
					// if(all[i] == -96) all[i]=' ';

//					byte m = all[i];
//					byte b = all[i++];// 获得字节
//					// boolean flag=Math.isChinese(b, m);//判断是否是中文
					if((i+1) < all.length){
						if (all[i] == -73){
							byte tmp = all[i + 1];
							if(tmp == -56 || tmp == -42 || (all[i-1] != -51 && tmp == -43)){
								all[i] = '.';
							}
						}
//						if (all[0] == 10 && all[1] == -96){
//							all[0] = all[1] = ' ';
//						}
						if(all[i]==-96){
							all[i] =  ' ';
						}
//						if (all[0] == 10 && all[1] == -96){
//							byte[] o = new byte[2];
//							o[0] = all[i + 2];
//							o[1] = all[i + 3];
//							short c = (short) (((all[i] & 0xFF) << 8) | (all[i + 1] & 0xFF));
//							 System.out.println(all[i + 1] + ">>>" + c + ">>>" + new String(o,"gbk") +">>>>>>" + isChineseChar(new String(o,"gbk")));
//////							if(isChineseChar(new String(o,"gbk")){
////							 all[i] = '.';
//						}
					}
				}
			}
			
			System.out.println(Arrays.toString(all));
			result = new String(all, "gbk");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	 public static boolean isChineseChar(String str){
	       boolean temp = false;
	       Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
	       Matcher m=p.matcher(str); 
	       if(m.find()){ 
	           temp =  true;
	       }
	       return temp;
	   }
	 public static void testChar(char c) throws Exception  
	    {  
	        //char c = '中';  
	        System.out.println( c );  
	        System.out.println( (int)c );  
	        System.out.println( Integer.toHexString(c) );  
	        if(c>255)  
	        {  
	            byte low = (byte)(c / 256);  
	            byte hight = (byte)(c % 256);  
	            System.out.println( getHex(low) );  
	            System.out.println( getHex(hight) );  
	        }  
	    }  
	  public static String getHex(byte b)  
	    {  
	        String hex = Integer.toHexString(b & 0xff);  
	        if(hex.length()==1)  
	        {  
	            hex = "0" + hex;  
	        }  
	        return hex;  
	    }  
	  
}
