package com.lzz.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzz.entity.Student;
/**
   *   开发MyBatis程序的步骤：
 * 1、配置mybatis：
   *    配置文件config.xml：配置数据库信息 和 需要加载的映射文件（表--类）
   *    映射文件xxxMapper.xml：增删改查标签<select>
 * 2、测试类
 * session.selectOne("需要查询的SQL的namespace.id","SQL的参数值")
 * @author CunsiALIEN
 *
 */
public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		//加载MyBatis配置文件
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session - connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper.queryStudentById";
		Student student = session.selectOne(statement , 1); //给SQL传值
		System.out.println(student);
		session.close();
	}
}
