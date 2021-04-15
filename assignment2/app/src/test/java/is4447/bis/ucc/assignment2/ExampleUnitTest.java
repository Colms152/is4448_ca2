package is4447.bis.ucc.assignment2;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void bGetBeer() throws IOException {
        ArrayList<Hero> response = HeroAdapter.getHeroes();
        System.out.println(response);
        assertEquals(1,1);
    }
    @Test
    public void bCreateBeer() throws IOException {
        Hero b = new Hero("-1", "Beamy", "Gazer", "4", "united");
        Hero createBeer = HeroAdapter.postCreateHero(b);
        System.out.println("output");
        assertEquals(1,1);
    }

    @Test
    public void bEditBeer() throws IOException {
        Hero b = new Hero("355", "Deadpool", "Ryan Reynolds", "5", "united");
        Hero createBeer = HeroAdapter.postUpdateHero(b);
        assertEquals(1,1);
    }

    @Test
    public void cDeleteBeer() throws IOException {
         int  id = 355;
         HeroAdapter.getDeleteHero(id);
        assertEquals(1,1);
    }
}