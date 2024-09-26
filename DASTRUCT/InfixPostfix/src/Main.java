public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    private static int strToInt(String str) {
        int num = 0, pos = 1;
        
        for (int i = 0; i < str.length(); i++) {
            if ((int)(str.charAt(i)) >= '0' && (int)(str.charAt(i)) <= '9') {
                num += (((int)(str.charAt(i)) - '0' ) * pos);
                pos *= 10;
            }
        }
        return num;
    }
}
