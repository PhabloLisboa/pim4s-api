package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Requests.TokenRequest;
import unip.pim4s.pim4s.Requests.UserRequest;
import unip.pim4s.pim4s.Services.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping("/users")
	public Iterable<User> getAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/token")
	public Object getByToken(@RequestBody TokenRequest request) {

		return JWT.decode(request.getToken()).getSubject();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public ResponseEntity create(@RequestBody UserRequest request) {
		try {
			User created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/users/{id}")
	public ResponseEntity findOne(@PathVariable(value = "id") String id) {
		try {
			User finded = service.findOne(Integer.valueOf(id));
			return ResponseEntity.ok(finded);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/users/delete/{id}")
	public ResponseEntity delete(@PathVariable(value = "id") String id) {
		try {
			service.delete(Integer.valueOf(id));
			return ResponseEntity.ok("deleted");
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}
}
