import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class TestFailure {

	@Test
	public void testHello() {
        String message = "Hello World!";
        Assert.assertEquals(12, message.length());
	}
}
