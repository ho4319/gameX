package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Comment;

public interface CommentDao {
  List<Comment> selectList();
  
  int insert(Comment comment);
  
  int delete(Comment comment);
  
  int update(Comment comment);
}







