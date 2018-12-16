import java.util.Scanner;

public class DataMahasiswa {
    public static void main(String[] args){
        char ch;
        String name;
        String nim;
        char gender;
        Scanner scan = new Scanner(System.in);
        DoubleLink list = new DoubleLink();

        do{
            System.out.println("\nData Mahasiswa");
            System.out.println("1. Memasukan data");
            System.out.println("2. Menghapus data");
            System.out.println("3. Mengubah data");
            System.out.println("4. Menampilkan data");
            System.out.println("5. Keluar");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Masukan data mahasiswa");
                    System.out.print("Nama mahasiswa :");
                    name = scan.next();
                    System.out.print("Nim mahasiswa :");
                    nim = scan.next();
                    do {
                        System.out.print("Jenis Kelamin mahasiswa :");
                        gender = scan.next().charAt(0);
                    } while(!(gender == 'L' || gender == 'P'));
                    list.insertData(name, nim, gender);
                    break;

                case 2:
                    System.out.println("Hapus data mahasiswa");
                    System.out.print("Nim mahasiswa :");
                    nim = scan.next();
                    list.delete(nim);
                    break;
                case 3:
                    System.out.println("Mengubah data mahasiswa");
                    System.out.print("Nim mahasiswa :");
                    nim = scan.next();
                    list.updateData(nim);
                    break;

                case 4:
                    System.out.println("Menampilkan data mahasiswa");
                    list.showFoward();
                    break;
            }
            list.showFoward();
            System.out.println("\nApa1kah anda ingin melanjutkan lagi (Ketik y atau n)");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');

//        System.out.println("Data pertama, {22,22.99} dimasukkan dengan insertFirst");
//        list.insertFirst("Hello", 1223123, 'L');
//        list.insertFirst("ha", 1223123, 'L');
//        list.insertFirst("3", 1223123, 'L');
//        list.insertLast("last", 1223123, 'L');
//        list.showFoward();
    }
}
