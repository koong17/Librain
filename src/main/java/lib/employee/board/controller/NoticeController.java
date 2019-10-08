package lib.employee.board.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lib.employee.board.model.BoardAttachDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.NoticeDTO;
import lib.employee.board.service.NoticeService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("employee/board/*") 
@AllArgsConstructor
public class NoticeController {

	private NoticeService service;

	@GetMapping("/registerNotice")
	public void boardRegisterForm() {}

	@PostMapping("/registerNotice")
	public String noticeInsert(NoticeDTO notice, RedirectAttributes rttr) {
		//첨부파일 처리
		if (notice.getAttachList() != null) {	
			notice.getAttachList().forEach(attach -> log.info(attach));
					//for(attach : board.getAttachList) { log.info(attach)};
		}
		
		service.noticeInsert(notice);
		rttr.addFlashAttribute("result", notice.getBoard_no());
		return "redirect:/employee/board/list";
	}

	@GetMapping({ "/getNotice", "/modifyNotice" })
	public void boardSelectOne(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectOne(board_no));
		System.out.println("일반글 상세보기 : " + model.toString()  );
	}
	
	@GetMapping({"/getNextNotice"})
	public void boardSelectNext(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectNext(board_no));
	}
	
	@GetMapping({"/getPrevNotice"})
	public void boardSelectPrev(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("board", service.noticeSelectPrev(board_no));
	}
	

	@PostMapping("/modifyNotice")
	public String boardUpdate(NoticeDTO notice, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

		if (service.noticeUpdate(notice)) { // true(정상종료)일 때만 값 전달
			rttr.addFlashAttribute("result", "success");
		}
		
		//페이징, 검색조건
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/employee/board/list";
	}

	@PostMapping("/removeNotice")
	public String boardDelete(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {

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
		return "redirect:/employee/board/list";
	}
	
	//첨부파일 - 한글처리 필요
	@GetMapping(value= "/getNoticeAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachDTO>> getAttachList(Long board_no){
		return new ResponseEntity<List<BoardAttachDTO>>(service.getAttachList(board_no), HttpStatus.OK);
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
