public class Camera {
    private float x, y;

    public Camera (float x, float y){
        this.x = x;
        this.y = y;
    }

   

    public void tick (GameObject object){
        //remember toa djust this when changing window size

        //var windowX = Window.getwidth();
        x += ((object.getX() - x) - 900/2) * 0.07f;
        y += ((object.getY() - y) - 540/2) * 0.07f;
 


        //camera stopping at edge of map
        //if(x <=0) x =0;
        //if(x >= 1032) x = 1032;
        //if(y <= 0) y =0;
        //if (y >= 563+16) y = 563+16;
    }

    public float getX() {
        return x;
    }
    public void setX(float x){
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
}
