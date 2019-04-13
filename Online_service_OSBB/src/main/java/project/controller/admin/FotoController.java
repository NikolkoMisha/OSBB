package project.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.dto.form.FotoForm;
import project.dto.form.NewsForm;
import project.entity.Foto;
import project.service.FotoService;
import project.service.NewsService;

@Controller
@RequestMapping("/admin/Option/Foto")
public class FotoController {


	@Autowired
	private FotoService fotoService;
	
	
	
	@ModelAttribute("foto")
	public FotoForm getForm(){
		return new FotoForm();
	}
	
	@GetMapping
	public String show( Model model){

		HashMap<Long, Integer> foto1 = new HashMap<>();
		try{
			foto1.put(fotoService.findAll().get(0).getId(), fotoService.findAll().get(0).getVersion());
		}catch (IndexOutOfBoundsException e) {
			return "admin-Foto";
		}
		HashMap<Long, Integer> foto2 = new HashMap<>();
		try{
			foto2.put(fotoService.findAll().get(1).getId(), fotoService.findAll().get(1).getVersion());
		}catch (IndexOutOfBoundsException e) {
			return "admin-Foto";
		}
		HashMap<Long, Integer> foto3 = new HashMap<>();
		try{
			foto3.put(fotoService.findAll().get(2).getId(), fotoService.findAll().get(2).getVersion());
		}catch (IndexOutOfBoundsException e) {
			return "admin-Foto";
		}
		HashMap<Long, Integer> foto4 = new HashMap<>();
		try{
			foto4.put(fotoService.findAll().get(3).getId(), fotoService.findAll().get(3).getVersion());
		}catch (IndexOutOfBoundsException e) {
			return "admin-Foto";
		}	
		model.addAttribute("foto1", foto1);
		model.addAttribute("foto2", foto2);
		model.addAttribute("foto3", foto3);
		model.addAttribute("foto4", foto4);
		model.addAttribute("fotos", fotoService.findAll());
		return "admin-Foto";
	}
	
//	@GetMapping("/update/{id}")
//	public String update(@PathVariable Integer id, Model model){
//		model.addAttribute("battery", batteryService.findOne(id));
//		return show(model);
//	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable long id){
		fotoService.delete(id);
		return "redirect:/admin/Option/Foto";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("foto")  FotoForm form, BindingResult br,Model model ){
	
		fotoService.save(form);
		return "redirect:/admin/Option/Foto";
	}
}
