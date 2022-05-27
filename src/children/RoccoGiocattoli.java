package children;


import main.Food;

public class RoccoGiocattoli extends main.Batterio {
    public boolean goDown;
    public boolean goRight;

    @Override
    protected void move() throws Exception {
        while(getHealth()>300) {
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

            if (y <= 0)
                goDown = true;
        }
        if (getAge()<100)
        {
            if (goRight)
                x=x+2;
            else
                x=x-2;

            if (goDown)
                y=y+2;
            else
                y=y-2;

        }
    }

    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        RoccoGiocattoli clone = (RoccoGiocattoli) super.clone();
        clone.x = x+3;
        clone.y = y +3;
        return clone;
    }
}