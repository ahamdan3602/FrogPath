
public class FrogPath {
	
	private Pond pond;
	
	public FrogPath(String filename) {
		
		try {
			pond = new Pond(filename);
		} catch (Exception e) {}
		
	}
	
	/*
	 * @param currCell, This represents the current cell that Freddy is on
	 */
	public Hexagon findBest(Hexagon currCell)  {
		UniquePriorityQueueADT<Hexagon> upq = new ArrayUniquePriorityQueue<Hexagon>();
		Hexagon neighbourCell = null;
		
	
		
		for (int i = 0; i < 6; i++) { //Iterate through neighbouring cells and check if they are safe. Incase each iteration in a try-catch statement
			try {
				neighbourCell = currCell.getNeighbour(i);
				if (neighbourCell != null && !neighbourCell.isMarked() && !neighbourCell.isMudCell() && !neighbourCell.isAlligator() 
						&& !isAlligatorNearby(neighbourCell)) { //Check if the cell is unmarked, it's not an alligator, it's not a mudcell, and any cells that are adjacen to an alligator cell
					double priority = calcRegPriority(neighbourCell); //Get the priority by using helper method
					upq.add(neighbourCell, priority); //Add cell and priority into UPQ.
					
				}
			} catch (InvalidNeighbourIndexException | NullPointerException e) { //Continue to the next iteration if an exception is caught
				continue;
			}
			
		}
		if(currCell.isLilyPadCell()) {
			for(int i = 0; i<6; i++) { //  Use double for loop to iterate through the cell's adjacent to the neighbour cell when on a lilypad.
				
				for(int j = 0; j<6; j++) { 
					try {
						Hexagon adjCell = currCell.getNeighbour(i).getNeighbour(j);
						
						if(!adjCell.isMarked() && !adjCell.isAlligator() && !isAlligatorNearby(adjCell) && !adjCell.isMudCell() && !upq.contains(adjCell)) {
							// Identify and make sure the cell is valid.
							double priority = calcRegPriority(adjCell);
							if(i == j) { //Checks if the adjacent cell to the neighbouring cell when on a lilypad is a straight line
								priority += 0.5;
							}
							else { // Checks if 
								priority += 1.0;
							}
							upq.add(adjCell, priority);
						}
						
					} catch(InvalidNeighbourIndexException | NullPointerException e) {
						continue;
					}
				}
			}
		}
		

		
	
		if (upq.isEmpty()) { 
			return null;
		} else {
			return upq.peek();
				
			}
		}
	/*
	 * @param cell, represents the cell we want to get the priority of
	 * @return priority, Returns the priority of the given cell
	 */
	private double calcRegPriority(Hexagon cell) { 
		double priority = 0.0;
		
		
		
		if (cell instanceof FoodHexagon) { //If statement to check if it is a food cell
			FoodHexagon foodCell = (FoodHexagon) cell;
			
			if (foodCell.getNumFlies() == 1) { // Calculate the priority based on the number of flies in the cell
				priority = 2.0;
			} else if (foodCell.getNumFlies() == 2) {
				priority = 1.0;
			} else if (foodCell.getNumFlies() == 3) {
				priority = 0.0;
			}
		}else if (cell.isEnd()) { // Location of Franny
			priority = 3.0;
		} else if (cell.isLilyPadCell()) {
			priority = 4.0;
		} else if (cell.isReedsCell()) {
			priority = 5.0;
			if (isAlligatorNearby(cell)) {
				priority = 10.0;
			}
		} else {
			priority = 6.0;
		}

		
		
		return priority;

	}
	
	/*
	 * @param cell, represents the cell we want to check if alligators are adjacent to that given cell
	 */
	private boolean isAlligatorNearby(Hexagon cell) {
		for (int i = 0; i < 6; i++) { //Use for loop to get all neighbors to check if any of the surrounding/adjacent cells are alligators
			try {
				Hexagon neighbour = cell.getNeighbour(i);
				if (neighbour != null && neighbour.isAlligator() && !cell.isReedsCell()) { 
					return true;
				}
			} catch (InvalidNeighbourIndexException | NullPointerException e) {
				continue;
				
			}
		}
		return false;
	}
	
	/*
	 * @return returns string representation of the ArrayUnqiuePriority
	 */
	public String findPath() {
		StackADT<Hexagon> S = new ArrayStack<>();
		Hexagon startCell = pond.getStart();
		
		
		S.push(startCell); // Push the start cell into 
		startCell.markInStack();
		
		int fliesEaten = 0;
		
		String string = "";
		
		while (S.isEmpty() == false) {
			Hexagon curr = S.peek();
			
			string += curr.getID() + " ";
			
			if (curr.isEnd()) {
				break;
			} else if (curr instanceof FoodHexagon) {
	            FoodHexagon foodCell = (FoodHexagon) curr;
	            // Use if statement to check if they are flies left
	            if (foodCell.getNumFlies() > 0) {
	                fliesEaten += foodCell.getNumFlies();
	                foodCell.removeFlies(); // Once flies are eaten remove them so they are not counted again
	            }
	        }
			
			Hexagon next = findBest(curr);
			
			if (next == null) {
				S.pop();
				curr.markOutStack();
			} else {
				S.push(next);
				next.markInStack();
			}
			
		}
		
		if (S.isEmpty()) {
			string = "No solution";
		} else {
			string += "ate " + fliesEaten + " flies";
		}
		
		
		
		return string;
	}
	
	public static void main (String[] args) {
		 if (args.length != 1) {
		 System.out.println("No map file specified in the arguments");
		 return;
		 }
		 FrogPath fp = new FrogPath(args[0]);
		 Hexagon.TIME_DELAY = 500; // Change this time delay as desired.
		 String result = fp.findPath();
		 System.out.println(result);
		}


}
