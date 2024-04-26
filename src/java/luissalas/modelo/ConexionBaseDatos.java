/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luissalas.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author luisf
 */
public class ConexionBaseDatos {
    
    private String driver="com.mysql.jdbc.Driver";
    private String nombreIPServidorBD="localhost";
    private String url="jdbc:mysql://";
    private int puertoServidorBD= 3306;
    private String usuarioBD="root";
    private String passwordUsuarioBD="";
    private String nombreBD="bd_sistemas_distribuidos";
    private Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet filasConsulta;
    
    
    
    public ConexionBaseDatos() throws Exception{
        url= url+nombreIPServidorBD+":"+puertoServidorBD+"/"+nombreBD;
        this.conectar();
    }
    
    public ConexionBaseDatos(String driver, String servidor, String url, String usuarioBD, String passwordUsuarioBD, String nombreBD)throws Exception{
        
        this.driver =driver;
        this.nombreIPServidorBD= servidor;
        this.url= url;
        this.usuarioBD=usuarioBD;
        this.passwordUsuarioBD= passwordUsuarioBD;
        this.nombreBD= nombreBD;
        this.conectar();
     
    }
    
    public void conectar()throws Exception{
        
        try {
            Class.forName(getDriver());
        } catch (ClassNotFoundException e) {
            throw new Exception("Error de Driver"+ e.getMessage());
        }
        try {
            setConexion(DriverManager.getConnection(getUrl(), getUsuarioBD(), getPasswordUsuarioBD()));
        } catch (SQLException e) {
            throw new Exception("Error de conexion \n codigo: "+e.getErrorCode()+" Explicacion: "+e.getMessage());
        }
    }
    
    public int actualizar(PreparedStatement sentencia)throws Exception{
        try{
            int res= sentencia.executeUpdate();
            return res;
        } catch(SQLException e){
            throw new SQLException("Error al ejecutar la sentencia BD Conexion \n Codigo: "+e.getErrorCode()+" Explicacion: "+e.getMessage());
        }
    }
    
    public ResultSet consultar(PreparedStatement sentencia) throws Exception{
        try{
            ResultSet filasBD = sentencia.executeQuery();
            return filasBD;
        }catch(SQLException e){
            throw new SQLException("Error al ejecutar la sentencia BD Conexion"+ e.getMessage());
        }
        
    }
    
    public void desconectar(){
        try{
            getConexion().close();
        } catch (SQLException ex){
            setConexion(null);
        }
    }
    
    public PreparedStatement crearSentencia(String sql) throws Exception{
        try{
            PreparedStatement sentencia = getConexion().prepareStatement(sql);
            return sentencia;
        }catch(SQLException e){
            throw new SQLException("Error al ejecutar la sentencia BD Conexion \n Codigo: "+e.getErrorCode()+" Explicacion: "+e.getMessage());
        }
    }

    
    public String getDriver() {
        return driver;
    }
    public void setDriver(String driver) {
        this.driver = driver;
    }


    public String getNombreIPServidorBD() {
        return nombreIPServidorBD;
    }
    public void setNombreIPServidorBD(String nombreIPServidorBD) {
        this.nombreIPServidorBD = nombreIPServidorBD;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public int getPuertoServidorBD() {
        return puertoServidorBD;
    }
    public void setPuertoServidorBD(int puertoServidorBD) {
        this.puertoServidorBD = puertoServidorBD;
    }

    public String getUsuarioBD() {
        return usuarioBD;
    }
    public void setUsuarioBD(String usuarioBD) {
        this.usuarioBD = usuarioBD;
    }

    public String getPasswordUsuarioBD() {
        return passwordUsuarioBD;
    }
    public void setPasswordUsuarioBD(String passwordUsuarioBD) {
        this.passwordUsuarioBD = passwordUsuarioBD;
    }

    public String getNombreBD() {
        return nombreBD;
    }
    public void setNombreBD(String nombreBD) {
        this.nombreBD = nombreBD;
    }

    public Connection getConexion() {
        return conexion;
    }
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement getSentencia() {
        return sentencia;
    }
    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }

    public ResultSet getFilasConsulta() {
        return filasConsulta;
    }
    public void setFilasConsulta(ResultSet filasConsulta) {
        this.filasConsulta = filasConsulta;
    }
    
    
}
