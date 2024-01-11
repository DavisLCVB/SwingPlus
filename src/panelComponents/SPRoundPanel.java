package panelComponents;

import utilities.RoundGeneration;
import utilities.RoundInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

/**
 * <code>SPRoundPanel</code> is a class that creates a Panel with rounded corners
 * <p>
 * <strong>Note:</strong> Corners can have an independent radius. As it is a graphic drawn on a panel, some JPanel methods such as setBorder() may not give the desired results.
 * </p>
 * <p>
 * <strong>Warning:</strong> This class extends JPanel so its warnings apply. Please see {@link JPanel}
 * </p>
 *
 * @author Davis Cartagena
 * @since 1.0
 */
public class SPRoundPanel extends JPanel implements RoundGeneration {

    /**
     * This field contains the corner radius information.
     * <p>
     * More information: {@link RoundInfo}
     * </p>
     */
    protected RoundInfo roundInfo;

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified radius, layout manager and buffering strategy.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     * @param radius           the radius of the corners
     */
    public SPRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius) {
        super(isDoubleBuffered);
        setLayout(layout);
        this.roundInfo = new RoundInfo(radius);
        configurePanel();
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified layout manager and buffering strategy. The radius of the corners is 0.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     */
    public SPRoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
        this(layout, isDoubleBuffered, 0);
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified radius and layout. The buffering strategy is set to true.
     *
     * @param layout the layout manager for this panel
     * @param radius the radius of the corners
     */
    public SPRoundPanel(LayoutManager layout, int radius) {
        this(layout, true, radius);
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified layout. The buffering strategy is set to true and the radius of the corners is 0.
     *
     * @param layout the layout manager for this panel
     */
    public SPRoundPanel(LayoutManager layout) {
        this(layout, true, 0);
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified buffering strategy. The radius of the corners is 0 and the layout is set to <code>FlowLayout</code>.
     *
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     */
    public SPRoundPanel(boolean isDoubleBuffered) {
        this(new FlowLayout(), isDoubleBuffered, 0);
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with the specified radius. The buffering strategy is set to true and the layout is set to <code>FlowLayout</code>.
     *
     * @param radius the radius of the corners
     */
    public SPRoundPanel(int radius) {
        this(new FlowLayout(), true, radius);
    }

    /**
     * Creates a new <code>SPRoundPanel</code> with no rounded corners. The buffering strategy is set to true and the layout is set to <code>FlowLayout</code>.
     */
    public SPRoundPanel() {
        this(new FlowLayout(), true, 0);
    }

    /**
     * Returns the object with the information about the radius of the corners. More information: {@link RoundInfo}
     *
     * @return the corner radius information
     */
    public RoundInfo getRoundInfo() {
        return roundInfo;
    }

    /**
     * Sets the corner information by means of an object of class {@link RoundInfo}, which contains the information about the radius of the corners.
     *
     * @param roundInfo the corner radius information
     */
    public void setRoundInfo(RoundInfo roundInfo) {
        this.roundInfo = roundInfo;
    }

    /**
     * Sets the opacity of the component to false as a 2D graphic will be rendered on top of it
     *
     * @see JPanel#setOpaque(boolean)
     */
    private void configurePanel() {
        setOpaque(false);
    }

    /**
     * Overwrite the <code>paintComponent</code> method to paint over a custom area.
     *
     * @param g the <code>Graphics</code> object to protect
     * @see JPanel#paintComponent(Graphics)
     */
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintCustom(g2);
        super.paintComponent(g);
    }

    /**
     * Paint the rectangle with rounded corners.
     *
     * @param g2 the <code>Graphics2D</code> object to draw
     */
    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setColor(getBackground());
        g2.fill(area);
        g2.dispose();
    }

    /**
     * Generates a rectangular-shaped Area and rounds the corners depending on the specifications of the <code>roundInfo</code> attribute
     * <p>
     * <strong>Note:</strong> The rounded rectangle is generated by means of the <code>RoundRectangle2D</code> class. More info: {@link RoundRectangle2D}
     * </p>
     *
     * @return the rounded rectangle area
     */
    protected Area createRoundArea() {
        Area area = new Area(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        if (roundInfo.getRadiusTL() > 0)
            area.intersect(new Area(createCornerTL()));
        if (roundInfo.getRadiusTR() > 0)
            area.intersect(new Area(createCornerTR()));
        if (roundInfo.getRadiusBL() > 0)
            area.intersect(new Area(createCornerBL()));
        if (roundInfo.getRadiusBR() > 0)
            area.intersect(new Area(createCornerBR()));
        return area;
    }

    /**
     * Generates a rounded corner in the top left corner of the component
     *
     * @return the rectangle area with top left corner rounded
     */
    @Override
    public Shape createCornerTL() {
        var list = preCalculus(roundInfo.getRadiusTL());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(list.get(2) / 2.0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, list.get(3) / 2.0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    /**
     * Generates a rounded corner in the top right corner of the component
     *
     * @return the rectangle area with top right corner rounded
     */
    @Override
    public Shape createCornerTR() {
        var list = preCalculus(roundInfo.getRadiusTR());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, list.get(3) / 2.0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    /**
     * Generates a rounded corner in the bottom left corner of the component
     *
     * @return the rectangle area with bottom left corner rounded
     */
    @Override
    public Shape createCornerBL() {
        var list = preCalculus(roundInfo.getRadiusBL());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(list.get(2) / 2.0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    /**
     * Generates a rounded corner in the bottom right corner of the component
     *
     * @return the rectangle area with bottom right corner rounded
     */
    @Override
    public Shape createCornerBR() {
        var list = preCalculus(roundInfo.getRadiusBR());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    /**
     * Calculates the base area of the rounded rectangle
     *
     * @param list the list with the information about the component and the radius of the corners
     * @return the base area of the rounded rectangle
     */
    protected Area calculateBaseArea(ArrayList<Integer> list) {
        return new Area(new RoundRectangle2D.Double(0, 0, list.get(0), list.get(1), list.get(2), list.get(3)));
    }

    /**
     * Calculates the information about the component and the radius of the corner.
     * <p>
     * The information is stored in an <code>ArrayList</code> with the following order:
     * </p>
     * <ol>
     *     <li>Width of the component</li>
     *     <li>Height of the component</li>
     *     <li>Radius X of the corner</li>
     *     <li>Radius Y of the corner</li>
     * </ol>
     *
     * @param comp the radius of the corner
     * @return the list with the information about the component and the radius of the corner
     */
    protected ArrayList<Integer> preCalculus(int comp) {
        ArrayList<Integer> list = new ArrayList<>();
        var width = getWidth();
        var height = getHeight();
        var roundX = Math.min(width, comp);
        var roundY = Math.min(height, comp);
        list.add(width);
        list.add(height);
        list.add(roundX);
        list.add(roundY);
        return list;
    }
}