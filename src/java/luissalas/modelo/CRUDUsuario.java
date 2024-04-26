/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package luissalas.modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author luisf
 */
public class CRUDUsuario {

    private Usuario alguien;
    private ConexionBaseDatos baseDatos;

    public void agregarUsuario() throws Exception {
        if (getAlguien().getId() == null || getAlguien().getId().isEmpty()) {
            throw new Exception("El ID del Usuario es Necesario");
        }
        String sqlInsert = "INSERT INTO Usuarios "
                + "(id, password, nombre, apellido, email, tipo) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement sentenciaSQL = getBaseDatos().crearSentencia(sqlInsert);
            sentenciaSQL.setString(1, getAlguien().getId());
            sentenciaSQL.setString(2, getAlguien().getPassword());
            sentenciaSQL.setString(3, getAlguien().getNombre());
            sentenciaSQL.setString(4, getAlguien().getApellido());
            sentenciaSQL.setString(5, getAlguien().getEmail());
            sentenciaSQL.setString(6, getAlguien().getTipo());
            getBaseDatos().actualizar(sentenciaSQL);
        } catch (Exception error) {
            throw new Exception("Error al Agregar el Usuario " + getAlguien().getId()
                    + "<br/>Explicacion: " + error.getMessage());
        } finally {
            getBaseDatos().desconectar();
        }
    }

    public void modificarUsuario() throws Exception {
        if (getAlguien().getId() == null || getAlguien().getId().isEmpty()) {
            throw new Exception("El ID del Usuario es Necesario");
        }
        String sqlUpdate = "UPDATE Usuarios "
                + "(id, password, nombre, apellido, email, tipo) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement sentenciaSQL = getBaseDatos().crearSentencia(sqlUpdate);
            sentenciaSQL.setString(1, getAlguien().getId());
            sentenciaSQL.setString(2, getAlguien().getPassword());
            sentenciaSQL.setString(3, getAlguien().getNombre());
            sentenciaSQL.setString(4, getAlguien().getApellido());
            sentenciaSQL.setString(5, getAlguien().getEmail());
            sentenciaSQL.setString(6, getAlguien().getTipo());
            getBaseDatos().actualizar(sentenciaSQL);
        } catch (Exception error) {
            throw new Exception("Error al Actualizar el Usuario " + getAlguien().getId()
                    + "<br/>Explicacion: " + error.getMessage());
        } finally {
            getBaseDatos().desconectar();
        }
    }

    public void eliminarUsuario() throws Exception {
        if (getAlguien().getId() == null || getAlguien().getId().isEmpty()) {
            throw new Exception("El ID del Usuario es Necesario");
        }
        String sqlDelete = "DELETE FROM Usuarios "
                + "WHERE id=?";
        try {
            PreparedStatement sentenciaSQL = getBaseDatos().crearSentencia(sqlDelete);
            sentenciaSQL.setString(1, getAlguien().getId());
            getBaseDatos().actualizar(sentenciaSQL);
        } catch (Exception error) {
            throw new Exception("Error al Eliminar el Usuario " + getAlguien().getId()
                    + "<br/>Explicacion: " + error.getMessage());
        } finally {
            getBaseDatos().desconectar();
        }
    }

    public static Usuario iniciarSesion(String id, String password) throws Exception {
        if (id == null || password == null || password.isEmpty()) {
            throw new Exception("El ID del Usuario es Necesario");
        }
        Usuario alguien;
        ConexionBaseDatos baseDatos = null;

        String sqlSelect = "SELECT * FROM Usuarios "
                + "WHERE id=? and password=?";

        try {
            baseDatos = new ConexionBaseDatos();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia(sqlSelect);
            sentenciaSQL.setString(1, id);
            sentenciaSQL.setString(2, password);
            ResultSet resultado = baseDatos.consultar(sentenciaSQL);
            if (resultado.next() == true) {
                alguien = new Usuario();
                alguien.setId(resultado.getString("id"));
                alguien.setPassword(resultado.getString("password"));
                alguien.setNombre(resultado.getString("nombre"));
                alguien.setApellido(resultado.getString("apellido"));
                alguien.setEmail(resultado.getString("email"));
                alguien.setTipo(resultado.getString("tipo"));
                return alguien;
            } else {
                throw new Exception("Error al consultar el Usuario " + id
                        + "<br/>Explicacion: ");
            }
        } catch (Exception error) {
            throw new Exception("Error en el ID o el Password estan Errados");
        } finally {
            if (baseDatos != null) {
                baseDatos.desconectar();
            }

        }
    }

    public static Usuario consultarUsuario(String id) throws Exception {
        if (id == null || id.isEmpty()) {
            throw new Exception("El ID del Usuario es Necesario");
        }
        Usuario alguien;
        ConexionBaseDatos baseDatos = null;

        String sqlSelect = "SELECT * FROM Usuarios "
                + "WHERE id=?";

        try {
            baseDatos = new ConexionBaseDatos();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia(sqlSelect);
            sentenciaSQL.setString(1, id);
            ResultSet resultado = baseDatos.consultar(sentenciaSQL);
            if (resultado.next() == true) {
                alguien = new Usuario();
                alguien.setId(resultado.getString("id"));
                alguien.setPassword(resultado.getString("password"));
                alguien.setNombre(resultado.getString("nombre"));
                alguien.setApellido(resultado.getString("apellido"));
                alguien.setEmail(resultado.getString("email"));
                alguien.setTipo(resultado.getString("tipo"));
                return alguien;
            } else {
                throw new Exception("Error al consultar el Usuario " + id
                        + "<br/>Explicacion: ");
            }
        } catch (Exception error) {
            throw new Exception("El usuario no existe en la BD");
        } finally {
            if (baseDatos != null) {
                baseDatos.desconectar();
            }

        }
    }

    public static Usuario[] listarTodosLosUsuarios() throws Exception {
        Usuario alguien;
        ConexionBaseDatos baseDatos = null;

        try {

            String sqlSelect = "SELECT * FROM Usuarios ";

            baseDatos = new ConexionBaseDatos();
            PreparedStatement sentenciaSQL = baseDatos.crearSentencia(sqlSelect);
            ResultSet resultado = baseDatos.consultar(sentenciaSQL);
            Usuario[] listado = new Usuario[resultado.getRow()];
            resultado.beforeFirst();
            while (resultado.next() == true) {
                alguien = new Usuario();
                alguien.setId(resultado.getString("id"));
                alguien.setPassword(resultado.getString("password"));
                alguien.setNombre(resultado.getString("nombre"));
                alguien.setApellido(resultado.getString("apellido"));
                alguien.setEmail(resultado.getString("email"));
                alguien.setTipo(resultado.getString("tipo"));
                listado[resultado.getRow()] = alguien;
            }
            if (listado.length <= 0) {
                throw new Exception("Error al Listar los Usuarios "
                        + "<br/>Explicacion: ");
            }
            return listado;
        } catch (Exception error) {
            throw new Exception("La BD esta vacia");
        } finally {
            if (baseDatos != null) {
                baseDatos.desconectar();
            }
        }

    }

    /**
     * @return the alguien
     */
    public Usuario getAlguien() {
        return alguien;
    }

    /**
     * @param alguien the alguien to set
     */
    public void setAlguien(Usuario alguien) {
        this.alguien = alguien;
    }

    /**
     * @return the baseDatos
     */
    public ConexionBaseDatos getBaseDatos() {
        return baseDatos;
    }

    /**
     * @param baseDatos the baseDatos to set
     */
    public void setBaseDatos(ConexionBaseDatos baseDatos) {
        this.baseDatos = baseDatos;
    }
    
    


}