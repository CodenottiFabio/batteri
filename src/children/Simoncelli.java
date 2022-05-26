package children;

import main.Batterio;
import main.Food;

public class Simoncelli extends Batterio {
    private boolean goDown;
    private boolean goRight;

    @Override
    protected void move() throws Exception {
        if (goRight)
            x++;
        else
            x--;

        if (goDown)
            y++;
        else
            y--;

        if (x >= Food.getWidth())
            goRight = false;

        if (x <= 0)
            goRight = true;

        if (y >= Food.getHeight())
            goDown = false;

        if (y<= 0)
            goDown = true;
    }

    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Simoncelli clone = (Simoncelli) super.clone();
        clone.goDown = !goDown;
        clone.goRight =! goRight;
        return clone;
    }
}
