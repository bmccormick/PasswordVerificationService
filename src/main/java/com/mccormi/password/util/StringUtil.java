package com.mccormi.password.util;

import java.util.Random;

public class StringUtil {
  
  private static final char[] randomCharacterLower = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
      'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
  
  private static final char[] randomCharacter = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
      'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
      'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
  private static Random random = new Random();
  
  public static String suggestRandom(int length) {
    return suggestRandom(length, false);
  }
  
  public static String suggestRandom(int length, boolean useLowerCase) {
    StringBuilder r = new StringBuilder();
    if (useLowerCase) {
      for (int i = 0; i < length; i++) {
        r.append(randomCharacterLower[random.nextInt(StringUtil.randomCharacterLower.length)]);
      }
    } else {
      for (int i = 0; i < length; i++) {
        r.append(randomCharacter[random.nextInt(StringUtil.randomCharacter.length)]);
      }
    }
    return r.toString();
  }
  
}
