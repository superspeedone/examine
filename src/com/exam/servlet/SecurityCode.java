package com.exam.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 登陆验证码
 * @author Administrator
 *
 */

public class SecurityCode extends HttpServlet {
	private static final long serialVersionUID = 5717139319301372165L;
	private Logger logger = LogManager.getLogger(SecurityCode.class.getName());

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int height = 35, width = 100;
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bi.getGraphics();
		graphics.setColor(new Color(200, 150, 255));
		graphics.fillRect(0, 0, width, height);
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWSYZ1234567890".toCharArray();
		Random r = new Random();
		// 随机产生80点，使图象中的认证码不易被其它程序探测到
		graphics.setColor(new Color(r.nextInt(125), r.nextInt(125), r
				.nextInt(125)));
		for (int i = 0; i < 80; i++) {
			int x = r.nextInt(width);
			int y = r.nextInt(height);
			graphics.drawLine(x, y, x + r.nextInt(2), y + r.nextInt(2));
		}
		// 随机生成不同的字体、字体样式和字体大小
		String[] fontName = { "微软雅黑", "Viner Hand ITC", "黑体",
				"Segoe script PRISTINA", "Georgia", "Verdana", "Arial",
				"Comic Sans MS", "Lucida Console", };
		int len = ch.length, index;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			// 产生随机字体颜色
			graphics.setColor(new Color(r.nextInt(125), r.nextInt(125), r.nextInt(125)));
			// 产生随机字体
			graphics.setFont(new Font(fontName[r.nextInt(fontName.length - 1)], Font.BOLD, 20));
			// 绘制随机大小写字母和数字
			if (r.nextInt(2) == 1) {
				graphics.drawString(ch[index] + "", (i * (r.nextInt(5) + 13)) + 13, 25);
			} else {
				graphics.drawString((ch[index] + "").toLowerCase(), (i * 18) + 13, 25);
			}
			sb.append(ch[index]);
		}
		logger.info(sb.toString());
		request.getSession().setAttribute("SecCode", sb.toString());
		ImageIO.write(bi, "png", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void init() throws ServletException {}

	public void destroy() {
		super.destroy();
	}

}
