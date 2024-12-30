package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass11 {
	public static void main(String[] args) {
		//수정할 회원의 정보라고 가정하자
		int num=4;
		String name="이정호";
		String addr="강남역";
		
		//수정할 회원의 정보를 MemberDto 객체에 담고
		MemberDto dto=new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		//미리 준비된 메소드를 이용해서 수정반영하고 성공여부 리턴 받기
		boolean isSuccess=update(dto);
		if(isSuccess) {
			System.out.println("회원정보 수정됨");
		}else {
			System.out.println("회원정보 수정 실패!");
		}
	}
	
	/*
	 *  수정할 회원의정보(번호, 이름, 주소) 가 MemberDto 객체에 담겨서 전달되는 메소드
	 *  성공여부가 리턴되는 메소드 
	 */
	public static boolean update(MemberDto dto) {
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
				UPDATE member
				SET name=?, addr=?
				WHERE num=?
			""";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			// ? 에 값 바인딩 하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
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
