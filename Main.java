import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    static ArrayList<User> Users=new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String option;

        System.out.print("Have an account (yes/no)");

        option = scanner.nextLine();

        switch (option.toLowerCase()) {
            case "yes":
                Login(scanner);
                break;
            case "no":
                Register(scanner);
                logUsers();
                break;

            default:
                System.out.println("Invalid option!!");
        }

        
    }

    private static void Register(Scanner scanner) {
        boolean isComplete = false;
        while (!isComplete) {
            System.out.print("Enter your email: ");
            String email = scanner.nextLine();
            if(!isEmailCorrect(email))
            {
                System.out.println("INVALID EMAIL!!!");
                continue;
            }

            System.out.print("Enter your fullname: ");
            String fullname = scanner.nextLine();

            System.out.print("Enter your password: ");

            String password = scanner.nextLine();

            if (isPasswordStrong(password)) {
                System.out.println(
                        "Welcome " + fullname + "\n Confirm your email is " + email + "\n and password " + password);

                System.out.print("Are the details correct? (yes/no)");

                String check_details = scanner.nextLine();

                switch (check_details.toLowerCase()) {
                    case "yes":
                        isComplete = true;
                        //User newUser=new User(email, fullname, password);
                        AddUser(email,fullname,password);
                        System.out.println("Welcome!!!");
                        break;

                    case "no":
                        System.out.println("Please enter your details again!!");
                        break;

                    default:
                        System.out.println("Invalid input!!");
                        break;
                }

            }
            else{
                System.out.println("WEAK PASSWORD!!, TRY AGAIN!!");
            }

        }
    }

    private static void Login(Scanner scanner)
    {
        System.out.println("Welcome to login page!!");

        System.out.print("Enter email");
        String email=scanner.nextLine();

       

    }
    

    private static void AddUser(String Email,String Fullname,String PASSWORD)
    {
        Users.add(new User(Email, Fullname, PASSWORD));
    }

    private static boolean isPasswordStrong(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

    private static boolean isEmailCorrect(String email)
    {
        String emailRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern pattern=Pattern.compile(emailRegex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    private static void logUsers()
    {
        System.out.println("USERS!!!");
        for (User user: Users)
        {
            System.out.println(user.getFullname());
        }
    }

}
