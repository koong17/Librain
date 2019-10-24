//package lib.employee.board.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import lib.employee.board.mapper.BoardAttachMapper;
//import lib.employee.board.mapper.BoardMapper;
//import lib.employee.board.model.BoardAttachDTO;
//import lib.employee.board.model.BoardDTO;
//import lib.employee.board.model.Criteria;
//import lib.employee.board.model.NoticeDTO;
//import lombok.AllArgsConstructor;
//import lombok.Setter;
//import lombok.extern.log4j.Log4j;
////@AllArgsConstructor : 紐⑤뱺 �뙆�씪誘명꽣瑜� �씠�슜�븯�뒗 �깮�꽦�옄瑜� 留뚮벀
//
//@Log4j
//@Service
//@AllArgsConstructor	
//public class BoardServiceImpl implements BoardService{
//	
//	@Setter(onMethod_ = @Autowired)
//	private BoardMapper mapper;
//	
//	@Setter(onMethod_ = @Autowired)
//	private BoardAttachMapper attachMapper;
//	
//	@Transactional
//	@Override
//	public void boardInsert(BoardDTO board) {
//		mapper.insertSelectKey(board);
//		
//		//�뙆�씪泥⑤�
//		if(board.getAttachList() == null || board.getAttachList().size() <=0) {
//			return;
//		}
//		
//		board.getAttachList().forEach(attach -> {
//			attach.setBoard_no(board.getBoard_no());
//			attachMapper.insert(attach);
//		});
//	}
//
//	@Override
//	public BoardDTO boardSelectOne(Long board_no) {
//		return mapper.read(board_no);
//	}
//	
//	@Override
//	public BoardDTO boardSelectPrev(Long board_no) {
//		
//		BoardDTO dto = mapper.readPrev(board_no);
//		if (dto==null) {
//			return mapper.read(board_no);
//		}else {
//			return dto;
//		}
//	}
//	
//	@Override
//	public BoardDTO boardSelectNext(Long board_no) {
//		BoardDTO dto =  mapper.readNext(board_no);
//		if(dto==null) {
//			return mapper.read(board_no);
//		} else {
//			return dto;
//		}
//	}
//
//	
//	@Transactional
//	@Override
//	public boolean boardUpdate(BoardDTO board) {
//		attachMapper.deleteAll(board.getBoard_no());
//		
//		boolean modifyResult = mapper.update(board) ==1;
//		if(modifyResult && board.getAttachList() != null && board.getAttachList().size() > 0) {
//			board.getAttachList().forEach(attach -> {
//				attach.setBoard_no(board.getBoard_no());
//				attachMapper.insert(attach);
//			});
//		}
//		return modifyResult;
//	}
//
//	@Override
//	public boolean boardDelete(Long board_no) {
//		attachMapper.deleteAll(board_no);
//		return mapper.delete(board_no)==1;
//	}
//
//	@Override
//	public List<BoardDTO> boardSelectAll(Criteria cri) {
//		return mapper.getListWithPaging(cri);
//	}
//
//	@Override
//	public int boardGetTotal(Criteria cri) {
//		return mapper.getTotalCount(cri);
//	}
//
//	@Override
//	public List<BoardAttachDTO> getAttachList(Long board_no) {
//		log.info("get Attach List by board_no" + board_no);
//		return attachMapper.findByBno(board_no);
//	}
//}
