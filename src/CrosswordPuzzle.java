public class CrosswordPuzzle{
	private Square[][] puzzle;
	
	
	public CrosswordPuzzle(boolean[][] blackSquares) {
		puzzle = new Square[blackSquares.length][blackSquares.length];
		int posNumberingCount = 2;
		
		for(int rows=0; rows<puzzle.length;rows++) {
			for(int cols=0; cols<puzzle.length;cols++) {
				if(blackSquares[rows][cols]) {
					puzzle[rows][cols] = new Square(true,0);
				}
				else if(toBeLabeled(rows, cols, blackSquares)){
					puzzle[rows][cols] = new Square(false, posNumberingCount);
					posNumberingCount = posNumberingCount+2;
				}
					
				}
			}
		}
	}
	private boolean toBeLabeled(int r, int c, boolean[][] blackSquares) {
		if(blackSquares[r][c] == blackSquares[0][c] || blackSquares[r][c] == blackSquares[r][0]) {
			return false;
		}
		else if(blackSquares[r][c-1] && blackSquares[r+1][c]) {
			return true;
		}
		return false;
	}
	
}