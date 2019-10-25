//
//package lib.employee.board.model;
//
//import org.springframework.web.util.UriComponentsBuilder;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Getter
//@Setter
//@ToString
//public class Criteria {
//	private int pageNum;
//	private int amount;
//	
//	//寃��깋
//	private String type;
//	private String keyword;
//
//	public Criteria() {
//		this(1, 10); // 1�럹�씠吏�, �뜲�씠�꽣 10媛쒖뵫
//	}
//
//	public Criteria(int pageNum, int amount) {
//		this.pageNum = pageNum;
//		this.amount = amount;
//	}
//	
//	//寃��깋
//	public String[] getTypeArr() {
//
//		if (type == null) {
//			return new String [] {};
//		} else {
//			return type.split("");
//		}		
//	}
//	
//	//寃뚯떆臾� �궘�젣 �썑 紐⑸줉�쑝濡� �룎�븘媛� �븣 寃��깋議곌굔, �럹�씠吏� 珥덇린�솕 諛⑹�
//	public String getListLink() {	//UriComponentsBuilder : �뿬�윭媛쒖쓽 �뙆�씪誘명꽣�뱾�쓣 �뿰寃고븯�뿬 �븯�굹�쓽 URL 留곹겕濡� 留뚮뱾�뼱 諛섑솚
//
//		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
//				.queryParam("pageNum", this.pageNum)
//				.queryParam("amount", this.getAmount())
//				.queryParam("type", this.getType())
//				.queryParam("keyword",  this.getKeyword());
//		
//		return builder.toUriString();
//	}
//}
