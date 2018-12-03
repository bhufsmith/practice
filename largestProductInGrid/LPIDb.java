
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class LPID{
	
	public static void main(String[] args){
		LPID lpid = new LPID();
		try{
			double ans = lpid.largestProductInGrid(4);
			System.out.printf("Largest product is: %,.0f", ans);
		}
		catch( FileNotFoundException fnf ){
			System.out.println("File not found: " + fnf.getMessage());
		}
	}
	
	//Here n is the number of elements to consider.
	//We will need to check (up down left right diagnonal)
	public double largestProductInGrid(int n) throws FileNotFoundException {

		//Read in the grid from grid.txt.
		Scanner sc = new Scanner(new File("grid.txt"));
		
		String line;
		String[] row;
		int[][] matrix;

		int index = 1;
		if( sc.hasNextLine() ){
			row = sc.nextLine().split(" ");
			matrix = new int[row.length][row.length];
			matrix[0] = Arrays.stream(row)
					.mapToInt(s -> Integer.valueOf(s))
					.toArray();
		

			while(sc.hasNextLine()){
				line = sc.nextLine();
				if( line != null && line != ""){
					matrix[index++] = Arrays.stream(line.split(" "))
								.mapToInt(s -> Integer.valueOf( s ) )
								.toArray();	
				}
			}


			double max = 0;
			for(int i = 0; i < matrix.length - n; i++){
				for( int j = 0; j<matrix[0].length - n; j++){
					max = Math.max(	max, product( i, j, 0, 0, 1, 4, 4, matrix ));
				}
			}
			return max;
		}	

		return -1;		
	}
	
	private double product(int x, int y, int lastx, int lasty, double currProduct, int remaining, int n,  int[][] grid){
		
		System.out.printf("Called on: x:%d, y:%d, remaining:%d, FROM - x:%d, y: %d \n", x, y, remaining, lastx, lasty);
		double thisValue = grid[x][y];
		double thisProduct = currProduct * thisValue;
		double max = 0 ;

                //These are if we want to continue in a straight line.
		int continueX = x + (x - lastx);
                int continueY = y + (y - lasty);	
		System.out.printf("--nextX: %d, nextY: %d\n", continueX, continueY);

		if( remaining == 1 ){
			return thisProduct;
		}

		//If we can continue in a straight line, then do it
		if( (remaining != n) 
			&& continueX < grid.length && continueX >= 0 
			&& continueY < grid[0].length && continueY >= 0 ){
			
			max = Math.max( max, product( continueX, continueY, x, y, thisProduct, remaining-1, n, grid ) );
		}
		else{
			if( (x + 1) < grid.length ){
				max = Math.max( max, product( x+1, y, x, y,  thisValue, n-1, n, grid ) );
			}
			if( (y+1) < grid[0].length){
				max = Math.max( max, product( x, y+1, x, y, thisValue, n-1, n, grid ) );
			}
			if( (x + 1) < grid.length && (y + 1) < grid[0].length){
				max = Math.max( max, product( x+1, y+1, x, y, thisValue, n-1, n, grid ) );
			}

			if( (x - 1) >= 0 && (y + 1) < grid[0].length){
				max = Math.max( max, product( x-1, y+1, x, y, thisValue, n-1, n, grid ) );
			}
		}
		return max;
	}

}
