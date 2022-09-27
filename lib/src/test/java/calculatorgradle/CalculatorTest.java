package calculatorgradle;

import org.junit.jupiter.api.Assertions;

import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class CalculatorTest {

	Calculator obj;
	@BeforeEach
	void initialize()
	{
		obj=new Calculator();
			System.out.println("Calculator Initialized");
	}
	@AfterEach
	void cleanup()
	{
		obj=null;
		System.out.println("clean up done");
	}
	@BeforeAll
	static void startup()
	{
		System.out.println("Starting Test Process");
	}
	
	@AfterAll
	static void cleanall()
	{
		System.out.println("All Resources Cleaned");
	}
	@Test
	void testAdd() {
		Calculator obj=new Calculator();
		int expected=12;
		int actual=obj.add(8, 4);
		Assertions.assertEquals(expected, actual);
		
	}

	@Test
	void testMultiply() {
		Calculator obj=new Calculator();
		int expected=40;
		int actual=obj.multiply(5, 8);
		
		Assertions.assertEquals(expected, actual);
		
	}
	
	@Test
	void testCheckEven()
	{
		Calculator obj=new Calculator();
		boolean res=obj.checkEven(12);
		Assertions.assertTrue(res);
	}
	
	@ParameterizedTest
	@ValueSource(ints= {12,14,11,19})
	void testCheckEven(int x)
	{
		boolean res=obj.checkEven(x);
		Assertions.assertTrue(res);
	}
	@ParameterizedTest
    @MethodSource("numberprovider")
    void testAdd(int a,int b) {
        int expected=a+b;
        int actual=obj.add(a,b);
        Assertions.assertEquals(expected, actual);
    
    }



   static Stream<Arguments> numberprovider()
    {
    return Stream.of(Arguments.arguments(12,23),
            Arguments.arguments(11,19));    
    }
   
   @ParameterizedTest
   @CsvSource({"12,23","11,19","10,20"})
   void testAdd2(int a,int b) {
       int expected=a+b;
       int actual=obj.add(a,b);
       Assertions.assertEquals(expected, actual);
   
   }
   
   @ParameterizedTest
   @ValueSource(strings= {"Apple","Banana"})
   void testCheckLength(String str)
   {
	   int expected=str.length();
	   Assertions.assertEquals(expected,obj.CheckLength(str) );
   }
   
   
   @ParameterizedTest
   @MethodSource("numberprovider2")
   void testAdd3(int a,int b) 
   {
	   int expected=a+b;
	   int actual=obj.add(a,b);
	   Assertions.assertEquals(expected,actual);
	   }
   static Stream<Arguments> numberprovider2()
   {
	   return Stream.of(Arguments.arguments(12,23),Arguments.arguments(11,19));
   }
	   
 
   
   
   }
