package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

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
        String decodedInpunt = new String(byteValue);
        System.out.println("The decoded input is: " + decodedInpunt);
        System.out.println("The decoded seperated input is: " + decodedInpunt.toCharArray());

    }
}
