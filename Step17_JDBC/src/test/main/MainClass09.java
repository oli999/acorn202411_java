package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.DeptDto;
import test.dto.EmpDeptDto;
import test.util.DBConnector;

public class MainClass09 {
	public static void main(String[] args) {
		List<EmpDeptDto> list=getList();
		for(EmpDeptDto tmp:list) {
			System.out.printf("사원번호:%d 사원이름:%s 부서번호:%d 부서명:%s \r\n",
					tmp.getEmpno(), tmp.getEname(), tmp.getDeptno(), tmp.getDname());
		}
		
	}
	//아래의 메소드를 완성해 보세요.
	public static List<EmpDeptDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<EmpDeptDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<DeptDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT empno, ename, deptno, dname
				FROM emp
				INNER JOIN dept USING(deptno)
				ORDER BY empno ASC
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				EmpDeptDto dto=new EmpDeptDto();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setDeptno(rs.getInt("deptno"));
				dto.setDname(rs.getString("dname"));
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
