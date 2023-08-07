import java.util.Scanner;

public class Reverse {
public static void main(String[] args) {
	System.out.println("Enter number: ");
	Scanner sc = new Scanner(System.in);
	int num, rev, i;
	num = sc.nextInt();
	
	rev= reverse(num);
	
	if(rev==num) {
		System.out.println("Palindrome");
	}
	else {
		System.out.println("Not Palindrome");
	}
}

private static int reverse(int num) {
	int rev=0;
	while(num>0) {
		rev = rev *10 + num%10;
		num/=10; 
	}
	return rev;
}
}
