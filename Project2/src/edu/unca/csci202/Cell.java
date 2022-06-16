package edu.unca.csci202;

public class Cell {

	String hippy = "-";
	String cell_count = "0";
	boolean contains_mine;
	String mine = "M";
	boolean seen1;
	private int count;
	int minecount;
	boolean seen = false;
	int row;
	int column;
	
	
	Cell(int row, int column){
		this.seen1  = false;
		this.count  = 0;
		this.minecount  = 0;
		this.contains_mine  = false;
		this.row = row;
		this.column = column;
		
	}

	public String getHippy() {
		return hippy;
	}

	public void setHippy(String hippy) {
		this.hippy = hippy;
	}

	public String getCell_count() {
		return cell_count;
	}

	public void setCell_count(String cell_count) {
		this.cell_count = cell_count;
	}

	public boolean isContains_mine() {
		return contains_mine;
	}

	public void setContains_mine(boolean contains_mine) {
		this.contains_mine = contains_mine;
	}

	public String getMine() {
		return mine;
	}

	public void setMine(String mine) {
		this.mine = mine;
	}

	public void getCount() {
		
		
		
	}

	public void setCount(int count) {
		this.count = count;
	}
}
