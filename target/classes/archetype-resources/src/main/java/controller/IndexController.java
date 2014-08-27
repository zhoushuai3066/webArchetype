package ${package}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 项目首页
 * 
 * @author xinqigu
 * 
 */
@Controller
public class IndexController extends BaseController {

	/** 首页 */
	private static String INDEX_VIEW = "/index.jsp";

	/**
	 * index
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(INDEX_VIEW);

		// 权限获取

		return mav;
	}

}
