
import java.util.*;
public class CS{

	//All coin ammounts are in pence (e.g. 100p = 1£
	static int[] coinAmmounts = {1, 2, 5, 10, 20, 50, 100, 200};

	/**
	 amt is the ammount we need to work with  in terms of money
	 coins is thw array containing the number of coins at index i in coinAmmounts
	*/
	
	public long coinSums(int amt, int coinIndex, int[] sol){
		long numWays = 0;

		if( amt == 0 ) {
			return 1;
		}
		if( coinIndex >= coinAmmounts.length ){
			return 0;
		}
		

		//Here we are using an initial multiple of 0,
		//The value 1 is used at the end of the loop. 
		int multiple = 1;
		int value = 0;
		int[] nextSol;
		for(; value <= amt; multiple ++){
			nextSol = sol.clone();
			nextSol[coinIndex] = multiple - 1;

			numWays += coinSums( amt - value, coinIndex + 1, nextSol );
			value = multiple * coinAmmounts[ coinIndex ];
		}

		return numWays;
	}

	public static void main(String[] args){
		CS coins = new CS();

		System.out.println("number of solutions: " + coins.coinSums(200, 0, new int[coinAmmounts.length]));
	}
}
