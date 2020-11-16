package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Repositories.RoleRepository;
import unip.pim4s.pim4s.Repositories.UserRepository;
import unip.pim4s.pim4s.Requests.UserRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public User create(UserRequest request) {
		User user = new User(request.getEmail(), request.getPassword(), request.getPhone(),
				roleRepository.findById(request.getRoleId()).get()

		);
		userRepository.save(user);
		return user;
	}

	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);

		return user;
	}

	public User findOne(Integer id) {
		User user = userRepository.findById(id).get();

		return user;
	}

	public void delete(Integer id) {
		User user = userRepository.findById(id).get();

		userRepository.delete(user);
	}

}
