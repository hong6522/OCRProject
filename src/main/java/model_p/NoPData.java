package model_p;

import javax.servlet.http.HttpServletRequest;

public class NoPData {
	int limit = 4, pageLimit=4, start, nowPage;
	int startPage, endPage,totalPage, total;
	String sch = null;
	String cate = null;
	public NoPData(HttpServletRequest request) {
		nowPage = 1;
		if(request.getParameter("nowPage")!=null && !request.getParameter("nowPage").equals("")) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		sch = request.getParameter("sch");
		cate = request.getParameter("cate");
		
		if( sch==null || sch.equals("null")) {
			sch = "";
		}

		if( cate==null || cate.equals("null")) {
			cate = "";
		}
		
		request.setAttribute("pd", this);
	}
	
	
	
	public String getCate() {
		return cate;
	}

	
	public String getSch() {
		return sch;
	}
	
	public void setTotal(int total) {
		totalPage = total / limit;
		// 0.3 = 3 / 10
		if(total % limit != 0 ) {
			totalPage++;
		}
		
		start = (nowPage -1)*limit;
		// 0 = (1-1)*10
		startPage = (nowPage -1 )/ pageLimit * pageLimit +1;
		// 1 = (1-1)/4*4+1
		endPage = startPage + pageLimit -1;
		//
		if(endPage>totalPage) {
			endPage = totalPage;
		}
	}
		

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public int getStart() {
		return start;
	}

	public int getNowPage() {
		return nowPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
}
