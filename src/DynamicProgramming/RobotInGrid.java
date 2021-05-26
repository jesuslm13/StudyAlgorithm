package DynamicProgramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Point{
	int row;
	int col;
	
	public Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
}

public class RobotInGrid {
	
	public int progress = 0;
	
	private List<Point> searchGrid(boolean[][] grid) {
		
		int row = 0;
		int col = 0;
		List<Point> list = new ArrayList<Point>();
		
		if(grid.length == 0 || grid == null) {
			return null;
		}
		
		if(searchGrid(grid, row, col, list)) {
			return list;
		} else {
			return null;
		}
	}
	
	private boolean searchGrid(boolean[][] grid, int row, int col, List<Point> list) {
		
		System.out.println("(" + row + "," + col + ")");
		
		if(!isInRange(grid, row, col) || !grid[row][col]) {
			System.out.println("error : (" + row + "," + col + ")");
			return false;
		}
		
		if( (row == grid.length-1 && col == grid[0].length-1) || searchGrid(grid, row, col+1, list) || searchGrid(grid, row+1, col, list)) {
			System.out.println(++progress);
			Point p = new Point(row, col);
			list.add(p);
			
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isInRange(boolean[][] grid, int row, int col) {
		
		//  Array length 사이에 있거나, 0보다 큰 경우 true
		boolean res = row <= grid.length-1 && col <= grid[row].length-1 && row >= 0 && col >= 0;
		
		return res;
		
	}

	public static void main(String[] args) {
		
		boolean[][] grid = {
				{true, true, true, true},
				{true, true, true, false},
				{false, false, true, true},
				{true, true, true, true}
		};
		
		List<Point> list = new  RobotInGrid().searchGrid(grid);
		
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print("(" + list.get(i).row + "," + list.get(i).col + ") -> ");
		}
		
	}
}
