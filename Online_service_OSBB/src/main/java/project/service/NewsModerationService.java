package project.service;

import java.util.List;

import project.dto.form.NewsModerationForm;
import project.entity.NewsModeration;

public interface NewsModerationService {

	List<NewsModeration> findAll();
	NewsModeration findOne(long id);
	void delete(long id); 
	void save(NewsModerationForm form);
//	NewsModerationForm findForm(long id);
//	NewsModeration findByNews(String theme);
}
