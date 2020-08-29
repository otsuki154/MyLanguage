package com.thanhduyen.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.thanhduyen.springmybatis.entity.Farmily;
import com.thanhduyen.springmybatis.util.MyBatisUtil;

@Repository
public class FarmilyMapper {
	
	public void saveFarmily(Farmily farmily){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertFarmily", farmily);
		session.commit();
		session.close();
	}
	
	public void updateFarmily(Farmily farmily){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateFarmily", farmily);
		session.commit();
		session.close();
	}
	
	public void deleteFarmily(int farmilyId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteFarmily", farmilyId);
		session.commit();
		session.close();
	}
	
	public List<Farmily> getAllFarmilys(){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Farmily> farmilysList = session.selectList("getAllFarmilys");
		session.commit();
		session.close();
		return farmilysList;
	}
	
	public Farmily findById(int farmilyId){
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		Farmily farmily = (Farmily) session.selectOne("findById", farmilyId);
		session.commit();
		session.close();
		return farmily;
	}
}
