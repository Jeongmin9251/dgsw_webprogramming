package dgsw.hs.kr.webblog.Repository;

import dgsw.hs.kr.webblog.Domain.Post;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // SQL에서 DB 조작하는 함수 자동 생성
public interface PostRepository extends JpaRepository<Post, Long>{
    Optional<Post> findTopByUserIdOrderByIdDesc(Long userId);    
}