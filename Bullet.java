import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Bullet extends GameObject{

    private Handler handler;
    private double direction;
    private int speed = 30;
    public Bullet (int x, int y, ID id, Handler handler, int mouseX, int mouseY){
        super(x , y, id);
        this.handler= handler;

        int deltaX = mouseX - x;
        int deltaY = mouseY - y;
        direction = Math.atan2(deltaY, deltaX);
      
    }
    
    public void tick(){
        x = (int)(x + (speed * Math.cos(direction)));
        y = (int)(y + (speed * Math.sin(direction)));

        for(int i=0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Block) {
                if (getBounds().intersects(tempObject.getBounds())){
                    handler.removeOject(this);
                }
            }
        } 
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