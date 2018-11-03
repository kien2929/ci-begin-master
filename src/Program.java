import base.game.GameCanvas;
import base.game.GameWindow;

public class Program {
    public static void main(String[] args) {
//        Student student1= new Student();
//        Student student2= new Student();
//        student1.print();
//
//        student2.name="BBBB";
//        student2.code="sb";
//        student2.print();
        GameWindow window = new GameWindow();


        GameCanvas canvas = new GameCanvas();
        window.add(canvas);
        window.setVisible(true);
        canvas.gameLoop();
    }
}
