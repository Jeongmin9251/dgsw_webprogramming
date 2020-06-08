package dgsw.hs.kr.webblog.Service;

import java.util.List;

import dgsw.hs.kr.webblog.Domain.Post;

// DATA 관련 함수 선언
public interface PostService {
    Post create(Post post);
    Post read(Long id);
    Post readByUserId(Long userId);
    Post update(Long id, Post post);
    boolean delete(Long id);
    List<Post> readAll();    
}