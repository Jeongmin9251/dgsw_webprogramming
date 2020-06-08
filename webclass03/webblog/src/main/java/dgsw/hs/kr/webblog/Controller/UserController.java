package dgsw.hs.kr.webblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dgsw.hs.kr.webblog.Domain.User;
import dgsw.hs.kr.webblog.Protocol.ResponseFormat;
import dgsw.hs.kr.webblog.Protocol.ResponseType;
import dgsw.hs.kr.webblog.Service.UserService;

@RestController // 컨트롤러
public class UserController {
    @Autowired // 의존성 주입
    private UserService userService; //DB 조작

    
    /** 
     * @param user 생성할 USER 객체
     * @return ResponseFormat 응답 포맷
     */
    @PostMapping("/user/create")
    public ResponseFormat create(@RequestBody User user){
        User newUser = userService.create(user);
        if(newUser != null){
            return new ResponseFormat(
                ResponseType.POST_ADD,
                newUser,
                newUser.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    
    /** 
     * @param id 업데이트 할 USER ID
     * @param user 업데이트 할 USER DATA
     * @return ResponseFormat 응답 포맷
     */
    @PutMapping("/user/update/{id}")
    public ResponseFormat update(@PathVariable Long id, @RequestBody User user){
        if(userService.update(id, user) != null){
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                userService.update(id, user),
                user.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    
    /** 
     * @param id 삭제할 USER ID
     * @return ResponseFormat 응답 포맷
     */
    @DeleteMapping("/user/delete/{id}")
    public ResponseFormat delete(@PathVariable Long id) {
        if(userService.delete(id)){
            return new ResponseFormat(
                ResponseType.POST_DELETE,
                userService.delete(id),
                id
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    
    /** 
     * @param id 조회 할 USER ID
     * @return ResponseFormat 응답 포맷
     */
    @GetMapping("/user/read/{id}")
    public ResponseFormat read(@PathVariable Long id){
        if(userService.read(id) != null){
            return new ResponseFormat(
                ResponseType.POST_GET,
                userService.read(id),
                id
            );

        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    
    /** 
     * @return ResponseFormat 응답 포맷
     */
    @GetMapping("/user/read")
    public ResponseFormat readAll(){
        if(userService.readAll() != null){
            return new ResponseFormat(
                ResponseType.POST_GET_ALL,
                userService.readAll()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}