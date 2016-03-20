package com.exam.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtil {
	private static Logger logger = LogManager.getLogger(FileUtil.class.getName());
	
	public static void saveStioAsFile(String filepath) {
		logger.entry(new Object[]{ filepath});
		try {
			File file = new File(filepath);
			if (file.exists())
				file.delete();
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file), "UTF-8"));
			StringBuffer sb = new StringBuffer();
			bw.write(sb.toString());
		    bw.newLine();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.exit();
	}
	
	public static void makeDirs(String path){
		logger.entry(new Object[]{ path });
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		logger.exit();
	}

	public static boolean deleteFile(String filepath) {
		logger.entry(new Object[]{ filepath });
		boolean flag = false;
		File file = new File(filepath);
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return logger.exit(flag);
	}

	public static String getFileContent(String filepath, String charset) {
		logger.entry(new Object[]{ filepath, charset });
		String filecontent = "";
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(new File(filepath)), charset));
			String s = "";
			while ((s = br.readLine()) != null) {
				filecontent += s + "\n";
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return logger.exit(filecontent);
	}

	public static final boolean CopyFile(File in, File out) throws Exception {
		logger.entry(new Object[]{ in, out });
		try {
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);
			byte[] buf = new byte[1024];
			int i = 0;
			while ((i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
			fis.close();
			fos.close();
			return logger.exit(true);
		} catch (IOException e) {
			e.printStackTrace();
			return logger.exit(false);
		}
	}

	public static String getTypePart(String fileName) {
		logger.entry(new Object[]{ fileName });
		int point = fileName.lastIndexOf('.');
		int length = fileName.length();
		if (point == -1 || point == length - 1) {
			return logger.exit("");
		} else {
			return logger.exit(fileName.substring(point + 1, length));
		}
	}

	public static String getFileType(File file) {
		logger.entry(new Object[]{ file });
		return logger.exit(getTypePart(file.getName()));
	}

	public static int getPathLsatIndex(String fileName) {
		logger.entry(new Object[]{ fileName });
		int point = fileName.lastIndexOf('/');
		if (point == -1) {
			point = fileName.lastIndexOf('\\');
		}
		return logger.exit(point);
	}

	public static int getPathLsatIndex(String fileName, int fromIndex) {
		logger.entry(new Object[]{ fileName,fromIndex });
		int point = fileName.lastIndexOf('/', fromIndex);
		if (point == -1) {
			point = fileName.lastIndexOf('\\', fromIndex);
		}
		return logger.exit(point);
	}

	public static String getNamePart(String fileName) {
		logger.entry(new Object[]{ fileName });
		int point = getPathLsatIndex(fileName);
		int length = fileName.length();
		if (point == -1) {
			return logger.exit(fileName);
		} else if (point == length - 1) {
			int secondPoint = getPathLsatIndex(fileName, point - 1);
			if (secondPoint == -1) {
				if (length == 1) {
					return logger.exit(fileName);
				} else {
					return logger.exit(fileName.substring(0, point));
				}
			} else {
				return logger.exit(fileName.substring(secondPoint + 1, point));
			}
		} else {
			return logger.exit(fileName.substring(point + 1));
		}
	}
}
