package com.exam.utils;

public class Constants {
	private String charset = "UTF-8";
	private FtpConfig ftpConfig;
	private String tempfilesPath = ""; 
	private static Constants application = null;
	
	public static synchronized Constants getInstance() {
		if (application == null)
			application = new Constants();

		return application;
	}

	public String getCharset() {
		return this.charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getTempfilesPath() {
		return tempfilesPath;
	}

	public void setTempfilesPath(String tempfilesPath) {
		this.tempfilesPath = tempfilesPath;
	}

	public FtpConfig getFtpConfig() {
		return ftpConfig;
	}

	public void setFtpConfig(FtpConfig ftpConfig) {
		this.ftpConfig = ftpConfig;
	}

	public static Constants getApplication() {
		return application;
	}

	public static void setApplication(Constants application) {
		Constants.application = application;
	}
	
}