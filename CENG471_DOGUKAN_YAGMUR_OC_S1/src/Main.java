import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		Node Alice = new Node();
		Node Bob = new Node();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter private key for Alice: ");
		BigInteger alicePrivateKey = new BigInteger(sc.nextLine());
		System.out.print("Enter private key for Bob: ");
		BigInteger bobPrivateKey = new BigInteger(sc.nextLine());
		System.out.print("Enter prime number: ");
		BigInteger prime = new BigInteger(sc.nextLine());
		System.out.print("Enter primitive number: ");
		BigInteger primitive = new BigInteger(sc.nextLine());
		
		System.out.println("\n\n");
		if(DHKeyExchange.generateKeys(Alice, Bob, prime, primitive, alicePrivateKey, bobPrivateKey).equals(BigInteger.ONE)) {
			System.out.println("Diffie Hellman Key Exchange Scheme executed ");
			System.out.println();
			System.out.println("Alice's Public Key: " + Alice.getPublicKey());
			System.out.println("Alice's Private Key: " + Alice.getPrivateKey());
			System.out.println("Alice's Common Secret: " + Alice.getCommonSecret());
			System.out.println();
			System.out.println("Bob's Public Key: " + Bob.getPublicKey());
			System.out.println("Bob's Private Key: " + Bob.getPrivateKey());
			System.out.println("Bob's Common Secret: " + Bob.getCommonSecret());
			System.out.println();
			System.out.println();
			
			System.out.println("Enter your message in a single line (Finish using 'ctrl + z'): ");
			
			String text = sc.nextLine();
			
			System.out.println("\n\n");
			long startTime = System.currentTimeMillis();
	        String cipherText = Alice.encrypt(text);
	        System.out.println("\n\n---------------------------------------------------------------------------\n\n");
	        System.out.println(text + "\n\n is encrypted to \n\n" + cipherText);
	        System.out.println("\n\n---------------------------------------------------------------------------\n\n");
	        System.out.println(cipherText + "\n\n is decrypted to \n\n" + Bob.decrypt(cipherText));
	        System.out.println("\n\n---------------------------------------------------------------------------\n\n");
	        long endTime = System.currentTimeMillis();
	        System.out.println("\n\nTook " + (endTime - startTime) + " milliseconds");
	        sc.close();
			
		} else {
			System.out.println("Diffie Hellman Key Exchange Scheme Error!");
		}
    }

}
