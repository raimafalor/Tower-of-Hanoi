/**
 * City data - the city name, state name, location designation,
 * and population est. 2017
 *
 * @author
 * @since
 */
public class City implements Comparable<City> {

	// fields
	private String name;
	private String state;
	private String type;
	private int population;

	// constructor
	public City(String name, String state, String type, int population) {
		this.name = name;
		this.state = state;
		this.type = type;
		this.population = population;
	}

	/**
	 * Compare two cities populations
	 * 
	 * @param other the other City to compare
	 * @return the following value:
	 *         If populations are different, then returns (this.population -
	 *         other.population)
	 *         else if states are different, then returns (this.state - other.state)
	 *         else returns (this.name - other.name)
	 */

	public int compareTo(City other) {
		if (this.population != other.population) {
			return this.population - other.population;
		} else if (!this.state.equals(other.state)) {
			return this.state.compareTo(other.state);
		} else {
			return this.name.compareTo(other.name);
		}
	}

	/**
	 * Equal city name and state name
	 * 
	 * @param other the other City to compare
	 * @return true if city name and state name equal; false otherwise
	 */

	public boolean equals(City other) {
		if (this.state.equals(other.state) && this.name.equals(other.name)) {
			return true;
		}
		return false;
	 }

	/** Accessor methods */
	public String getName() {
		return this.name;
	}

	public int getPopulation() {
		return this.population;
	}

	public String getState() {
		return this.state;
	}

	public String getType() {
		return this.type;
	}

	/** toString */
	@Override
	public String toString() {
		return String.format("%-22s %-22s %-12s %,12d", state, name, type,
				population);
	}
}