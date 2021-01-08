package com.war.stack;

import java.util.Objects;
import java.util.Stack;

/**
 * @author Syed Anwaruddin Hashmi (anwar@lumity.com)
 */
public class BalancedBrackets {
  private String brackets = "[{()}]";
  private int bracketCount = 3;

  public boolean isBalanced(String exp) {
    Stack<Character> stack = new Stack<>();
    if (Objects.isNull(exp) || exp.trim().isEmpty()) {
      return false;
    } else {
      for (int i = 0; i < exp.length(); i++) {
        Character c = exp.charAt(i);
        int idx = brackets.indexOf(c);
        int revIdx = 2 * bracketCount - 1 - idx;
        if (idx < bracketCount) {
          stack.push(c);
        } else {
          if (stack.isEmpty() || brackets.indexOf(stack.peek().toString()) != revIdx) {
            return false;
          } else {
            stack.pop();
          }
        }
      }
      return stack.isEmpty();
    }
  }
}
