import java.util.Scanner;

class Colors {
    public static final String purple = "\033[0;35m";
    public static final String cyanColor = "\033[0;36m";
    public static final String darkBlueBlink = "\033[0;34;5m";
    public static final	String maroonColor = "\033[0;31m";
    public static final String red = "\033[0;31m";
    public static final String reset = "\033[0m";
    public static final String blink = "\033[5m";
    public static final	String yellow = "\033[0;33m";
    public static final String rstblink = "\033[25m";
    public static final String green = "\033[0;32m";
        
}

class UserDetails {
    private String name = "Sivani";
    private String mobileNumber = "9876543210";
    private String aadharNumber = "123456789090";
    private String address = "Karimnagar";
    private String password = "123456";
	
    // Constructor to initialize user details
    public UserDetails(String name, String mobileNumber, String aadharNumber, String address, String password) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.aadharNumber = aadharNumber;
        this.address = address;
        this.password = password;
    }

    UserDetails(){}
    // Getter methods
    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}

class AuthenticationService {

    // Validates mobile number (10 digits)
    public boolean isValidMobileNumber(String mobileNumber) {
        if (mobileNumber.length() == 10) {
            for (int i = 0; i < mobileNumber.length(); i++) {
                if (mobileNumber.charAt(i) < '0' || mobileNumber.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Validates Aadhar number (12 digits)
    public boolean isValidAadharNumber(String aadharNumber) {
        if (aadharNumber.length() == 12) {
            for (int i = 0; i < aadharNumber.length(); i++) {
                if (aadharNumber.charAt(i) < '0' || aadharNumber.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Validates the password (simple length check)
    public boolean isValidPassword(String password) {
        return password.length() >= 6; // password should have at least 6 characters
    }

	// checks if user enter 2 directly before signup
	public void loginFirst(UserDetails ud){
		System.out.print("Enter Username : ");
		String name = UserRegistration.sc.next();
		System.out.print("Enter Password : ");
		String password = UserRegistration.sc.next();
		if(name.equalsIgnoreCase(ud.getName())&&password.equals(ud.getPassword())){
			System.out.println(Colors.green + "Login Successful............" + Colors.reset);
			System.out.println("Hello "+ud.getName()+" Welcome......");
			System.out.println("\n\t$Experience The Ultimate Comfort And Luxury with our Exceptional Services$");
			Hotel.mainMenu();
		}
		else{
			System.out.println(Colors.yellow + "Sorry You are not a valid User Please SignUp........." + Colors.reset);
			UserRegistration.register();
		}
	}


    // Check user login credentials using name
    public void login(UserDetails ud) {
	System.out.println();
	System.out.println(Colors.maroonColor + "Press 1 for Login \nPress any key to Exit" + Colors.reset);
	String ch = UserRegistration.sc.next();
	switch(ch){
	case "1":
	System.out.print("Enter Username : ");
	String name = UserRegistration.sc.next();
	System.out.print("Enter Password : ");
	String password = UserRegistration.sc.next();
		if(name.equalsIgnoreCase(ud.getName())&&password.equals(ud.getPassword())){
			System.out.println(Colors.green + "Login Successful............" + Colors.reset);
			Hotel.mainMenu();
		}
		else{
			System.out.println(Colors.yellow + "Invalid Credentials \nPlease Try again............" + Colors.reset);
			login(ud);	
		}
	break;
	default:
	System.out.println(Colors.cyanColor + "Thank You..........." + Colors.reset);System.exit(0); }
    }
}

//_________________________________________________________________________________________________________________________________

// Hotel1 Deatils and properties are here

abstract class Accom{
                            abstract void accom();
                            abstract  void ac(); 
                            abstract void non_ac();		
}
interface Food{
		abstract void displayMenu();
		abstract void houseKeeping();
		}
class Hotel extends Accom implements Food{
          static Scanner sc=new Scanner(System.in);
		static int totalCost=0;
              static Accom ob=new Hotel();
		
		String SbrAc;
                double SbrAc_total_cost;
                String DbrAc;
                double DbrAc_total_cost;
                String TbrAc;
                double TbrAc_total_cost;
                double Total_cost = 0.0; 
                void SbrAc(){
		    SbrAc_total_cost =0;
                    SbrAc = "Actual Price --> 3000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");SbrAc();}
				    if(a==0){return;}
					                SbrAc_total_cost += 2700*a;
                                    Total_cost += SbrAc_total_cost;
				    System.out.println(SbrAc+SbrAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : SbrAc();
		                    }
                }
                void DbrAc(){
			DbrAc_total_cost=0;
                    DbrAc = "Actual Price --> 4000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have choose invalid option please choose an integer type value..:)");DbrAc();}
				    if(a==0){return;}
					                DbrAc_total_cost += 3600*a;
                                    Total_cost += DbrAc_total_cost;
				    System.out.println(DbrAc+DbrAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : DbrAc();
		                    }
                    
                }
                void TbrAc(){
			TbrAc_total_cost=0;
                    TbrAc = "Actual Price --> 5000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 0;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have choose invalid option please choose an integer type value..:)");TbrAc();}
                                    if(a==0){return;}
					                TbrAc_total_cost += 4500*a;
                                    Total_cost += TbrAc_total_cost;
				    System.out.println(TbrAc+TbrAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : TbrAc();
		                    }
                }


            void ac(){
                     System.out.println("\t\t 1.AC Single Bed Room cost is 3000 with discount 10%");
                     System.out.println("\t\t 2.AC Double Bed Room cost is 4000 with discount 10%");
                     System.out.println("\t\t 3.AC Triple Bed Room cost is 5000 with discount 10%");
		     System.out.println("\t\t 4.To go back");
                     System.out.println("\t\t 5.Exit");
                    System.out.println("\t\t Select above options for booking");
                     String s=sc.next();
                     switch(s){
                         case "1":  SbrAc();
				    break;
                         case "2":  DbrAc();
                                    break;
                         case "3":  TbrAc();
                                    break;
                         case "4":  accom();
                                    break;
                         case "5":  System.exit(0);
                         default :  System.out.println("\t\t It seems you have choosen invalid option Please Choose any one of the above options");     
                                    ac();
                        
                     }

            }
            

		String SbrNAc;
                double SbrNAc_total_cost;
                String DbrNAc;
                double DbrNAc_total_cost;
                String TbrNAc;
                double TbrNAc_total_cost;
                    void SbrNAc(){
		    SbrNAc_total_cost =0;
                    SbrNAc = "Actual Price --> 2000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");SbrNAc();}
				    if(a==0){return;}
					                SbrNAc_total_cost += 1800*a;
                                    Total_cost += SbrNAc_total_cost;
				    System.out.println(SbrNAc+SbrNAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : SbrNAc();
		                    }
                }
                void DbrNAc(){
			DbrNAc_total_cost=0;
                    DbrNAc = "Actual Price --> 3000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have choose invalid option please choose an integer type value..:)");DbrNAc();}
				    if(a==0){return;}
					                DbrNAc_total_cost += 2700*a;
                                    Total_cost += DbrNAc_total_cost;
				    System.out.println(DbrNAc+DbrNAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : DbrNAc();
		                    }
                    
                }
                void TbrNAc(){
			TbrNAc_total_cost=0;
                    TbrNAc = "Actual Price --> 4000 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print(Colors.darkBlueBlink + "Please select ...How many rooms would you like to be in ....." + Colors.reset);
                                    String number = sc.next();
                                    int a = 0;
                                    try{a = Integer.parseInt(number);}catch(NumberFormatException e){System.out.println("It Seems like you have choose invalid option please choose an integer type value..:)");TbrNAc();}
                                    if(a==0){return;}
					                TbrNAc_total_cost += 3600*a;
                                    Total_cost += TbrNAc_total_cost;
				    System.out.println(TbrNAc+TbrNAc_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : TbrNAc();
		                    }
                }



		void non_ac(){
                     System.out.println("\t\t 1.Non_AC Single Bed Room cost is 2000 with discount 10%");
                     System.out.println("\t\t 2.Non_AC Double Bed Room cost is 3000 with discount 10%");
                     System.out.println("\t\t 3.Non_AC Triple Bed Room cost is 4000 with doscount 10%"); 
                     System.out.println("\t\t 4.To go back");
                     System.out.println("\t\t 5.Exit");
                     System.out.println("\t\t Select above options for booking");

                     String s=sc.next();
                     switch(s){
                         case "1":  SbrNAc();
				    break;
                         case "2":  DbrNAc();
                                    break;
                         case "3":  TbrNAc();
                                    break;
                         case "4":  accom();
                                    break;
                         case "5":  System.exit(0);
                         default :  System.out.println("\t\t It seems you have choosen invalid option Please Choose any one of the above options");     
                                    non_ac();
                        
                     }

           	}

			
          
             void accom(){
                    System.out.println("\t\t 1.A/c  Rooms ");
                    System.out.println("\t\t 2.Non A/c Rooms ");
		    System.out.println("\t\t 3.Return to home ");
                    String m=sc.next();
                    switch(m){
                           case "1": ob.ac();
                                       break;
                           case "2": ob.non_ac();
                                       break;
			   case "3": mainMenu();
                           default :System.out.println(" Choose any one of the above options ");
                                    accom();
                    }
           }

//--------------------------------------------------------------------------------------------------------------





//---------------------------------------------------------------------------------------------------------------
		static Food obj=new Hotel();
		String combo;
                String brf;
		String lunch;
		String dinner;
		double Combo_total_cost;
               double bf_total_cost;
		double Lunch_total_cost ;
		double Dinner_total_cost;
		

  void bf(){
		    bf_total_cost =0;
                    brf = "Actual Price --> 80 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print("Please select ...How many orders would you like to give .....");
                                    String no1 = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(no1);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");bf();}
				    if(a==0){return;}
					                bf_total_cost += 72*a;
                                    Total_cost += bf_total_cost;
				    System.out.println(brf+bf_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : bf();
		                    }
                }
void Lunch(){
		    Lunch_total_cost =0;
                    lunch = "Actual Price --> 150 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print("Please select ...How many orders would you like to give .....");
                                    String no1 = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(no1);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");Lunch();}
				    if(a==0){return;}
					                Lunch_total_cost += 135*a;
                                    Total_cost += Lunch_total_cost;
				    System.out.println(lunch+Lunch_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : Lunch();
		                    }
                }
void Dinner(){
		    Dinner_total_cost =0;
                    dinner = "Actual Price --> 150 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print("Please select ...How many orders would you like to give .....");
                                    String no1 = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(no1);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");Dinner();}
				    if(a==0){return;}
					                Dinner_total_cost += 135*a;
                                    Total_cost += Dinner_total_cost;
				    System.out.println(dinner+Dinner_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : Dinner();
		                    }
                }
void Combo(){
		    Combo_total_cost =0;
                    combo = "Actual Price --> 150 \nDiscount --> 10% \nTotal Price --> ";
                                    System.out.print("Please select ...How many orders would you like to give .....");
                                    String no1 = sc.next();
                                    int a = 1;
                                    try{a = Integer.parseInt(no1);}catch(NumberFormatException e){System.out.println("It Seems like you have entered invalid input please choose an integer value only.. :)");Combo();}
				    if(a==0){return;}
					                Combo_total_cost += 135*a;
                                    Total_cost += Combo_total_cost;
				    System.out.println(combo+Combo_total_cost);
				    System.out.println("Select an option ");
				    System.out.println("1.Payment     2.Exit");
				    String n = sc.next();
				    switch(n){
					case "1": Payment.chooseBank();break;					  
					case "2": System.exit(0);
					default : Combo();
		                    }
                }




			
   public void displayMenu() {
        System.out.println("\t\t 1. Breakfast - Rs. 80 Rs/-");
        System.out.println("\t\t 2. Lunch - Rs. 150 Rs/-");
        System.out.println("\t\t 3. Dinner - Rs. 150 Rs/-");
        System.out.println("\t\t 4. Combo Meal (Lunch + Dinner) - Rs. 300 Rs/- with 5% discount");
        System.out.println("\t\t 5. To go back");
        System.out.println("\t\t 6. Exit");
        System.out.println("\t\t Select above options for booking");
        String n = sc.next();
        
        switch(n) {
            case "1":      bf();           
 				break;
            case "2":    Lunch();          
                                break;
            case "3":     Dinner();         
                                break;
            case "4":  	Combo();	 	
				break;
            case "5":	mainMenu();
                             	break;
             case "6":  System.exit(0);
             default :  System.out.println("\t\t It seems you have choosen invalid option Please Choose any one of the above options");     
                           displayMenu();       
         }
    }
           //-------------------------------------------------------------------------------------------------- 
		public void houseKeeping() {
    System.out.println("\t\t Housekeeping Services:");
    System.out.println("\t\t 1. Room Cleaning");
    System.out.println("\t\t 2. Laundry Service");
    System.out.println("\t\t 3. Additional Towels - Available upon request.");
    System.out.println("\t\t 4. Go back to main menu");

    String choice = sc.next();
    switch (choice) {
        case "1":
            System.out.println("\t\t You selected Room Cleaning. This service will be provided shortly.");
		houseKeeping();
            break;
        case "2":
            System.out.println("\t\t You selected Laundry Service. This service will be provided shortly.");
		houseKeeping();
            break;
        case "3":
            System.out.println("\t\t You selected Additional Towels. They will be provided shortly.");
		houseKeeping();
            break;
        case "4":
            System.out.println("\t\t Returning to main menu...");
	mainMenu();
            break;
        default:
            System.out.println("\t\t Invalid choice. Please select from above options.......");
            houseKeeping();
    }
}
//-----------------------------------------------------------------------------------------------------------------
   
            public static void mainMenu() {
    
    

    
        System.out.println("\n\t\t--- Main Menu ---");
        System.out.println("\t\t 1. Accommodation");
        System.out.println("\t\t 2. Food");
        System.out.println("\t\t 3. House Keeping");
        System.out.println("\t\t 4. Swimming pool");
        System.out.println("\t\t 5. GYM");
	System.out.println("\t\t 6. View Total Cost");
        System.out.println("\t\t 7. Exit");

        System.out.print("\t\t Enter your choice: ");
        String n = sc.next();

        switch (n) {
            case "1": ob.accom();
                    	break;
            case "2": obj.displayMenu();
                    	break;
            case "3": obj.houseKeeping();
                    	break;
            case "4": System.out.println("\t\t Swimming Pool service is available.");
			mainMenu();
                    	break;
            case "5": System.out.println("\t\t GYM service is available.GYM Timings are 7:00 AM To 10:00 PM");
			mainMenu();
                    	break;
		case "6":
                System.out.println("Total Cost: Rs. " + totalCost);
                mainMenu();
                break;
	    case "7": System.out.println("\t\t Thank You Visit Again..................");break;
            default:  System.out.println("\t\t Invalid choice. Please select a valid option.");
			mainMenu(); 
    }
		
}

}
//-----------------------------------PayMent Class is here------------------------------

class Payment{
	static Scanner sc = new Scanner(System.in);
	static void chooseBank(){
		System.out.println("Choose any one of the following options if not available we will accept cash toooo    ");
		System.out.println("1.PhonePe	   2.Googlepay 	      3.Paytm");
		String n = sc.next();
		switch(n){
			case "1": 
				  while(true){
					System.out.println("Enter UPIPin ");System.out.println("Enter only digits ");String PUpi = sc.next();
					long a = 0;
					try{a = Long.parseLong(PUpi);break;}catch(NumberFormatException e){System.out.println("It seems you have eneterd other than digits.... Please Re-Enter.....");}
					
				  }
				  try{System.out.println("Making Payment Process......");Thread.sleep(3000);}catch(InterruptedException e){}
				  System.out.println("Payment Successful...... \nThank You.... \nNow You can check in......");
				  System.out.println("1.MainMenu		2.Enter any character to exit");
				  String c = sc.next();
				  if(c.equals("1"))
					Hotel.mainMenu();
				  else{System.exit(0);}
				  break;
			case "2":    
				while(true){
					System.out.println("Enter UPIPin ");System.out.println("Enter only digits ");String PUpi = sc.next();
					long a = 0;
					try{a = Long.parseLong(PUpi);break;}catch(NumberFormatException e){System.out.println("It seems you have eneterd other than digits.... Please Re-Enter.....");}
				  	}
				  	try{System.out.println("Making Payment Process......");Thread.sleep(3000);}catch(InterruptedException e){}
				  	System.out.println("Payment Successful...... \nThank You.... \nNow You can check in......");
				  	System.out.println("1.MainMenu		2.Enter any character to exit");
				  	String c1 = sc.next();
				  	if(c1.equals("1"))
						Hotel.mainMenu();
				  	else{System.exit(0);}
				  	break;
                            case "3": 	
				   while(true){
						System.out.println("Enter UPIPin ");System.out.println("Enter only digits ");String PUpi = sc.next();
						long a = 0;
						try{a = Long.parseLong(PUpi);break;}catch(NumberFormatException e){System.out.println("It seems you have eneterd other than digits.... Please Re-Enter.....");}
				  		}
				  		try{System.out.println("Making Payment Process......");Thread.sleep(3000);}catch(InterruptedException e){}
				  		System.out.println("Payment Successful...... \nThank You.... \nsNow You can check in......");
				  		System.out.println("1.MainMenu		2.Enter any character to exit");
				  		String c2 = sc.next();
				  		if(c2.equals("1"))
							Hotel.mainMenu();
				  		else{System.exit(0);}
				  		break;
			
			default : System.out.println("It seems like you have choosen an invalid option please choose again....");
		}		
	}
}



//-------------------------------------------------------------------------------------------------------

class UserRegistration {
	static Scanner sc = new Scanner(System.in);
	static UserDetails ud1;
	static UserDetails user;
	static AuthenticationService authService = new AuthenticationService();
	// To store the registered user details
	static String bold = "\033[1m";
        static String blue = "\033[34m";      // Blue color
        static String blink = "\033[5m";      // Blinking effect
        static String reset = "\033[0m";      // Reset to normal text

	static {
            // Apply bold, blue, and blinking effect
            System.out.println();
            System.out.println();
            System.out.println(bold + blue + blink + "------------------------- WELCOME TO THE GRAND HOTEL OF HYDERABAD -----------------------" + reset);
            System.out.println();
	}

	public static boolean isValidAadhaar(String aadhaar) {
		String regex = "^\\d{12}$|^(\\d{4}\\s?){3}$";
		return aadhaar.matches(regex);
	}
	
	static void register(){

                    System.out.print(Colors.purple + "Enter your name: " + Colors.reset);
                    String name = sc.next();

                    String newMobile = "";
			while (true) {
    				System.out.print(Colors.purple + "Enter your mobile number (10 digits): " + Colors.reset);
    				newMobile = sc.next();

    				// Check if the mobile number is 10 digits, starts with 6/7/8/9, and is numeric
    				if (newMobile.length() == 10) {
        			char firstChar = newMobile.charAt(0);
        				boolean startsWithValidDigit = (firstChar == '6' || firstChar == '7' || firstChar == '8' || firstChar == '9');
        			boolean isNumeric = true;

        			for (int i = 0; i < newMobile.length(); i++) {
            			if (!Character.isDigit(newMobile.charAt(i))) {
                		isNumeric = false;
                		break;
            				}
        			}

       				 if (startsWithValidDigit && isNumeric) {
           			 break; // Valid number, exit loop
        				}
    				}

    			// If the loop does not break, shows an error message
    			System.out.println(Colors.red + Colors.blink + "Invalid Mobile Number. Please Re-enter." + Colors.rstblink + Colors.reset);
		}
		String newAadhar = "";
                    while (true) {
                        System.out.print(Colors.purple + "Enter your Aadhar number (12 digits): " + Colors.reset);
                        newAadhar = sc.next();
                        if (isValidAadhaar(newAadhar)) {
                            break;
                        } else {
                            System.out.println(Colors.red + Colors.blink + "Invalid Aadhar Number. Please Re-enter" + Colors.rstblink + Colors.reset);
                        }
                    }

                    System.out.print(Colors.purple + "Enter your address: " + Colors.reset);
                    String address = sc.next();

                    String password = "";
                    while (true) {
                        System.out.print(Colors.purple + "Enter your password (at least 6 characters): " + Colors.reset);
                        password = sc.next();
                        if (authService.isValidPassword(password)) {
                            break;
                        } else {
                            System.out.println(Colors.red + Colors.blink + "Invalid Password. Please Re-enter" + Colors.rstblink + Colors.reset);
                        }
                    }

                    // Create user object
                    user = new UserDetails(name, newMobile, newAadhar, address, password);
                    System.out.println("User registered successfully!");
		    System.out.println("Please Login...................");
		    authService.login(user);
	}



    public static void main(String[] args) {
        
                   
            System.out.println("\t\t\t\t\t1. Sign Up");
            System.out.println("\t\t\t\t\t2. Login");
            System.out.println("\t\t\t\t\t3. Exit");
            System.out.print("Choose an option: ");
            char option = sc.next().charAt(0);
            sc.nextLine(); // Consume the newline character left after reading the integer

            switch (option) {
		case '1':  // Sign Up
                    // User registration process
             		register();
                    break;

                case '2':  // Login
			
                    	UserDetails ud1 = new UserDetails();
			authService.loginFirst(ud1);
			break;
                   
                case '3':  // Exit
                    System.out.println("Thankyou....visit again....!");
                    break;

                default:
                    System.out.println(Colors.red + "Invalid option. Please try again." + Colors.reset);
			
            }
       
    }
}