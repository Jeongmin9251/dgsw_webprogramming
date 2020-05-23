package kr.hs.dgsw.webclass02.Service;

import java.util.List;

public interface UserService {
    User add(User user);
    User login(String email, String password);
    User update(User user);
    boolean delete(String id);
    User view(String id);
    List<User> list(); 
}