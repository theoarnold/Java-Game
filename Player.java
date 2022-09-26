import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;

public class Player extends GameObject {

    Handler handler;
    boolean Pup = false;
    boolean Pdown= false;
    boolean Pleft= false;
    boolean Pright = false;
    float stamina = 100;
    public Player (int x, int y, ID id, Handler handler){
        super(x , y, id);
        this.handler = handler;
        
    }
    public void tick(){
        collision();
        x += velX;
        y += velY;

        //up
        if(handler.isUp()) {
            velY = -4;
            Pup = true;
            Pdown = false;
        }else if (!handler.isDown()) velY = 0;
        //left
        if(handler.isLeft()){
            velX = -5;
            Pleft = true;
            Pright = false;
        } else if (!handler.isRight()) velX = 0;
        //down
        if(handler.isDown()){
            velY = 5; 
            Pdown = true;
            Pup = false;
        } 
        else if (!handler.isUp()) {
            velY = 0;
            Pup = true;
            Pdown = false;
        }
        //right
        if(handler.isRight()) velX = 5;
        else if (!handler.isLeft()) velX = 0;
        if (handler.isRight() && handler.isRun() && stamina > 0) {
            velX += 4; 
            stamina -= 1; 
            System.out.println(stamina);  
        }

        if (handler.isLeft() && handler.isRun()&& stamina > 0){
            velX -= 4; 
            stamina -= 1;
             System.out.println(stamina);   
        } 
        if (handler.isUp() && handler.isRun()&& stamina > 0) {
            velY -= 4; 
            stamina -= 1;
             System.out.println(stamina); 
        }
            
        if (handler.isDown() && handler.isRun()&& stamina > 0) {
            velY += 4;
             stamina -= 1;
             System.out.println(stamina); 
        }
        if (!handler.isRun() && stamina < 100){
            stamina += 0.25f;
        }
    }

    public boolean place_free(int x, int y, Rectangle myRect, Rectangle otherRect) {
        myRect.x = x;
        myRect.y = y;
        if (myRect.intersects(otherRect)) {
         return false;
        }
        return true;
       }
       
       public void collision(){
        for (int i = 0; i < handler.object.size(); i++) {
         GameObject tempObject = handler.object.get(i);
      
         if (tempObject.getId() == ID.Block) {
          if (!place_free((int) (x + velX), y, getBounds(), tempObject.getBounds())) {
           velX = 0;
          }
      
          if (!place_free(x, (int) (y + velY), getBounds(), tempObject.getBounds())) {
           velY = 0;
          }
         }
        }
       }


    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(x, y, 50, 50);
        g.drawString("test test test test",70,20); 
    }

    public Rectangle getBounds(){
        return new Rectangle (x, y, 50, 50);
    }
}
