package com.github.pwnmn;

import java.util.List;

public class Grid {
    private int xSize;
    private int ySize;

    public Grid(int xSize, int ySize) {
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public boolean canMove(int x, int y) {
        var xValid = x <= xSize && x >= 0;
        var yValid = y <= ySize && y >= 0;

        return xValid && yValid;
    }

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }
}
