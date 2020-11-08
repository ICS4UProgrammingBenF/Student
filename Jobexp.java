//import necessary classes
import java.util.*;

public class Jobexp {
  //properties
  private String firstName;
  private String midInit;
  private String lastName;
  private String firstJob;
  private String secondJob;
  private String thirdJob;
  
  /**
   * Constructor.
  */
  public Jobexp(String name1, String name2, String name3, String job1, String job2, String job3)  {
    firstName = name1;
    midInit = name2;
    lastName = name3;
    firstJob = job1;
    secondJob = job2;
    thirdJob = job3;
  }
  
  public String print() {
    String output = "";
    if (firstJob == null) {
      output = firstName + " does not have any job experience\r\n";
    } else  {
      output = firstName + " worked these jobs: " + firstJob + ", ";
      output += secondJob + ", " + thirdJob + "\r\n";
    }
    return output;
  }
}