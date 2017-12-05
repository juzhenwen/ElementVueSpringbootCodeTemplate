package cn.xiaowenjie.common.beans;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.StringUtils;

import lombok.Data;

/**
 * 分页请求参数
 * 
 * @author 肖文杰 https://github.com/xwjie/
 *
 */
@Data
public class PageReq {

	private int page = 1;

	private int pagesize = 10;

	private String sortfield = "";

	private String sort = "";

	private String keyword = "";

	public PageReq() {
		super();
	}

	public PageReq(int page, int pagesize, String sortfield, String sort,
			String keyword) {
		super();
		this.page = page;
		this.pagesize = pagesize;
		this.sortfield = sortfield;
		this.sort = sort;
		this.keyword = keyword;
	}

	public PageReq getPageable() {
		return new PageReq(page, pagesize, sortfield, sort, keyword);
	}

	public Pageable toPageable() {
		// pageable里面是从第0页开始的。
		Pageable pageable = null;

		if (StringUtils.isEmpty(sortfield)) {
			pageable = new PageRequest(page - 1, pagesize);
		}
		else {
			pageable = new PageRequest(page - 1, pagesize,
					sort.toLowerCase().startsWith("desc") ? Direction.DESC
							: Direction.ASC,
					sortfield);
		}

		return pageable;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public String getSortfield() {
		return sortfield;
	}

	public void setSortfield(String sortfield) {
		this.sortfield = sortfield;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
