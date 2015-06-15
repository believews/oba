package com.oba.web.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页
 */

@SuppressWarnings("all")
public class Pager {

	public static final Integer MAX_PAGE_SIZE = 100000;// 每页最大记录数限制
	public String max_count = "100000";
	private Integer currePageNumber = 1;// 当前页码
	private Integer pageSize = 10;// 每页记录数
	private Integer totalCount = 0;// 总记录数
	private Integer pageCount = 0;// 总页数
	private List list;// 数据List

	private String sql;	//查询列表SQL
	private String countSql;	//查询条数SQL

	private Integer maxShowPageCount = 4;// 默认显示 。。。多少个页数出现... 分页显示用到
	private Integer segment;// 分隔的当前页码段
	private Integer startPageNumber;// 默认显示 。。。开始页数... 分页显示用到
	private Integer endPageNumber;// 默认显示 。。。结束页数 ... 分页显示用到

	private Integer firstResult;// first pagenum 显示的第一条记录是多少[开始条数]

	public Pager() {

	}

	public String getMax_count() {
		return max_count;
	}

	public void setMax_count(String maxCount) {
		max_count = maxCount;
	}

	public Integer getFirstResult() {
		return (currePageNumber - 1) * pageSize;
	}

	public Integer getSegment() {
		this.segment = (currePageNumber - 1) / maxShowPageCount;
		if ((currePageNumber - 1) % maxShowPageCount >= 0) {
			segment++;
		}
		if (this.segment < 1) {
			this.segment = 1;
		}
		return segment;
	}

	public Integer getStartPageNumber() {
		this.startPageNumber = (getSegment() - 1) * maxShowPageCount + 1;
		if (this.startPageNumber < 1) {
			this.startPageNumber = 1;
		}
		return startPageNumber;
	}

	public Integer getEndPageNumber() {
		this.endPageNumber = getSegment() * maxShowPageCount;
		if (this.endPageNumber > pageCount) {
			this.endPageNumber = pageCount;
		}
		return endPageNumber;
	}

	public Integer getCurrePageNumber() {
		return currePageNumber;
	}

	public void setCurrePageNumber(Integer currePageNumber) {
		if (currePageNumber < 1) {
			currePageNumber = 1;
		}
		this.currePageNumber = currePageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize < 1) {
			pageSize = 1;
		} else if (pageSize > MAX_PAGE_SIZE) {
			pageSize = MAX_PAGE_SIZE;
		}
		this.pageSize = pageSize;
	}

	public Integer getPageCount() {
		pageCount = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			pageCount++;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getMaxShowPageCount() {
		return maxShowPageCount;
	}

	public void setMaxShowPageCount(Integer maxShowPageCount) {
		this.maxShowPageCount = maxShowPageCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	/**
	 * 返回STRING类型在开始条数
	 * 
	 * @return
	 */
	public String getCurrePageNumberForString() {
		return String.valueOf(this.getCurrePageNumber());
	}

	public String getFirstResultForString() {
		return String.valueOf(this.getFirstResult());
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getCountSql() {
		return countSql;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}
	
}