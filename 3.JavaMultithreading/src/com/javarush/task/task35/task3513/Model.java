package com.javarush.task.task35.task3513;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
    private int score;
    private int maxTile;
    public Model() {
        resetGameTiles();
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

    private void compressTiles(Tile[] tiles) {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (tiles[i].value == 0) {
                for (int j = i; j < FIELD_WIDTH; j++) {
                   if (tiles[j].value != 0) {
                       tiles[i].value = tiles[j].value;
                       tiles[j].value = 0;
                       break;
                   }
                }
            }
        }
    }

    private void mergeTiles(Tile[] tiles) {

    }
}
