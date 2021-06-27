package thaotai.dev;
/**
 * Lop quan ly teacher
 * @author Thao Tai
 *
 */

public class Teacher extends Person implements ILuongcoban {
	String idTeacher;
	double heSoLuong;
	
	
	
	public Teacher(String firstName, String lastName, byte age, String idTeacher, double heSoLuong) {
		super(firstName, lastName, age);
		this.idTeacher = idTeacher;
		this.heSoLuong = heSoLuong;
	}

	@Override
	public double luongCoBan() {
		// TODO Auto-generated method stub
		return 1200000;
	}
	
	double tinhLuong() {
		return luongCoBan() * heSoLuong;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("IDGV: %s; HoTen: %s %s; Tuoi: %d, heSoLuong: %f, Luong: %f", idTeacher,firstName,lastName,age,heSoLuong,tinhLuong());
	}
	
	
}
