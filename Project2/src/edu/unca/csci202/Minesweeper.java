package edu.unca.csci202;

import java.util.Scanner;

public class Minesweeper {

	public static void main(String[] args) {
		boolean x = true;	
		Scanner scan = new Scanner(System.in);
		
			while (x = true) {
			String y = "";
			Gameboard game = new Gameboard();
			game.run();
			System.out.println("Would you like to play again? (y/n)");
			y = scan.nextLine();
			if (y.compareTo("y") == 0) {
				continue;
			}else {
				break;
			}
			
			

		

	}



	}

}
