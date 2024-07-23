import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

public class MarathonQuailifierTest {
    @Test
    public void testCase1() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = -1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("invalid", result);
    }

    @Test
    public void testCase2() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = 1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("Khong dat", result);
    }

    @Test
    public void testCase3() {
        LocalDate reviewDate = LocalDate.of(2023, 1, 20);
        int runTime = 6000;
        int ranking = 70;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase4() {
        LocalDate reviewDate = LocalDate.of(2023, 1, 20);
        int runTime = 8000;
        int ranking = 30;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase5() {
        LocalDate reviewDate = LocalDate.of(2023, 1, 20);
        int runTime = 8000;
        int ranking = 100;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("Khong dat", result);
    }
}
