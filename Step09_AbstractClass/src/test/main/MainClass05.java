package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	
	public static void main(String[] args) {
		
		Weapon w1 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무데나 공격하자~");
			}
		};
		useWeapon(w1);
		
		useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("김구라를 공격하자~");
			}
		});
				
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}




