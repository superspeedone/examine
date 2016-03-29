package com.exam.utils;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tools
{
  public static void main(String[] args)
    throws ParseException, UnsupportedEncodingException
  {
    System.out.println("字符串转日期，日期转字符串");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse("2014-1-1");
    System.out.println(dateFormat.format(date));
    System.out.println("-------------------------------------------------");
    System.out.println("获取当前系统时间");
    Calendar calendar = Calendar.getInstance();
    System.out.println(dateFormat.format(calendar.getTime()));
    System.out.println("判断日期是否合法");
    String s1 = "2000-02-29";
    String s2 = "2001-02-29";
    System.out.println(s1 + " 日期" + ifThen(isValidDate(s1), "合法", "非法"));
    System.out.println(s2 + " 日期" + ifThen(isValidDate(s2), "合法", "非法"));
    System.out.println("-------------------------------------------------");
    System.out.println("获取中英文字符在各种编码下占据字节数");
    String en = "A";
    String cn = "中";
    String[] charsets = { "UTF-8", "GBK", "GB2312", "ISO-8859-1", 
      "UTF-16BE" };
    System.out.println("默认    A: " + en.getBytes().length);
    System.out.println("默认    B: " + cn.getBytes().length);
    for (int i = 0; i < charsets.length; ++i) {
      System.out.println(charsets[i] + "     " + en + ":  " + 
        en.getBytes(charsets[i]).length);
      System.out.println(charsets[i] + "     " + cn + ": " + 
        cn.getBytes(charsets[i]).length);
    }
    System.out.println("-------------------------------------------------");
    System.out.println("字符串补齐测试");
    System.out.println(rpad("A中", "B华", 6, "UTF-8"));
    System.out.println(rpad("A中", "B华", 6, "GBK"));
    System.out.println(rpad("A中", "B华", 6, ""));
    System.out.println(lpad("A中", "B华", 6, "UTF-8"));
    System.out.println(lpad("A中", "B华", 6, "GBK"));
    System.out.println(lpad("A中", "B华", 6, ""));
    System.out.println("-------------------------------------------------");
  }
  
  public static String doubleTwo(double d){
	  DecimalFormat formatter = new DecimalFormat();
	  formatter.setMaximumFractionDigits(2);
	  return formatter.format(d);
  }
  
  public static String doubleToString(double d){
	  DecimalFormat formatter = new DecimalFormat("0.00");
	  formatter.setMaximumFractionDigits(2);
	  return formatter.format(d);
  }
  
  public static String dateToString(Date d){
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	  return dateFormat.format(d);
  }
  
  public static Date stringToDate(String s) throws ParseException{
	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	  return dateFormat.parse(s);
  }
  
  public static String getCurrency(double d){
	  NumberFormat format = NumberFormat.getCurrencyInstance(Locale.getDefault()); 
	  String s= format.format(d);
	  return s.substring(1, s.length());
  }
  
  public static boolean isMatchs(String regex, String s){
	  Pattern pattern = Pattern.compile(regex);
	  Matcher matcher = pattern.matcher(s);
	  return matcher.matches();
  }

  public static String trim(Object object)
  {
    if (object == null)
      return "";

    return object.toString().trim();
  }

  public static String trim(Object object, String emptyIs)
  {
    String result = trim(object);
    if ("".equals(result))
      return emptyIs;

    return result;
  }

  public static String ifThen(boolean bool, String trueValue, String falseValue)
  {
    if (bool)
      return trueValue;

    return falseValue;
  }

  public static boolean equalsZero(Double amount)
  {
    return (Math.abs(amount.doubleValue()) < 0.01D);
  }

  public static boolean isValidDate(String sDate)
  {
    String datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
    String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

    if (sDate != null) {
      Pattern pattern = Pattern.compile(datePattern1);
      Matcher match = pattern.matcher(sDate);
      if (match.matches()) {
        pattern = Pattern.compile(datePattern2);
        match = pattern.matcher(sDate);
        return match.matches();
      }
      return false;
    }

    return false;
  }

  public static String escapeXml(String xml)
  {
    if (xml == null)
      return "";

    xml = xml.replaceAll("&", "&amp;");
    xml = xml.replaceAll("<", "&lt;");
    xml = xml.replaceAll(">", "&gt;");
    xml = xml.replaceAll("\"", "&quot;");
    xml = xml.replaceAll("'", "&apos;");
    return xml;
  }

  public static String unEscapeXml(String xml)
  {
    if (xml == null)
      return "";

    xml = xml.replaceAll("&amp;", "&");
    xml = xml.replaceAll("&lt;", "<");
    xml = xml.replaceAll("&gt;", ">");
    xml = xml.replaceAll("&quot;", "\"");
    xml = xml.replaceAll("&apos;", "'");
    return xml;
  }

  public static String rpad(String source, String fillStr, int length, String charset)
  {
    StringBuffer sb = new StringBuffer("");
    if (source != null)
      sb.append(source);

    charset = trim(charset);
    if ("".equals(charset))
      charset = "ISO-8859-1";
    try
    {
      if (sb.toString().getBytes(charset).length >= length)
        return sb.toString();

      if (fillStr == null)
        return sb.toString();

      if (fillStr.toString().getBytes(charset).length <= 0)
        return sb.toString();

      int x = (length - sb.toString().getBytes(charset).length) / 
        fillStr.toString().getBytes(charset).length;
      for (int i = 0; i < x; ++i)
        sb.append(fillStr);

      for (int i = 0; i < fillStr.length(); ++i) {
        String chr = fillStr.substring(i, i + 1);

        if (sb.toString().getBytes(charset).length + 
          chr.getBytes(charset).length <= length)
          sb.append(chr);
        else
          return sb.toString();
      }
    }
    catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      return source;
    }
    return sb.toString();
  }

  public static String lpad(String source, String fillStr, int length, String charset)
  {
    if (source == null)
      return rpad("", fillStr, length, charset);

    charset = trim(charset);
    if ("".equals(charset))
      charset = "ISO-8859-1";
    try
    {
      return 
        rpad("", fillStr, length - 
        source.getBytes(charset).length, charset) + 
        source;
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace(); }
    return source;
  }

  public static String formatPrecision(double number, int precision)
  {
    StringBuilder sb = new StringBuilder(lpad("0", "#", 
      String.valueOf(number).length(), ""));
    if (precision > 0) {
      sb.append(".");
      for (int i = 0; i < precision; ++i)
        sb.append("0");
    }

    return new DecimalFormat(sb.toString()).format(number);
  }
}