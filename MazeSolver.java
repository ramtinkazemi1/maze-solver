import java.util.ArrayList;
import java.util.List;
/**
 * Name: Ramtin Kazemi
 * PID: A16567965
 * Email: rkazemi@ucsd.edu
 * 
 * This file contains the maze solver class which goes over all the neighbors and
 * compares each one of the neighbor's running cost and takes the shortest path to the
 * finish square.
 */

/*
 * this class is using a maze and a priorityQueue in order to find the shortest possible path
 * to solve the maze (go from start to the finish maze). returns null if there is no path or 
 * solution
 */
public abstract class MazeSolver {
    
    /*
     * This method solves the maze and finds the shortest possible path from start to end.
     * It take the maze and the PriorityQueue as the parameters. and calculates the cost too.
     */
    public static Square solve(Maze maze, PriorityQueue<Integer,Square> pq) {	    		   

	//2. add the start square's cost as the key and the start square itself as the value to pq
	pq.add(maze.start.getCost(), maze.start);

	while(!pq.isEmpty()) {
	    //let current = remove the first entry from pq (poll)
	    Entry<Integer, Square> current = pq.poll();
	    //System.out.println(current.toString());
	   
	    //6.     Mark currentSquare as visited
	    current.value.visit();
	    //7.     if currentSquare is the finishing square
	    if(current.value == maze.finish) { 
		//System.out.print("finish");
		//8.         return currentSquare
		return current.value;
		//9.     else
	    }else {

		int currRow = current.value.getRow();
		int currCol = current.value.getCol();

		
		if ((currRow-1>=0 )&& ((currRow-1) < maze.rows) && 
		(maze.contents[(currRow -1)][currCol].getIsWall()==false)
		&& maze.contents[(currRow -1)][currCol].isVisited()==false ) {
		    Square northN = maze.contents[(currRow -1)][currCol];
		    //System.out.println("north");
		    operation(current,northN,current.value,pq);
		}

		
		if ((currRow+1>=0 )&& ((currRow+1) < maze.rows) && 
			(maze.contents[(currRow +1)][currCol].getIsWall()==false)
			&& maze.contents[(currRow +1)][currCol].isVisited()==false ) {
		    Square southN = maze.contents[(currRow +1)][currCol];
		    //System.out.println("south");
		    operation(current,southN,current.value,pq);
		}
		
		
		if ((currCol+1>=0 )&& ((currCol+1) < maze.cols) && 
			(currRow<maze.rows) &&
			(maze.contents[(currRow)][currCol+1].getIsWall()==false)
			&& maze.contents[(currRow)][currCol+1].isVisited()==false ) {
		    Square eastN = maze.contents[(currRow)][(currCol +1)];
		    //System.out.println("east");
		    operation(current,eastN,current.value,pq);
		}
		
		
		if ((currCol-1 >=0 )&& ((currCol-1) < maze.cols) &&
			(maze.contents[(currRow)][currCol-1].getIsWall()==false) 
			&& maze.contents[(currRow)][currCol-1].isVisited()==false ) {
		    Square westN = maze.contents[(currRow)][(currCol -1)];
		    //System.out.println("west");
		    operation(current,westN,current.value,pq);
		}
	    }
	}
	//if the loop ended, return null (no path found)
	return null;
    }



    //helper method
    private static void operation(Entry<Integer, Square> current, Square neighbor, 
	    		Square currentSquare, PriorityQueue<Integer, Square> pq) {

	int currentCost = current.key + neighbor.getCost();
	if(currentCost < neighbor.getRunningCost()) {
	   //System.out.print("inside if ");
	   neighbor.setPrevious(current.value);
	   neighbor.setRunningCost(currentCost);
	   pq.add(currentCost, neighbor);
	}
    }
}