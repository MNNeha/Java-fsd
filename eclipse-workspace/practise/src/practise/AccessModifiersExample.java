package practise;

public class AccessModifiersExample {

	    public int publicVariable = 10;
	    private int privateVariable = 20;
	    protected int protectedVariable = 30;
	    int defaultVariable = 40;

	    public void publicMethod() {
	        System.out.println("This is a public method.");
	    }

	    private void privateMethod() {
	        System.out.println("This is a private method.");
	    }

	    protected void protectedMethod() {
	        System.out.println("This is a protected method.");
	    }

	    void defaultMethod() {
	        System.out.println("This is a default method.");
	    }

}
