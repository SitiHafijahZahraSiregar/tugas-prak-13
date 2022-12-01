package jdbc.project;

import Db.DBHelper;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MahasiswaModel {
    private final Connection CONN;
    
    public MahasiswaModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addMahasiswa(Mahasiswa mhs){
         String insert = "INSERT INTO mhs VALUES ('"
                 + mhs.getNpm() + "', '" + mhs.getNama()
                 + "');";
         
        try { 
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil Memasukkan Data");
            } else {
                System.out.println("Gagal Memasukan Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Memasukkan Data ");
        }
    }
    
         public void deleteMahasiswa(Mahasiswa mhs){
        String delete = "DELETE FROM mhs WHERE npm = '"
                 + mhs.getNpm() + "';"; 
        
        try { 
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil Menghapus Data");
            } else {
                System.out.println("Gagal Menghapus Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Menghapus Data ");
        }
    }
    
        public void updateMahasiswa(Mahasiswa mhs, Mahasiswa mhs1){
        String update = "UPDATE mhs SET npm = '" + mhs.getNpm() + "', nama = '" + mhs.getNama() + "' WHERE npm = '" + mhs1.getNpm() + "';";
        
        try { 
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil Mengupdate Data");
            } else {
                System.out.println("Gagal Mengupdate Data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengupdate Data ");
        }
    }
    
    public ArrayList<Mahasiswa> getMahasiswa(){
        String query = "SELECT * FROM mhs"; 
        ArrayList<Mahasiswa> mhs  = new ArrayList<Mahasiswa>();
        
        try { 
             ResultSet rs = CONN.createStatement().executeQuery(query);
            while(rs.next()){
                Mahasiswa temp = new Mahasiswa(rs.getString("npm"), rs.getString("nama"));
                mhs.add(temp);
            }
            System.out.println("Berhasil Mengambil Data");
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal Mengambil Data");
        }
        
        return mhs;
        
    }
    
}
