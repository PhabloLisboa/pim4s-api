package unip.pim4s.pim4s.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import unip.pim4s.pim4s.Models.User;
import unip.pim4s.pim4s.Repositories.UserRepository;

@Service
public class AuthService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public User login(String email, String password) {
		User user = userRepository.findByEmail(email);

		if (user != null) {
			return bCryptPasswordEncoder.matches(password, user.getPassword()) ? user : null;
		}

		return null;
	}
}
