package application.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class VerificationCodeTool {
	

	public static Map<String,Integer> generateArithmeticVerification() {
		Random random = new Random();			
		int a = random.nextInt(10)+1;		
		int b = random.nextInt(10)+1;
		int c = random.nextInt(10)+1;
		
		//'+', '-', '*', '/'
		char[] OperatorArray  = new char[] {'+', '-', '*', '/'};
		int opIndex1 = random.nextInt(4);
		int opIindx2 = random.nextInt(4);
		char op1 = OperatorArray[opIndex1];
		char op2 = OperatorArray[opIindx2];
		
		int result = 0; 		
		if(comparisonOpPriority(op1, op2)) {
			result = calculate(a, b, op1);
			result = calculate(result, c, op2);
		}else {
			result = calculate(b, c, op2);
			result = calculate(a, result, op1);
		}
		
		String opExp = ""+a + op1+ b + op2 + c ;
		Map<String,Integer> resExp = new HashMap<>();
		resExp.put(opExp, result);
		return resExp;			
	}
	
	
	public static int calculate(int a, int b, char op) {
		int calResult = 0;
		switch(op)
		{
		case '+':
			calResult = a+b;
			break;
		case '-':
			calResult = a-b;
			break;
		case '*':
			calResult = a*b;
			break;
		case '/':
			calResult = a/b;
			break;
		}
		return calResult;
	}
	
	
	public static boolean comparisonOpPriority(char op1, char op2)
	{
		boolean op1HasHighPriority = true;
		switch(op1)						
		{
		case '-':	
		case '+':
			if(op2=='*' || op2=='/')
				op1HasHighPriority = false;
			break;
		}
		return op1HasHighPriority;
	}
}
