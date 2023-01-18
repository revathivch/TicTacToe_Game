import java.sql.SQLOutput;
import java.util.Scanner;
import BoardGame.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        char play;

        do {
            System.out.println("Please select the board game you would like to play by entering the index of the game as shown below");
            System.out.println("1. Tic Tac Toe");
            System.out.println("2. Order and Chaos");
            int chosen_game = console.nextInt();

            char ans;

            if (chosen_game == 1) {

                do {
                    System.out.println("Please enter the dimension of the square board (0-10)");
                    int rows = console.nextInt();
                    int cols = rows;

                    TicTacToe T = new TicTacToe(rows, cols);

                    System.out.println("Please enter position to insert X:");
                    T.board.displayInstructionBoard();

                    //T.state.assignCurrentPlayer(T.players[0]);
                    //T.state.currentPlayer = T.players[0];

                    int loc = console.nextInt();

                    T.board.insertIntoBoard(loc, T.state.currentPlayer.piece_list[0].name);

                    int entered = 1;  // Entered is the variable used to check if the user has inserted into an empty cell or not. The first insertion has to be into an empty cell

                    while(T.state.value != 1){

                        if(entered == 1){
                            T.state.currentPlayer = T.nextPlayer();
                            System.out.println("Please enter position to insert " + T.state.currentPlayer.piece_list[0].name);
                            System.out.println("Current state of the board");
                            T.board.displayCurrentBoard();
                            System.out.println("Refer below to get to choose the position:");
                            T.board.displayInstructionBoard();
                            loc = console.nextInt();
                            entered = T.board.insertIntoBoard(loc, T.state.currentPlayer.piece_list[0].name);

                        }
                        else{
                            System.out.println("Please enter position to insert " + T.state.currentPlayer.piece_list[0].name);
                            loc = console.nextInt();
                            entered = T.board.insertIntoBoard(loc, T.state.currentPlayer.piece_list[0].name);
                        }

                        String current_game_status = T.checkGameOver();
                        if(current_game_status.equals("Matrix_Full")){
                            System.out.println("The game has reached a draw. Great Play !");
                        }
                        if(current_game_status.equals("Continue")){
                            continue;
                        }
                        else{
                            System.out.println("Congratulations! Player " + T.state.currentPlayer.piece_list[0].name + "has won");

                            if(T.state.currentPlayer.name.equals(T.players[0].name)){
                                T.players[0].score = T.players[0].score + 1;
                            }
                            else{
                                T.players[1].score = T.players[1].score + 1;
                            }

                            System.out.println("Score of player " + T.players[0].name + " is: "+ T.players[0].score);
                            System.out.println("Score of player " + T.players[1].name + " is: "+ T.players[1].score);
                            T.state.value = 1;

                        }

                    }

                    System.out.println("Would you like to continue playing Tic Tac Toe? (Y/N)");
                    ans = console.next().charAt(0);

                } while (ans == 'Y' || ans == 'y');

            }



            //If the player chooses order and chaos

            else if (chosen_game == 2) {
                do {

                    OrderAndChaos OC = new OrderAndChaos(6, 6);

                    OC.board.displayInstructionBoard();
                    System.out.println("Choose location on board to play for Chaos:");
                    int loc = console.nextInt();

                    System.out.println("Enter X or O as the symbol you choose to play with:");
                    String character = console.next();

                    int char_index = 0;

                    if(character.equals("X") || character.equals("x")){
                        char_index = 0;
                    }
                    else{
                        char_index = 1;
                    }

                    System.out.println(char_index);
                    System.out.println(OC.state.currentPlayer.piece_list[0].name);
                    System.out.println(OC.state.currentPlayer.piece_list[1].name);


                    OC.board.insertIntoBoard(loc, OC.state.currentPlayer.piece_list[char_index].name);

                    int entered = 1;  // Entered is the variable used to check if the user has inserted into an empty cell or not. The first insertion has to be into an empty cell

                    while(OC.state.value != 1){

                        if(entered == 1){
                            OC.state.currentPlayer = OC.nextPlayer();
                            System.out.println("Please enter position to insert " + OC.state.currentPlayer.piece_list[char_index].name);
                            System.out.println("Current state of the board");
                            OC.board.displayCurrentBoard();
                            System.out.println("Refer below to choose the position: ");
                            OC.board.displayInstructionBoard();
                            System.out.println("Choose location on board to play for Chaos:");
                            loc = console.nextInt();

                            System.out.println("Enter X or O as the symbol you choose to play with:");
                            character = console.next();
                            entered = OC.board.insertIntoBoard(loc, OC.state.currentPlayer.piece_list[char_index].name);

                        }
                        else{
                            System.out.println("Invalid location chosen, please choose location again to play for Chaos:");
                            loc = console.nextInt();

                            System.out.println("Enter X or O as the symbol you choose to play with:");
                            character = console.next();

                            entered = OC.board.insertIntoBoard(loc, OC.state.currentPlayer.piece_list[char_index].name);
                        }

                        // Checking for winning condition
                        String current_game_status = OC.checkGameOver();  // Here we are passing the number of continuous elements to be considered for a win

                        if(current_game_status.equals("Matrix_Full")){
                            System.out.println("The game has reached a draw. Great Play !");
                        }
                        if(current_game_status.equals("Continue")){
                            continue;
                        }
                        else{
                            System.out.println("Congratulations! Player " + OC.state.currentPlayer.name + " has won");

                            if(OC.state.currentPlayer.name.equals(OC.players[0].name)){
                                OC.players[0].score = OC.players[0].score + 1;
                            }
                            else{
                                OC.players[1].score = OC.players[1].score + 1;
                            }

                            System.out.println("Score of player " + OC.players[0].name + " is: "+ OC.players[0].score);
                            System.out.println("Score of player " + OC.players[1].name + " is: "+ OC.players[1].score);
                            break;

                        }

                    }

                    System.out.println("Would you like to continue playing Order and Chaos? (Y/N)");
                    ans = console.next().charAt(0);

                } while (ans == 'Y' || ans == 'y');

            }

            System.out.println("Would you like to continue playing any of the two games? (Y/N) ");
            play = console.next().charAt(0);

            if(play=='n' || play=='N'){
                System.out.println("Thank you for playing with us, have a nice day !");
            }

        }while(play == 'y' || play == 'Y');
    }
}