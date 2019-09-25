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
import lib.employee.board.model.BoardDTO;
import lib.employee.board.model.Criteria;
import lib.employee.board.model.PageDTO;
import lib.employee.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("employee/board/*") 
@AllArgsConstructor
public class BoardController {

	private BoardService service;

	@GetMapping("/list")
	public void boardSelectAll(Criteria cri, Model model) {
		log.info("list");
		model.addAttribute("list", service.boardSelectAll(cri));
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));//전체데이터수 나중에 구현해서 123 자리에 넣기
		
		//전체 데이터 수 
		int total = service.boardGetTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));
	}

	@GetMapping("/register")
	public void boardRegisterForm() {
		// 입력페이지를 보여주는 역할
		log.info("boardRegisterForm");
	}

	@PostMapping("/register")
	public String boardInsert(BoardDTO board, RedirectAttributes rttr) { // RedirectAttributes : redirect 하면서 게시글번호 들고감
		log.info("--------------------------------------");
		log.info("register: " + board);
		
		///////첨부파일 관련 추가
		if (board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		
		log.info("--------------------------------------");
		
		service.boardInsert(board);
		rttr.addFlashAttribute("result", board.getBno());// addFlashAttribute : 데이터를 단 한번만 사용할 수 있게 해 줌
		return "redirect:/employee/board/list";
	}

	@GetMapping({ "/get", "/modify" })	//읽기 또는 수정하기 폼
	public void boardSelectOne(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or modify");
		model.addAttribute("board", service.boardSelectOne(bno));
	}

	@PostMapping("/modify")
	public String boardUpdate(BoardDTO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);
		if (service.boardUpdate(board)) { // 수정||삭제 메소드 반환형은boolean처리 했었음
			rttr.addFlashAttribute("result", "success");
		}
		
		
		//페이징, 검색조건 관련 코드
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/employee/board/list";
	}

	@PostMapping("/remove")
	public String boardDelete(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove:" + bno);
		
		List<BoardAttachDTO> attachList = service.getAttachList(bno);
		
		if (service.boardDelete(bno)) {
			//delete attached files
			deleteFiles(attachList);
			rttr.addFlashAttribute("result", "success");
		}
		
		//페이징, 검색 조건 관련 코드
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/employee/board/list";
	}
	
	/////////첨부파일
	@GetMapping(value= "/getAttachList", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachDTO>> getAttachList(Long bno){
		log.info("getAttachList " + bno);
		
		return new ResponseEntity<>(service.getAttachList(bno), HttpStatus.OK);
	}
	
	//파일 삭제 
	
	private void deleteFiles(List<BoardAttachDTO> attachList) {
		
		if(attachList == null || attachList.size() == 0) {
			return;
		}
		
		log.info("delete attach files ..................");
		log.info(attachList);
		
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
