package dgsw.hs.kr.webblog.Service;

import java.util.List;

import dgsw.hs.kr.webblog.Domain.User;

// USER 관련 함수 선언
public interface UserService {
    User create(User user);
    User read(Long id);
    User update(Long id, User user);
    boolean delete(Long id);
    List<User> readAll();
}