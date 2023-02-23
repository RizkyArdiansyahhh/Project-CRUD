import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        Scanner terminaalInput = new Scanner(System.in);
        String pilihanUser;
        boolean isLanjutkan = true;

        while (isLanjutkan) {
            clearScreen();
            System.out.println("\n========DATABASE PERPUSTAKAAN========\n");
            System.out.println("1.\tLihat seluruh buku");
            System.out.println("2.\tCari data buku");
            System.out.println("3.\tTambah data buku");
            System.out.println("4.\tUbah data buku");
            System.out.println("5.\thapus data buku");

            System.out.print("\n\nPilihan anda: ");
            pilihanUser = terminaalInput.next();

            switch (pilihanUser) {
                case "1":
                    System.out.println("\n=================");
                    System.out.println("LIST SELURUH BUKU");
                    System.out.println("=================");
                    //TAMPILKAN DATA
                    break;
                case "2":
                    System.out.println("\n=========");
                    System.out.println("CARI BUKU");
                    System.out.println("=========");
                    //CARI DATA
                    break;
                case "3":
                    System.out.println("\n================");
                    System.out.println("TAMBAH DATA BUKU");
                    System.out.println("================");
                    //TAMBAH DATA
                    break;
                case "4":
                    System.out.println("\n==============");
                    System.out.println("UBAH DATA BUKU");
                    System.out.println("==============");
                    //UBAH DATA
                    break;
                case "5":
                    System.out.println("\n===============");
                    System.out.println("HAPUS DATA BUKU");
                    System.out.println("===============");
                    //HAPUS DATA
                    break;
                default:
                    System.err.println("\nPilihan anda tidak vaid \nSilahkan masukkan angka (1-5)");
            }
            isLanjutkan = getYesOrNo("Apakah anda ingin melanjutkan");
        }
    }

    private static void tampilkanData() throws IOException{

    }

    //FUNGSI DI BAWAH UNTUK MENGECUALIKAN INPUT USER SELAIN Y/N
    private static boolean getYesOrNo(String message){
        Scanner terminaalInput = new Scanner(System.in);
        System.out.print("\n" + message + "(y/n) ? ");
        String pilihanUser = terminaalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")){
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message + "(y/n) ? ");
            pilihanUser = terminaalInput.next();
        }
        return pilihanUser.equalsIgnoreCase("y");
    }

    //FUNGSI DI BAWAH UNTUK MEMBUAT CLEAR SCREEN
    private static void clearScreen(){
        try{
            if(System.getProperty("os.name").contains("Windows")){
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            }else {
                System.out.println("\033\143");
            }
        }catch(Exception e){
            System.out.println("Tidak bisa clear screen");
        }

    }
}
