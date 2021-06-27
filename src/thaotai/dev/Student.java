package thaotai.dev;
/**
 * Lop quan ly sinh vien
 * @author Thao Tai
 *
 */

public class Student extends Person {
	String idStudent;
	double math;
	double english;
	double literature;
	double combination;
	
	
	
	public Student(String firstName, String lastName, byte age, String idStudent, double math, double english,
			double literature, double combination) {
		super(firstName, lastName, age);
		this.idStudent = idStudent;
		this.math = math;
		this.english = english;
		this.literature = literature;
		this.combination = combination;
	}

	double mark() {
		return (math + english + literature + combination)/4;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("IDSV: %s; HoTen: %s %s; Tuoi:%d; Diem(Toan Van English DiemToHop): %f %f %f %f, DTB: %f",idStudent,firstName,lastName,age,math,literature,english,combination,mark());
	}
}
