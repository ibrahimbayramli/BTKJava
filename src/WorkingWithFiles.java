import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class WorkingWithFiles {
    public static void main(String[] args) {
        createFile();

        getFileInfo();

        readFile();

        writeFile();

        readFile();
    }

    public static void createFile(){
        File file =new File("./deneme.txt");
        System.out.println(file.canRead());
        try {
            if(file.createNewFile()){
                System.out.println("Dosya uretildi.");
            }else {
                System.out.println("Dosya mevcut.");
            }
            System.out.println("**************************");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }
    public static void getFileInfo(){
        File file =new File("./deneme.txt");

        // file.exists() dosya mevcut mu? bilgisini verir.
        if(file.exists()){
            System.out.println("Dosya Adi : "+file.getName());
            System.out.println("Dosya Yolu : "+file.getAbsolutePath());
            System.out.println("Dosya Yazilabilir Mi : " +file.canWrite());
            System.out.println("Dosya Okunabilir Mi : " +file.canRead());
            System.out.println("Doya Boyutu (Byte) : "+file.length());
        }
        System.out.println("**************************");
    }
    public static void readFile()  {
        File file =new File("./deneme.txt");

        try {
            Scanner reader=new Scanner(file);
            while (reader.hasNextLine()){

                System.out.println(reader.nextLine());

            }
            System.out.println("**************************");
            reader.close();
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

    }

    public static void writeFile(){
        try {
//            (1. yontem)
//            FileWriter writer =new FileWriter("./deneme.txt");

            // 2. yontem
            BufferedWriter writer=new BufferedWriter(new FileWriter("./deneme.txt",true));
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write("Tarih : "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:MM:SS")));
            System.out.println("dosyaya yazildi");
            writer.close();
            System.out.println("**************************");
        }catch (IOException e){
            System.err.println(e.getMessage());
        }


    }

}
