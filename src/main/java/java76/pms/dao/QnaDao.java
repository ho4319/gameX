package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Qna;

public interface QnaDao {
  List<Qna> selectList();
  
  int insert(Qna qna);
  
  int delete(int no);
  
  int update(Qna qna);

  Qna selectOne(int no);
  
}