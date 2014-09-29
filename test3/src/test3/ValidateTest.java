/**
 * 
 */
package test3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author hash
 *
 */
public class ValidateTest {

	/**
	 * Test method for {@link test3.Validate#isValidName(java.lang.String)}.
	 */
	@Test
	public final void testIsValidName() {
		assertEquals(true, Validate.isValidName("James"));
	}

	/**
	 * Test method for {@link test3.Validate#isValidEmail(java.lang.String)}.
	 */
	@Test
	public final void testIsValidEmail() {
		assertEquals(true, Validate.isValidEmail("hash.cv@gmail.com"));
	}

}
