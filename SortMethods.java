
/**
 * SortMethods - Sorts an array of Citys in ascending order.
 *
 * @author Raima Falor
 * @since December 5, 2022
 */
import java.util.*;

public class SortMethods {

	/**
	 * Bubble Sort algorithm - in ascending order
	 * 
	 * @param arr array of City objects to sort
	 */
	public void bubbleSort(List<City> arr) {
		for (int outer = arr.size() - 1; outer > 0; outer--) {
			for (int inner = 0; inner < outer; inner++) {
				if (arr.get(inner).compareTo(arr.get(inner + 1)) > 0) {
					swap(arr, inner, inner + 1);
				}
			}
		}
	}

	/**
	 * Swaps two City objects in array arr
	 * 
	 * @param arr array of City objects
	 * @param x   index of first object to swap
	 * @param y   index of second object to swap
	 */
	private void swap(List<City> arr, int x, int y) {
		City temp = arr.get(x);
		arr.set(x, arr.get(y));
		arr.set(y, temp);
	}

	/**
	 * Selection Sort algorithm - in ascending order
	 * 
	 * @param arr array of City objects to sort
	 */
	public void selectionSortByPopulationAsc(List<City> arr) {
		int total = arr.size() - 1;
		int first = 0;
		int y;

		while (total >= 0) {
			City min = arr.get(first);
			y = first;
			for (int i = (first + 1); i < arr.size(); i++) {
				if (arr.get(i).compareTo(min) < 0) {
					min = arr.get(i);
					y = i;
				}
			}
			swap(arr, first, y);
			total--;
			first++;

		}
	}

	/**
	 * Insertion Sort algorithm - in ascending order (you implement)
	 * 
	 * @param arr array of City objects to sort
	 */
	public void insertionSortByNameAsc(List<City> arr) {
		int midIndex = 1;
		int current = midIndex;

		while (midIndex < arr.size()) {
			for (int i = midIndex - 1; i >= 0; i--) {
				current = i + 1;
				if (arr.get(i).getName().compareTo(arr.get(current).getName()) > 0) {
					swap(arr, current, i);
				}
			}
			midIndex++;
		}
	}

	/**
	 * Insertion Sort algorithm - in descending order (you implement)
	 * 
	 * @param arr array of City objects to sort
	 */
	public void insertionSortByPopulationDesc(List<City> arr) {
		int midIndex = 1;
		int current = midIndex;

		while (midIndex < arr.size()) {
			for (int i = midIndex - 1; i >= 0; i--) {
				current = i + 1;
				if (arr.get(i).compareTo(arr.get(current)) < 0) {
					swap(arr, current, i);
				}
			}
			midIndex++;
		}
	}

	/**
	 * In place Merge Sort algorithm - in descending order (you implement)
	 * 
	 * @param arr array of City objects to sort
	 */

	public void mergeSortByPopulationDesc(List<City> arr) {
		popSort(arr, 0, arr.size() - 1);
	}

	public void mergeSortByNameDesc(List<City> arr) {
		nameSort(arr, 0, arr.size() - 1);
	}

	private void popMerge(List<City> array, int left, int mid, int right) {
		// Find sizes of two halves to be merged
		int size1 = mid - left + 1;
		int size2 = right - mid;

		// Create temp ArrayLists
		ArrayList<City> temp1 = new ArrayList<>();
		ArrayList<City> temp2 = new ArrayList<>();

		// Copy data to temp ArrayLists
		for (int i = 0; i < size1; i++) {
			temp1.add(array.get(left + i));
		}

		for (int j = 0; j < size2; j++) {
			temp2.add(array.get(mid + 1 + j));
		}

		// Initial indexes of first and second halves
		int i = 0, j = 0;

		int k = left;
		while (i < size1 && j < size2) {
			if (temp1.get(i).compareTo(temp2.get(j)) > 0) {
				array.set(k, temp1.get(i));
				i++;
			} else {
				array.set(k, temp2.get(j));
				j++;
			}
			k++;
		}

		// Copy the rest of the longer half
		while (i < size1) {
			array.set(k, temp1.get(i));
			i++;
			k++;
		}
		while (j < size2) {
			array.set(k, temp2.get(j));
			j++;
			k++;
		}
	}

	private void nameMerge(List<City> array, int left, int mid, int right) {
		int size1 = mid - left + 1;
		int size2 = right - mid;

		ArrayList<City> temp1 = new ArrayList<>();
		ArrayList<City> temp2 = new ArrayList<>();

		for (int i = 0; i < size1; i++) {
			temp1.add(array.get(left + i));
		}

		for (int j = 0; j < size2; j++) {
			temp2.add(array.get(mid + 1 + j));
		}

		int i = 0, j = 0;

		int k = left;
		while (i < size1 && j < size2) {
			if (temp1.get(i).getName().compareTo(temp2.get(j).getName()) > 0) {
				array.set(k, temp1.get(i));
				i++;
			} else {
				array.set(k, temp2.get(j));
				j++;
			}
			k++;
		}

		while (i < size1) {
			array.set(k, temp1.get(i));
			i++;
			k++;
		}
		while (j < size2) {
			array.set(k, temp2.get(j));
			j++;
			k++;
		}
	}

	public void popSort(List<City> array, int left, int right) {
		if (left < right) {
			// Find the midpoint
			int mid = left + (right - left) / 2;

			// Sort first and second half
			popSort(array, left, mid);
			popSort(array, mid + 1, right);

			// Merge the sorted arrays
			popMerge(array, left, mid, right);
		}
	}

	public void nameSort(List<City> array, int left, int right) {
		if (left < right) {
			// Find the midpoint
			int mid = left + (right - left) / 2;

			// Sort first and second half
			nameSort(array, left, mid);
			nameSort(array, mid + 1, right);

			// Merge the sorted arrays
			nameMerge(array, left, mid, right);
		}
	}

	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/

	/**
	 * Print an array of Citys to the screen
	 * 
	 * @param arr the array of Citys
	 */
	public void printArray(List<City> arr) {
		if (arr.size() == 0)
			System.out.print("(");
		else
			System.out.printf("( %4d", arr.get(0).getPopulation());
		for (int a = 1; a < arr.size(); a++) {
			if (a % 10 == 0)
				System.out.printf(",\n  %4d", arr.get(a).getPopulation());
			else
				System.out.printf(", %4d", arr.get(a).getPopulation());
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		se.run();
	}

	public void run() {
		List<City> arr = new ArrayList<City>();
		// Fill arr with random numbers
		for (int a = 0; a < 10; a++) {
			City city = new City("Cupertino", "California", "city", (int) (1000 * Math.random()));
			;
			arr.add(city);
		}

		System.out.println("\nBubble Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		bubbleSort(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		System.out.println("\nSelection Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		selectionSortByPopulationAsc(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		System.out.println("\nInsertion Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		insertionSortByPopulationDesc(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();

		System.out.println("\nMerge Sort");
		System.out.println("Array before sort:");
		printArray(arr);
		System.out.println();
		mergeSortByPopulationDesc(arr);
		System.out.println("Array after sort:");
		printArray(arr);
		System.out.println();
	}
}