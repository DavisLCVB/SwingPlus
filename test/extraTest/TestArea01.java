package extraTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class TestArea01 {
    public static void main(String[] args) {

        var frame = new JFrame();
        var panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                var g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                var list = preCalculus(50, this);
                var area = new Area(new RoundRectangle2D.Double(0, 0, list.get(0), list.get(1), 50,50));
                area.add(new Area(new Rectangle2D.Double(list.get(2) / 2.0, 0, list.get(0) - list.get(2) / 2.0, list.get(1))));
                area.add(new Area(new Rectangle2D.Double(0, list.get(3) / 2.0, list.get(0), list.get(1) - list.get(3) / 2.0)));
                g2.setColor(getBackground());
                g2.fill(area);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBounds(35, 35, 400, 400);
        panel.setBackground(Color.RED);
        panel.setOpaque(false);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static ArrayList<Integer> preCalculus(int comp, JPanel frame) {
        ArrayList<Integer> list = new ArrayList<>();
        var width = frame.getWidth();
        var height = frame.getHeight();
        var roundX = Math.min(width, comp);
        var roundY = Math.min(height, comp);
        list.add(width);
        list.add(height);
        list.add(roundX);
        list.add(roundY);
        return list;
    }
}
