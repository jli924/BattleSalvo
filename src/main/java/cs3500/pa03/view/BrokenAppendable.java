package cs3500.pa03.view;

import java.io.IOException;

/**
 * Broken appendable for testing
 */
public class BrokenAppendable implements Appendable{
  /**
   * Implementing methods for the broken appendable
   */
  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException();
  }

  /**
   * Implementing methods for the broken appendable
   */
  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException();
  }

  /**
   * Implementing methods for the broken appendable
   */
  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException();
  }
}
