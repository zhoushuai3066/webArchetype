package ${package}.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ${package}.utils.WebUtils;

/**
 * base controller
 * 
 * @author xinqigu
 */
public class BaseController {

	protected final Logger logger = Logger.getLogger(this.getClass());

	/** google gson parse object util */
	protected static Gson gson = new GsonBuilder().setDateFormat(
			"yyyy-MM-dd HH:mm:ss").create();

	/**
	 * 返回错误提示信息
	 * 
	 * @param response
	 * @param errorCode
	 * @param statusCode
	 */
	public void renderErrorMessage(HttpServletResponse response,
			String errorCode, int statusCode) {
		response.setStatus(statusCode);
		WebUtils.renderJson(response, "{\"error\":\"" + errorCode + "\"}");
	}

	/**
	 * 返回错误提示信息
	 * 
	 * @param response
	 * @param errorCode
	 * @param statusCode
	 */
	public void renderErrorMessage(HttpServletResponse response,
			String errorCode) {
		WebUtils.renderJson(response, "{\"error\":\"" + errorCode + "\"}");
	}

	/**
	 * 返回xml/json信息
	 * @param response
	 * @param result
	 * @param format
	 */
	public void responseResult(HttpServletResponse response, String result,
			String format) {
		if ("json".equals(format)) {
			WebUtils.renderJson(response, result);
		} else if ("xml".equals(format)) {
			WebUtils.renderXML(response, result);
		}
	}

}
