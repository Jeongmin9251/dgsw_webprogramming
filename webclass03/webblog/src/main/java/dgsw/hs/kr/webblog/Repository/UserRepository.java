package dgsw.hs.kr.webblog.Repository;

import dgsw.hs.kr.webblog.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // SQL에서 DB 조작하는 함수 자동 생성
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByAccount(String account);    
}