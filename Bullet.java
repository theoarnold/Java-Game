import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Bullet extends GameObject{

    private Handler handler;

    public Bullet (int x, int y, ID id, Handler handler, int mouseX, int mouseY){
        super(x , y, id);
        this.handler= handler;

        velX = (mouseX - x) / 10;
        velY = (mouseY - y) / 10;
    }
    
    public void tick(){
        x += velX;
        y += velY;
    }


    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillOval(x, y, 8, 8);
    }
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x, y, 8, 8);
    }
}