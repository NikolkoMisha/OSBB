package project.service;

import org.springframework.web.multipart.MultipartFile;



public interface FileWriter {

	enum Folder{
		 NEWS,ATTENTION,PROPOSITIONS,OSBBFOTO,OSBBINFO
	}
	
	boolean write(Folder folder, MultipartFile file, Long id);
}
