package utilities;

import java.io.Serializable;

public class RoundInfo implements Serializable {
    private int radiusTL;
    private int radiusTR;
    private int radiusBL;
    private int radiusBR;

    public RoundInfo(int radiusTL, int radiusTR, int radiusBL, int radiusBR) {
        this.radiusTL = radiusTL;
        this.radiusTR = radiusTR;
        this.radiusBL = radiusBL;
        this.radiusBR = radiusBR;
    }

    public RoundInfo(int radius) {
        this.radiusTL = radius;
        this.radiusTR = radius;
        this.radiusBL = radius;
        this.radiusBR = radius;
    }

    public RoundInfo() {
    }

    public int getRadiusTL() {
        return radiusTL;
    }

    public void setRadiusTL(int radiusTL) {
        this.radiusTL = radiusTL;
    }

    public int getRadiusTR() {
        return radiusTR;
    }

    public void setRadiusTR(int radiusTR) {
        this.radiusTR = radiusTR;
    }

    public int getRadiusBL() {
        return radiusBL;
    }

    public void setRadiusBL(int radiusBL) {
        this.radiusBL = radiusBL;
    }

    public int getRadiusBR() {
        return radiusBR;
    }

    public void setRadiusBR(int radiusBR) {
        this.radiusBR = radiusBR;
    }
}
