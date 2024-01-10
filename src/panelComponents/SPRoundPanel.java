package panelComponents;

import utilities.RoundGeneration;
import utilities.RoundInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.io.Serializable;
import java.util.ArrayList;

public class SPRoundPanel extends JPanel implements RoundGeneration, Serializable {
    private RoundInfo roundInfo;

    public SPRoundPanel(LayoutManager layout, boolean isDoubleBuffered, int radius) {
        this(layout, isDoubleBuffered);
        this.roundInfo = new RoundInfo(radius);
    }

    public SPRoundPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        setLayout(layout);
        this.roundInfo = new RoundInfo(0);
        configurePanel();
    }

    public SPRoundPanel(LayoutManager layout, int radius) {
        this(layout);
        this.roundInfo = new RoundInfo(radius);
    }

    public SPRoundPanel(LayoutManager layout) {
        setLayout(layout);
        this.roundInfo = new RoundInfo(0);
        configurePanel();
    }

    public SPRoundPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        this.roundInfo = new RoundInfo(0);
        configurePanel();
    }

    public SPRoundPanel(int radius) {
        this.roundInfo = new RoundInfo(radius);
        configurePanel();
    }

    public SPRoundPanel() {
        this.roundInfo = new RoundInfo(0);
        configurePanel();
    }

    public RoundInfo getRoundInfo() {
        return roundInfo;
    }

    public void setRoundInfo(RoundInfo roundInfo) {
        this.roundInfo = roundInfo;
    }

    private void configurePanel() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        paintCustom(g2);
        super.paintComponent(g);
    }

    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setColor(getBackground());
        g2.fill(area);
        g2.dispose();
    }

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

    @Override
    public Shape createCornerTL() {
        var list = preCalculus(roundInfo.getRadiusTL());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(list.get(2) / 2.0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, list.get(3) / 2.0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    @Override
    public Shape createCornerTR() {
        var list = preCalculus(roundInfo.getRadiusTR());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, list.get(3) / 2.0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    @Override
    public Shape createCornerBL() {
        var list = preCalculus(roundInfo.getRadiusBL());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(list.get(2) / 2.0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    @Override
    public Shape createCornerBR() {
        var list = preCalculus(roundInfo.getRadiusBR());
        Area area = calculateBaseArea(list);
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
        area.add(new Area(new Rectangle2D.Double(0, 0, list.get(0), list.get(1) - list.get(3) / 2.0)));
        return area;
    }

    protected Area calculateBaseArea(ArrayList<Integer> list) {
        return new Area(new RoundRectangle2D.Double(0, 0, list.get(0), list.get(1), list.get(2), list.get(3)));
    }

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