package mainBranch;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Input expression = new Input(input.nextLine());
		System.out.println(expression.checkErrors());
		if (expression.checkErrors() == "") {
			expression.Solve();
			Scanner input2 = new Scanner(System.in);
		}
	}

}
