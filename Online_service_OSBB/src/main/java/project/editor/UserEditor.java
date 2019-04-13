package project.editor;

import java.beans.PropertyEditorSupport;

import project.entity.User;
import project.service.UserService;

public class UserEditor extends PropertyEditorSupport{

	private final UserService userService;

	public UserEditor(UserService userService) {
		this.userService = userService;
	}
	 
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = userService.findOne(Integer.valueOf(text));
		setValue(user);
	}
	
}
