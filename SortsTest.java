package sortingAlgorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class SortsTest {

	private int[] noArray;
	private int[] tinyArray;
	private int[] smallArray;
	private int[] repeatArray;
	private int[] largeArray;

	@Before
	public void setUp() throws Exception {
		noArray = new int[] {};
		tinyArray = new int[] { 0 };
		smallArray = new int[] { -3, 1, 5 };
		repeatArray = new int[] { -3, 1, 1, 1, 1, 1, 1, 1, 1 };
		largeArray = new int[] { 5326, -7057, 9692, -6641, -6641, -8805, 5890, 9829, -4777, 1324, 1509, 699, -2891,
				-2262, -8658, 1760, 1154, -8056, -2715, -2241, -4434, -8247, -9323, -1701, 9645, -2069, 7006, -1002,
				3328, -5454, 8468, -8291, 5289, 1714, -709, -3036, -3956, -9966, 9587, 5047, 6619, -9865, -1106, 1102,
				-3187, -5301, 2743, -1138, 5231, -812, 4469, -9599, 7986, 3384, -7546, 1192, 4495, 4818, -3990, 6707,
				-2580, -2600, -3230, 1299, 3310, 9135, -4861, 6047, 1030, 7023, -1155, 5144, 6612, -3820, 9238, -1027,
				-6748, -7277, -4056, 3555, -1536, -7877, -6088, 4862, 9639, 9907, -3540, 7674, -6262, -6367, 9918,
				1993, -3133, -1290, 3978, 4220, 9992, -5961, -2897, -1883, 1533, 9560, -6518, 9191, 2226, 6021, -2960,
				2100, 155, 9393, -8978, 7381, -8682, 134, 5381, -613, 8985, 9528, 1564, -4277, -5611, -5372, -2964,
				1459, 319, -7730, -3524, -5589, 1936, 9923, 3283, -530, 6835, 5565, -292, -9484, -1047, -3322, -673,
				5358, 2531, -8436, -7881, 3271, 4254, -6629, -8688, 7948, -8048, -6119, -3871, 864, -5062, -4083,
				-9068, 3049, 556, -229, -5707, -9205, 8642, 3322, -1699, 2239, 5048, -5606, -5451, 3914, 3312, -3386,
				8069, 6876, 8662, 9895, -3012, -3802, 1702, -2340, 4668, -3254, 9668, 5229, 4605, -6597, -8588, 3016,
				-9096, -7706, 5812, 118, 6238, 2590, -4053, -7472, -5473, 5679, -9477, -611, 2053, 1295, -1269, -5205,
				-2649, -4184, -856, -728, -9170, 5023, 8164, -4501, -2720, 9418, 9449, -6506, -3216, 240, -1949, -1853,
				-2409, 5686, -9310, -5480, -5793, 8625, -6537, -9933, 5320, 13, -6205, 8885, -5937, 6439, 477, -23,
				-1022, 5430, -5677, -519, -6381, -4898, -8706, 3982, 627, -6057, 3226, 6380, 8100, -2214, -4461, 1081,
				7989, 4150, -4579, -9136, -3003, -3255, -6160, 7098, 1576, 9112, -7666, -7443, -3494, 7201, 5419, 1462,
				8082, 781, 144, -678, 4259, 7793, -3202, 710, 5443, -9457, 1482, -5647, -3848, 5163, -9362, 6038,
				-3764, -3720, -5532, -234, -8167, -4257, 90, -8106, -1595, 6429, -324, 5242, 225, -72, 9614, 1825,
				6583, 330, 6663, 3871, -6366, -539, 3257, 3983, 2983, -8121, -1655, -4707, -7020, 9882, -8026, 2024,
				-7441, -6330, 2074, -6439, 1333, 2530, -6064, -7496, -3463, -9474, 3755, 4713, -7845, -9734, 8288,
				3681, -1039, 8188, -4311, -8715, -5529, 6432, 6954, 3748, 7108, 6768, 3945, -5899, 418, -5242, 3885,
				-9922, 7578, -472, -1261, -5715, 2943, 4161, -1485, -1589, 3078, -700, -7725, -8152, -4857, 9253,
				-7960, 3615, 9107, 7619, 909, -2023, 1558, -9881, -8796, 2029, -1835, 1960, 7139, -5339, 7359, -7089,
				-3726, 4120, -9141, -4147, -8693, 6378, -1577, -7954, 3445, 2542, 7776, -7997, -7917, 7657, -7593,
				-3530, -4647, 5744, 4362, -1149, -6388, 1751, -1315, 84, -5361, 6609, -7620, 7511, -6787, -6619, -9119,
				-6, -910, 6263, 2376, 5798, -5084, -3658, -5664, -1684, -2674, -2563, 9307, -9557, -123, -1006, -3953,
				-6356, 4567, -8540, -8369, 6169, 5822, -60, 6795, 8314, -8304, -9724, 6054, -4866, 2661, -7296, -4608,
				2488, 6918, -6443, 5767, 9, -1921, 6941, 5432, -7320, -3829, -3893, -6914, -3852, 1329, 3503, 2077,
				-7765, -146, 5662, 8132, 2399, -3986, 126, -335, -2015, 9732, 1225, -6696, -3974, -8679, 3719, 6402,
				-1461, 8420, 6584, 1595, 2591, 896, 370, 5128, -4419, 9801, 4267, 7125, 9030, -7028, 4887, 4751, 7582,
				6834, -3074, -3967, 8836, 6738, 7378, -5770, -4283, -6324, -7494, 367, -5359, 2695, -9680, -6980,
				-9231, -9103, 6970, 7501, -7029, 564, -7998, -3019, 9759, -5676, -3644, -6946, 4143, -7018, -5787,
				-7355, 425, -3612, -7658, -886, 2675, -9829, -5526, 6062, 6251, -2844, -6017, 7699, -2773, -6913,
				-8137, -7667, -7702, 4587, -8175, 9346, 7244, 1119, -8728, -3470, -8488, 3599, 1838, -7239, 7560, 3803,
				7272, 3953, -6251, 7800, 3294, 9338, -9629, 9151, 4171, 4091, -7085, 300, -4387, -7215, -8051, 7512,
				-274, 3086, -5133, -3115, 3562, 226, 1710, 2999, 1885, -8733, 8230, -3215, -2324, 1626, -4243, -7486,
				4720, -9195, -3244, -8323, -8606, -2995, 7334, -4590, 71, -7743, -4806, -2943, -621, 3621, -6493,
				-5032, -2998, -7253, -8632, -6514, 1385, -9931, -5995, 6819, -2057, 7242, -5022, -9176, -1934, -4074,
				-9657, -8308, 9375, 4229, 6729, 3339, -3148, -7450, 9951, -1167, -3162, 475, 276, 1220, 8271, -3011,
				9045, -8270, -1908, 1668, -2179, -3569, -8873, 9443, -4938, -9012, -8719, -348, 7103, -1464, 9321, 277,
				-3330, 2316, -8030, 3912, 3888, -2959, -158, -971, 7816, 3522, 8257, 2904, 5387, 7663, 4399, 2847, 738,
				8499, 4011, -7101, 335, -3583, -8214, 2208, -7132, -4924, -9547, 6324, 8485, -2638, -7624, 5775, -5828,
				7993, 2880, 2762, 614, -7382, -5824, 730, -8512, -5849, 3630, 6, -2491, 7799, 8334, -5138, 1890, -2423,
				4051, -8138, -8412, -6178, -6879, 8616, -1988, -7473, -9606, 585, 7195, 7679, 3370, 6924, -603, 594,
				-2277, -8887, 6234, 7465, 5511, 2015, 3012, 1484, 581, -9536, -9876, 7368, 8217, 2728, -1224, -6562,
				503, -2395, 2515, 9284, -8817, -7897, -9810, 9834, 6101, -2694, 6246, -7832, 4533, 4510, 6585, 9050,
				-6640, 3670, 99, 9499, 5751, -2083, -5919, 1557, 9763, 6844, 2873, -6434, 1306, 2585, 7787, 6232,
				-1061, -5056, 4794, 9034, -1209, -2174, -4324, -3772, 4505, -925, -4477, 557, -5976, -773, 8568, -4747,
				7545, -5208, -1991, 6902, -1147, -5503, 4998, 5354, 7972, -5789, -4943, -5114, -9936, -9522, -5952,
				-98, -2301, 6348, 1399, 6787, 9892, -7011, -9548, 6640, 9447, -8450, -4798, -6091, -7458, -7894, -5695,
				7593, 4497, 389, -2025, 409, 3987, -7362, -8282, 7237, -5574, 8506, 7184, -5918, -2792, 9546, 9282,
				-2799, 5250, 6579, 7893, 5727, 4201, -7529, 3472, -2492, 2220, -2260, 467, 2061, 2437, -8469, 1105,
				-4785, 9643, -6582, 3966, 1378, -7560, 3698, -4483, -4430, -4152, 2341, -3374, -2582, 8884, 3164, 8975,
				-1944, -9400, -6635, -8217, 5934, -5283, -1011, 4498, 4630, -4759, 4056, 9154, -8262, -3376, -2121,
				5715, -7449, 2093, 6410, 5158, -4840, 5581, 6723, -3941, 3474, 6207, -1805, -2136, 7856, -4665, 7741,
				-3491, 5853, -5279, 685, -73, -3534, -8954, -8182, -1772, 3998, 3760, 6742, -5528, 7038, 2533, 6459,
				-8208, -2541, 6146, -629, 1337, 7361, 5473, 9544, -455, -6287, 3374, -3315, -6501, -4159, 7451, -7789,
				-2821, -860, -2246, -6470, -5428, -842, -2800, -2439, 922, -9949, 7450, 8291, 9684, 4553, -9418, 2022,
				-8942, -5563, 6339, 1428, -2991, 8048, -8393, -6273, 497, 5448, -708, 6882, 1731, -7957, 6320, -2467,
				203, -3475, -3042, -3292, -5487, -5290, -3999, 1222, -980, -9596, -527, -7599, 9079, -3952, -7526,
				-7405, -3090, -995, 6757, -6427, -3247, -924, -5229, 7567, 9129, 6153, 6950, -2096, -4702, -4508, -390,
				-4129, 8329, -4126, 5667, 2435, 4228, 4388, -1576, 7200, 4658, -8205, -230, 2005, -1635, -5447, -4842,
				3798, -5445, 6242, -1049, -2236, -1916 };
	}

	/**
	 * Selection Sort test methods
	 */

	@Test
	public void testSelectionSortSmall() {
		Sorts.randomize(smallArray);
		int[] smallArrayCopy = smallArray.clone();
		Sorts.selectionSort(smallArray);
		Arrays.sort(smallArrayCopy);
		assertArrayEquals(smallArrayCopy, smallArray);
	}

	@Test
	public void testSelectionSortNone() {
		Sorts.randomize(noArray);
		int[] noArrayCopy = noArray.clone();
		Sorts.selectionSort(noArray);
		Arrays.sort(noArrayCopy);
		assertArrayEquals(noArrayCopy, noArray);
	}

	@Test
	public void testSelectionSortTinyArray() {
		Sorts.randomize(tinyArray);
		int[] tinyArrayCopy = tinyArray.clone();
		Sorts.selectionSort(tinyArray);
		Arrays.sort(tinyArrayCopy);
		assertArrayEquals(tinyArrayCopy, tinyArray);
	}

	@Test
	public void testSelectionSortRepeatArray() {
		Sorts.randomize(repeatArray);
		int[] repeatArrayCopy = repeatArray.clone();
		Sorts.selectionSort(repeatArray);
		Arrays.sort(repeatArrayCopy);
		assertArrayEquals(repeatArrayCopy, repeatArray);
	}

	@Test
	public void testSelectionSortLargeArray() {
		Sorts.randomize(largeArray);
		int[] largeArrayCopy = largeArray.clone();
		Sorts.selectionSort(largeArray);
		Arrays.sort(largeArrayCopy);
		assertArrayEquals(largeArrayCopy, largeArray);
	}

	/**
	 * Insertion Sort test methods
	 */

	@Test
	public void testInsertionSortSmall() {
		Sorts.randomize(smallArray);
		int[] smallArrayCopy = smallArray.clone();
		Sorts.insertionSort(smallArray);
		Arrays.sort(smallArrayCopy);
		assertArrayEquals(smallArrayCopy, smallArray);
	}

	@Test
	public void testInsertionSortNone() {
		Sorts.randomize(noArray);
		int[] noArrayCopy = noArray.clone();
		Sorts.insertionSort(noArray);
		Arrays.sort(noArrayCopy);
		assertArrayEquals(noArrayCopy, noArray);
	}

	@Test
	public void testInsertionSortTinyArray() {
		Sorts.randomize(tinyArray);
		int[] tinyArrayCopy = tinyArray.clone();
		Sorts.insertionSort(tinyArray);
		Arrays.sort(tinyArrayCopy);
		assertArrayEquals(tinyArrayCopy, tinyArray);
	}

	@Test
	public void testInsertionSortRepeatArray() {
		Sorts.randomize(repeatArray);
		int[] repeatArrayCopy = repeatArray.clone();
		Sorts.insertionSort(repeatArray);
		Arrays.sort(repeatArrayCopy);
		assertArrayEquals(repeatArrayCopy, repeatArray);
	}

	@Test
	public void testInsertionSortLargeArray() {
		Sorts.randomize(largeArray);
		int[] largeArrayCopy = largeArray.clone();
		Sorts.insertionSort(largeArray);
		Arrays.sort(largeArrayCopy);
		assertArrayEquals(largeArrayCopy, largeArray);
	}

	/**
	 * Bubble Sort test methods
	 */

	@Test
	public void testBubbleSortSmall() {
		Sorts.randomize(smallArray);
		int[] smallArrayCopy = smallArray.clone();
		Sorts.bubbleSort(smallArray);
		Arrays.sort(smallArrayCopy);
		assertArrayEquals(smallArrayCopy, smallArray);
	}

	@Test
	public void testBubbleSortNone() {
		Sorts.randomize(noArray);
		int[] noArrayCopy = noArray.clone();
		Sorts.bubbleSort(noArray);
		Arrays.sort(noArrayCopy);
		assertArrayEquals(noArrayCopy, noArray);
	}

	@Test
	public void testBubbleSortTinyArray() {
		Sorts.randomize(tinyArray);
		int[] tinyArrayCopy = tinyArray.clone();
		Sorts.bubbleSort(tinyArray);
		Arrays.sort(tinyArrayCopy);
		assertArrayEquals(tinyArrayCopy, tinyArray);
	}

	@Test
	public void testBubbleSortRepeatArray() {
		Sorts.randomize(repeatArray);
		int[] repeatArrayCopy = repeatArray.clone();
		Sorts.bubbleSort(repeatArray);
		Arrays.sort(repeatArrayCopy);
		assertArrayEquals(repeatArrayCopy, repeatArray);
	}

	@Test
	public void testBubbleSortLargeArray() {
		Sorts.randomize(largeArray);
		int[] largeArrayCopy = largeArray.clone();
		Sorts.bubbleSort(largeArray);
		Arrays.sort(largeArrayCopy);
		assertArrayEquals(largeArrayCopy, largeArray);
	}

	/**
	 * Quicksort test methods
	 */

	@Test
	public void testQuicksortSmall() {
		Sorts.randomize(smallArray);
		int[] smallArrayCopy = smallArray.clone();
		Sorts.quicksort(smallArray);
		Arrays.sort(smallArrayCopy);
		assertArrayEquals(smallArrayCopy, smallArray);
	}

	@Test
	public void testQuicksortNone() {
		Sorts.randomize(noArray);
		int[] noArrayCopy = noArray.clone();
		Sorts.quicksort(noArray);
		Arrays.sort(noArrayCopy);
		assertArrayEquals(noArrayCopy, noArray);
	}

	@Test
	public void testQuicksortTinyArray() {
		Sorts.randomize(tinyArray);
		int[] tinyArrayCopy = tinyArray.clone();
		Sorts.quicksort(tinyArray);
		Arrays.sort(tinyArrayCopy);
		assertArrayEquals(tinyArrayCopy, tinyArray);
	}

	@Test
	public void testQuicksortRepeatArray() {
		Sorts.randomize(repeatArray);
		int[] repeatArrayCopy = repeatArray.clone();
		Sorts.quicksort(repeatArray);
		Arrays.sort(repeatArrayCopy);
		assertArrayEquals(repeatArrayCopy, repeatArray);
	}

	@Test
	public void testQuicksortLargeArray() {
		Sorts.randomize(largeArray);
		int[] largeArrayCopy = largeArray.clone();
		Sorts.quicksort(largeArray);
		Arrays.sort(largeArrayCopy);
		assertArrayEquals(largeArrayCopy, largeArray);
	}
	
	
	
	
	/**
	 * Shell Sort test methods
	 */

	@Test
	public void testShellSortSmall() {
		Sorts.randomize(smallArray);
		int[] smallArrayCopy = smallArray.clone();
		Sorts.shellSort(smallArray);
		Arrays.sort(smallArrayCopy);
		assertArrayEquals(smallArrayCopy, smallArray);
	}

	@Test
	public void testShellSortNone() {
		Sorts.randomize(noArray);
		int[] noArrayCopy = noArray.clone();
		Sorts.shellSort(noArray);
		Arrays.sort(noArrayCopy);
		assertArrayEquals(noArrayCopy, noArray);
	}

	@Test
	public void testShellSortTinyArray() {
		Sorts.randomize(tinyArray);
		int[] tinyArrayCopy = tinyArray.clone();
		Sorts.shellSort(tinyArray);
		Arrays.sort(tinyArrayCopy);
		assertArrayEquals(tinyArrayCopy, tinyArray);
	}

	@Test
	public void testShellSortRepeatArray() {
		Sorts.randomize(repeatArray);
		int[] repeatArrayCopy = repeatArray.clone();
		Sorts.shellSort(repeatArray);
		Arrays.sort(repeatArrayCopy);
		assertArrayEquals(repeatArrayCopy, repeatArray);
	}

	@Test
	public void testShellSortLargeArray() {
		Sorts.randomize(largeArray);
		int[] largeArrayCopy = largeArray.clone();
		Sorts.shellSort(largeArray);
		Arrays.sort(largeArrayCopy);
		assertArrayEquals(largeArrayCopy, largeArray);
	}

	/**
	 * Other test methods
	 */
	@Test
	public void testGetAverages() {
		long time1 = (long) 3.50;
		long time2 = (long) 5.55;
		long time3 = (long) 8.10;
		long time4 = (long) 19.09;
		long time5 = (long) 3.50;

		ArrayList<Long> times = new ArrayList<Long>();
		times.add(time1);
		times.add(time2);
		times.add(time3);
		times.add(time4);
		times.add(time5);
		assertEquals((long) 5.7166666666, Sorts.getAverages(times));

		ArrayList<Long> times2 = new ArrayList<Long>();
		times2.add(time1);
		assertEquals((long) 3.5, Sorts.getAverages(times2));

		ArrayList<Long> times3 = new ArrayList<Long>();
		times3.add(time1);
		times3.add(time2);
		assertEquals((long) 4.525, Sorts.getAverages(times3));

		ArrayList<Long> times4 = new ArrayList<Long>();
		times4.add(time2);
		times4.add(time3);
		times4.add(time4);
		assertEquals((long) 8.1, Sorts.getAverages(times4));

	}

	@Test
	public void testIsValid() {
		assertTrue(Sorts.isValid("1"));
		assertTrue(Sorts.isValid("2"));
		assertFalse(Sorts.isValid("-1"));
		assertFalse(Sorts.isValid("a"));
	}
}
