package a4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * A die whose faces are labeled with strings and whose value is determined by rolling to a random face.
 * 
 * <p>
 * A die has a fixed number of faces, where each face is associated with a string label provided by the user.
 * At any time, the die has a current value corresponding to one of its face labels.
 * 
 * <p>
 * Class invariant:
 * <ul>
 *   <li>The number of faces is greater than zero.</li>
 *   <li>The current index is always a valid index of the face list.</li>
 *   <li>No face label is {@code null}.</li>
 * </ul>
 */
public class Die implements Comparable<Die>{
	/**
	 * The list of face labels for this die.
	 */
	private ArrayList<String> faces;
	/**
	 * The index of the current face value.
	 */
	private int CurrentIndex;
	/**
	 * The random number generator used to roll this die.
	 */
	private Random rng;
	
	/**
	 * Constructs a die with the specified face labels.
	 * 
	 * <p>
	 * The initial value of the die is the first label in the list.
	 * 
	 * @param labels the face labels of the die; must not be {@code null}and must contain at least one non-null label
	 * @throws NullPointerException if {@code labels} is {@code null}
	 * @throws IllegalArgumentException if {@code labels} is empty or contains a {@code null} element
	 */
	public Die(List<String> labels) {
		if (labels == null) {
			throw new NullPointerException("labels cannot be null");
		}
		if (labels.isEmpty()) {
			throw new IllegalArgumentException("a die must have at least one face");
		}
		
		this.faces = new ArrayList<String>();
		for (String s : labels) {
			if (s == null) {
				throw new IllegalArgumentException("face labels cannot be null");
			}
			this.faces.add(s);
		}
		
		this.CurrentIndex = 0;
		this.rng = new Random();
	}
	
	/**
	 * Constructs a die with the specified face labels.
	 * 
	 * <p>
	 * The initial value of the die is the first label in the list
	 * 
	 * @param labels the face labels of the die; must not be {@code null} and must contain at least one non-null label
	 */
	public Die(String... labels) {
		this(Arrays.asList(labels));
	}
	
	/**
	 * Constructs a new die by copying another die.
	 * 
	 * <p>
	 * The new die has the same face labels and current value as the specified die, but is independent and generates its own sequence of random values.
	 * 
	 * @param other the die to copy
	 * @throws NullPointerException if {@code other} is {@code null}
	 */
	public Die(Die other) {
		if (other == null) {
			throw new NullPointerException("other caannot be null");
		}
		this.faces = new ArrayList<String>(other.faces);
		this.CurrentIndex = other.CurrentIndex;
		this.rng = new Random();
	}
	
	/**
	 * Returns a standard six-sided die with face labels {@code "1"} through {@code "6"}.
	 * 
	 * @return a new six-sided die
	 */
	public static Die StandardDie() {
		return new Die("1", "2", "3", "4", "5", "6");
	}
	
	/**
	 * Return the number of faces on this die.
	 * 
	 * @return the number of faces
	 */
	public int size() {
		return this.faces.size();
	}
	
	/**
	 * Return the current value of this die.
	 * 
	 * @return the current face label of this die
	 */
	public String GetValue() {
		return this.faces.get(this.CurrentIndex);
	}
	
	/**
	 * Rolls this die to a random face.
	 * 
	 * <p>
	 * Each face is equally likely to be selected. 
	 */
	public void Roll() {
		this.CurrentIndex = this.rng.nextInt(this.faces.size());
	}
	
	/**
	 * Compares this die to another die based on their current values.
	 * 
	 * <p>
	 * The comparison is performed using dictionary (lexicographic) order on the string labels.
	 * 
	 * @param other the die to compare with
	 * @return a negative integer, zero, or a positive integer if this die is less than, equal to, or greater than the specified die
	 * @throws NullPointerException if {@code other} is {@code null}
	 */
	@Override
	public int compareTo(Die other) {
		if (other == null) {
			throw new NullPointerException("other cannot be null");
		}
		return this.GetValue().compareTo(other.GetValue());
	}
	
	/**
	 * Tests whether this die is equal to another object.
	 * 
	 * <p>
	 * Two dice are consider equal if their current values are equal.
	 * 
	 * @param obj the object to compare with
	 * @return {@code true} if the current values are equal, {@code false} otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(!(obj instanceof Die)) {
			return false;
		}
		Die other = (Die) obj;
		return this.GetValue().equals(other.GetValue());
	}
	
	/**
	 * Return a hash code for this die based on its current value
	 * 
	 * @return a hash code for this die
	 */
	@Override
	public int hashCode() {
		return this.GetValue().hashCode();
	}
	
	/**
	 * Return a string representation of this die.
	 * 
	 * <p>
	 * The string contains the current value and the list of face labels.
	 * 
	 * @return a string representation of this die
	 */
	@Override
	public String toString() {
		return this.GetValue() + ": " + this.faces.toString();
	}
	
	/**
	 * Demonstrates the functionality of the {@code Die} class.
	 * 
	 * <p>
	 * This method creates dice, rolls them, compares them, and prints their values to standard output.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Die d1 = new Die("A", "B", "C", "A", "B", "C");
		Die d2 = new Die("01", "02", "03", "04", "05", "06", "A", "B", "C", "D", "E", "F");
		Die d3 = Die.StandardDie();
		Die d4 = new Die(d1);
				
		System.out.println("Creating a 6 sided die d1 with faces A, B, C, A, B, C");
		System.out.println(d1);
		System.out.println("\nCreating a 12 sided die d2 with faces 01, 02, 03, ..., 06, A, B, C, D, E, F ");
		System.out.println(d2);
		System.out.println("\nd1 current value: " + d1.GetValue());
		System.out.println("d2 current value: " + d2.GetValue());
		System.out.println("\nStandard Die:");
		System.out.println(d3);
		System.out.println("\nCopy Die:");
		System.out.println(d4);
		
		System.out.println("\nRolling the dice 5 times:");
		for (int i = 0;i < 5; i++) {
			System.out.println("\nRolling...");
			d1.Roll();
			d2.Roll();
			
			System.out.println("d1: " + d1.GetValue());
			System.out.println("d2: " + d2.GetValue());
			
			int cmp = d1.compareTo(d2);
			if (cmp < 0) {
				System.out.println("d1 less than d2");
			} else if (cmp > 0) {
				System.out.println("d1 greater than d2");
			} else {
				System.out.println("d1 equals d2");
			}
		}
	}
}

