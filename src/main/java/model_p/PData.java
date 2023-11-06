package model_p;

import javax.servlet.http.HttpServletRequest;

public class PData {
	int limit = 10, pageLimit=4, start, nowPage;
	int startPage, endPage,totalPage, total;
	public String sch = null;
	public String inputStart = null;
	public String inputEnd = null;
	
	public PData(HttpServletRequest request) {
		nowPage = 1;
		if(request.getParameter("nowPage")!=null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		sch = request.getParameter("sch");
		
		inputStart = request.getParameter("inputStart");
		inputEnd = request.getParameter("inputEnd");
		
		if( sch==null || sch.equals("null")) {
			sch = "";
		}

		if( inputStart==null || inputStart.equals("null")) {
			inputStart = "";
		}
		
		if( inputEnd==null || inputEnd.equals("null")) {
			inputEnd = "";
		}
		
		request.setAttribute("pd", this);
	}
	
	
	
	public String getInputStart() {
		return inputStart;
	}

	public String getInputEnd() {
		return inputEnd;
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
