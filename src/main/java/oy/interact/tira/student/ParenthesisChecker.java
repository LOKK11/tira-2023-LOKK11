package oy.interact.tira.student;

import oy.interact.tira.util.StackInterface;

public class ParenthesisChecker {

   private ParenthesisChecker() {
   }

   /**
    * Student: Implement this method which checks if the given string has matching opening and closing
    * parentheses. It should check for matching parentheses:

    *   Lorem ipsum ( dolor sit {  amet, [ consectetur adipiscing ] elit, sed } do eiusmod tempor ) incididunt ut...,
    * 
    * that can be found for example in Java source code and JSON structures.
    * 
    * If the string has issues with parentheses, you should throw a {@code ParenthesisException} with a
    * descriptive message and error code. Error codes are already defined for you in the ParenthesesException
    * class to be used.
    * 
    * NOTE: If the string contains quotation marks ("like this"), the text between quotation marks 
    * MUST be ignored. Why? In structured text, the rule of the parentheses applies only to the structured
    * text but not the text in quotation marks. It is totally valid to have JSON:
    * 
    * {
    *    "somekey": "Some value [ with that opening bracket only" 
    * }
    *
    * and that is perfectly ok and acceptable, also in source code like Java.
    *
    * Note that the exception thrown must include correct line and column numbers of the
    * place where it became obvious that there are incorrect parenthesis in the input text.
    *
    * What is to be tested about the incoming string:
    *
    * - If a quotation mark was found, all characters until the next quotation mark must be ignored.
    *   And obviously, before and after, all charactes must be checked if they are parenthesis chars.
    * - When an opening parenthesis is found in the string, it is successfully pushed to the stack (push may fail).
    * - When a closing parenthesis is found in the string, chech that a matching opening parenthesis is popped from the stack.
    * - If the stack was empty, this indicates an error, too many opening parentheses (or too few closing ones).
    *   Note that you can check if the stack is empty before calling pop() and throw an exception.
    * - When the string has been handled, and if the stack still has parentheses, there are too few closing parentheses.
    * 
    * @param stack The stack object used in checking the parentheses from the string.
    * @param fromString A string containing parentheses to check if it is valid.
    * @return Returns the number of parentheses found from the input in total (both opening and closing).
    * @throws ParenthesesException if the parentheses did not match as intended.
    * @throws StackAllocationException If the stack cannot be allocated or reallocated if necessary.
    */
    public static int checkParentheses(StackInterface<Character> stack, String fromString) throws ParenthesesException {
      
      try {
         int line = 1;
         int column = 0;
         int parentheses = 0;
         // for each character in the input string
         for (int i = 0; i < fromString.length(); i++) {
            //increase column number
            column++;
            //if '\n' is found, increase value of row by one and reset
            //value of column back to 0.
            if (fromString.charAt(i) == '\n') {
               column = 0;
               line++;
               continue;
            }
            //if already between quotes
            if (!stack.isEmpty() && stack.peek() == '"') {
               //if character is '"'
               if (fromString.charAt(i) == '"') {
                  //remove '"' from stack and go to next char
                  stack.pop();
                  continue;
               }
               //else ignore character
               continue;
            }
            //if not between quotes, but character is '"'
            if (fromString.charAt(i) == '"') {
               //push '"' in stack and go to next char
               stack.push('"');
               continue;
            }
            //if character is an opening parenthesis -- one of "([{"
            //push it to stack and go to next char
            switch (fromString.charAt(i)) {
               case ('('):
                  stack.push('(');
                  parentheses++;
                  continue;
               case ('{'):
                  stack.push('{');
                  parentheses++;
                  continue;
               case ('['):
                  stack.push('[');
                  parentheses++;
                  continue;
            }
            //if character is a closing parenthesis -- one of ")]}"
            switch (fromString.charAt(i)) {
               case (')'):
                  //if stack is empty, throw "too many closing parentheses" -exception
                  if (stack.isEmpty()) {
                     throw new 
                     ParenthesesException("Too many closing parentheses", 
                     line, column, ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
                  }
                  //if stack.pop() doesn't return matching opening parenthesis,
                  //throw "parentheses in wrong order" -exception
                  if (stack.pop() != '(') {
                     throw new 
                     ParenthesesException(
                     "Parentheses in wrong order", 
                     line, column, ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
                  }
                  //else pop the matching parenthesis out and go to next char
                  parentheses++;
                  continue;
               case ('}'):
                  //if stack is empty, throw "too many closing parentheses" -exception
                  if (stack.isEmpty()) {
                     throw new 
                     ParenthesesException("Too many closing parentheses", 
                     line, column, ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
                  }
                  //if stack.pop() doesn't return matching opening parenthesis,
                  //throw "parentheses in wrong order" -exception
                  if (stack.pop() != '{') {
                     throw new 
                     ParenthesesException(
                     "Parentheses in wrong order", 
                     line, column, ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
                  }
                  //else pop the matching parenthesis out and go to next char
                  parentheses++;
                  continue;
               case (']'):
                  //if stack is empty, throw "too many closing parentheses" -exception
                  if (stack.isEmpty()) {
                     throw new 
                     ParenthesesException("Too many closing parentheses", 
                     line, column, ParenthesesException.TOO_MANY_CLOSING_PARENTHESES);
                  }
                  //if stack.pop() doesn't return matching opening parenthesis,
                  //throw "parentheses in wrong order" -exception
                  if (stack.pop() != '[') {
                     throw new 
                     ParenthesesException(
                     "Parentheses in wrong order", 
                     line, column, ParenthesesException.PARENTHESES_IN_WRONG_ORDER);
                  }
                  //else pop the matching parenthesis out and go to next char
                  parentheses++;
                  continue;
            }
         }
         // if the stack is not empty after all the characters have been handled
         if (!stack.isEmpty()) {
            //throw an exception since the string has more opening than closing parentheses.
            throw new 
            ParenthesesException(
            "Too many opening parentheses", 
            line, column, ParenthesesException.TOO_MANY_OPENING_PARENTHESES);
         } else {
            return parentheses;
         }
      } catch (OutOfMemoryError e) {
         throw new StackAllocationException("Memory problem during stack allocation");
      }
   }
}
