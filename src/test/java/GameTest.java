import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.Game;
import ru.netology.javaqa.NotRegisteredException;
import ru.netology.javaqa.Player;

public class GameTest {

    @Test
    public void testSecondPlayerWin() {
        Player arnold = new Player(1488, "Арнольд", 200);
        Player silvestr = new Player(1072, "Сильвестр", 180);
        Game game = new Game();
        game.register(arnold);
        game.register(silvestr);
        int actual = game.round("Сильвестр", "Арнольд");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayer1() {

        Player arnold = new Player(1488, "Сильвестр", 200);
        Player silvestr = new Player(1072, "Арнольд", 180);
        Game game = new Game();
        game.register(arnold);
        game.register(silvestr);

        int actual = game.round("Сильвестр", "Арнольд");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFirstPlayer2() {

        Player arnold = new Player(148, "Сильвестр", 200);
        Player silvestr = new Player(107, "Арнольд", 200);
        Game game = new Game();
        game.register(arnold);
        game.register(silvestr);

        int actual = game.round("Сильвестр", "Арнольд");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test1NoExist() {
        Player arnold = new Player(1, "Арнольд", 21);
        Game game = new Game();
        game.register(arnold);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Джон", "Арнольд")
        );
    }

    @Test
    public void test2NoExist() {
        Player arnold = new Player(1, "Арнольд", 200);
        Game game = new Game();
        game.register(arnold);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Арнольд", "Джон")
        );

    }
}
