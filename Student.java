import java.util.*;

public class Student  {
  
  //declare properties
  private String firstName;
  private String midInit;
  private String lastName;
  private int grade;
  private boolean iep;
  
  /**
   * Constructor.
  */
  public Student(String first, String mid, String last, int lvl, boolean type)  {
    firstName = first;
    midInit = mid;
    lastName = last;
    grade = lvl;
    iep = type;
  }
  
  /**
   * Print method.
  */
  public String print() {
    String output = firstName + " " + midInit + ". " + lastName;
    output += " is in grade " + grade + ". ";
    
    String outputIEP = "";
    //check if student has an iep or not
    if (iep == true)  {
      outputIEP = firstName + " has an IEP\r\n";
    } else  {
      outputIEP = firstName + " doesn't have an IEP\r\n";
    }
    
    output += outputIEP;
    return output;
  }
}