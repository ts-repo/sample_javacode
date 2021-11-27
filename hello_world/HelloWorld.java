public class HelloWorld {
    public static void main(String[] args) {

        System.out.println("start");

        boolean flg = false;
        if (args.length != 0) {
            flg = true;
            System.out.println("Hello World!!" + args[0]);
        }

        if(!flg){
            System.out.println("引数はありません");
        }

        System.out.println("end");
    }
} 







