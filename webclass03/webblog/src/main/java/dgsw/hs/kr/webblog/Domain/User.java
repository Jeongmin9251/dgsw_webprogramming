package dgsw.hs.kr.webblog.Domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity // 테이블 맵핑
@Data // Getter, Setter Setting
@NoArgsConstructor // 기본 생성자
public class User {
    @Id // 기본키 맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, unique = true, length = 20) // unique 값 20자 이하
    private String account;
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // JSON으로 변환 시에 사용할 이름
    private String password;

    public void setPassword(String password){ // 패스워드 암호화
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-512"); // 패스워드 저장
            md.update(password.getBytes(),0,password.getBytes().length);
            this.password = new BigInteger(1,md.digest()).toString(16);
            
        }catch(NoSuchAlgorithmException e){
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
        }
    }

    @Column(nullable = false)
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String profilePath;
    @CreationTimestamp
    @Column(updatable = false,nullable = false) // 수정 불가능
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime modified;

    // 입력받는 생성자
    public User(String account, String password, String name, String email, String phone, String profilePath){
        this.account = account;
        setPassword(password);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePath = profilePath;
    }
}