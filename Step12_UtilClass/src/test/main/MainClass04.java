package test.main;

import java.util.ArrayList;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		//1. Car type 을 저장할수 있는 ArrayList 객체를 생성해서
		//참조값을 ArrayList type  지역변수 cars  에 담아 보세요.
		ArrayList<Car> cars=new ArrayList<>();
		//2. Car 객체(3개)를 생성해서 ArrayList 객체에 저장해 보세요. 
		Car car1=new Car("소나타");
		Car car2=new Car("그랜저");
		//Car car3=new Car("아반떼");
		
		cars.add(car1);
		cars.add(car2);
		cars.add(new Car("아반떼"));
	
		//3. 일반 for 문을 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해 보세요.
		for(int i=0; i<cars.size(); i++) {
			Car tmp=cars.get(i);
			tmp.drive();
		}
		//4. 확장 for 문을 이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive() 메소드를
		//순서대로 호출해 보세요.
		for(Car tmp:cars) {
			tmp.drive();
		}
		//5. ArrayList 객체의 forEach() 메소드를  이용해서 ArrayList 객체에 저장된 모든 Car 객체의 drive()
		//메소드를 순서대로 호출해 보세요.
		cars.forEach((tmp)->{
			tmp.drive();
		});
		
	}
}



