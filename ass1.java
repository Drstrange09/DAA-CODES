Problem Statement : Write a program to compute squares of 20-digit large integer numbers and product of 2 large integers numbers using divide and conquer strategy ( Make it menu driven ).

Code
package daa;
import java.util.Scanner;
public class ass1.java {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
				
		do {
			
			System.out.println("1. Multiplication of two numbers.");
			System.out.println("2.Square of a number : ");
			System.out.println("3.Exit : ");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				
				System.out.println("Enter the two Numbers : ");
				System.out.print("1st Number : ");
				String str1 = sc.next();
				System.out.print("2nd Number : ");
				String str2 = sc.next();
				String ans = new Karatsuba(str1, str2).multiply();
				System.out.println("The Answer is : " + ans);
				break;
				
			}
			case 2 : {
				System.out.println("Enter the Number : ");
				System.out.print("1st Number : ");
				String str1 = sc.next();
				String ans = new Karatsuba(str1, str1).multiply();
				System.out.println("The Answer is : " + ans);
				break;
			}
			case 3 : {
				System.out.println("Thank You !!!");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		} while (ch != 3);
		
	}
}
class Karatsuba {
	String str1;
	String str2;
	public Karatsuba(String str1, String str2) {
		super();
		this.str1 = str1;
		this.str2 = str2;
	}
	public String sumTwo() {
		String ans = "";
		if (str1.length() > str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		int n1 = str1.length();
		int n2 = str2.length();
		str1 = new StringBuilder(str1).reverse().toString();
		str2 = new StringBuilder(str2).reverse().toString();
		int carry = 0;
		for (int i = 0; i < n1; i++) {
			int sum = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
			ans += (char) (sum % 10 + '0');
			carry = sum / 10;
		}
		for (int i = n1; i < n2; i++) {
			int sum = ((str2.charAt(i) - '0') + carry);
			ans += (char) (sum % 10 + '0');
			carry = sum / 10;
		}
		if (carry != 0)
			ans += (char) (carry + '0');
		return new StringBuilder(ans).reverse().toString();
	}
	public String diffTwo() {
		String ans = "";
		if (str1.length() < str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		int n1 = str1.length();
		int n2 = str2.length();
		str1 = new StringBuilder(str1).reverse().toString();
		str2 = new StringBuilder(str2).reverse().toString();
		int borrow = 0;
		for (int i = 0; i < n2; i++) {
			int diff = (str1.charAt(i) - '0') - (str2.charAt(i) - '0') - borrow;
			if (diff < 0) {
				diff = diff + 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			ans += (char) (diff + '0');
		}
		for (int i = n2; i < n1; i++) {
			int diff = ((str1.charAt(i) - '0') - borrow);
			if (diff < 0) {
				diff = diff + 10;
				borrow = 1;
			} else {
				borrow = 0;
			}
			ans += (char) (diff + '0');
		}
		return new StringBuilder(ans).reverse().toString();
	}
	public String removeZeros(String str) {
		int idx = 0;
		while(str.charAt(idx) == '0') {
			idx++;
			if(idx == str.length()) {
				idx = 0;
				break;
			}
		}
		int n = str.length();
		str.substring(idx, n-1);
		return str;
	}
	public String multiply() {
		if (str1.length() > str2.length()) {
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		int n1 = str1.length();
		int n2 = str2.length();
		String ans = "";
		while (n2 > n1) {
			str1 = "0" + str1;
			n1++;
		}
		if (n1 == 1) {
			int ansInt = Integer.parseInt(str1) * Integer.parseInt(str2);
			return Integer.toString(ansInt);
		}
		if (n1 % 2 == 1) {
			str1 = "0" + str1;
			str2 = "0" + str2;
			n1++;
		}
		String al = "", ar = "", bl = "", br = "";
		for (int i = 0; i < n1 / 2; i++) {
			al += str1.charAt(i);
			bl += str2.charAt(i);
			ar += str1.charAt(n2 / 2 + i);
			br += str2.charAt(n2 / 2 + i);
		}
		String p = new Karatsuba(al, bl).multiply();
		String q = new Karatsuba(ar, br).multiply();
		String r = new Karatsuba(
				new Karatsuba(new Karatsuba(al, ar).sumTwo(), new Karatsuba(bl, br).sumTwo()).multiply(),
				new Karatsuba(p, q).sumTwo()).diffTwo();
		
		for (int i = 0; i < n1; ++i)
           p = p + "0";
       // Multiply s by 10^(n/2)
       for (int i = 0; i < n1 / 2; ++i)
           r = r + "0";
       ans = new Karatsuba(p, new Karatsuba(q, r).sumTwo()).sumTwo();
      
       ans = removeZeros(ans);
      
      
		return ans;
	}
}


Output
1. Multiplication of two numbers.
2.Square of a number :
3.Exit :
Enter your choice : 1
Enter the two Numbers :
1st Number : 12345678923456789
2nd Number : 98765432113456789
The Answer is : 00000000018977455358086667816292407765025
1. Multiplication of two numbers.
2.Square of a number :
3.Exit :
Enter your choice : 2
Enter the Number :
1st Number : 12345678912345678955
The Answer is : 0000101494329294140746205082616944100229321
1. Multiplication of two numbers.
2.Square of a number :
3.Exit :
Enter your choice : 3
Thank You !!!


