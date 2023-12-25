package practise;


class Student{
	int regNumber;
	String studentName;
	
	Student(int reg_no, String Name){
		this.regNumber = reg_no;
		this.studentName = Name;
	}
}

public class StudentData {

	public static void main(String[] args) {
	   //declare an array of integers
		Student[] arr;
		
        arr = new Student[5];
        
        arr[0] = new Student(1001, "raj");
        arr[1] = new Student(1002, "anirudh");
        arr[2] = new Student(1003, "hema");
        arr[3] = new Student(1004, "tina");
        arr[4] = new Student(1005, "umesh");
        for(int i =0; i<arr.length; i++)
        {
        	System.out.println(arr[i]);
        }
        for(int i =0; i<arr.length; i++) {
        	System.out.println("Student with registration number" + arr[i].regNumber +" is: "+ arr[i].studentName);
        }
	}

}
