public class ShowMap {

    public void showMap(Square[][] squares, int playerXPos, int playerYPos){
        printRowOfSquares(squares.length, squares, playerXPos, playerYPos);
    }

    private void printRowOfSquares(int columns, Square[][] squares, int playerXPos, int playerYPos){
        for(int i = 0; i <= columns; i++) {
            printSquares(columns);
            if(i < columns){
                printStatus(columns, squares[i], i, playerXPos, playerYPos);
            }
        }
    }

    private void printStatus(int columns, Square[] squares, int currentRow, int playerXPos, int playerYPos) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0, k = 0; j <= ((5 * columns * 2)); j += 2) {
            if ((j % 5) == 1) {
                //Suggestion use spaces instead of modulus
                if((currentRow == playerYPos) && (k == playerXPos)){
                    sb.append("☢\uFE0F");
                }
                else if(!squares[k].checkIfSquareExplored()){
                    sb.append(" ?");
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
