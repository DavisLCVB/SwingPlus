package utilities;

import java.io.Serializable;

/**
 * <code>RoundInfo</code> is a class that contains the corner radius information.
 *
 * @author Davis Cartagena
 * @version 1.0
 */
public class RoundInfo implements Serializable {
    /**
     * This field contains the corner radius of the top left corner.
     */
    private int radiusTL;

    /**
     * This field contains the corner radius of the top right corner.
     */
    private int radiusTR;

    /**
     * This field contains the corner radius of the bottom left corner.
     */
    private int radiusBL;

    /**
     * This field contains the corner radius of the bottom right corner.
     */
    private int radiusBR;

    /**
     * Creates a new <code>RoundInfo</code> with the specified corner radius information.
     *
     * @param radiusTL the corner radius of the top left corner
     * @param radiusTR the corner radius of the top right corner
     * @param radiusBL the corner radius of the bottom left corner
     * @param radiusBR the corner radius of the bottom right corner
     */
    public RoundInfo(int radiusTL, int radiusTR, int radiusBL, int radiusBR) {
        this.radiusTL = Math.max(radiusTL, 0);
        this.radiusTR = Math.max(radiusTR, 0);
        this.radiusBL = Math.max(radiusBL, 0);
        this.radiusBR = Math.max(radiusBR, 0);
    }

    /**
     * Creates a new <code>RoundInfo</code> with the specified corner radius information.
     *
     * @param radius the corner radius of all corners
     */
    public RoundInfo(int radius) {
        this.radiusTL = Math.max(radius, 0);
        this.radiusTR = Math.max(radius, 0);
        this.radiusBL = Math.max(radius, 0);
        this.radiusBR = Math.max(radius, 0);
    }

    /**
     * Creates a new <code>RoundInfo</code> with the default corner radius (<code>0</code>).
     */
    public RoundInfo() {
        this(0);
    }

    /**
     * Returns the corner radius of the top left corner.
     *
     * @return the corner radius of the top left corner
     */
    public int getRadiusTL() {
        return radiusTL;
    }

    /**
     * Sets the corner radius of the top left corner.
     *
     * @param radiusTL the corner radius of the top left corner
     */
    public void setRadiusTL(int radiusTL) {
        this.radiusTL = radiusTL;
    }

    /**
     * Returns the corner radius of the top right corner.
     *
     * @return the corner radius of the top right corner
     */
    public int getRadiusTR() {
        return radiusTR;
    }

    /**
     * Sets the corner radius of the top right corner.
     *
     * @param radiusTR the corner radius of the top right corner
     */
    public void setRadiusTR(int radiusTR) {
        this.radiusTR = radiusTR;
    }

    /**
     * Returns the corner radius of the bottom left corner.
     *
     * @return the corner radius of the bottom left corner
     */
    public int getRadiusBL() {
        return radiusBL;
    }

    /**
     * Sets the corner radius of the bottom left corner.
     *
     * @param radiusBL the corner radius of the bottom left corner
     */
    public void setRadiusBL(int radiusBL) {
        this.radiusBL = radiusBL;
    }

    /**
     * Returns the corner radius of the bottom right corner.
     *
     * @return the corner radius of the bottom right corner
     */
    public int getRadiusBR() {
        return radiusBR;
    }

    /**
     * Sets the corner radius of the bottom right corner.
     *
     * @param radiusBR the corner radius of the bottom right corner
     */
    public void setRadiusBR(int radiusBR) {
        this.radiusBR = radiusBR;
    }
}
