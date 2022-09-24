import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends GameObject {

    Handler handler;
     
    public Player (int x, int y, ID id, Handler handler){
        super(x , y, id);
        this.handler = handler;
    }
    public void tick(){
        x += velX;
        y += velY;

        //up
        if(handler.isUp()) velY = -5;
        else if (!handler.isDown()) velY = 0;
        //left
        if(handler.isLeft()) velX = -5;
        else if (!handler.isRight()) velX = 0;
        //down
        if(handler.isDown()) velY = 5;
        else if (!handler.isUp()) velY = 0;
        //right
        if(handler.isRight()) velX = 5;
        else if (!handler.isLeft()) velX = 0;

    }
    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(x, y, 50, 50);
    }

    public Rectangle getBounds(){
        return new Rectangle (x, y, 50, 50);
    }
}
