package com.n3wt0n.Pixahl;

import java.util.Random;

public class Board {

	protected int[][] board;
	protected String[] columns;
	protected String[] rows;

	protected int width, height;

	public Board(int w, int h) {
		width = w;
		height = h;
		board = new int[w][h];

		columns = new String[w];
		rows = new String[h];

		this.init();
		this.populate(0.50f);
		this.labelColumns();
		this.labelRows();
	}

	/**********************************/

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getBlock(int x, int y) {
		return board[x][y];
	}

	public void setBlock(int x, int y, int b) {
		board[x][y] = b;
	}

	/**********************************/

	public void init() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				board[x][y] = 0;
			}
		}
	}

	public void populate(float percentFilled) {
		int blocks = (int) (width * height * percentFilled);
		Random rand = new Random();
		int xRand, yRand;

		for (int i = 0; i < blocks; i++) {

			do {
				xRand = rand.nextInt(width);
				yRand = rand.nextInt(height);
			} while (this.getBlock(xRand, yRand) == 1);

			setBlock(xRand, yRand, 1);
		}
	}
	
	/*
	 * Takes a string, such as "1001110110" and returns
	 * a string such as "1,3,2" based on the consecutive
	 * 1's that are found.
	 */
	public String mathifyString(String str) {
		String result = "";
		String tmp[];
		
		tmp = str.split("0");
		
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].length() > 0) {
				result += "," + tmp[i].length();
			}
		}
		
		result = (result.length() > 0) ? result.substring(1) : "0";
		
		return result;
	}

	public void labelColumns() {
		String col;

		for (int x = 0; x < width; x++) {
			col = "";

			for (int y = 0; y < height; y++) {
				col += getBlock(x, y);
			}
			
			columns[x] = mathifyString(col);
		}
	}

	public void labelRows() {

	}

	public void printBoard() {
		String out = "";
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				out += getBlock(x, y);
			}
			out += "\n";
		}
		System.out.print(out);
	}

	public void printColumns() {
		for (int x = 0; x < width; x++) {
			System.out.println(columns[x]);
		}
	}

	public void printRows() {

	}

	public static void main(String[] args) {
		Board b = new Board(4, 4);
		
		System.out.println ("Board dimensions, width x height --> " + b.getWidth() + " x " + b.getHeight());
		
//		b.populate(0.50f);
		b.printBoard();

		System.out.println("---------");

		b.printColumns();
		b.printRows();

		System.out.println("---------");
		
		System.out.println ("This should be '0' --> " + b.mathifyString("0"));
		System.out.println ("This should be '1,2' --> " + b.mathifyString("1011"));
	}
}
