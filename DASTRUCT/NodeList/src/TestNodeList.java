public class TestNodeList {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        Node newNode1 = new Node();
        Node newNode2 = new Node();
        Node newNode3 = new Node();

        newNode1.data = "Hello World";
        newNode2.data = "Hi crush";
        newNode3.data = "what the sigma";


        System.out.println(list.isEmpty());

        list.add(newNode1);
        list.add(newNode2);
        list.add(newNode3);

        System.out.println(list.isEmpty());

        list.displayFIFO();
        list.displayLIFO();

        list.delete(2);
        list.displayFIFO();
    }
}
