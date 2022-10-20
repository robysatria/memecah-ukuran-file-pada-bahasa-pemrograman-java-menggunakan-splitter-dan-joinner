/** 
 Nama           : Muhamad Roby Satria
 Kelas          : 2KA22
 NPM            : 10121766
 Mata Kuliah    : Struktur & Organisasi Data*
 Tugas membuat memecah ukuran file dengan memakai Splitter dan Join
 
 **/

package file_splitter_joinner;
import java.io.*;

public class File_Joinner {
    
    public static void main(String[] args) {
     try{
         byte bt[] = new byte[10000];
         InputStreamReader insr = new InputStreamReader(System.in);
         BufferedReader buf = new BufferedReader(insr);
         
         //Ketik alamat dan nama file bagian split yang pertama contohnya saja dalam file yang saya buat (c:\\Users\\USER\\Documents\\NetBeansProjects\\file_splitter_joinner\\gambar\\logo.png.001)
         System.out.println("Ketik alamat dan nama file bagian split yang pertama: ");
         String bagian_file = buf.readLine();
         String nama_file = bagian_file.substring(0, bagian_file.lastIndexOf("."));
         String file_extension = nama_file.substring(nama_file.lastIndexOf("."));
         String nomor_file = bagian_file.substring(bagian_file.lastIndexOf(".")+ 1);
        
         //Ketik alamat dan nama file baru yang sudah di join contohnya saja dalam file yang saya buat (c:\\Users\\USER\\Documents\\NetBeansProjects\\file_splitter_joinner\\gambar\\logo_join.png)
         System.out.println("Ketik alamat dan nama file baru yang sudah di join: ");
         String new_path = buf.readLine();
         
         File combine_file_path = new File(new_path);
         String path_parent = combine_file_path.getParent();
         
         int flag=0;
         if (new_path.endsWith(file_extension)) {
             flag=1;
         }
         File check_bagian_file = new File(bagian_file);
         File check_file_baru = new File(path_parent);
         
         if (check_bagian_file.exists() && flag==1 && check_file_baru.exists()) {
             FileOutputStream out = new FileOutputStream(new_path);
             
             int read_bytes;
             int x = 1;
             String bagian_nama_file = "";
             
             while(true){
                 bagian_nama_file ="";
                 
                 if (nomor_file.startsWith("00")) {
                     bagian_nama_file = nama_file + ".00" + x;
                     
                 }
                 else{
                     bagian_nama_file = nama_file + ".0" + x;
                 }
                 
                 File f = new File(bagian_nama_file);
                 
                 if (f.exists()) {
                      FileInputStream in = new FileInputStream(bagian_nama_file);
                      
                      while(in.available()!=0){
                          read_bytes = in.read(bt, 0, 10000);
                          out.write(bt, 0, read_bytes);
                      }
                      System.out.println("Bagian File " +x+ " Berhasil Join");
                      in.close();
                      x++;
                 }
                 else{
                     System.out.println("File Join Berhasil Dibuat");
                     break;
                 }
             }
         }
         else if(!(check_file_baru.exists())){
             System.out.println("Salah dalam menulis file baru");
         }
         else if(flag==0){
             System.out.println("Ekstension file baru tidak sesuai dengan ekstension yang ada di file bagian");
         }
         else{
             System.out.println("Bagian file pertama tidak ada");
         }
     }
     catch (Exception e){
         e.printStackTrace();
     }
     
    }
    
}
