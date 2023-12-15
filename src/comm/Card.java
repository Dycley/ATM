package comm;

import java.sql.*;

import static comm.DBLoad.*;

public class Card {
	private String cardID;
	private String userName;
	private String passWord;
	private float banlance;
	public float getBanlance() {
		return banlance;
	}
	public void setBanlance(float banlance) {
		this.banlance = banlance;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public Card(String cardID, String passWord, float banlance){
		this.cardID = cardID;
		this.passWord = passWord;
		this.banlance = banlance;
		getInfo(cardID);
	}

	public Card(String cardID){
		getInfo(cardID);
	}

	public void getInfo(String cardID){
		Connection conn = null;
		Statement stmt = null;
		try{
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// 执行查询
			System.out.println(" 实例化Statement对象...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT CardID, UserName, PassWord, Balance FROM user where CardID =" + cardID;
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while(rs.next()){
				// 通过字段检索
				String id  = rs.getString("CardID");
				String name = rs.getString("UserName");
				String pwd = rs.getString("PassWord");
				int balance = rs.getInt("Balance");

				// 输出数据
				System.out.print("CardID: " + id);
				System.out.print("UserName " + name);
				System.out.print("PassWord " + pwd);
				System.out.print("Balance " + balance);
				System.out.print("\n");

				this.cardID = id;
				this.userName = name;
				this.banlance=banlance;
				this.passWord=pwd;
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}finally{
			// 关闭资源
			try{
				if(stmt!=null) stmt.close();
			}catch(SQLException se2){
			}// 什么都不做
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
