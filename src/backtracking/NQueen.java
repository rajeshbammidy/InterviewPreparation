package backtracking;

public class NQueen {
	private static int board[][]=new int[11][11];

	public static void main(String[] args) {
		
		placeNQueen(4);//which means 4x4 matrix;

	}

	private static void placeNQueen(int n) {
		
		nQueenHelper(n,0);//where n=size and 0 is the row
	}

	private static void nQueenHelper(int n, int row) {
		if(row==n) {//we need to print the possible solution
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("----------------------------------------");
		}
		
		for(int j=0;j<n;j++) {
			if(isPossible(n,row,j)) {
				board[row][j]=1;
				nQueenHelper(n, row+1);
				board[row][j]=0;
				
			}
		}
		
		
	}

	private static boolean isPossible(int n, int row, int col) {
		//check in the same above column
		for(int i=row-1;i>=0;i--) {
			if(board[i][col]==1)return false;
			
		}
		
		//check in the above left diagonal
		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(board[i][j]==1)return false;
		}
		//check in the above right diagonal
		
		for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++) {
			if(board[i][j]==1)return false;
		}
		
		
		//If  all the constraints satisfied return true so that we can insert one at that cell
		return true;
	}

}
