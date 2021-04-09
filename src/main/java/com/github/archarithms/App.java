package com.github.archarithms;


import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class App
{
  public static String convertToTitleCase(final String inpStr)
  {
    {
      //check for null
      if(inpStr == null) {
        throw new NullPointerException();
      }
      //make string lower case
      String input = inpStr.toLowerCase();
      //remove all non alpha numeric
      input = input.replaceAll("[^a-zA-Z0-9]"," ");
      //remove excess whitespace
      input = input.replaceAll("\\s+"," ");
      //Captialize Words
      char[] charArray = input.toCharArray();
      //set foundspace true so first letter is always capatilized
      boolean foundSpace = true;
      for(int i=0; i < charArray.length; i++)
      {
        if(Character.isLetter(charArray[i]) && foundSpace)
        {
          charArray[i] = Character.toUpperCase(charArray[i]);
          foundSpace = false;
        }
        if(charArray[i]==' ')
        {
          foundSpace=true;
        }
      }
      //return completed string
      return String.valueOf(charArray);
    }

  }

  public static String convertUnixToDateString(final Long inpUnixSeconds)
  {
    //check for null
    if(inpUnixSeconds==null)
    {
      throw new NullPointerException();
    }
    //convert from unix epoch time to human readable time
    else return LocalDateTime.ofInstant(Instant.ofEpochSecond(inpUnixSeconds),
            ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("MMMM d, YYYY"));
  }
}
