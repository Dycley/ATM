package comm;

import java.sql.*;
import java.util.Objects;

import static comm.DBConfig.*;

public class Card {
	private String cardID;
	private String userName;
	private String passWord;
	private int balance;
	private boolean exist;
	public int getBalance() {
		return balance;
	}
//	public void setBanlance(float banlance) {this.banlance = banlance;}
	public String getUserName() {return userName;}
	public void setUserName(String userName) {this.userName = userName;	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public String getPassWord() {
		return passWord;
	}
//	public void setPassWord(String passWord) {
//		this.passWord = passWord;
//	}
	public Card(String cardID, String passWord, int balance){
		this.cardID = cardID;
		this.passWord = passWord;
		this.balance = balance;
		getInfo(cardID);
	}

	public Card(String cardID){
		getInfo(cardID);
	}

	//从数据库获取信息
	public void getInfo(String cardID){
		exist = false;
		Connection conn = null;
		Statement stmt = null;
		try{
			// 注册 JDBC 驱动
			Class.forName(JDBC_DRIVER);

			// 打开链接
			System.out.println("连接数据库...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// 执行查询
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
				System.out.print(" UserName: " + name);
				System.out.print(" PassWord: " + pwd);
				System.out.print(" Balance: " + balance);
				System.out.print("\n");

				this.cardID = id;
				this.userName = name;
				this.balance = balance;
				this.passWord=pwd;
				if(!Objects.equals(id, "")) exist=true;

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

	// 判断账号是否存在
	public boolean exist(){
		System.out.println(exist);
		return exist;
	}

	// 判断密码是否正确
	public boolean judgePwd(String pwd){
		return Objects.equals(pwd, this.passWord);
	}

	// 改密
	public boolean setPassWord(String pwd){
		if(exist()){
			Connection conn = null;
			Statement stmt = null;
			try{
				// 注册 JDBC 驱动
				Class.forName(JDBC_DRIVER);

				// 打开链接
				System.out.println("连接数据库...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);

				// 执行修改
				stmt = conn.createStatement();
				String sql;
				sql = "UPDATE user SET Password=? where CardID =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setString(1,pwd);
				pst.setString(2,cardID);
				pst.executeUpdate();
				// 完成后关闭
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
			passWord=pwd;
		}
		return true;
    }

	//修改余额
	public boolean setBanlance(int balance){
		if(exist()){
			Connection conn = null;
			Statement stmt = null;
			try{
				// 注册 JDBC 驱动
				Class.forName(JDBC_DRIVER);

				// 打开链接
				System.out.println("连接数据库...");
				conn = DriverManager.getConnection(DB_URL,USER,PASS);

				// 执行修改
				stmt = conn.createStatement();
				String sql;
				sql = "UPDATE user SET Balance=? where CardID =?";
				PreparedStatement pst = conn.prepareStatement(sql);
				pst.setInt(1,balance);
				pst.setString(2,cardID);
				pst.executeUpdate();
				// 完成后关闭
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
			this.balance=balance;
		}
        return true;
    }

}
