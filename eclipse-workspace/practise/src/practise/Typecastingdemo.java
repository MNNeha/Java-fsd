package practise;

public class Typecastingdemo {

	public static void main(String[] args) {
		//implicit type casting
		
		int m=6;
		float n;
		
		n=m;
		
		//explicit type casting
		long a = 1291019203912910L;
		int b;
		
		double d = 123.45;
		int e;
		

		b= (int) a;
		e = (int) d;
		 
		System.out.printf("long a = %s, \n", a);
		System.out.printf("long a = %s, \n", b);
		 // Explicit casting from double to integer
        System.out.println("\nExplicit Casting (Narrowing):");
        System.out.println("Double (double): " + d);
        System.out.println("Integer (int): " + e);
	}

}
