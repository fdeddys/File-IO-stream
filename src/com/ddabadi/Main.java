package com.ddabadi;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    // write your code here

        String pathFile ="testFileText.txt";
        String pathFile2 ="testClassFileText.txt";
        // String pathFile ="f:\\test.txt";

        GenFile("abcabcabc ", pathFile);
        ReadFile(pathFile);

        GenClassFile("Deddy","rahasia",pathFile2);
        ReadClassFile("testClass.txt");

    }

    public static void GenFile(String pesan, String path) throws IOException {

        try {
            byte[] pesanInByte = pesan.getBytes();
            File file =new File(path);
            FileOutputStream fos = new FileOutputStream(file, false);
            fos.write(pesanInByte);
            fos.close();
        } catch (IOException e) {
            throw e;
        }

    }

    public static void ReadFile(String path) throws IOException {

        File file =new File(path);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            int ukuranFile = fileInputStream.available();
            System.out.println("Membaca File");
            for(int k=0; k<= ukuranFile; k++) {
                System.out.print((char) fileInputStream.read());
            }

        } catch (IOException e) {
            throw e;
        }finally {
            fileInputStream.close();
        }
    }


    public static void GenClassFile(String nama, String pesan, String path) throws IOException {

        FileRahasia fr = new FileRahasia();
        fr.setNama(nama);
        fr.setKatakunci(pesan);
        try {
            byte[] pesanInByte = pesan.getBytes();
            File file =new File(path);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
            objectOutputStream.writeObject(fr);
            fos.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public static void ReadClassFile(String path) throws IOException {

        FileRahasia fr = new FileRahasia();

        try {

            File file =new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            fr = (FileRahasia)objectInputStream.readObject();
            System.out.println("Hasil baca dari Object Input Stream");
            System.out.println("Nama = "+fr.getNama());
            System.out.println("KataKunci = "+fr.getKatakunci());
            fileInputStream.close();
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


}
