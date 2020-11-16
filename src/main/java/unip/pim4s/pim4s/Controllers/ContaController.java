package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.Conta;
import unip.pim4s.pim4s.Services.ContaService;

@RestController
@CrossOrigin("*")
public class ContaController {

	@Autowired
	private ContaService service;

	@RequestMapping("/contas")
	public Iterable<Conta> getAll() {
		return service.findAll();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/contas/{id}")
	public ResponseEntity getOne(@PathVariable(value = "id") String id) {
		try {
			Conta conta = service.get(Integer.valueOf(id));
			return ResponseEntity.ok(conta);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/contas/{id}/depositar/{value}")
	public ResponseEntity depositar(@PathVariable(value = "id") String id,
			@PathVariable(value = "value") String value) {
		try {
			Conta conta = service.depositar(Integer.valueOf(id), Double.valueOf(value));
			return ResponseEntity.ok(conta);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/contas/{id}/sacar/{value}")
	public ResponseEntity sacar(@PathVariable(value = "id") String id, @PathVariable(value = "value") String value) {
		try {
			Conta conta = service.sacar(Integer.valueOf(id), Double.valueOf(value));
			return ResponseEntity.ok(conta);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}
}
