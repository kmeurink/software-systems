package ss.week6.dictionaryattack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        // To implement        
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
