package test.main;

import java.util.ArrayList;
import java.util.function.Consumer;

public class MainClass03 {
	public static void main(String[] args) {
		//인사말을 담을 ArrayList 객체를 생성해서 참조값을  greets 라는 지역변수에 대입하기 
		ArrayList<String> greets = new ArrayList<>();
		//greets 에 들어 있는 참조값을 이용해서 인사말 3개를 임의로 담아보세요
		greets.add("hello");
		greets.add("hi");
		greets.add("good night");
		
		//확장 for 문을 이용해서 모든 인사말을 콘솔창에 순서대로 출력해 보세요.
		for(String tmp : greets) {
			System.out.println(tmp);
		}
		
		System.out.println("--- ---");
		
		//아래의 동작을 분석해 보세요
		Consumer<String> con = new Consumer<String>() {
			@Override
			public void accept(String t) {
				// 매개 변수에 전달되는 item 을 가지고 어떤 작업을 할지 여기에 coding 을 하면 된다. 
				System.out.println(t);
			}
		};
		/*
		 *  ArrayList 객체의 forEach() 메소드를 호출하면서 Consumer type 객체를 전달하면
		 *  전달된 객체의 accept() 메소드를 호출하면서 
		 *  ArrayList 객체에 저장된 item 을 순서대로 매개 변수에 전달해 준다. 
		 */
		greets.forEach(con);
		
		System.out.println("-----");
		
		Consumer<String> con2 = (t)->{
			System.out.println(t);
		};
		
		greets.forEach(con2);
		
		System.out.println("-----");
		
		greets.forEach((t)->{
			System.out.println(t);
		});
		
	}
}











