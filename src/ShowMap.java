public class ShowMap {

    public void showMap(Square[][] squares, Player player){
        printRowOfSquares(squares.length, squares, player);
    }

    private void printRowOfSquares(int columns, Square[][] squares, Player player){
        printPlayerStatus(player);
        for(int i = 0; i <= columns; i++) {
            printSquares(columns);
            if(i < columns){
                printStatus(columns, squares[i], i, player.getxPos(), player.getyPos());
            }
        }
    }

    private void printPlayerStatus(Player player){
        StringBuilder sb = new StringBuilder();
        sb.append("Stamina: ");
        if(player.getStamina() >= 10) {
            sb.append("\uD83D\uDCAA".repeat(10));
            sb.append("+").append(player.getStamina() - 10);
        }
        else {
            sb.append("\uD83D\uDCAA".repeat(Math.max(0, player.getStamina())));
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append("Gold: ");
        if(player.getGold() >= 10){
            sb.append("\uD83E\uDD47".repeat(10));
            sb.append("+").append(player.getGold() - 10);
        } else {
            sb.append("\uD83E\uDD47".repeat(Math.max(0, player.getGold())));
        }
        System.out.println(sb.toString());
    }

    private void printStatus(int columns, Square[] squares, int currentRow, int playerXPos, int playerYPos) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0, k = 0; j <= ((5 * columns * 2)); j += 2) {
            if ((j % 5) == 1) {
                //Suggestion use spaces instead of modulus
                if((currentRow == playerYPos) && (k == playerXPos)){
                    sb.append(" P");
                }
                else if(squares[k].getEnemies().length > 0){
                    sb.append(" E");
                }
                else if(squares[k].getTreasure().getGold() > 0){
                    sb.append(" G");
                }
                else if(!squares[k].checkIfSquareExplored()){
//                    sb.append(" ?");
                    sb.append(" U");
                }
                else{
                    sb.append(" C");
                }
                k++;
            }
            else {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private void printSquares(int columns){
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j <= (5 * columns); j++){
            if((j % 5) == 0){
                sb.append(" +");
            }
            else{
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

    }
}
