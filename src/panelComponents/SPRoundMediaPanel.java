package panelComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

public class SPRoundMediaPanel extends SPRoundPanel {
    private ImageIcon media;


    public SPRoundMediaPanel(ImageIcon media, int radius) {
        super(radius);
        this.media = media;
    }

    public SPRoundMediaPanel(ImageIcon media) {
        super();
        this.media = media;
    }

    public SPRoundMediaPanel() {
        super();
    }

    @Override
    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setClip(area);
        if (this.media != null) {
            g2.drawImage(media.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
        g2.dispose();
    }

    public ImageIcon getMedia() {
        return media;
    }

    public void setMedia(ImageIcon media) {
        this.media = media;
    }
}
