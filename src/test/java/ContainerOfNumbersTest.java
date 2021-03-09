import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContainerOfNumbersTest {
    @Test
    public void addTest(){
        СontainerOfNumbers arrayTest = new СontainerOfNumbers();
        assertEquals(0, arrayTest.size());
        assertEquals(0, arrayTest.size());

        arrayTest.addNumb(1);
        assertEquals(1, arrayTest.size());

        arrayTest.addNumb(2);
        arrayTest.addNumb(3);
        assertEquals(3, arrayTest.size());
    }

    @Test
    public void removeTest(){
        СontainerOfNumbers arrayTest = new СontainerOfNumbers();
        for(int i = 0; i < 8; i++)
            arrayTest.addNumb(i);

        arrayTest.removeNumbInd(5);
        assertEquals(7, arrayTest.size());

        arrayTest.removeNumb(7);
        arrayTest.removeNumb(6);
        assertEquals(5, arrayTest.size());
    }

    @Test
    public void extractTest(){
        СontainerOfNumbers arrayTest = new СontainerOfNumbers();
        for(int i = 0; i < 8; i++)
            arrayTest.addNumb(i);

        int a = arrayTest.extractNumb(3);
        assertEquals(3, a);
    }

    @Test
    public void createNewArrTest(){
        СontainerOfNumbers arrayTest = new СontainerOfNumbers();
        for(int i = 0; i < 12; i++)
            arrayTest.addNumb(i);

        assertEquals(arrayTest.size(), 12);
    }
}
