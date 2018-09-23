package com.lzz.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lzz.entity.Student;
/**
   *   ����MyBatis����Ĳ��裺
 * 1������mybatis��
   *    �����ļ�config.xml���������ݿ���Ϣ �� ��Ҫ���ص�ӳ���ļ�����--�ࣩ
   *    ӳ���ļ�xxxMapper.xml����ɾ�Ĳ��ǩ<select>
 * 2��������
 * session.selectOne("��Ҫ��ѯ��SQL��namespace.id","SQL�Ĳ���ֵ")
 * @author CunsiALIEN
 *
 */
public class TestMyBatis {
	public static void main(String[] args) throws IOException {
		//����MyBatis�����ļ�
		Reader reader = Resources.getResourceAsReader("config.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//session - connection
		SqlSession session = sessionFactory.openSession();
		String statement = "com.lzz.entity.studentMapper.queryStudentById";
		Student student = session.selectOne(statement , 1); //��SQL��ֵ
		System.out.println(student);
		session.close();
	}
}
