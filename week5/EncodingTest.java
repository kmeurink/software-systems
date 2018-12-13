package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.binary.Base64;


/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
        String input = "Hello Big World";
        String encodedInput = Hex.encodeHexString(input.getBytes());
        System.out.println("The encoded input is: " + encodedInput);
        byte[] byteValue = Hex.decodeHex(encodedInput);
        String decodedInput1 = new String(byteValue);
        System.out.println("The decoded input is: " + decodedInput1);
        System.out.println("The decoded seperated input is: " + decodedInput1.toCharArray());
        
        String encodedInput2 = Base64.encodeBase64String(input.getBytes());
        System.out.println("The encoded base64 input is: " + encodedInput2);
        String hex2 = "010203040506";
        byte[] byteValue2 = Hex.decodeHex(hex2);
        String encodedInput3 = Base64.encodeBase64String(byteValue2);
        System.out.println("The Base64 encoded hex is: " + encodedInput3);
        String base64input = "U29mdHdhcmUgU3lzdGVtcw==";
        byte[] b64Value = Base64.decodeBase64(base64input);
        String decodedbase64input = new String(b64Value);
        System.out.println("The decoded base64 input is: " + decodedbase64input);
        System.out.println("Now to test the effect of input length on Base64 hash");
        String base641 = "a";
        String base642 = "aa";
        String base643 = "aaa";
        String base644 = "aaaa";
        String base645 = "aaaaa";
        String base646 = "aaaaaa";
        String base647 = "aaaaaaa";
        String base648 = "aaaaaaaa";
        System.out.println("The encoded base64 input 1 is: " + Base64.encodeBase64String(base641.getBytes()));
        System.out.println("The encoded base64 input 2 is: " + Base64.encodeBase64String(base642.getBytes()));
        System.out.println("The encoded base64 input 3 is: " + Base64.encodeBase64String(base643.getBytes()));
        System.out.println("The encoded base64 input 4 is: " + Base64.encodeBase64String(base644.getBytes()));
        System.out.println("The encoded base64 input 5 is: " + Base64.encodeBase64String(base645.getBytes()));
        System.out.println("The encoded base64 input 6 is: " + Base64.encodeBase64String(base646.getBytes()));
        System.out.println("The encoded base64 input 7 is: " + Base64.encodeBase64String(base647.getBytes()));
        System.out.println("The encoded base64 input 8 is: " + Base64.encodeBase64String(base648.getBytes()));
        
    }
}
