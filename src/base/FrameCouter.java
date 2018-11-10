package base;

public class FrameCouter {
    int coutMax;
    int cout;
    public FrameCouter(int coutMax){
        this.coutMax=coutMax;
        this.cout=cout;
    }
    public boolean run(){
        //true cout done
        //fasle count not done
        if(cout< coutMax){
            cout++;
            return false;
        }else {
            cout=0;
            return true;
        }
    }
    public void reset(){
        this.cout=0;

    }
}
