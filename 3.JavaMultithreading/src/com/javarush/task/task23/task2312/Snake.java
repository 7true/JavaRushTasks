package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        SnakeSection section = new SnakeSection(x, y);
        sections = new ArrayList<>();
        sections.add(section);
        isAlive = true;
    }

    void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    void checkBorders(SnakeSection head) {
        int y = head.getY();
        int x = head.getX();
        if (x >= Room.game.getWidth() || y >= Room.game.getHeight() ||
                x < 0 || y < 0) {
            isAlive = false;
        }
    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    int getX() {
        return sections.get(0).getX();
    }

    int getY(){
        return sections.get(0).getY();
    }

    public void move() {
        if (isAlive == false) return;
        switch (direction) {
            case UP:
                move(0, -1);
            case RIGHT:
                move(1, 0);
            case DOWN:
                move(0, 1);
            case LEFT:
                move(-1, 0);
        }
    }

    public void move(int dx, int dy) {
        SnakeSection head = new SnakeSection(sections.get(0).getX() + dx, sections.get(0).getY() + dy);
        checkBorders(head);
        checkBody(head);
        if (isAlive == false) return;
        sections.add(0, head);
        if (Room.game.getMouse().getX() == head.getX() &&
                Room.game.getMouse().getY() == head.getY()) {
            Room.game.eatMouse();
        } else {
            sections.remove(sections.size()-1);
        }
    }
}
