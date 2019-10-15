package lib.employee.board.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lib.employee.board.mapper.BoardAttachMapper;
import lib.employee.board.model.BoardAttachDTO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class FileCheckTask {
	
	@Setter(onMethod_= { @Autowired})
	private BoardAttachMapper attachMapper;
	
	private String getFolderYesterDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		String str = sdf.format(cal.getTime());
		return str.replace("-", File.separator);
	}
	
	@Scheduled(cron="0 * * * * *")//0 0 15 * * * : 매일 오후 세시 // 매일 새벽 두 시 : 0 0 2 * * *	//1분마다 : 0 * * * * *
	public void checkFiles() throws Exception {
		log.warn("file Check task run.........");
		log.warn(new Date());
		
		//db에 남은 파일 목록
		List<BoardAttachDTO> fileList = attachMapper.getOldFiles();
		
		List<Path> fileListPaths = fileList.stream()
									.map(dto -> Paths.get("C:\\upload", dto.getUploadPath(),
									dto.getUuid()+ "_" + dto.getFileName()))
									.collect(Collectors.toList());
		//이미지 파일 썸네일 처리
		fileList.stream().filter(dto -> dto.isFileType() == true)
				.map(dto -> Paths.get("C:\\upload", dto.getUploadPath(), "s_" +
				dto.getUuid() + "_" + dto.getFileName()))
				.forEach(p -> fileListPaths.add(p));
		log.warn("===================================");
		fileListPaths.forEach(p -> log.warn(p));
		
		//어제 날짜 파일
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
		File[] removeFiles = targetDir.listFiles(file -> fileListPaths.contains(file.toPath())==false);
		log.warn("---------------------------------------");
		for (File file : removeFiles) {
			log.warn(file.getAbsoluteFile());
			file.delete();
		}
	}
}
