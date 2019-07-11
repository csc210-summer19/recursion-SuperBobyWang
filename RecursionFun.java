/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Boby Wang
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		} else if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n < 1000) {
			return String.valueOf(n);
		}
		if (n % 1000 < 10) {
			return intWithCommas(n / 1000) + ",00" + (n % 1000);
		} else if (n % 1000 < 100) {
			return intWithCommas(n / 1000) + ",0" + (n % 1000);
		} else {
			return intWithCommas(n / 1000) + "," + (n % 1000);
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (index > len - 1) {
			return;
		}
		int temp = x[index];
		x[index] = x[len - 1];
		x[len - 1] = temp;
		reverseArray(x, index + 1, len - 1);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		if (a.length == 1) {
			return 0;
		} else if (a.length == 2) {
			return Math.abs(a[0] - a[1]);
		} else {
			int min = arrayRangeMin(a, 0);
			int max = arrayRangeMax(a, 0);
			return max - min;
		}
	}

	public int arrayRangeMin(int[] a, int index) {
		if (index == a.length - 1) {
			return a[index];
		} else {
			return Math.min(a[index], arrayRangeMin(a, index + 1));
		}
	}

	public int arrayRangeMax(int[] a, int index) {
		if (index == a.length - 1) {
			return a[index];
		} else {
			return Math.max(a[index], arrayRangeMax(a, index + 1));
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return isSortedHelper(nums, 0);
	}

	public boolean isSortedHelper(int[] nums, int index) {
		if (nums.length < 2) {
			return true;
		}
		if (index == nums.length - 1) {
			return true;
		}
		if (nums[index] > nums[index + 1]) {
			return false;
		} else {
			return isSortedHelper(nums, index + 1);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return foundHelper(search, strs, 0);
	}

	public boolean foundHelper(String search, String[] strs, int index) {
		if (index == strs.length - 1 && !strs[index].equals(search)) {
			return false;
		} else if (strs[index].equals(search)) {
			return true;
		} else {
			return foundHelper(search, strs, index + 1);
		}
	}

}
