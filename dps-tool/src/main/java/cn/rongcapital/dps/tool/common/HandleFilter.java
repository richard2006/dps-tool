package cn.rongcapital.dps.tool.common;
/**
 * 
 * @author lipeng
 *
 * 2016年6月7日
 */
public class HandleFilter {
	/**
	 * \r\n to "     "
	 * @param input
	 * @return
	 */
	public static String filterRN(String input){
		return input.replace("\r\n", "     ");
	}
	/**
	 * \n to "     "
	 * @param input
	 * @return
	 */
	public static String filterN(String input){
		return input.replace("\n", "     ");
	}
	/**
	 * special code to replace for RTF
	 * @param input
	 * @return
	 */
	public static String filterRTF(String input){
		return filterN(input).replace("牸蚶嗪� ", "简历编号：").replace("牋", " ");
	}
}
