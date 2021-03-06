package ss.week6.dictionaryattack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.codec.binary.Hex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;
	
	//Constructor:
	public DictionaryAttack() {
		this.passwordMap = new HashMap<>();
		this.hashDictionary = new HashMap<>();
	}

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException {
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			String total;
			String[] parts = new String[2];
			while (in.hasNextLine()) {
				total = in.nextLine();		
				parts = total.split(": ");
				passwordMap.put(parts[0], parts[1]);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 */
	public String getPasswordHash(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] message = md.digest(password.getBytes());
			String hash = Hex.encodeHexString(message);
			return hash;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
   	}
	/**
	 * Checks the password for the user in the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
		if (passwordMap.get(user).equals(getPasswordHash(password))) {
			return true;
		}
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    public void addToHashDictionary(String filename) {
		File file = new File(filename);
		try {
			Scanner in = new Scanner(file);
			String passWord;
			String hashPass;
			while (in.hasNext()) {
				passWord = in.next();		
				hashPass = getPasswordHash(passWord);
				hashDictionary.put(hashPass, passWord);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    	
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		Set<String> users = passwordMap.keySet();
		Set<String> passes = hashDictionary.keySet();
		int count = 0;
		for (String u : users) {
			for (String p : passes) {
				if (passwordMap.get(u).equals(p)) {
					System.out.println("User: " + u + ": Password: " + hashDictionary.get(p));
					count++;
				}
			}
		}
		System.out.println("Total passwords recovered: " + count);
		
	}
	/**
	 * Method to determine the starting index of the long, based on the expected password size.
	 * @param size - the expected password size.
	 * @return - the starting index of the long.
	 */
	public int startSize(int size) {
		int start = (int) Math.pow(36, size - 1); 
		return start;
	}
	
	/**
	 * Method to bruteForce a password.
	 * @param hashPass - the password that is to be brute forced.
	 * @param wordSize - the expected size of this password.
	 */
	public void doBruteForce(String hashPass, int wordSize) {
		int i = startSize(wordSize);
		System.out.println("start index: " + i);
		while (!hashPass.equals(this.getPasswordHash(Long.toString(i, 36)))) {
			if (i == Long.MAX_VALUE) {
				return;
			}
			i++;
		}
		System.out.println("The password is: " + Long.toString(i, 36));
	}
	
	
	
	public static void main(String[] args) throws IOException {
//		DictionaryAttack da = new DictionaryAttack();
//		da.readPasswords("LeakedPasswords.txt");
//		System.out.println("Reading hashed passwords");
//		da.addToHashDictionary("CommonPasswords.txt");
//		System.out.println("Dictionary is ready");
//		da.doDictionaryAttack();
//		System.out.println("Attack completed");
		DictionaryAttack bf = new DictionaryAttack();
		
		long mili = System.currentTimeMillis();

		bf.doBruteForce(bf.getPasswordHash("sane"), 4);

		System.out.println("Computed in " + -1 * (double) (mili - System.currentTimeMillis()) / 1000 + "s");
		//System.out.println((int) Math.pow(36, 4 - 1));
		System.out.println("Optimized time for 6 digit password: 255.856s");
		System.out.println("Unoptimized time for 6 digit password: 606.314s");
		
	}
}
