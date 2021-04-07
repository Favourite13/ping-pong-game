package game;

/*import java.awt.Canvas;*/
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window /** extends Canvas */
{

    /* private static final long serialVersionUID = 3721650581912402800L; */

    private JFrame frame;

    public Window(int width, int height, String title, Game scene) {
	frame = new JFrame(title);
	frame.setPreferredSize(new Dimension(width, height));
	frame.setMinimumSize(new Dimension(width, height));
	frame.setMaximumSize(new Dimension(width, height));
	frame.setResizable(false);
	frame.add(scene);
	frame.pack();
	frame.setFocusable(true);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	scene.start();

    }

}
