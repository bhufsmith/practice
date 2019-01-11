public class NSD{

	
	public static void main(String[] args){

		NSD nsd = new NSD();

		int[][] spiral = nsd.spiralize( 1001 );
		
		//Now sum the diagonals
		int max = spiral.length;
		int min = 0;

		//Here we will sum along the two major diagonals. 
		long sum = 0; 
		for(int off = 0; off < max; off++ ){

			//Only add the center once
			if( off != (spiral.length - 1) - off ) {
				//0,n -> n,0
				sum += spiral[off][ (spiral.length - 1) - off ];
			}

			//0,0 -> n,n 
			sum += spiral[ off ][ off ];

		}
		System.out.println("Sum: " + sum);

	}


	//Given n (the size of the square matrix
	//Fill it with a number spiral.
	public int[][] spiralize( int n ){
		
		//This is the biggest number in the spiral.
		int curr = n*n; 
		int x = n - 1;
		int y = 0;

		int nextX = x;
		int nextY = y;

		int[][] spiral = new int[n][n];

		Direction[] dirs = Direction.values();
		int thisDir = 0;

		Direction dir = dirs[ thisDir ];

		//Control the direction we are moving
		for( ; curr > 0; ){

			//Travers in one direction until out of bounds
			while( nextX < n && nextX >= 0 
				&& nextY < n && nextY >= 0
				&& spiral[nextX][nextY] == 0 ){

				x = nextX;
				y = nextY;

				//insert curr into the spiral
				spiral[x][y] = curr;
				--curr; 

				//Apply offset to move to the next point.
				nextX += dir.xOff;
				nextY += dir.yOff;
				
			}

			//Adjust offset direction.
			thisDir = (thisDir + 1) % dirs.length;
			dir = dirs[ thisDir ];

			nextX = x + dir.xOff;
			nextY = y + dir.yOff;
			
		}
		return spiral; 
	}


	private enum Direction {
		LEFT(-1, 0), DOWN(0, 1), RIGHT(1, 0), UP(0, -1); 

		public int xOff;
		public int yOff;

		Direction(int xAdj, int yAdj) {
			this.xOff = xAdj;
			this.yOff = yAdj; 
		}

	}

}
