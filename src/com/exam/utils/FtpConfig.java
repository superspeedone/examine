package com.exam.utils;

/**
 * ftp配置信息
 * addr ftp服务器地址
 * port ftp 端口号，默认端口21
 *username  ftp用户名
 *password  ftp密码
 *path 上传到ftp服务器的路径,默认为跟目录
 */

public class FtpConfig {
	String addr;
	int port = 21;
	String username;
	String password;
	String path = "";

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public FtpConfig(){};

	public FtpConfig(String addr, int port, String username, String password,
			String path) {
		super();
		this.addr = addr;
		this.port = port;
		this.username = username;
		this.password = password;
		this.path = path;
	}
	
	public FtpConfig(String addr, int port, String username, String password) {
		super();
		this.addr = addr;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	public FtpConfig(String addr, String username, String password) {
		super();
		this.addr = addr;
		this.username = username;
		this.password = password;
	}

	public FtpConfig(String addr,String username, String password,String path) {
		super();
		this.addr = addr;
		this.username = username;
		this.password = password;
		this.path = path;
	}

}
