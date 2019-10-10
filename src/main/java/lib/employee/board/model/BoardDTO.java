package lib.employee.board.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {		//Lombok을 이용해서 생성자와 getter/setter, toString()만들어냄. 그래서 @Data 필요

	private Long board_no;
	private String board_title;
	private String board_content;
	private String board_writer;
	private Date board_regdate;
	private Date board_updateDate;
	
	/////////////2019 09 25 추가
	private List<BoardAttachDTO> attachList;
	
}