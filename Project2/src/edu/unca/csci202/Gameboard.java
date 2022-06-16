package edu.unca.csci202;

	import java.util.Random;
	import java.util.Scanner;
	import java.util.Stack;



public class Gameboard{
	public static final int SIZE = 8;
	int catchy;
	int length;
	int width;
	int count;
	int l;
	int p;
	boolean testers;
	String peek = "";
	String peek1 = "";
	int test2 [][];
	boolean test;
	boolean testie;
	int count_mines;
	int mines_left;
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	Cell[][] pirate;
	Stack<Cell> stack;
	
	public Gameboard(){
	pirate  = new Cell[SIZE][SIZE];
	test2 = new int [10][10];
	test = true;
	testie = false;
	count_mines = 0;
	mines_left = 0;
	testers = false;
	catchy = 0;
	count = 0;
	l = 0;
	p = 0;
	stack = new Stack<Cell>();
	
	
	}
	
	public void printboars() {
		for(int i = 0; i < SIZE; i++) {
			for(int j=0; j < SIZE; j++) {
				if (pirate[i][j].contains_mine == true){
				System.out.print(pirate[i][j].mine +",");
			} else {
				System.out.print(pirate[i][j].hippy + ",");
			}
				
			}
			System.out.println();
		}
	}
	public void testcell(Cell x, int row, int column){
		try {
			if (pirate[row -1][column-1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell2(Cell x, int row, int column){
		try {
			if (pirate[row -1][column+1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell3(Cell x, int row, int column){
		try {
			if (pirate[row -1][column].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell4(Cell x, int row, int column){
		try {
			if (pirate[row][column-1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell5(Cell x, int row, int column){
		try {
			if (pirate[row][column].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell6(Cell x, int row, int column){
		try {
			if (pirate[row][column+1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell7(Cell x, int row, int column){
		try {
			if (pirate[row +1][column-1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell8(Cell x, int row, int column){
		try {
			if (pirate[row +1][column].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		} 
	}
	public void testcell9(Cell x, int row, int column){
		try {
			if (pirate[row +1][column+1].contains_mine == true) {
				pirate[row][column].minecount++;
			}
			
		}catch (Exception ArrayIndexOutOfBounds) {
			
		}
	}
	public void push1(Cell xx) throws ArrayIndexOutOfBoundsException{
		    try {
		    	if(pirate[xx.row][xx.column+1].seen1 == false) {
		    		stack.push(pirate[xx.row][xx.column+1]);
		    	}
		    } catch (Exception ArrayIndexOutOfBounds) {
		    	
		    }
		    try {
		    	if(pirate[xx.row+1][xx.column].seen1 == false) {
		    		stack.push(pirate[xx.row+1][xx.column]);
		    	}
		    } catch (Exception ArrayIndexOutOfBounds) {
		    	
		    }
		    try {
		    	if(pirate[xx.row-1][xx.column].seen1 == false) {
		    		stack.push(pirate[xx.row-1][xx.column]);
		    	}
		    } catch (Exception ArrayIndexOutOfBounds) {
		    	
		    }
		    try {
		    	if(pirate[xx.row][xx.column-1].seen1 == false) {
		    		stack.push(pirate[xx.row][xx.column-1]);
		    	}
		    } catch (Exception ArrayIndexOutOfBounds) {
		    	
		    }

	}
	
	public void expand(Cell c) {
		stack.push(c);
		while(!stack.isEmpty() == true) {
			Cell xx = stack.pop();
			xx.seen1 = true;
			testcell(xx,xx.row,xx.column);
			testcell2(xx,xx.row,xx.column);
			testcell3(xx,xx.row,xx.column);
			testcell4(xx,xx.row,xx.column);
			testcell5(xx,xx.row,xx.column);
			testcell6(xx,xx.row,xx.column);
			testcell7(xx,xx.row,xx.column);
			testcell8(xx,xx.row,xx.column);
			testcell9(xx,xx.row,xx.column);
			
			
			if(xx.minecount == 0) {
				push1(xx);
				
				
			}
		}
	}
	
	public void run() {
		
		
		
		
		for(int i = 0; i < SIZE; i++) {
			for(int j=0; j < SIZE; j++) {
				pirate[i][j] = new Cell(i,j);
			}
	}

		while(count < 10) {
			l = rand.nextInt(8);
			p = rand.nextInt(8);
			if (test2[l][p] == 1) {
				continue;
			}
			test2[l][p] = 1;
			pirate[l][p].setContains_mine(true);
			
			
			count ++;
		}
		
		
		System.out.println("Welcome to minesweeper!!");
		
		
		while (testers == false) {
		System.out.println("Do you want to take a peak? (y/n)");
		peek = scan.nextLine();
		if (peek.compareTo("y")==0) {
			testers = true;
		System.out.println();
		for(int i = 0; i < SIZE; i++) {
			for(int j=0; j < SIZE; j++) {
				if (pirate[i][j].contains_mine == true){
				System.out.print(pirate[i][j].mine +" ");
			} else {
				System.out.print(pirate[i][j].hippy + " ");
			}
				
			}
			System.out.println();
		}
		}
		else if (peek.compareTo("n")==0){
			testers = true;
		}
		}
		
		while (test == true) {
			try {
				testers = false;
			int row = 0;
			int column = 0;
			System.out.println();
			System.out.println("What is your row? (1-8)");
			row = scan.nextInt() ;
			System.out.println("What is your column? (1-8)");
			column = scan.nextInt() ;
			System.out.println("Is this a mine? (y/n)");
			String testm = scan.nextLine();
			testm = scan.nextLine();
			row--;
			column--;
			
			pirate[row][column].minecount = 0;
			if (pirate[row][column].contains_mine == true && testm.compareTo("y")==0) {
				mines_left++;
				pirate[row][column].seen = true;
				
				for(int i = 0; i < SIZE; i++) {
					for(int j=0; j < SIZE; j++) {
						if (pirate[i][j].seen == true) {
						System.out.print(pirate[i][j].mine + " ");
						} else if (pirate[i][j].seen1 == true) {
							System.out.print(pirate[i][j].minecount + " ");
						} else {
							System.out.print(pirate[i][j].hippy+" ");
						}
					}
					System.out.println();
				}
				
			}
			if (pirate[row][column].contains_mine == true && testm.compareTo("n")==0) {
				System.out.println("Sorry you lose, try again");
				catchy = 1;
				
			}
			if (pirate[row][column].contains_mine == false && testm.compareTo("y")==0) {
				System.out.println("Sorry you lose, try again");
				catchy = 1;
			}
			if (pirate[row][column].contains_mine == false && testm.compareTo("n")==0) {
				
			pirate[row][column].seen1 = true;
			
			expand(pirate[row][column]);
				
			
			
			for(int i = 0; i < SIZE; i++) {
				for(int j=0; j < SIZE; j++) {
					if (i == row && j == column) {
						System.out.print(pirate[i][j].minecount + " ");
					}
					else if (pirate[i][j].minecount != 0) {
					System.out.print(pirate[i][j].minecount + " ");
					}
					else if (pirate[i][j].seen == true){
						System.out.print(pirate[i][j].mine + " ");
					} else if (pirate[i][j].seen1 == true){
						System.out.print(pirate[i][j].minecount + " ");
						}
					else {
						System.out.print(pirate[i][j].hippy + " ");
					}
				}
				System.out.println();
				
				
			}
			}
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("You have entered a row or a column that is out of bounds, try again.");
				testie = true;
				System.out.println();
			}
			catch (Exception InputMismatch) {
				System.out.println("You have entered an invalid input for your rows and columns, please try again.");
				System.out.println();
				testie = true;
			}
			finally {
				if (catchy == 1) {
					break;
				}
			
				if (mines_left == 10) {
					System.out.println("Congratulations you won the game!!!");
					break;
				}
			}
			
			while (testers == false) {
			System.out.println("Do you want to take a peak? (y/n)");
			System.out.println();
			String peek1 = "";
			peek1 = scan.nextLine();
			if (testie == true) {
				peek1 = scan.nextLine();
				testie = false;
			}
			if (peek1.compareTo("y")==0) {
			System.out.println();
			for(int i = 0; i < SIZE; i++) {
				for(int j=0; j < SIZE; j++) {
				if (pirate[i][j].contains_mine == true){
					System.out.print(pirate[i][j].mine +" ");
				} else if (pirate[i][j].seen1 == true){
					System.out.print(pirate[i][j].minecount + " ");
					} else {
						System.out.print(pirate[i][j].hippy + " ");
					}
					
					
				}
				System.out.println();
			
		}
			testers = true;
		}
			if (peek1.compareTo("n")==0) {
				testers = true;
			}
			}
		 
}
}
}