package com.ucuh.dao;

import com.ucuh.entity.Wordbook;

import java.util.List;

public interface WordbookDao {
  //保存一个信息
  void saveWordbook(Wordbook wb);
  //通过leixing,name,activityId查询
  Wordbook findByLNA(String leixing, String name, int activityId);
  //通过activityId查询
  List<Wordbook> findByActivityId(int activityId, String leixing);
}
