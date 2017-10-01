package util;

import java.sql.ResultSet;

/**
 * 结果集提取器
 * @author ljd
 *
 */
public interface ResultSetExtractor {
	/**
	 * 提取数据
	 * @param rs 结果集
	 * @return 对结果集进行封装的数据
	 * @throws Exception
	 */
	public Object extractData(ResultSet rs)throws Exception;
}
