import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.Feline;
import com.example.Lion;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Mock
    private Feline feline;

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane() {
        assertTrue("На словах ты Лев Толстой, а на деле.. Лев без гривы!!", lion.doesHaveMane());
    }

    @Test
    public void testDoesNotHaveManeForFemale() throws Exception {
        Lion femaleLion = new Lion("Самка", feline);
        assertFalse("Самка льва не должна иметь гриву!", femaleLion.doesHaveMane());
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(expectedList);

        List<String> actualFood = lion.getFood();
        assertEquals("Что же у вас Лев ест??", expectedList, actualFood);
    }

    @Test
    public void testConstructorThrowsExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Средний род", feline));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void testGetKittens() {
        when(feline.getKittens()).thenReturn(3);
        assertEquals("Количество львят не совпадает", 3, lion.getKittens());
    }
}
