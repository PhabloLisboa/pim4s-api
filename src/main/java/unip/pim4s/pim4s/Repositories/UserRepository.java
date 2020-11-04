package unip.pim4s.pim4s.Repositories;

import org.springframework.data.repository.CrudRepository;

import unip.pim4s.pim4s.Models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	User findByEmail(String email);
}
