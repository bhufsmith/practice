 
import java.util.*;
public class LP{

//	List<String> pathList = new ArrayList<String>();
	Integer numPaths = 0;
	
	public long numPaths(int x, int y, long[][] grid ){
		
		long numPaths = 0;

		if( x == grid.length -1 && y == grid[0].length -1 ){
			return 1;
		}
		else if( grid[x][y] != 0 ){
			return grid[x][y];
		}
		
		if ( x < grid.length -1 ){
			numPaths += numPaths( x + 1, y, grid);
		}
		if( y < grid[0].length -1){
			numPaths += numPaths( x, y + 1, grid);
		}
		
		grid[x][y] = numPaths;
		return numPaths;
	}	

	public static void main(String[] args){
		LP lp = new LP();

		System.out.println( "" + lp.numPaths(0, 0, new long[21][21]) );
	}
}
