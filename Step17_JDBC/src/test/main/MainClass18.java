package test.main;

import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass18 {
	public static void main(String[] args) {
		/*
		 *  MemberDao 객체를 이용해서 회원목록을 얻어온 다음 
		 *  전체 목록을 반복문 돌면서 이쁘게 출력해 보세요
		 */
		
		List<MemberDto> list=new MemberDao().getList();
		for(MemberDto tmp:list) {
			System.out.printf("번호:%d 이름:%s 주소:%s", tmp.getNum(), tmp.getName(), tmp.getAddr());
			System.out.println();
		}
	}
}











