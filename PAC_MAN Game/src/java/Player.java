/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hash
 */
public class Player {
    int x;
    int y;
    int score;
    int [] player1 = {score,x,y};
    int [] player2 = {score,x,y};
    int [] player3 = {score,x,y};
    int [] player4 = {score,x,y};

    public Player(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
    
    public void getCurruntPosition(String key){
         int i = Integer.parseInt(key);

            switch (i) {
                case 37:
                    player1[1] -= 1;
                    break;

                case 38:
                    player1[2] -= 1;
                    break;

                case 39:
                    player1[1] += 1;
                    break;

                case 40:
                    player1[2] += 1;
                    break;
            }
    }
    
    public String  currunt_position(){
      return "\"PLAYERS\": [[\"P1\"," + player1[0] + ", " + player1[1] + ", " + player1[2] + "], [\"P2\", " + player2[0] + ", " + player2[1] + ", " + player2[2] + "],[\"P3\", " + player3[0] + ", " + player3[1] + ", " + player3[2] + "],[\"P4\"," + player4[0] + ", " + player4[1] + ", " + player4[2] + "]]";
    }

   
 }
