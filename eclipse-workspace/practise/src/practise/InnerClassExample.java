package practise;

	class MLA{
		private int ccNo=567432189;
		
		private void bankTransfer(int amount, int CC ) {
			System.out.println("Transfer 5000 USD ");
		}
		
		class PersonalSecretary {
			
			public void m1() {
				// Inner class has access to privte stuff of the outer class.
				System.out.println("ccNo of my master is " +ccNo);
				
				bankTransfer(5000,ccNo);
				
			}

		}

	}

	public class InnerClassExample{
		
		public static void main(String[] args) {
			
			MLA mla1 = new MLA();
			
			
			MLA.PersonalSecretary pSec1 = mla1.new PersonalSecretary();
			
			pSec1.m1();
			
		}
	}
	

