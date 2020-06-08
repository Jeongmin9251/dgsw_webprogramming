package dgsw.hs.kr.webblog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dgsw.hs.kr.webblog.Domain.User;
import dgsw.hs.kr.webblog.Repository.UserRepository;

@Service //Service 역할
public class UserServiceImpl implements UserService {
    
    @Autowired // 의존성 주입
    private UserRepository userRepository; // DB를 조작하는 레파지토리

    
    /** 
     * @param user 생성 할 USER 객체
     * @return User 생성한 USER 객체
     */
    @Override
    public User create(User user) {
        Optional<User> found = userRepository.findByAccount(user.getAccount());
        if (found.isPresent()) return null;
        return userRepository.save(user);
    }

    
    /** 
     * @param id 업데이트 할 USER ID
     * @param user 업데이트 할 USER DATA
     * @return User 업데이트한 USER 객체
     */
    @Override
    public User update(Long id, User user) {
        return userRepository.findById(id)
                .map(found -> {
                    found.setPassword(Optional.ofNullable(user.getPassword()).orElse(found.getPassword()));
                    found.setName(Optional.ofNullable(user.getName()).orElse(found.getName()));
                    found.setEmail(Optional.ofNullable(user.getEmail()).orElse(found.getEmail()));
                    found.setPhone(Optional.ofNullable(user.getPhone()).orElse(found.getPhone()));
                    found.setProfilePath(Optional.ofNullable(user.getProfilePath()).orElse(found.getProfilePath()));
                    return userRepository.save(found);
                })
                .orElse(null);
    }

    
    /** 
     * @param id 삭제 할 USER ID
     * @return boolean 삭제 성공 유무
     */
    @Override
    public boolean delete(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    /** 
     * @param id 읽어들일 USER ID
     * @return User 읽어들인 USER 객체
     */
    @Override
    public User read(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user.get() : null;
    }

    
    /** 
     * @return List<User> 전제 USER 반환
     */
    @Override
    public List<User> readAll() {
        return userRepository.findAll();
    }
}