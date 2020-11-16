package unip.pim4s.pim4s.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import unip.pim4s.pim4s.Models.Investment;
import unip.pim4s.pim4s.Requests.InvestimentRequest;
import unip.pim4s.pim4s.Services.InvestmentService;

@RestController
@CrossOrigin("*")
public class InvestmentController {

	@Autowired
	private InvestmentService service;

	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.POST, path = "/investimentos")
	public ResponseEntity create(@RequestBody InvestimentRequest request) {
		try {
			Investment created = service.create(request);
			return ResponseEntity.ok(created);
		} catch (Exception e) {
			return ResponseEntity.status(400).body(e);
		}
	}
}
