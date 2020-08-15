package practiceManagementSoftware;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

class GetIntOrStringTest {

    @org.junit.jupiter.api.Test
    public void getmyString() {
        GetIntOrString GetIntOrString = new GetIntOrString();
        String input = "paracetamol";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertEquals("paracetamol", GetIntOrString.GetmyString());

    }
    @org.junit.jupiter.api.Test
    public void getmyStringFail() {
        GetIntOrString GetIntOrString = new GetIntOrString();
        String input = "paracetamol";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertNotSame("vomex", GetIntOrString.GetmyString());

    }
    
}