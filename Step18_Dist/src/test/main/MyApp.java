package test.main;

import java.util.Scanner;

public class MyApp {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("이름입력:");
		String name=scan.nextLine();
		if(name.equals("이정호")) {
			System.out.println(name+" 은 잘생겼습니다.");
		}else {
			System.out.println(name+" 은 못생겼습니다.");
		}
	}
}
