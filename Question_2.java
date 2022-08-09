import java.util.Scanner;
class Register{
    static int s0 = 0;
    static int r1 = 0;
    static int r2 = 0;
    static int r3 = 0;
    static int r4 = 0;
    static int r5 = 0;
}

public class Question_2 {
    public static void main(String[] args) {
        System.out.println("Please enter code:");
        boolean exitFlag = false;
        while (!exitFlag) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String lowercase = input.toLowerCase(); // lower case string for instruction
            String[] tokens = lowercase.split("\\."); // break string into token
            String operation = tokens[0];
            System.out.println("Address: " + System.identityHashCode(input));
            PrintBinary(tokens[0], tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
            switch (operation) { // switch case base on instruction operation
                case "add" -> AddOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                case "sub" -> SubOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                case "mul" -> MulOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
                case "div" -> DivOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
            }
            System.out.println("s0: " + Register.s0);
            System.out.println("r1: " + Register.r1);
            System.out.println("r2: " + Register.r2);
            System.out.println("r3: " + Register.r3);
            System.out.println("r4: " + Register.r4);
            System.out.println("r5: " + Register.r5);
            if (input.equals(""))
                exitFlag = true;

        }
    }

    private static void CheckSyntax(String syntax) {
        String[] tokens = syntax.split("\\.");
        if (tokens.length > 5) {
            System.out.println("Syntax error");
        }
        if (!tokens[0].equals("add") && !tokens[0].equals("sub") && !tokens[0].equals("mul") && !tokens[0].equals("div")){
            System.out.println("Syntax error with instruction code");
        }
        if (!tokens[1].equals("s0") && !tokens[1].equals("r1") && !tokens[1].equals("r2") &&
                !tokens[1].equals("r3") && !tokens[1].equals("r4") && !tokens[1].equals("r5")){
            System.out.println("Syntax error with first register");
        }
        if (!tokens[2].equals("s0") && !tokens[2].equals("r1") && !tokens[2].equals("r2") &&
                !tokens[2].equals("r3") && !tokens[2].equals("r4") && !tokens[2].equals("r5")){
            System.out.println("Syntax error with second register");
        }
        if (!tokens[3].equals("r1") && !tokens[3].equals("r2") && !tokens[3].equals("r3") &&
                !tokens[3].equals("r4") && !tokens[3].equals("r5")){
            System.out.println("Syntax error with destination register");
        }
        try {
            Integer.parseInt(tokens[4]);
        } catch(NumberFormatException e){
            System.out.println("Syntax error with immediate value");
        }
    }
    private static void PrintBinary(String op, String firstReg, String secondReg, String destinationReg, int immediateVal){
        System.out.print("opcode: ");
        switch (op){
            case "add" -> System.out.println("00");
            case "sub" -> System.out.println("01");
            case "mul" -> System.out.println("10");
            case "div" -> System.out.println("11");
        }
        System.out.print("first reg: ");
        switch (firstReg){
            case "s0" -> System.out.println("000");
            case "r1" -> System.out.println("001");
            case "r2" -> System.out.println("010");
            case "r3" -> System.out.println("011");
            case "r4" -> System.out.println("100");
            case "r5" -> System.out.println("101");
        }
        System.out.print("second reg: ");
        switch (secondReg){
            case "s0" -> System.out.println("000");
            case "r1" -> System.out.println("001");
            case "r2" -> System.out.println("010");
            case "r3" -> System.out.println("011");
            case "r4" -> System.out.println("100");
            case "r5" -> System.out.println("101");
        }
        System.out.print("destination reg: ");
        switch (destinationReg){
            case "r1" -> System.out.println("001");
            case "r2" -> System.out.println("010");
            case "r3" -> System.out.println("011");
            case "r4" -> System.out.println("100");
            case "r5" -> System.out.println("101");
        }
        System.out.print("immediate value: ");
        String val_res = Integer.toBinaryString(immediateVal);
        String resultWithPadding = String.format("%12s", val_res).replaceAll(" ", "0");
        System.out.println(resultWithPadding);
    }
    private static void AddOperation(String firstReg, String secondReg, String destinationReg, int immediateVal){
        if (firstReg.equals("s0") && secondReg.equals("s0") && immediateVal != 0){ // add.s0.s0.r3.10 -> r3 = 10
            switch (destinationReg) {
                case "r1" -> Register.r1 = immediateVal;
                case "r2" -> Register.r2 = immediateVal;
                case "r3" -> Register.r3 = immediateVal;
                case "r4" -> Register.r4 = immediateVal;
                case "r5" -> Register.r5 = immediateVal;
            }
        }
        else if (!firstReg.equals("s0") && !secondReg.equals("s0") && immediateVal == 0){ //add.r1.r2.r3.0 -> r3 = r1 + r2
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r1 = Register.r1 + Register.r2;
                                case "r3" -> Register.r1 = Register.r1 + Register.r3;
                                case "r4" -> Register.r1 = Register.r1 + Register.r4;
                                case "r5" -> Register.r1 = Register.r1 + Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r2 + Register.r1;
                                case "r3" -> Register.r1 = Register.r2 + Register.r3;
                                case "r4" -> Register.r1 = Register.r2 + Register.r4;
                                case "r5" -> Register.r1 = Register.r2 + Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r3 + Register.r1;
                                case "r2" -> Register.r1 = Register.r3 + Register.r2;
                                case "r4" -> Register.r1 = Register.r3 + Register.r4;
                                case "r5" -> Register.r1 = Register.r3 + Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r4 + Register.r1;
                                case "r2" -> Register.r1 = Register.r4 + Register.r2;
                                case "r3" -> Register.r1 = Register.r4 + Register.r3;
                                case "r5" -> Register.r1 = Register.r4 + Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r5 + Register.r1;
                                case "r2" -> Register.r1 = Register.r5 + Register.r2;
                                case "r3" -> Register.r1 = Register.r5 + Register.r3;
                                case "r5" -> Register.r1 = Register.r5 + Register.r4;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                    case "r1":
                        switch (secondReg){
                            case "r2" -> Register.r2 = Register.r1 + Register.r2;
                            case "r3" -> Register.r2 = Register.r1 + Register.r3;
                            case "r4" -> Register.r2 = Register.r1 + Register.r4;
                            case "r5" -> Register.r2 = Register.r1 + Register.r5;
                        }
                        break;
                    case "r2":
                        switch (secondReg){
                            case "r1" -> Register.r2 = Register.r2 + Register.r1;
                            case "r3" -> Register.r2 = Register.r2 + Register.r3;
                            case "r4" -> Register.r2 = Register.r2 + Register.r4;
                            case "r5" -> Register.r2 = Register.r2 + Register.r5;
                        }
                        break;
                    case "r3":
                        switch (secondReg){
                            case "r1" -> Register.r2 = Register.r3 + Register.r1;
                            case "r2" -> Register.r2 = Register.r3 + Register.r2;
                            case "r4" -> Register.r2 = Register.r3 + Register.r4;
                            case "r5" -> Register.r2 = Register.r3 + Register.r5;
                        }
                        break;
                    case "r4":
                        switch (secondReg){
                            case "r1" -> Register.r2 = Register.r4 + Register.r1;
                            case "r2" -> Register.r2 = Register.r4 + Register.r2;
                            case "r3" -> Register.r2 = Register.r4 + Register.r3;
                            case "r5" -> Register.r2 = Register.r4 + Register.r5;
                        }
                        break;
                    case "r5":
                        switch (secondReg){
                            case "r1" -> Register.r2 = Register.r5 + Register.r1;
                            case "r2" -> Register.r2 = Register.r5 + Register.r2;
                            case "r3" -> Register.r2 = Register.r5 + Register.r3;
                            case "r5" -> Register.r2 = Register.r5 + Register.r4;
                        }
                        break;
                }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r3 = Register.r1 + Register.r2;
                                case "r3" -> Register.r3 = Register.r1 + Register.r3;
                                case "r4" -> Register.r3 = Register.r1 + Register.r4;
                                case "r5" -> Register.r3 = Register.r1 + Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r2 + Register.r1;
                                case "r3" -> Register.r3 = Register.r2 + Register.r3;
                                case "r4" -> Register.r3 = Register.r2 + Register.r4;
                                case "r5" -> Register.r3 = Register.r2 + Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r3 + Register.r1;
                                case "r2" -> Register.r3 = Register.r3 + Register.r2;
                                case "r4" -> Register.r3 = Register.r3 + Register.r4;
                                case "r5" -> Register.r3 = Register.r3 + Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r4 + Register.r1;
                                case "r2" -> Register.r3 = Register.r4 + Register.r2;
                                case "r3" -> Register.r3 = Register.r4 + Register.r3;
                                case "r5" -> Register.r3 = Register.r4 + Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r5 + Register.r1;
                                case "r2" -> Register.r3 = Register.r5 + Register.r2;
                                case "r3" -> Register.r3 = Register.r5 + Register.r3;
                                case "r5" -> Register.r3 = Register.r5 + Register.r4;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r4 = Register.r1 + Register.r2;
                                case "r3" -> Register.r4 = Register.r1 + Register.r3;
                                case "r4" -> Register.r4 = Register.r1 + Register.r4;
                                case "r5" -> Register.r4 = Register.r1 + Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r2 + Register.r1;
                                case "r3" -> Register.r4 = Register.r2 + Register.r3;
                                case "r4" -> Register.r4 = Register.r2 + Register.r4;
                                case "r5" -> Register.r4 = Register.r2 + Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r3 + Register.r1;
                                case "r2" -> Register.r4 = Register.r3 + Register.r2;
                                case "r4" -> Register.r4 = Register.r3 + Register.r4;
                                case "r5" -> Register.r4 = Register.r3 + Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r4 + Register.r1;
                                case "r2" -> Register.r4 = Register.r4 + Register.r2;
                                case "r3" -> Register.r4 = Register.r4 + Register.r3;
                                case "r5" -> Register.r4 = Register.r4 + Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r5 + Register.r1;
                                case "r2" -> Register.r4 = Register.r5 + Register.r2;
                                case "r3" -> Register.r4 = Register.r5 + Register.r3;
                                case "r5" -> Register.r4 = Register.r5 + Register.r4;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r5 = Register.r1 + Register.r2;
                                case "r3" -> Register.r5 = Register.r1 + Register.r3;
                                case "r4" -> Register.r5 = Register.r1 + Register.r4;
                                case "r5" -> Register.r5 = Register.r1 + Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r2 + Register.r1;
                                case "r3" -> Register.r5 = Register.r2 + Register.r3;
                                case "r4" -> Register.r5 = Register.r2 + Register.r4;
                                case "r5" -> Register.r5 = Register.r2 + Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r3 + Register.r1;
                                case "r2" -> Register.r5 = Register.r3 + Register.r2;
                                case "r4" -> Register.r5 = Register.r3 + Register.r4;
                                case "r5" -> Register.r5 = Register.r3 + Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r4 + Register.r1;
                                case "r2" -> Register.r5 = Register.r4 + Register.r2;
                                case "r3" -> Register.r5 = Register.r4 + Register.r3;
                                case "r5" -> Register.r5 = Register.r4 + Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r5 + Register.r1;
                                case "r2" -> Register.r5 = Register.r5 + Register.r2;
                                case "r3" -> Register.r5 = Register.r5 + Register.r3;
                                case "r5" -> Register.r5 = Register.r5 + Register.r4;
                            }
                            break;
                    }
                    break;
            }
        }
    }
    private static void SubOperation(String firstReg, String secondReg, String destinationReg, int immediateVal){
        if (!firstReg.equals("s0") && !secondReg.equals("s0") && immediateVal == 0){ // sub.r1.r2.r3.0 -> r3 = r1 - r2
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r1 = Register.r1 - Register.r2;
                                case "r3" -> Register.r1 = Register.r1 - Register.r3;
                                case "r4" -> Register.r1 = Register.r1 - Register.r4;
                                case "r5" -> Register.r1 = Register.r1 - Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r2 - Register.r1;
                                case "r3" -> Register.r1 = Register.r2 - Register.r3;
                                case "r4" -> Register.r1 = Register.r2 - Register.r4;
                                case "r5" -> Register.r1 = Register.r2 - Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r3 - Register.r1;
                                case "r2" -> Register.r1 = Register.r3 - Register.r2;
                                case "r4" -> Register.r1 = Register.r3 - Register.r4;
                                case "r5" -> Register.r1 = Register.r3 - Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r4 - Register.r1;
                                case "r2" -> Register.r1 = Register.r4 - Register.r2;
                                case "r3" -> Register.r1 = Register.r4 - Register.r3;
                                case "r5" -> Register.r1 = Register.r4 - Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r5 - Register.r1;
                                case "r2" -> Register.r1 = Register.r5 - Register.r2;
                                case "r3" -> Register.r1 = Register.r5 - Register.r3;
                                case "r5" -> Register.r1 = Register.r5 - Register.r4;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r2 = Register.r1 - Register.r2;
                                case "r3" -> Register.r2 = Register.r1 - Register.r3;
                                case "r4" -> Register.r2 = Register.r1 - Register.r4;
                                case "r5" -> Register.r2 = Register.r1 - Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r2 - Register.r1;
                                case "r3" -> Register.r2 = Register.r2 - Register.r3;
                                case "r4" -> Register.r2 = Register.r2 - Register.r4;
                                case "r5" -> Register.r2 = Register.r2 - Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r3 - Register.r1;
                                case "r2" -> Register.r2 = Register.r3 - Register.r2;
                                case "r4" -> Register.r2 = Register.r3 - Register.r4;
                                case "r5" -> Register.r2 = Register.r3 - Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r4 - Register.r1;
                                case "r2" -> Register.r2 = Register.r4 - Register.r2;
                                case "r3" -> Register.r2 = Register.r4 - Register.r3;
                                case "r5" -> Register.r2 = Register.r4 - Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r5 - Register.r1;
                                case "r2" -> Register.r2 = Register.r5 - Register.r2;
                                case "r3" -> Register.r2 = Register.r5 - Register.r3;
                                case "r5" -> Register.r2 = Register.r5 - Register.r4;
                            }
                            break;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r3 = Register.r1 - Register.r2;
                                case "r3" -> Register.r3 = Register.r1 - Register.r3;
                                case "r4" -> Register.r3 = Register.r1 - Register.r4;
                                case "r5" -> Register.r3 = Register.r1 - Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r2 - Register.r1;
                                case "r3" -> Register.r3 = Register.r2 - Register.r3;
                                case "r4" -> Register.r3 = Register.r2 - Register.r4;
                                case "r5" -> Register.r3 = Register.r2 - Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r3 - Register.r1;
                                case "r2" -> Register.r3 = Register.r3 - Register.r2;
                                case "r4" -> Register.r3 = Register.r3 - Register.r4;
                                case "r5" -> Register.r3 = Register.r3 - Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r4 - Register.r1;
                                case "r2" -> Register.r3 = Register.r4 - Register.r2;
                                case "r3" -> Register.r3 = Register.r4 - Register.r3;
                                case "r5" -> Register.r3 = Register.r4 - Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r5 - Register.r1;
                                case "r2" -> Register.r3 = Register.r5 - Register.r2;
                                case "r3" -> Register.r3 = Register.r5 - Register.r3;
                                case "r5" -> Register.r3 = Register.r5 - Register.r4;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r4 = Register.r1 - Register.r2;
                                case "r3" -> Register.r4 = Register.r1 - Register.r3;
                                case "r4" -> Register.r4 = Register.r1 - Register.r4;
                                case "r5" -> Register.r4 = Register.r1 - Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r2 - Register.r1;
                                case "r3" -> Register.r4 = Register.r2 - Register.r3;
                                case "r4" -> Register.r4 = Register.r2 - Register.r4;
                                case "r5" -> Register.r4 = Register.r2 - Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r3 - Register.r1;
                                case "r2" -> Register.r4 = Register.r3 - Register.r2;
                                case "r4" -> Register.r4 = Register.r3 - Register.r4;
                                case "r5" -> Register.r4 = Register.r3 - Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r4 - Register.r1;
                                case "r2" -> Register.r4 = Register.r4 - Register.r2;
                                case "r3" -> Register.r4 = Register.r4 - Register.r3;
                                case "r5" -> Register.r4 = Register.r4 - Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r5 - Register.r1;
                                case "r2" -> Register.r4 = Register.r5 - Register.r2;
                                case "r3" -> Register.r4 = Register.r5 - Register.r3;
                                case "r5" -> Register.r4 = Register.r5 - Register.r4;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r5 = Register.r1 - Register.r2;
                                case "r3" -> Register.r5 = Register.r1 - Register.r3;
                                case "r4" -> Register.r5 = Register.r1 - Register.r4;
                                case "r5" -> Register.r5 = Register.r1 - Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r2 - Register.r1;
                                case "r3" -> Register.r5 = Register.r2 - Register.r3;
                                case "r4" -> Register.r5 = Register.r2 - Register.r4;
                                case "r5" -> Register.r5 = Register.r2 - Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r3 - Register.r1;
                                case "r2" -> Register.r5 = Register.r3 - Register.r2;
                                case "r4" -> Register.r5 = Register.r3 - Register.r4;
                                case "r5" -> Register.r5 = Register.r3 - Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r4 - Register.r1;
                                case "r2" -> Register.r5 = Register.r4 - Register.r2;
                                case "r3" -> Register.r5 = Register.r4 - Register.r3;
                                case "r5" -> Register.r5 = Register.r4 - Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r5 - Register.r1;
                                case "r2" -> Register.r5 = Register.r5 - Register.r2;
                                case "r3" -> Register.r5 = Register.r5 - Register.r3;
                                case "r5" -> Register.r5 = Register.r5 - Register.r4;
                            }
                            break;
                    }
                    break;
            }
        }
    }
    private static void MulOperation(String firstReg, String secondReg, String destinationReg, int immediateVal) {
        if (!firstReg.equals("s0") && !secondReg.equals("s0") && immediateVal == 0) { // mul.r1.r2.r3.0 -> r3 = r1 * r2
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r1 = Register.r1 * Register.r2;
                                case "r3" -> Register.r1 = Register.r1 * Register.r3;
                                case "r4" -> Register.r1 = Register.r1 * Register.r4;
                                case "r5" -> Register.r1 = Register.r1 * Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r2 * Register.r1;
                                case "r3" -> Register.r1 = Register.r2 * Register.r3;
                                case "r4" -> Register.r1 = Register.r2 * Register.r4;
                                case "r5" -> Register.r1 = Register.r2 * Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r3 * Register.r1;
                                case "r2" -> Register.r1 = Register.r3 * Register.r2;
                                case "r4" -> Register.r1 = Register.r3 * Register.r4;
                                case "r5" -> Register.r1 = Register.r3 * Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r4 * Register.r1;
                                case "r2" -> Register.r1 = Register.r4 * Register.r2;
                                case "r3" -> Register.r1 = Register.r4 * Register.r3;
                                case "r5" -> Register.r1 = Register.r4 * Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r5 * Register.r1;
                                case "r2" -> Register.r1 = Register.r5 * Register.r2;
                                case "r3" -> Register.r1 = Register.r5 * Register.r3;
                                case "r5" -> Register.r1 = Register.r5 * Register.r4;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r2 = Register.r1 * Register.r2;
                                case "r3" -> Register.r2 = Register.r1 * Register.r3;
                                case "r4" -> Register.r2 = Register.r1 * Register.r4;
                                case "r5" -> Register.r2 = Register.r1 * Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r2 * Register.r1;
                                case "r3" -> Register.r2 = Register.r2 * Register.r3;
                                case "r4" -> Register.r2 = Register.r2 * Register.r4;
                                case "r5" -> Register.r2 = Register.r2 * Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r3 * Register.r1;
                                case "r2" -> Register.r2 = Register.r3 * Register.r2;
                                case "r4" -> Register.r2 = Register.r3 * Register.r4;
                                case "r5" -> Register.r2 = Register.r3 * Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r4 * Register.r1;
                                case "r2" -> Register.r2 = Register.r4 * Register.r2;
                                case "r3" -> Register.r2 = Register.r4 * Register.r3;
                                case "r5" -> Register.r2 = Register.r4 * Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r5 * Register.r1;
                                case "r2" -> Register.r2 = Register.r5 * Register.r2;
                                case "r3" -> Register.r2 = Register.r5 * Register.r3;
                                case "r5" -> Register.r2 = Register.r5 * Register.r4;
                            }
                            break;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r3 = Register.r1 * Register.r2;
                                case "r3" -> Register.r3 = Register.r1 * Register.r3;
                                case "r4" -> Register.r3 = Register.r1 * Register.r4;
                                case "r5" -> Register.r3 = Register.r1 * Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r2 * Register.r1;
                                case "r3" -> Register.r3 = Register.r2 * Register.r3;
                                case "r4" -> Register.r3 = Register.r2 * Register.r4;
                                case "r5" -> Register.r3 = Register.r2 * Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r3 * Register.r1;
                                case "r2" -> Register.r3 = Register.r3 * Register.r2;
                                case "r4" -> Register.r3 = Register.r3 * Register.r4;
                                case "r5" -> Register.r3 = Register.r3 * Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r4 * Register.r1;
                                case "r2" -> Register.r3 = Register.r4 * Register.r2;
                                case "r3" -> Register.r3 = Register.r4 * Register.r3;
                                case "r5" -> Register.r3 = Register.r4 * Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r5 * Register.r1;
                                case "r2" -> Register.r3 = Register.r5 * Register.r2;
                                case "r3" -> Register.r3 = Register.r5 * Register.r3;
                                case "r5" -> Register.r3 = Register.r5 * Register.r4;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r4 = Register.r1 * Register.r2;
                                case "r3" -> Register.r4 = Register.r1 * Register.r3;
                                case "r4" -> Register.r4 = Register.r1 * Register.r4;
                                case "r5" -> Register.r4 = Register.r1 * Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r2 * Register.r1;
                                case "r3" -> Register.r4 = Register.r2 * Register.r3;
                                case "r4" -> Register.r4 = Register.r2 * Register.r4;
                                case "r5" -> Register.r4 = Register.r2 * Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r3 * Register.r1;
                                case "r2" -> Register.r4 = Register.r3 * Register.r2;
                                case "r4" -> Register.r4 = Register.r3 * Register.r4;
                                case "r5" -> Register.r4 = Register.r3 * Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r4 * Register.r1;
                                case "r2" -> Register.r4 = Register.r4 * Register.r2;
                                case "r3" -> Register.r4 = Register.r4 * Register.r3;
                                case "r5" -> Register.r4 = Register.r4 * Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r5 * Register.r1;
                                case "r2" -> Register.r4 = Register.r5 * Register.r2;
                                case "r3" -> Register.r4 = Register.r5 * Register.r3;
                                case "r5" -> Register.r4 = Register.r5 * Register.r4;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r5 = Register.r1 * Register.r2;
                                case "r3" -> Register.r5 = Register.r1 * Register.r3;
                                case "r4" -> Register.r5 = Register.r1 * Register.r4;
                                case "r5" -> Register.r5 = Register.r1 * Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r2 * Register.r1;
                                case "r3" -> Register.r5 = Register.r2 * Register.r3;
                                case "r4" -> Register.r5 = Register.r2 * Register.r4;
                                case "r5" -> Register.r5 = Register.r2 * Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r3 * Register.r1;
                                case "r2" -> Register.r5 = Register.r3 * Register.r2;
                                case "r4" -> Register.r5 = Register.r3 * Register.r4;
                                case "r5" -> Register.r5 = Register.r3 * Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r4 * Register.r1;
                                case "r2" -> Register.r5 = Register.r4 * Register.r2;
                                case "r3" -> Register.r5 = Register.r4 * Register.r3;
                                case "r5" -> Register.r5 = Register.r4 * Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r5 * Register.r1;
                                case "r2" -> Register.r5 = Register.r5 * Register.r2;
                                case "r3" -> Register.r5 = Register.r5 * Register.r3;
                                case "r5" -> Register.r5 = Register.r5 * Register.r4;
                            }
                            break;
                    }
                    break;
            }
        }
    }
    private static void DivOperation(String firstReg, String secondReg, String destinationReg, int immediateVal) {
        if (secondReg.equals("s0")){
            System.out.println("Can't divided by 0!");
            System.exit(-1);
        }
        else if (!firstReg.equals("s0") && !secondReg.equals("s0") && immediateVal == 0) { // mul.r1.r2.r3.0 -> r3 = r1 / r2
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r1 = Register.r1 / Register.r2;
                                case "r3" -> Register.r1 = Register.r1 / Register.r3;
                                case "r4" -> Register.r1 = Register.r1 / Register.r4;
                                case "r5" -> Register.r1 = Register.r1 / Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r2 / Register.r1;
                                case "r3" -> Register.r1 = Register.r2 / Register.r3;
                                case "r4" -> Register.r1 = Register.r2 / Register.r4;
                                case "r5" -> Register.r1 = Register.r2 / Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r3 / Register.r1;
                                case "r2" -> Register.r1 = Register.r3 / Register.r2;
                                case "r4" -> Register.r1 = Register.r3 / Register.r4;
                                case "r5" -> Register.r1 = Register.r3 / Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r4 / Register.r1;
                                case "r2" -> Register.r1 = Register.r4 / Register.r2;
                                case "r3" -> Register.r1 = Register.r4 / Register.r3;
                                case "r5" -> Register.r1 = Register.r4 / Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r5 / Register.r1;
                                case "r2" -> Register.r1 = Register.r5 / Register.r2;
                                case "r3" -> Register.r1 = Register.r5 / Register.r3;
                                case "r5" -> Register.r1 = Register.r5 / Register.r4;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r2 = Register.r1 / Register.r2;
                                case "r3" -> Register.r2 = Register.r1 / Register.r3;
                                case "r4" -> Register.r2 = Register.r1 / Register.r4;
                                case "r5" -> Register.r2 = Register.r1 / Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r2 / Register.r1;
                                case "r3" -> Register.r2 = Register.r2 / Register.r3;
                                case "r4" -> Register.r2 = Register.r2 / Register.r4;
                                case "r5" -> Register.r2 = Register.r2 / Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r3 / Register.r1;
                                case "r2" -> Register.r2 = Register.r3 / Register.r2;
                                case "r4" -> Register.r2 = Register.r3 / Register.r4;
                                case "r5" -> Register.r2 = Register.r3 / Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r4 / Register.r1;
                                case "r2" -> Register.r2 = Register.r4 / Register.r2;
                                case "r3" -> Register.r2 = Register.r4 / Register.r3;
                                case "r5" -> Register.r2 = Register.r4 / Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r5 / Register.r1;
                                case "r2" -> Register.r2 = Register.r5 / Register.r2;
                                case "r3" -> Register.r2 = Register.r5 / Register.r3;
                                case "r5" -> Register.r2 = Register.r5 / Register.r4;
                            }
                            break;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r3 = Register.r1 / Register.r2;
                                case "r3" -> Register.r3 = Register.r1 / Register.r3;
                                case "r4" -> Register.r3 = Register.r1 / Register.r4;
                                case "r5" -> Register.r3 = Register.r1 / Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r2 / Register.r1;
                                case "r3" -> Register.r3 = Register.r2 / Register.r3;
                                case "r4" -> Register.r3 = Register.r2 / Register.r4;
                                case "r5" -> Register.r3 = Register.r2 / Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r3 / Register.r1;
                                case "r2" -> Register.r3 = Register.r3 / Register.r2;
                                case "r4" -> Register.r3 = Register.r3 / Register.r4;
                                case "r5" -> Register.r3 = Register.r3 / Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r4 / Register.r1;
                                case "r2" -> Register.r3 = Register.r4 / Register.r2;
                                case "r3" -> Register.r3 = Register.r4 / Register.r3;
                                case "r5" -> Register.r3 = Register.r4 / Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r5 / Register.r1;
                                case "r2" -> Register.r3 = Register.r5 / Register.r2;
                                case "r3" -> Register.r3 = Register.r5 / Register.r3;
                                case "r5" -> Register.r3 = Register.r5 / Register.r4;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r4 = Register.r1 / Register.r2;
                                case "r3" -> Register.r4 = Register.r1 / Register.r3;
                                case "r4" -> Register.r4 = Register.r1 / Register.r4;
                                case "r5" -> Register.r4 = Register.r1 / Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r2 / Register.r1;
                                case "r3" -> Register.r4 = Register.r2 / Register.r3;
                                case "r4" -> Register.r4 = Register.r2 / Register.r4;
                                case "r5" -> Register.r4 = Register.r2 / Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r3 / Register.r1;
                                case "r2" -> Register.r4 = Register.r3 / Register.r2;
                                case "r4" -> Register.r4 = Register.r3 / Register.r4;
                                case "r5" -> Register.r4 = Register.r3 / Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r4 / Register.r1;
                                case "r2" -> Register.r4 = Register.r4 / Register.r2;
                                case "r3" -> Register.r4 = Register.r4 / Register.r3;
                                case "r5" -> Register.r4 = Register.r4 / Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r5 / Register.r1;
                                case "r2" -> Register.r4 = Register.r5 / Register.r2;
                                case "r3" -> Register.r4 = Register.r5 / Register.r3;
                                case "r5" -> Register.r4 = Register.r5 / Register.r4;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r5 = Register.r1 / Register.r2;
                                case "r3" -> Register.r5 = Register.r1 / Register.r3;
                                case "r4" -> Register.r5 = Register.r1 / Register.r4;
                                case "r5" -> Register.r5 = Register.r1 / Register.r5;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r2 / Register.r1;
                                case "r3" -> Register.r5 = Register.r2 / Register.r3;
                                case "r4" -> Register.r5 = Register.r2 / Register.r4;
                                case "r5" -> Register.r5 = Register.r2 / Register.r5;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r3 / Register.r1;
                                case "r2" -> Register.r5 = Register.r3 / Register.r2;
                                case "r4" -> Register.r5 = Register.r3 / Register.r4;
                                case "r5" -> Register.r5 = Register.r3 / Register.r5;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r4 / Register.r1;
                                case "r2" -> Register.r5 = Register.r4 / Register.r2;
                                case "r3" -> Register.r5 = Register.r4 / Register.r3;
                                case "r5" -> Register.r5 = Register.r4 / Register.r5;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r5 / Register.r1;
                                case "r2" -> Register.r5 = Register.r5 / Register.r2;
                                case "r3" -> Register.r5 = Register.r5 / Register.r3;
                                case "r5" -> Register.r5 = Register.r5 / Register.r4;
                            }
                            break;
                    }
                    break;
            }
        }
    }
}
