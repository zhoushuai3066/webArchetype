package ${package}.utils;

import java.io.UnsupportedEncodingException;

public class StringLenUtils {

	/**
	 * 字符串按字节截取
	 * 
	 * @param str
	 *            原字符
	 * @param len
	 *            截取长度
	 * @return String
	 * @since 2010.07.05
	 */
	public static String splitString(String str, int len) {
		return splitString(str, len, "...");
	}
	
	
	/**
	 * 字符串截取
	 * 
	 * @param str
	 * @param targetCount
	 * @param more
	 * @return
	 */
	public static String subContent(String str, int targetCount, String more) {
		String result = "";
		try {
			//不能使用getBytes(),因为它会使用平台默认的字符集来判断长度，
			//比如utf-8会认为汉字是三个字节
			if (str.getBytes("GBK").length > targetCount) {
				int t = 0;
				char[] tempChar = str.toCharArray();
				for (int i = 0; i < tempChar.length && t < targetCount; i++) {
					// if ((int) tempChar[i] >= 0x4E00
					// && (int) tempChar[i] <= 0x9FA5)// 是否汉字
					if ((int) tempChar[i] > 256) { // 不是英文字母以及数字
						result += tempChar[i];
						t += 2;
					} else {
						result += tempChar[i];
						t++;
					}
				}
				result += more;
			}
			else {
				result = str;//如果长度比需要的长度n小,返回原字符串
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 字符串按字节截取
	 * 
	 * @param str
	 *            原字符
	 * @param len
	 *            截取长度
	 * @param elide
	 *            省略符
	 * @return String
	 * @since 2010.07.05
	 */
	public static String splitString(String str, int len, String elide) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		// int elideLen = (elide.trim().length() == 0) ? 0 :
		// elide.getBytes().length;
		int elideLen = 0;
		if (len >= strLen || len < 1) {
			return str;
		}
		if (len - elideLen > 0) {
			len = len - elideLen;
		}
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;
		}
		return new String(strByte, 0, len) + elide.trim();
	}

	public static String subStr(String str, int num) {
		int max = num;
		try {
			max = trimGBK(str.getBytes("GBK"), num);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int sum = 0;
		if (str != null && str.length() > max) {
			StringBuilder sb = new StringBuilder(max);
			for (int i = 0; i < str.length(); i++) {
				int c = str.charAt(i);
				// if ((c & 0xff00) != 0)
				// sum += 2;
				// else
				sum += 1;
				if (sum <= max)
					sb.append((char) c);
				else
					break;
			}
			return sb.append("...").toString();
		} else
			return str != null ? str : "";
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		if (buf.length < n)
			return buf.length;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}

		return num;
	}

	public static void main(String[] args) {
		System.out.println(splitString("aaaaa周帅帅", 9));
	}
}
