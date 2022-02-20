package com.omc.sales.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;
import com.omc.sales.dto.FileUploadResponseDTO;
import com.omc.sales.service.FileStorageService;
import org.springframework.http.HttpHeaders;
@RestController
public class FileController {
	
	@Autowired
	private FileStorageService fileStorageService;
	
	@RequestMapping(value = "/uploadsfile", method = RequestMethod.POST)
	    public FileUploadResponseDTO uploadFile(@RequestParam("file") MultipartFile file) {
	        String fileName = fileStorageService.storeFile(file);

	        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                .path("/downloadfile")
	                .path(fileName)
	                .toUriString();

	        return new FileUploadResponseDTO(fileName, fileDownloadUri,
	                file.getContentType(), file.getSize());
	    }
	 
	 @GetMapping("/downloadfile/{fileName}")
	    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
	        
	        Resource resource = fileStorageService.loadFileAsResource(fileName);

	        // Try to determine file's content type
	        String contentType = null;
	        try {
	            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
	        } catch (IOException ex) {
	        	ex.getMessage();
	           // logger.info("Could not determine file type.");
	        }

	        // Fallback to the default content type if type could not be determined
	        if(contentType == null) {
	            contentType = "application/octet-stream";
	        }

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(contentType))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
	    }

}
