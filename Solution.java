/*
 * An array of integers representing coins is passed into the 'solution' method.
 * 
 * Coins showing as heads are represented by 0s, and tails are represented as 1s.
 * 
 * The program finds the minimum number of coin switches needed to achieve an alternating array of coins, e.g. 101010 or 010101 if there are (for example) six coins. 
 */

public class Solution {

	public int solution(int[] coins) {
		// Each deviation from a particular alternating series of coins represents a
		// coin flip that needs to be made to make 'coins' identical to the alternating series of
		// coins in question.
		int numDeviationsWithHeads = getNumDeviations(0, coins);
		int numDeviationsWithTails = getNumDeviations(1, coins);
		return numDeviationsWithHeads < numDeviationsWithTails ? numDeviationsWithHeads : numDeviationsWithTails;
	}

	private int getNumDeviations(int headsOrTails, int[] coins) {
		// With 'headsOrTails, heads = 0, tails = 1
		int numDeviations = 0;
		for (int coin : coins) {
			if (coin != headsOrTails) {
				numDeviations++;
			}
			headsOrTails = headsOrTails == 0 ? 1 : 0;
		}
		return numDeviations;
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
