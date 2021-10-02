package ftt.ec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

// Biblioteca externa (JAR):
// 1 - Adicionar no CLASSPATH
// 2 - Adicionar a aplicação - Incorpora na aplicação
// 3 - MAVEN para gerenciar as packages, teste, build - POM.XML
//     https://mvnrepository.com/artifact/mysql/mysql-connector-java/8.0.26

public class AppMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("FTT-SQLAPP1 - " + new Date());
		
		System.out.println("Vai Corinthians!");

		try {
			//https://docs.microsoft.com/pt-br/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
			//jdbc:sqlserver://localhost;user=MyUserName;password=*****;
			
            Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexao = DriverManager.getConnection(
			        "jdbc:mysql://localhost/ftt?serverTimezone=GMT-3",
			        "scott",
			        "T1ger!");
			
			PreparedStatement stmt = conexao.
                    prepareStatement("select now() agora from dual;");
            
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
                String agora = rs.getString("agora");
                System.out.println("Data do banco de dados: " + agora);
			} //while
			
			stmt = conexao.
                    prepareStatement("select * from ftt.USER;");
            
			rs = stmt.executeQuery();
			
			while (rs.next()) {
                String name = rs.getString("name");
                System.out.println("Person name: " + name);
			} //while
			
			conexao.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Ops!! " + new Date());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        System.out.println("Feito!!");
		

	}

}
