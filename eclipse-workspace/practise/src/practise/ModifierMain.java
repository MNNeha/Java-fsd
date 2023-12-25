package practise;

public class ModifierMain {

	public static void main(String[] args) {
	
		 AccessModifiersExample example = new AccessModifiersExample();

	        // Accessing variables and methods using different access modifiers
	        System.out.println("Public variable value: " + example.publicVariable);
	        example.publicMethod();

	        // Private members cannot be accessed directly outside the class
	        //System.out.println("Private variable value: " + example.privateVariable); // Results in a compilation error
	        // example.privateMethod(); // Results in a compilation error

	        System.out.println("Protected variable value: " + example.protectedVariable);
	        example.protectedMethod();

	        System.out.println("Default variable value: " + example.defaultVariable);
	        example.defaultMethod();
	}

}
