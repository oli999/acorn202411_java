package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.EmpDto;
import test.dto.MemberDto;
import test.util.DBConnector;

public class MainClass07 {
	public static void main(String[] args) {
		//사원 목록을 아주 쉽게 얻어낼수 있다 (날로 먹을수 있다)
		List<EmpDto> list=getList();
		for(EmpDto tmp:list) {
			System.out.printf("사원번호:%d 사원이름:%s 직업:%s 급여:%f \r\n",
					tmp.getEmpno(), tmp.getEname(), tmp.getJob(), tmp.getSal());
		}
	}
	
	//미리 준비된 메소드가 있다고 가정하면 
	public static List<EmpDto> getList(){
		
		//리턴해줄 객체를 미리 생성하기
		List<EmpDto> list=new ArrayList<>();
		
		//여기에 어떻게 코딩하면 회원 목록(List<EmpDto>) 를 리턴해줄수 있을까? 코딩해 보세요.
		//필요한 객체를 담을 지역변수 미리 준비
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			//우리가 설계한 클래스로 객체생성후 Connection 객체 얻어내기
			conn=new DBConnector().getConn();
			String sql="""
				SELECT empno, ename, job, sal
				FROM emp
				ORDER BY empno ASC
			""";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				// ResultSet 객체로 부터 사원 한명의 정보를 추출 했다.
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				double sal = rs.getDouble("sal");
				// 추출한 사원한명의 정보를 EmpDto 객체를 생성해서 담는다.
				EmpDto dto=new EmpDto();
				dto.setEmpno(empno);
				dto.setEname(ename);
				dto.setJob(job);
				dto.setSal(sal);
				// 사원한명의 정보가 담긴 EmpDto 객체를 ArrayList 객체에 누적 시키기
				list.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}














