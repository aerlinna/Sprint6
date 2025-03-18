import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;
import org.mockito.Spy;
import com.example.Feline;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineTests {

    @Spy
    private Feline feline;

    @Before
    public void setUp() {
        feline = Mockito.spy(new Feline());
    }

    @Test
    public void testFood() throws Exception {
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals("Ммм, животные, птицы и рыба! Кошачий рай!", List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testUnknownFood() throws Exception {
        when(feline.eatMeat()).thenThrow(new Exception("Неизвестное животное"));
        Exception exception = assertThrows(Exception.class, () -> feline.eatMeat());
        assertEquals("Неизвестное животное", exception.getMessage());
    }

    @Test
    public void familyIsCorrect() {
        Assert.assertEquals("Неверное семейство", "Кошачьи", feline.getFamily());
    }

    @Test
    public void defaultKittensIsOne() {
        assertEquals("Неверное число котят", 1, feline.getKittens());
    }

    @Test
    public void kittensCountIsFive() {
        assertEquals("Неверное число котят с параметром", 5, feline.getKittens(5));
    }
}
