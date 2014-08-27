package ${package}.utils;

public class NumberUtils {

	public static StringBuffer sb = new StringBuffer();

	/**
	 * 鏁板瓧鐨勪綅鏁颁笉瓒虫寚瀹氫綅鏁�鍒欏湪鍓嶉潰琛�
	 * 
	 * @param num
	 *            鏁板瓧
	 * @param len
	 *            浣嶆暟
	 * @return
	 */
	public static String getIndexNumber(String num, int len, String prx) {
		sb.delete(0, sb.length());
		int numlen = num.length();
		if (numlen < len) {
			int count = len - numlen;
			while (count > 0) {
				sb.append(prx);
				count--;
			}
			sb.append(num);
			return sb.toString();
		} else {
			return num;
		}

	}

	public static void main(String[] args) {
		System.out.println("221".length());
	}
}
