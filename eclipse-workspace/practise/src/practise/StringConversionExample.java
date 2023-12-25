package practise;

public class StringConversionExample {

	public static void main(String[] args) {
		 
		
		     String str = "Hi, this is an example for string";

	        // Convert String to StringBuffer
	        StringBuffer stringBuffer = new StringBuffer(str);
	        System.out.println("String to StringBuffer:");
	        System.out.println("String: " + str);
	        System.out.println("StringBuffer: " + stringBuffer);

	        // Convert String to StringBuilder
	        StringBuilder stringBuilder = new StringBuilder(str);
	        System.out.println("\nString to StringBuilder:");
	        System.out.println("String: " + str);
	        System.out.println("StringBuilder: " + stringBuilder);

	}

}
