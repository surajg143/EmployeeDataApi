package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping(path="/demo")
public class DetailsController {
	  
	@Autowired 
	 private EmployeeRepository empRepo;
	
	
	  @PostMapping(path="/add")
	  public  String addNewUser (@RequestBody Details d){
		  empRepo.save(d);
	    return "Saved Data";
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<Details> getAllUsers() {
	    return empRepo.findAll();
	  }
	  
	  @GetMapping(path="/emp/{id}")
	  public @ResponseBody Iterable<Details> getUser(@PathVariable Integer id) {
	    return empRepo.findAllById(id);
	    
	  }
	  
	  @PutMapping("/update")
	  public String updateEmpDetails(@RequestBody Details d)
	  {
//		  if(d.getId()!=nul
			  empRepo.save(d);
		  return "Updated Data";
	  }
	  
	  @DeleteMapping("/del/{id}")
	  public String deleteEmpDetails(@PathVariable int id)
	  {
		  empRepo.deleteById(id);
		  return "Deleted Data";
	  }
}