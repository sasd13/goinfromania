package main;

import game.element.ListElements;
import game.element.character.Nutritionist;
import game.element.character.Virus;
import game.element.food.Cake;
import game.element.food.PoisonCake;
import game.element.item.Wall;

import java.awt.Point;

public class Test {
	
	public static void testArena(ListElements listElements) {
		PoisonCake poisonCake = new PoisonCake();
		poisonCake.setPosition(new Point(200, 200));
		listElements.add(poisonCake);
		
		Wall wall1 = new Wall();
		wall1.setPosition(new Point(300, 100));
		listElements.add(wall1);
		
		Wall wall2 = new Wall();
		wall2.setPosition(new Point(300, 200));
		listElements.add(wall2);
		
		Nutritionist nutritionist = new Nutritionist();
		nutritionist.setPosition(new Point(300, 300));
		listElements.add(nutritionist);
		
		Virus virus = new Virus();
		virus.setPosition(new Point(300, 400));
		listElements.add(virus);
		
		Cake cake0 = new Cake();
		cake0.setPosition(new Point(100, 0));
		listElements.add(cake0);
		
		Cake cake1 = new Cake();
		cake1.setPosition(new Point(500, 0));
		listElements.add(cake1);
		
		Cake cake2 = new Cake();
		cake2.setPosition(new Point(500, 100));
		listElements.add(cake2);
		
		Cake cake3 = new Cake();
		cake3.setPosition(new Point(500, 200));
		listElements.add(cake3);
		
		Cake cake4 = new Cake();
		cake4.setPosition(new Point(500, 300));
		listElements.add(cake4);
		
		Cake cake5 = new Cake();
		cake5.setPosition(new Point(500, 400));
		listElements.add(cake5);
		
		Cake cake6 = new Cake();
		cake6.setPosition(new Point(700, 0));
		listElements.add(cake6);
		
		Cake cake7 = new Cake();
		cake7.setPosition(new Point(700, 100));
		listElements.add(cake7);
		
		Cake cake8 = new Cake();
		cake8.setPosition(new Point(700, 200));
		listElements.add(cake8);
		
		Cake cake9 = new Cake();
		cake9.setPosition(new Point(700, 300));
		listElements.add(cake9);
		
		Cake cake10 = new Cake();
		cake10.setPosition(new Point(700, 400));
		listElements.add(cake10);
	}
}
