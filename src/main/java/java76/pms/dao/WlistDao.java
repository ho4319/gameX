package java76.pms.dao;

import java.util.List;

import java76.pms.domain.Wlist;

public interface WlistDao {
  List<Wlist> selectList();

  int delete(Wlist wlist);
}