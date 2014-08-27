package ${package}.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

public class UrlUtils {

	private static final Logger logger = Logger.getLogger(UrlUtils.class);

	/** 榛樿缂栫爜UTF-8 */
	private static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * url encoding
	 * 
	 * @param url
	 * @return url encoder value
	 */
	public static String urlEncoder(String url) {
		try {
			return URLEncoder.encode(url, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * url encoding
	 * 
	 * @param url
	 * @param coding
	 * @return url encode value
	 */
	public static String urlEncoder(String url, String coding) {
		try {
			return URLEncoder.encode(url, coding);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Constructs the URL
	 * 
	 * @param targetUrl
	 *            url鍦板潃
	 * @param params
	 *            鍙傛暟map
	 * @return url
	 */
	public static String constructUrl(final String targetUrl,
			final Map<String, String> params) {
		StringBuffer suf = new StringBuffer();
		try {
			suf.append(URLEncoder.encode(targetUrl, "UTF-8"));
			Iterator<String> itr = params.keySet().iterator();
			String key = null;
			while (itr.hasNext()) {
				key = itr.next();
				if (targetUrl.indexOf("?") != -1) {
					suf.append("?");
				} else {
					suf.append("&");
				}
				suf.append(key).append("=").append(params.get(key));
			}

		} catch (final UnsupportedEncodingException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException(e);
		}
		return suf.toString();
	}

	/**
	 * httpcliet璋冪敤url杩炴帴鑾峰彇鍝嶅簲鍊�
	 * 
	 * @param url
	 * @return request string
	 */
	// public static String callUrl(String url) {
	// String message = null;
	// HttpClient client = null;
	// HttpMethod method = null;
	// ByteArrayOutputStream buf = null;
	// InputStream in = null;
	// try {
	// client = new HttpClient();
	// client.setTimeout(60000);
	// method = new GetMethod(url);
	// method.setRequestHeader("Connection", "close");// 娉ㄦ剰杩欒蹇呴』鍐欙紝鍚﹀垯涓嶈嚜鍔ㄥ叧闂繛鎺�
	// method.getParams().setParameter(
	// HttpMethodParams.HTTP_CONTENT_CHARSET, "GBK");
	// client.executeMethod(method);
	// if (method.getStatusCode() == HttpStatus.SC_OK) {
	// buf = new ByteArrayOutputStream();
	// in = method.getResponseBodyAsStream();
	// int b = -1;
	// while ((b = in.read()) != -1) {
	// buf.write(b);
	// }
	// buf.flush();
	// message = buf.toString();
	// }
	// } catch (Exception e) {
	// logger.error("cal " + url + " error, cause "
	// + e.getMessage());
	// throw new RuntimeException();
	// } finally {
	// if (in != null) {
	// try {
	// in.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// if (buf != null) {
	// try {
	// buf.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	// if (method != null) {
	// method.releaseConnection();
	// }
	// }
	// return message;
	// }

}
