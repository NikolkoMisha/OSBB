package project.controller.user;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.entity.User;
import project.entity.UserInfo;
import project.service.ReceiptsService;
import project.service.UserInfoService;
import project.service.UserService;

@Controller
@RequestMapping("/Receipts")
public class ReceiptsController {

	@Autowired
	private ReceiptsService receiptsService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserInfoService userInfoService;
	
		@GetMapping
		public String receipts(Model model, Principal principal
				,@PageableDefault(sort = "date", direction = Sort.Direction.DESC, value=1)  Pageable pageable){

			List<String> unit = new ArrayList<>();
			List<String> exception = new ArrayList<>();
			exception.add("У адміністрації сайту немає квитанцій.");
			unit.add("куб.");
			unit.add("куб.");
			unit.add("ГКал");
			model.addAttribute("units", unit);
			try{
				User user = userService.findByLogin(principal.getName());
				UserInfo userInfo = userInfoService.findBySurname(user.getSurname(), principal);
				model.addAttribute("user", userInfoService.findForm(userInfo.getId()));
			}catch (NullPointerException e) {
				model.addAttribute("exception", exception);
			}
			try{
				model.addAttribute("page", receiptsService.findByUserId(principal, pageable));
			}catch (NullPointerException  e) {
				model.addAttribute("exception", exception);
			}
			
//			model.addAttribute("receipts", receiptsService.findByUserId(principal));
			return "user-Receipts";
		}


}
