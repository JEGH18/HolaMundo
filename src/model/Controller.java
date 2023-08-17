	package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<Project> projects;

    public Controller() {
        this.projects = new ArrayList<Project>();
    }

	public void createProject() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nombre del proyecto: ");

		String name = scanner.nextLine();
		System.out.println("Ingrese el nombre del cliente: ");

		String clientName = scanner.nextLine();
		System.out.println("Ingrese el tipo de proyecto (1. Desarrollo, 2. Mantenimiento, 3. Despliegue):");

		int projectType = scanner.nextInt();
		scanner.nextLine();

		String type;

		switch (projectType) {
			case 1:
				type = "Desarrollo";
				break;
			case 2:
				type = "Mantenimiento";
				break;
			case 3:
				type = "Despliegue";
				break;
			default:
				System.out.println("Opción inválida. El proyecto se registrará como 'Desarrollo'.");
				type = "Desarrollo";
		}
		System.out.println("Ingrese la fecha planeada para el inicio del proyecto (dd/mm/aaaa): ");
		String startDate = scanner.nextLine();

		System.out.println("Ingrese la fecha planeada para la finalización del proyecto (dd/mm/aaaa): ");
		String endDate = scanner.nextLine();

		System.out.println("Ingrese el valor correspondiente al presupuesto del proyecto: ");
		double budget = scanner.nextDouble();

		scanner.nextLine();

		Project project = new Project(name, clientName, type, startDate, endDate, budget);
		projects.add(project);
		
		System.out.println("\n-> Proyecto registrado correctamente!.");
	}
	

	public void consultProjectsFinishBeforeDate() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\nIngrese la fecha límite en formato dd/mm/aaaa: \n");
	
		String dateStr = scanner.nextLine();
		String[] dateSplit = dateStr.split("/");
	
		int day = Integer.parseInt(dateSplit[0]);
		int month = Integer.parseInt(dateSplit[1]) - 1;
		int year = Integer.parseInt(dateSplit[2]);
	
		Calendar date = Calendar.getInstance();
		date.set(year, month, day, 0, 0, 0);
	
		for (Project project : projects) {
			Calendar endDate = project.getEndDate();
			if (endDate.before(date)) {
				System.out.println(project);
			}
		}
	}
	
	public void consultProjectsStartAfterDate() {
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("\nIngrese la fecha de inicio en formato (dd/mm/aaaa): \n");
		String dateStr = scanner.nextLine();
	
		Calendar date = Calendar.getInstance();
	
		String[] dateSplit = dateStr.split("/");

		int day = Integer.parseInt(dateSplit[0]);

		int month = Integer.parseInt(dateSplit[1]) - 1;

		int year = Integer.parseInt(dateSplit[2]);
	
		date = Calendar.getInstance();

		date.set(year, month, day, 0, 0, 0);
	
		for (Project project : projects) {
			Calendar startDate = project.getStartDate();
	
			if (startDate.after(date)) {
				System.out.println(project);
			}
		}
	}
	
	

		public void consultProjectsStartingAfterDate(Calendar date) {
			for (Project project : projects) {
				Calendar startDate = project.getStartDate();
				if (startDate.after(date)) {
					System.out.println(project);
				}
			}
		}
	}		
