package dgsw.hs.kr.webblog.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity // 테이블 맵핑
@Data // Getter, Setter Setting
public class Attachment {
    @Id // 기본키 맵핑
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment 사용
    private Long id;
    private String storedPath;
    private Long postId;    
}