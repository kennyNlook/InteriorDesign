

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class Databaseconnection {

		

			private String dbUrl ="jdbc:mysql://localhost:3306/interior";
			private String dbUser ="root";
			private String dbPwd ="";
			private String dbDriver = "com.mysql.jdbc.Driver";
			
			
			private static final String DELETE_USERS ="delete from users where id = ?";
			
			
		public void loaddriver(String dbDriver) {
				
				try {
					getClass().forName(dbDriver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}

		public Connection getConnection() { 
			Connection con = null;

		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return con;
		}
		
		
		
		
		
		
		public boolean checkCredentials(String username,String pass) {
			
			loaddriver(dbDriver);
			//String Message="";
			Connection con = getConnection();
			String query = "SELECT * from login where username='"+username+"' AND password='"+pass+"'";
			
		    try {
				PreparedStatement ps = con.prepareStatement(query);
				
//				ps.setString(1, username);
//				ps.setString(2, pass);
				ResultSet rs=ps.executeQuery(query);
				if(rs.next()) {
//					rs.getStatement();
					return true;
					//Message="done";
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//Message=e.toString();
				e.printStackTrace();
			}
		return false;
			
		}
		
		
		
		
		
	public String insert(Conclass co) {
			
			loaddriver(dbDriver);
			Connection con = getConnection();
			
			String query = "INSERT INTO register VALUES(?,?,?,?)";
			
			String message ="Record registed successfully";
			
					try {
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, co.getRegister() );
						ps.setString(2, co.getPhone());
						ps.setString(3, co.getLocation());
						ps.setString(4, co.getGender());
						
						
						ps.executeUpdate();
					} catch (SQLException e) {
						message ="record not registered" +e;
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			return message;
		}
	
	
	public String login(Logclass co) {
		
		loaddriver(dbDriver);
		Connection con = getConnection();
		
		String query = "INSERT INTO login VALUES(?,?,?)";
		
		String message ="Record registed successfully";
		
				try {
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, co.getName() );
					ps.setString(2, co.getEmail());
					ps.setString(3, co.getPassword());
					
					
					
					ps.executeUpdate();
				} catch (SQLException e) {
					message ="record not registered" +e;
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return message;
	}
	


	public String poro(product co) {
		
		loaddriver(dbDriver);
		Connection con = getConnection();
		
		String query = "INSERT INTO product VALUES(?,?,?,?)";
		
		String message ="Record registed successfully";
		
				try {
					PreparedStatement ps = con.prepareStatement(query);
					ps.setString(1, co.getPname());
					ps.setString(2, co.getAmount());
					ps.setString(3, co.getType());
					ps.setString(4, co.getSize());
					
					
					ps.executeUpdate();
				} catch (SQLException e) {
					message ="record not registered" +e;
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return message;
	
		 
		 

		
		
	
	
		}}



