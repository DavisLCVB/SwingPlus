package buttonComponents;

import javax.swing.*;
import java.awt.*;

public class SPCircleButton extends JButton {

    private Color borderColor = Color.BLACK;
    private int borderSize = 2;
    private Color fillColor = Color.BLACK;
    private boolean hover = false;

    public SPCircleButton() {
        super();
        setContentAreaFilled(false);
        setBorder(null);
        addProperties();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        createBorder(g2);
        if (hover)
            fillButton(g2);
        super.paintComponent(g);
    }

    private void addProperties(){
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                hover = false;
                repaint();
            }
        });
    }

    private void createBorder(Graphics2D g2) {
        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(borderSize));
        g2.drawOval(borderSize, borderSize, getWidth() - (2 * borderSize), getHeight() - (2 * borderSize));
    }

    private void fillButton(Graphics2D g2) {
        g2.setColor(fillColor);
        g2.fillOval(borderSize, borderSize, getWidth() - (2 * borderSize), getHeight() - (2 * borderSize));
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}
