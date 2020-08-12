package com.future.serviceribbon.service;

/**
 * @author Simon
 */
public interface HelloRibbonService {

	/**
	 * 默认服务者ID
	 * @param name
	 * @return
	 */
	String hiService(String name);

	/**
	 * 自定义服务者ID
	 * @param client
	 * @param name
	 * @return
	 */
	String hiService(String client, String name);

}
