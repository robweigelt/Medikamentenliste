package practiceManagementSoftware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MedicineGlossaryObjectTest {



    @Test
    void searchInsideListArray() {



        String result ="MedicineName=Zerbaxa\n" +
                "TherapeuticArea=Bacterial Infections\n" +
                "INN=ceftolozane / tazobactam\n" +
                "ActiveSubstance=ceftolozane sulfate, tazobactam sodium\n" +
                "ATC=J01\n" +
                "Company=Merck Sharp  Dohme Limited\n" +
                "PharmacotherapeuticGroup=Antibacterials for systemic use, \n";
        int tester = 2;
        ByteArrayOutputStream sink = new ByteArrayOutputStream();
        System.setOut(new PrintStream(sink, true));
        MedicineGlossaryObject.SearchInsideListArray(tester);
        assertThat(new String(sink.toByteArray()), containsString(result));


    }

    @Test
    void switcherMedCategories() {

    }

    @Test
    void testToString() {
    }

    @Test
    void selectSearch() {
    }
}