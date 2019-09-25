package lib.employee.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lib.employee.board.mapper.BoardAttachMapper;
import lib.employee.board.mapper.BoardMapper;
import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
//@Service:이 클래스에서 제일 중요한 부분임		 @AllArgsConstructor : 모든 파라미터를 이용하는 생성자를 만듦

@Log4j
@Service
@AllArgsConstructor	
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	@Transactional
	@Override
	public void boardInsert(BoardDTO board) {
		log.info("register.........." + board);
		
		//게시물번호까지 포함
		mapper.insertSelectKey(board);
		
		//////////파일첨부
		if(board.getAttachList() == null || board.getAttachList().size() <=0) {
			return;
		}
		
		board.getAttachList().forEach(attach -> {
			
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardDTO boardSelectOne(Long bno) {
//		log.info("get............" + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean boardUpdate(BoardDTO board) {
//		log.info("modify............" + board);
		return mapper.update(board) ==1;
	}

	@Override
	public boolean boardDelete(Long bno) {
		log.info("delete......." + bno);
		attachMapper.deleteAll(bno);
		return mapper.delete(bno)==1;
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("getList.............");
//		return mapper.getList();
//	}

	@Override
	public List<BoardDTO> boardSelectAll(Criteria cri) {
		
		log.info("get List with criteria: "  + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int boardGetTotal(Criteria cri) {	//전체 데이터 수 구하기
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<BoardAttachDTO> getAttachList(Long bno) {
		log.info("get Attach List by bno" + bno);
		return attachMapper.findByBno(bno);
	}
}
