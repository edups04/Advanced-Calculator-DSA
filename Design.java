import javax.swing.*;
import java.awt.*;

class Design extends JButton {
    private int radius;

    public Design (String label, int radius) {
        super(label);
        this.radius = radius;
        setFont(new Font("SansSerif", Font.PLAIN, 30)); 
        setFocusPainted(false); 
        setContentAreaFilled(false); 
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
       
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // smooth rectangles
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width - 1, height - 1, radius, radius);
        
        String text = getText();
        FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (width - metrics.stringWidth(text)) / 2; // Centering x position
        int y = ((height - metrics.getHeight()) / 2) + metrics.getAscent(); // Centering y position

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
        
    }
}
