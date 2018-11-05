package it.zoologic.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.zoologic.business.ZoologyService;
import it.zoologic.domain.AreaGeografica;

@RestController
@RequestMapping("/api/area")
public class RESTAreaController {

	@Autowired
	private ZoologyService service;
	
	@GetMapping
	public List<AreaGeografica> list() {
		return service.findAllAreas();
	}	
	
}
