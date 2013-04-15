import static org.junit.Assert.*;

import org.junit.Test;


public class CoutingCodeLinesTest {

	@Test
	public void voidString_should_return_cero() {
		String codigo ="";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(0, actual);
	}
	
	@Test
	public void oneCodeLine_should_return_one() {
		String codigo ="public interface Dave {";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(1, actual);
	}
	
	@Test
	public void oneCommentLine_should_return_cero() {
		String codigo ="// This file contains 3 lines of code";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(0, actual);
	}
	
	@Test
	public void CommentBlock_should_return_cero() {
		String codigo ="/** \n* count the number of lines in a file \n*/";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(0, actual);
	}
	
	@Test
	public void twoCodeLine_should_return_two() {
		String codigo ="public interface Dave { \n int countLines(File inFile); ";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(2, actual);
	}
	
	@Test
	public void twoCodeLineAndCommentLine_should_return_two() {
		String codigo ="// This file contains 3 lines of code\n public interface Dave { \n int countLines(File inFile);  ";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(2, actual);
	}
	
	@Test
	public void codeLine_should_return_three() {
		String codigo ="// This file contains 3 lines of code\n  public interface Dave {\n     /**\n      * count the number of lines in a file\n      */\n     int countLines(File inFile); // not the real signature!\n   }\n";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(3, actual);
	}
	
	@Test
	public void codeLine_should_return_five() {
		String codigo =" /*****\n   * This is a test program with 5 lines of code\n   *  \\/* no nesting allowed!\n   //*****//***/// Slightly pathological comment ending...\n  public class Hello {\n      public static final void main(String [] args) { // gotta love Java\n          // Say hello\n        System./*wait*/out./*for*/println/*it*/('Hello/*');\n      }\n\n  \n}\n";
		int actual = CountingCodeLines.count(codigo);
		assertEquals(5, actual);
	}


}
