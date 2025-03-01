package test;

import model.Game;
import persistence.GamePersistence;

import java.io.IOException;

public class TestGamePersistence {
  public static void main(String[] args) {
    GamePersistence p = new GamePersistence();

    testSaveArchive(p);

    try {
      p.readArchive();
      for (Game game : p.getGames()) {
        System.out.println(game);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void testSaveArchive(GamePersistence p) {
    Game g1 = new Game();
    p.add(g1);

    Game g2 = TestGameModel.generateGameExample1();
    p.add(g2);

    try {
      p.recordArchive();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
