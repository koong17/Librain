package lib.employee.board.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public PageDTO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5; //한번에 5페이지씩
		this.startPage = this.endPage - 4;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}
	
}