package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.Cripto;
import unip.pim4s.pim4s.Requests.CriptoRequest;
import unip.pim4s.pim4s.Services.CriptoService;

@RestController
@CrossOrigin("*")
public class CriptoController {

	@Autowired
	private CriptoService service;

	@RequestMapping("/criptos")
	public Iterable<Cripto> getAll() {
		return service.findAll();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, path = "/criptos")
	public ResponseEntity create(@RequestBody CriptoRequest request) {
		try {
			Cripto created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}

}
