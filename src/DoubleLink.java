import java.util.Scanner;

class DoubleLink {
    //declaration for first and last node
    private Node first, last;
    Scanner scan = new Scanner(System.in);

    //construct
    public DoubleLink(){
        first = null;
        last = null;
    }

    //check empty this double link
    public boolean isEmpty(){
        return first==null;
    }

    //method for insert first data, use for first data male gender (L)
    public void insertFirst(String name, int nim, char gender){
        Node node = new Node(name, nim, gender);
        if(isEmpty())
            last = node;
        else {
            first.previous = node;
            node.next = first;
        }
        first = node;

    }

    //method for insert last data, use for first data female gender (P)
    public void insertLast(String name, int nim, char gender){
        Node node = new Node(name, nim, gender);
        if(isEmpty())
            first = node;
        else {
            last.next = node;
            node.previous = last ;
        }
        last = node;
    }

    //method for insert after, use for first data male gender (L)
    public boolean insertAfter(int nim, String name, int nim1, char gender) {
        Node index = first;
        while(index.nim != nim) {
            index = index.next;
            if(index == null)
                return false; // data not found
        }
        Node newNode = new Node(name,nim1, gender);
        if(index == last) {

            last = newNode;
        }
        else {
            newNode.next = index.next;
            index.next.previous = newNode;
        }
        newNode.previous = index;
        index.next = newNode;
        return true; // previous data found, new data added
    }

    public Node delete(int nim1){
        if(!isEmpty()){
        Node index = first;
        while(index.nim != nim1) {
            index = index.next;
            if(index == null)
                return null; // data not found
        }
        if(index == first)
            first = index.next;
        else
            index.previous.next = index.next;

        if(index == last)
            last = index.previous;
        else
            index.next.previous = index.previous;
        return index;}
        else
            System.out.println("Data Kosong");
            return null;
    }

    public void updateData(int nim1) {
        char gender;
        if (!isEmpty()) {
            int ch;
            Node index = first;
            while (index.nim != nim1) {
                index = index.next;
                if (index == null)
                    System.out.println("Data tidak ditemukan");
            }
            Node tmp = index;

            do {
                System.out.println("1. Ubah Nama mahasiswa ---> " + tmp.name);
                System.out.println("2. Ubah Nim mahasiswa ---> " + tmp.nim);
                System.out.println("3. Ubah Jenis Kelamin mahasiswa ---> " + tmp.gender);
                System.out.println("4. Finish");
                System.out.println("Pilih update :");
                 ch = scan.nextInt();
                 switch (ch){
                     case 1:
                         System.out.print("Nama mahasiswa :");
                         tmp.name = scan.next();
                         System.out.print("Ubah data sukses");
                         break;
                     case 2:
                         System.out.print("Nim mahasiswa :");
                         tmp.nim = scan.nextInt();
                         System.out.print("Ubah data sukses");
                         break;
                     case 3:
                         System.out.print("Jenis Kelamin mahasiswa :");
                         tmp.gender = scan.next().charAt(0);
                         System.out.print("Ubah data sukses");
                         break;
                 }
            } while (ch < 4);
            delete(index.nim);
            insertData(tmp.name, tmp.nim, tmp.gender);
            System.out.print("Data terbaru sudah diperbarui");


        } else {
            System.out.println("Data Kosong");
        }
    }

    public void showFoward() {
        System.out.println("List Data Mahasiswa: ");
        Node index = first;
        while(index != null) {
            index.showNode();
            index = index.next;
        }
        System.out.println("");
    }

    public boolean checkNim(int nim1){
        if(isEmpty()) {
            return false;
        }
        else {
            Node index = first;
            while(index.nim != nim1) {
                index = index.next;
                if(index == null)
                    return false;
            }
            return true;
        }
    }

    public void insertData(String name, int nim1, char gender){
        boolean notFound = false;
        if(!checkNim(nim1)) {
            if (gender == 'L') {
                if (this.isEmpty())
                    insertFirst(name, nim1, gender);
                else {
                    Node index = first;
                    Node temp;
                    if (index.nim < nim1) {
                        while (index.nim < nim1) {
                            temp = index;
                            index = index.next;
                            if (index == null) {
                                index = temp;
                                System.out.println("Nim sebelumnya = " + index.nim);
                                break;
                            }
                        }
                        if (!notFound) {
                            System.out.println(insertAfter(index.nim, name, nim1, gender));
                        }
                    } else {
                        insertFirst(name, nim1, gender);
                    }
                }
            } else {
                if (isEmpty())
                    insertLast(name, nim1, gender);
                else {
                    Node index = last;
                    Node temp;
                    if (index.nim > nim1) {
                        while (index.nim > nim1) {
                            temp = index;
                            index = index.previous;
                            if (index == null || index.gender == 'L') {
                                index = temp;
                                System.out.println("Nim sebelumnya = " + index.nim);
                                break;
                            }
                        }
                        if (!notFound) {
                            System.out.println(insertAfter(index.nim, name, nim1, gender));
                        }
                    } else {
                        insertLast(name, nim1, gender);
                    }

                }
            }
        }
        else {
            System.out.println("Data Mahasiswa Sudah ada");
            System.out.println();
        }
    }
}
