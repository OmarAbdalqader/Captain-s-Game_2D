package pkg2dgame_2;

import inputs.KeyboardInputs;
import inputs.Mousinputs;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import static pkg2dgame_2.Game.GAME_HEIGHT;
import static pkg2dgame_2.Game.GAME_WIDTH;

public class GamePanel extends JPanel {

    private Mousinputs mousInputs;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        mousInputs = new Mousinputs(this);

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mousInputs);
        addMouseMotionListener(mousInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
        System.out.println("Size : "+GAME_WIDTH+"\t"+GAME_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);  // استخدم الكائن الموجود بدلاً من إنشاء كائن جديد
    }

    public Game getGame() {
        return game;
    }
}
