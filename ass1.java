Write a program to compute square of 20-digit large integer numbers using divide and conquer
strategy.
  
import java.util.Scanner;
public class fine {
    public static String addition(String a, String b) {
        if (a.length() > b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        String str = "";
        int n1 = a.length();
        int n2 = b.length();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n1; i++) {
            int sum = ((a.charAt(i) - '0') + (b.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        for (int i = n1; i < n2; i++) {
            int sum = ((b.charAt(i) - '0') + carry);
            str += (char)(sum % 10 + '0');
            carry = sum / 10;
        }
        if (carry != 0)
            str += (char)(carry + '0');

        str = new StringBuilder(str).reverse().toString();
        return str;
    }

    static String diff(String a, String b) {
        String str = "";
        int n1 = a.length(), n2 = b.length();

        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int carry = 0;
        for (int i = 0; i < n2; i++) {
            int sub = ((a.charAt(i) - '0') - (b.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else
                carry = 0;
            str += sub;
        }
        for (int i = n2; i < n1; i++) {
            int sub = ((a.charAt(i) - '0') - carry);
            if (sub < 0) {
                sub += 10;
                carry = 1;
            } else
                carry = 0;
            str += sub;
        }
        str = new StringBuilder(str).reverse().toString();
        return str;
    }

    public static String zeros(String str) {
        String pattern = "^0+(?!$)";
        str = str.replaceAll(pattern, "");
        return str;
    }

    public static String multiply(String A, String B) {
        if (A.length() > B.length()) {
            String temp = A;
            A = B;
            B = temp;
        }
        int n1 = A.length(), n2 = B.length();
        while (n2 > n1) {
            A = "0" + A;
            n1++;
        }
        if (n1 == 1) {
            int ans = Integer.parseInt(A) * Integer.parseInt(B);
            return Integer.toString(ans);
        }
        if (n1 % 2 == 1) {
            n1++;
            A = "0" + A;
            B = "0" + B;
        }

        String al = "", ar = "", bl = "", br = "";
        for (int i = 0; i < n1 / 2; ++i) {
            al += A.charAt(i);
            bl += B.charAt(i);
            ar += A.charAt(n1 / 2 + i);
            br += B.charAt(n1 / 2 + i);
        }
        String p = multiply(al, bl);
        String q = multiply(ar, br);
        String r = diff(multiply(addition(al, ar), addition(bl, br)), addition(p, q));

        for (int i = 0; i < n1; ++i)
            p = p + "0";
        for (int i = 0; i < n1 / 2; ++i)
            r = r + "0";
        String ans = addition(p, addition(q, r));
        ans = zeros(ans);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Multiplication");
            System.out.println("2. Square");
            System.out.println("3. Addition");
            System.out.println("4. Subtraction");
            System.out.println("5. Exit");

            choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println("Enter numbers A and B:");
                    String A = sc.nextLine();
                    String B = sc.nextLine();
                    System.out.println("Product: " + multiply(A, B));
                    break;

                case 2:
                    System.out.println("Enter number A:");
                    A = sc.nextLine();
                    System.out.println("Square: " + multiply(A, A));
                    break;

                case 3:
                    System.out.println("Enter numbers A and B:");
                    A = sc.nextLine();
                    B = sc.nextLine();
                    System.out.println("Sum: " + addition(A, B));
                    break;

                case 4:
                    System.out.println("Enter numbers A and B:");
                    A = sc.nextLine();
                    B = sc.nextLine();
                    System.out.println("Difference: " + diff(A, B));
                    break;

                case 5:
                    System.out.println("Exiting the program");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}

Output

PS D:\Java> javac fine.java
PS D:\Java> java fine.java 
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
1
Enter numbers A and B:
12345678
67894521
Product: 838203894230238
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
2
Enter number A:
123456789
Square: 15241578750190521
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
3
Enter numbers A and B:
567896
122334 
Sum: 690230
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
4
Enter numbers A and B:
788762544
656758
4. Subtraction
5. Exit
4
Enter numbers A and B:
788762544
656758
Difference: 788105786
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
4. Subtraction
5. Exit
4
Enter numbers A and B:
788762544
656758
Difference: 788105786
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
4
Enter numbers A and B:
788762544
656758
Difference: 788105786
5. Exit
4
Enter numbers A and B:
788762544
656758
4
Enter numbers A and B:
788762544
656758
788762544
656758
656758
Difference: 788105786
Enter your choice:
1. Multiplication
2. Square
3. Addition
4. Subtraction
5. Exit
5
Exiting the program
