import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class MarathonQualifierTestDongDuLieu {
    @Test
    public void testCase1() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = 1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("Khong dat", result);
    }

    @Test
    public void testCase2() {
        LocalDate reviewDate = LocalDate.of(2024, 1, 20);
        int runTime = 1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase3() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = -1000;
        int ranking = 66;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("invalid", result);
    }

    @Test
    public void testCase4() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = 1000;
        int ranking = -65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("invalid", result);
    }

    @Test
    public void testCase5() {
        LocalDate reviewDate = LocalDate.of(2024, 1, 20);
        int runTime = 1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase6() {
        LocalDate reviewDate = LocalDate.of(2024, 1, 20);
        int runTime = 8000;
        int ranking = 10;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase7() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = 1000;
        int ranking = -65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("invalid", result);
    }

    @Test
    public void testCase8() {
        LocalDate reviewDate = LocalDate.of(2021, 1, 20);
        int runTime = 1000;
        int ranking = 65;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("Khong dat", result);
    }

    @Test
    public void testCase9() {
        LocalDate reviewDate = LocalDate.of(2024, 1, 20);
        int runTime = 8000;
        int ranking = 10;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("dat", result);
    }

    @Test
    public void testCase10() {
        LocalDate reviewDate = LocalDate.of(2024, 1, 20);
        int runTime = 8000;
        int ranking = 100;
        String result = MarathonQualifier.checkQualification(reviewDate, runTime, ranking);
        assertEquals("Khong dat", result);
    }
}
