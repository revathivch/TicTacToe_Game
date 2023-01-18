package BoardGame;

public class Player {
    public String name;
    int count_pieces; // Stores the number of pieces that belong to a particular player
    public Piece[] piece_list;

    public int score;

    public Player(String name, int cp, int score){
        this.name = name;
        this.count_pieces = cp;
        this.score = score;
        piece_list = new Piece[cp];
    }

    public void assignPiece(String name, int index){ // To assign a name to a piece at the index passed
        piece_list[index] = new Piece(name);
    }


}
