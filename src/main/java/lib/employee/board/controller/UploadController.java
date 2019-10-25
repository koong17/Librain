//package lib.employee.board.controller;
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.nio.file.Files;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.UUID;
//
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.core.io.Resource;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import lib.employee.board.model.AttachFileDTO;
//import lombok.extern.log4j.Log4j;
//import net.coobird.thumbnailator.Thumbnailator;
//
//@Controller
//@RequestMapping("board/*")
//@Log4j
//public class UploadController {
//
//	@PostMapping("/uploadFormAction.do")
//	public void uploadFormPost(MultipartFile[] uploadFile, Model model) {
//
//		String uploadFolder = "C:\\upload";
//
//		for (MultipartFile multipartFile : uploadFile) {
//			log.info("------------------------------------------");
//			log.info("Upload File Name: " + multipartFile.getOriginalFilename());
//			log.info("Upload File Size : " + multipartFile.getSize());
//
//			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
//
//			try {
//				multipartFile.transferTo(saveFile);
//			} catch (Exception e) {
//				log.error(e.getMessage());
//			} // end catch
//		} // end for
//
//	}
//
//	@GetMapping("/uploadAjax.do")
//	public void uploadAjax() {
//	}
//
//	private String getFolder() { // �궇吏쒕퀎濡� �뙆�씪 愿�由�
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = new Date();
//		String str = sdf.format(date);
//		return str.replace("-", File.separator);
//	}
//
//	// �뜽�꽕�씪
//	private boolean checkImageType(File file) {
//		try {
//			String contentType = Files.probeContentType(file.toPath());
//			return contentType.startsWith("image");
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
//
//	// 釉뚮씪�슦��濡� �뙆�씪 �쟾�넚
//	@PostMapping(value = "/uploadAjaxAction.do", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<List<AttachFileDTO>> uploadAjaxPost(@RequestParam("uploadFile") MultipartFile[] uploadFile) {
//		if (uploadFile != null) {
//			log.info(uploadFile.length);
//		}
//
//		List<AttachFileDTO> list = new ArrayList<>();
//		String uploadFolder = "C:\\upload";
//
//		String uploadFolderPath = getFolder();
//		File uploadPath = new File(uploadFolder, uploadFolderPath);
//
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		}
//
//		for (MultipartFile multipartFile : uploadFile) {
//
//			AttachFileDTO attachDTO = new AttachFileDTO();
//			String uploadFileName = multipartFile.getOriginalFilename();
//
//			// IE
//			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
//
//			log.info("only file name : " + uploadFileName);
//
//			attachDTO.setFileName(uploadFileName);
//
//			UUID uuid = UUID.randomUUID();
//
//			uploadFileName = uuid.toString() + "_" + uploadFileName;
//
//			try {
//				File saveFile = new File(uploadPath, uploadFileName);
//				multipartFile.transferTo(saveFile);
//
//				attachDTO.setUuid(uuid.toString());
//				attachDTO.setUploadPath(uploadFolderPath);
//
//				// �씠誘몄� �뙆�씪 泥댄겕
//				if (checkImageType(saveFile)) {
//					attachDTO.setImage(true);
//
//					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_" + uploadFileName));
//					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 100, 100);
//					thumbnail.close();
//				}
//				list.add(attachDTO);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		} // end for
//		return new ResponseEntity<>(list, HttpStatus.OK);
//
//	}
//
//	// �뜽�꽕�씪泥섎━- �뙆�씪�꽮 �씠由꾩쓣 諛쏆븘�꽌 �씠誘몄� �뜲�씠�꽣 �쟾�넚
//	@GetMapping("/display")
//	@ResponseBody
//	public ResponseEntity<byte[]> getFile(String fileName) {
//
//		log.info("fileName: " + fileName);
//		File file = new File("c:\\upload\\" + fileName);
//		log.info("file : " + file);
//
//		ResponseEntity<byte[]> result = null;
//
//		try {
//			HttpHeaders header = new HttpHeaders();
//
//			header.add("Content-Type", Files.probeContentType(file.toPath()));
//			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
//
//	@GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//	@ResponseBody
//	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String fileName) {
//
////		log.info("download file:" + fileName);
//		Resource resource = new FileSystemResource("c:\\upload\\" + fileName);
////		log.info("resource : " + resource);
//
//		if (resource.exists() == false) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		String resourceName = resource.getFilename();
//
//		// remove UUID - �썝�옒 �씠由꾩쑝濡� �떎�슫 諛쏆쓣 �닔 �엳寃� �븿
//		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);
//
//		HttpHeaders headers = new HttpHeaders();
//
//		try {
//			String downloadName = null;
//			if (userAgent.contains("Trident")) {
//				log.info("IE browser");
//				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
//			} else if (userAgent.contains("Edge")) {
//				log.info("Edge browser");
//				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
//				log.info("Edge name: " + downloadName);
//			} else {
//				log.info("Chrome browser");
//				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
//			}
//
//			headers.add("Content-Disposition", "attachment; filename=" + downloadName);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}
//
//	@PostMapping("/deleteFile.do")
//	@ResponseBody
//	public ResponseEntity<String> deleteFile(String fileName, String type) {
//
//		log.info("deleteFile: " + fileName);
//		File file;
//
//		try {
//			file = new File("c:\\upload\\" + URLDecoder.decode(fileName, "UTF-8"));
//
//			file.delete();
//
//			if (type.contentEquals("image")) {
//				String largeFileName = file.getAbsolutePath().replace("s_", "");
//				log.info("largeFileName: " + largeFileName);
//				file = new File(largeFileName);
//				file.delete();
//			}
//
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//
//		return new ResponseEntity<String>("deleted", HttpStatus.OK);
//	}
//
//}
