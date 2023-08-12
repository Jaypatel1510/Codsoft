
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = 1; 
        int max = 10;
        int round=6;
        
        
        boolean exit= false;
        
        while (exit != true)  {
            
            System.out.println("--------------------------");
            System.out.println("1 = Play Game //In this We Give You 5 Round");
            System.out.println("2 = Change Defult Round");
            System.out.println("3 = 'Exit'");
            System.out.println("--------------------------");
            
            System.out.println("Enter Choise");
            int choise = sc.nextInt();
            
            switch (choise) {
                case 1:
                {System.out.println("So lets Start Game. The number Generate Between "+min+" to "+max);
                
                int attempt=1;
                int rendomNumber = randomNumber(min, max);
                            while(attempt != round+1)
                            {
                                System.out.println("-----------------------------");
                                System.out.print("It is Your "+attempt+" Chance,Enter number: ");
                                int user= sc.nextInt();

                                if(user == rendomNumber)
                                {
                                    System.out.println("Congratulasions, You Select Perfect Number");
                                    break;
                                }
                                else if (user > rendomNumber) {
                                    System.out.println("Too High!!");
                                }
                                else if(user < rendomNumber){
                                    System.out.println("Too small!!");
                                }
                                attempt++;  
                                
                            }
                            System.out.println("Random number between " + min + " and " + max + " is " + rendomNumber);
                            }

                        break;
                

                    case 2:
                    {
                        System.out.println("Enter No of Rounds Which you want");
                        round= sc.nextInt();
                        System.out.println("You have Successfully change Value");
                    }
                    default:
                        break;
                    

                    case 3:
                    {
                        exit = true;
                    }
                }
         }
      }

    public static int randomNumber(int min, int max){
        Random random = new Random();
        int randomNumber = random.nextInt(max - min + 1) + min;
        return randomNumber;
    }    
}