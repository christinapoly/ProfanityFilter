import java.util.Scanner;
import java.util.ArrayList;

public class ProfanityFilter {

  Scanner scanner = new Scanner(System.in);
  String[] swear_words_array;  
  ArrayList<String> final_text_arraylist = new ArrayList<String>();


  public void askInput() {
    String first_line = scanner.nextLine(); //isolate the first line
    if (first_line == "") {
      while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
      } 
    }
    else {
      swear_words_array = first_line.split(" "); //make the first line an array
    }
    
    //String swear_words_string = Arrays.toString(swear_words_array); 
    //System.out.println(swear_words_string);
    
    String text = "";
    String total_text = "";
    
    while(scanner.hasNextLine()) {
      Scanner line = new Scanner(scanner.nextLine());

      while (line.hasNext()) {
        String next_word = line.next(); //read next word
        boolean hasPunctuation = false;
        char character = '.';

        if (next_word.endsWith(".") || next_word.endsWith(",") || next_word.endsWith("!") || next_word.endsWith("?")) {
          character = next_word.charAt(next_word.length() - 1); //last character of next_word
          next_word = next_word.substring(0, next_word.length()-1);
          hasPunctuation = true;

        
        }
    
          for (int i=0; i < swear_words_array.length; i++) { //compare curse word array with the input word
            if (swear_words_array[i].equalsIgnoreCase(next_word)) {
              
              next_word = "";
    
              for (int j=0; j<swear_words_array[i].length(); j++) {
                if (j%5 == 0) {
                  next_word = next_word + "*";
                } else if (j%5 == 1) {
                  next_word = next_word + "&";
                } else if (j%5 == 2) {
                  next_word = next_word + "#";
                } else if (j%5 == 3) {
                  next_word = next_word + "$";
                } else if (j%5 == 4) {
                  next_word = next_word + "%";
                }
              }
    
            } 

          }  

          if (hasPunctuation == true) {
            next_word = next_word + character;
          }


        if (text == "") {
          text = next_word;
        } else {
        text = text + " " + next_word;
        }
        
        
      } 

      if (scanner.hasNextLine()) {
       total_text = total_text + text + "\n";
      } else {
        total_text = total_text + text;
      }
      text = "";


    }

    scanner.close();
    System.out.println(total_text);

    
      
      

    }


    

  public static void main(String[] args) {
    ProfanityFilter pf = new ProfanityFilter();
    pf.askInput();
    
  }

}

