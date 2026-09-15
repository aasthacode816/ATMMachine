import java.util.Scanner;
public class calculator{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner (System.in)) {
            System.out.println("Calculator");
            System.out.print("Enter first number");
            double num1 = sc.nextDouble();
            System.out.print("Enter Operator (+,-,*,/):");
            char operator = sc.next().charAt(0);
            System.out.println("Enter second number");
            double num2 = sc.nextDouble();
            double result;
            switch (operator){
                case '+' -> result = num1+num2;
                case '-' -> result = num1-num2;
                case '*' -> result = num1*num2;
                case '/' -> {
                    if(num2==0){
                        System.out.println("Cannot divide by zero");
                        sc.close();
                        return;
                    }
                    result = num1/num2;
                }
                    
                default -> {
                    System.out.print("Invalid operator");
                    sc.close();
                    return;
                }
            }
            System.out.println("Result="+result);
        }

        }
    }
    

