package id.co.cryptocore.cryptoapi.repository;

import id.co.cryptocore.cryptoapi.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String username);
}
