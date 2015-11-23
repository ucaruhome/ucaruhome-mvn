package com.ucuh.dao;

import com.ucuh.entity.Code;

public interface CodeDao {
  //保存一个Code
  void saveCode(Code code);
  //删除一个Code
  void delCode(Code code);
  //通过userKey查询
  Code findByUserKey(String userKey);
}
