import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Population - <description goes here>
 *
 * Requires FileUtils and Prompt classes.
 *
 * @author
 * @since
 */
public class Population {

	// List of cities
	private List<City> cities = new ArrayList<City>();

	// List of states
	private List<String> states = new ArrayList<String>();

	// US data file
	private final String DATA_FILE = "usPopData2017.txt";

	public static void main(String[] args) {
		Population pop = new Population();
		Scanner file = FileUtils.openToRead(pop.DATA_FILE);

		Scanner s = file.useDelimiter("[\t\n]");
		while (s.hasNext()) {
			String state = s.next();
			String name = s.next();
			String type = s.next();
			int population = s.nextInt();
			s.nextLine();
			pop.cities.add(new City(name, state, type, population));
			if (pop.states.isEmpty() || !state.equals(pop.states.get(pop.states.size() - 1))) {
				pop.states.add(state);
			}
		}
		s.close();
		pop.printIntroduction();
		System.out.println();
		takeTurn(pop);
	}

	private static void takeTurn(Population pop) {
		System.out.println();
		pop.printMenu();
		System.out.println();
		int choice = Prompt.getInt("Enter selection -> ");
		System.out.println();
		SortMethods sortMethods = new SortMethods();
		long startMillisec = System.currentTimeMillis();

		switch (choice) {
			case 1:
				System.out.println("Fifty least populous cities");
				System.out.println();
				sortMethods.selectionSortByPopulationAsc(pop.cities);
				print50(pop.cities);
				break;

			case 2:

				System.out.println("Fifty most populous cities");
				System.out.println();
				sortMethods.mergeSortByPopulationDesc(pop.cities);
				print50(pop.cities);
				break;

			case 3:
			System.out.println("Fifty cities sorted by name");
			System.out.println();
				sortMethods.insertionSortByNameAsc(pop.cities);
				print50(pop.cities);
				break;

			case 4:
			System.out.println("Fifty cities sorted by name descending");
				System.out.println();
				sortMethods.mergeSortByNameDesc(pop.cities);
				print50(pop.cities);
				break;

			case 5:
			System.out.println("Fifty cities sorted by name descending");
				System.out.println();
				pop.mostPopulousOfState(pop.states, pop.cities);
				takeTurn(pop);
				break;

			case 6:
				pop.mostPopulousCity(pop.cities);
				takeTurn(pop);
				break;

			case 9:
				System.out.println("Thanks for using Population!");
				System.exit(1);
				break;

			default:
				System.out.println("That is not a valid choice!");
				takeTurn(pop);
				break;
		}
		long endMillisec = System.currentTimeMillis();
		System.out.println();
		System.out.println("Elapsed Time " + (endMillisec - startMillisec) + " milliseconds");
		System.out.println();
		takeTurn(pop);
	}

	public void mostPopulousCity(List<City> cities) {
		List<City> c = new ArrayList<City>();
		SortMethods sortMethods = new SortMethods();

		String cityName = Prompt.getString("Enter city name -> ");
		System.out.println();

		for (City city : cities) {
			if (city.getName().equals(cityName)) {
				c.add(city);
			}
		}

		sortMethods.insertionSortByPopulationDesc(c);

		int i = 1;
		System.out.println("City " + cityName + " by population");
		System.out.println();
		if (c.size() != 0) {
			System.out.printf("%-25s %-22s %-12s %12s", "State", "Name", "Type",
					"Population");
			System.out.println();
		}
		for (City city : c) {
			System.out.println(i + ": " + city);
			i++;
		}
		System.out.println();
	}

	public void mostPopulousOfState(List<String> states, List<City> cities) {
		// Fifty most populous cities in named state
		SortMethods sortMethods = new SortMethods();
		List<City> c = new ArrayList<City>();

		String state = Prompt.getString("Enter state name (ie. Alabama) -> ");
		System.out.println();
		while (!states.contains(state)) {
			System.out.println("ERROR: " + state + " is not valid");
			state = Prompt.getString("Enter state name (ie. Alabama) -> ");

		}
		for (City city : cities) {
			if (city.getState().equals(state)) {
				c.add(city);
			}
		}
		sortMethods.insertionSortByPopulationDesc(c);
		System.out.println("Fifty most populous cities in " + state);
		System.out.println();
		print50(c);

	}

	public static void print50(List<City> cities) {

		System.out.printf("%-25s %-22s %-12s %12s", "State", "Name", "Type",
				"Population");
		System.out.println();
		for (int i = 0; i < 50; i++) {
			System.out.println((i + 1) + ": " + cities.get(i));
		}
	}

	/** Prints the introduction to Population */
	public void printIntroduction() {
		System.out.println("   ___                  _       _   _");
		System.out.println("  / _ \\___  _ __  _   _| | __ _| |_(_) ___  _ __ ");
		System.out.println(" / /_)/ _ \\| '_ \\| | | | |/ _` | __| |/ _ \\| '_ \\ ");
		System.out.println("/ ___/ (_) | |_) | |_| | | (_| | |_| | (_) | | | |");
		System.out.println("\\/    \\___/| .__/ \\__,_|_|\\__,_|\\__|_|\\___/|_| |_|");
		System.out.println("           |_|");
		System.out.println();

		System.out.println("31765 cities in database");
	}

	/** Print out the choices for population sorting */
	public void printMenu() {
		System.out.println("1. Fifty least populous cities in USA (Selection Sort)");
		System.out.println("2. Fifty most populous cities in USA (Merge Sort)");
		System.out.println("3. First fifty cities sorted by name (Insertion Sort)");
		System.out.println("4. Last fifty cities sorted by name descending (Merge Sort)");
		System.out.println("5. Fifty most populous cities in named state");
		System.out.println("6. All cities matching a name sorted by population");
		System.out.println("9. Quit");
	}

}