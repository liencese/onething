package com.linewell.gg.util;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.Clob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <p>
 * 		字符串操作辅助性工具类。
 * </p>
 * 
 * @author 文件创建者姓名:张建辉 zjianhui@linewell.com
 * @version 1.0.0 date:
 * <p>
 *      Copyright (c) Jul 10, 2011 Linewell.com
 * </p>
 */
public class StrUtil {
	
	/**
	 * 功能：格式化空字符串
	 * 
	 * @param str
	 * @return String
	 */
	public static String formatNull(Object str) {
		return null == str || "null".equals(str) ? "" : str.toString();
	}

	/**
	 * 功能：格式化空字符串,为空时返回默认字符串
	 * 
	 * @param str			原字符串
	 * @param defaultStr	默认字符串
	 * @return String
	 */
	public static String formatNull(String str,String defaultStr) {
		String retStr = "";
		if(!StrUtil.isNull(str)){
			retStr = str;
		}else if(!StrUtil.isNull(defaultStr)){
			retStr = defaultStr;
		}
		return retStr;
	}

	/**
	 * 功能：判断字符串是否为空
	 * 
	 * @param str
	 * @return boolean
	 */
	public static boolean isNull(String str) {
		return null == str || "".equals(str) || "null".equals(str);
	}

	/**
	 * 将String转换成byte数组
	 * 
	 * @param str
	 * @return String
	 */
	public static byte[] stringToByte(String str,String encoding) {
		byte[] result = null;
		try {
			encoding = StrUtil.isNull(encoding) ? "GBK" : encoding;
			result = str.getBytes(encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将byte数组转换成String
	 * 
	 * @param bytes
	 * @return String
	 */
	public static String byteToString(byte[] bytes,String encoding) {
		String result = null;
		try {
			encoding = StrUtil.isNull(encoding) ? "GBK" : encoding;
			result = new String(bytes, encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 把一维数组转换成以split为分隔的字符串
	 * 
	 * @param arrays
	 * @param split
	 * @return String
	 */
	public static String arrayToString(String[] arrays, String split) {
		StringBuffer sb = new StringBuffer();
		if (null != arrays && arrays.length > 0) {
			for (int i = 0; i < arrays.length; i++) {
				sb.append((i == 0 ? "" : split) + arrays[i]);
			}
		}
		return sb.toString();
	}

	/**
	 * 把以split为分隔的字符串转换成一维数组
	 * 
	 * @param arrays
	 * @param split
	 * @return String
	 */
	public static String arrayToString(String[][] arrays, String split) {
		String result = "";
		if (null != arrays && arrays.length > 0) {
			for (int i = 1; i < arrays.length; i++) {
				for(int m=0;m<arrays[i].length;m++){
					result += (StrUtil.isNull(result) ? "" : split) + arrays[i][m];
				}
			}
		}
		return result;
	}

	/**
	 * 如果文本中有xml的实体字符，则要采用CDATA的方式输出
	 * 
	 * @param in
	 *            传入的文本
	 * @return 输出的处理结果文本
	 */
	public static String formatXMLValue(String in) {
		if (null == in || in.equals("")) {
			return in;
		}
		if (in.indexOf('>') >= 0 || in.indexOf('<') >= 0 || in.indexOf('&') >= 0) {
			char[] chars1 = new char[1];
			chars1[0] = 91;
			char[] chars2 = new char[1];
			chars2[0] = 93;
			return "<!" + new String(chars1) + "CDATA" + new String(chars1)
					+ " " + in + " " + new String(chars2) + new String(chars2)
					+ ">";
		} else{
			return in;
		}
	}

	/**
	 * 把字符串里出现的", <,>,&等特殊字符转换成标准可识别的字符 如字符串中包括 <,会转换成 &lt;
	 */
	public static String formatXMLAttribute(String str) {
		if (null == str || str.equals("")) {
			return str;
		}
		String[] src = { "<", ">", "\"", "'", "&" };
		String[] des = { "&lt;", "&gt;", "&quot", "&apos", "&amp;" };
		String result = str;
		for (int i = 0; i < src.length; i++) {
			result = result.replaceAll(src[i], des[i]);
		}
		return result;
	}

	/**
	 * 将分隔符的字符串转化为List对象
	 * 
	 * @param str
	 *            String-传入的分隔符字符串
	 * @param split
	 *            String-分隔符
	 * @return List对象
	 */
	public static List<String> stringToList(String str, String split) {
		List<String> list = null;
		if (!StrUtil.isNull(str)) {
			String args[] = str.split(split);
			list = Arrays.asList(args);
		}
		return list;
	}

	/**
	 * 将分隔符的字符串转化为String一维数组对象
	 * 
	 * @param str
	 *            String-传入的分隔符字符串
	 * @param split
	 *            String-分隔符
	 * @return String一维数组对象
	 */
	public static String[] stringToArray(String str, String split) {
		String array[] = new String[0];
		if (!StrUtil.isNull(str)) {
			array = str.split(split);
		}
		return array;
	}

	/**
	 * 将列表转换成以指定分隔符的字符串
	 * 
	 * @param list :
	 *            List<String> - 含有字符串元素的列表
	 * @param split :
	 *            String - 分隔符
	 * @return String - 以指定分隔符的字符串
	 */
	public static String listToString(final List<String> list, final String split) {
		String str = "";
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				str += (0 == i ? "" : split) + list.get(i);
			}
		}
		return str;
	}

	/**
	 * 判断一个字符串是否是正整数
	 * 
	 * @return true or false
	 */
	public static boolean isPositiveInteger(String num) {
		Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
		Matcher isNum = pattern.matcher(num);
		return isNum.matches();
	}

	/**
	 * 判断一个字符串是否是负整数
	 * 
	 * @return true or false
	 */
	public static boolean isNegativeInteger(String num) {
		Pattern pattern = Pattern.compile("^-[0-9]*[1-9][0-9]*$");
		Matcher isNum = pattern.matcher(num);
		return isNum.matches();
	}

	/**
	 * 判断一个字符串是不是由整数组成的
	 * 
	 * @return true or false
	 */
	public static boolean isNumber(String num) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher isNum = pattern.matcher(num);
		return isNum.matches();
	}

	/**
	 * 将字符串中的中文数字转换成阿拉伯数字
	 * 
	 * @param s      
	 * @return String
	 */
	public static String chineseToNumber(String s) {
		char[] chars = s.toCharArray();
		char[] chineseNum = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chineseNum.length; j++) {
				if (chars[i] == chineseNum[j]) {
					chars[i] = String.valueOf(j).charAt(0);
				}
			}
		}
		return new String(chars);
	}

	/**
	 * 将字符串中的阿拉伯数字转换成中文数字
	 * 
	 * @param s
	 * @return String
	 */
	public static String numberToChinese(String s) {
		char[] chars = s.toCharArray();
		char[] chineseNum = new char[] { '零', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chineseNum.length; j++) {
				if (chars[i] == j) {
					chars[i] = chineseNum[j];
				}
			}
		}
		return new String(chars);
	}

	/**
	 * 将字符串中的汉字转换成拼音
	 * 
	 * @param cnStr
	 *            汉字字符串
	 * @param type
	 *            类型：1.全拼 2.拼音首字母
	 * @return String
	 */
	public static String chineseToPinYin(String cnStr, int type) {
		if (isNull(cnStr)) {
			return cnStr;
		}
		
		HanyuPinyinOutputFormat outputFormat = new HanyuPinyinOutputFormat();
		outputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		outputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		cnStr = StringUtils.deleteWhitespace(cnStr);
		char[] chars = cnStr.toCharArray();
		StringBuffer pinyinStr = new StringBuffer();
		for (int i = 0; i < chars.length; i++) {
			try {
				String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(chars[i], outputFormat);
				if (pinyinArray != null) {
					if (type == 1) {
						pinyinStr.append(StringUtils.join(pinyinArray, ""));
					} else {
						pinyinStr.append(pinyinArray[0].charAt(0));
					}
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}
		}
		return pinyinStr.toString();
	}

	/**
	 * 为字符串后面不足补0
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @param length
	 *            补零后的总长度
	 * @param type
	 *            类型：1.往前补0 2.往后补0
	 * @return 长度为length的补零后的字符串
	 */
	public static String fillZero(String str, int length, int type) {
		String code = "";
		for (int i = 0; i < length; i++) {
			code = code + "0";
		}

		if (type == 1) {
			code = code.substring(str.length()) + str;
		} else {
			code = str + code.substring(str.length());
		}
		return code;
	}
	
	/**
	 * 为字符串后面不足补a
	 * 
	 * @param str
	 *            需要处理的字符串
	 * @param length
	 *            补零后的总长度
	 * @param type
	 *            类型：1.往前补a 2.往后补a
	 * @param chars
	 *            类型：字符
	 * @return 长度为length的补零后的字符串
	 */
	public static String fillChar(String str, int length, int type,String chars) {
		String code = "";
		for (int i = 0; i < length; i++) {
			code = code + chars;
		}

		if (type == 1) {
			code = code.substring(str.length()) + str;
		} else {
			code = str + code.substring(str.length());
		}
		return code;
	}

	/**
	 * 
	 * 功能说明:将1,2,3字符串转换成'1','2','3'
	 * @param id  -源字符串
	 * @param split-字符串分割符
	 * @return
	 * String
	 * @author chh
	 * @Jun 28, 2012
	 */
	public static String toSqlIds(String id,String split){
		if(StrUtil.isNull(id)) return "''";
		String[] ids =id.split(split);
		StringBuffer sb =new StringBuffer();
		for(int i=0;i<ids.length;i++){
			sb.append((i == 0 ? "" : ",") + ("'" + ids[i] + "'"));
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * 功能说明：将Object对象转化成String对象
	 * @param value
	 * @return String
	 * @author chh
	 * @Sep 27, 2012
	 */
	public static String objectToString(Object value){
		String strValue;
		if (value == null) {
			strValue = null;
		} else if (value instanceof String) {
			strValue = (String) value;
		} else if (value instanceof Integer) {
			strValue = ((Integer) value).toString();
		} else if (value instanceof Long) {
			strValue = ((Long) value).toString();
		} else if (value instanceof Float) {
			strValue = ((Float) value).toString();
		} else if (value instanceof Double) {
			strValue = ((Double) value).toString();
		} else if (value instanceof Boolean) {
			strValue = ((Boolean) value).toString();
		} else if (value instanceof Date) {
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间格式
			format.setTimeZone(TimeZone.getTimeZone("GMT+8"));// 时区格式
			strValue = format.format((Date) value);
		} else {
			strValue = value.toString();
		}
		return strValue;
	}
	
	/**
	 * 判断数组中是否包含指定字符串
	 * 
	 * @param array	字符串数据
	 * @param value 指定的字符串
	 * @return 包含则返回true,不包含返回false
	 */
	public static boolean isArrayHasValue(String [] array,String value){
		for(int i=0;i<array.length;i++){
			if(array[i].equals(value))return true;
		}
		return false;
	}
	
	/**
	 * 从表达式中提取参数
	 * 
	 * @param expression	表达式
	 * @param regExp		参数的匹配格式(正则表达式)
	 * @return				匹配的参数名称(多个参数用","分格)
	 */
	public static String getPramsFromExpression(String expression,String regExp){
		String result = "";
		if (!StrUtil.isNull(expression)) {				
			Pattern p = Pattern.compile(regExp);
			Matcher m = p.matcher(expression);
			while (m.find()) {
				String param = m.group(1);
				if(!StrUtil.isNull(param) && result.indexOf(param) < 0){//过滤重复的参数
					result += (StrUtil.isNull(result) ? "" : ",") + param;
				}
			}
		} 
		return result;
	}
	
	/**
	 * 判断当前字段串是否为json对象
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isJSONObject(String str){
		boolean result = false;
		if(!isNull(str)){
			result = str.trim().startsWith("{") && str.trim().endsWith("}");
			//result = result && str.contains(":");
		}
		return result;
	}
	
	/**
	 * 判断当前字段串是否为json数组
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isJSONArray(String str){
		boolean result = false;
		if(!isNull(str)){
			result = str.trim().startsWith("[") && str.trim().endsWith("]");
			//result = result && str.contains("{") && str.contains("}");
			//result = result && str.contains(":");
		}
		return result;
	}

	/**
	 * 获取json对象的属性值
	 * 
	 * @param jsonObj
	 * @return
	 */
	public static String getJsonAttributeValue(JSONObject jsonObj, String attributeName){
		String value = "";
		if(jsonObj.containsKey(attributeName)){
			value = jsonObj.getString(attributeName);
		}else{
			Iterator<?> it = jsonObj.entrySet().iterator(); 
			while (it.hasNext()) { 
				Entry<?, ?> entry = (Entry<?, ?>) it.next(); 
				value = entry.getValue().toString(); //获取第一个属性的值
				break;
			}
		}
		return value;
	}
	
	/***
     * 按字节数截取字符串, 不能截出半个汉字, 如果是半个汉字则舍去!
     * @param source
     * @param byteCount
     * @return
     */
    public static String cutString(String source, int byteCount) {
        byte[] byteArr = source.getBytes();
        int count = 0;
        // 统计要截取的那部分字节中负数的个数
        for (int i = 0; i < byteCount; i++) {
            if (byteArr[i] < 0) {
                count++;
            }
        }
        // 负数成对出现 则不会出现半个汉字
        if (count % 2 == 0)
        	// 负数个数不是偶数，则有半个汉字
            return new String(byteArr, 0, byteCount);
        else
        	return new String(byteArr, 0, byteCount - 1);
    }
    
    public static void main(String[] args) {
    	System.out.println(cutString("我aabc中国cccr", 6));
    }
    
}