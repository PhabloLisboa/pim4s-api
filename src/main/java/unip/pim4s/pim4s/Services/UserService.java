package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Repositories.UserRepository;
import unip.pim4s.pim4s.Requests.UserRequest;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public User create(UserRequest request) {
		User user = new User(request.getEmail(), new BCryptPasswordEncoder().encode(request.getPassword()));
		userRepository.save(user);
		return user;
	}

	public User findByEmail(String email) {
		User user = userRepository.findByEmail(email);

		return user;
	}

}
