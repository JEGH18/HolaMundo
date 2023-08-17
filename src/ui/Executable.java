package ui;

import java.util.Calendar;
import java.util.Scanner;
import model.Controller;

public class Executable {
    
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        System.out.println("Bienvenido al menu de proyectos!");

        while (!exit) {

            System.out.println("_________________________________________________________________");
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Registrar un proyecto");
            System.out.println("2. Consultar proyectos finalizados antes de una fecha");
            System.out.println("3. Consultar proyectos que iniciarán después de una fecha");
            System.out.println("4. Salir");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            
            int option = scanner.nextInt();
            scanner.nextLine();
            
            switch (option) {
                case 1:

                    controller.createProject();

                    break;
                case 2:

                    controller.consultProjectsFinishBeforeDate();

                    break;
                case 3:

                    controller.consultProjectsStartAfterDate();

                    break;
                case 4:

                    System.out.println("¡Hasta luego!");
                    exit = true;

                    break;
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        }
        
        scanner.close();
    }
    
    private static Calendar parseDate(String dateStr) {

        String[] parts = dateStr.split("/");

        int day = Integer.parseInt(parts[0]);

        int month = Integer.parseInt(parts[1]) - 1;

        int year = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();

        calendar.setLenient(false);

        calendar.set(Calendar.YEAR, year);

        calendar.set(Calendar.MONTH, month);

        calendar.set(Calendar.DAY_OF_MONTH, day);

        return calendar;
    }
}
