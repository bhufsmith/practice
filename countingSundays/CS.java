
import java.util.GregorianCalendar;
import java.util.Calendar;
public class CS{

	public static void main(String[] args){
		GregorianCalendar gc = new GregorianCalendar();
		
		//Starting from jan 01 1901
		//To Dec 31 2000

		//need to check the first of every month to see if it is sunday.

		int numSundaysOnFirstOfMonth = 0;
		for( int year = 1901; year <= 2000; year++  ){
			for ( int month = 1; month <= 12; month++){
				gc.set( Calendar.YEAR, year );
				gc.set( Calendar.MONTH, month);
				gc.set( Calendar.DAY_OF_MONTH, 1);

			 	if ( gc.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
					numSundaysOnFirstOfMonth++;
				}
			}
		} 
		System.out.println("total: " + numSundaysOnFirstOfMonth);

	}

}
