import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;


public class Zombie extends GameObject{
    
    private Handler handler;

    public Zombie (int x, int y, ID id, Handler handler){
        super(x , y, id);
        this.handler = handler;
        
        
        
        
    }
    
   

    public void tick(){
        x += velX;
        y += velY;
    }


    public void render(Graphics g){
        g.setColor(Color.pink);
        g.fillRect(x, y, 50, 50);
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 50, 50);
    }
}

