class Node {
    //variable of data this node
    protected String name;
    protected int nim;
    protected char gender;

    //dual address this node, previous and next
    protected Node previous, next;

    //constructor this class with default value of nama = "", nim = 0, gender = 'L'
    public Node() {
        next = null;
        previous = null;
        name = "";
        nim = 0;
        gender = 'L';
    }

    //constructor this class with nama, nim, gender
    public Node(String name, int nim, char gender) {
        this.name = name;
        this.nim = nim;
        this.gender = gender;
    }

//    show node data
    public void showNode(){
        System.out.println("{  " + name +"   |   " + nim +"  |  " + gender +" }");
    }
}
