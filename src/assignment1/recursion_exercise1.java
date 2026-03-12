package assignment1;
import java.util.Scanner;

public class recursion_exercise1 {

    public static int counter(int num) {
        if (num == 1) {
            return 1;
        }
        return 1 + counter(num - 1);
    }

    public static double freeMarks(int numPpl) {
        if (numPpl == 1) {
            return 1;
        }

        if (numPpl % 5 == 0) {
            return 0.5 + freeMarks(numPpl - 1);
        } else if (numPpl % 2 == 0) {
            return 2 + freeMarks(numPpl - 1);
        } else {
            return 1 + freeMarks(numPpl - 1);
        }
    }

    public static double power(int base, int exponent) {
        if (base == 1) {
            return 1;
        } else if (base == 0) {
            if (exponent <= 0) {
                return -666;
            }
            return 0;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent < 0) {
            return 1.0 / base * power(base, exponent + 1);
        } else {
            return base * power(base, exponent - 1);
        }
    }

    public static int remainder(int num1, int num2) {
        if (Math.abs(num1) < Math.abs(num2)) {
            return num1;
        } else if (num1 * num2 > 0) {
            return remainder(num1 - num2, num2);
        } else {
            return remainder(num1 + num2, num2);
        }
    }

    public static int math(String equation) {
        if (equation.length() == 0) {
            return 0;
        }
        if (equation.charAt(0) == '+' || equation.charAt(0) == '-' || equation.charAt(0) == '*'
                || equation.charAt(0) == '/' || equation.charAt(0) == '%') {
            return 1 + math(equation.substring(1));
        } else {
            return math(equation.substring(1));
        }
    }

    public static String compress(String input, int count) {
        if (input.length() <= 1) {
            if (count > 1) {
                return input + String.valueOf(count);
            } else {
                return input;
            }
        }
        if (Character.toLowerCase(input.charAt(0)) == Character.toLowerCase(input.charAt(1))) {
            return compress(input.substring(1), count + 1);
        } else {
            if (count > 1) {
                return input.charAt(0) + String.valueOf(count) + compress(input.substring(1), 1);
            } else {
                return input.charAt(0) + compress(input.substring(1), 1);
            }
        }
    }

    public static String commas(int num) {
        if (num == 0) {
            return "00" + num;
        }
        if (num > -1000 && num < 0) {
            if (num > -10) {
                return "-00" + Math.abs(num);
            }
            if (num > -100) {
                return "-0" + Math.abs(num);
            }
            return "-" + Math.abs(num);
        }

        if (num < 1000 && num > 0) {
            if (num < 10) {
                return "+00" + num;
            }
            if (num < 100) {
                return "+0" + num;
            }
            return "+" + num;
        }

        int q = num / 1000;
        int r = Math.abs(num % 1000); // last 3 digits
        if (r < 10) {
            return commas(q) + ",00" + r;
        }
        if (r < 100) {
            return commas(q) + ",0" + r;
        }
        return commas(q) + "," + r;
    }

    public static int findLarge(int[] num, int max, int index, int count) {
        if (index == num.length - 1) {
            if (Math.abs(num[index]) > max) {
                max = Math.abs(num[index]);
                return max;
            } else {
                return max * count;
            }
        } else {
            if (Math.abs(num[index]) > max) {
                max = Math.abs(num[index]);
                return findLarge(num, max, index + 1, 1);
            } else if (Math.abs(num[index]) == max) {
                return findLarge(num, max, index + 1, count + 1);
            } else {
                return findLarge(num, max, index + 1, count);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String answer = "";
        do {
            System.out.println("Choose one from below and enter the number:");
            System.out.println("1. FreeMarks");
            System.out.println("2. Power");
            System.out.println("3. Remainder");
            System.out.println("4. Math");
            System.out.println("5. Compress");
            System.out.println("6. Commas");
            System.out.println("7. Find the Largest");
            int input = sc.nextInt();
            sc.nextLine();
            if (input == 1) {
                int numPpl = sc.nextInt();
                sc.nextLine();
                if (numPpl <= 0) {
                    System.out.println("Invalid input");
                } else {
                    System.out.println(freeMarks(numPpl));
                }
            } else if (input == 2) {
                int base = sc.nextInt();
                int exponent = sc.nextInt();
                sc.nextLine();
                if (base == 0 && exponent == 0) {
                    System.out.println("Invalid input");
                } else {
                    System.out.println(power(base, exponent));
                }

            } else if (input == 3) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();
                sc.nextLine();
                if (num2 == 0) {
                    System.out.println("Invalid input");
                } else {
                    System.out.println(remainder(num1, num2));
                }

            } else if (input == 4) {
                String equation = sc.nextLine();
                System.out.println(math(equation));
            } else if (input == 5) {
                String input2 = sc.nextLine();
                System.out.println(compress(input2, 1));
            } else if (input == 6) {
                int num = sc.nextInt();
                sc.nextLine();
                System.out.println(commas(num));

            } else if (input == 7) {
                int[] input3 = {23, 5, -2, -2000, 234};
                System.out.println(findLarge(input3, Integer.MIN_VALUE, 0, 1));
            } else {
                System.out.println("Invalid input, enter again");
                continue;
            }
            System.out.println("Do you want to continue? enter(y/n)");
            answer = sc.nextLine();

        } while (answer.equalsIgnoreCase("y"));

    }

}
