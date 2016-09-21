package ru.stq.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("World");

		Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

    Rectangle r = new Rectangle(4, 6);
 		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

    Point p1 = new Point(-10, 1);
    Point p2 = new Point(4, 10);
    System.out.println("Расстояние от точки с координатами " + p1.x + " и " + p1.y + " до точки с координатами " + p2.x + " и " + p2.y + " равно " + p1.distance(p2));


		System.out.println(2 + 2);
		System.out.println(2 * 2);
		System.out.println(2 - 2);
		System.out.println(2 / 2);

		System.out.println(1.0 / 2);

		System.out.println("2" + "2");
		System.out.println("2" + 2);

		System.out.println("2 + 2 = " + (2 + 2));

	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}


}