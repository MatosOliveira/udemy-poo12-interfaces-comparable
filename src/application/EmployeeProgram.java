/**
 * 
 */
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

/**
 * @author Matos
 *
 */
public class EmployeeProgram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		String path = "C:\\Temp\\employee.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String employee = br.readLine();
			
			while(employee != null) {
				String[] listEmployee = employee.split(";");
				list.add(new Employee(listEmployee[0], Double.parseDouble(listEmployee[1])));
				employee = br.readLine();
			}
			
			Collections.sort(list);
			for(Employee emp: list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		} catch (IOException e) {
			System.out.println("Erro: " +  e.getMessage());
		}

	}

}
