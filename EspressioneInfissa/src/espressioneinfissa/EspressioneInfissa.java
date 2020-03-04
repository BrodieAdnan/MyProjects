package espressioneinfissa;

public class EspressioneInfissa {

    static Stack numeri = new Stack();
    static Stack operazioni = new Stack();
    static String espressione = "(1+2*(1+2*3))"; //risulatato=15;
    static String[] formula;
    static int parentesiAperta;
    static int parentesiChiusa;
    static String supporto = "";

    public static void main(String[] args) {
        do {
            formula = new String[espressione.length()];
            riempi();
            riempiStack();
            riordinaStack();
            calcola();
        } while (parentesiAperta != 0 && parentesiChiusa != espressione.length());
        System.out.println(numeri.top());
    }

    public static void riempi() {
        for (int i = 0; i < espressione.length(); i++) {
            formula[i] = "" + espressione.charAt(i);
        }
    }

    public static void riempiStack() {
        parentesiAperta = 0;
        parentesiChiusa = 0;
        for (int i = 0; i < formula.length; i++) {
            if (formula[i].equals("(")) {
                parentesiAperta = i + 1;
            }
        }
        for (int i = formula.length; i > 0; i--) {
            if (formula[i].equals(")")) {
                parentesiChiusa = i;
            }
        }

        for (; parentesiAperta < parentesiChiusa; parentesiAperta++) {
            if (formula[parentesiAperta].equals("+") || formula[parentesiAperta].equals("-") || formula[parentesiAperta].equals("*") || formula[parentesiAperta].equals("/")) {
                operazioni.push(formula[parentesiAperta]);
            } else {
                numeri.push(formula[parentesiAperta]);
            }
        }
    }

    public static void riordinaStack() {
		
//        numeri = operazioni.riordina(numeri);
    }

    public static void calcola() {
        if (((String) operazioni.top()).equals("+")) {
            numeri.push((Integer.parseInt((String) numeri.pop())) + (Integer.parseInt((String) numeri.pop())));
            operazioni.pop();
        } else if (((String) operazioni.top()).equals("-")) {
            numeri.push((Integer.parseInt((String) numeri.pop())) - (Integer.parseInt((String) numeri.pop())));
            operazioni.pop();
        } else if (((String) operazioni.top()).equals("/")) {
            numeri.push((Integer.parseInt((String) numeri.pop())) / (Integer.parseInt((String) numeri.pop())));
            operazioni.pop();
        } else { //moltiplicazione.
            numeri.push((Integer.parseInt((String) numeri.pop())) * (Integer.parseInt((String) numeri.pop())));
            operazioni.pop();
        }
        supporto = espressione.substring(0, parentesiAperta - 1) + (String) numeri.pop() + espressione.substring(parentesiChiusa + 1, espressione.length());
        espressione = supporto;
    }
}
