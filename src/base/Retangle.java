package base;

public class Retangle {
    Vector2D position;
    int width;
    int height;

//    public Retangle() {
//        this(new Vector2D(), 5, 5);
//    }

    public Retangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public boolean intersects(Retangle other) {
        if ((other.position.x > (this.position.x + this.width) ||
                (other.position.x + other.width) < this.position.x)||(other.position.y > (this.position.y + this.height) ||
                (other.position.y + other.height) < this.position.y)) {
                return false;
            }
            else return true;
    }

    public static void main(String[] args) {
        Retangle rec1 = new Retangle(new Vector2D(0, 0), 10, 10);
        Retangle rec2 = new Retangle(new Vector2D(5, 5), 10, 10);
        Retangle rec3 = new Retangle(new Vector2D(5, -15), 10, 10);
        rec1.intersects(rec2);//==true;
        rec2.intersects(rec3);//==false;

        System.out.println(rec1.intersects(rec2));
        System.out.println(rec2.intersects(rec3));
    }
}
