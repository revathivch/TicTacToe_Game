import BoardGame.*;
public class TicTacToe{
    BoardGame.Player[] players;
    BoardGame.Piece[] pieces;
    BoardGame.Board board;
    BoardGame.State state;



    TicTacToe(int r, int c){

        players = new BoardGame.Player[2];
        pieces = new BoardGame.Piece[2];


        for(int i=0; i<2; i++){   // One player can have multiple pieces to play with but here in tic-tac-toe we are only assigning one piece to a player which is either x or 0
            String val = Integer.toString(i+1);
            players[i] = new BoardGame.Player(val, 1, 0);
            if(i==0){
                players[i].assignPiece("X", 0);
            }
            else{
                players[i].assignPiece("O", 0);
            }

        }

        state = new State(0, players[0]);

        if((r<0 || r>10) || (r != c)){
            System.out.println("Invalid Input, please enter a value in the range of 0-10");
        }
        else {
            board = new BoardGame.Board(r,c);
        }
    }

    public Player nextPlayer(){ // Returns the index of the next player
        if(state.currentPlayer.equals(players[0])){
            return players[1];
        }
        else{
            return players[0];
        }
    }

    public String checkGameOver(){

        int d= board.rows;
        String return_val="";
        int matrix_full = 0; //0 for full and 1 for not full

        // Checking the rows for a pattern match
        for(int i=0; i<d; i++){
            int countX = 0;
            int countO = 0;
            for(int j=0; j<d; j++){
                if(board.board[i][j] != null){
                    if(board.board[i][j].equals("X")){
                        countX++;
                    }   else if(board.board[i][j].equals("O")){
                        countO++;
                    }

                }
                else{
                    matrix_full = 1;
                    break;
                }

            }
            if(countX == d){
                return_val = "X";
            }
            if(countO == d){
                return_val= "O";
            }
        }


        // Checking the columns ofr a pattern match
        for(int i=0; i<d; i++){
            int countX = 0;
            int countO = 0;
            for(int j=0; j<d; j++){
                if(board.board[j][i] != null){
                    if(board.board[j][i].equals("X")){
                        countX++;
                    }   else if(board.board[j][i].equals("O")){
                        countO++;
                    }
                }
                else{
                    matrix_full = 1;
                    break;
                }

            }
            if(countX == d){
                return_val =  "X";
            }
            if(countO == d){
                return_val =  "O";
            }
        }


        //Checking for right diagonal pattern match

        int rdcountX = 0;
        int rdcountY = 0;
        for(int i=0; i<d; i++){
            if(board.board[i][d-1-i] != null){
                if(board.board[i][d-1-i].equals("X")){
                    rdcountX++;
                }
                else if(board.board[i][d-1-i].equals("O")){
                    rdcountY++;
                }
                if(rdcountX == d){
                    return_val = "X";
                }
                if(rdcountY == d){
                    return_val = "O";
                }
            }
            else{
                matrix_full = 1;
            }

        }

        // Checking for left diagonal pattern matching
        int ldcountX = 0;
        int ldcountY = 0;
        for(int i=0; i<d; i++){
            if(board.board[i][i] != null){
                if(board.board[i][i].equals("X")){
                    ldcountX++;
                }
                else if(board.board[i][i].equals("O")){
                    ldcountY++;
                }
                if(ldcountX == d){
                    return_val= "X";
                }
                if(ldcountY == d){
                    return_val = "O";
                }
            }
            else{
                matrix_full = 1;
            }

        }

        if(matrix_full == 0 && (return_val.equals("X") || return_val.equals("Y"))){
            return return_val;
        }
        if(matrix_full == 0 && (return_val.equals(""))){
            return_val = "Matrix_Full";
        }
        if(matrix_full == 1 && (return_val.equals(""))){
            return_val = "Continue";
        }

        return(return_val);
    }



}

