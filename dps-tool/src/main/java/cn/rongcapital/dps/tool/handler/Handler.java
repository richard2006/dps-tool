package cn.rongcapital.dps.tool.handler;

import java.io.InputStream;

public interface Handler {
	/**
	 * file parse hadnler
	 * @param path
	 * @return
	 */
	public String doHandle(String path);
	/**
	 * file parse hadnler
	 * @param path
	 * @return
	 */
	public String doHandle(InputStream input);

}
