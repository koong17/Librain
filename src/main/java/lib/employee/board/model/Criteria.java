
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
	
	//검색
	private String type;
	private String keyword;

	public Criteria() {
		this(1, 10); // 1페이지, 데이터 10개씩
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	//검색
	public String[] getTypeArr() {

		if (type == null) {
			return new String [] {};
		} else {
			return type.split("");
		}		
	}
	
	//게시물 삭제 후 목록으로 돌아갈 때 검색조건, 페이징 초기화 방지
	public String getListLink() {	//UriComponentsBuilder : 여러개의 파라미터들을 연결하여 하나의 URL 링크로 만들어 반환

		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword",  this.getKeyword());
		
		return builder.toUriString();
	}
}
