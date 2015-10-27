package domini.Basic;

public class Game {
  
  int gameId;
  int difficult;    // 1 = fàcil, 2 = mitjà, 3 = difícil
  
  
  public Game(int gameId, int difficult) {
    
    this.gameId = gameId;
    this.difficult = difficult;

  }
  
  public int getGameId() {
    return gameId;
  }
  
  public void setGameId(int gameId) {
    this.gameId = gameId
  }
  
  public int getDifficult() {
    return difficult;
  }
  
  public void setDifficult(int difficult) {
    this.difficult = difficult;
  }


}
