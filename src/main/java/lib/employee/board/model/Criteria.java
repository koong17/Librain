
package lib.employee.board.model;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNum;
	private int amount;
	
	//////////////검색
	private String type;
	private String keyword;
	////////////////

	public Criteria() {
		this(1, 10); // default : 1페이지, 데이터 10개씩
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	///////////검색
	public String[] getTypeArr() {
		return type == null? new String[] {}: type.split("");
	}
	
	
	//////게시물-파일 삭제 후 페이지 번호, 검색조건 유지
	public String getListLink() {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword",  this.getKeyword());
		
		return builder.toUriString();
	}

}
