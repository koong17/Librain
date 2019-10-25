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
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;
import lib.employee.board.service.NoticeService;
import lib.employee.login.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("board/*") 
@AllArgsConstructor
public class NoticeController {

	private NoticeService service;
	public HttpSession session;

	//공지글 입력 폼
	@GetMapping("/registerNotice.do")
	public String boardRegisterForm() {
		return "employee/board/registerNotice";
	}

	//실제 글 등록 처리
	@PostMapping("/registerNotice.do")
	public String noticeInsert(NoticeDTO notice, RedirectAttributes rttr) {
		//첨부파일 처리
		if (notice.getAttachList() != null) {	
			notice.getAttachList().forEach(attach -> log.info(attach));
		}
		
		service.noticeInsert(notice);
		rttr.addFlashAttribute("result", notice.getBoard_no());
		return "redirect:./list.do";
	}

	//글 읽기
	@GetMapping("/getNotice.do")
	public String noticeSelectOne(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectOne(board_no));
		String emp_no= (String) session.getAttribute("emp_no");
		return "employee/board/getNotice";
	}
	
	//글 수정 폼
	@GetMapping("/modifyNotice.do")
	public String noticeModifyForm(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectOne(board_no));
		return "employee/board/modifyNotice";
	}
	
	
	//실제 수정 처리
	@PostMapping("/modifyNotice.do")
	public String noticeUpdate(NoticeDTO notice, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		if (service.noticeUpdate(notice)) { // true(정상종료)일 때만 값 전달
			rttr.addFlashAttribute("result", "success");
		}
		
		//페이징, 검색조건
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:./list.do";
	}
	
	//다음 공지글
	@GetMapping({"/getNextNotice.do"})
	public String noticeSelectNext(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectNext(board_no));
		return "employee/board/getNextNotice"; 
	}
	
	//이전 공지글
	@GetMapping({"/getPrevNotice.do"})
	public String noticeSelectPrev(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectPrev(board_no));
		return "employee/board/getPrevNotice";
	}

	
	//글 삭제
	@PostMapping("/removeNotice.do")
	public String noticeDelete(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		List<BoardAttachDTO> attachList = service.getAttachList(board_no);
		
		if (service.noticeDelete(board_no)) {
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
	@GetMapping(value= "/getNoticeAttachList.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachDTO>> getAttachList(Long board_no){
		return new ResponseEntity<List<BoardAttachDTO>>(service.getAttachList(board_no), HttpStatus.OK);
	}
	
	//파일 삭제 
	private void deleteFiles(List<BoardAttachDTO> attachList) {
		if(attachList == null || attachList.size() == 0) {return;}
		
		attachList.forEach(attach -> {
			try {
				Path file = Paths.get(
									"C:\\upload\\"+attach.getUploadPath()+
									"\\" + attach.getUuid()+
									"_"+attach.getFileName());
				Files.deleteIfExists(file);
				
				if(Files.probeContentType(file).startsWith("image")) {
					Path thumNail = Paths.get(
									"C:\\upload\\"+attach.getUploadPath()+
									"\\s_" + attach.getUuid() + "_"+ 
									attach.getFileName());
					Files.delete(thumNail);
				}
				
			} catch(Exception e) {
				log.error("delete file error" + e.getMessage());
			}//end catch
		});//end forEach
	}
}
