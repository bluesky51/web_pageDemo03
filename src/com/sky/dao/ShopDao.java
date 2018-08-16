package com.sky.dao;

import java.sql.SQLException;
import java.util.List;

import com.sky.domain.Shop;

public interface ShopDao {

	/**
	 * 获取总的条数
	 * @return
	 * @throws SQLException
	 */
	public  long  queryTotalCount() throws SQLException;
	
	/**
	 * 获取指定页面要显示的数据
	 * @param pageNo:当前页
	 * @param pageSize：每页显示的数量
	 * @return  
	 * @throws SQLException
	 */
	public  List<Shop> queryShoList(int pageNo,int pageSize) throws SQLException;
}
