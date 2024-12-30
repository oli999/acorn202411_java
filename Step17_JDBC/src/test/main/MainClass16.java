package test.main;

import test.dao.MemberDao;

public class MainClass16 {
	public static void main(String[] args) {
		/*
		 *  MemberDao 객체를 이용해서 1 번회원의 정보를 삭제해 보세요
		 *  단) 성공여부를 콘솔창에 출력하세요
		 */
		var dao=new MemberDao();
		var isSuccess=dao.delete(1);
		if(isSuccess) {
			System.out.println("삭제 했습니다.");
		}else {
			System.out.println("삭제 실패!");
		}
	}
}
