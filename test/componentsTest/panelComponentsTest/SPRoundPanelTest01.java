package componentsTest.panelComponentsTest;

import panelComponents.SPRoundPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SPRoundPanelTest01 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.setBackground(new Color(0,0,0,0));
        center.setBorder(new EmptyBorder(50,50,50,50));

        SPRoundPanel panel = new SPRoundPanel(50);
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.RED);

        center.add(panel, BorderLayout.CENTER);
        frame.add(center, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
