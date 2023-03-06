import java.io.BufferedReader;
import java.io.FileReader;
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
                    tampilkanData();
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
        FileReader fileInput;
        BufferedReader bufferedinput;

        try{
            fileInput = new FileReader("database.txt");
            bufferedinput = new BufferedReader(fileInput);
        }catch(Exception e){
            System.err.println("Database tidak di temukan");
            System.err.println("Silahkan tambah data terlebih dahulu");
            return;
        }

        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.println("| NO |\tTAHUN   |\tPENULIS                 |\tPENERBIT           |\tJUDUL BUKU           |");
        System.out.println("----------------------------------------------------------------------------------------------");

        String data = bufferedinput.readLine();
        int nomordata = 0;
        while(data != null) {
            nomordata++;

            StringTokenizer stringTokenizer = new StringTokenizer(data,",");
            stringTokenizer.nextToken();

            System.out.printf("| %2d ",nomordata);
            System.out.printf("|\t%4s    ", stringTokenizer.nextToken());
            System.out.printf("|\t%-20s    ", stringTokenizer.nextToken());
            System.out.printf("|\t%-15s    ", stringTokenizer.nextToken());
            System.out.printf("|\t%-16s     |", stringTokenizer.nextToken());
            System.out.println();
            data = bufferedinput.readLine();
        }
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("AKHIR DARI DATA BASE");


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
