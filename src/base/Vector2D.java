package base;

public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x,float y){
        this.x=x;
        this.y=y;
    }
    public Vector2D(){
        this(0,0);
    }

    public Vector2D add(float x, float y){
        Vector2D result =new Vector2D(this.x+x,this.y+y);
        return result;
    }
    public Vector2D add(Vector2D other){
        return this.add(other.x,other.y);
    }
    public Vector2D addThis(float x,float y ){
        this.x+=x;
        this.y+=y;
        return this;
    }
    public Vector2D addThis(Vector2D other){
        return this.addThis(other.x,other.y);
    }
    public Vector2D substract(float x, float y){
        Vector2D result =new Vector2D(this.x-x, this.y-y);
        return result;
    }
    public Vector2D substract(Vector2D other){
        return this.substract(other.x,other.y);
    }


    public Vector2D substractThis(float x, float y){
       this.x-=x;
       this.y-=y;
       return this;
    }
    public Vector2D substractThis(Vector2D other){
        return this.substractThis(other.x,other.y);
    }

    public Vector2D scale(float rate){

        return new Vector2D(this.x*rate,this.y*rate);
    }

    public Vector2D scaleThis(float rate){
        this.x*=rate;
        this.y*=rate;
        return this;
    }
    public Vector2D scaleThis(Vector2D other){
        return this.scaleThis(other);
    }
    public Vector2D set(float x,float y){
        this.x=x;
        this.y=y;
        return this;
    }
    public Vector2D set(Vector2D other){
        return this.set(other.x,other.y);
    }
    public float lengh(){
        return (float)Math.sqrt(x*x+y*y);
    }
    public Vector2D setLength(float length){
        float currentLength=this.lengh();
        this.scaleThis(length/currentLength);
        return this;
    }
//    public Vector2D setLength(){
//
//    }

    }
