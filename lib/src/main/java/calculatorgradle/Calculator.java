package calculatorgradle;

public class Calculator {

	public int add(int a,int b)
	{
		return a+b;
	}
	public int multiply(int a,int b)
	{
		return a*b;
	}
	public boolean checkEven(int num)
	{
		return num%2==0;
	}
	public int CheckLength(String str)
	{
		return str.length();
	}
	public boolean checkVal(int val)
	{
		return val>0;
	}
}


