
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class MPS{
	

	public static void main(String[] args) {

		MPS mps = new MPS();
		File f = new File("triangle.txt");

		try {
			int[] triangle = mps.readTriangleFile(f);
			System.out.println( mps.findMaxTriangleSum( 1, 0, triangle) );
		}
		catch(FileNotFoundException fnf){
			System.out.println(fnf.getMessage());
		}


	}

	//Here, row is the row in the triangle. Always starts at 1
	//index is the index of the element into the triangle array. Always starts at 0
	public long findMaxTriangleSum(int row, int index, int[] triangle){
		
		//The children of this element are "row" elements away
		//row number will match the number of elements in this row.
		int leftChildIndex = index + row;

		//The left child is always one away from the right
		int rightChildIndex = leftChildIndex + 1;

		//Use this for storing the sum of all child elements.
		long maxSum = 0;
		
		//we will always have both children, or this is an invalid triangle
		if( rightChildIndex < triangle.length ){
			maxSum = Math.max ( findMaxTriangleSum( row + 1, leftChildIndex, triangle),
						findMaxTriangleSum( row + 1, rightChildIndex, triangle) );
		}

		return triangle[index] + maxSum;
	}


	public int[] readTriangleFile( File file ) throws FileNotFoundException {
		
		int[] triangle;
		List<String> lines = new ArrayList<String>();
		Scanner sc  = new Scanner(file);

		String line; 
		while( sc.hasNextLine() ){
			line = sc.nextLine();
			if( !line.equals("") ){
				lines.add( line ); 
			}
		}

		//Since this is a triangle, where each row has n+1 elements
		int n = lines.size();
		int numElements =  ( ( n * (n+1) ) / 2); //Standard summ of natural numbers applies
		triangle = new int[ numElements ];

		//Insert the elements from each line one at a time into the array. 
		int index = 0;
		String[] lineElements;
		for( int i = 0; i < lines.size(); i++ ) {

			lineElements = lines.get(i).split(" ");
			for( int elem = 0; elem < lineElements.length; elem++ ){
				triangle[index] =  Integer.valueOf( lineElements[ elem ] );
				index++;
			}
		}
		return triangle;
	}

}
