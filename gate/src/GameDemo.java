public class GameDemo {
    public static void main(String[] args) {
        //just for test, it can be changed to Utility class later
        String[] mapData = {
                "####.####",
                "#...#...#",
                "#.#...#.#",
                "#.#####.#",
                "#.......#",
                "#########"
        };

        Map gameMap = new Map(mapData);
        int pRow = 1;
        int pCol = 1;
        //display the location of player
        if (gameMap.isValidMove(pRow,pCol)){
            gameMap.displayMap(pRow, pCol);
        }else {
            System.out.println("Invalid!");
        }
    }
}
