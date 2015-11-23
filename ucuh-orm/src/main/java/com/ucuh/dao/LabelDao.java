package com.ucuh.dao;

import com.ucuh.entity.Label;

import java.util.List;

public interface LabelDao {
     //根据type类型读取所有的label
	 List<Label> findByType(int type);
	//根据等级查询相关list
	List<Label> findByGrade(int grade, int type);
	//根据父节点查询list
	List<Label> findByParentId(int parentId, int type);
	//通过type查询并通过treeCode排序
	List<Label> findByTypeAndTreeCodeAsc(int type);
	//通过type查询并通过treeCode排序 可购标签除外
	List<Label> findByTypeAndTreeCodeAsc1(int type);
	//通过type查询并通过treeCode排序 只查询可购标签
	List<Label> findByTypeAndTreeCodeAsc2(int type);
	//通过id查询一个标签信息
	Label findByID(int id);
	//保存更新一个Label
	void saveLabel(Label label);
	//对自定义标签进行模糊查询
	List<Label> findBySouSuo(String sousuo, int type);
	//删除一个系统标签
	void deleteLabel(Label label);
	//通过parentId查询
	List<Label> findByParentId(int parentId);
	//通过type,parentId,grade查询
	Label findByTPG(int type, int parentId, int grade);
}
