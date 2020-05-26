package kr.hs.dgsw.webclass02.Service;

import kr.hs.dgsw.webclass02.Domain.Comment;
import kr.hs.dgsw.webclass02.Protocol.CommentUsernameProtocol;

import java.util.List;

public interface CommentService {
    CommentUsernameProtocol add(Comment comment);
    boolean remove(Long id);
    CommentUsernameProtocol update(Long id, Comment comment);
    CommentUsernameProtocol view(Long id);
    List<CommentUsernameProtocol> listAllComments();
}