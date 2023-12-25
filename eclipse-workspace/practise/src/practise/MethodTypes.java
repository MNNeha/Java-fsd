package practise;

class addition{
	
    //call by method 

	static void add()
	{
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);
	}
}

//call by method 
class Multi{
	static void mul(int x,int y) {
		int z = x*y;
		System.out.println(z);
	}
}

//call by reference
class Divide{
	static int div() {
		int s = 10;
		int d = 5;
		int g = s/d;
		return g;
	}
}



public class MethodTypes {

	public static void main(String[] args) {
	   
		//call by method 
		addition.add();
	  
      //call by method with parameter 
	   Multi.mul(3, 100);
	   
	   //call by reference
	   int h = Divide.div();
      System.out.println(h);
	}

}
