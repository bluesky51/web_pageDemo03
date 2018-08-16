package com.sky.test;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;

import com.sky.utils.C3P0Utils;

public class TestInsert {

	public static void main(String[] args) {
		QueryRunner queryRunner =new QueryRunner(C3P0Utils.getDataSource());
	   String sql="insert into shop (name,price,category) values(?,?,?)";
		Object[][] params =new Object[100][];
	    for (int i = 0; i < params.length; i++) {
			params[i]=new Object[] {"name=="+100*i,100+100*i,"category=="+100*i};
		}
		try {
			int[]  rowCount = queryRunner.batch(sql, params);
			if (rowCount.length>0) {
				System.out.println("插入成功");
			}else {
				System.out.println("插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
