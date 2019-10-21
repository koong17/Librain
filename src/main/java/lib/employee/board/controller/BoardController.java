package lib.employee.board.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.PageDTO;
import lib.employee.board.service.BoardService;
import lib.employee.board.service.NoticeService;
import lib.employee.login.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board/*") 
@AllArgsConstructor
public class BoardController {

	private BoardService boardService;
	private NoticeService noticeService;
	public HttpSession session;

	
	@GetMapping("/list.do")
	public String boardSelectAll(Criteria cri, Model model) {
		model.addAttribute("list", boardService.boardSelectAll(cri));
		
		//전체 데이터 수 
		int total = boardService.boardGetTotal(cri);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
		
		//공지사항 출력
		model.addAttribute("notice", noticeService.getNotices());
		return "employee/board/list";

	}

	@GetMapping("/register.do")
	public String boardRegisterForm() {
		return "employee/board/register";
	}
	
	@PostMapping("/register.do")
	public String boardInsert(BoardDTO board, RedirectAttributes rttr) {
		//첨부파일 처리
		if (board.getAttachList() != null) {	
			board.getAttachList().forEach(attach -> log.info(attach));
					//for(attach : board.getAttachList) { log.info(attach)};
		}
		
		boardService.boardInsert(board);
		rttr.addFlashAttribute("result", board.getBoard_no());
		return "redirect:./list.do";
	}

	@GetMapping("/get.do")	//읽기폼
	public String boardSelectOne(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", boardService.boardSelectOne(board_no));
		return "employee/board/get";
	}
	
	@GetMapping("/modify.do" )	//수정폼
	public String boardModifyForm(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", boardService.boardSelectOne(board_no));
		return "employee/board/modify";
	}
	
	@GetMapping({"/getNext.do"})
	public String boardSelectNext(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", boardService.boardSelectNext(board_no));
		return "employee/board/getNext";
	}
	
	@GetMapping({"/getPrev.do"})
	public String boardSelectPrev(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", boardService.boardSelectPrev(board_no));
		return "employee/board/getPrev";
	}

	@PostMapping("/modify.do")
	public String boardUpdate(BoardDTO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		if (boardService.boardUpdate(board)) { // true(작업 완료 후 정상종료)일 때만 값 전달
			rttr.addFlashAttribute("result", "success");
		}
		
		//페이징, 검색조건
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:./list.do";
	}

	@PostMapping("/remove.do")
	public String boardDelete(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		List<BoardAttachDTO> attachList = boardService.getAttachList(board_no);
		
		if (boardService.boardDelete(board_no)) {
			//게시글 삭제시 서버, 디비에서 첨부파일도 같이 삭제
			deleteFiles(attachList);
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:./list.do";
	}
	
	//첨부파일 - 한글처리 필요
	@GetMapping(value= "/getAttachList.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachDTO>> getAttachList(Long board_no){
		return new ResponseEntity<List<BoardAttachDTO>>(boardService.getAttachList(board_no), HttpStatus.OK);
	}
	
	//파일 삭제 
	private void deleteFiles(List<BoardAttachDTO> attachList) {
		if(attachList == null || attachList.size() == 0) {return;}
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\" + attach.getUuid()+"_"+attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_" + attach.getUuid() + "_"
							+ attach.getFileName());
					Files.delete(thumNail);
				}
				
			} catch(Exception e) {
				log.error("delete file error" + e.getMessage());
			}//end catch
		});//end forEach
	}
}
