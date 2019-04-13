package project.service;

import java.util.List;

import project.dto.form.NewsForm;
import project.dto.form.NewsModerationForm;
import project.entity.News;

public interface NewsService {

	List<News> findAll();
	News findOne(Long id);
	void delete(long id); 
	void save(NewsForm form);
	News findById(long id);
	NewsModerationForm findForm(long id);
	
}
