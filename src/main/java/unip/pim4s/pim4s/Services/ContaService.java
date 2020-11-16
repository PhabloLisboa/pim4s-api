package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.Conta;
import unip.pim4s.pim4s.Repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repository;

	public Iterable<Conta> findAll() {
		return repository.findAll();
	}

	public Conta get(Integer id) {
		return repository.findById(id).get();
	}

	public Conta depositar(Integer id, Double value) {
		Conta conta = repository.findById(id).get();
		conta.setSaldo(conta.getSaldo() + value);

		repository.save(conta);

		return conta;
	}

	public Conta sacar(Integer id, Double value) {
		Conta conta = repository.findById(id).get();

		if (conta.getSaldo() >= value)
			conta.setSaldo(conta.getSaldo() - value);

		repository.save(conta);

		return conta;
	}

}
