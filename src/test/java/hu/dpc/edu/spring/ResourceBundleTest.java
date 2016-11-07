package hu.dpc.edu.spring;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.Assert.assertEquals;

/**
 * Created by vrg on 2016. 11. 07..
 */
public class ResourceBundleTest {

    @Test
    public void testResBundle() {
        final ResourceBundle resourceBundle = ResourceBundle.getBundle("hu.dpc.edu.spring.messages", new Locale("hu"));
        final String welcome = resourceBundle.getString("welcome");
        System.out.println(welcome);
        assertEquals("Udv, kedves {0}!", welcome);
    }
}

