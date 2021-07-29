/*
 * An array of integers representing coins is passed into the 'solution' method.
 * 
 * Coins showing as heads are represented by 0s, and tails are represented as 1s.
 * 
 * The program finds the minimum number of coin switches needed to achieve an alternating array of coins, e.g. 101010 or 010101 if there are (for example) six coins. 
 */
import java.util.ArrayList;

public class Solution {

	public int solution(int[] coins) {
		// Creates two lists of alternating coins, one beginning 0 and one beginning 1
		ArrayList<Integer> coinsBeginningHeads = populateCoinList(0, coins.length);
		ArrayList<Integer> coinsBeginningTails = populateCoinList(1, coins.length);
		// Each deviation from an alternating series of coins represents a coin flip that needs to be made.
		int numDeviationsWithHeads = 0;
		int numDeviationsWithTails = 0;
		for (int i = 0; i < coins.length; i++) {
			if (coins[i] != coinsBeginningHeads.get(i)) {
				numDeviationsWithHeads++;
			}
			if (coins[i] != coinsBeginningTails.get(i)) {
				numDeviationsWithTails++;
			}
		}
		return numDeviationsWithHeads < numDeviationsWithTails ? numDeviationsWithHeads : numDeviationsWithTails;
	}

	private static ArrayList<Integer> populateCoinList(int initialValue, int numCoins) {
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		for (int j = 0; j < numCoins; j++) {
			tempList.add(initialValue);
			if (initialValue == 0) {
				initialValue = 1;
			} else {
				initialValue = 0;
			}
		}
		return tempList;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] arrayOfCoins = new int[] { 1, 0, 1, 0, 1, 1 };
		System.out.println(test.solution(arrayOfCoins)); // Expected output: 1
		arrayOfCoins = new int[] { 1, 1, 0, 1, 1 };
		System.out.println(test.solution(arrayOfCoins)); // Expected output: 2
		arrayOfCoins = new int[] { 0, 1, 1, 0 };
		System.out.println(test.solution(arrayOfCoins)); // Expected output: 2
		arrayOfCoins = new int[] { 0, 1, 0, 1 };
		System.out.println(test.solution(arrayOfCoins)); // Expected output: 0
	}
}
