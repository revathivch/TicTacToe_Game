import BoardGame.*;

public class OrderAndChaos {
    BoardGame.Player[] players;
    BoardGame.Piece[] pieces;
    BoardGame.Board board;
    BoardGame.State state;



    OrderAndChaos(int r, int c){ // Order and chaos will strictly have 6*6 matrix

        players = new BoardGame.Player[2];
        pieces = new BoardGame.Piece[2];


        for(int i=0; i<2; i++){   // One player can have multiple pieces to play with but here in order and chaos we are only assigning one piece to a player which is either x or 0

            if(i==0){
                players[i] = new BoardGame.Player("Order", 2, 0);
            }
            else{
                players[i] = new BoardGame.Player("Chaos", 2, 0);
            }

            players[i].assignPiece("X", 0);
            players[i].assignPiece("O", 1);

        }

        state = new State(0, players[0]);
        board = new BoardGame.Board(r,c);

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

        int d= 5;
        String return_val="";
        int matrix_full = 0; //0 for full and 1 for not full

        // Checking the rows for a pattern match

        for(int i=0; i<d; i++){
            int countX = 0;
            int countO = 0;
            for(int j=0; j<d; j++){
                if(i==1 || i==2 || i==3 || i==4){
                    if(board.board[i][j] == null){
                        break;
                    }
                }
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




        // Checking the columns for a pattern match

        for(int i=0; i<d; i++){
            int countX = 0;
            int countO = 0;
            for(int j=0; j<d; j++){
                if(i==1 || i==2 || i==3 || i==4){
                    if(board.board[i][j] == null){
                        break;
                    }
                }
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

        // Checking for the diagonal next to right diagonal
        int ldrcountX = 0;
        int ldrcountY = 0;
        for(int i=0; i<d; i++){
            if(board.board[i][i+1] != null){
                if(board.board[i][i+1].equals("X")){
                    ldrcountX++;
                }
                else if(board.board[i][i+1].equals("O")){
                    ldrcountY++;
                }
                if(ldrcountX == d){
                    return_val= "X";
                }
                if(ldrcountY == d){
                    return_val = "O";
                }
            }
            else{
                matrix_full = 1;
            }

        }


        // Checking for the diagonal right next to left diagonal

        if(board.board[0][1] != null && board.board[1][2] != null && board.board[2][3] != null && board.board[3][4] != null && board.board[4][5] != null){
            if(board.board[0][1].equals("X") && board.board[1][2].equals("X") && board.board[2][3].equals("X") && board.board[3][4].equals("X") && board.board[4][5].equals("X")){
                return_val = "X";
            }
        }
        if(board.board[0][1] != null && board.board[1][2] != null && board.board[2][3] != null && board.board[3][4] != null && board.board[4][5] != null){
            if(board.board[0][1].equals("O") && board.board[1][2].equals("O") && board.board[2][3].equals("O") && board.board[3][4].equals("O") && board.board[4][5].equals("O")){
                return_val = "O";
            }
        }

        // lower diagonal

        if(board.board[1][0] != null && board.board[2][1] != null && board.board[3][2] != null && board.board[4][3] != null && board.board[5][4] != null){
            if(board.board[1][0].equals("O") && board.board[2][1].equals("O") && board.board[3][2].equals("O") && board.board[4][3].equals("O") && board.board[5][4].equals("O")){
                return_val = "O";
            }
        }

        if(board.board[1][0] != null && board.board[2][1] != null && board.board[3][2] != null && board.board[4][3] != null && board.board[5][4] != null){
            if(board.board[1][0].equals("X") && board.board[2][1].equals("X") && board.board[3][2].equals("X") && board.board[4][3].equals("X") && board.board[5][4].equals("X")){
                return_val = "X";
            }
        }


        // Checking for the upper diagonal right next to right diagonal

        if(board.board[0][4] != null && board.board[1][3] != null && board.board[2][2] != null && board.board[3][1] != null && board.board[4][0] != null){
            if(board.board[0][4].equals("X") && board.board[1][3].equals("X") && board.board[2][2].equals("X") && board.board[3][1].equals("X") && board.board[4][0].equals("X")){
                return_val = "X";
            }
        }
        if(board.board[0][4] != null && board.board[1][3] != null && board.board[2][2] != null && board.board[3][1] != null && board.board[4][0] != null){
            if(board.board[0][4].equals("O") && board.board[1][3].equals("O") && board.board[2][2].equals("O") && board.board[3][1].equals("O") && board.board[4][0].equals("O")){
                return_val = "O";
            }
        }

        // lower diagonal

        if(board.board[1][4] != null && board.board[2][4] != null && board.board[3][3] != null && board.board[4][2] != null && board.board[5][1] != null){
            if(board.board[1][0].equals("O") && board.board[2][1].equals("O") && board.board[3][2].equals("O") && board.board[4][3].equals("O") && board.board[5][4].equals("O")){
                return_val = "O";
            }
        }

        if(board.board[1][4] != null && board.board[2][4] != null && board.board[3][3] != null && board.board[4][2] != null && board.board[5][1] != null){
            if(board.board[1][4].equals("X") && board.board[2][4].equals("X") && board.board[3][3].equals("X") && board.board[4][2].equals("X") && board.board[5][1].equals("X")){
                return_val = "X";
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
