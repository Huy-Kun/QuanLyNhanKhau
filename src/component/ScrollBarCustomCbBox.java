package component;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustomCbBox extends JScrollBar {

    public ScrollBarCustomCbBox() {
        setUI(new ModernScrollBarCbBox());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
