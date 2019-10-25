//package lib.employee.board.controller;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import lib.employee.board.model.BoardAttachDTO;
//import lib.employee.board.model.Criteria;
//import lib.employee.board.model.NoticeDTO;
//import lib.employee.board.service.NoticeService;
//import lib.employee.login.service.LoginService;
//import lombok.AllArgsConstructor;
//import lombok.extern.log4j.Log4j;
//
//@Controller
//@Log4j
//@RequestMapping("board/*") 
//@AllArgsConstructor
//public class NoticeController {
//
//	private NoticeService service;
//	public HttpSession session;
//
//	@GetMapping("/registerNotice.do")
//	public String boardRegisterForm() {
//		return "employee/board/registerNotice";
//	}
//
//	@PostMapping("/registerNotice.do")
//	public String noticeInsert(NoticeDTO notice, RedirectAttributes rttr) {
//		//泥⑤��뙆�씪 泥섎━
//		if (notice.getAttachList() != null) {	
//			notice.getAttachList().forEach(attach -> log.info(attach));
//		}
//		
//		service.noticeInsert(notice);
//		rttr.addFlashAttribute("result", notice.getBoard_no());
//		return "redirect:./list.do";
//	}
//
//	@GetMapping("/getNotice.do")
//	public String noticeSelectOne(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
//		model.addAttribute("board", service.noticeSelectOne(board_no));
//		String emp_no= (String) session.getAttribute("emp_no");
//		return "employee/board/getNotice";
//	}
//	
//	@GetMapping("/modifyNotice.do")
//	public String noticeModifyForm(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
//		model.addAttribute("board", service.noticeSelectOne(board_no));
//		return "employee/board/modifyNotice";
//	}
//	
//	@GetMapping({"/getNextNotice.do"})
//	public String noticeSelectNext(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
//		model.addAttribute("board", service.noticeSelectNext(board_no));
//		return "employee/board/getNextNotice"; 
//	}
//	
//	@GetMapping({"/getPrevNotice.do"})
//	public String noticeSelectPrev(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, Model model) {
//		model.addAttribute("board", service.noticeSelectPrev(board_no));
//		return "employee/board/getPrevNotice";
//	}
//	
//
//	@PostMapping("/modifyNotice.do")
//	public String noticeUpdate(NoticeDTO notice, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
//
//		if (service.noticeUpdate(notice)) { // true(�젙�긽醫낅즺)�씪 �븣留� 媛� �쟾�떖
//			rttr.addFlashAttribute("result", "success");
//		}
//		
//		//�럹�씠吏�, 寃��깋議곌굔
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		return "redirect:./list.do";
//	}
//
//	@PostMapping("/removeNotice.do")
//	public String noticeDelete(@RequestParam("board_no") Long board_no, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
//
//		List<BoardAttachDTO> attachList = service.getAttachList(board_no);
//		
//		if (service.noticeDelete(board_no)) {
//			//寃뚯떆湲� �궘�젣�떆 �꽌踰�, �뵒鍮꾩뿉�꽌 泥⑤��뙆�씪�룄 媛숈씠 �궘�젣
//			deleteFiles(attachList);
//			rttr.addFlashAttribute("result", "success");
//		}
//		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
//		return "redirect:./list.do";
//	}
//	
//	//泥⑤��뙆�씪 - �븳湲�泥섎━ �븘�슂
//	@GetMapping(value= "/getNoticeAttachList.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<List<BoardAttachDTO>> getAttachList(Long board_no){
//		return new ResponseEntity<List<BoardAttachDTO>>(service.getAttachList(board_no), HttpStatus.OK);
//	}
//	
//	//�뙆�씪 �궘�젣 
//	private void deleteFiles(List<BoardAttachDTO> attachList) {
//		if(attachList == null || attachList.size() == 0) {return;}
//		
//		attachList.forEach(attach -> {
//			try {
//				Path file = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\" + attach.getUuid()+"_"+attach.getFileName());
//				Files.deleteIfExists(file);
//				
//				if(Files.probeContentType(file).startsWith("image")) {
//					Path thumNail = Paths.get("C:\\upload\\"+attach.getUploadPath()+"\\s_" + attach.getUuid() + "_"
//							+ attach.getFileName());
//					Files.delete(thumNail);
//				}
//				
//			} catch(Exception e) {
//				log.error("delete file error" + e.getMessage());
//			}//end catch
//		});//end forEach
//	}
//}
