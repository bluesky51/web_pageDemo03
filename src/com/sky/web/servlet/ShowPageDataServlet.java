package com.sky.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.domain.ShopBean;
import com.sky.service.ShopService;
import com.sky.service.impl.ShopServiecImpl;

import net.sf.json.JSONObject;

@WebServlet("/ShowPageDataServlet")
public class ShowPageDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
		int pageNo1 = 1;
		int pageSize1 = 10;
		String pageNo = request.getParameter("pageNo");
		if ("".equals(pageNo) || null == pageNo) {

		} else {
			pageNo1 = Integer.parseInt(pageNo);
		}
		String pageSize = request.getParameter("pageSize");
		if ("".equals(pageSize) || null == pageSize) {

		} else {
			pageSize1 = Integer.parseInt(pageSize);
		}
		ShopService service= new  ShopServiecImpl();
		//原因是jsp页面中ajax响应的内容(每页要展示的数据list集合， 当前页pageNo和总页数totalPage)
		ShopBean shopBean = service.getDateByPage(pageNo1,pageSize1);
	    request.getSession().setAttribute("shopBean", shopBean);
		response.sendRedirect("show.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
