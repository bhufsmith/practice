import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class NS{

	public static void main(String[] args){
		
		File f  = new File("names.txt");
		
		//File has only one line of comma separated data. 
		String line = "";
		String[] names;
		long sumOfScores = 0;

		try(Scanner sc = new Scanner(f) ){
			while (sc.hasNextLine() ){
				line = sc.nextLine();
				line = line.replace("\"", "");
			}

			names = line.split(",");
			Arrays.sort(names);

			long sumOfChars;
			for( int i = 0; i<names.length; i++){
				
				sumOfChars = sumOfChars( names[i], 'A' );
				sumOfScores += ( (i+1) * sumOfChars );

				System.out.printf("%d: %s, %d%n", i, names[i], sumOfChars);
			}
			
			System.out.println(sumOfScores);
		}
		catch(FileNotFoundException fnf){
			System.out.println(fnf.getMessage());
		}
	}



	public static  long sumOfChars( String s, char base ) {
		return s.chars().map( c -> (c - base) + 1 ).sum();
	}	
}
