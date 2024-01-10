package panelComponents;

import java.awt.*;
import java.awt.geom.Area;

/**
 * <code>SPGradientRoundPanel</code> is a class that creates a Panel with rounded corners and a gradient background
 * <p>
 * <strong>Note:</strong> Corners can have an independent radius
 * </p>
 * <p>
 * <strong>Warning:</strong> This class extends SPRoundPanel so its warnings apply. Please see {@link SPRoundPanel}
 * </p>
 *
 * @author Davis Cartagena
 * @since 1.0
 */
public class SPGradientRoundPanel extends SPRoundPanel {

    /**
     * This field contains the gradient start color.
     */
    private Color gradientStart;
    /**
     * This field contains the gradient end color.
     */
    private Color gradientEnd;
    /**
     * This field contains the gradient direction.
     */
    private int gradientDirection;
    /**
     * This field contains a custom gradient paint.
     */
    private Paint gradientPaint;

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager, buffering strategy, radius, gradient start color, gradient end color and gradient direction.
     *
     * @param layout            the layout manager for this panel
     * @param isDoubleBuffered  a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     * @param radius            the radius of the corners
     * @param gradientStart     the gradient start color
     * @param gradientEnd       the gradient end color
     * @param gradientDirection the gradient direction
     */
    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color gradientStart, Color gradientEnd, int gradientDirection) {
        super(layout, isDoubleBuffered, radius);
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;
        if (gradientDirection < 0 || gradientDirection > 360)
            throw new IllegalArgumentException("Gradient direction must be between 0 and 360");
        this.gradientDirection = gradientDirection;
        this.gradientPaint = createGradientPaint(getWidth(), getHeight());
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager, buffering strategy, radius, gradient start color and gradient end color.
     * The gradient direction is set to 0.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     * @param radius           the radius of the corners
     * @param gradientStart    the gradient start color
     * @param gradientEnd      the gradient end color
     */
    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color gradientStart, Color gradientEnd) {
        this(layout, isDoubleBuffered, radius, gradientStart, gradientEnd, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager, buffering strategy, radius and background color.
     * The gradient start and end colors are set to the background color.
     * The gradient direction is set to 0.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     * @param radius           the radius of the corners
     * @param startToEnd       the background color
     */
    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color startToEnd) {
        this(layout, isDoubleBuffered, radius, startToEnd, startToEnd, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager, buffering strategy and radius.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     * @param radius           the radius of the corners
     */
    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius) {
        this(layout, isDoubleBuffered, radius, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified gradient start color, gradient end color and gradient direction.
     * The layout manager is set to FlowLayout.
     * The radius is set to 0.
     * The buffering strategy is set to true.
     *
     * @param gradientStart     the gradient start color
     * @param gradientEnd       the gradient end color
     * @param gradientDirection the gradient direction
     */
    public SPGradientRoundPanel(Color gradientStart, Color gradientEnd, int gradientDirection) {
        this(new FlowLayout(), true, 0, gradientStart, gradientEnd, gradientDirection);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager and buffering strategy.
     * The radius is set to 0.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param layout           the layout manager for this panel
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     */
    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
        this(layout, isDoubleBuffered, 0, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager and radius.
     * The buffering strategy is set to true.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param layout the layout manager for this panel
     * @param radius the radius of the corners
     */
    public SPGradientRoundPanel(LayoutManager layout, int radius) {
        this(layout, true, radius, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified background color and gradient direction.
     * The layout manager is set to FlowLayout.
     * The radius is set to 0.
     * The buffering strategy is set to true.
     * The gradient start and end colors are set to the background color.
     *
     * @param starToEnd         the background color
     * @param gradientDirection the gradient direction
     */
    public SPGradientRoundPanel(Color starToEnd, int gradientDirection) {
        this(new FlowLayout(), true, 0, starToEnd, starToEnd, gradientDirection);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified gradient start color and gradient end color.
     * The layout manager is set to FlowLayout.
     * The radius is set to 0.
     * The buffering strategy is set to true.
     * The gradient direction is set to 0.
     *
     * @param gradientStart the gradient start color
     * @param gradientEnd   the gradient end color
     */
    public SPGradientRoundPanel(Color gradientStart, Color gradientEnd) {
        this(new FlowLayout(), true, 0, gradientStart, gradientEnd, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified layout manager.
     * The radius is set to 0.
     * The buffering strategy is set to true.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param layout the layout manager for this panel
     */
    public SPGradientRoundPanel(LayoutManager layout) {
        this(layout, true, 0, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified buffering strategy.
     * The layout manager is set to FlowLayout.
     * The radius is set to 0.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param isDoubleBuffered a boolean, true for double-buffering, which uses additional memory space to achieve fast, flicker-free updates
     */
    public SPGradientRoundPanel(boolean isDoubleBuffered) {
        this(new FlowLayout(), isDoubleBuffered, 0, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code> with the specified radius.
     * The layout manager is set to FlowLayout.
     * The buffering strategy is set to true.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     *
     * @param radius the radius of the corners
     */
    public SPGradientRoundPanel(int radius) {
        this(new FlowLayout(), true, radius, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Creates a new <code>SPGradientRoundPanel</code>.
     * The layout manager is set to FlowLayout.
     * The radius is set to 0.
     * The buffering strategy is set to true.
     * The gradient start and end colors are set to white.
     * The gradient direction is set to 0.
     */
    public SPGradientRoundPanel() {
        this(new FlowLayout(), true, 0, Color.WHITE, Color.WHITE, 0);
    }

    /**
     * Returns the initial color of the gradient
     *
     * @return the initial color of the gradient
     */
    public Color getGradientStart() {
        return gradientStart;
    }

    /**
     * Sets the initial color of the gradient
     *
     * @param gradientStart the initial color of the gradient
     */
    public void setGradientStart(Color gradientStart) {
        this.gradientStart = gradientStart;
    }

    /**
     * Returns the final color of the gradient
     *
     * @return the final color of the gradient
     */
    public Color getGradientEnd() {
        return gradientEnd;
    }

    /**
     * Sets the final color of the gradient
     *
     * @param gradientEnd the final color of the gradient
     */
    public void setGradientEnd(Color gradientEnd) {
        this.gradientEnd = gradientEnd;
    }

    /**
     * Returns the gradient direction
     *
     * @return the gradient direction
     */
    public int getGradientDirection() {
        return gradientDirection;
    }

    /**
     * Sets the gradient direction. The value must be between 0 and 360
     *
     * @param gradientDirection the gradient direction
     */
    public void setGradientDirection(int gradientDirection) {
        this.gradientDirection = gradientDirection;
    }

    /**
     * Returns the custom gradient paint. If this is not null, the gradient start and end colors are ignored
     *
     * @return the custom gradient paint
     */
    public Paint getGradientPaint() {
        return gradientPaint;
    }

    /**
     * Sets the custom gradient paint. If this is not null, the gradient start and end colors are ignored
     *
     * @param gradientPaint the custom gradient paint
     */
    public void setGradientPaint(Paint gradientPaint) {
        this.gradientPaint = gradientPaint;
    }

    /**
     * Overwrite the <code>paintCustom</code> method to paint over a custom area.
     * A rectangular area with rounded corners is generated and filled with a linear gradient.
     *
     * @param g2 the <code>Graphics2D</code> object to protect
     * @see SPRoundPanel#paintCustom(Graphics2D)
     */
    @Override
    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setPaint(this.gradientPaint);
        g2.fill(area);
        g2.dispose();
    }

    /**
     * Creates a new <code>GradientPaint</code> object with the object's colors and direction.
     *
     * @param width  the width of the panel
     * @param height the height of the panel
     * @return a new <code>GradientPaint</code> object with the object's colors and direction
     */
    private Paint createGradientPaint(int width, int height) {
        Color start = this.gradientStart;
        Color end = this.gradientEnd;

        if (gradientDirection == 0) {
            return new GradientPaint(0, 0, start, 0, height, end);
        }
        double radian = Math.toRadians(this.gradientDirection);
        int x1 = (int) (width * 0.5 * (1 - Math.cos(radian)));
        int y1 = (int) (height * 0.5 * (1 - Math.sin(radian)));
        int x2 = width - x1;
        int y2 = height - y1;

        return new GradientPaint(x1, y1, start, x2, y2, end);
    }
}
