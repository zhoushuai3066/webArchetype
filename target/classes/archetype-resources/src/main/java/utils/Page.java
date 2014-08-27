package ${package}.utils;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

	/**
	 * 褰撳墠椤垫暟
	 */
	private int currentPage = 0;

	/**
	 * 鎬昏褰曟暟
	 */
	private int count = 0;

	/**
	 * 姣忛〉鏄剧ず鏁�
	 */
	private int pageSize = 0;

	public List<T> getCurrentPageList(List<T> ls) {
		int start = (currentPage - 1) * pageSize;
		List<T> result = new ArrayList<T>();
		int count = pageSize;
		for (int i = start; i < ls.size(); i++) {
			if (count > 0) {
				result.add(ls.get(i));
				count--;
			}
		}
		return result;
	}

	/**
	 * 褰撳墠椤垫暟鎹�
	 */
	private List<T> list = new ArrayList<T>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
