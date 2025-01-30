import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the GPA Calculator!");
        System.out.print("Enter the number of courses: ");
        int numCourses = scanner.nextInt();

        double totalGradePoints = 0;
        int totalCreditHours = 0;

        for (int i = 1; i <= numCourses; i++) {
            System.out.print("Enter grade for course " + i + " (A, B, C, D, F): ");
            char grade = scanner.next().toUpperCase().charAt(0);

            System.out.print("Enter credit hours for course " + i + ": ");
            int creditHours = scanner.nextInt();

            double gradePoint = getGradePoint(grade);
            if (gradePoint == -1) {
                System.out.println("Invalid grade entered. Try again.");
                i--; // Repeat this iteration
                continue;
            }

            totalGradePoints += gradePoint * creditHours;
            totalCreditHours += creditHours;
        }

        double gpa = totalGradePoints / totalCreditHours;
        System.out.printf("Your GPA is: %.2f\n", gpa);
    }

    private static double getGradePoint(char grade) {
        switch (grade) {
            case 'A':
                return 4.0;
            case 'B':
                return 3.0;
            case 'C':
                return 2.0;
            case 'D':
                return 1.0;
            case 'F':
                return 0.0;
            default:
                return -1; // Invalid grade
        }
    }
}
