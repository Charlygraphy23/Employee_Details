import java.util.Scanner;

public class EmpMain {

    static Scanner scanner=new Scanner(System.in);
    static int arraysize,person,index=-1;
   static Employee empArray[];

// getting input from user
    private static void getData() throws Exception{
        if((index+1)==empArray.length)  //full book
            displayData();

        else if(index < (empArray.length-1) && index >-1) {
            for (var i = index; i < (empArray.length-1); i++) {
                System.out.println("----------------------------");
                System.out.println((i + 1) + " no Employee Details");
                System.out.println("Enter Name ");
                empArray[i].setEmpName(scanner.next().toUpperCase());
                System.out.println(" Enter Age ");
                empArray[i].setAge(scanner.nextInt());
                System.out.println("Enter Gender ");
                empArray[i].setGender(Gender.valueOf(scanner.next().toUpperCase()));
                System.out.println("Enter Id ");
                empArray[i].setEmId(scanner.nextInt());
                System.out.println("Enter Designation ");
                empArray[i].setEmpDesignation(scanner.next().toUpperCase());
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                index++;
            }

        }



        else{
        for(var i=0;i<empArray.length;i++) {
            System.out.println("----------------------------");
            System.out.println((i + 1) + " no Employee Details");
            System.out.println("Enter Name ");
            empArray[i].setEmpName(scanner.next().toUpperCase());
            System.out.println(" Enter Age ");
            empArray[i].setAge(scanner.nextInt());
            System.out.println("Enter Gender ");
            empArray[i].setGender(Gender.valueOf(scanner.next().toUpperCase()));
            System.out.println("Enter Id ");
            empArray[i].setEmId(scanner.nextInt());
            System.out.println("Enter Designation ");
            empArray[i].setEmpDesignation(scanner.next().toUpperCase());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
            index++;
        }

        }
    }
    // display data;
       private static void displayData() throws Exception {

        if((index+1)==empArray.length) { //full
            System.out.println("The Employee book is Full");
            for (var i = 0; i <=index; i++) {

                System.out.println("------------------------------");
                System.out.println("Name " + empArray[i].getEmpName());
                System.out.println("Age " + empArray[i].getAge());
                System.out.println("Gender " + empArray[i].getGender().getDescription());
                System.out.println("ID " + empArray[i].getEmId());
                System.out.println("Designation " + empArray[i].getEmpDesignation());
            }
        }

        else if(index==-1) {  // null
            System.out.println("The book is Empty");
            System.out.println("Do you want to insert data ?");
            if((scanner.next().charAt(0)=='y')||(scanner.next().charAt(0)=='y')){
                getData();
            }
            else {
                System.out.println("------------------------------");
                System.out.println("|||| Exiting From Display() ||||");
                System.out.println("------------------------------");
                mainMenu();
            }
        }

        else if((index < (empArray.length-1) && index >-1)) {
            for (var i = 0; i <=index; i++) {

                System.out.println("------------------------------");
                System.out.println("Name " + empArray[i].getEmpName());
                System.out.println("Age " + empArray[i].getAge());
                System.out.println("Gender " + empArray[i].getGender().getDescription());
                System.out.println("ID " + empArray[i].getEmId());
                System.out.println("Designation " + empArray[i].getEmpDesignation());

            }
        }

    }
    //exit System

    private static void exitFromSystem(){
        System.exit(0);
    }

    //delete data

    private static void deleteData() throws Exception {

        if(index==-1)
            displayData();
        else {

            System.out.println("-----------------");
            System.out.println("Select the Employee");
            for (var i = 0; i <= index; i++) {
                System.out.println((i + 1) + " for " + empArray[i].getEmpName());


            }
            System.out.println("Enter 0 for (!! Main Menu !!)");
            person = scanner.nextInt();

            if (person == 0) {
                mainMenu();
            } else if (person > 0 && person <= empArray.length) {
                for (var i = (person-1);i<index;i++){
                    empArray[i]=empArray[i+1];
                    break;
                }
                index--;

            }

        }

    }





    //update by data

    private static void updateData() throws Exception{
        char ch, select;

        do {
            System.out.println("-----------------");
            System.out.println("Select the Employee");
            for (var i = 0; i < empArray.length; i++) {
                System.out.println((i + 1) + " for " + empArray[i].getEmpName());
            }
            System.out.println("Enter 0 for (!! Main Menu !!)");
            person = scanner.nextInt(); // This is the person
            if (person == 0) {
                mainMenu();}

            else if (person > 0 && person <= empArray.length) {
                do {
                    System.out.println("-------------------------");
                    System.out.println(empArray[person - 1].getEmpName() + "'s Profile Update");
                    System.out.println(" 1  Update Name ");
                    System.out.println(" 2  Update Age");
                    System.out.println(" 3  Update Gender ");
                    System.out.println(" 4  Update ID ");
                    System.out.println(" 5  Update Designation ");
                    System.out.println(" 6  Exit ");
                    System.out.println("Select any Choice ----->");

                    switch (scanner.nextInt()) {
                        case 1:
                            updateName();
                            break;
                        case 2:updateAge();
                            break;
                        case 3:updateGender();
                            break;
                        case 4:updateId();
                            break;
                        case 5:updateDesignation();
                            break;
                        case 6:

                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                    System.out.println("Do you want to update anything about " + empArray[person - 1].getEmpName() + " ?");
                    select=scanner.next().charAt(0);
                    if (select=='n')
                    {
                        System.out.println("------------------------------");
                        System.out.println("|||| Exiting From Profile ||||");
                        System.out.println("------------------------------");
                        break;
                    }

                } while (select=='y' || select=='Y');
            } else {
                System.out.println("Enter Correct option");
            }


            System.out.println("Do you want to continue with Updating Data ?");
            ch=scanner.next().charAt(0);
            if (ch=='n')
            {
                System.out.println("------------------");
                System.out.println("|||| Exiting  ||||");
                System.out.println("------------------");
                break;
            }

        } while (ch=='y' || ch=='Y');
    }


    //update by person



    private static void updateDesignation() {
        System.out.println("Enter Designation ");
        empArray[person-1].setEmpDesignation(scanner.next().toUpperCase());
    }

    private static void updateId() {
        System.out.println("Enter Id");
        empArray[person-1].setEmId(scanner.nextInt());
    }

    private static void updateGender() {
        System.out.println("Enter Gender (M/F/O)");
        empArray[person-1].setGender(Gender.valueOf(scanner.next().toUpperCase()));
    }

    private static void updateAge() {
        System.out.println("Enter Age");
        empArray[person-1].setAge(scanner.nextInt());
    }

    private static void updateName() {
        System.out.println("Enter Name ");
        empArray[person-1].setEmpName(scanner.next().toUpperCase());

    }




    //main


    public static void main(String[] args) throws Exception{

        System.out.println("How Many Employee Details You Want to insert ?");
        arraysize=scanner.nextInt();

        empArray=new Employee[arraysize]; // array initialization


        for(var i=0;i<empArray.length;i++){
            empArray[i]=new Employee(); // Allocating Space
        }

           mainMenu();


    }
       // main menu option
    private static void mainMenu() throws Exception{
        char ch;

        do{
            System.out.println("------------------------");
            System.out.println("    1  Enter Data ");
            System.out.println("    2  Display Data");
            System.out.println("    3  Update Data");
            System.out.println("    4  Delete Data");
            System.out.println("    5  Exit ");
            System.out.println("Select any Choice ----->");

            switch (scanner.nextInt()){
                case 1:getData();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    updateData();
                    break;
                case 4:
                    deleteData();
                    break;
                case 5:
                    exitFromSystem();
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

            System.out.println("Do you want to continue y/n ?");
            ch=scanner.next().charAt(0);
            if (ch=='n')
            {
                System.out.println("------------------");
                System.out.println("|||| GOOD BYE ||||");
                System.out.println("------------------");
                exitFromSystem();
            }
            else {}
        }while ((ch=='y') || (ch=='Y') );

    }


}
