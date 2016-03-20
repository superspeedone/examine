package com.exam.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FtpUtil {
	private Logger logger = LogManager.getLogger(FtpUtil.class.getName());
	public static final int BINARY_FILE_TYPE = FTPClient.BINARY_FILE_TYPE; 
	private FTPClient ftpClient;
	
	public  boolean connect(FtpConfig config) throws SocketException, IOException {
		this.logger.entry(new Object[]{ config });
		boolean result = false;
		ftpClient = new FTPClient();
		int reply;  //连接成功后的响应码
		ftpClient.connect(config.getAddr(), config.getPort());
		ftpClient.login(config.getUsername(), config.getPassword());
		ftpClient.setFileType(BINARY_FILE_TYPE);   //设置传输文件类型
		ftpClient.setBufferSize(1024);     //设置上传缓存大小
    	ftpClient.setControlEncoding("UTF-8");     //设置编码
		reply = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {  //如果没有连接成功，就断开连接
			ftpClient.disconnect();
			return result;
		}
		String path = config.getPath();
		if(!ftpClient.changeWorkingDirectory(path)){  //切换到指定路径，如果路径不存在则切换不成功，返回false
			ftpClient.mkd(path);        //创建文件夹
			ftpClient.changeWorkingDirectory(path);
		}
		result = true;
		return this.logger.exit(result);
	}
	
	/**
     * 关闭连接
     * @throws IOException
     */
    public void closeConnect() throws IOException {
    	this.logger.entry(new Object[]{ this.ftpClient });
        if (ftpClient!=null&&ftpClient.isConnected()) {  
        	ftpClient.logout();
            ftpClient.disconnect();
        }  
        this.logger.exit();
    }

    /**
     * 上传文件到ftp服务器，上传新的文件名称和原名称一样
     * @param localFile：本地文件
     * @return
     * @throws IOException
     */
	public  boolean upload(File localFile) throws IOException {
		this.logger.entry(new Object[]{ localFile });
		if(!localFile.exists()) 
			this.logger.error("FileNotFound");
		boolean flag = false;  
        InputStream in = null;  
        try {  
        	in = new FileInputStream(localFile.getPath());  
            flag = ftpClient.storeFile(localFile.getName(), in);  
        } catch (IOException e) {  
            flag = false;  
            return this.logger.exit(flag);
        } finally {  
            if (in != null) {  
            	in.close();  
            }  
        }  
        return this.logger.exit(flag);
	}
	
	/**
     * 从ftp服务器上下载文件到本地
     * @param remoteFileName：ftp服务器上文件名称
     * @param localFileName：本地文件名称
     * @return
     * @throws IOException
     */
    public boolean download(String remoteFileName, String localFileName)  
            throws IOException { 
    	this.logger.entry(new Object[]{ remoteFileName, localFileName });
        boolean flag = false;  
        File outfile = new File(localFileName);  
        OutputStream oStream = null;  
        try {  
            oStream = new FileOutputStream(outfile);  
            flag = ftpClient.retrieveFile(remoteFileName, oStream);  
        } catch (IOException e) {  
            flag = false;  
            return this.logger.exit(flag);  
        } finally {  
            oStream.close();  
        }  
        return this.logger.exit(flag);  
    }
    
    /**
     * 从ftp服务器上下载文件到本地
     * @param sourceFileName：服务器资源文件名称
     * @return InputStream 输入流
     * @throws IOException
     */
    public InputStream downFile(String sourceFileName) throws IOException {  
    	this.logger.entry(new Object[]{ sourceFileName });
        return this.logger.exit(ftpClient.retrieveFileStream(sourceFileName));  
    }
	
	 /**
     * 检查目录在服务器上是否存在 true：存在  false：不存在
     * @param path
     * @return
     * @throws IOException
     */
    public boolean existDirectory(String path) throws IOException {
    	this.logger.entry(new Object[]{ path});
        boolean flag = false;  
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);  
        for (FTPFile ftpFile : ftpFileArr) {  
            if (ftpFile.isDirectory()  
                    && ftpFile.getName().equalsIgnoreCase(path)) {  
                flag = true;  
                break;  
            }  
        }  
        return this.logger.exit(flag);  
    }  
    
    /**
     * 在服务器上创建目录
     * @param pathName
     * @return
     * @throws IOException
     */
    public boolean createDirectory(String pathName) throws IOException { 
    	this.logger.entry(new Object[]{ pathName });
        return this.logger.exit(ftpClient.makeDirectory(pathName));  
    }  
    
    /**
     * 在服务器上删除目录
     * @param path
     * @return
     * @throws IOException
     */
    public boolean removeDirectory(String path) throws IOException {
    	this.logger.entry(new Object[]{ path });
        return this.logger.exit(ftpClient.removeDirectory(path));  
    }
    
    /**
     * 删除服务器上的文件
     * @param pathName
     * @return
     * @throws IOException
     */
    public boolean deleteFile(String pathName) throws IOException {
    	this.logger.entry(new Object[]{ pathName });
        return this.logger.exit(ftpClient.deleteFile(pathName));  
    }
    
    /**
     * 删除所有文件和目录
     * @param path
     * @param isAll true:删除所有文件和目录
     * @return
     * @throws IOException
     */
    public boolean removeDirectory(String path, boolean isAll)  
            throws IOException {  
        this.logger.entry(new Object[]{ path, isAll });
        if (!isAll) {  
            return this.logger.exit(removeDirectory(path));  
        }  
  
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);  
        if (ftpFileArr == null || ftpFileArr.length == 0) {  
        	return this.logger.exit(removeDirectory(path));
        }  
        //   
        for (FTPFile ftpFile : ftpFileArr) {  
            String name = ftpFile.getName();  
            if (ftpFile.isDirectory()) {  
            	System.out.println("* [sD]Delete subPath ["+path + "/" + name+"]");               
                removeDirectory(path + "/" + name, true);  
            } else if (ftpFile.isFile()) {  
            	System.out.println("* [sF]Delete file ["+path + "/" + name+"]");                          
                deleteFile(path + "/" + name);  
            } else if (ftpFile.isSymbolicLink()) {  
  
            } else if (ftpFile.isUnknown()) {  
  
            }  
        }  
        return this.logger.exit(removeDirectory(path));
    } 
    
	public static void main(String[] args) {
		try {
			FtpUtil t = new FtpUtil();
			//下载不需要修改路径（默认为根路径）
			FtpConfig config = new FtpConfig("192.168.0.163","fdwz", "fdwz","/FDWZ/000");
			t.connect(config);
			File file = new File("d:\\suda_eam_pledge.doc");
			boolean uploadFlag = t.upload(file);
			if(uploadFlag){
				System.out.println("上传成功！");
			}else {
			    System.out.println("上传失败！");
			}
			/*boolean downloadFlag = t.download("test\\result.txt", "C:\\Users\\Administrator\\Desktop\\result.txt");
			if(downloadFlag){
				System.out.println("下载成功！");
			}else {
				System.out.println("下载失败！");
			}*/
			t.closeConnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
