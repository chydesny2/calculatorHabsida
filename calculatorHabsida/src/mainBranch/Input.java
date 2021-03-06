package mainBranch;

import java.util.ArrayList;
import java.util.Arrays;

public class Input {
	private String rawLine;
	private ArrayList<String> operands = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));
	private ArrayList<String> romanNums = new ArrayList<>(Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"));
	public String checkErrors() {
		String verdict = "";
		
		//split the line by operands
		ArrayList<String> splittedLine = new ArrayList<>(Arrays.asList(rawLine.split("\\+|\\-|\\*|\\/")));
		
		//more than 2 variables check
		if (splittedLine.size() > 2) 
			verdict += "More than 2 variables. ";
		//less than 2 variables check
		if (splittedLine.size() < 2)
			verdict += "Less than 2 variables. ";
		//ordinary flag
		boolean flag = true;
		//check if all elements are Arab numerals not greater than 10
		for (String i : splittedLine)
		{
			try 
			{
				int d = Integer.parseInt(i);
				if (d > 10 || d < 0) verdict += "The variables input are iut of range.";
			}
				catch (NumberFormatException nfe) {
			        flag = false;
			        break;
			    }
		}
		
		//if all elements aren't Arab numerics, check if they are Roman numerals
		if (flag == false)
		{
			for (int i = 0; i < splittedLine.size(); i++)
			{
				if (!romanNums.contains(splittedLine.get(i).trim()))
				{
					verdict += "The variables input are neither entirely Arab nor entirely Roman numerals from I to X. ";
					break;
				}
			}
		}
		
		
		return verdict;
	}
	
	//the method that returns two variables
	public ArrayList<Variable> getVariables() {		
			ArrayList<Variable> variables = new ArrayList<>();
			ArrayList<String> splittedLine = new ArrayList<>(Arrays.asList(rawLine.split("\\+|\\-|\\*|\\/")));
			for (int i = 0; i < splittedLine.size(); i++)
			{
				variables.add(new Variable(splittedLine.get(i)));
			}
		return variables;
	}
	
	
	//checks if all vars are Roman
	public boolean areRoman()
	{
		for (Variable v : this.getVariables())
			if (!v.isRoman()) return false;
		return true;
	}
	
	//checks if all vars are Arabic
	public boolean areArabic()
	{
		for (Variable v : this.getVariables())
			if (!v.isNumeric()) return false;
		return true; 
	}
	
	//just sum up
	public int doSumm() {
		int summ = 0;
		for (Variable v : this.getVariables()) {
			summ += v.getValue();
		}
		return summ;
	}
	
	//just subtract
	public int doSubtr() {
		int subtr = this.getVariables().get(0).getValue() - this.getVariables().get(1).getValue();
		return 0;
	}
	
	//just multiply
	public int doMult() {
		int mult = 1;
		for (Variable v : this.getVariables()) {
			mult *= v.getValue();
		}
		return mult;
	}	
	
	//just divide
	public double doDiv() {
		double div = (double)this.getVariables().get(0).getValue() / (double)this.getVariables().get(1).getValue();
		return div;
	}
	
	//solve the expression
	public void Solve() {
		
		//if the variables are Arabic, check the operand of the expression and execute the respective method
		if (this.areArabic()) {
			if (this.rawLine.contains("+")) System.out.println(this.doSumm());
			if (this.rawLine.contains("-")) System.out.println(this.doSubtr());
			if (this.rawLine.contains("*")) System.out.println(this.doMult());
			if (this.rawLine.contains("/")) System.out.println(this.doDiv());
		}
		//if the variables are Roman, check the operand of the expression,  
		//convert the variable to Roman and execute the respective method
		if (this.areRoman()) {
			if (this.rawLine.contains("+")) System.out.println(RomanNumeral.arabicToRoman(this.doSumm()));
			if (this.rawLine.contains("-")) System.out.println(RomanNumeral.arabicToRoman(this.doSubtr()));
			if (this.rawLine.contains("*")) System.out.println(RomanNumeral.arabicToRoman(this.doMult()));
			if (this.rawLine.contains("/")) System.out.println(this.getVariables().get(0) + " / " + this.getVariables().get(1));
		}

	}

	
	
	
	
	//constructor
	public Input(String rawLine) {
		this.rawLine = rawLine;
	}
	
	//null constructor
	public Input() {
		
	}
	
	
}
