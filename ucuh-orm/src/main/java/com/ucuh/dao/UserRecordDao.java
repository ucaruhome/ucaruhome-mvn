package com.ucuh.dao;

import com.ucuh.entity.UserRecord;

public interface UserRecordDao {
 //保存一条记录
 void saveUserRecord(UserRecord ur);
 //删除一条记录
 void delUserRecord(UserRecord ur);
}
