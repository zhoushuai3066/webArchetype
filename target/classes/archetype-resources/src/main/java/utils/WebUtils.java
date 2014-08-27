package ${package}.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * web util
 * 
 * @author xinqigu
 */
public final class WebUtils {

	private static final Logger logger = Logger.getLogger(WebUtils.class);

	/** 榛樿缂栫爜UTF-8 */
	private static final String DEFAULT_ENCODING = "UTF-8";

	/**
	 * 鍒ゆ柇鍙傛暟鍒楄〃涓槸鍚︽湁绌哄�
	 * 
	 * @param strArray
	 * @return true:鏈夌┖鍊�false:娌℃湁
	 */
	public boolean isBlankArray(String[] strArray) {
		for (String param : strArray) {
			if (StringUtils.isBlank(param)) {
				logger.info("args exist empty value");
				return true;
			}
		}
		return false;
	}

	/**
	 * Sends the redirect.
	 * 
	 * @param response
	 *            the HttpServletResponse. CANNOT be NULL.
	 * @param url
	 *            the url to redirect to.
	 */
	public static void sendRedirect(final HttpServletResponse response,
			final String url) {
		try {
			response.sendRedirect(url);
		} catch (final Exception e) {
			logger.warn(e.getMessage(), e);
		}
	}

	/**
	 * render text(utf-8)
	 * 
	 * @param response
	 * @param content
	 * @throws Exception
	 */
	public static void renderText(HttpServletResponse response, String content) {
		renderText(response, DEFAULT_ENCODING, content);
	}

	/**
	 * render text
	 * 
	 * @param response
	 * @param content
	 * @param encoding
	 * @throws Exception
	 */
	public static void renderText(HttpServletResponse response,
			String encoding, String content) {
		renderContent(response, "text/plain", encoding, content);
	}

	/**
	 * render html(utf-8)
	 * 
	 * @param response
	 * @param content
	 * @throws Exception
	 */
	public static void renderHtml(HttpServletResponse response, String content) {
		renderHtml(response, DEFAULT_ENCODING, content);
	}

	/**
	 * render html
	 * 
	 * @param response
	 * @param content
	 * @param encoding
	 * @throws Exception
	 */
	public static void renderHtml(HttpServletResponse response,
			String encoding, String content) {
		renderContent(response, "text/html", encoding, content);
	}

	/**
	 * render xml(utf-8)
	 * 
	 * @param response
	 * @param content
	 * @throws Exception
	 */
	public static void renderXML(HttpServletResponse response, String content) {
		renderXML(response, DEFAULT_ENCODING, content);
	}

	/**
	 * render xml
	 * 
	 * @param response
	 * @param encoding
	 * @param content
	 * @throws Exception
	 */
	public static void renderXML(HttpServletResponse response, String encoding,
			String content) {
		renderContent(response, "text/xml", encoding, content);
	}

	/**
	 * render json(utf-8)
	 * 
	 * @param response
	 * @param content
	 * @throws Exception
	 */
	public static void renderJson(HttpServletResponse response, String content) {
		renderJson(response, DEFAULT_ENCODING, content);
	}

	/**
	 * render json
	 * 
	 * @param response
	 * @param encoding
	 * @param content
	 * @throws Exception
	 */
	public static void renderJson(HttpServletResponse response,
			String encoding, String content) {
		renderContent(response, "application/json", encoding, content);
	}

	/**
	 * 鐩存帴鍚戝鎴风杩斿洖Content瀛楃涓诧紝涓嶉�杩囬〉闈㈡覆鏌�	 * 
	 * @param response
	 * @param contentType
	 *            text/xml or text/json or text/html...
	 * @param encoding
	 * @param content
	 */
	public static void renderContent(HttpServletResponse response,
			String contentType, String encoding, String content) {
		PrintWriter out = null;
		try {
			response.setContentType(contentType);
			response.setCharacterEncoding(encoding);
			out = response.getWriter();
			out.print(content);
			out.flush();
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new RuntimeException();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

}
