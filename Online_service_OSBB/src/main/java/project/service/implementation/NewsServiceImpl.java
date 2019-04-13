package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.NewsForm;
import project.dto.form.NewsModerationForm;
import project.entity.News;
import project.repository.NewsRepository;
import project.service.FileWriter;
import project.service.FileWriter.Folder;
import project.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;
	
	@Autowired
	private FileWriter fileWriter;
	
	@Override
	public List<News> findAll() {
		return newsRepository.findAll();
	}

	@Override
	public News findOne(Long id) {
		return newsRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		newsRepository.delete(id);
	}

	@Override
	public void save(NewsForm form) {
		News news = new News();
		news.setId(form.getId());
		news.setTheme(form.getTheme());
		news.setText(form.getText());
		news = newsRepository.saveAndFlush(news);
		if(fileWriter.write(Folder.NEWS, form.getFile(), news.getId())){
		if(news.getVersion()==null)news.setVersion(0);
		else news.setVersion(news.getVersion()+1);}
		newsRepository.save(news);
	}

	@Override
	public News findById(long id) {
		return newsRepository.findById(id);
	}

	@Override
	public NewsModerationForm findForm(long id) {
		News news = newsRepository.findOne(id);
		NewsModerationForm form = new NewsModerationForm();
//		form.setId(news.getId());
		form.setTheme(news.getTheme());
		form.setText(news.getText());
		form.setUserId(news.getId());
		form.setVersion(news.getVersion());
		return form;
	}

}
