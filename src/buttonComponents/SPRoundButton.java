package buttonComponents;

import panelComponents.SPRoundPanel;
import utilities.RoundInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SPRoundButton extends JButton {
    protected boolean hover;
    protected Color colorHover = new Color(127, 213, 225);
    protected Color colorClick = new Color(219, 234, 236);
    protected Color borderColor = Color.BLACK;
    protected int borderSize = 0;
    protected String text;
    protected JLabel lb = new JLabel();
    protected RoundInfo roundInfo;
    protected Color oldBackground;

    protected SPRoundPanel border;
    protected SPRoundPanel background;

    public SPRoundButton(String text, int radius) {
        this.text = text;
        this.roundInfo = new RoundInfo(radius);
        configButton();
        initComponents();
        setText(text);
    }

    public SPRoundButton(String text) {
        this.text = text;
        this.roundInfo = new RoundInfo(0);
        configButton();
        initComponents();
        setText(text);
    }

    public SPRoundButton(int radius) {
        this.roundInfo = new RoundInfo(radius);
        configButton();
        initComponents();
    }

    public SPRoundButton() {
        this.roundInfo = new RoundInfo(0);
        configButton();
        initComponents();
    }

    private void initComponents() {
        lb = new JLabel();
        background.add(lb, BorderLayout.CENTER, 0);
    }

    private void configButton() {
        this.setContentAreaFilled(false);
        this.setBorder(null);
        this.setFocusPainted(false);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                oldBackground = getBackground();
                setBackground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (hover) background.setBackground(colorHover);
                else background.setBackground(oldBackground);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hover = true;
                oldBackground = getBackground();
                background.setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hover = false;
                background.setBackground(oldBackground);
            }
        });
        this.setLayout(new BorderLayout());
        createBackground();
    }

    protected void createBackground() {
        border = new SPRoundPanel();
        border.setRoundInfo(roundInfo);
        border.setBackground(borderColor);
        border.setBorder(new EmptyBorder(borderSize, borderSize, borderSize, borderSize));
        border.setLayout(new BorderLayout());
        add(border, BorderLayout.CENTER, 0);

        RoundInfo ri = new RoundInfo(roundInfo.getRadiusTL() - borderSize, roundInfo.getRadiusTR() - borderSize,
                roundInfo.getRadiusBL() - borderSize, roundInfo.getRadiusBR() - borderSize);
        background = new SPRoundPanel();
        background.setRoundInfo(ri);
        background.setBackground(getBackground() == null ? Color.WHITE : getBackground());
        background.setLayout(new BorderLayout());
        border.add(background, BorderLayout.CENTER, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
    }

    @Override
    public void setText(String text) {
        this.text = text;
        lb.setText(text);
        lb.setVerticalAlignment(JLabel.CENTER);
        lb.setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public void setFont(Font font) {
        if (lb != null) lb.setFont(font);
    }

    @Override
    public void setForeground(Color fg) {
        if (lb != null) lb.setForeground(fg);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        if (background != null) this.background.setBackground(bg);
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        border.setBorder(new EmptyBorder(borderSize, borderSize, borderSize, borderSize));
        RoundInfo ri = new RoundInfo(roundInfo.getRadiusTL() - borderSize/2, roundInfo.getRadiusTR() - borderSize/2,
                roundInfo.getRadiusBL() - borderSize/2, roundInfo.getRadiusBR() - borderSize/2);
        background.setRoundInfo(ri);
    }

    public boolean isHover() {
        return hover;
    }

    public void setHover(boolean hover) {
        this.hover = hover;
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        border.setBackground(borderColor);
    }

    public int getBorderSize() {
        return borderSize;
    }

    public RoundInfo getRoundInfo() {
        return roundInfo;
    }

    public void setRoundInfo(RoundInfo roundInfo) {
        this.roundInfo = roundInfo;
    }
}
