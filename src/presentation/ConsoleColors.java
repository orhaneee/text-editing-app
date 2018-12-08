package presentation;

/**
 * 
 * This enumeration is for coloring the color output.
 * It has a defined value and with appending
 * it to the beginning of an console string
 * it converts it to a colorful show!
 */
public enum ConsoleColors {
	ANSI_RESET("\u001B[0m"),
	ANSI_BLUE("\u001B[34m"),
	ANSI_RED("\u001B[31m"),
	ANSI_GREEN("\u001B[32m");
	
	private String value;
	
	private ConsoleColors(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
