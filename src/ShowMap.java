public class ShowMap {

    public void showMap(Square[][] squares, Player player){
        printRowOfSquares(squares.length, squares, player);
    }

    private void printRowOfSquares(int columns, Square[][] squares, Player player){
        printPlayerStatus(player);
        for(int i = 0; i <= columns; i++) {
            printSquares(columns);
            if(i < columns){
                printStatus(columns, squares[i], i, player.getxPos() , player.getyPos());
            }
        }
    }

    private void printPlayerStatus(Player player){
        StringBuilder sb = new StringBuilder();
        sb.append("Stamina: ");
        if(player.getStamina() >= 10) {
            for (int i = 0; i < 10; i++) {
                sb.append("\uD83D\uDCAA");
            }
            sb.append("+" + (player.getStamina() - 10));
        } else {
            for (int i = 0; i < player.getStamina(); i++) {
                sb.append("\uD83D\uDCAA");
            }
        }
        System.out.println(sb.toString());
        sb = new StringBuilder();
        sb.append("Gold: ");
        if(player.getGold() >= 10){
            for(int i = 0; i < 10; i++) {
                sb.append("\uD83E\uDD47");
            }
            sb.append("+" + (player.getGold() - 10));
        } else {
            for (int i = 0; i < player.getGold(); i++) {
                sb.append("\uD83E\uDD47");
            }
        }
        System.out.println(sb.toString());
    }

    private void printStatus(int columns, Square[] squares, int currentRow, int playerXPos, int playerYPos) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0, k = 0; j <= ((5 * columns * 2)); j += 2) {
            if ((j % 5) == 1) {
                //Suggestion use spaces instead of modulus
                if((currentRow == playerYPos) && (k == playerXPos)){
                    sb.append("\uD83E\uDDD1");
                }
                else if(squares[k].getEnemies().length > 0){
                    sb.append("☠\uFE0F");
                }
                else if(!squares[k].checkIfSquareExplored()){
//                    sb.append(" ?");
                    sb.append("\uD83C\uDF0E");
                }
                else{
                    sb.append(" E");
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
