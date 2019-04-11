import java.util.Scanner;

public class CodedMessageApp {
	
	public String encrypt(String key, String message) {
		
		String newMessage = "";
		char next = ' ';
		int j = 0;

		int [] keys = new int[key.length()];           //declare a integer array to accept keys from string key
		
		for (int i = 0; i < keys.length; i++) {         //come up with the keys
			if (key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') keys[i] = ( key.charAt(i) - 'A') + 1;
			else keys[i] = 0;
		}
		
		for (int i = 0; i < message.length(); i++ ) {
			
			if (j >= keys.length) j= 0;                //make sure the iterator for the keys array doesn't go out of bounds
					
			if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {    // upper case letters in message
			     next = (char) (message.charAt(i) + (char)(keys[j]));     // use the current key to change current message letter
			     if (next > 'Z') next -= ('Z' - 'A' + 1);                 // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator                    
			
			}
			
			else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {   // lower case letters in message
			     next = (char) (message.charAt(i) + (char)(keys[j]));     // use the current key to change current message letter
			     if (next > 'z') next -= ('z' - 'a' + 1);                 // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator
		    }
			
			else if (message.charAt(i) >= '0' && message.charAt(i) <= '9') {  // number characters in message
			     next = (char) (message.charAt(i) + (char)(keys[j]));     // use the current key to change current message letter
			     while (next > '9') next -= ('9' - '0' + 1);              // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator
		
	        }
			
			else next = message.charAt(i);                               // if not an alphanumeric character put directly as next
			
			newMessage += next;                                          // add next into the coded message
	   }
		
		return newMessage;
		
	}
	
	public String decrypt(String key, String message) {
		String newMessage = "";
		char next = ' ';
		int j = 0;

		int [] keys = new int[key.length()];           //declare a integer array to accept keys from string key
		
		for (int i = 0; i < keys.length; i++) {         //come up with the keys
			if (key.charAt(i) >= 'A' && key.charAt(i) <= 'Z') keys[i] = ( key.charAt(i) - 'A') + 1;
			else keys[i] = 0;
		}
		
		for (int i = 0; i < message.length(); i++ ) {
			
			if (j >= keys.length) j= 0;                //make sure the iterator for the keys array doesn't go out of bounds
					
			if (message.charAt(i) >= 'A' && message.charAt(i) <= 'Z') {    // upper case letters in message
			     next = (char) (message.charAt(i) - (char)(keys[j]));     // use the current key to change current message letter
			     if (next < 'A') next += ('Z' - 'A' + 1);                 // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator                    
			
			}
			
			else if (message.charAt(i) >= 'a' && message.charAt(i) <= 'z') {   // lower case letters in message
			     next = (char) (message.charAt(i) - (char)(keys[j]));     // use the current key to change current message letter
			     if (next < 'a') next += ('z' - 'a' + 1);                 // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator
		    }
			
			else if (message.charAt(i) >= '0' && message.charAt(i) <= '9') {  // number characters in message
			     next = (char) (message.charAt(i) - (char)(keys[j]));     // use the current key to change current message letter
			     while (next < '0') next += ('9' - '0' + 1);              // account for key putting letter out of bounds
			     j++;                                                     // iterate the keys iterator
		
	        }
			
			else next = message.charAt(i);                                // leave none alphanumeric characters as is
			
			newMessage += next;
	   }
		
		return newMessage;
		
	}
	
	
	public static void main(String args[])  {
		
		CodedMessageApp code = new CodedMessageApp();
		
		String message, key, newMessage;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please Enter a message to be coded:");
		
	    message = scanner.nextLine();
	    
	    System.out.println("Please enter a key as a series of letters a-z");
	    
	    key = scanner.nextLine();
		
	    key = key.toUpperCase();
	    
	    newMessage = code.encrypt(key, message);
	    
	    System.out.println(newMessage);
	    
	    message = newMessage;
	    
	    newMessage = code.decrypt(key, message);
	    
	    System.out.println(newMessage);
	    
	}

}
