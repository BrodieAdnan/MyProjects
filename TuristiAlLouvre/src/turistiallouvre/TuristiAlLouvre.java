package turistiallouvre;

public class TuristiAlLouvre {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer=new Buffer();
        for (int i = 0; i < 50; i++) {//50 turisti per entrare al museo.
            new Turisti(buffer, "Turista n."+i).start();
            //t.join();
        }
    }
    
}
