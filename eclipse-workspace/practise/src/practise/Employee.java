package practise;

public class Employee {

	String emp_name;
	int emp_id;
	double emp_sal;
	Employee(String a,int b,double c){
		emp_name = a;
		emp_id = b;
		emp_sal = c;
	}
	
	public static void main(String[] args) {
	
		Employee e1 = new Employee("Yash",1998,200000);
		System.out.println(e1.emp_name);
		System.out.println(e1.emp_id);
		System.out.println(e1.emp_sal);

	}

}
