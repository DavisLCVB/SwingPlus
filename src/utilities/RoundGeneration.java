package utilities;

import java.awt.*;

/**
 * <code>RoundGeneration</code> is an interface that contains the methods to create the corners of a rounded shape.
 */
public interface RoundGeneration {
    /**
     * Creates a new <code>Shape</code> with the specified corner radius.
     *
     * @return a new <code>Shape</code> with the specified corner radius
     */
    Shape createCornerTL();

    /**
     * Creates a new <code>Shape</code> with the specified corner radius.
     *
     * @return a new <code>Shape</code> with the specified corner radius
     */
    Shape createCornerTR();

    /**
     * Creates a new <code>Shape</code> with the specified corner radius.
     *
     * @return a new <code>Shape</code> with the specified corner radius
     */
    Shape createCornerBL();

    /**
     * Creates a new <code>Shape</code> with the specified corner radius.
     *
     * @return a new <code>Shape</code> with the specified corner radius
     */
    Shape createCornerBR();
}
