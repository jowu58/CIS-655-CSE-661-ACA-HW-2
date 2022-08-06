package com.hwk2.main;

import java.util.Objects;

public class main {
    public static void main(String[] args) {
        String s = "add.s0.s0.r2.10";
        String[] tokens = s.split("\\.");
        String opcode = tokens[0];
        String firstreg = tokens[1];
        String secondreg = tokens[2];
        String destinationreg = tokens[3];
        String immediatevalue = tokens[4];

        String binaryadd = "00";
        int add = Integer.parseInt(binaryadd, 2);

        String binarysub = "10";
        int sub = Integer.parseInt(binarysub, 2);

        String binarymul = "01";
        int mul = Integer.parseInt(binarymul, 2);

        String binarydiv = "11";
        int div = Integer.parseInt(binarydiv, 2);

        String binaryfirstregr1 = "000";
        int fr1 = Integer.parseInt(binaryfirstregr1, 2);

        String binaryfirstregr2 = "001";
        int fr2 = Integer.parseInt(binaryfirstregr2, 2);

        String binaryfirstregr3 = "010";
        int fr3 = Integer.parseInt(binaryfirstregr3, 2);

        String binaryfirstregr4 = "100";
        int fr4 = Integer.parseInt(binaryfirstregr4, 2);

        String binaryfirstregr5 = "101";
        int fr5 = Integer.parseInt(binaryfirstregr5, 2);

        String binaryfirstregr6 = "110";
        int fr6 = Integer.parseInt(binaryfirstregr6, 2);

        String binaryfirstregr7 = "111";
        int fr7 = Integer.parseInt(binaryfirstregr7, 2);

        String binarysecondregr1 = "000";
        int sr1 = Integer.parseInt(binarysecondregr1, 2);

        String binarysecondregr2 = "001";
        int sr2 = Integer.parseInt(binarysecondregr2, 2);

        String binarysecondregr3 = "010";
        int sr3 = Integer.parseInt(binarysecondregr3, 2);

        String binarysecondregr4 = "100";
        int sr4 = Integer.parseInt(binarysecondregr4, 2);

        String binarysecondregr5 = "101";
        int sr5 = Integer.parseInt(binarysecondregr5, 2);

        String binarysecondregr6 = "110";
        int sr6 = Integer.parseInt(binarysecondregr6, 2);

        String binarysecondregr7 = "111";
        int sr7 = Integer.parseInt(binarysecondregr7, 2);

        String binarydestinationregr1 = "000";
        int dr1 = Integer.parseInt(binarydestinationregr1, 2);

        String binarydestinationregr2 = "001";
        int dr2 = Integer.parseInt(binarydestinationregr2, 2);

        String binarydestinationregr3 = "010";
        int dr3 = Integer.parseInt(binarydestinationregr3, 2);

        String binarydestinationregr4 = "100";
        int dr4 = Integer.parseInt(binarydestinationregr4, 2);

        String binarydestinationregr5 = "101";
        int dr5 = Integer.parseInt(binarydestinationregr5, 2);

        String binarydestinationregr6 = "110";
        int dr6 = Integer.parseInt(binarydestinationregr6, 2);

        String binarydestinationregr7 = "111";
        int dr7 = Integer.parseInt(binarydestinationregr7, 2);


        if (Objects.equals(opcode, "add")) {
            System.out.println(binaryadd);
            if (Objects.equals(firstreg, "r1")) {
                System.out.println(binaryfirstregr1);
            }
            if (Objects.equals(firstreg, "r2")) {
                System.out.println(binaryfirstregr2);
            }
            if (Objects.equals(firstreg, "r3")) {
                System.out.println(binaryfirstregr3);
            }
            if (Objects.equals(firstreg, "r4")) {
                System.out.println(binaryfirstregr4);
            }
            if (Objects.equals(firstreg, "r5")) {
                System.out.println(binaryfirstregr5);
            }
            if (Objects.equals(firstreg, "r6")) {
                System.out.println(binaryfirstregr6);
            }
            if (Objects.equals(firstreg, "r7")) {
                System.out.println(binaryfirstregr7);
            }
            if (Objects.equals(secondreg, "r1")) {
                System.out.println(binarysecondregr1);
            }
            if (Objects.equals(secondreg, "r2")) {
                System.out.println(binarysecondregr2);
            }
            if (Objects.equals(secondreg, "r3")) {
                System.out.println(binarysecondregr3);
            }
            if (Objects.equals(secondreg, "r4")) {
                System.out.println(binarysecondregr4);
            }
            if (Objects.equals(secondreg, "r5")) {
                System.out.println(binarysecondregr5);
            }
            if (Objects.equals(secondreg, "r6")) {
                System.out.println(binarysecondregr6);
            }
            if (Objects.equals(secondreg, "r7")) {
                System.out.println(binarysecondregr7);
            }
            if (Objects.equals(destinationreg, "r1")) {
                System.out.println(binarydestinationregr1);
            }
            if (Objects.equals(destinationreg, "r2")) {
                System.out.println(binarydestinationregr2);
            }
            if (Objects.equals(destinationreg, "r3")) {
                System.out.println(binarydestinationregr3);
            }
            if (Objects.equals(destinationreg, "r4")) {
                System.out.println(binarydestinationregr4);
            }
            if (Objects.equals(destinationreg, "r5")) {
                System.out.println(binarydestinationregr5);
            }
            if (Objects.equals(destinationreg, "r6")) {
                System.out.println(binarydestinationregr6);
            }
            if (Objects.equals(destinationreg, "r7")) {
                System.out.println(binarydestinationregr7);
            }
            System.out.println("Hex Memory Address = " + s.hashCode());
        }


        if (Objects.equals(opcode, "sub")) {
            System.out.println(binarysub);
            if (Objects.equals(firstreg, "r1")) {
                System.out.println(binaryfirstregr1);
            }
            if (Objects.equals(firstreg, "r2")) {
                System.out.println(binaryfirstregr2);
            }
            if (Objects.equals(firstreg, "r3")) {
                System.out.println(binaryfirstregr3);
            }
            if (Objects.equals(firstreg, "r4")) {
                System.out.println(binaryfirstregr4);
            }
            if (Objects.equals(firstreg, "r5")) {
                System.out.println(binaryfirstregr5);
            }
            if (Objects.equals(firstreg, "r6")) {
                System.out.println(binaryfirstregr6);
            }
            if (Objects.equals(firstreg, "r7")) {
                System.out.println(binaryfirstregr7);
            }
            if (Objects.equals(secondreg, "r1")) {
                System.out.println(binarysecondregr1);
            }
            if (Objects.equals(secondreg, "r2")) {
                System.out.println(binarysecondregr2);
            }
            if (Objects.equals(secondreg, "r3")) {
                System.out.println(binarysecondregr3);
            }
            if (Objects.equals(secondreg, "r4")) {
                System.out.println(binarysecondregr4);
            }
            if (Objects.equals(secondreg, "r5")) {
                System.out.println(binarysecondregr5);
            }
            if (Objects.equals(secondreg, "r6")) {
                System.out.println(binarysecondregr6);
            }
            if (Objects.equals(secondreg, "r7")) {
                System.out.println(binarysecondregr7);
            }
            if (Objects.equals(destinationreg, "r1")) {
                System.out.println(binarydestinationregr1);
            }
            if (Objects.equals(destinationreg, "r2")) {
                System.out.println(binarydestinationregr2);
            }
            if (Objects.equals(destinationreg, "r3")) {
                System.out.println(binarydestinationregr3);
            }
            if (Objects.equals(destinationreg, "r4")) {
                System.out.println(binarydestinationregr4);
            }
            if (Objects.equals(destinationreg, "r5")) {
                System.out.println(binarydestinationregr5);
            }
            if (Objects.equals(destinationreg, "r6")) {
                System.out.println(binarydestinationregr6);
            }
            if (Objects.equals(destinationreg, "r7")) {
                System.out.println(binarydestinationregr7);
            }
            System.out.println("Hex Memory Address = " + s.hashCode());
        }

        if (Objects.equals(opcode, "mul")) {
            System.out.println(binarymul);
            if (Objects.equals(firstreg, "r1")) {
                System.out.println(binaryfirstregr1);
            }
            if (Objects.equals(firstreg, "r2")) {
                System.out.println(binaryfirstregr2);
            }
            if (Objects.equals(firstreg, "r3")) {
                System.out.println(binaryfirstregr3);
            }
            if (Objects.equals(firstreg, "r4")) {
                System.out.println(binaryfirstregr4);
            }
            if (Objects.equals(firstreg, "r5")) {
                System.out.println(binaryfirstregr5);
            }
            if (Objects.equals(firstreg, "r6")) {
                System.out.println(binaryfirstregr6);
            }
            if (Objects.equals(firstreg, "r7")) {
                System.out.println(binaryfirstregr7);
            }
            if (Objects.equals(secondreg, "r1")) {
                System.out.println(binarysecondregr1);
            }
            if (Objects.equals(secondreg, "r2")) {
                System.out.println(binarysecondregr2);
            }
            if (Objects.equals(secondreg, "r3")) {
                System.out.println(binarysecondregr3);
            }
            if (Objects.equals(secondreg, "r4")) {
                System.out.println(binarysecondregr4);
            }
            if (Objects.equals(secondreg, "r5")) {
                System.out.println(binarysecondregr5);
            }
            if (Objects.equals(secondreg, "r6")) {
                System.out.println(binarysecondregr6);
            }
            if (Objects.equals(secondreg, "r7")) {
                System.out.println(binarysecondregr7);
            }
            if (Objects.equals(destinationreg, "r1")) {
                System.out.println(binarydestinationregr1);
            }
            if (Objects.equals(destinationreg, "r2")) {
                System.out.println(binarydestinationregr2);
            }
            if (Objects.equals(destinationreg, "r3")) {
                System.out.println(binarydestinationregr3);
            }
            if (Objects.equals(destinationreg, "r4")) {
                System.out.println(binarydestinationregr4);
            }
            if (Objects.equals(destinationreg, "r5")) {
                System.out.println(binarydestinationregr5);
            }
            if (Objects.equals(destinationreg, "r6")) {
                System.out.println(binarydestinationregr6);
            }
            if (Objects.equals(destinationreg, "r7")) {
                System.out.println(binarydestinationregr7);
            }
            System.out.println("Hex Memory Address = " + s.hashCode());
        }

        if (Objects.equals(opcode, "div")) {
            System.out.println(binarydiv);
            if (Objects.equals(firstreg, "r1")) {
                System.out.println(binaryfirstregr1);
            }
            if (Objects.equals(firstreg, "r2")) {
                System.out.println(binaryfirstregr2);
            }
            if (Objects.equals(firstreg, "r3")) {
                System.out.println(binaryfirstregr3);
            }
            if (Objects.equals(firstreg, "r4")) {
                System.out.println(binaryfirstregr4);
            }
            if (Objects.equals(firstreg, "r5")) {
                System.out.println(binaryfirstregr5);
            }
            if (Objects.equals(firstreg, "r6")) {
                System.out.println(binaryfirstregr6);
            }
            if (Objects.equals(firstreg, "r7")) {
                System.out.println(binaryfirstregr7);
            }
            if (Objects.equals(secondreg, "r1")) {
                System.out.println(binarysecondregr1);
            }
            if (Objects.equals(secondreg, "r2")) {
                System.out.println(binarysecondregr2);
            }
            if (Objects.equals(secondreg, "r3")) {
                System.out.println(binarysecondregr3);
            }
            if (Objects.equals(secondreg, "r4")) {
                System.out.println(binarysecondregr4);
            }
            if (Objects.equals(secondreg, "r5")) {
                System.out.println(binarysecondregr5);
            }
            if (Objects.equals(secondreg, "r6")) {
                System.out.println(binarysecondregr6);
            }
            if (Objects.equals(secondreg, "r7")) {
                System.out.println(binarysecondregr7);
            }
            if (Objects.equals(destinationreg, "r1")) {
                System.out.println(binarydestinationregr1);
            }
            if (Objects.equals(destinationreg, "r2")) {
                System.out.println(binarydestinationregr2);
            }
            if (Objects.equals(destinationreg, "r3")) {
                System.out.println(binarydestinationregr3);
            }
            if (Objects.equals(destinationreg, "r4")) {
                System.out.println(binarydestinationregr4);
            }
            if (Objects.equals(destinationreg, "r5")) {
                System.out.println(binarydestinationregr5);
            }
            if (Objects.equals(destinationreg, "r6")) {
                System.out.println(binarydestinationregr6);
            }
            if (Objects.equals(destinationreg, "r7")) {
                System.out.println(binarydestinationregr7);
            }
            System.out.println("Hex Memory Address = " + s.hashCode());
        }
    }
}
