package dgsw.hs.kr.webblog.Service;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgsw.hs.kr.webblog.Domain.Post;
import dgsw.hs.kr.webblog.Domain.User;
import dgsw.hs.kr.webblog.Repository.PostRepository;
import dgsw.hs.kr.webblog.Repository.UserRepository;

@Service // Service 역할
public class PostServiceImpl implements PostService{

    @Autowired // 의존성 주입
    private PostRepository postRepository; // DB를 조작하는 레파지토리

    @Autowired
    private UserRepository userRepository;

    @PostConstruct // 맨 처음 한 번만 수행
    private void init(){
        User user = userRepository.save(new User("MarkLee","1234","Mark","MarkLee@dgsw.hs.kr","010-1234-5678",""));
        postRepository.save(new Post(user.getId(),"안녕하세요.","첫 게시물입니다."));
    }

   
   /** 
    * @param post 생성 할 Post data
    * @return Post 생성한 post data
    */
   @Override
   public Post create(Post post) {
        return postRepository.save(post);
    }

    
    /** 
     * @param id 읽어들일 post ID
     * @return Post 읽어들인 post data
     */
    @Override
   public Post read(Long id) {
        return postRepository.findById(id).isPresent() ? postRepository.findById(id).get() : null;
    }

   
   /** 
    * @param userId 조회 할 USER ID
    * @return Post 작성자 본인이 작성한 post
    */
   @Override
   public Post readByUserId(Long userId) {
        return postRepository
        .findTopByUserIdOrderByIdDesc(userId)
        .orElse(null);
   }
    
    
    /** 
     * @param id 업데이트 할 포스트 ID
     * @param post 업데이트 할 포스트 객체
     * @return Post 업데이트한 포스트 객체
     */
    @Override
   public Post update(Long id, Post post) {
        return postRepository.findById(id)
                .map(found->{
                    found.setTitle(Optional.ofNullable(post.getTitle()).orElse(found.getTitle()));
                    found.setContent(Optional.ofNullable(post.getContent()).orElse(found.getContent()));
                    found.setPictures(Optional.ofNullable(post.getPictures()).orElse(found.getPictures()));
                    return postRepository.save(found);
                })
                .orElse(null);
   }

    
    /** 
     * @param id 삭제 할 포스트 ID
     * @return boolean 삭제 성공 유무
     */
    @Override
   public boolean delete(Long id) {
      try{
            postRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

   
   /** 
    * @return List<Post> 전체 포스트
    */
   @Override
   public List<Post> readAll() {
      
      return postRepository.findAll();
   }
    
}