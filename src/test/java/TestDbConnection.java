
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDbConnection {
	public static void main(String args[]){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("search-servlet.xml");
		DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
		
		try {
			Connection conn = dataSource.getConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
