package mainBranch;

import java.util.ArrayList;
import java.util.Arrays;

public class Variable {
	private String value;
	
	//checks if the variable consists of Arabic numbers
	public boolean isNumeric() {
		boolean flag = true;
		for (int i = 0; i < this.value.length(); i++)
		{
			if (!Character.isDigit(this.value.charAt(i))) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	//checks if the variable consists of Roman numbers
	public boolean isRoman() {
		ArrayList<String> possibleValues =
			    new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII","VIII","IX","X"));
		if (possibleValues.contains(this.value)) return true;
		else
		return false;
	}
	
	
	//String constructor
	public Variable(String value) {
		super();
		this.value = value.trim();
	}
	
	
	
	//value getter: if the variable is Roman, converts to Arabic prior returning
	public int getValue() {
		if (this.isNumeric())
		return Integer.parseInt(value);
		if (this.isRoman())
		return RomanNumeral.romanToArabic(value);
		return 0;
	}
	
	
	//setter; trims spaces before sending the value
	public void setValue(String value) {
		this.value = value.trim();
	}
	
	//overriding the method so to print the variable in an understandable fashion
	@Override
	public String toString() {
		return this.value;
	}
	
	
}
