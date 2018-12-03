
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class LS{

	public static final String numberFile = "numbers.txt";

	public static void main(String[] args){
		StringBuilder numbersBuilder = new StringBuilder();
		String line;

		try(Scanner sc = new Scanner( new File( LS.numberFile ) ) ){
			String[] numbers;
			while( sc.hasNextLine() ){
				line = sc.nextLine();
				if( line != null && !line.equals("") ){
					numbersBuilder.append(line).append("\n");
				}
			}
	
			numbers = numbersBuilder.toString().split("\n");

			System.out.println(numbers.length);
			
			double sum = 0;
			for ( String number : numbers ){
				sum += Double.valueOf(number);
			}

			System.out.printf("Sum: %,.0f", sum);

		}
		catch(FileNotFoundException fnf){
			System.out.println("could not find file");
		}

	}

	

	

	
}
