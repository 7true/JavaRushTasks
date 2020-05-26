package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    protected int score = 0;
    protected int maxTile = 0;
    public Model() {
        resetGameTiles();
    }
    private Stack <Tile[][]> previousStates = new Stack();
    private Stack <Integer> previousScores = new Stack();
    private boolean isSaveNeeded = true;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value == 0) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (emptyTiles.isEmpty()) {
            return;
        }
        int element = (int) (emptyTiles.size() * Math.random());
        emptyTiles.get(element).value = (Math.random() < 0.9 ? 2 : 4);
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean modify = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value == 0) {
                for (int j = i; j < FIELD_WIDTH; j++) {
                    if (tiles[j].value != 0) {
                        tiles[i].value = tiles[j].value;
                        tiles[j].value = 0;
                        modify = true;
                        break;
                    }
                }
            }
        }
        return modify;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean modify = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            if (tiles[i].value == tiles[i+1].value && tiles[i].value != 0) {
                tiles[i].value = tiles[i].value * 2;
                tiles[i + 1].value = 0;
                compressTiles(tiles);
                score += tiles[i].value;
                modify = true;
                if (maxTile < tiles[i].value) {
                    maxTile = tiles[i].value;
                }
            }
        }
        return modify;
    }

    protected void left() {
        if (isSaveNeeded == true) {
            saveState(gameTiles);
        }
        boolean needAddTile = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            boolean compressed = compressTiles(gameTiles[i]);
            boolean merged = mergeTiles(gameTiles[i]);

            needAddTile = compressed || merged || needAddTile;
        }
        if (needAddTile) {
            addTile();
        }
    }

    protected void down() {
        saveState(gameTiles);
        gameTiles = rotateClockwise(gameTiles);
        left();
        for (int i = 0; i < 3; i++) {
            gameTiles = rotateClockwise(gameTiles);
        }
    }

    protected void right() {
        saveState(gameTiles);
        for (int i = 0; i < 2; i++) {
            gameTiles = rotateClockwise(gameTiles);
        }
        left();

        for (int i = 0; i < 2; i++) {
            gameTiles = rotateClockwise(gameTiles);
        }
    }

    protected void up() {
        saveState(gameTiles);
        for (int i = 0; i < 3; i++) {
            gameTiles = rotateClockwise(gameTiles);
        }
        left();
        gameTiles = rotateClockwise(gameTiles);
    }

    public Tile[][] rotateClockwise(Tile[][] array) {
        Tile[][] result = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                result[i][j] = array[FIELD_WIDTH - j - 1][i];
            }
        }
        return result;
    }

    public boolean canMove() {
        boolean canMove = false;
        for (int i = 0; i < FIELD_WIDTH - 1; i++) {
            for (int j = 0; j < FIELD_WIDTH - 1; j++) {
                if (gameTiles[i][j].value == 0) {
                    canMove = true;
                }
                if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                    canMove = true;
                }
                if (gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    canMove = true;
                }
            }
        }
        return canMove;
    }

    private void saveState(Tile[][] tiles) {
        //Tile[][]temp = tiles.clone();
        Tile[][] temp = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                temp[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousScores.push(score);
        previousStates.push(temp);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            gameTiles = (Tile[][]) previousStates.pop();
            score = (int) previousScores.pop();
        }
    }

    void randomMove() {
        int n = (int) ((Math.random()*100) % 4);
        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        int thisWeight = 0;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                thisWeight += gameTiles[i][j].value;
            }
        }

        int weightFromStack = 0;
        Tile[][]temp = (Tile[][]) previousStates.peek();
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                weightFromStack += temp[i][j].value;
            }
        }
        return thisWeight != weightFromStack ? true:false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency;
        move.move();
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        } else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
            rollback();
        }
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
            priorityQueue.offer(getMoveEfficiency(() -> left()));
            priorityQueue.offer(getMoveEfficiency(() -> right()));
            priorityQueue.offer(getMoveEfficiency(() -> up()));
            priorityQueue.offer(getMoveEfficiency(() -> down()));
            priorityQueue.peek().getMove().move();
    }
}
