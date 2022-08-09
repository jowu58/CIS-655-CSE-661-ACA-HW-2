package syr;


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
        Register.r1 = 1;
        Register.r2 = 2;
        Register.r3 = 3;
        String s = "sub.r3.r2.r5.1";
        String lowercase = s.toLowerCase(); // lower case string for instruction
        String[] tokens = lowercase.split("\\."); // break string into token
        boolean res = CheckSyntax(lowercase); // check if instruction syntax is correct
        System.out.println("Syntax is " + res);
        String operation = tokens[0];
        switch (operation) { // switch case base on instruction operation
            case "add" -> AddOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
            case "sub" -> SubOperation(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]));
            case "mul" -> System.out.println("mul");
            case "div" -> System.out.println("div");
        }
        System.out.println("s0: " + Register.s0);
        System.out.println("r1: " + Register.r1);
        System.out.println("r2: " + Register.r2);
        System.out.println("r3: " + Register.r3);
        System.out.println("r4: " + Register.r4);
        System.out.println("r5: " + Register.r5);

    }
    private static boolean CheckSyntax(String syntax) {
        String[] tokens = syntax.split("\\.");
        if (tokens.length > 5) {
            System.out.println("Syntax error");
            return false;
        }
        if (!tokens[0].equals("add") && !tokens[0].equals("sub") && !tokens[0].equals("mul") && !tokens[0].equals("div")){
            System.out.println("Syntax error with instruction code");
            return false;
        }
        if (!tokens[1].equals("s0") && !tokens[1].equals("r1") && !tokens[1].equals("r2") &&
                !tokens[1].equals("r3") && !tokens[1].equals("r4") && !tokens[1].equals("r5")){
            System.out.println("Syntax error with first register");
            return false;
        }
        if (!tokens[2].equals("s0") && !tokens[2].equals("r1") && !tokens[2].equals("r2") &&
                !tokens[2].equals("r3") && !tokens[2].equals("r4") && !tokens[2].equals("r5")){
            System.out.println("Syntax error with second register");
            return false;
        }
        if (!tokens[3].equals("r1") && !tokens[3].equals("r2") && !tokens[3].equals("r3") &&
                !tokens[3].equals("r4") && !tokens[3].equals("r5")){
            System.out.println("Syntax error with destination register");
            return false;
        }
        try {
            Integer.parseInt(tokens[4]);
        } catch(NumberFormatException e){
            System.out.println("Syntax error with immediate value");
            return false;
        }
        return true;
    }
    private static void AddOperation(String firstReg, String secondReg, String destinationReg, int immediateVal){
        if (firstReg.equals("s0") && secondReg.equals("s0")){ // add.s0.s0.r3.10 -> r3 = 10
            switch (destinationReg) {
                case "r1" -> Register.r1 = immediateVal;
                case "r2" -> Register.r2 = immediateVal;
                case "r3" -> Register.r3 = immediateVal;
                case "r4" -> Register.r4 = immediateVal;
                case "r5" -> Register.r5 = immediateVal;
            }
        }
        else if (!firstReg.equals("s0") && secondReg.equals("s0") && immediateVal != 0){ // add.r1.s0.r3.10 -> r3 = r1 + 10
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r2" -> Register.r1 = immediateVal + Register.r2;
                        case "r3" -> Register.r1 = immediateVal + Register.r3;
                        case "r4" -> Register.r1 = immediateVal + Register.r4;
                        case "r5" -> Register.r1 = immediateVal + Register.r5;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1" -> Register.r2 = immediateVal + Register.r1;
                        case "r3" -> Register.r2 = immediateVal + Register.r3;
                        case "r4" -> Register.r2 = immediateVal + Register.r4;
                        case "r5" -> Register.r2 = immediateVal + Register.r5;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1" -> Register.r3 = immediateVal + Register.r1;
                        case "r2" -> Register.r3 = immediateVal + Register.r3;
                        case "r4" -> Register.r3 = immediateVal + Register.r4;
                        case "r5" -> Register.r3 = immediateVal + Register.r5;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1" -> Register.r4 = immediateVal + Register.r1;
                        case "r2" -> Register.r4 = immediateVal + Register.r3;
                        case "r3" -> Register.r4 = immediateVal + Register.r4;
                        case "r5" -> Register.r4 = immediateVal + Register.r5;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1" -> Register.r5 = immediateVal + Register.r1;
                        case "r2" -> Register.r5 = immediateVal + Register.r3;
                        case "r3" -> Register.r5 = immediateVal + Register.r4;
                        case "r4" -> Register.r5 = immediateVal + Register.r5;
                    }
                    break;
            }
        }
        else if (firstReg.equals("s0") && immediateVal != 0){ // add.s0.r2.r3.10 -> r3 = r2 + 10
            switch (destinationReg) {
                case "r1":
                    switch (secondReg) {
                        case "r2" -> Register.r1 = immediateVal + Register.r2;
                        case "r3" -> Register.r1 = immediateVal + Register.r3;
                        case "r4" -> Register.r1 = immediateVal + Register.r4;
                        case "r5" -> Register.r1 = immediateVal + Register.r5;
                    }
                    break;
                case "r2":
                    switch (secondReg) {
                        case "r1" -> Register.r2 = immediateVal + Register.r1;
                        case "r3" -> Register.r2 = immediateVal + Register.r3;
                        case "r4" -> Register.r2 = immediateVal + Register.r4;
                        case "r5" -> Register.r2 = immediateVal + Register.r5;
                    }
                    break;
                case "r3":
                    switch (secondReg) {
                        case "r1" -> Register.r3 = immediateVal + Register.r1;
                        case "r2" -> Register.r3 = immediateVal + Register.r2;
                        case "r4" -> Register.r3 = immediateVal + Register.r4;
                        case "r5" -> Register.r3 = immediateVal + Register.r5;
                    }
                    break;
                case "r4":
                    switch (secondReg) {
                        case "r1" -> Register.r4 = immediateVal + Register.r1;
                        case "r2" -> Register.r4 = immediateVal + Register.r2;
                        case "r3" -> Register.r4 = immediateVal + Register.r3;
                        case "r5" -> Register.r4 = immediateVal + Register.r5;
                    }
                    break;
                case "r5":
                    switch (secondReg) {
                        case "r1" -> Register.r5 = immediateVal + Register.r2;
                        case "r2" -> Register.r5 = immediateVal + Register.r3;
                        case "r3" -> Register.r5 = immediateVal + Register.r4;
                        case "r4" -> Register.r5 = immediateVal + Register.r5;
                    }
                    break;
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
        else if (!firstReg.equals("s0") && !secondReg.equals("s0")){ //add.r1.r2.r3.10 -> r3 = r1 + r2 +10
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r1 = Register.r1 + Register.r2 + immediateVal;
                                case "r3" -> Register.r1 = Register.r1 + Register.r3 + immediateVal;
                                case "r4" -> Register.r1 = Register.r1 + Register.r4 + immediateVal;
                                case "r5" -> Register.r1 = Register.r1 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r2 + Register.r1 + immediateVal;
                                case "r3" -> Register.r1 = Register.r2 + Register.r3 + immediateVal;
                                case "r4" -> Register.r1 = Register.r2 + Register.r4 + immediateVal;
                                case "r5" -> Register.r1 = Register.r2 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r3 + Register.r1 + immediateVal;
                                case "r2" -> Register.r1 = Register.r3 + Register.r2 + immediateVal;
                                case "r4" -> Register.r1 = Register.r3 + Register.r4 + immediateVal;
                                case "r5" -> Register.r1 = Register.r3 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r4 + Register.r1 + immediateVal;
                                case "r2" -> Register.r1 = Register.r4 + Register.r2 + immediateVal;
                                case "r3" -> Register.r1 = Register.r4 + Register.r3 + immediateVal;
                                case "r5" -> Register.r1 = Register.r4 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r1 = Register.r5 + Register.r1 + immediateVal;
                                case "r2" -> Register.r1 = Register.r5 + Register.r2 + immediateVal;
                                case "r3" -> Register.r1 = Register.r5 + Register.r3 + immediateVal;
                                case "r5" -> Register.r1 = Register.r5 + Register.r4 + immediateVal;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r2 = Register.r1 + Register.r2 + immediateVal;
                                case "r3" -> Register.r2 = Register.r1 + Register.r3 + immediateVal;
                                case "r4" -> Register.r2 = Register.r1 + Register.r4 + immediateVal;
                                case "r5" -> Register.r2 = Register.r1 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r2 + Register.r1 + immediateVal;
                                case "r3" -> Register.r2 = Register.r2 + Register.r3 + immediateVal;
                                case "r4" -> Register.r2 = Register.r2 + Register.r4 + immediateVal;
                                case "r5" -> Register.r2 = Register.r2 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r3 + Register.r1 + immediateVal;
                                case "r2" -> Register.r2 = Register.r3 + Register.r2 + immediateVal;
                                case "r4" -> Register.r2 = Register.r3 + Register.r4 + immediateVal;
                                case "r5" -> Register.r2 = Register.r3 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r4 + Register.r1 + immediateVal;
                                case "r2" -> Register.r2 = Register.r4 + Register.r2 + immediateVal;
                                case "r3" -> Register.r2 = Register.r4 + Register.r3 + immediateVal;
                                case "r5" -> Register.r2 = Register.r4 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r2 = Register.r5 + Register.r1 + immediateVal;
                                case "r2" -> Register.r2 = Register.r5 + Register.r2 + immediateVal;
                                case "r3" -> Register.r2 = Register.r5 + Register.r3 + immediateVal;
                                case "r5" -> Register.r2 = Register.r5 + Register.r4 + immediateVal;
                            }
                            break;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r3 = Register.r1 + Register.r2 + immediateVal;
                                case "r3" -> Register.r3 = Register.r1 + Register.r3 + immediateVal;
                                case "r4" -> Register.r3 = Register.r1 + Register.r4 + immediateVal;
                                case "r5" -> Register.r3 = Register.r1 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r2 + Register.r1 + immediateVal;
                                case "r3" -> Register.r3 = Register.r2 + Register.r3 + immediateVal;
                                case "r4" -> Register.r3 = Register.r2 + Register.r4 + immediateVal;
                                case "r5" -> Register.r3 = Register.r2 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r3 + Register.r1 + immediateVal;
                                case "r2" -> Register.r3 = Register.r3 + Register.r2 + immediateVal;
                                case "r4" -> Register.r3 = Register.r3 + Register.r4 + immediateVal;
                                case "r5" -> Register.r3 = Register.r3 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r4 + Register.r1 + immediateVal;
                                case "r2" -> Register.r3 = Register.r4 + Register.r2 + immediateVal;
                                case "r3" -> Register.r3 = Register.r4 + Register.r3 + immediateVal;
                                case "r5" -> Register.r3 = Register.r4 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r3 = Register.r5 + Register.r1 + immediateVal;
                                case "r2" -> Register.r3 = Register.r5 + Register.r2 + immediateVal;
                                case "r3" -> Register.r3 = Register.r5 + Register.r3 + immediateVal;
                                case "r5" -> Register.r3 = Register.r5 + Register.r4 + immediateVal;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r4 = Register.r1 + Register.r2 + immediateVal;
                                case "r3" -> Register.r4 = Register.r1 + Register.r3 + immediateVal;
                                case "r4" -> Register.r4 = Register.r1 + Register.r4 + immediateVal;
                                case "r5" -> Register.r4 = Register.r1 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r2 + Register.r1 + immediateVal;
                                case "r3" -> Register.r4 = Register.r2 + Register.r3 + immediateVal;
                                case "r4" -> Register.r4 = Register.r2 + Register.r4 + immediateVal;
                                case "r5" -> Register.r4 = Register.r2 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r3 + Register.r1 + immediateVal;
                                case "r2" -> Register.r4 = Register.r3 + Register.r2 + immediateVal;
                                case "r4" -> Register.r4 = Register.r3 + Register.r4 + immediateVal;
                                case "r5" -> Register.r4 = Register.r3 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r4 + Register.r1 + immediateVal;
                                case "r2" -> Register.r4 = Register.r4 + Register.r2 + immediateVal;
                                case "r3" -> Register.r4 = Register.r4 + Register.r3 + immediateVal;
                                case "r5" -> Register.r4 = Register.r4 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r4 = Register.r5 + Register.r1 + immediateVal;
                                case "r2" -> Register.r4 = Register.r5 + Register.r2 + immediateVal;
                                case "r3" -> Register.r4 = Register.r5 + Register.r3 + immediateVal;
                                case "r5" -> Register.r4 = Register.r5 + Register.r4 + immediateVal;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg){
                                case "r2" -> Register.r5 = Register.r1 + Register.r2 + immediateVal;
                                case "r3" -> Register.r5 = Register.r1 + Register.r3 + immediateVal;
                                case "r4" -> Register.r5 = Register.r1 + Register.r4 + immediateVal;
                                case "r5" -> Register.r5 = Register.r1 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r2 + Register.r1 + immediateVal;
                                case "r3" -> Register.r5 = Register.r2 + Register.r3 + immediateVal;
                                case "r4" -> Register.r5 = Register.r2 + Register.r4 + immediateVal;
                                case "r5" -> Register.r5 = Register.r2 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r3 + Register.r1 + immediateVal;
                                case "r2" -> Register.r5 = Register.r3 + Register.r2 + immediateVal;
                                case "r4" -> Register.r5 = Register.r3 + Register.r4 + immediateVal;
                                case "r5" -> Register.r5 = Register.r3 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r4 + Register.r1 + immediateVal;
                                case "r2" -> Register.r5 = Register.r4 + Register.r2 + immediateVal;
                                case "r3" -> Register.r5 = Register.r4 + Register.r3 + immediateVal;
                                case "r5" -> Register.r5 = Register.r4 + Register.r5 + immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg){
                                case "r1" -> Register.r5 = Register.r5 + Register.r1 + immediateVal;
                                case "r2" -> Register.r5 = Register.r5 + Register.r2 + immediateVal;
                                case "r3" -> Register.r5 = Register.r5 + Register.r3 + immediateVal;
                                case "r5" -> Register.r5 = Register.r5 + Register.r4 + immediateVal;
                            }
                            break;
                    }
                    break;
            }
        }
        else if (!firstReg.equals("s0")){ // add.r1.s0.r3.0 -> r3 = r1
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r2" -> Register.r1 = Register.r2;
                        case "r3" -> Register.r1 = Register.r3;
                        case "r4" -> Register.r1 = Register.r4;
                        case "r5" -> Register.r1 = Register.r5;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1" -> Register.r2 = Register.r1;
                        case "r3" -> Register.r2 = Register.r3;
                        case "r4" -> Register.r2 = Register.r4;
                        case "r5" -> Register.r2 = Register.r5;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1" -> Register.r3 = Register.r1;
                        case "r2" -> Register.r3 = Register.r2;
                        case "r4" -> Register.r3 = Register.r4;
                        case "r5" -> Register.r3 = Register.r5;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1" -> Register.r4 = Register.r1;
                        case "r2" -> Register.r4 = Register.r2;
                        case "r3" -> Register.r4 = Register.r3;
                        case "r5" -> Register.r4 = Register.r5;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1" -> Register.r5 = Register.r1;
                        case "r2" -> Register.r5 = Register.r2;
                        case "r3" -> Register.r5 = Register.r3;
                        case "r5" -> Register.r5 = Register.r4;
                    }
                    break;
            }
        }
        else {// add.s0.r2.r3.0 -> r3 = r2
            switch (destinationReg) {
                case "r1":
                    switch (secondReg) {
                        case "r2" -> Register.r1 += Register.r2;
                        case "r3" -> Register.r1 += Register.r3;
                        case "r4" -> Register.r1 += Register.r4;
                        case "r5" -> Register.r1 += Register.r5;
                    }
                    break;
                case "r2":
                    switch (secondReg) {
                        case "r1" -> Register.r2 += Register.r1;
                        case "r3" -> Register.r2 += Register.r3;
                        case "r4" -> Register.r2 += Register.r4;
                        case "r5" -> Register.r2 += Register.r5;
                    }
                    break;
                case "r3":
                    switch (secondReg) {
                        case "r1" -> Register.r3 += Register.r1;
                        case "r2" -> Register.r3 += Register.r2;
                        case "r4" -> Register.r3 += Register.r4;
                        case "r5" -> Register.r3 += Register.r5;
                    }
                    break;
                case "r4":
                    switch (secondReg) {
                        case "r1" -> Register.r4 += Register.r1;
                        case "r2" -> Register.r4 += Register.r2;
                        case "r3" -> Register.r4 += Register.r3;
                        case "r5" -> Register.r4 += Register.r5;
                    }
                    break;
                case "r5":
                    switch (secondReg) {
                        case "r1" -> Register.r5 += Register.r1;
                        case "r2" -> Register.r5 += Register.r2;
                        case "r3" -> Register.r5 += Register.r3;
                        case "r5" -> Register.r5 += Register.r4;
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
        else if (!firstReg.equals("s0") && !secondReg.equals("s0")) { // sub.r1.r2.r3.10 -> r3 = r1 - r2 - 10
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r1 = Register.r1 - Register.r2 - immediateVal;
                                case "r3" -> Register.r1 = Register.r1 - Register.r3 - immediateVal;
                                case "r4" -> Register.r1 = Register.r1 - Register.r4 - immediateVal;
                                case "r5" -> Register.r1 = Register.r1 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r2 - Register.r1 - immediateVal;
                                case "r3" -> Register.r1 = Register.r2 - Register.r3 - immediateVal;
                                case "r4" -> Register.r1 = Register.r2 - Register.r4 - immediateVal;
                                case "r5" -> Register.r1 = Register.r2 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r3 - Register.r1 - immediateVal;
                                case "r2" -> Register.r1 = Register.r3 - Register.r2 - immediateVal;
                                case "r4" -> Register.r1 = Register.r3 - Register.r4 - immediateVal;
                                case "r5" -> Register.r1 = Register.r3 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r4 - Register.r1 - immediateVal;
                                case "r2" -> Register.r1 = Register.r4 - Register.r2 - immediateVal;
                                case "r3" -> Register.r1 = Register.r4 - Register.r3 - immediateVal;
                                case "r5" -> Register.r1 = Register.r4 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r1 = Register.r5 - Register.r1 - immediateVal;
                                case "r2" -> Register.r1 = Register.r5 - Register.r2 - immediateVal;
                                case "r3" -> Register.r1 = Register.r5 - Register.r3 - immediateVal;
                                case "r5" -> Register.r1 = Register.r5 - Register.r4 - immediateVal;
                            }
                            break;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r2 = Register.r1 - Register.r2 - immediateVal;
                                case "r3" -> Register.r2 = Register.r1 - Register.r3 - immediateVal;
                                case "r4" -> Register.r2 = Register.r1 - Register.r4 - immediateVal;
                                case "r5" -> Register.r2 = Register.r1 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r2 - Register.r1 - immediateVal;
                                case "r3" -> Register.r2 = Register.r2 - Register.r3 - immediateVal;
                                case "r4" -> Register.r2 = Register.r2 - Register.r4 - immediateVal;
                                case "r5" -> Register.r2 = Register.r2 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r3 - Register.r1 - immediateVal;
                                case "r2" -> Register.r2 = Register.r3 - Register.r2 - immediateVal;
                                case "r4" -> Register.r2 = Register.r3 - Register.r4 - immediateVal;
                                case "r5" -> Register.r2 = Register.r3 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r4 - Register.r1 - immediateVal;
                                case "r2" -> Register.r2 = Register.r4 - Register.r2 - immediateVal;
                                case "r3" -> Register.r2 = Register.r4 - Register.r3 - immediateVal;
                                case "r5" -> Register.r2 = Register.r4 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r2 = Register.r5 - Register.r1 - immediateVal;
                                case "r2" -> Register.r2 = Register.r5 - Register.r2 - immediateVal;
                                case "r3" -> Register.r2 = Register.r5 - Register.r3 - immediateVal;
                                case "r5" -> Register.r2 = Register.r5 - Register.r4 - immediateVal;
                            }
                            break;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r3 = Register.r1 - Register.r2 - immediateVal;
                                case "r3" -> Register.r3 = Register.r1 - Register.r3 - immediateVal;
                                case "r4" -> Register.r3 = Register.r1 - Register.r4 - immediateVal;
                                case "r5" -> Register.r3 = Register.r1 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r2 - Register.r1 - immediateVal;
                                case "r3" -> Register.r3 = Register.r2 - Register.r3 - immediateVal;
                                case "r4" -> Register.r3 = Register.r2 - Register.r4 - immediateVal;
                                case "r5" -> Register.r3 = Register.r2 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r3 - Register.r1 - immediateVal;
                                case "r2" -> Register.r3 = Register.r3 - Register.r2 - immediateVal;
                                case "r4" -> Register.r3 = Register.r3 - Register.r4 - immediateVal;
                                case "r5" -> Register.r3 = Register.r3 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r4 - Register.r1 - immediateVal;
                                case "r2" -> Register.r3 = Register.r4 - Register.r2 - immediateVal;
                                case "r3" -> Register.r3 = Register.r4 - Register.r3 - immediateVal;
                                case "r5" -> Register.r3 = Register.r4 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r3 = Register.r5 - Register.r1 - immediateVal;
                                case "r2" -> Register.r3 = Register.r5 - Register.r2 - immediateVal;
                                case "r3" -> Register.r3 = Register.r5 - Register.r3 - immediateVal;
                                case "r5" -> Register.r3 = Register.r5 - Register.r4 - immediateVal;
                            }
                            break;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r4 = Register.r1 - Register.r2 - immediateVal;
                                case "r3" -> Register.r4 = Register.r1 - Register.r3 - immediateVal;
                                case "r4" -> Register.r4 = Register.r1 - Register.r4 - immediateVal;
                                case "r5" -> Register.r4 = Register.r1 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r2 - Register.r1 - immediateVal;
                                case "r3" -> Register.r4 = Register.r2 - Register.r3 - immediateVal;
                                case "r4" -> Register.r4 = Register.r2 - Register.r4 - immediateVal;
                                case "r5" -> Register.r4 = Register.r2 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r3 - Register.r1 - immediateVal;
                                case "r2" -> Register.r4 = Register.r3 - Register.r2 - immediateVal;
                                case "r4" -> Register.r4 = Register.r3 - Register.r4 - immediateVal;
                                case "r5" -> Register.r4 = Register.r3 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r4 - Register.r1 - immediateVal;
                                case "r2" -> Register.r4 = Register.r4 - Register.r2 - immediateVal;
                                case "r3" -> Register.r4 = Register.r4 - Register.r3 - immediateVal;
                                case "r5" -> Register.r4 = Register.r4 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r4 = Register.r5 - Register.r1 - immediateVal;
                                case "r2" -> Register.r4 = Register.r5 - Register.r2 - immediateVal;
                                case "r3" -> Register.r4 = Register.r5 - Register.r3 - immediateVal;
                                case "r5" -> Register.r4 = Register.r5 - Register.r4 - immediateVal;
                            }
                            break;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1":
                            switch (secondReg) {
                                case "r2" -> Register.r5 = Register.r1 - Register.r2 - immediateVal;
                                case "r3" -> Register.r5 = Register.r1 - Register.r3 - immediateVal;
                                case "r4" -> Register.r5 = Register.r1 - Register.r4 - immediateVal;
                                case "r5" -> Register.r5 = Register.r1 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r2":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r2 - Register.r1 - immediateVal;
                                case "r3" -> Register.r5 = Register.r2 - Register.r3 - immediateVal;
                                case "r4" -> Register.r5 = Register.r2 - Register.r4 - immediateVal;
                                case "r5" -> Register.r5 = Register.r2 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r3":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r3 - Register.r1 - immediateVal;
                                case "r2" -> Register.r5 = Register.r3 - Register.r2 - immediateVal;
                                case "r4" -> Register.r5 = Register.r3 - Register.r4 - immediateVal;
                                case "r5" -> Register.r5 = Register.r3 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r4":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r4 - Register.r1 - immediateVal;
                                case "r2" -> Register.r5 = Register.r4 - Register.r2 - immediateVal;
                                case "r3" -> Register.r5 = Register.r4 - Register.r3 - immediateVal;
                                case "r5" -> Register.r5 = Register.r4 - Register.r5 - immediateVal;
                            }
                            break;
                        case "r5":
                            switch (secondReg) {
                                case "r1" -> Register.r5 = Register.r5 - Register.r1 - immediateVal;
                                case "r2" -> Register.r5 = Register.r5 - Register.r2 - immediateVal;
                                case "r3" -> Register.r5 = Register.r5 - Register.r3 - immediateVal;
                                case "r5" -> Register.r5 = Register.r5 - Register.r4 - immediateVal;
                            }
                            break;
                    }
                    break;
            }
        }

        else if(!firstReg.equals("s0") && immediateVal != 0){ //sub.r1.s0.r3.10 -> r3 = r1 - 10
            switch (destinationReg) {
                case "r1":
                    switch (firstReg) {
                        case "r2" -> Register.r1 = Register.r2 - immediateVal;
                        case "r3" -> Register.r1 = Register.r3 - immediateVal;
                        case "r4" -> Register.r1 = Register.r4 - immediateVal;
                        case "r5" -> Register.r1 = Register.r5 - immediateVal;
                    }
                    break;
                case "r2":
                    switch (firstReg) {
                        case "r1" -> Register.r2 = Register.r1 - immediateVal;
                        case "r3" -> Register.r2 = Register.r3 - immediateVal;
                        case "r4" -> Register.r2 = Register.r4 - immediateVal;
                        case "r5" -> Register.r2 = Register.r5 - immediateVal;
                    }
                    break;
                case "r3":
                    switch (firstReg) {
                        case "r1" -> Register.r3 = Register.r1 - immediateVal;
                        case "r2" -> Register.r3 = Register.r2 - immediateVal;
                        case "r4" -> Register.r3 = Register.r4 - immediateVal;
                        case "r5" -> Register.r3 = Register.r5 - immediateVal;
                    }
                    break;
                case "r4":
                    switch (firstReg) {
                        case "r1" -> Register.r4 = Register.r1 - immediateVal;
                        case "r2" -> Register.r4 = Register.r2 - immediateVal;
                        case "r3" -> Register.r4 = Register.r3 - immediateVal;
                        case "r5" -> Register.r4 = Register.r5 - immediateVal;
                    }
                    break;
                case "r5":
                    switch (firstReg) {
                        case "r1" -> Register.r5 = Register.r1 - immediateVal;
                        case "r2" -> Register.r5 = Register.r2 - immediateVal;
                        case "r3" -> Register.r5 = Register.r3 - immediateVal;
                        case "r4" -> Register.r5 = Register.r4 - immediateVal;
                    }
                    break;
            }
        }
        else if(firstReg.equals("s0") && !secondReg.equals("s0") && immediateVal != 0){ //sub.s0.r2.r3.10 -> r3 = r2 - 10
            switch (destinationReg) {
                case "r1":
                    switch (secondReg) {
                        case "r2" -> Register.r1 = Register.r2 - immediateVal;
                        case "r3" -> Register.r1 = Register.r3 - immediateVal;
                        case "r4" -> Register.r1 = Register.r4 - immediateVal;
                        case "r5" -> Register.r1 = Register.r5 - immediateVal;
                    }
                    break;
                case "r2":
                    switch (secondReg) {
                        case "r1" -> Register.r2 = Register.r1 - immediateVal;
                        case "r3" -> Register.r2 = Register.r3 - immediateVal;
                        case "r4" -> Register.r2 = Register.r4 - immediateVal;
                        case "r5" -> Register.r2 = Register.r5 - immediateVal;
                    }
                    break;
                case "r3":
                    switch (secondReg) {
                        case "r1" -> Register.r3 = Register.r1 - immediateVal;
                        case "r2" -> Register.r3 = Register.r2 - immediateVal;
                        case "r4" -> Register.r3 = Register.r4 - immediateVal;
                        case "r5" -> Register.r3 = Register.r5 - immediateVal;
                    }
                    break;
                case "r4":
                    switch (secondReg) {
                        case "r1" -> Register.r4 = Register.r1 - immediateVal;
                        case "r2" -> Register.r4 = Register.r2 - immediateVal;
                        case "r3" -> Register.r4 = Register.r3 - immediateVal;
                        case "r5" -> Register.r4 = Register.r5 - immediateVal;
                    }
                    break;
                case "r5":
                    switch (secondReg) {
                        case "r1" -> Register.r5 = Register.r1 - immediateVal;
                        case "r2" -> Register.r5 = Register.r2 - immediateVal;
                        case "r3" -> Register.r5 = Register.r3 - immediateVal;
                        case "r4" -> Register.r5 = Register.r4 - immediateVal;
                    }
                    break;
            }
        }
        else if(firstReg.equals("s0") && !secondReg.equals("s0")) { //sub.s0.r2.r3.0 -> r3 = 0 - r2
            switch (destinationReg){
                case "r1":
                    switch (secondReg) {
                        case "r2" -> Register.r1 = -Register.r2;
                        case "r3" -> Register.r1 = -Register.r3;
                        case "r4" -> Register.r1 = -Register.r4;
                        case "r5" -> Register.r1 = -Register.r5;
                    }
                    break;
                case "r2":
                    switch (secondReg) {
                        case "r1" -> Register.r2 = -Register.r1;
                        case "r3" -> Register.r2 = -Register.r3;
                        case "r4" -> Register.r2 = -Register.r4;
                        case "r5" -> Register.r2 = -Register.r5;
                    }
                    break;
                case "r3":
                    switch (secondReg) {
                        case "r1" -> Register.r3 = -Register.r1;
                        case "r2" -> Register.r3 = -Register.r2;
                        case "r4" -> Register.r3 = -Register.r4;
                        case "r5" -> Register.r3 = -Register.r5;
                    }
                    break;
                case "r4":
                    switch (secondReg) {
                        case "r1" -> Register.r4 = -Register.r1;
                        case "r2" -> Register.r4 = -Register.r2;
                        case "r3" -> Register.r4 = -Register.r3;
                        case "r5" -> Register.r4 = -Register.r5;
                    }
                    break;
                case "r5":
                    switch (secondReg) {
                        case "r1" -> Register.r5 = -Register.r1;
                        case "r2" -> Register.r5 = -Register.r2;
                        case "r3" -> Register.r5 = -Register.r3;
                        case "r4" -> Register.r5 = -Register.r4;
                    }
                    break;
            }

        }
    }
}
