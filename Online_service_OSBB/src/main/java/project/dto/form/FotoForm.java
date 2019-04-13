package project.dto.form;

import org.springframework.web.multipart.MultipartFile;

public class FotoForm {

private long id;
	
	private String nameFoto;
	
	
	private MultipartFile file;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String getNameFoto() {
		return nameFoto;
	}

	public void setNameFoto(String nameFoto) {
		this.nameFoto = nameFoto;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
