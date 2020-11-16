package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.Client;
import unip.pim4s.pim4s.Models.Conta;
import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Repositories.ClientRepository;
import unip.pim4s.pim4s.Repositories.ContaRepository;
import unip.pim4s.pim4s.Repositories.RoleRepository;
import unip.pim4s.pim4s.Repositories.UserRepository;
import unip.pim4s.pim4s.Requests.ClientRequest;

@Service
public class ClientService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ContaRepository contaRepository;

	@Autowired
	private ClientRepository clientRepository;

	public Client create(ClientRequest request) {
		User user = new User(request.getEmail(), request.getPassword(), request.getPhone(),
				roleRepository.findById(request.getRoleId()).get()

		);
		userRepository.save(user);

		Conta conta = new Conta(request.getCarteira());
		contaRepository.save(conta);

		Client client = new Client(request.getName(), conta, user);
		clientRepository.save(client);

		return client;

	}
}
