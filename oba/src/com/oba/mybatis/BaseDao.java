package com.oba.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

/**
 * 父类dao接口
 * 
 * @author keke
 * 
 * @param <T>
 * @param <PK>
 */
public interface BaseDao<T, PK extends Serializable> extends Serializable {

	/**
	 * 获取主键
	 * @return
	 */
	Long getKey();
	
	/**
	 * 保存对象
	 * 
	 * @param o
	 * @return
	 */
	void save(T o);

	/**
	 * 删除对象记录
	 * 
	 * @param id
	 */
	void delete(PK id);

	/**
	 * 批量删除
	 * 
	 * @param map
	 */
	void batchDelete(Map<String, List<Integer>> map);

	/**
	 * 通过ID查询对象
	 * 
	 * @param id
	 * @return
	 */
	T getByID(PK id);

	/**
	 * 跟新对象
	 * 
	 * @param model
	 */
	void update(T model);

	/**
	 * 统计数据总条数
	 * 
	 * @return
	 */
	int countAll();

	/**
	 * 获取全部对象
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 根据此查询条件统计记录总条数
	 * 
	 * @param parameters map 包含各种属性的查询
	 * @return
	 */
	Integer findNumberByCondition(Map<String, Object> parameters);

	/**
	 * 分页查询函数，返回对象集合
	 * 
	 * @param parameters map 包含各种属性的查询
	 * @param rowBounds 偏移量恢复为初始值(offet:0,limit:Integer.max) 使用参考：new
	 *            RowBounds(pageNum, pageSize)
	 * @return
	 */
	//栏目模板集合
	List<T> findPageBreakByCondition(Map<String, Object> parameters, RowBounds rowBounds);

}
