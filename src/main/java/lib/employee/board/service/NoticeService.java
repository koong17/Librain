package lib.employee.board.service;

import java.util.List;

import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;

public interface NoticeService {
		public void noticeInsert(NoticeDTO notice);
		public NoticeDTO noticeSelectOne(Long board_no);
		public boolean noticeUpdate(NoticeDTO notice);
		public boolean noticeDelete(Long board_no);
		public int noticeGetTotal(Criteria cri);
		public List<BoardAttachDTO> getAttachList(Long board_no);
		public List<NoticeDTO> getNotices();
		public NoticeDTO noticeSelectPrev(Long board_no);
		public NoticeDTO noticeSelectNext(Long board_no);
	}

