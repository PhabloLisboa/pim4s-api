package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.Cripto;
import unip.pim4s.pim4s.Repositories.CriptoRepository;
import unip.pim4s.pim4s.Requests.CriptoRequest;

@Service
public class CriptoService {

	@Autowired
	private CriptoRepository criptoRepository;

	public Iterable<Cripto> findAll() {
		return criptoRepository.findAll();
	}

	public Cripto create(CriptoRequest request) {
		Cripto cripto = new Cripto(request.getName(), request.getCotacao());

		criptoRepository.save(cripto);

		return cripto;
	}
}
