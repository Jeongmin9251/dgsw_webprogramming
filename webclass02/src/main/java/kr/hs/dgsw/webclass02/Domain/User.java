package kr.hs.dgsw.webclass02.Domain;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @Generated
    private long id;
    private String username;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;
    private String storedPath;
    private String originalName;

    public User(String username, String email, String password, String storedPath, String originalName){
        this.username = username;
        this.email = email;
        this.password = password;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}