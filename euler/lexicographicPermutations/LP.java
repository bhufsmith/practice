
import java.util.*;
public class LP{

	public static void main(String[] args){
		System.out.println( new LP().permutations("0123456789").get(999999) );
	}

	public List<String> permutations(String chars){
		List<String> permutations = new ArrayList<>();
		String prefix = "";
		String remaining = "";
		List<String> subPerm;

		//ystem.out.println("called on: " + chars);
		if( chars.length() == 1){
			permutations.add( chars );
			return permutations;

		}
		for( int index = 0; index < chars.length(); index++){
			prefix = chars.substring(index, index + 1);
			remaining = chars.substring(0, index) + chars.substring(index + 1);
			subPerm = permutations ( remaining );
			
			for( String s : subPerm ){
				permutations.add( prefix + s ); 
			}
		}

		return permutations;
	}
}
