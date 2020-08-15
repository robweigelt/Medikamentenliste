package practiceManagementSoftware;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class HelperFunctionsTest {


    @Test
    void makeStringToCapital() {
        HelperFunctions HelperFunctions = new HelperFunctions();
        String input = "paracetamol";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("PARACETAMOL", HelperFunctions.makeStringToCapital());

        String dummy = "paracetamol";
        InputStream dummyin = new ByteArrayInputStream(dummy.getBytes());
        System.setIn(dummyin);


        assertNotEquals("paracetamol",HelperFunctions.makeStringToCapital());

    }

    @Test
    void getList() {
        HelperFunctions HelperFunctions = new HelperFunctions();
        List<String> Starter = Arrays.asList("one", "two", "three");
        List<String> Comparer = Arrays.asList("ONE", "TWO", "THREE");
        List<String> Dummy = Arrays.asList("OnE", "tWO", "THREe");

        assertEquals(Comparer,HelperFunctions.getList(Starter));
        assertNotEquals(Dummy,HelperFunctions.getList(Starter) );

    }
}