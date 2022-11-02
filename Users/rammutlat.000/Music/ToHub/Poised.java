/*
Project management system for a small structural engineering firm to keep track of the many projects on which they work
 * @author Tebogo Rammutla
 */

// Importing necessary classes from java core library
 import java.util.*;

// Class definition
public class Poised 

{ 
    //Properties of the class 
    private Project project;
    private Person person;
    private static Scanner scanner = new Scanner(System.in);
    private static int projectNo;
      
    //  Poised Class Constructor
    /**
     * Constructor of Poised Class
     * @param project the Project to set
     * @param person the person to set
     */
    public Poised(Project project,Person person)
    {
        // Properties of Poised class
        this.project = project;
        this.person=person;
    }
    
    /**
     * getProject
     * @return project object
     */
    //  getProject
    public Project getProject()
    {   // returns Project object
        return this.project;  
    } 
    
    /**
     * getPerson
     * @return person object
     */ 
    // returns Person object
    public Person getPerson()
    {  
        return this.person;  
    } 
    
    /**
     * updateContractorDetails
     * @param contractor object to set
     */ 
    // updateContractorDetails method
    private static void  updateContractorDetails(Contractor contractor)
    {
            System.out.print("What would you like to change ?(telephone,email or both?) : ");
            String choice = scanner.next();
            if(choice.equalsIgnoreCase("telephone"))
                {
                    //Updating the contractor telephone details in contractor class                       
                    System.out.print("Please enter the contractor telephone number : ");
                    String telephoneNo = scanner.next();
                    contractor.setTelephoneNumber(telephoneNo); 
                }
            else if(choice.equalsIgnoreCase("email"))
                { 
                    //Updating the contractor email details in contractor class    
                    System.out.print("Please enter the contractor email address : ");
                    String emailAddress = scanner.next();
                    contractor.setEmailAddress(emailAddress); 
                }
            else if(choice.equalsIgnoreCase("both"))
                { 
                    //Updating the contractor contact details in contractor class                   
                    System.out.print("Please enter the contractor telephone number : ");
                    String telephoneNo = scanner.next();
                    contractor.setTelephoneNumber(telephoneNo);                    
                    System.out.print("Please enter the contractor email address : ");
                    String emailAddress = scanner.next();
                    contractor.setEmailAddress(emailAddress);                       
                }
    }
    
    /**
     * create Person
     * @return person object
     */ 
    // Creating person object
    private static Person createPersonObject()
    {
        Customer customer = new Customer("Tebogo","Rammutla","015 564 3456","tebza@hotmail.com","23 Vilakazi Street,Soweto,Johannesburg");
        Architect architect = new Architect("Jones","Makgoka","012 564 3456","jonesM@yahoo.com","34 Mole Street,Montana,Pretoria");
        Contractor contractor = new Contractor("Sara","Bartman","041 564 3456","sara.bartman@hotmail.com","11 Seapoint Street,Summerstrand,Port Elizaberth");
        Person person=new Person(customer,architect,contractor);
        return person;
    }
    
    /**
     * create Project 
     * @return project object
     */ 
    // Creating project object
    private static Project createProjectObject(String projectName,String buildingType,String physicalAddress,String erfNo, String projectTotalFee, String totalPaid,String projectDeadline)
    {
        projectNo++;
        Project project=new Project(projectNo,projectName,buildingType,physicalAddress,erfNo,projectTotalFee,totalPaid,projectDeadline);   
        return project;
    }
    // main method of the class
    /**
     * main
     * @param string[]
     */ 
    public static void main(String [] args)
    {
        // Getting project input data from the user
        System.out.print("Enter the project name : ");
        String projectName = scanner.next();
        System.out.print("What type of building is being designed ? \n(house/apartment block/store etc): ");
        String buildingType = scanner.next();
        System.out.print("What is the physical address for the project? : ");
        String physicalAddress = scanner.next();
        physicalAddress += scanner.nextLine();
        System.out.print("What is the ErfNo : ");
        String erfNo = scanner.next();
        System.out.print("What is the total fee being charged for the project? (Do not input currency symbol !!) : ");
        String projectTotalFee = "";
        String totalPaid = "";
        try 
        {
            projectTotalFee = scanner.next();
            boolean b = isNumeric(projectTotalFee );
            if(b)
            { 
            }
            else
            {   
            /** If what the user has typed as first number is not a valid number,
              * ask user to enter first number again until the input is a valid number
            */
                while(!b)
                {
                //Asking user to enter first number again
                    System.out.print("Please enter the total fee being charged for the project again? :  ");
                    projectTotalFee = scanner.next();
                    // Testing again if input is a valid number
                    b = isNumeric( projectTotalFee);
                }
            }
            System.out.print("What is the total amount paid to date?(Do not input currency symbol !!) : ");
            totalPaid = scanner.next();
            boolean b1 = isNumeric(totalPaid);
            if(b1)
            {
            }
            else 
            {
        	
            /** If what the user has typed as second number is not a valid number,
             * ask user to enter second number again until the input is a valid number
           */           
                while(!b1)
                {
                    System.out.print("Please enter the total fee being charged for the project again? : ");
                    totalPaid = scanner.next();
                    // Testing again if input is a valid number
                    b1 = isNumeric(totalPaid);
                }
             }	
        }
        catch(NumberFormatException e)
        {
        	e.printStackTrace();
        }
        System.out.print("What is the deadline for the project (dd Mon yyyy) : ");
        String projectDeadline = scanner.next(); 
        projectDeadline += scanner.nextLine();

        //Creating objects
        Person person = createPersonObject();
        Project project1 = createProjectObject(projectName,buildingType,physicalAddress,erfNo,projectTotalFee,totalPaid,projectDeadline);
        Poised poised1 = new Poised(project1,person);  
        
        // Asking user to state whether they need to change the due date of the project
        System.out.print("Do you want to update the due date of the project ?(yes/no)");
        String updateDueDate = scanner.nextLine();
        if(updateDueDate.equalsIgnoreCase("yes") )
        {
        // Asking user to change the due date of the project
            System.out.print("Enter the new due date of the project : ");
            String newDueDate = scanner.next();
            newDueDate += scanner.nextLine();
        //Updating the due date of the project in Project class
            project1.setProjectDeadlineDate(newDueDate);
        }
        else if(updateDueDate.equalsIgnoreCase("no") )
        {
        }
        System.out.print("Do you want to update the total amount of the fee paid to date?(yes/no) : ");
        String updateAmountPaid = scanner.next();
        if(updateAmountPaid.equalsIgnoreCase("yes"))
        {       
           // Asking user to change the new total amount of the fee paid to date for the project
           System.out.print("Enter the new total amount of the fee paid to date : ");
           String totalPaidToDate = scanner.next();
           try 
           {
                boolean b2 = isNumeric(totalPaidToDate);
                if(b2)
                {
                     
                }
                else 
                {
           	
               /** If what the user has typed as second number is not a valid number,
                * ask user to enter second number again until the input is a valid number
              */           
                    while(b2 != true)
                    {
                         System.out.print("Please enter the new total amount of the fee paid to date again : ");
                         totalPaidToDate = scanner.next();
                         // Testing again if input is a valid number
                        b2 = isNumeric(totalPaidToDate);
                    }
                }	
           }
           catch(NumberFormatException e)
           {
           	e.printStackTrace();
           }
           //Updating the new total amount of the fee paid to date in Project class
           project1.setTotalAmountPaidToDate(totalPaidToDate); 
        }
        else if(updateAmountPaid.equalsIgnoreCase("no"))
        {
                	
        }
        System.out.print("Do you want to update the contractor 's contact details details?(yes/no) : ");
        String updateContractorDetails = scanner.next();
        if(updateContractorDetails.equalsIgnoreCase("yes"))
        { 
            updateContractorDetails(person.getContractor());  
        }
        else if(updateContractorDetails.equalsIgnoreCase("No"))
        {
         
        }
        //Displaying the data entered for the first project        
        System.out.println(poised1.getProject());
        System.out.println(poised1.getPerson().getArchitect());
        System.out.println(poised1.getPerson().getContractor());       
        System.out.println(poised1.getPerson().getCustomer());        
        
    }
    
    /**
     * IsNumeric
     * @param string the string to test if its numeric
     * @return boolean boolean of whether input entered is numeric
     */ 
    private static boolean isNumeric(String string) 
    {
        Double doubleValue;	 
        try
        {
            // If what the user has entered as a number can be converted to be an integer,return true
            doubleValue = Double.parseDouble(string);
            return true;
        } 
        catch (NumberFormatException e) 
        {
            // If what the user has typed as a number cannot be converted to integer,display a message
            System.out.println(string + " is invalid,either you have put a currecy symbol or not supplied a valid number!! ");
        }
        // Return false if what the user has entered cannot be converted to an integer
        return false; 
    }     
} 
