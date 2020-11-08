//import necessary libraries
import java.util.*;
import java.io.*;

/**
 * Class Main
 */
public class Main {
  
  //delcare properties
  private static String output = "";
  
  /**
   * Main procedure.
   */
  public static void main(String[] args) {
    //create objects
    Scanner scanner = new Scanner(System.in);
    
    //declare variables
    boolean goAgain = true;
    
    //while the user wants to add another student, repeat
    do  {
      //get the first name of the student
      System.out.print("Enter the first name of the student: ");
      String first = scanner.nextLine();
      
      //get the middle initial of the student
      System.out.print("Enter the middle name of the student: ");
      String mid = scanner.nextLine();
      
      //get the last name of the student
      System.out.print("Enter the last name of the student: ");
      String last = scanner.nextLine();
      
      //declare a valid input boolean
      boolean validInput = false;
      int gradeInt = 1;
      //get the grade of the student
      do  {
        try {
          System.out.print("What grade is the student in? ");
          String grade = scanner.next();
          gradeInt = Integer.parseInt(grade);
          
          //check for a valid input
          if (0 < gradeInt && gradeInt <= 12)  {
            validInput = true;
          } else  {
            validInput = false;
          }
        } catch(Exception e) {
          validInput = false;
          System.out.println("Invalid input. Please try again");
        }
      } while (validInput == false);
      
      //getting the iep status of the student
      boolean iepValid = false;
      boolean iep = false;
      
      do  {
        System.out.print("Does the student have an IEP? (y/n): ");
        String ynIEP = scanner.next();
        
        //check to see if the input is valid
        if (ynIEP.equals("y")) {
          iep = true;
          iepValid = true;
        } else if (ynIEP.equals("n"))  {
          iep = false;
          iepValid = true;
        } else  {
          System.out.println("Invalid input. Please try again");
          iepValid = false;
        }
      } while (iepValid == false);
      
      //now checking to see if the student has any job experience
      boolean jobExp = false;
      boolean jobExpValid = false;
      do  {
        //does the user want to enter another student
        System.out.print("Does the student have any job experience? (y/n): ");
        String strjob = scanner.next();
        
        //checking for a valid input
        if (strjob.equals("y")) {
          jobExp = true;
          jobExpValid = true;
        } else if (strjob.equals("n"))  {
          jobExp = false;
          jobExpValid = true;
        } else  {
          System.out.println("Invalid input. Please try again");
          jobExpValid = false;
        }
      } while (jobExpValid == false);
      
      //getting their job experience
      String job1 = "";
      String job2 = "";
      String job3 = "";
      if (jobExp == true) {
        //get the student's first job
        System.out.print("Enter the student's first job: ");
        job1 = scanner.next();
        
        System.out.print("Enter the student's second job: ");
        job2 = scanner.next();
        
        System.out.print("Enter the student's third job: ");
        job3 = scanner.next();
      } else  {
        job1 = null;
        job2 = null;
        job3 = null;
      }
      
      //checking to see if the user wants to add another student
      boolean nextStudentValid = false;
      do  {
        //does the user want to enter another student
        System.out.print("Would you like to add another student? (y/n): ");
        String strGoAgain = scanner.next();
        
        //checking for a valid input
        if (strGoAgain.equals("y")) {
          goAgain = true;
          nextStudentValid = true;
        } else if (strGoAgain.equals("n"))  {
          goAgain = false;
          nextStudentValid = true;
        } else  {
          System.out.println("Invalid input. Please try again");
          nextStudentValid = false;
        }
      } while (nextStudentValid == false);
      
      //creating the student object
      Student student = new Student(first, mid, last, gradeInt, iep);
      output += student.print();
      Jobexp jobexp = new Jobexp(first, mid, last, job1, job2, job3);
      output += jobexp.print();
      
      
    } while (goAgain == true);
    
    try {
      //writing everything to a text file
      File myObj = new File("output.txt");
      
      //creating the filewriter
      FileWriter fileWriter = new FileWriter(myObj);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
      
      bufferedWriter.write(output);
      bufferedWriter.close();
    } catch(Exception e) {
    }
  }
}