import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test2 {

	static void count(String str) {
		int five = 0;
		int three = 0;
		int seven = 0;
		// Create a char array of given String
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {

			// Declare a String with empty initialization
			String s = "";

			// When the character is not space
			/*
			 * while (i < ch.length && ch[i] != (' ') && ch[i] != '?' && ch[i] != '!' &&
			 * ch[i] != '.' && ch[i] != ',' && ch[i] != '-' && ch[i]!= ':' && ch[i]!=';'
			 * &&ch[i]!='(' && ch[i]!=')' &&ch[i]!='"' &&ch[i]!='-') {
			 * 
			 * // concat with the declared String
			 */

			while (i < ch.length && String.valueOf(ch[i]).matches("\\w")) {
				s = s + ch[i];
				i++;
			}
			if (s.length() == 5)
				five++;
			if (s.length() == 3)
				three++;
			if (s.length() == 7)
				seven++;

		}
		System.out.println("three letters: " + three);
		System.out.println("five letters: " + five);
		System.out.println("seven letters: " + seven);

	}

	public static void main(String[] args) throws IOException {
		// adding a txt file
		File file = new File("a.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] data = new byte[(int) file.length()];
		fis.read(data);
		fis.close();
		String str = new String(data, "UTF-8");

		String strArray[] = str.split("[.?!]");
		// System.out.println(strArray[17]);
		
		// Ex 1
		count(str);
		// Ex2
		System.out.println("Precise num of sentences: " + preciseSentences(str));

		// particular(str);
		//Ex #5
		for(int i=(strArray.length-3); i< strArray.length; i++) {
		connecting(strArray[i]);
		}
		System.out.println();
		System.out.println("words in txt: "+ count2(str));
		// Ex #5
		//connectingLast3(str);
		splittingSentences(str);
		// Ex #8
		String reverse = new StringBuilder(strArray[17]).reverse().toString();
		System.out.print(reverse);
		digits(str);
		getvalues(str);
		
		//int sum=0;
      /*  for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
               char digitStr = str.charAt(i);
                
            }          
			for (int y=0; y<digitStr.length; y++) {
            	
            }
        }*/

	}
	
	public static void getvalues(String s1) {
	    int sum = 0;
	    for (int i = 0; i < s1.length(); i++) {
	      char a = s1.charAt(i);
	      if (Character.isDigit(a)) {
	        int b = Integer.parseInt(String.valueOf(a));
	        sum = sum + b;
	      }
	    }
	    if (sum == 0) {
	      System.out.println(-1);
	    } else
	      System.out.println(sum);
	  }

	
	public static void digits (String str) {
		int sum=0;
		
		  for (int i = 0; i < str.length(); i++) {
	            if (Character.isDigit(str.charAt(i))) { 
	               char digitStr = str.charAt(i);
	              // sum= (sum + digitStr); 
	               sum = sum + Character.getNumericValue(str.charAt(i));
	              
	            }
	               // System.out.println(digitStr);
	                
	                     
				//for (int y=0; y<digitStr.length; y++) {	            	
	          //  }
	          
	        }
		 
 System.out.println(sum);
	}

	public static void splittingSentences(String str) {
		String strArray[] = str.split("[.?!]");
		for (int a = 0; a < strArray.length; a++) {
			// System.out.println(strArray[a]);
		}
		System.out.println("sentence count: " + strArray.length);

	}

	public static int preciseSentences(String str) {
		int sentenceCount = 0;
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '!' | ch[i] == '?' | ch[i] == '.' && ch[i - 2] != ' ')
				sentenceCount++;
		}
		return sentenceCount;
	}

	public static void connectingLast3(String str) {
		int sentenceCount = 0;
		String s = "";
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '!' | ch[i] == '?' | ch[i] == '.' && ch[i - 2] != ' '
					&& sentenceCount < preciseSentences(str) - 2)
				sentenceCount++;
			{

				if (sentenceCount == (preciseSentences(str) - 2)) {

					s = s + ch[i];

					String replaced = s.replace(("."), ",");
					String replaced2 = replaced.replace("?", ",");
					String replaced3 = replaced2.replace("!", ",");
					if (sentenceCount == preciseSentences(str)) {
						System.out.println(replaced3);
					}
				}
			}
		}
	}

	public static void connecting(String a) {

		// replacing character in this String
		/*String replaced = a.replace(("."), ",");
		String replaced2 = replaced.replace("?", ",");
		String replaced3 = replaced2.replace("!", ",");*/
		String replaced3 = a+",";
		System.out.print(replaced3);
		
		

	}

	public static int count2(String str) {
		if (str == null || str.isEmpty()) {
			return 0;
		}

		int wordCount = 0;

		boolean isWord = false;
		int endOfLine = str.length() - 1;
		char[] characters = str.toCharArray();

		for (int i = 0; i < characters.length; i++) {

			// if the char is a letter, word = true.
			if (Character.isLetter(characters[i]) && i != endOfLine) {
				isWord = true;

				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(characters[i]) && isWord) {
				wordCount++;
				isWord = false;

				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(characters[i]) && i == endOfLine) {
				wordCount++;
			}
		}

		return wordCount;
	}
}
