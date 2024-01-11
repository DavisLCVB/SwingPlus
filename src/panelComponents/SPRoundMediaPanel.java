package panelComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;

/**
 * <code>SPRoundMediaPanel</code> is a class that creates a Panel with rounded corners with media content.
 * <p>
 * <strong>Note:</strong> Corners can have an independent radius. As it is a graphic drawn on a panel, some JPanel methods such as setBorder() may not give the desired results.
 * <br>
 * <strong>Note:</strong> Media content can only include images and gifs.
 * <br>
 * <strong>Warning:</strong> This class extends <code>SPRoundPanel</code> so its warnings apply. Please see {@link SPRoundPanel}
 * </p>
 *
 * @author Davis Cartagena
 * @since 1.0
 */
public class SPRoundMediaPanel extends SPRoundPanel {
    /**
     * This field contains the media content.
     */
    private ImageIcon media;


    /**
     * Creates a new <code>SPRoundMediaPanel</code> with the specified media content and radius
     *
     * @param media  the media content
     * @param radius the radius of the corners
     */
    public SPRoundMediaPanel(ImageIcon media, int radius) {
        super(new FlowLayout(), true, radius);
        this.media = media;
    }

    /**
     * Creates a new <code>SPRoundMediaPanel</code> with the specified media content
     *
     * @param media the media content
     */
    public SPRoundMediaPanel(ImageIcon media) {
        super(new FlowLayout(), true, 0);
        this.media = media;
    }

    /**
     * Creates a new <code>SPRoundMediaPanel</code>
     */
    public SPRoundMediaPanel() {
        super(new FlowLayout(), true, 0);
    }

    /**
     * Overwrites the <code>SPRoundPanel</code> class function to place a mask over an area with rounded corners over which it draws an image.
     * <p>
     * More information: {@link SPRoundPanel#paintComponent(Graphics)}
     * </p>
     *
     * @param g2 the <code>Graphics2D</code> object to draw
     */
    @Override
    protected void paintCustom(Graphics2D g2) {
        Area area = createRoundArea();
        g2.setClip(area);
        if (this.media != null) {
            g2.drawImage(media.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
        g2.dispose();
    }

    /**
     * Returns the media content
     *
     * @return the media content
     */
    public ImageIcon getMedia() {
        return media;
    }

    /**
     * Sets the media content
     *
     * @param media the media content
     */
    public void setMedia(ImageIcon media) {
        this.media = media;
        repaint();
    }
}
