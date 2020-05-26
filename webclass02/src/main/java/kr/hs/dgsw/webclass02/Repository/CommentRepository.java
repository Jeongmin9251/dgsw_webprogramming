package kr.hs.dgsw.webclass02.Repository;

import kr.hs.dgsw.webclass02.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}