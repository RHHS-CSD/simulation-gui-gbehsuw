/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatastarter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;

/**
 *
 * @author mithu
 */
public class PredPrey {
    
    /**
     * @param args the command line arguments
     */
    
//    constants / important vars
    public static final int GRID_X = 20;
    public static final int GRID_Y = 20;
    public static int[][] grid = new int[GRID_X][GRID_Y];
    public static final int PREY_REPROD_RATE = 10;
    public static final int PRED_REPROD_RATE = 5;
    public static final int PRED_HUNGER_VAL = 20;
    public static final int PRED_REPRODUCE_MIN = 10;
    public static final int PRED_DESPERATION = 4;
    public static int numPrey = 100;
    public static int numPred = 10;
    private static int stepNumber = 0;

    
//    initialize grid
    public void gridSetUp() {
        for (int row = 0; row < grid.length; row++) {
            Arrays.fill(grid[row], 0);
        }
//        populate grid
        populatePrey();
        populatePred();
    }
    
//    return a copy of the 2d int array
    private static int[][] copyGrid(int [][] grid) {
        int[][] newGrid = new int[GRID_X][GRID_Y];
        for (int i = 0; i < newGrid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, GRID_Y);
        }
        
        return newGrid;
    }
    
//    add prey in
    private void populatePrey() {
        Random r = new Random();
        for (int prey = 0; prey < numPrey; prey++) {
            boolean valid = false;
            while (!valid) {
//                randomly generate a cord
                int x = r.nextInt(GRID_X);
                int y = r.nextInt(GRID_Y);
                
//                make sure cord is empty
                if (grid[x][y] == 0) {
                    grid[x][y] = -1;
                    valid = true;
                }
            }
        }
    }
    
//    add predators
    private void populatePred() {
        Random r = new Random();
        for (int pred = 0; pred < numPred; pred++) {
            boolean valid = false;
            while (!valid) {
//                random generate a cord
                int x = r.nextInt(GRID_X);
                int y = r.nextInt(GRID_Y);
                
//                make sure cord is empty
                if (grid[x][y] == 0) {
                    grid[x][y] = PRED_HUNGER_VAL;
                    valid = true;
                }
            }
        }
    }
    
    public int printGrid() {
//        counters
        int nPrey = 0;
        int nPred = 0;
//        nested for loop for each value
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
//                check whether its empty (0), prey (1), or pred (2)
                switch (grid[row][col]) {
                    case 0: 
                        System.out.print(". ");
                        break;
                    case -1:
                        System.out.print("o ");
                        nPrey++;
                        break;
                    default:
                        System.out.print("P ");
                        nPred++;
                        break;
                }
            }
//            enter after each line
            System.out.println("");
        }
        System.out.println("Predators: " + nPred + ", Prey: " + nPrey);
        return nPred + nPrey;
    }
    
    public void drawGrid(Graphics g, int width, int height) {
        //        counters
        int nPrey = 0;
        int nPred = 0;
        
        int wInterval = width / grid.length;
        int hInterval = height / grid[0].length;
//        nested for loop for each value
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
//                check whether its empty (0), prey (1), or pred (2)
                switch (grid[row][col]) {
                    case 0:
                        break;
                    case -1:
                        g.setColor(Color.blue);
                        g.fillOval(row*wInterval, col*hInterval, 10, 10);
                        nPrey++;
                        break;
                    default:
                        g.setColor(Color.red);
                        g.fillOval(row*wInterval, col*hInterval, 10, 10);
                        nPred++;
                        break;
                }
            }
//            enter after each line
        }
    }
    
//    count the number of steps
    private void step() {
        stepNumber++;
        System.out.println("Step: " + stepNumber);
    }
    
//    overall movement
    public int[][] movement() {
        Random r = new Random();
//        first copy grid
        int[][] newGrid = copyGrid(grid);
        
//        loop through each val
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                switch (grid[row][col]) {
                    case 0:
                        break;
//                    if prey use prey movement and update the copied grid
                    case -1:
                        int numPrey = r.nextInt(100/PREY_REPROD_RATE);
                        if (numPrey == 0) {
                            newGrid = reproduction(row, col, newGrid, -1);
                        }
                        newGrid = preyMovement(row, col, newGrid);
                        break;
                        
//                        similar case for predator
                    default:
                        int numPred = r.nextInt(100/PRED_REPROD_RATE);
//                        healthy reproductive predator
                        if (numPred == 0 && grid[row][col] > PRED_REPRODUCE_MIN) {
                            newGrid = predMovement(row, col, newGrid);
                            newGrid = reproduction(row, col, newGrid, grid[row][col]);
                        } 
//                      healthy normal predator
                        else if (grid[row][col] > 0) {
                            newGrid = predMovement(row, col, newGrid);
                        } 
//                        starved predator
                        else {
                            newGrid[row][col] = 0;
                        }
                        break;
                }
            }
        }
//        copy the new grid onto grid
        grid = copyGrid(newGrid);
        return grid;
    }
    
//    prey movement

    /**
     * The prey will randomly move to another location that is empty.
     * @param x, x location of the prey
     * @param y, y location of the prey
     * @param newGrid, the new grid with updated positions
     * @return the new updated grid
     */
    public static int[][] preyMovement(int x, int y, int[][] newGrid) {
        int[] dRow = {-1, 1, 0, 0}; // Direction row changes: up, down
        int[] dCol = {0, 0, -1, 1}; // Direction column changes: left, right
        ArrayList<int[]> emptySpaces = new ArrayList<>();

        // Look for empty spaces around the prey
        for (int i = 0; i < 4; i++) {
            int newRow = (x + dRow[i] + newGrid.length) % newGrid.length; // Wrap vertically
            int newCol = (y + dCol[i] + newGrid[0].length) % newGrid[0].length; // Wrap horizontally

            if (newGrid[newRow][newCol] == 0) {
                emptySpaces.add(new int[]{newRow, newCol});
            }
        }

        if (!emptySpaces.isEmpty() && newGrid[x][y] == -1) {
            // Randomly select an empty space to move into
            Random rand = new Random();
            int[] moveTo = emptySpaces.get(rand.nextInt(emptySpaces.size()));

            // Move the prey to the new location
            newGrid[moveTo[0]][moveTo[1]] = -1;
            newGrid[x][y] = 0; // Clear old position
        } else if (newGrid[x][y] == -1) {
            // No empty space, delete the prey
            newGrid[x][y] = 0;
        }
        
        return newGrid;
    }
    
//    pred movement

    /**
     * The predator movement first looks for nearby prey.
     * If looks in a spiral pattern around itself based on the range given.
     * This range is influenced (increases) as the predator becomes hungrier.
     * Otherwise, the predator will move to a random location and either become a little hungrier,
     * or eat a more starved and weakened predator thus refilling itself.
     * @param x, x location of predator
     * @param y, y location of predator
     * @param newGrid, update new positions
     * @return, the updated grid
     */
    public static int[][] predMovement(int x, int y, int[][] newGrid) {
//        hunger level
        int hungerLevel = newGrid[x][y]; 
//        directions of scanning
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1}; 
        
        ArrayList<int[]> validMoves = new ArrayList<>();

        // Check if there's prey within 2 spaces
        int[] preyPos = preyFinder(newGrid, x, y, (21-hungerLevel)/PRED_DESPERATION);
        if (preyPos != null && newGrid[x][y] > 0) {
            // Move 1 step closer to the prey
            newGrid = moveToPrey(newGrid, x, y, preyPos);
            return newGrid; 
        }

        // Otherwise, look for empty spaces or weaker predators around the predator
        for (int i = 0; i < 4; i++) {
            int newRow = (x + dRow[i] + newGrid.length) % newGrid.length; 
            int newCol = (y + dCol[i] + newGrid[0].length) % newGrid[0].length;

            if (newGrid[newRow][newCol] < hungerLevel && newGrid[x][y] > 0) {
                validMoves.add(new int[]{newRow, newCol});
            }
        }

//        choose random valid move
        if (!validMoves.isEmpty() && newGrid[x][y] > 0) {
            // Randomly select a move
            Random rand = new Random();
            int[] moveTo = validMoves.get(rand.nextInt(validMoves.size()));

            // If moving onto a predator, eat it and reset hunger
            if (newGrid[moveTo[0]][moveTo[1]] < hungerLevel && newGrid[moveTo[0]][moveTo[1]] > 0) {
                newGrid[moveTo[0]][moveTo[1]] = PRED_HUNGER_VAL;
            } else {
                // Move the predator to the new location
                newGrid[moveTo[0]][moveTo[1]] = hungerLevel - 1;
            }

//            clear position
            newGrid[x][y] = 0; 
        } 
    //            pred starves    
        else {
            newGrid[x][y] = 0; 

        }
        return newGrid;
    }
    
//prey scanner    
    private static int[] preyFinder(int[][] grid, int predRow, int predCol, int range) {
//        spiral arround pred location to scan for prey
        for (int d = 1; d < range; d++)
        {
            for (int i = 0; i < d + 1; i++)
            {
//                the + grid.length ... is to wrap around the grid
                int x1 = (predRow - d + i + grid.length) % grid.length;
                int y1 = (predCol - i + grid[0].length) % grid[0].length;

                if (grid[x1][y1] == -1) {
                    return new int[] {x1, y1};
                }

                int x2 = (predRow + d - i + grid.length) % grid.length;
                int y2 = (predCol + i + grid[0].length) % grid[0].length;

                if (grid[x2][y2] == -1) {
                    return new int[] {x2, y2};
                }
            }


            for (int i = 1; i < d; i++)
            {
                int x1 = (predRow - i + grid.length) % grid.length;
                int y1 = (predCol + d - i + grid[0].length) % grid[0].length;

                if (grid[x1][y1] == -1) {
                    return new int[] {x1, y1};
                }

                int x2 = (predRow + i + grid.length) % grid.length;
                int y2 = (predCol - d + i + grid[0].length) % grid[0].length;

                if (grid[x2][y2] == -1) {
                    return new int[] {x2, y2};
                }
            }
        }
        
        return null;
    }
    
//    move towards prey
    private static int[][] moveToPrey(int[][] grid, int predRow, int predCol, int[] preyPos) {
        int hungerLevel = grid[predRow][predCol];
        int preyRow = preyPos[0];
        int preyCol = preyPos[1];

//        directions
        int[] dRow = {-1, 1, 0, 0}; 
        int[] dCol = {0, 0, -1, 1}; 

        ArrayList<int[]> possibleMoves = new ArrayList<>();

        // Find valid moves that bring the predator closer to the prey
        for (int i = 0; i < 4; i++) {
            int newRow = (predRow + dRow[i] + grid.length) % grid.length;
            int newCol = (predCol + dCol[i] + grid[0].length) % grid[0].length;

            int distanceBefore = Math.abs(predRow - preyRow) + Math.abs(predCol - preyCol);
            int distanceAfter = Math.abs(newRow - preyRow) + Math.abs(newCol - preyCol);

            if (grid[newRow][newCol] <= 0 && distanceAfter < distanceBefore) {
                possibleMoves.add(new int[]{newRow, newCol});
            }
        }

//        for valid moves
        if (!possibleMoves.isEmpty() && grid[predRow][predCol] > 0) {
            // Move 1 step closer
            Random rand = new Random();
            int[] moveTo = possibleMoves.get(rand.nextInt(possibleMoves.size()));

            // If moving onto a prey, eat it and reset hunger
            if (grid[moveTo[0]][moveTo[1]] == -1) {
                grid[moveTo[0]][moveTo[1]] = PRED_HUNGER_VAL;
            } else {
                // Move the predator to the new location
                grid[moveTo[0]][moveTo[1]] = hungerLevel - 1;
            }
            
//            clear old position
            grid[predRow][predCol] = 0;
        }
        
        return grid;
    }
    
//    reproduction

    /**
     * This function looks at the four directions around the prey/predator.
     * If one of these locations are empty, the organism will reproduce.
     * @param x, x location of reproducing organism
     * @param y, y location of reproducing organism
     * @param grid, the grid to check and update
     * @param type, whether this is a predator or prey
     * @return updated grid
     */
    public static int[][] reproduction(int x, int y, int[][] grid, int type) {
        Random r = new Random(); 
        boolean valid = false;
        boolean[] validMovement = {true, true, true, true};
        
        while (!valid) {
            int direction = r.nextInt(4);
            switch (direction) {
//                left
                case 0:
//                    if this is an edge case reproduction fails
                    if (x == 0) {
                        validMovement[direction] = false;
                        break;
                    }
//                    otherwise if empty reproduce
                    else if (grid[x-1][y] == 0) {
                        grid[x-1][y] = type;
                        valid = true;
                    } else {
                        validMovement[direction] = false;
                    }
                    break;
//                    right
                case 1:
                    if (x == GRID_X-1) {
                        validMovement[direction] = false;
                        break;
                    }
                    else if (grid[x+1][y] == 0) {
                        grid[x+1][y] = type;
                        valid = true;
                    } else {
                        validMovement[direction] = false;
                    }
                case 2:
                    if (y == 0) {
                        validMovement[direction] = false;
                        break;
                    }
                    else if (grid[x][y-1] == 0) {
                        grid[x][y-1] = type;
                        valid = true;
                    } else {
                        validMovement[direction] = false;
                    }
                    break;
//                    down
                case 3:
                    if (y == GRID_X-1) {
                        validMovement[direction] = false;
                        break;
                    }
                    else if (grid[x][y+1] == 0) {
                        grid[x][y+1] = type;
                        valid = true;
                    } else {
                        validMovement[direction] = false;
                    }
                    break;
            }
//            starvation when no free spaces
            if (!validMovement[0] && !validMovement[1] && !validMovement[2] && !validMovement[3]) {
                grid[x][y] = 0;
                valid = true;
            }
        }
        return grid;
    }
    
//    main
    public static void main(String[] args) {
//        create scanner
        Scanner s = new Scanner(System.in);
//        make and populate grid
        
        PredPrey p = new PredPrey();
        p.gridSetUp();
        
//        ensure grid not empty
        int numOrganisms = numPrey + numPred;
        
//        while input not q
        while (!s.nextLine().equals("q") && numOrganisms > 0) {
//            print iteration number
            p.step();
//            move prey and pred
            grid = p.movement();
//            print grid
            numOrganisms = p.printGrid();
        }
    }
}
