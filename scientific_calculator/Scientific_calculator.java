import java.util.ArrayList;
import java.util.Scanner;

public class Scientific_calculator {
    static ArrayList<String> AL1 = new ArrayList<>();
    static double current_result = 0;
    static double result = 0;

    public static double facti(double i) {
        if (i == 1 || i == 0) {
            return 1;
        } else {
            return i * facti(i - 1);
        }
    }

    public static String format(ArrayList<Double> AL, String Value, Double result) {
        StringBuilder SB = new StringBuilder();
        SB.append(AL.get(0));
        for (int i = 1; i < AL.size(); i++) {
            SB.append(" ").append(Value).append(" ").append(AL.get(i));
        }
        SB.append(" = ").append(result);
        return SB.toString();
    }

    public static double cal(ArrayList<Double> AL, String a) {
        Scanner sc = new Scanner(System.in);
        result = AL.isEmpty() ? 0 : AL.get(0);
        switch (a) {
            case "+":
                for (int i = 1; i < AL.size(); i++) {
                    result += AL.get(i);
                }
                break;
            case "-":
                for (int i = 1; i < AL.size(); i++) {
                    result -= AL.get(i);
                }
                break;
            case "*":
                for (int i = 1; i < AL.size(); i++) {
                    result *= AL.get(i);
                }
                break;
            case "/":
                for (int i = 1; i < AL.size(); i++) {
                    if (AL.get(i) != 0) {
                        result /= AL.get(i);
                    } else {
                        System.out.println("Error Division by zero");
                        return Double.NaN;
                    }
                }
                break;
            case "%":
                for (int i = 1; i < AL.size(); i++) {
                    result %= AL.get(i);
                }
                break;
            case "fact":
                for (int i = 1; i < AL.size(); i++) {
                    result = facti(AL.get(i));
                }
                break;
            case "Pi":
                for (int i = 1; i < AL.size(); i++) {
                    result = AL.get(i) * Math.PI;
                }
                break;
            case "XpowerN":
                System.out.println("Enter the power of X:");
                int power = sc.nextInt();
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.pow(AL.get(i), power);
                }
                break;
            case "cube_root":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.cbrt(AL.get(i));
                }
                break;
            case "square_root":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.sqrt(AL.get(i));
                }
                break;
            case "log10":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.log10(AL.get(i));
                }
                break;
            case "log":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.log(AL.get(i));
                }
                break;
            case "exp":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.exp(AL.get(i));
                }
                break;
            case "R->D":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.toDegrees(AL.get(i));
                }
                break;
            case "D->R":
                for (int i = 1; i < AL.size(); i++) {
                    result = Math.toRadians(AL.get(i));
                }
                break;
            case "sin":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.sin(exam);
                }
                break;
            case "cos":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.cos(exam);
                }
                break;
            case "tan":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.tan(exam);
                }
                break;
            case "cosec":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.asin(exam);
                }
                break;
            case "sec":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.acos(exam);
                }
                break;
            case "cot":
                for (int i = 1; i < AL.size(); i++) {
                    double exam = Math.toRadians(AL.get(i));
                    result = Math.atan(exam);
                }
                break;
            default:
                System.out.println("Some feature is under processing ");
                break;
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            ArrayList<Double> AL = new ArrayList<>();
            String End;
            System.out.println("  ---Welcome to Solo Calculator--- ");
            System.out.println("Previous result =" + current_result);
            System.out.println("Press = to stop and Exit for termination ");
            while (true) {
                End = sc.nextLine();
                if (End.equalsIgnoreCase("=")) {
                    break;
                } else if (End.equalsIgnoreCase("Exit")) {
                    System.out.println("   Thanks you ");
                    sc.close();
                    return;
                } else {
                    try {
                        double result = Double.parseDouble(End);
                        AL.add(result);
                    } catch (Exception e) {
                        System.out.println("Something went wrong " + e);
                    }
                }
            }
            if (AL.isEmpty()) {
                continue;
            }
            // for first
            AL.add(0, current_result);
            System.out.println(" Which operation does you perform ?");
            System.out.println(
                    " + ,- ,* ,/, % ,Pi,XpowN,fact,cube_root,square_root,log10,logN,exp,R->D,D->R,sin,cos,tan,cosec,sec,cot");
            String Value = sc.nextLine();
            if (Value.equalsIgnoreCase(" Exit ")) {
                System.out.println("Thanks You visit again ");
            }
            double new_result = cal(AL, Value);
            if (Double.isNaN(new_result)) {
                System.out.println("Calculation Failed !!! ");
            } else {
                current_result = new_result;
                AL1.add(format(AL, Value, new_result));
            }
            System.out.println(" New Result = " + current_result);
            System.out.println("     ---History Chart--- ");
            for (String S : AL1) {
                System.out.println(S);
            }
        }
    }
}