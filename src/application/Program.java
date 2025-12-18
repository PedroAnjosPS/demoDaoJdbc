package application;

import java.util.Date; 
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("======= TEST 1: Seller findById =======");
		Seller seller = sellerDao.findById(8);
		
		System.out.println(seller);
		
		System.out.println("\n======= TEST 2: Seller findByDepartment =======");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		
		for (Seller obj : list) {
			System.out.println(obj + "\n");
		}
		
		System.out.println("\n======= TEST 3: Seller findAll =======");
		list = sellerDao.findAll();
		
		for (Seller obj : list) {
			System.out.println(obj + "\n");
		}
		
		System.out.println("\n======= TEST 4: Seller insert =======");
		Seller newSeller = new Seller(null, "Manuel", "manuel@gmail.com", new Date(), 3000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n======= TEST 5: Seller update =======");
		seller = sellerDao.findById(9);
		
		System.out.println("Update the seller's name and baseSalary");
		
		System.out.print("Name: ");
		String name = sc.nextLine();
		seller.setName(name);
		
		System.out.print("BaseSalary: ");
		double baseSalary = sc.nextDouble();
		seller.setBaseSalary(baseSalary);
		
		sellerDao.update(seller);
		System.out.println("Updated successfully!");
		
		System.out.println("\n======= TEST 6: Seller delete =======");
		
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		
		System.out.println("Deleted successfully!");
		
		sc.close();
	}

}
