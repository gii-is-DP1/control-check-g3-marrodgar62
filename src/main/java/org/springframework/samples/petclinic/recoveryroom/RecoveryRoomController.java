package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recoveryroom")
public class RecoveryRoomController {
    
	@Autowired
	RecoveryRoomService service;
	
	public static final String FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";
	
	
	@GetMapping("/create")
	public String create(ModelMap model) {
		RecoveryRoom recoverRoom = new RecoveryRoom();
		model.addAttribute("recoveryRoom", recoverRoom);
		return FORM;
	}
	
	@PostMapping("/create")
	public String create(@Valid RecoveryRoom rr, BindingResult result) {
		String welcome = "welcome";
		if(result.hasErrors()) {
			return FORM;
		} else {
			service.save(rr);
			return welcome;
		}
	}
	
}
