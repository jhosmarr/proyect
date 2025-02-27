

package modelo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Puesto {
    private int id_puesto;
    private String puesto;
    conexion cn;
    public Puesto(){}
    public Puesto(int id_puesto, String puesto) {
        this.id_puesto = id_puesto;
        this.puesto = puesto;
    }

    public int getId_puesto() {
        return id_puesto;
    }

    public void setId_puesto(int id_puesto) {
        this.id_puesto = id_puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public HashMap drop_puesto(){
        HashMap<String,String> drop = new HashMap();
        try{
            String query = "select id_puesto, puesto from puestos;";
            cn = new conexion();
            cn.abrir_conexion();
            ResultSet consulta = cn.conectar_db.createStatement().executeQuery(query);
            while(consulta.next()){
                drop.put(consulta.getString("id_puesto"), consulta.getString("puesto"));
            }
            cn.cerrar_conexion();
        }catch(SQLException ex){
            System.out.println("Error drop_puesto: "+ ex.getMessage());
        }
        return drop;
    }
}
