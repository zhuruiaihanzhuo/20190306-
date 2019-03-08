package db;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//访问数据库类
public class DBA {
		public SqlSession getSqlSession() throws IOException {
			//1.通过配置文件获取数据库连接信息
			Reader reader= Resources.getResourceAsReader("config/Configuration.xml");
			
			//2.通过配置信息构建sqlsessionFactory
			SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
			//3.通过sqlSessionFactory打开数据库会话
		
			SqlSession sqlSession=sqlSessionFactory.openSession();
			
			return sqlSession;
		}
	
	
}
