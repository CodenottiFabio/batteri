package children;

import main.Food;

public class Code extends main.Batterio{

    //attributi
    public boolean godown;
    public boolean goright;
    public boolean ultima;
    public int raggio;
    public int obbx;
    public int obby;
    public boolean trovata;

    public Code() {
        if (Math.random()%2 == 1){
            godown = true;
            goright = true;
        }
        else {
            godown = false;
            goright = false;
        }
        this.ultima = true;
        raggio = 200;
        obbx = -1;
        obby = -1;
        trovata = false;
    }

    //per spostarlo
    @Override
    protected void move(){

        for (int i = 0; i < raggio; i++) {
            if (trovata)
                break;
            for (int j = 0; j < raggio; j++) {
                if (Food.isFood((x - i), (y - j))){
                    obbx = this.getX() - i;
                    obby = this.getY() - j;
                    trovata = true;
                    break;
                }
                 if (Food.isFood(x + i, y + j)){
                    obbx = this.getX() + i;
                    obby = this.getY() + j;
                    trovata = true;
                    break;
                }
                 if (trovata)
                     break;
            }
        }

        if (obbx != -1 && obby != -1) {
            if (obbx > x)
                x += (obbx - x);
            else if (obbx < x)
                x -= (x - obbx);
            if (obby > y)
                y += (obby - y);
            else if (obby < y)
                y -= (y - obby);
        }
        else if (!trovata) {
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


        if (obbx == x && obby == y){
            obbx =-1;
            obby = -1;
            trovata = false;
        }


    }

    //per clonarlo
    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Code clone = (Code) super.clone();
        clone.x = (int)(Math.random() % Food.getWidth());
        clone.y = (int)(Math.random() % Food.getHeight());
        clone.ultima = !ultima;
        return clone;
    }
}
