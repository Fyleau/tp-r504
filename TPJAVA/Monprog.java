public class Monprog {
    public static void main(String[] args) {
        System.out.println("Nombre d'arguments : " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("arg[" + i + "] = " + args[i]);
        }
    }
}
