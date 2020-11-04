package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Requests.LoginRequest;
import unip.pim4s.pim4s.Security.JwtService;
import unip.pim4s.pim4s.Services.AuthService;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService service;

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity login(@RequestBody LoginRequest request) {
		User logged = service.login(request.getEmail(), request.getPassword());

		if (logged != null) {
			logged.setToken(JwtService.generateToken(logged));
			return ResponseEntity.ok(logged);
		}

		return ResponseEntity.status(404).body("Email ou Senha incirretos!");
	}

}
