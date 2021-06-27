package thaotai.dev;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MainApp {
	static List<Person> readFromFile(String fileName) throws Exception{
		List<Person> personList = new ArrayList<Person>();
		FileInputStream fstream = new FileInputStream(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		
		String strLine;
		
		while ((strLine = br.readLine()) != null)   {
			if (strLine.indexOf("#S") == 0) {
				String idStudent = strLine.substring(1,strLine.length());
				String firstName = br.readLine();
				String lastName = br.readLine();
				byte age = Byte.parseByte(br.readLine());
				double math = Double.parseDouble(br.readLine());
				double english = Double.parseDouble(br.readLine());
				double literature = Double.parseDouble(br.readLine());
				double combination = Double.parseDouble(br.readLine());
				Person std = new Student(firstName, lastName, age, idStudent, math, english, literature, combination);
				personList.add(std);
			}
			if (strLine.indexOf("#T") == 0) {
				String idTeacher = strLine.substring(1,strLine.length());
				String firstName = br.readLine();
				String lastName = br.readLine();
				byte age = Byte.parseByte(br.readLine());
				double heSoLuong  = Double.parseDouble(br.readLine());
				Person teacher = new Teacher(firstName, lastName, age, idTeacher, heSoLuong);
				personList.add(teacher);
			}
		}
		return personList;
	}
	static void print(List<Person> personList) {
		Iterator<Person> it = personList.iterator();
		
		System.out.println("List Student");
		while (it.hasNext()) {
			Person person = it.next();
			if ((person instanceof Student) == true) {
				System.out.println(person.toString());
			}
		}
		
		System.out.println("List Teacher");
		Iterator<Person> it2 = personList.iterator();
		while (it2.hasNext()) {
			Person person = it2.next();
			if ((person instanceof Teacher) == true) {
				System.out.println(person.toString());
			}
		}
	}
	static void printSV(List<Student> personList) {
		Iterator<Student> it = personList.iterator();
		
		System.out.println("List Student");
		while (it.hasNext()) {
			Person person = it.next();
			if ((person instanceof Student) == true) {
				System.out.println(person.toString());
			}
		}
	}
		
	static void printGV(List<Teacher> personList) {
		Iterator<Teacher> it = personList.iterator();
		
		System.out.println("List Teacher");
		while (it.hasNext()) {
			Person person = it.next();
			if ((person instanceof Teacher) == true) {
				System.out.println(person.toString());
			}
		}
	}	
	static void sortName(List<Person> personList) {
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person person1, Person person2) {
				// TODO Auto-generated method stub
				if (person1.lastName.hashCode() < person2.lastName.hashCode()) {
					return -1;
				}else {
					return 1;
				}
			}
		});
		print(personList);
	}
	static void sortDTB(List<Person> personList) {
		Iterator<Person> it = personList.iterator();
		List<Student> stdList = new ArrayList<Student>();
		while (it.hasNext()) {
			Person person = it.next();
			if ((person instanceof Student) == true) {
				Student std = (Student) person;
				stdList.add(std);
			}
		}
		Collections.sort(stdList, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				// TODO Auto-generated method stub
				if (s1.mark() < s2.mark()) {
					return 1;
				}else if (s1.mark() == s2.mark()) {
					return 0;
				}else return -1;
			}
		});
		
		System.out.println("Sort Diem Trung Binh");
		printSV(stdList);
	}
	static void sortLuong(List<Person> personList) {
		List<Teacher> teacherList = new ArrayList<Teacher>();
		Iterator<Person> it = personList.iterator();
		while (it.hasNext()) {
			Person person = it.next();
			if ((person instanceof Teacher) == true) {
				Teacher std = (Teacher) person;
				teacherList.add(std);
			}
		}
		Collections.sort(teacherList, new Comparator<Teacher>() {
			@Override
			public int compare(Teacher t1, Teacher t2) {
				// TODO Auto-generated method stub
				if (t1.tinhLuong() < t2.tinhLuong()) {
					return 1;
				}else if (t1.tinhLuong() == t2.tinhLuong()) {
					return 0;
				}else return -1;
			}
		});
		System.out.println("Sort Luong Giam Dan");
		printGV(teacherList);
	}
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> personList = new ArrayList<Person>();
		try {
			personList = readFromFile("input.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
//		print(personList);
//		sortName(personList); // SortSV A- Z, SortGV Z-A
//		sortDTB(personList);
//		print(personList);
		sortLuong(personList);
	}

}
