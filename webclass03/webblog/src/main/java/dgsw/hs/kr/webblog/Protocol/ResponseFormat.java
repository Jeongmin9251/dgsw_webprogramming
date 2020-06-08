package dgsw.hs.kr.webblog.Protocol;

import lombok.Data;

@Data
public class ResponseFormat {
    private int code; // 응답 코드
    private String desc; // 응답 메세지
    private Object data; // 응답 데이터

    // 데이터 ID를 메세지에 삽입
    public ResponseFormat(ResponseType rt, Object data, Object option){
        this.code = rt.code();
        this.desc = option instanceof Long || option instanceof String // 참조하고 있는 인스턴스의 실제 타입
                ? String.format(rt.desc(), option)
                : rt.desc();
        this.data = data;
    }

    // ID가 필요없는 생성자
    public ResponseFormat(ResponseType rt, Object data){
        this(rt,data,null);
    }
}