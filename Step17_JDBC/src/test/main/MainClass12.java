package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.util.DBConnector;

public class MainClass12 {
	public static void main(String[] args) {
		int num=3; //삭제할 회원의 번호라고 가정
		
		boolean isSuccess=delete(num);
		if(isSuccess) {
			System.out.println("회원정보를 삭제 했습니다.");
		}else {
			System.out.println("회원 정보 삭제 실패!");
		}
	}
	
	//매개변수로 전달되는 회원의 번호를 이용해서 회원 한명의 정보를 삭제하고 성공여부를 리턴하는 메소드 
	public static boolean delete(int num) {
		//필요한 객체를 담을 지역변수 미리 만들기
		Connection conn=null;
		PreparedStatement pstmt=null;
		//변화된 row 갯수를 저장할 변수를 0 을 대입해서 미리 만들어 둔다.
		int rowCount = 0;
		try {
			//Connection 객체의 참조값 얻어내기
			conn=new DBConnector().getConn();
			//실행할 미완성의 sql 문
			String sql="""
				DELETE FROM member
				WHERE num=?
			""";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기
			pstmt.setInt(1, num);
			// sql 문 실행하고 추가(insert)되거나, 변경(update)되거나, 삭제(delete) 된 row 의 갯수리턴 받기
			rowCount=pstmt.executeUpdate();
		}catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		
		
		// rowCount 변수에 들어 있는 값을 확인해서 작업의 성공여부를 리턴해 준다. 
		if(rowCount > 0) {
			return true;
		}else {
			return false;
		}
	}
}
