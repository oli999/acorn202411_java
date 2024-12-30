package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.util.DBConnector;

public class MainClass08 {
	public static void main(String[] args) {
		List<DeptDto> list=getList();
		for(DeptDto tmp:list) {
			System.out.printf("부서번호:%d 부서명:%s 부서의위치:%s \r\n", 
					tmp.getDeptno(), tmp.getDname(), tmp.getLoc());
		}
		
	}
	//아래의 메소드를 완성해 보세요.
	public static List<DeptDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<DeptDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<DeptDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT deptno, dname, loc
				FROM dept
				ORDER BY deptno ASC
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				//부서 정보를 담을 DeptDto 객체를 생성해서 
				DeptDto dto=new DeptDto();
				//부서하나의 정보를 담고 
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				dto.setLoc(rs.getString("loc"));
				//부서 정보가 담겨있는 DeptDto 객체를 ArrayList 에 누적 시키기
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
