package children;

import main.Food;

public class Arrivetti extends main.Batterio{
    private int raggio;
    private int ciboX;
    private int ciboY;
    private boolean trovato;
    public Arrivetti(){
        raggio = 10;
        ciboY = -1;
        ciboX = -1;
        trovato = false;

    }
    @Override
    protected void move() throws Exception {
        if(!trovato){
            for(int i = 0; i < raggio; i++){
                if(trovato)
                    break;
                for(int j = 0; j < raggio; j++){
                    if(Food.isFood(this.getX() + i, this.getY() + j)){
                        ciboX = this.getX() + i;
                        ciboY = this.getY() + j;
                        trovato = true;
                    }
                    else if(Food.isFood(this.getX() - i, this.getY() - j)){
                        ciboX = this.getX() - i;
                        ciboY = this.getY() - j;
                        trovato = true;
                    }
                    else if(Food.isFood(this.getX() + i, this.getY() - j)){
                        ciboX = this.getX() + i;
                        ciboY = this.getY() - j;
                        trovato = true;
                    }
                    else if(Food.isFood(this.getX() - i, this.getY() + j)){
                        ciboX = this.getX() - i;
                        ciboY = this.getY() + j;
                        trovato = true;
                    }
                    if(trovato)
                        break;
                }
            }
        }
        if(ciboX > this.getX())
            x++;
        else
            x--;
        if(ciboY > this.getY())
            y++;
        else
            y--;
        if(ciboY == y && ciboX == x){
            trovato = false;
            ciboY = -1;
            ciboX = -1;
            while(this.isReadyForCloning())
                this.clone();
        }
    }
    @Override
    public main.Batterio clone() throws CloneNotSupportedException {
        Arrivetti clone = (Arrivetti) super.clone();
        clone.x = x+ 10;
        clone.y = y +10;
        return clone;
    }
}
