package twilio;

public class FizzBuzzNumber {

	private static final int FIZZ_MULTIPLE = 3;
	private static final int BUZZ_MULTIPLE = 5;
	private static final String FIZZ = "fizz";
	private static final String BUZZ = "buzz";
	
	private String value;
	
	public FizzBuzzNumber(int value) {
		this.value = convertToFizzBuzzNumber(value);
	}

	/**
	 * Gives a String representation of the FizzBuzzNumber
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Checks if input number is a multiple of fizz and/or buzz and
	 * returns the FizzBuzzNumber associated with this int in the form of a String.
	 * @param n number to be changed to FizzBuzzNumber
	 * @return String representing FizzBuzzNumber
	 */
	public static String convertToFizzBuzzNumber(int n) {
		String result = "";
		if (n % FIZZ_MULTIPLE == 0) {
			result += FIZZ;
		} 
		if (n % BUZZ_MULTIPLE == 0) {
			result += BUZZ;
		} 
		if (result.equals("")) {
			result += n;
		}
		return result;
	}
	
}
