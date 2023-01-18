package BoardGame;

public class Board {
    public int rows;
    int columns;
    public String[][] board;

    public Board(int r, int c){
        this.rows = r;
        this.columns = c;
        this.board = new String[r][c]; // A board of size r*c will be created
    }

    public int insertIntoBoard(int loc, String value){
        int x, y;
        if((loc%columns) == 0){
            x = (loc/columns) - 1;
            y = (columns-1);
        }

        else{
            x = (loc/columns);
            y = ((loc%columns) - 1);
        }

        if(board[x][y] != null){
            System.out.println("Cannot insert value into the entered location as it is already occupied, Please choose another location");
            return 0;
        }
        else{
            board[x][y] = value;
            return 1;
        }

    }




    public void displayCurrentBoard(){
        for(int i =0; i<rows; i++){
            String str1 = "";
            String str2 = "";

            for(int j=0; j<columns; j++){
                if(j != columns-1){
                    str1 = str1 + "+---";
                    if(board[i][j] == null){
                        str2 = str2 + "| " + " " + " ";
                    }
                    else{
                        str2 = str2 + "| " + board[i][j] + " ";
                    }

                }
                else{
                    str1 = str1 + "+---+";
                    if(board[i][j] == null){
                        str2 = str2 + "| " + " " + " |";
                    }
                    else{
                        str2 = str2 + "| " + board[i][j] + " |";
                    }

                }
            }
            System.out.println(str1);
            System.out.println(str2);
            if(i==rows-1){
                System.out.println(str1);
            }

        }

        System.out.println("");
    }

    public void displayInstructionBoard(){

        for(int i =0; i<rows; i++){
            String str1 = "";
            String str2 = "";

            for(int j=0; j<columns; j++){
                if(j != columns-1){
                    str1 = str1 + "+---";

                    int ind = (columns*(i)) + (j+1);    //The index of the cell to be displayed
                    String s = Integer.toString(ind);
                    str2 = str2 + "| " + s + " ";
                }
                else{
                    str1 = str1 + "+---+";

                    int ind = (columns*(i)) + (j+1);    //The index of the cell to be displayed
                    String s = Integer.toString(ind);
                    str2 = str2 + "| " + s + " |";
                }
            }
            System.out.println(str1);
            System.out.println(str2);
            if(i==rows-1){
                System.out.println(str1);
            }

        }

    }

}