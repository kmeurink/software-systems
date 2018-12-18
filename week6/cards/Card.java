package ss.week6.cards;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {
	
	public static void main(String[] args) {
		String file;
		PrintWriter writer = null;
		//Make sure that when the file is not found and exception is thrown.
			//If no filename is given(argument length == 0) write to System.out.
		if (args.length != 0) {
			file = args[0];
			try {
				writer = new PrintWriter(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			writer = new PrintWriter(System.out);
		}
		Card c1 = new Card(DIAMONDS, '9');
		Card c2 = new Card(SPADES, '4');
		Card c3 = new Card(SPADES, KING);
		Card c4 = new Card(DIAMONDS, JACK);
		Card c5 = new Card(HEARTS, ACE);
		c1.write(writer);
		c2.write(writer);
		c3.write(writer);
		c4.write(writer);
		c5.write(writer);
		writer.close();	
	} 

	// ---- constants -----------------------------------

	// ranks are 2, ..., 9 and:
	public static final char JACK = 'J';
	public static final char QUEEN = 'Q';
	public static final char KING = 'K';
	public static final char ACE = 'A';
	public static final char TEN = 'T';

	// suits are:
	public static final char CLUBS = 'C';
	public static final char DIAMONDS = 'D';
	public static final char HEARTS = 'H';
	public static final char SPADES = 'S';

	// some convenient arrays
	private static final char[] RANK_CHARACTERS = "23456789TJQKA".toCharArray();
	private static final char[] SUIT_CHARACTERS = {'C', 'D', 'H', 'S'};
	private static final String[] RANK_STRINGS = {"2", "3", "4", "5", "6", "7",
	    "8", "9", "10", "jack", "queen", "king", "ace"};
	private static final String[] SUIT_STRINGS = {"Clubs", "Diamonds",
	    "Hearts", "Spades"};

	// ---- class methods -------------------------------------

	/**
	 * Translates a String encoding of rank into its character representation.
	 * @param  rank the String encoding a rank
	 * @return the char encoding of rank
	 * @return '?' if <code>isValidRank(rank)</code> returns <code>false</code>
	 */
	private static char rankString2Char(String rank) {
		int i;
		for (i = 0; i < 13 && !(RANK_STRINGS[i].equals(rank)); i++) {
            ;
        }
		return (i == 13) ? '?' : RANK_CHARACTERS[i];
	}

	/**
	 * Translates a suit String into its character encoding.
	 * @param  rank the String representation of a suit
	 * @return the character encoding of suit
	 * @return '?' if <code>isValidSuit(suit)</code> returns <code>false</code>
	 */
	private static char suitString2Char(String suit) {
		int i;
		for (i = 0; i < 4 && !(SUIT_STRINGS[i].equals(suit)); i++) {
            ;
        }
		return (i == 4) ? '?' : SUIT_CHARACTERS[i];
	}

	/**
	 * Tests if a <tt>char</tt> represents a valid suit.
	 * @return <tt>true</tt> if 
	 *         <tt>k</tt> in <tt>CLUBS | DIAMONDS | HEARTS | SPADES</tt>
	 */
	/*@pure*/
	public static boolean isValidSuit(char suit) {
		return suit == CLUBS || suit == DIAMONDS || suit == HEARTS
				|| suit == SPADES;
	}

	/**
	 * Tests if a <tt>char</tt> represents a valid rank.
	 * @return <tt>true</tt> if 
	 * <tt>k</tt> in <tt>'2'..'9' | TEN | JACK | QUEEN | KING | ACE</tt>
	 */
    /*@pure*/
	public static boolean isValidRank(char r) {
		return ('2' <= r && r <= '9') || r == TEN || r == JACK || r == QUEEN
				|| r == KING || r == ACE;
	}

	/*@
	   requires isValidSuit(s1) && isValidSuit(s2);
	 */
	/**
	 * Tests if the value of a suit is less than the value of
	 * another suit following the order.
	 * CLUBS < DIAMONDS < HEARTS < SPADES.
	 */
	public static boolean suitLessThan(char s1, char s2) {
		boolean result = false;
		if (s1 == CLUBS) {
			result = s2 != CLUBS;
		} else if (s1 == DIAMONDS) {
			result = s2 != CLUBS && s2 != DIAMONDS;
		} else if (s1 == HEARTS) {
			result = s2 == SPADES;
		}
		return result;
	}

    /*@
       requires isValidRank(r1) && isValidRank(r2);
     */
	/**
	 * Tests if one rank is less then the other following the order
	 * '2' < '3' < ... < TEN < JACK < QUEEN < KING < ACE.
	 */
	public static boolean rankLessThan(char r1, char r2) {
		int i;
		for (i = 0; RANK_CHARACTERS[i] != r1 && RANK_CHARACTERS[i] != r2; i++) {
            ;
        }
		return RANK_CHARACTERS[i] == r2 ? false : RANK_CHARACTERS[i] == r1;
	}

	/*@
       requires isValidRank(r1) && isValidRank(r2);
     */
	/**
	 * Tests if one rank directly follows the other according to
	 * '2' < '3' < ... < TEN < JACK < QUEEN < KING < ACE.
	 */
	public static boolean isRankFollowing(char r1, char r2) {
		boolean result = false;
		if (r1 == KING) {
			result = r2 == ACE;
		} else if (r1 == QUEEN) {
			result = r2 == KING;
		} else if (r1 == JACK) {
			result = r2 == QUEEN;
		} else if (r1 == TEN) {
			result = r2 == JACK;
		} else if (r1 == '9') {
			result = r2 == TEN;
		} else {
			result = r2 == r1 + 1;
		}
		return result;
	}
	
	/**
	 * P6.4
	 * Write the description of the object to the PrintWriter.
	 */
	public void write(PrintWriter writer) {
		writer.println(this.toString());

	}
	
	/**
	 * P6.5
	 * Read and create a new Card object from a file.
	 */
	public static Card read(BufferedReader in) throws EOFException {
		String card = null;
		try {
			card = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner check = new Scanner(card);
		char[] suit = check.next().toUpperCase().toCharArray();
		char[] rank = check.next().toUpperCase().toCharArray();
		if (isValidSuit(suit[0])) {
			if (isValidRank(rank[0])) {
				check.close();
				return new Card(suit[0], rank[0]);
			}
		} else {
			check.close();
			return null;
		}
		check.close();
		return null;
	}
	
	/**
	 * P6.7
	 * Read and write a new card object using inputStream and outputStream.
	 */
	public void write(DataOutput out) {
		try {
			out.writeChars(this.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Card read(DataInput in) throws EOFException {
		char suit = 'b';
		char rank = 'b';
		boolean suitDone = false;
		boolean rankDone = false;
		char temp;
		int count = 0;
		try {
			while (suitDone == false) {
				temp = in.readChar();
				if (temp == ' ') {
					suitDone = true;
				} else if (count == 0) {
					suit = Character.toUpperCase(temp);
					count++;
				}
			}
			count = 0;
			while (suitDone == true && rankDone == false) {
				temp = in.readChar();
				if (count == 0) {
					rank = Character.toUpperCase(temp);
					rankDone = true;
					count++;				
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (isValidSuit(suit)) {
			if (isValidRank(rank)) {
				return new Card(suit, rank);
			}
		} else {
			return null;
		}
		return null;
	}
	
	/**
	 * P6.8
	 * Read and write a new card object using ObjectInput and ObjectOutput.
	 * Is exactly the same as the data channels, so ask for more explanation.
	 */
	public void write(ObjectOutput out) {
		try {
			out.writeChars(this.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static Card read(ObjectInput in) throws EOFException {
		char suit = 'b';
		char rank = 'b';
		boolean suitDone = false;
		boolean rankDone = false;
		char temp;
		int count = 0;
		try {
			while (suitDone == false) {
				temp = in.readChar();
				if (temp == ' ') {
					suitDone = true;
				} else if (count == 0) {
					suit = Character.toUpperCase(temp);
					count++;
				}
			}
			count = 0;
			while (suitDone == true && rankDone == false) {
				temp = in.readChar();
				if (count == 0) {
					rank = Character.toUpperCase(temp);
					rankDone = true;
					count++;				
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (isValidSuit(suit)) {
			if (isValidRank(rank)) {
				return new Card(suit, rank);
			}
		} else {
			return null;
		}
		return null;
	}
	
	// ---- instance variables -----------------------------------

	/*@
	   private invariant isValidSuit(suit);
	 */
	/**
	 * Suit of this card.
	 */
	private char suit;
	/*@
	   private invariant isValidRank(rank);
	 */
	/**
	 * Rank of this card..
	 */
	private char rank;

	// ---- constructors -----------------------------------

	/*@
	   requires isValidSuit(s) && isValidRank(r);
	 */
	/** 
	 * Creates a new Card with the given suit and rank.
	 * @param   s suit of the new card.
	 * @param   r rank of the new card.
	 */
	public Card(char s, char r) {
		assert isValidSuit(s) && isValidRank(r);
		suit = s;
		rank = r;
	}

	// ---- queries ---------------------------------------

	/*@
	   ensures isValidSuit(\result);
	 */
	/**
	 * Returns the suit of this card. 
	 * @return suit of this card.
	 */
	public char getSuit() {
		return suit;
	}

    /*@
       ensures isValidRank(\result);
    */
	/** 
	 * Returns the rank of this card. 
	 * @return rank of this card.
	 */
	public char getRank() {
		return rank;
	}

	/** Returns a String description of this card. */
	@Override
    public String toString() {
		String res;

		switch (getSuit()) {
    		case CLUBS:
    		    res = "Clubs";
    		    break;
    		case DIAMONDS:
    		    res = "Diamonds";
    		    break;
    		case HEARTS:
    		    res = "Hearts";
    		    break;
    		default:
    		    res = "Spades";
		}
		res += " ";
		switch (getRank()) {
    		case TEN:
    		    res += "10";
    		    break;
    		case JACK:
    		    res += "jack";
    		    break;
    		case QUEEN:
    		    res += "queen";
    		    break;
    		case KING:
    		    res += "king";
    		    break;
    		case ACE:
    		    res += "ace";
    		    break;
    		default:
    		    res += getRank();
		}

		return res;
	}

	/**
	 * Tests if this card is equal to another (i.e., same suit and rank).
	 * @param  obj Card to be compared.
	 * @return <code>true</code> if the suit and rank of <code>obj</code> 
	 *         are the same as of this Card.
	 */
	@Override
    public boolean equals(Object obj) {
		if (!(obj instanceof Card)) {
			return false;
		}
		Card card = (Card) obj;
		return this.getSuit() == card.getSuit()
				&& this.getRank() == card.getRank();
	}

	/**
	 * Overwrites the hashcode from Object.
	 */
	@Override
    public int hashCode() {
		return 100 * rank + suit;
	}

	/*@
	   requires card != null;
	 */
	/**
	 * Tests if this Card is less in suit than another Card.
	 * @see #suitLessThan(char, char)
	 * @param   card Card for the comparison.
	 * @return  <code>true</code> if the suit of this Card is less than that of <code>card</code>.
	 */
	public boolean ltSuit(Card card) {
		return suitLessThan(this.getSuit(), card.getSuit());
	}

    /*@
       requires card != null;
     */
	/**
	 * Tests if this Card is less in rank that another Card.
	 * @see #rankLessThan(char, char)
	 * @param   card Card for the comparison
	 * @return  <code>true</code> if the rank of this Card is less than that of <code>kaart</code>.
	 */
	public boolean ltRank(Card card) {
		return rankLessThan(this.getRank(), card.getRank());
	}

    /*@
       requires card != null;
     */
	/**
	 * Tests if this Card is directly followed in rank by another Card.
	 * Does not consider suit.
	 * see {@link #isRankFollowing(char, char)}
	 * @param   card Card for the comparison.
	 * @return  <code>true</code> if the rank of this Card directly precedes the rank of <code>card</code>.
	 */
	public boolean isInRankBefore(Card card) {
		return isRankFollowing(this.getRank(), card.getRank());
	}
}
