package kr.hs.dgsw.webclass02.Repository;

import kr.hs.dgsw.webclass02.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}