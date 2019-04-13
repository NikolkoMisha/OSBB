package project.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.dto.form.NewsModerationForm;
import project.entity.NewsModeration;
import project.repository.NewsModerationRepository;
import project.service.NewsModerationService;
//import project.service.NewsService;

@Service
public class NewsModerationServiceImpl implements NewsModerationService{

	@Autowired
	private NewsModerationRepository newsModerationRepository;
//	@Autowired
//	private NewsService newsService;
	
	@Override
	public List<NewsModeration> findAll() {
		return newsModerationRepository.findAll();
	}

	@Override
	public NewsModeration findOne(long id) {
		return newsModerationRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		newsModerationRepository.delete(id);
	}

	@Override
	public void save(NewsModerationForm form) {
		NewsModeration moderation = new NewsModeration();
//		News news = newsService.findOne(id);
		moderation.getId();
//		moderation.setId(form.getId());
		moderation.setTheme(form.getTheme());
		moderation.setText(form.getText());
		moderation.setNewsId(form.getUserId());
		moderation.setVersion(form.getVersion());
		moderation = newsModerationRepository.saveAndFlush(moderation);
		newsModerationRepository.save(moderation);
	}

//	@Override
//	public NewsModerationForm findForm(long id) {
//		News news = newsService.findOne(id);
//		NewsModerationForm form = new NewsModerationForm();
//		form.setId(news.getId());
//		form.setTheme(news.getTheme());
//		form.setText(news.getText());
//		return form;
//	}

//	@Override
//	public NewsModeration findByNews(String theme) {
//		return newsModerationRepository.;
//	}

}
