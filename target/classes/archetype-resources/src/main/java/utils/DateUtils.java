package ${package}.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String parseHM(String dateStr, String pix) {
		Calendar cal = Calendar.getInstance();
		String result = "";
		Date d = null;
		try {
			d = sdf.parse(dateStr);
			// cal.setTimeZone(value)
			cal.setTime(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parseNumber(cal.get(Calendar.HOUR_OF_DAY)) + pix
				+ parseNumber(cal.get(Calendar.MINUTE));
	}

	public static String parseMD(String dateStr, String pix) {
		String result = "";
		Calendar cal = Calendar.getInstance();
		Date d = null;
		try {
			d = sdf.parse(dateStr);
			cal.setTime(d);
			// System.out.println(cal.get(Calendar.MONTH));
			// System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// cal.
		return cal.get(Calendar.MONTH) + 1 + pix
				+ cal.get(Calendar.DAY_OF_MONTH);
		// return
		// parseNumber(cal.get(Calendar.MONTH)+1)+pix+parseNumber(cal.get(Calendar.DAY_OF_MONTH));
	}

	public static String addDay(int day) {
		Calendar calD = Calendar.getInstance();
		calD.add(Calendar.DAY_OF_MONTH, day);
		return parseMD(sdf.format(calD.getTime()), "-");
	}

	public static Boolean isInRangeDays(String dateStr, int days) {
		Date d = null;
		Long nowDayTimes = getCurrentDayTimeInMillis();
		Long lowDayTimes = nowDayTimes - 24 * 60 * 60 * 1000 * (days);
		try {
			d = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (d.getTime() >lowDayTimes) {
			System.out.println(1);
			if (d.getTime() < nowDayTimes) {
				System.out.println(2);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private static Long getCurrentDayTimeInMillis() {
		Calendar cale = Calendar.getInstance();
		cale.set(Calendar.HOUR, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		long nowt = cale.getTimeInMillis();
		nowt = nowt+24 * 60 * 60 * 1000;
		return nowt;
	}

	private static String parseNumber(int num) {
		if (num < 10) {
			return "0" + num;
		} else {
			return String.valueOf(num);
		}
	}

	/**
	 * 璁＄畻涓や釜鏃ユ湡涔嬮棿鐨勫樊璺濆ぉ鏁�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int cutTwoDateToDay(Date a, Date b) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int theday = 0;
		try {
			Date beginDate = format.parse(format.format(a));
			Date endDate = format.parse(format.format(b));

			calendar.setTime(beginDate);
			long begin = calendar.getTimeInMillis();
			calendar.setTime(endDate);
			long end = calendar.getTimeInMillis();

			theday = (int) ((end - begin) / (86400000));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return theday;
	}

	/**
	 * 灏嗘暟瀛楀瀷鐨勬椂闂磋浆涓哄瓧绗︿覆锛�0 -> 01:20锛�
	 * 
	 * @param time
	 * @return
	 */
	public static String intToTimeString(int time) {
		String hour = String.valueOf(time / 60);
		String minute = String.valueOf(time - time / 60 * 60);

		if (hour.length() < 2) {
			hour = "0" + hour;
		}
		if (minute.length() < 2) {
			minute = "0" + minute;
		}
		return hour + ":" + minute;
	}

	/**
	 * 鍙栧嚭涓や釜鏃堕棿鍑鸿緝澶х殑鏃堕棿
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Date MaxDate(Date a, Date b) {
		if (a.before(b)) {
			return b;
		} else {
			return a;
		}
	}

	/**
	 * 鍙栧嚭涓や釜鏃堕棿鍑鸿緝灏忕殑鏃堕棿
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Date MinDate(Date a, Date b) {
		if (a.before(b)) {
			return a;
		} else {
			return b;
		}
	}

	/**
	 * 璁＄畻缁欏畾鏃ユ湡鏄槦鏈熷嚑
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekOfDate(Date date) {
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
		if (w == 0)
			w = 7;
		return w;
	}

	/**
	 * 鏍煎紡鍖栨棩鏈�
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String formatDate(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	/**
	 * 鏍规嵁缁欏畾鏃ユ湡瀛楃涓插拰鏃ユ湡鏍煎紡 鍒涘缓鏃ユ湡
	 * 
	 * @param dateString
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Date createDate(String dateString, String pattern)
			throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.parse(dateString);
	}

	public static void main(String[] args) {
	   DateUtils du = new DateUtils();
	   long t = du.getCurrentDayTimeInMillis();
	   String str = sdf.format(new Date(t));
	   System.out.println(str);
	   System.out.println(isInRangeDays("20120921100300",3));
	}

}
