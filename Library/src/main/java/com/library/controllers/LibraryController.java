package com.library.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.library.dao.LibraryDTO;
//import com.casestudy.models.Employee;
import com.library.entities.Admin;
import com.library.entities.Library;
import com.library.services.AdminServices;
import com.library.services.LibraryServices;

@Controller

//@Validated
public class LibraryController {
	@Autowired
	private AdminServices adminservice;
	@Autowired
	private LibraryServices libraryservice;
	@Autowired
	private RestTemplate resttemplate;
	
	@GetMapping("/login")
	public String index(@ModelAttribute("admin")Admin admin,Model model) {
//		model.addAttribute("admin", new Admin());
		model.addAttribute("admin", new Admin());
		return "login";
	}

	@PostMapping("/homepage")
	public String login(@ModelAttribute("admin")Admin admin,Model model) {
		Admin adm=adminservice.ValidateAdmin(admin.getUsername(), admin.getPassword());
//		List<Library> library=libraryservice.getAllLibrary();
		LibraryDTO library=resttemplate.getForObject("http://localhost:8086/login", LibraryDTO.class);
		
		model.addAttribute("library", library.getLibrary());
		
		return "LibraryHomePage";
		
	}
	

	//Controller for deleting
	@GetMapping("/delete-record")
	public String delete(@RequestParam("student_id")int student_id,Model model) {
//		System.out.println(name_of_the_stud);
//		libraryservice.deleteRecord(student_id);
//		resttemplate.getForObject("http://localhost:8086/delete-record", )
		Map<String, String> map = new HashMap<String, String>();
		map.put("student_id", Integer.toString(student_id));
		
		
		
		UriComponentsBuilder builder  = UriComponentsBuilder.fromHttpUrl("http://localhost:8086/delete-record");
		for(Map.Entry<String, String> entry : map.entrySet())
		{
			builder.queryParam(entry.getKey(), entry.getValue());
			
		}
		ResponseEntity<String> response =   resttemplate.exchange(builder.toUriString(), HttpMethod.DELETE, null, String.class, map);
		
		
		
		LibraryDTO library=resttemplate.getForObject("http://localhost:8086/login", LibraryDTO.class);
		System.out.println(library.getLibrary());
		model.addAttribute("library", library.getLibrary());
		
		return "LibraryHomePage";
	}
	//Controller for inserting
	@PostMapping(value="/insert_operation")
	public ModelAndView insert(Library library1) {
		ModelAndView mav=new ModelAndView();
		System.out.println(library1);
//		libraryservice.insertRecord(library1);
		Library lib=resttemplate.postForObject("http://localhost:8086/insert-record", library1, Library.class);
//		List<Library> library=libraryservice.getAllLibrary();
		LibraryDTO library=resttemplate.getForObject("http://localhost:8086/login", LibraryDTO.class);

		mav.addObject("library", library.getLibrary());
		mav.setViewName("LibraryHomePage");
		return mav;
	}
	//Controller for updating
	@GetMapping(value="/update-record")
	public ModelAndView update(Library library) {
		ModelAndView mav=new ModelAndView();
		System.out.println(library);
		mav.addObject("library", library);
		mav.setViewName("UpdateRecord");
		return mav;
	}
	
	@PostMapping(value="/after-update")
	public ModelAndView afterUpdate(Library library1) {
		ModelAndView mav=new ModelAndView();
		System.out.println(library1);
		Library lib=resttemplate.postForObject("http://localhost:8086/update-record",library1,Library.class);
		LibraryDTO library=resttemplate.getForObject("http://localhost:8086/login", LibraryDTO.class);
		mav.addObject("library", library.getLibrary());
		mav.setViewName("LibraryHomePage");
		return mav;
		
	}
}
