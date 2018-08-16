package com.sky.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sky.dao.ShopDao;
import com.sky.domain.Shop;
import com.sky.utils.C3P0Utils;

public class ShopDaoImpl implements ShopDao {

	@Override
	public long queryTotalCount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		Object object =  queryRunner.query("select count(*) from shop ", new ScalarHandler());
		long totalCount = (long) object;
		return totalCount;
	}

	@Override
	public List<Shop> queryShoList(int pageNo, int pageSize) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		String sql="select * from shop limit ?,?";
		List<Shop>  list = queryRunner.query(sql, new  BeanListHandler<Shop>(Shop.class),(pageNo-1)*pageSize,pageSize);
		return list;
	}

}
