/**
 * LAB 3 -  Lotto QuickPicker Game 
 */
package edu.cuny.csi.csc330.lab3;

import edu.cuny.csi.csc330.util.Randomizer;
import java.util.Date;
import java.util.Random;
import java.util.Arrays;
import java.util.*;

public class LottoQuickPicker {

	// constants specific to current game - BUT NOT ALL GAMES
	public final static int DEFAULT_GAME_COUNT = 1;
	private final static String GAME_NAME = "Lotto";
	private final static int SELECTION_POOL_SIZE = 59;
	private final static int SELECTION_COUNT = 6;
	static protected Date timeOfPurchase;

	private String[] args;

	public LottoQuickPicker(String[] args) {
		this.args = args;
	}

	public LottoQuickPicker() {
		init(DEFAULT_GAME_COUNT);
	}

	public LottoQuickPicker(int games) {
		init(games);
	}

//	public int generateInts(int low, int high) {
//
//		
//		return (int) ((Math.random() * (high - low)) + low);
//	}

	private void init(int games) {

		/**
		 * 
		 * Now what ... START FROM HERE What additional methods do you need? What
		 * additional data properties/members do you need?
		 */

		int[] lottoGames = new int[SELECTION_COUNT];

		for (int i = 0; i < SELECTION_COUNT; ++i) {
			lottoGames[i] = Randomizer.generateInt(DEFAULT_GAME_COUNT, SELECTION_POOL_SIZE);
		}

		Arrays.sort(lottoGames);
		for (int i = 0; i < SELECTION_COUNT; ++i) {
			System.out.printf(" %02d ", lottoGames[i]);
		}
	}

	protected void displayHeading() {
		System.out.println("-----------------------------------------\n" + "------------------" + GAME_NAME
				+ "------------------");

	}

	protected void displayFooter() {

		timeOfPurchase = new Date();
		System.out.println("\t" + timeOfPurchase);
	}

	/**
	 * 
	 * @return
	 */

	// Function uses scanner to take user input for game specification and
	// multiplies the chance of one lotto game
	// to win by the selection poolsize subtracted iterations of i from the for loop
	// divided by i.
	private long calculateOdds() {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter Lotto Count: ");
		int lottoCount = input.nextInt();
		System.out.println("Enter Lotto Pool Size: ");
		int poolSize = input.nextInt();

		int lottoWin = 1;
		for (int i = 1; i <= lottoCount; i++) {
			lottoWin = lottoWin * (poolSize - i + 1) / i;
		}
		System.out.println("Odds of Winning: 1 in " + lottoWin);

		return 0;
	}

	/**
	 * 
	 */
	public void displayTicket() {

		/**
		 * display heading
		 * 
		 * for i in gameCount generate selectionCount number of unique random selections
		 * in ascending order
		 * 
		 * display footer
		 */

		// display ticket heading
		displayHeading();

		/**
		 * Display selected numbers
		 */

		// display ticket footer
		displayFooter();

		for (int i = 0; i < args.length; i++) {
			Arrays.sort(args);

			System.out.printf("\n(%s) ", args[i]);
			init(SELECTION_COUNT);

		}

		if (args.length == 0) {
			System.out.printf("\n(%s) ", DEFAULT_GAME_COUNT);
			init(DEFAULT_GAME_COUNT);

		}
		System.out.println("\n");
		calculateOdds();

		System.out.println("\n-----------" + " S.I. Corner Deli " + "------------\n"
				+ "-----------------------------------------\n");
		return;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// takes an optional command line parameter specifying number of QP games to be
		// generated
		// By default, generate 1

		int numberOfGames = DEFAULT_GAME_COUNT;

		if (args.length > 0) { // if user provided an arg, assume it to be a game count
			numberOfGames = Integer.parseInt(args[0]); // [0] is the 1st element!
			// System.out.println(numberOfGames);

		}
		LottoQuickPicker lotto = new LottoQuickPicker(args);

		lotto.displayTicket();

	}

}
