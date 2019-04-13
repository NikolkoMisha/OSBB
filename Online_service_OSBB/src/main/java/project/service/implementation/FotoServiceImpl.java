package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.FotoForm;
import project.dto.form.NewsForm;
import project.entity.Foto;
import project.entity.News;
import project.repository.FotoRepository;
import project.repository.NewsRepository;
import project.service.FotoService;
import project.service.FileWriter;
import project.service.FileWriter.Folder;

@Service
public class FotoServiceImpl implements FotoService{

	@Autowired
	private FotoRepository fotoRepository;
	@Autowired
	private FileWriter fileWriter;
	
	
	
	@Override
	public List<Foto> findAll() {
		return fotoRepository.findAll();
	}

	@Override
	public Foto findOne(long id) {
		return fotoRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		fotoRepository.delete(id);
	}

	@Override
	public void save(FotoForm form) {
		Foto foto = new Foto();
		foto.setId(form.getId());
		foto.setNameFoto(form.getNameFoto());
		foto = fotoRepository.saveAndFlush(foto);
		if(fileWriter.write(Folder.OSBBFOTO, form.getFile(), foto.getId())){
		if(foto.getVersion()==null)foto.setVersion(0);
		else foto.setVersion(foto.getVersion()+1);}
		fotoRepository.save(foto);
	}

//	@Override
//	public News findByNews(String theme) {
//		return newsRepository.findByTheme(theme);
//	}

	@Override
	public FotoForm findForm(long id) {
		return null;
	}

}
