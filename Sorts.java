package sortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Program to run 4 sort algorithms: Bubble Sort, Selection Sort, Insertion Sort
 * and Quicksort.
 * 
 * @author Kevin Lee
 * @version 0.0
 * 
 *          Structure of file: - Sort methods - Sort wrapper methods - Input
 *          methods - Utility methods
 * 
 */

public class Sorts {

	private static final int REPEATS = 30;

	public static final void main(String[] argv) {

		new Sorts().run();

	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		int sortType = menuSelect(scanner, "sortType");
		int arraySize = menuSelect(scanner, "arraySize");
		int[] numbers = createArray(arraySize);
		long averageSortTime = runSortAlgorithm(sortType, numbers);
		System.out.println(averageSortTime + " <-- microseconds");

	}

	/*******
	 * Sort methods 
	 * ******
	 */

	/**
	 * Sorts an array of numbers using quicksort
	 * 
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void quicksort(int[] numbers) {
		if (numbers.length == 0)
			return;
		sort(0, numbers.length - 1, numbers);

	}

	/**
	 * Helper method for quicksort. Recursively sorts an array of numbers
	 * 
	 * @param low
	 *            - A pointer to the smallest element in the array
	 * @param high
	 *            - A pointer to the largest element in the array
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	private static void sort(int low, int high, int[] numbers) {
		int i = low;
		int j = high;

		int pivot = numbers[i + ((j - i) / 2)];

		// Divide into two lists
		while (i <= j) {

			// Increment 'i' until numbers[i] is no longer less than pivot
			while (numbers[i] < pivot) {
				i++;
			}

			// Decrement 'j' until numbers[j] is no longer greater than pivot
			while (numbers[j] > pivot) {
				j--;
			}

			// numbers[i] > pivot, and numbers[j] < pivot, so we exchange the
			// two
			if (i <= j) {
				exchange(i, j, numbers);
				i++;
				j--;
			}
		}

		// Recursion
		if (low < j)
			sort(low, j, numbers);
		if (i < high)
			sort(i, high, numbers);

	}

	/**
	 * Helper method for quicksort Swaps numbers[i] with numbers[j]
	 * 
	 * @param i
	 *            - Pointer to the 1st element to be swapped
	 * @param j
	 *            - Pointer to the 2nd element to be swapped
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void exchange(int i, int j, int[] numbers) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

	/**
	 * Sorts an array of
	 * numbers using Bubble Sort
	 * 
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void bubbleSort(int[] numbers) {
		for (int i = numbers.length; i > 0; i--) {
			for (int j = 0; j < (numbers.length - 1); j++) {
				if (numbers[j + 1] < numbers[j]) {
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Sorts an array of numbers using Insertion Sort
	 * 
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void insertionSort(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			int key = numbers[i];
			int j = i - 1;
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j--;
			}
			numbers[j + 1] = key;
		}
	}

	/**
	 * Sorts an array of numbers using Selection Sort
	 * 
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void selectionSort(int[] numbers) {
		int min, i, j;
		for (i = 0; i < numbers.length - 1; i++) {
			min = i;
			for (j = i + 1; j < numbers.length; j++) {
				if (numbers[j] < numbers[min])
					min = j;
			}
			int temp = numbers[i];
			numbers[i] = numbers[min];
			numbers[min] = temp;
		}
	}
	
	/**
	 *  Sorts an array of numbers using Shell Sort
	 * 
	 * @param numbers
	 *            - Array of numbers to be sorted
	 */
	public static void shellSort(int[] numbers){
		if (numbers == null) return;
		
		int len = numbers.length;
		if (len < 2) return;
		int h = 1;
		while (h < len / 3) h = 3 * h + 1;
		while (h >= 1){
			for (int i = h; i < len; i++){
				for (int j = i; j >= h && (numbers[j] < numbers[j-h]); j-=h){
					int temp = numbers[j];
					numbers[j] = numbers[j-h];
					numbers[j-h] = temp;
				}
				h = h/3;
			}
		}
		
	}

	/******
	 * Sort wrapper methods 
	 * ****
	 */

	/**
	 * Initiates tests for Bubble Sort. Includes randomization of array and
	 * timing
	 * 
	 * @param numbers
	 *            - array of numbers to sort
	 * @param repeats
	 *            - number of times to sort the array
	 * @return - The average time taken to sort
	 */
	public long runBubbleSort(int[] numbers, int repeats) {
		ArrayList<Long> times = new ArrayList<Long>();
		for (int i = 0; i < repeats; i++) {
			randomize(numbers);
			System.gc();
			long startTime = System.nanoTime();
			bubbleSort(numbers);
			long elapsedTime = System.nanoTime() - startTime;
			times.add(elapsedTime);
		}
		long average = getAverages(times);
		return average;
	}

	/**
	 * Initiates tests for Insertion Sort. Includes randomization of array and
	 * timing
	 * 
	 * @param numbers
	 *            - array of numbers to sort
	 * @param repeats
	 *            - number of times to sort the array
	 * @return - The average time taken to sort
	 */
	public long runInsertionSort(int[] numbers, int repeats) {
		ArrayList<Long> times = new ArrayList<Long>();
		for (int i = 0; i < repeats; i++) {
			randomize(numbers);
			System.gc();
			long startTime = System.nanoTime();
			insertionSort(numbers);
			long elapsedTime = System.nanoTime() - startTime;
			times.add(elapsedTime);
		}
		long average = getAverages(times);
		return average;
	}

	/**
	 * Initiates tests for Selection Sort. Includes randomization of array and
	 * timing
	 * 
	 * @param numbers
	 *            - array of numbers to sort
	 * @param repeats
	 *            - number of times to sort the array
	 * @return - The average time taken to sort
	 */
	public long runSelectionSort(int[] numbers, int repeats) {
		ArrayList<Long> times = new ArrayList<Long>();
		for (int i = 0; i < repeats; i++) {
			randomize(numbers);
			System.gc();
			long startTime = System.nanoTime();
			selectionSort(numbers);
			long elapsedTime = System.nanoTime() - startTime;
			times.add(elapsedTime);
		}
		long average = getAverages(times);
		return average;
	}

	/**
	 * Initiates tests for Quicksort. Includes randomization of array and timing
	 * 
	 * @param numbers
	 *            - array of numbers to sort
	 * @param repeats
	 *            - number of times to sort the array
	 * @return - The average time taken to sort
	 */
	public long runQuicksort(int[] numbers, int repeats) {
		ArrayList<Long> times = new ArrayList<Long>();
		for (int i = 0; i < repeats; i++) {
			randomize(numbers);
			System.gc();
			long startTime = System.nanoTime();
			quicksort(numbers);
			long elapsedTime = System.nanoTime() - startTime;
			times.add(elapsedTime);
		}
		long average = getAverages(times);
		return average;
	}

	/**
	 * Initiates tests for Shell Sort. Includes randomization of array and timing
	 * 
	 * @param numbers
	 *            - array of numbers to sort
	 * @param repeats
	 *            - number of times to sort the array
	 * @return - The average time taken to sort

	 */
	public long runShellSort(int[] numbers, int repeats) {
		ArrayList<Long> times = new ArrayList<Long>();
		for (int i = 0; i < repeats; i++) {
			randomize(numbers);
			System.gc();
			long startTime = System.nanoTime();
			shellSort(numbers);
			long elapsedTime = System.nanoTime() - startTime;
			times.add(elapsedTime);
		}
		long average = getAverages(times);
		return average;
	}

	
	/*****
	 * Input methods 
	 * *****
	 */

	/**
	 * Based on selection by user, gives the average time required to sort an
	 * array of randomly generated integers using Bubble Sort, Selection Sort,
	 * Insertion Sort or Quicksort.
	 * 
	 * @param selection
	 *            - the selection made by user
	 * @param numbers
	 *            - array of randomly generated integers
	 * @return - the average time taken to sort array
	 */
	private long runSortAlgorithm(int selection, int[] numbers) {
		long averageTime;

		switch (selection) {
		case 1:
			averageTime = runBubbleSort(numbers, REPEATS);
			break;
		case 2:
			averageTime = runSelectionSort(numbers, REPEATS);
			break;
		case 3:
			averageTime = runInsertionSort(numbers, REPEATS);
			break;
		case 4:
			averageTime = runQuicksort(numbers, REPEATS);
			break;
		case 5:
			averageTime = runShellSort(numbers, REPEATS);
			break;
		}
		return averageTime / (long) 1000;
	}

	/**
	 * Creates an array of random positive and negative integers. Size of array
	 * is determined by selection
	 * 
	 * @param selection
	 *            - the selection made by user
	 * @return - An array of size 2.5k, 5k, 10k or 100k randomly generated
	 *         numbers.
	 */
	private int[] createArray(int selection) {
		int[] array;
		int arraySize;

		switch (selection) {
		case 1:
			arraySize = 2500;
			break;
		case 2:
			arraySize = 5000;
			break;
		case 3:
			arraySize = 10000;
			break;
		default:
			arraySize = 100000;
			break;
		}
		array = createRandomArray(arraySize);
		return array;
	}

	/**
	 * Creates an array of randomly generated numbers. Includes negative and
	 * repeat numbers
	 * 
	 * @param size
	 *            - Size of array
	 * @return - An array of size 'size' with randomly generated numbers.
	 */
	private int[] createRandomArray(int size) {

		Random random = new Random();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(size / 2) - (size / 4);
		}
		return array;
	}

	/**
	 * Allows user to select either: 
	 * - sort type (Bubble Sort / Selection Sort / Insertion Sort / Quicksort); or 
	 * - array size (2.5k, 5k, 10k, or 100k) (based on value of "purpose" parameter)
	 * 
	 * @param scanner
	 *            - scanner object
	 * @param purpose
	 *            - whether the selection is for sort type ("sortType") or array size ("arraySize")
	 * @return - an integer representing the type of sort that's selected
	 */
	private int menuSelect(Scanner scanner, String purpose) {
		boolean valid = false;
		int selection = 0;
		while (!valid) {
			if (purpose.equals("sortType")) {
				System.out
						.println("Select type of sort:\n\t1. Bubble Sort\n\t2. Selection Sort\n\t3. Insertion Sort\n\t4. Quicksort\n\t5. Shell Sort\nSelect 1, 2, 3, 4 or 5: ");
			} else if (purpose.equals("arraySize")) {
				System.out
						.println("Select size of array:\n\t1. 2,500\n\t2. 5,000\n\t3. 10,000\n\t4. 100,000\nSelect 1, 2, 3 or 4: ");
			}
			String input = scanner.next();
			if (isValid(input)) {
				valid = true;
				selection = Integer.parseInt(input);
			}
		}
		return selection;
	}


	
	/******
	 * Utility methods *******
	 */

	/**
	 * Randomizes an array in place.
	 * 
	 * @param array
	 *            - The array to be suffled.
	 */
	public static void randomize(int[] array) {
		java.util.Random rand = new java.util.Random();
		for (int i = array.length; i > 1; i--) {
			int choice = rand.nextInt(i);
			int temp = array[choice];
			array[choice] = array[i - 1];
			array[i - 1] = temp;
		}
	}

	/**
	 * Finds the average in an arrayList of times. If the size of the array is >
	 * 2, removes the largest and smallest elements. 
	 * @param times ArrayList of
	 * times (as longs)
	 * 
	 * @param times
	 *            - the arrayList of times to be averaged
	 * @return - the average of the arrayList
	 */
	public static long getAverages(ArrayList<Long> times) {

		if (times.size() > 2) {
			Collections.sort(times);
			times.remove(times.size() - 1);
			times.remove(0);
		}

		long totalTime = 0;
		for (long time : times) {
			totalTime += time;
		}
		long averageTime = totalTime / times.size();
		return averageTime;
	}

	/**
	 * Determines whether an input is valid
	 * 
	 * @param input
	 *            - Text that is input
	 * @return - True if input = 1, 2, 3, 4, 5
	 */
	public static boolean isValid(String input) {
		if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("5"))
			return true;
		return false;
	}

}
