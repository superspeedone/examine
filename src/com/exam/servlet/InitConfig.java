package com.exam.servlet;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.exam.utils.Constants;
import com.exam.utils.FileUtil;
import com.exam.utils.FtpConfig;
import com.exam.utils.FtpUtil;


public class InitConfig extends HttpServlet {
	private static final long serialVersionUID = 8831528689710446898L;
	
	private Logger logger = LogManager.getLogger(InitConfig.class.getName());

	@Override
	public void init(ServletConfig config) throws ServletException {
		long startTime = new Date().getTime();
		this.logger.info("**************************************");
		this.logger.info(">>>      欢迎使用考试系统");
		this.logger.info("**************************************");
	    super.init(config);
	    this.logger.info("catalina.home=" + System.getProperty("catalina.home"));
	    ServletContext application = config.getServletContext();
	    String webAppFullPath = application.getRealPath("/");
	    this.logger.info("webAppFullPath="+webAppFullPath);
	    String configFile = config.getInitParameter("configFile");
	    String configFilePath = webAppFullPath + configFile;
	    try {
	      this.logger.info("系统正在初始化中 ...");
	      this.logger.info("configFile=" + configFile);
	      DataInputStream inputStream = new DataInputStream(
	        new BufferedInputStream(new FileInputStream(configFilePath)));
	      Properties properties = new Properties();
	      properties.load(inputStream);
	      String charset = properties.getProperty("charset");
	      this.logger.info("charset=" + charset);
	      Constants.getInstance().setCharset(charset);
	      FtpConfig ftpConfig = new FtpConfig();
	      String ftpAddress = properties.getProperty("ftpAddress");
	      ftpConfig.setAddr(ftpAddress);
	      this.logger.info("ftpAddress=" + ftpAddress);
	      String tempfilePath = webAppFullPath.replace("\\", File.separator )+"WEB-INF"+File.separator +"tempfile";
	      Constants.getInstance().setTempfilesPath(tempfilePath);
	      /*if(!new File(tempfilePath).exists()) FileUtil.makeDirs(tempfilePath);
	      this.logger.info("tempfilePath="+tempfilePath);
	      String ftpUser = properties.getProperty("ftpUser");
	      ftpConfig.setUsername(ftpUser);
	      String ftpPwd = properties.getProperty("ftpPwd");
	      ftpConfig.setPassword(ftpPwd);
	      String uploadDrect = properties.getProperty("uploadDrect");
	      if((!uploadDrect.equals("/"))&&(properties.getProperty("uploadDrect")!=null)){
	    	  ftpConfig.setPath(uploadDrect);
	      }
	      Constants.getInstance().setFtpConfig(ftpConfig);
	      inputStream.close();
	      FtpUtil ftpUtil = new FtpUtil();
	      if(ftpUtil.connect(ftpConfig)){
	    	  //this.logger.info("ftp服务器："+ftpAddress+"连接成功！");
	    	  this.logger.info("ftp服务器连接成功！");
	    	  ftpUtil.closeConnect();
	      }*/
	      this.logger.info("系统初始化成功！");
	      this.logger.info("***********************************************");
	    } catch (Exception e) {
	      this.logger.info("系统初始化失败！");
	      this.logger.info("***********************************************");
	    }
	    //系统运行日志代码编写
	    long endTime = new Date().getTime();
	    this.logger.info(">>>     系统启动成功 in "+String.valueOf(endTime-startTime)+" ms");
	}
	
	@Override
	public void destroy() {
	    //系统关闭事件日志编写
	    super.destroy();
	}

}
