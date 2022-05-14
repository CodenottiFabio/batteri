package children;

import main.Food;

public class Arrive extends main.Batterio {

    public boolean godown;
    public boolean goright;
    public boolean ultima;

    public Arrive() {
        if (Math.random()%2 == 1){
            godown = true;
            goright = true;
        }
        else {
            godown = false;
            goright = false;
        }
        this.ultima = true;
    }

    @Override
    protected void move() {
        if (y > Food.getHeight()) {
            godown = false;
        }
        if (x > Food.getWidth()) {
            goright = false;
        }
        if (y < 0) {
            godown = true;
        }
        if (x < 0) {
            goright = true;
        }
        if (ultima) {
            if (godown)
                y++;
            else
                y--;
        } else {
            if (goright)
                x++;
            else
                x--;
        }

    }

    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Arrive clone = (Arrive) super.clone();
        clone.ultima = ultima;
        return clone;
    }
}