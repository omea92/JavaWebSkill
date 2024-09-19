package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private PreparedStatement pstmt;
	private Connection con;
	private static final String driver = "oracle.jdbc.driver.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String user = "C##SCOTT";
	private static final String pwd = "TIGER";
	
	public List listMemers(MemberVO memberVO) {
		List<MemberVO> list = new ArrayList<>();
		String _name = memberVO.getName();
		
		
		try {
			connDB();
			String query = "select * from t_member ";
			
			if((_name != null && _name.length() != 0)) {
				query += " where name=?";
				pstmt.setString(1, _name);
				pstmt = con.prepareStatement(query);
			} else {
				pstmt = con.prepareStatement(query);
			}
			
			System.out.println("prepareStatement: " + query);
			ResultSet rs = pstmt.executeQuery(query);
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	private void connDB() {
		try {
			Class.forName(driver);
			System.out.println("Oracle 드라이버 로딩 성공");
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connection 생성 성공");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
