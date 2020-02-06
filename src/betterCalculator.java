import java.util.*;

public class betterCalculator {
    public static void main(String[] args){
        Scanner n = new Scanner (System.in);
        String operator = n.nextLine();
        int x = n.nextInt();
        int y = n.nextInt();
        if (operator.equals("add")){
            System.out.println(x + y);
        } else if (operator.equals("subtract")){
            System.out.println(x - y);
        } else if (operator.equals("multiply")){
            System.out.println(x * y);
        } else if (operator.equals("divide")){
            System.out.println(x / y);
        }
    }
}