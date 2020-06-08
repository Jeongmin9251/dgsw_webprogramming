package dgsw.hs.kr.webblog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 테이블 맵핑
@Data // Getter, Setter Setting
@NoArgsConstructor // 기본 생성자
public class Post {
    @Id // 기본키 맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false) // 컬럼 맵핑
    private Long userId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false)
    private List<Attachment> pictures;
    @CreationTimestamp // 시간 자동 생성
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 형식 지정
    private LocalDateTime created;
    @UpdateTimestamp // 시간 자동 업데이트
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modified;

    public Post(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }  
}