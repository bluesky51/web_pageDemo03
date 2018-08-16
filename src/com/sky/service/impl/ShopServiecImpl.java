package com.sky.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.sky.dao.ShopDao;
import com.sky.dao.impl.ShopDaoImpl;
import com.sky.domain.Shop;
import com.sky.domain.ShopBean;
import com.sky.service.ShopService;

public class ShopServiecImpl implements ShopService {

	ShopDao shopDao = new ShopDaoImpl();

	@Override
	public ShopBean getDateByPage(int pageNo1, int pageSize1) {
		// TODO Auto-generated method stub
		ShopBean shopBean = new ShopBean();
		try {
			shopBean.setPageNo(pageNo1);
			// 获取表中总的条数
			long totalCount = shopDao.queryTotalCount();
			// 计算总页数
			int totalPage = (int) Math.ceil(totalCount / pageSize1);

			shopBean.setTotalPage(totalPage);

			List<Shop> list = shopDao.queryShoList(pageNo1, pageSize1);
			shopBean.setList(list);
			
			
			// 每次最多显示5个页的按钮
			 int startPos = 1;
			 int endPos = 5;
//			
			 if (totalPage <= 5) {
			 endPos = totalPage;
			 } else {
			
			 startPos = pageNo1 - 2;
			 endPos = pageNo1 + 2;
			
			 if (startPos <= 0) {
			 startPos = 1;
			 endPos = 5;
			 }
			 if (endPos > totalPage) {
			 endPos = totalPage;
			 startPos = endPos - 4;
			 }
			 }

			// 数据量特别大，每次最多显示15个页的按钮
			/**
			 * 1，2，3，4，5，6，7，8，9，10，11，12，13，14，15
			 * 
			 */
//			int startPos = 1;
//			int endPos = 15;
//			if (totalPage <= 15) {
//				endPos = totalPage;
//			} else {
//				startPos = pageNo1 - 7;
//				endPos = pageNo1 + 7;
//
//				if (startPos <= 0) {
//					startPos = 1;
//					endPos = 15;
//				}
//				if (endPos > totalPage) {
//					endPos = totalPage;
//					startPos = endPos - 14;
//				}
//			}
			shopBean.setStartPos(startPos);
			shopBean.setEndPos(endPos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return shopBean;
	}

}
