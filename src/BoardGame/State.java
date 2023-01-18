package BoardGame;

public class State {
    public int value; // Specifies whether the game is over or not
    public Player currentPlayer;

    public State(int val, Player p){
        this.value = val;
        currentPlayer = p;
    }

    public void assignCurrentPlayer(Player p){
        currentPlayer.name = p.name;
        currentPlayer.count_pieces = p.count_pieces;
        currentPlayer.piece_list = p.piece_list;
        currentPlayer.score = p.score;
    }
}
