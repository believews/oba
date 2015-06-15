package com.oba.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.oba.web.comm.exception.GenericBusinessException;
import com.oba.web.util.Pager;


/**
 * 父类Service
 * @author MengTao
 * 
 * @param <T>
 * @param <PK>
 */
public interface BaseService<T, PK extends Serializable> {
	
	/**
	 * 保存对象
	 * 
	 * @param o
	 * @return
	 */
	Long getKey() throws DataAccessException, GenericBusinessException;

	/**
	 * 保存对象
	 * 
	 * @param o
	 * @return
	 */
	void save(T o) throws DataAccessException, GenericBusinessException;

	/**
	 * 删除对象记录
	 * 
	 * @param id
	 */
	void delete(PK id) throws DataAccessException, GenericBusinessException;
	
	/**
	 * 批量删除
	 * @param map
	 */
	void batchDelete(Map<String, List<Integer>> map) throws DataAccessException, GenericBusinessException;

	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * @return
	 */
	T getByID(PK id) throws DataAccessException, GenericBusinessException;

	/**
	 * 跟新对象
	 * 
	 * @param model
	 */
	void update(T model) throws DataAccessException, GenericBusinessException;

	/**
	 * 统计数据总条数
	 * 
	 * @return
	 */
	int countAll() throws DataAccessException, GenericBusinessException;

	/**
	 * 获取全部对象
	 * 
	 * @return
	 */
	List<T> findAll() throws DataAccessException, GenericBusinessException;

	/**
	 * 根据此查询条件统计记录总条数
	 * 
	 * @param parameters map 包含各种属性的查询
	 * @return
	 */
	Integer findNumberByCondition(Map<String, Object> parameters) throws DataAccessException, GenericBusinessException;

	/**
	 * 分页查询函数，返回对象集合
	 * 
	 * @param parameters map 包含各种属性的查询
	 * @param rowBounds 偏移量恢复为初始值(offet:0,limit:Integer.max) 使用参考：new
	 *            RowBounds(pageNum, pageSize)
	 * @return
	 */
	List<T> findPageBreakByCondition(Map<String, Object> parameters, int offset, int pageSize) throws DataAccessException, GenericBusinessException;

	/**
	 * 分页查询
	 * 
	 * @param map
	 * @param pager
	 * @return
	 * @throws DataAccessException
	 * @throws GenericBusinessException
	 */
	Pager findList(Map<String, Object> map, Pager pager) throws DataAccessException, GenericBusinessException;
}
