package panelComponents;

import java.awt.*;
import java.awt.geom.Area;

public class SPGradientRoundPanel extends SPRoundPanel {

    private Color gradientStart;
    private Color gradientEnd;
    private int gradientDirection;

    private Paint gradientPaint;

    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color gradientStart, Color gradientEnd, int gradientDirection) {
        super(layout, isDoubleBuffered, radius);
        this.gradientStart = gradientStart;
        this.gradientEnd = gradientEnd;
        if (gradientDirection < 0 || gradientDirection > 360)
            throw new IllegalArgumentException("Gradient direction must be between 0 and 360");
        this.gradientDirection = gradientDirection;
        this.gradientPaint = createGradientPaint(getWidth(), getHeight());
    }

    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color gradientStart, Color gradientEnd) {
        this(layout, isDoubleBuffered, radius, gradientStart, gradientEnd, 0);
    }

    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius, Color startToEnd) {
        this(layout, isDoubleBuffered, radius, startToEnd, startToEnd, 0);
    }

    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius) {
        this(layout, isDoubleBuffered, radius, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel(Color gradientStart, Color gradientEnd, int gradientDirection) {
        this(new FlowLayout(), true, 0, gradientStart, gradientEnd, gradientDirection);
    }

    public SPGradientRoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
        this(layout, isDoubleBuffered, 0, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel(LayoutManager layout, int radius) {
        this(layout, true, radius, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel(Color starToEnd, int gradientDirection) {
        this(new FlowLayout(), true, 0, starToEnd, starToEnd, gradientDirection);
    }

    public SPGradientRoundPanel(Color gradientStart, Color gradientEnd) {
        this(new FlowLayout(), true, 0, gradientStart, gradientEnd, 0);
    }

    public SPGradientRoundPanel(LayoutManager layout) {
        this(layout, true, 0, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel(boolean isDoubleBuffered) {
        this(new FlowLayout(), isDoubleBuffered, 0, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel(int radius) {
        this(new FlowLayout(), true, radius, Color.WHITE, Color.WHITE, 0);
    }

    public SPGradientRoundPanel() {
        this(new FlowLayout(), true, 0, Color.WHITE, Color.WHITE, 0);
    }

    public Color getGradientStart() {
        return gradientStart;
    }

    public void setGradientStart(Color gradientStart) {
        this.gradientStart = gradientStart;
    }

    public Color getGradientEnd() {
        return gradientEnd;
    }

    public void setGradientEnd(Color gradientEnd) {
        this.gradientEnd = gradientEnd;
    }

    public int getGradientDirection() {
        return gradientDirection;
    }

    public void setGradientDirection(int gradientDirection) {
        this.gradientDirection = gradientDirection;
    }

    public Paint getGradientPaint() {
        return gradientPaint;
    }

    public void setGradientPaint(Paint gradientPaint) {
        this.gradientPaint = gradientPaint;
    }

    @Override
    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setPaint(this.gradientPaint);
        g2.fill(area);
        g2.dispose();
    }

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
