import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> weekDays = new ArrayList<>();
        ArrayList<Double> dailyTemperatures = new ArrayList<>();

        System.out.println("Enter the average temperature for each day of the week in Fahrenheit:");
        for (String day : new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
            weekDays.add(day);
            System.out.print(day + "'s Temperature: ");
            while (!scnr.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a numeric value.");
                System.out.print(day + "'s Temperature: ");
                scnr.next();
            }
            double temperature = scnr.nextDouble();
            dailyTemperatures.add(temperature);
        }

        scnr.nextLine();

        while (true) {
            System.out.println("\nEnter a weekday to see its temperature, 'week' to view all temperatures and the weekly average, or 'exit' to close the program:");
            String input = scnr.nextLine().trim();
            
            if (weekDays.contains(input)) {
                int index = weekDays.indexOf(input);
                System.out.println(input + "'s average temperature: " + dailyTemperatures.get(index) + "F");
            } else if (input.equals("week")) {
                double total = 0;
                System.out.println("\nWeekly Temperature Data:");
                for (int i = 0; i < weekDays.size(); i++) {
                    System.out.println(weekDays.get(i) + ": " + dailyTemperatures.get(i) + "F");
                    total += dailyTemperatures.get(i);
                }
                System.out.printf("Average temperature: %.1fF\n", total / weekDays.size());
            } else if (input.equals("exit")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid entry. Please enter a weekday, 'week', or 'exit'.");
            }
        }
        
        scnr.close();
    }
}
