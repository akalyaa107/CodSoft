import java.util.Scanner;

public class GradeCalculator {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
   System.out.print("Enter Roll Number: ");
   int rollNumber = scanner.nextInt();
   int numSubjects = 5; 
   int[] marks = new int[numSubjects];
   String[] subjectNames = {"Tamil", "English", "Maths", "Science", "Social"};
   int totalMarks = 0;
   for (int i = 0; i < numSubjects; i++) {
   System.out.print("Enter marks obtained in " + subjectNames[i] + " (out of 100): ");
   marks[i] = scanner.nextInt();
   totalMarks += marks[i];
}
   double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: " + averagePercentage);
        System.out.println("");
        System.out.println("Grade: " + grade);
}

  public static String calculateGrade(double averagePercentage) 
{
       if (averagePercentage >= 90) 
{
       return "O (Excellent Grade)";
}
   else if (averagePercentage >= 80)
{
            return "A+ (Very Good Grade)";
}
   else if (averagePercentage >= 70) 
{
            return "A (Very Good Grade) ";
} 
  else if (averagePercentage >= 60) 
{
            return "B+ (Good Grade) ";
} 
  else if (averagePercentage >= 50) 
{
            return "B (Average Grade) ";
} 
  else
{
            return "C(Average Grade) ";
        }
    }
}
