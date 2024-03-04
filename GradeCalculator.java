import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int subjects = 5; 
        int[] marks = new int[subjects];

        for (int i = 0; i < subjects; i++) {
            marks[i] = getValidMark(scanner, i + 1);
        }

       
        int totalMarks = calculateTotalMarks(marks);

       
        double averagePercentage = calculateAveragePercentage(totalMarks, subjects);

        
        char grade = calculateGrade(averagePercentage);

       
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }
    
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
    
    private static int getValidMark(Scanner scanner, int subjectNumber) {
        int mark;
        while (true) {
            System.out.print("Subject " + subjectNumber + ": ");
            if (scanner.hasNextInt()) {
                mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) {
                    break; 
                } else {
                    System.out.println("Please enter a valid mark between 0 and 100.");
                }
            } else {
                System.out.println("Please enter a valid integer.");
                scanner.next(); 
            }
        }
        return mark;
    }
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
    
    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int subjects) {
        return (double) totalMarks / subjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
/*
     * Author: Farrell, J (2018)
     * Title: Java Programming, Ninth Edition
     * Publisher: Cengage
     * Year: 2018
     */
