import javafx.geometry.Pos;

import java.util.HashMap;
import java.util.List;
import java.util.*;
import java.util.PriorityQueue;

public class Chess {

}

class Position {
    int x;
    int y;

}

class Board {

    Map<Position, Piece> pieces = new HashMap<>();

    public void makeMove(Piece piece, Position destination) {

    }

    public Piece get(Position destination) {
        return pieces.get(destination);
    }
}

abstract class Piece {
    Position currentPosition;
    Board currentBoard;

    void move(Position destination) {
        if (isValid(currentPosition, destination)) {
            currentPosition = destination;
        }
        if (currentBoard.get(destination) != null) {

        }
    }

    private boolean isValid(Position start, Position end) {
        Board temp = currentBoard;
        temp.makeMove(this, end);
        if (currentKingInCheck(temp)) {
            return false;
        } else {
            return isValidMove();
        }
    }

    private boolean isValidMove() {

        return true;

    }

    private boolean currentKingInCheck(Board temp) {
        return false;
    }

    abstract void getAllPossibleMoves();
}

class Pawn {

    public void enpassant() {

    }

    public void promotion() {

    }

}

class King {
    public void castle() {
        // Complex logic
    }

}

class Queen {

}

class Bishop {

}

class Knight {

}

class Rook {


}
