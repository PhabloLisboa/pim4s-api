package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.Client;
import unip.pim4s.pim4s.Requests.ClientRequest;
import unip.pim4s.pim4s.Services.ClientService;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientController {
	@Autowired
	private ClientService service;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity create(@RequestBody ClientRequest request) {
		try {
			Client created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}
}
