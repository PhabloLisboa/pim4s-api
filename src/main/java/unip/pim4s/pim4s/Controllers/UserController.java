package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Requests.UserRequest;
import unip.pim4s.pim4s.Services.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;

	@GetMapping
	public Iterable<User> getAll() {
		return service.findAll();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity create(@RequestBody UserRequest request) {
		try {
			User created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}
}
