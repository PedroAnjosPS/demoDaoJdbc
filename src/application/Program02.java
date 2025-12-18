package application;

import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program02 {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("======= TEST 1: Department insert =======");
		Department dep = new Department(null, "Leisure");
		depDao.insert(dep);
		System.out.println("Inserted! New Id = " + dep.getId());
		
		System.out.println("\n======= TEST 2: Department update =======");		
		
		System.out.print("Update the deparment name: ");
		String depName = sc.nextLine();
		dep.setName(depName);
		
		depDao.update(dep);				
		System.out.println("Updated successfully!");
		
		sc.close();
	}

}
