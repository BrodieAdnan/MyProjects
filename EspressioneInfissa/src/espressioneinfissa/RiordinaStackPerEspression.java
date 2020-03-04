package espressioneinfissa;

import java.util.*;

public class RiordinaStackPerEspression extends Stack{

    @Override
    public Stack riordina(Stack numeri) {
        boolean priorità = false;
        int j=0;
        while (!priorità) {
            for (int i = 0; i < stack.size() && priorità; i++) {
                if (stack.get(i).equals("*")) {
                    j=(Integer.parseInt((String) stack.get(i + 1))) * (Integer.parseInt((String) stack.get(i)));
                    String s=(String)stack.get(i);
                    //int f=(int) numeri.get(i);
                    priorità = true;

                }
            }
        }
        return numeri;
    }
}
