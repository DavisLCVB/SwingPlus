package utilities;

import java.awt.*;

/**
 * <code>RoundGeneration</code> is an interface that contains the methods to create the corners of a rounded shape.
 */
public interface RoundGeneration {
    Shape createCornerTL();
    Shape createCornerTR();
    Shape createCornerBL();
    Shape createCornerBR();
}
