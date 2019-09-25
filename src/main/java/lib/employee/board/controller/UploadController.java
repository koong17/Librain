package lib.employee.board.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lib.employee.board.model.AttachFileDTO;
import lombok.extern.log4j.Log4j;
import net.coobird.thumbnailator.Thumbnailator;

@Controller
@RequestMapping("employee/board/*")
@Log4j
public class UploadController {

	@GetMapping("/uploadForm")
	public void uploadForm() {
		log.info("upload form");
	}

	@PostMapping("/uploadFormAction")
	public void uploadFormPost( MultipartFile[] uploadFile, Model model) {

		String uploadFolder = "C:\\upload";

		for (MultipartFile multipartFile : uploadFile) {
			log.info("------------------------------------------");
			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
			log.info("Upload File Size : " + multipartFile.getSize());

			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

			try {
				multipartFile.transferTo(saveFile);
			} catch (Exception e) {
				log.error(e.getMessage());
			} // end catch
		} // end for

	}

	@GetMapping("/uploadAjax")
	public void uploadAjax() {
		log.info("upload ajax");
	}

//	@ResponseBody
//	@PostMapping("/uploadAjaxAction")
//	public void uploadAjaxPost(MultipartFile[] uploadFile) {
//		log.info("update ajax post................");
//
//		String uploadFolder = "C:\\upload";
//
//		// make folder.........
//		File uploadPath = new File(uploadFolder, getFolder());
//		log.info("upload path: " + uploadPath);
//
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		} // make yyyy/MM/dd folder
//
//		for (MultipartFile multipartFile : uploadFile) {
//			log.info("-----------------------------------------");
//			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//			log.info("Upload File Size : " + multipartFile.getSize());
//
//			String uploadFileName = multipartFile.getOriginalFilename();
//
//			// IE has file path
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
//			log.info("only file name: " + uploadFileName);
//			// 파일 이름 중복 처리
//			UUID uuid = UUID.randomUUID();
//			uploadFileName = uuid.toString() + "_" + uploadFileName;
//
//			try {
////			File saveFile = new File(uploadFolder, uploadFileName);
//				File saveFile = new File(uploadPath, uploadFileName);
//				multipartFile.transferTo(saveFile);
//				//check image type file
//				if (checkImageType(saveFile)) {
//					FileOutputStream thumbnail = 
//							new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//					
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail, 100, 100);
//					thumbnail.close();
//				}
//			} catch (Exception e) {
//				log.error(e.getMessage());
//			} // end catch
//		} // end for
//	}

	private String getFolder() { // 날짜별로 파일을 관리할 수 있음
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	// 썸네일
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());
			return contentType.startsWith("image");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	///////////////// 브라우저로 파일 전송
	@PostMapping(value = "/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(@RequestParam("uploadFile") MultipartFile[] uploadFile) {
		
		log.warn("1----------------------------------------");
		log.warn("1----------------------------------------");
		log.warn("1----------------------------------------");
		
		log.warn(uploadFile);
		
		if(uploadFile != null) {
			log.warn(uploadFile.length);
		}
		
		log.warn("1----------------------------------------");
		log.warn("1----------------------------------------");
		log.warn("1----------------------------------------");
		
		List<AttachFileDTO> list = new ArrayList<>();
		String uploadFolder = "C:\\upload";

		String uploadFolderPath = getFolder();
		// make folder
		File uploadPath = new File(uploadFolder, uploadFolderPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		// make yyyy/MM/dd folder
		for (MultipartFile multipartFile : uploadFile) {
			
			log.info("2----------------------------------------");
			
			
			AttachFileDTO attachDTO = new AttachFileDTO();
			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			
			log.info("only file name : " + uploadFileName);
			log.info("only file name : " + uploadFileName);
			log.info("only file name : " + uploadFileName);
			log.info("only file name : " + uploadFileName);
			
			
			attachDTO.setFileName(uploadFileName);

			UUID uuid = UUID.randomUUID();

			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				attachDTO.setUuid(uuid.toString());
				attachDTO.setUploadPath(uploadFolderPath);

				// check image type file
				if (checkImageType(saveFile)) {
					attachDTO.setImage(true);

					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));

					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);

					thumbnail.close();
				}

				// add to list
				list.add(attachDTO);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // end for
		return new ResponseEntity<>(list, HttpStatus.OK);

	}
	
	//썸네일처리- 파일ㄹ 이름을 받아서 이미지 데이터 전송
	@GetMapping("/display")
	@ResponseBody
	public ResponseEntity<byte[]> getFile(String fileName){
		
		log.info("fileName: " + fileName);
		File file = new File("c:\\upload\\" + fileName);
		log.info("file : " + file);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-Type", Files.probeContentType(file.toPath()));
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
//	//첨부파일 다운로드 - 일반파일 (16h03) - 브라우저 무반응, 콘솔에 파일 이름만 출력되면 OK
//	@GetMapping(value="/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(String fileName){
//		
//		log.info("download file:" + fileName);
//		
//		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
//		log.info("resource : " + resource);
//		
//		return null;
//	}
	
	//자동 다운로드 처리까지 완료
//	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(String fileName) {
//
//		log.info("download file:" + fileName);
//
//		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
//		
//		log.info("resource : " + resource);
//
//		String resourceName = resource.getFilename();
//
//		HttpHeaders headers = new HttpHeaders();
//		try {
//			headers.add("Content-Disposition",
//					"attachment; filename=" + new String(resourceName.getBytes("UTF-8"), "ISO-8859-1"));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
	
//	//IE, Edge 한글깨짐 처리 - 그러나 테스트 할 떄는 주소창에 한글을 변환해서 해야 함
//	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
//
//		log.info("download file:" + fileName);
//		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
//		log.info("resource : " + resource);
//		
//		
//		if (resource.exists() == false) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		
//		String resourceName = resource.getFilename();
//		HttpHeaders headers = new HttpHeaders();
//		
//		try {
//			String downloadName = null;
//			if (userAgent.contains("Trident")) {
//				log.info("IE browser");
//				downloadName = URLEncoder.encode(resourceName, "UTF-8").replaceAll("\\+", " ");
//			} else if (userAgent.contains("Edge")) {
//				log.info("Edge browser");
//				downloadName = URLEncoder.encode(resourceName, "UTF-8");
//				log.info("Edge name: " + downloadName);
//			} else {
//				log.info("Chrome browser");
//				downloadName = new String(resourceName.getBytes("UTF-8"), "ISO-8859-1");
//			}
//			
//			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}//직접 url 입력했을 때 한글 깨지지 않고 다운로드 됩니다.
	
	
	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {

//		log.info("download file:" + fileName);
		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
//		log.info("resource : " + resource);
		
		
		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String resourceName = resource.getFilename();
		
		//remove UUID - 원래 이름으로 다운 받을 수 있게 함
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_")+1);
		
		HttpHeaders headers = new HttpHeaders();
		
		try {
			String downloadName = null;
			if (userAgent.contains("Trident")) {
				log.info("IE browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				log.info("Edge browser");
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
				log.info("Edge name: " + downloadName);
			} else {
				log.info("Chrome browser");
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}
			
			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	@PostMapping("/deleteFile")
	@ResponseBody
	public ResponseEntity<String> deleteFile(String fileName, String type){
		
		log.info("deleteFile: " + fileName);
		File file;
		
		try {
			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
			
			file.delete();
			
			if(type.contentEquals("image")) {
				String largeFileName = file.getAbsolutePath().replace("s_",  "");
				log.info("largeFileName: " + largeFileName);
				file = new File(largeFileName);
				file.delete();
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<String>("deleted", HttpStatus.OK);
	}
	
}
