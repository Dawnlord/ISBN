//Author: Liu Hanyang (liu.hanyang96@gmail.com/290233090lhy@gmail.com)
//Run method: javac ISBN_LHY.java
//			  java ISBN_LHY <Product ID>
//Example: java ISBN_LHY 978155192370

public class ISBN_LHY{
	private static int ID_LENGTH = 12;
	private static String ID_PREFIX = "978";
	private static int VALID_NUM_LENGTH = 9;
	private static int SUM_FIRST_FACTOR = 10;
	private static int MOD_FACTOR = 11;

	private static boolean CheckID(String productID){
		if(productID.length() < ID_LENGTH){
			System.out.println("It is an invalid product ID!!!");
			return false;
		} else if(!productID.substring(0,ID_PREFIX.length()).equals(ID_PREFIX)){
			System.out.println("It is an invalid product ID!!!");
			return false;
		} else {
			return true;
		}
	}

	private static String CaculateISBN(String validID){
		int lastBit = 0;
		int sum = 0;
		char[] idCharArray = validID.toCharArray();

		for(int i = 0; i < VALID_NUM_LENGTH; i++){
			int thisNum = Integer.parseInt(String.valueOf(idCharArray[i]));
			sum += thisNum * (SUM_FIRST_FACTOR - i);
		}

		for(int i = 0; i <= SUM_FIRST_FACTOR; i++){
			if((sum + i) % MOD_FACTOR == 0){
				lastBit = i;
				break;
			}
		}

		if(lastBit == 10){
			return validID + "x";
		} else {
			return validID + lastBit;
		}
	}

	public static void main(String args[]) {
		if(args.length > 0){
			String productID = args[0];

			if(CheckID(productID)){
				String validID = productID.substring(ID_PREFIX.length(), ID_LENGTH);
				String isbn = CaculateISBN(validID);
				System.out.println(isbn);
			}
		} else {
			System.out.println("Please type in a product ID!");
		}
	}
}