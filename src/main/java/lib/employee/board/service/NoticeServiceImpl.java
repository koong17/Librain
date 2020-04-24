package lib.employee.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lib.employee.board.mapper.BoardAttachMapper;
import lib.employee.board.mapper.NoticeMapper;
import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
//@Service:이 클래스에서 제일 중요한 부분임		 @AllArgsConstructor : 모든 파라미터를 이용하는 생성자를 만듦

@Log4j
@Service
@AllArgsConstructor	
public class NoticeServiceImpl implements NoticeService{
	
	@Setter(onMethod_ = @Autowired)
	private NoticeMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardAttachMapper attachMapper;
	
	// 공지 등록
	@Transactional
	@Override
	public void noticeInsert(NoticeDTO notice) {
		mapper.insertSelectKey(notice);

		// 파일첨부
		if (notice.getAttachList() == null || notice.getAttachList().size() <= 0) {
			return;
		}

		notice.getAttachList().forEach(attach -> {
			attach.setBoard_no(notice.getBoard_no());
			attachMapper.insert(attach);
		});
	}

	//글 읽기
	@Override
	public NoticeDTO noticeSelectOne(Long board_no) {
		return mapper.read(board_no);
	}

	//이전 글
	@Override
	public NoticeDTO noticeSelectPrev(Long board_no) {
		
		NoticeDTO dto = mapper.readPrev(board_no);
		if (dto==null) {return mapper.read(board_no);}
		else {return dto;}
	}
	
	//다음 글
	@Override
	public NoticeDTO noticeSelectNext(Long board_no) {
		NoticeDTO dto =  mapper.readNext(board_no);
		if(dto==null) {return mapper.read(board_no);} 
		else {return dto;}
	}
	
	//글 수정
	@Transactional
	@Override
	public boolean noticeUpdate(NoticeDTO notice) {
		attachMapper.deleteAll(notice.getBoard_no());
		
		boolean modifyResult = mapper.update(notice) ==1;
		if(modifyResult && notice.getAttachList() != null && notice.getAttachList().size() > 0) {
			notice.getAttachList().forEach(attach -> {
				attach.setBoard_no(notice.getBoard_no());
				attachMapper.insert(attach);
			});
		}
		return modifyResult;	//리턴 결과를 토대로 정상종료, 비정상종료 판단
	}
	

	//공지 삭제
	@Override
	public boolean noticeDelete(Long board_no) {
		attachMapper.deleteAll(board_no);
		return mapper.delete(board_no)==1;
	}

	//페이징
	@Override
	public int noticeGetTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

	//첨부파일
	@Override
	public List<BoardAttachDTO> getAttachList(Long board_no) {
		log.info("get Attach List by board_no" + board_no);
		return attachMapper.findByBno(board_no);
	}
	
	//전체보기
	@Override
	public List<NoticeDTO> getNotices(){
		return mapper.getNotices();
	}
}
