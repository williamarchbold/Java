package edu.frontrange.csc240.a10.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * This class has two functions that are used for regular expression matching. 
 * This class was written to specifically look for certain search criterion in a 
 * static string called TEXT in a class called Text. 
 *
 * @author William Archbold, S02369823
 * @version 2018-11-13, CSC-240 Assignment 10 DataMiner.java 
 */
public class DataMiner {
    
    /**
     * This is the main function of the class DataMiner. No DataMiner objects
     * are required to run this method therefore it is static. This method will
     * call the method hunt 5 times. 
     * 
     * I used the following video to help me understand regular expressions: 
     *  https://www.youtube.com/watch?v=sa-TUpSx1JA&t=1667s
     * 
     * @param args 
     */
    
    public static void main(String...args) {

       hunt("Web page references:", "((http\\:\\/\\/|https\\:\\/\\/|www\\.)([^ \n\r]*\\.)*[^ .\n\r]+)[ \n\r]", 0, true);        
       
       hunt("Lines:", "\r\n|\r|\n", 1, false);

       hunt("Course numbers:", "[^A-Za-z][A-Za-z]{3}[- ]?\\d{3}[\\D]", 0, false);
       
       hunt("Phone numbers:", "[\\D]([(]?\\d{3}[)]?[- ]?\\d{3}[- ]?\\d{4})[\\D]", 0, false);

       hunt("Dates:", "(\\d?\\d\\/\\d?\\d\\/(\\d{2})?\\d{2})"
               + "|([^A-Za-z](January|February|March|April|May|June|July|August|September|October|November|December) "
               + "\\d?\\d)(, (\\d{2})?\\d{2})?\\D",
               0, false);
    }
    
    /**      
    * This method looks for matching search criteria. 
    * I used the below website to find out how to use Matcher and search the TEXT
    * string and add up the matches. 
    * https://stackoverflow.com/questions/2850203/count-the-number-of-lines-in-a-java-string/2850495#2850495
    * 
    * I used the below website to find out how to print matches. 
    * https://stackoverflow.com/questions/836704/print-regex-matches-in-java
    * 
    * @param String name        A string that will be used as std output to provide
    *                               the reader with context of the search results
    * @param String pattern     This is the regular expression based search criteria 
    * @param int initial Value  The starting number for number of matches of 
    *                               search criteria
    * @param boolean printResult If true, print matches to screen
    */
    private static void hunt(String name, String pattern, int initialValue, boolean printResult) {
       
        Matcher m = Pattern.compile(pattern).matcher(Text.TEXT);
        int count = initialValue;
        int websiteCount = 1;
        while (m.find()) { 
            if (printResult == true) {
                System.out.printf("(%d) Found web page reference: %s\n", websiteCount, m.group(1));
                websiteCount++;
            }
            count++;
        }  
        System.out.printf("%s %d \n", name, count);
    }
}
