package entitys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import utilz.Constants;
import utilz.HelpMethods;
import utilz.LoadSave;

public class Player extends Entity {
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 25;
    private int playerAction = Constants.PlayerConstants.IDLE;
    private boolean moving = false, attacking = false;
    private boolean up, left, right, down;
    private float playerSpeed = 2.0f;
    private int[][] lvlData;

    // تحديد حجم اللاعب64  40
    private final int WIDTH = 130;
    private final int HEIGHT = 120;

    public Player(float x, float y) {
        super(x, y);
        loadAnimations();
    }

    public void update() {
        updatePos();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][aniIndex], (int) x, (int) y, WIDTH, HEIGHT, null);
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= Constants.PlayerConstants.GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                attacking = false;
            }
        }
    }

    private void setAnimation() {
        if (moving) {
            playerAction = Constants.PlayerConstants.RUNNING;
        } else {
            playerAction = Constants.PlayerConstants.IDLE;
        }

        if (attacking) {
            playerAction = Constants.PlayerConstants.ATTACK_1;
        }
    }

    private void updatePos() {
        moving = false;
        if (!left && !right && !up && !down) {
            return;
        }

        float xSpeed = 0, ySpeed = 0;

        if (left && !right) {
            xSpeed -= playerSpeed;
            moving = true;
        } else if (!left && right) {
            xSpeed += playerSpeed;
            moving = true;
        }

        if (up && !down) {
            ySpeed -= playerSpeed;
            moving = true;
        } else if (!up && down) {
            ySpeed += playerSpeed;
            moving = true;
        }

        // التحقق من التصادم بشكل مثالي
        if (HelpMethods.CanMoveHere(x + xSpeed, y + ySpeed, WIDTH, HEIGHT, lvlData)) {
            x += xSpeed;
            y += ySpeed;
        }
    }

    private void loadAnimations() {
        BufferedImage img = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * 64, j * 40, 64, 40);
            }
        }
    }

    public void loadLvlData(int[][] lvlData) {
        this.lvlData = lvlData;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setAttack(boolean attacking) {
        this.attacking = attacking;
    }

    public void resetDirBooleans() {
        left = false;
        right = false;
        up = false;
        down = false;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
