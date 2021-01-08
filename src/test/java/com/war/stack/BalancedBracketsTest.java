package com.war.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Syed Anwaruddin Hashmi (anwar@lumity.com)
 */
public class BalancedBracketsTest {

  private BalancedBrackets balancedBrackets = new BalancedBrackets();

  @Test
  public void EmptyOrNull() {
    Assert.assertFalse(balancedBrackets.isBalanced(null));
    Assert.assertFalse(balancedBrackets.isBalanced(""));
  }

  @Test
  public void closeBracketBeforeOpen() {
    Assert.assertFalse(balancedBrackets.isBalanced(")("));
    Assert.assertFalse(balancedBrackets.isBalanced("())"));
    Assert.assertFalse(balancedBrackets.isBalanced("()("));
    Assert.assertTrue(balancedBrackets.isBalanced("()()()()()()()()({[]})"));
    Assert.assertTrue(balancedBrackets.isBalanced("({({({({({({({({({({({({({({({({({({({({({({({({({" +
                                                       "})})})})})})})})})})})})})})})})})})})})})})})})})"));
  }
}
