package java76.pms.dao;

import java.util.List;
import java.util.Map;

import java76.pms.domain.Sell;

public interface SellDao {
  List<Sell> selectList(Map<String,Object> paramMap);
  
  int insert(Sell sell);
  
  int delete(int no);
  
  int update(Sell sell);

  Sell selectOne(int no);
  
}