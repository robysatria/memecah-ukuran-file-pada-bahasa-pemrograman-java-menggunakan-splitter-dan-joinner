/** 
 Nama           : Muhamad Roby Satria
 Kelas          : 2KA22
 NPM            : 10121766
 Mata Kuliah    : Struktur & Organisasi Data*
 Tugas membuat memecah ukuran file dengan memakai Splitter dan Join
 
 **/

package file_splitter_joinner;

import java.io.*;
public class File_splitter {

    
    public static void main(String[] args) {
         try{
            
            
            int y=0; 
            int x=1;
            byte bt[] = new byte[100];
            String f = "";
            InputStreamReader insr = new InputStreamReader(System.in);
            BufferedReader buf = new BufferedReader(insr);
            
            // Ketik alamat dan nama file yang ingin di split contohnya saja dalam file yang saya buat (c:\\Users\\USER\\Documents\\NetBeansProjects\\file_splitter_joinner\\gambar\\logo.png)
            System.out.println("Ketik alamat dan nama file yang ingin di split: ");
            String path = buf.readLine();
            
                FileInputStream in = new FileInputStream(path);
                int read_bytes;
                while(in.available()!=0){
                    y = 0;
                    f="";
                    if (x<=9) {
                        f = path+".00"+x;
                    }
                    else{
                        f = path+".0"+x;
                    }
                    FileOutputStream out = new FileOutputStream(f);
                    while(y<=90000 && in.available()!=0){
                        read_bytes = in.read(bt, 0 , 100);
                        y = y + read_bytes;
                        out.write(bt, 0 , read_bytes);
                    }
                    System.out.println("Bagian File "+x+ "  Berhasil Dibuat");
                    x++;
                }
                System.out.println("File Berhasil Di Split");
                in.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
