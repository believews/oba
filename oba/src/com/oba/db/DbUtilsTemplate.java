package com.oba.db;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.oba.web.comm.exception.GenericBusinessException;
import com.oba.web.util.Pager;
import com.oba.web.util.StringTool;


/**
 * 数据源操作类
 * 
 * @author keke
 * 
 */
@Service
@SuppressWarnings("all")
public class DbUtilsTemplate {

	@Resource
	private DataSource dataSource;
	private QueryRunner queryRunner = null;
	private static final Log LOG = LogFactory.getLog(DbUtilsTemplate.class);

	/**
	 * 执行sql语句
	 * 
	 * @param sql sql语句
	 * @return 受影响的行数
	 */
	public int update(String sql) {
		return update(sql, null);
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 受影响的行数
	 */
	public int update(String sql, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		int affectedRows = 0;
		try {
			if (params == null) {
				affectedRows = queryRunner.update(sql);
			} else {
				affectedRows = queryRunner.update(sql, params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to update data", e);
		}
		return affectedRows;
	}

	/**
	 * 执行批量sql语句
	 * 
	 * @param sql sql语句
	 * @param params 二维参数数组
	 * @return 受影响的行数的数组
	 */
	public int[] batchUpdate(String sql, Object[][] params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		int[] affectedRows = new int[0];
		try {
			affectedRows = queryRunner.batch(sql, params);
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to batch update data", e);
		}
		return affectedRows;
	}

	/**
	 * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
	 * 
	 * @param sql sql语句
	 * @return 查询结果
	 */
	public List<Map<String, Object>> find(String sql) {
		return find(sql, null);
	}

	/**
	 * 执行查询，将每行的结果保存到一个Map对象中，然后将所有Map对象保存到List中
	 * 
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 查询结果
	 */
	public List<Map<String, Object>> find(String sql, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			if (params == null) {
				list = (List<Map<String, Object>>) queryRunner.query(sql, new MapListHandler());
			} else {
				list = (List<Map<String, Object>>) queryRunner.query(sql, new MapListHandler(), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return list;
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass 类名
	 * @param sql sql语句
	 * @return 查询结果
	 */
	public <T> List<T> find(Class<T> entityClass, String sql) {
		return find(entityClass, sql, null);
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass 类名
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 查询结果
	 */
	public <T> List<T> find(Class<T> entityClass, String sql, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		List<T> list = new ArrayList<T>();
		try {
			if (params == null) {
				list = (List<T>) queryRunner.query(sql, new BeanListHandler(entityClass));
			} else {
				list = (List<T>) queryRunner.query(sql, new BeanListHandler(entityClass), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return list;
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成对象
	 * 
	 * @param entityClass 类名
	 * @param sql sql语句
	 * @return 对象
	 */
	public <T> T findFirst(Class<T> entityClass, String sql) {
		return findFirst(entityClass, sql, null);
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成对象
	 * 
	 * @param entityClass 类名
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 对象
	 */
	public <T> T findFirst(Class<T> entityClass, String sql, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		Object object = null;
		try {
			if (params == null) {
				object = queryRunner.query(sql, new BeanHandler(entityClass));
			} else {
				object = queryRunner.query(sql, new BeanHandler(entityClass), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return (T) object;
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成Map对象
	 * 
	 * @param sql sql语句
	 * @return 封装为Map的对象
	 */
	public Map<String, Object> findFirst(String sql) {
		return findFirst(sql, null);
	}

	/**
	 * 查询出结果集中的第一条记录，并封装成Map对象
	 * 
	 * @param sql sql语句
	 * @param params 参数数组
	 * @return 封装为Map的对象
	 */
	public Map<String, Object> findFirst(String sql, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		Map<String, Object> map = null;
		try {
			if (params == null) {
				map = (Map<String, Object>) queryRunner.query(sql, new MapHandler());
			} else {
				map = (Map<String, Object>) queryRunner.query(sql, new MapHandler(), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return map;
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql sql语句
	 * @param columnName 列名
	 * @return 结果对象
	 */
	public Object findBy(String sql, String columnName) {
		return findBy(sql, columnName, null);
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql sql语句
	 * @param columnName 列名
	 * @param params 参数数组
	 * @return 结果对象
	 */
	public Object findBy(String sql, String columnName, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		Object object = null;
		try {
			if (params == null) {
				object = queryRunner.query(sql, new ScalarHandler(columnName));
			} else {
				object = queryRunner.query(sql, new ScalarHandler(columnName), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return object;
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql sql语句
	 * @param columnIndex 列索引
	 * @return 结果对象
	 */
	public Object findBy(String sql, int columnIndex) {
		return findBy(sql, columnIndex, null);
	}

	/**
	 * 查询某一条记录，并将指定列的数据转换为Object
	 * 
	 * @param sql sql语句
	 * @param columnIndex 列索引
	 * @param params 参数数组
	 * @return 结果对象
	 */
	public Object findBy(String sql, int columnIndex, Object... params) {
		if (queryRunner == null) {
			queryRunner = new QueryRunner(dataSource);
		}
		Object object = null;
		try {
			if (params == null) {
				object = queryRunner.query(sql, new ScalarHandler(columnIndex));
			} else {
				object = queryRunner.query(sql, new ScalarHandler(columnIndex), params);
			}
		} catch (SQLException e) {
			LOG.error("Error occured while attempting to query data", e);
		}
		return object;
	}

	/**
	 * 封装分页方法
	 * 
	 * @param pager pager对象
	 * @return
	 */
	public Pager findPage(Pager pager) {
		return findPage(pager, null);
	}

	/**
	 * 封装分页方法
	 * 
	 * @param pager pager对象
	 * @param params 参数
	 * @return
	 */
	public Pager findPage(Pager pager, Object... params) {
		if (pager == null || StringTool.isEmpty(pager.getSql())) {
			return null;
		}
		// 组装分页
		StringBuffer pagingSelect = new StringBuffer(pager.getSql().length() + 100);
		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pagingSelect.append(pager.getSql());
		pagingSelect.append(" ) row_ ) where rownum_ > " + pager.getFirstResult() + " and rownum_ <= " + (pager.getFirstResult() + pager.getPageSize()));
		List<Map<String, Object>> list = find(pagingSelect.toString(), params);
		pager.setList(list);
		return pager;
	}
	/**
	 * 执行统计查询语句，语句的执行结果必须只返回一个数值
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getCount(String sql, Object... params) throws GenericBusinessException {
		Number num = 0L;
		try {
			if (queryRunner == null) {
				queryRunner = new QueryRunner(dataSource);
			}
			num = (Number) queryRunner.query(sql, _g_scaleHandler, params);
		} catch (SQLException e) {
			throw new GenericBusinessException("count error");
		}
		return (num != null) ? num.intValue() : 0;
	}

	/**
	 * 执行统计查询语句，语句的执行结果必须只返回一个数值
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getCount(String sql) throws GenericBusinessException {
		return getCount(sql, null);
	}

	private final static ScalarHandler _g_scaleHandler = new ScalarHandler() {
		@Override
		public Object handle(ResultSet rs) throws SQLException {
			Object obj = super.handle(rs);
			if (obj instanceof BigInteger)
				return ((BigInteger) obj).longValue();
			return obj;
		}
	};
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
}