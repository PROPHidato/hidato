package domini.Basic;


public class Match extends Player extends Game{
  int playerID;
  int gameID;
  int time;
  int hints;
  int result;
  
  public Match(int gameID, int playerID, int difficult) {
  
    this.gameID = gameID;
    this.playerID = playerID;
    time = 0;
    hints = 0;
    result = -1;  //no hi ha resultat encara

  }
  
  public int getTime() {
    return time;
  }
  
  public void setTime(int time) {
    this.time = time;
  }
  
  public int getHints() {
    return hints;
  }
  
  public void setHints(int hints) {
    this.hints = hints;
  }
  
  public int getResult() {
    return result;
  }
  
  public void setResult(int result) {
    this.result = result;
  }

}
