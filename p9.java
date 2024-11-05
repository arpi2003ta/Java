import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

 class KeyEventExample extends JFrame implements KeyListener {
    private JLabel displayLabel;

    public KeyEventExample() {
        setTitle("KeyEvent Handling Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Label to display key event information
        displayLabel = new JLabel("Press any key...");
        displayLabel.setBounds(50, 50, 300, 50);
        add(displayLabel);

        // Add KeyListener to the frame
        addKeyListener(this);
        setFocusable(true);  // Set focusable to ensure frame receives key events
    }

    @Override
    public void keyPressed(KeyEvent e) {
        displayLabel.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        displayLabel.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        displayLabel.setText("Key Typed: " + e.getKeyChar());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            KeyEventExample keyEventExample = new KeyEventExample();
            keyEventExample.setVisible(true);
        });
    }
}
