import java.sql.*;
import java.util.Scanner;

public class miprimerDelete {
    static final String DB_URL = "jdbc:mysql://localhost/POOJAVA";
    static final String USER = "root";
    static final String PASS = "root_bas3";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);) {

            // Operacion Select
            String Query_sql_select = "SELECT * FROM estudiantes";
            try (PreparedStatement pstmt = conn.prepareStatement(Query_sql_select)){
                try (ResultSet rs = pstmt.executeQuery()){
                    while (rs.next()){
                        System.out.println("id_estudiante:" + rs.getInt("id_estudiante"));
                        System.out.println("nombre:"+ rs.getString("nombre"));
                        System.out.println("edad:"+rs.getInt("edad"));
                        System.out.println("ciudad:"+rs.getString("ciudad"));
                        System.out.println("cedula:"+rs.getInt("cedula"));
                    }
                }
            }
            /*
            // Operacion delete
            System.out.println("Ingrese el ID del estudainite que desee eliminar");
            int eliminarID_estudiante = input.nextInt();

            String Query_sql = "DELETE FROM estudiantes WHERE id_estudiante = ?";
              try(PreparedStatement pstmt = conn.prepareStatement(Query_sql)){
                  pstmt.setInt(1,eliminarID_estudiante);
                  int filasEliminadas = pstmt.executeUpdate();
                  if (filasEliminadas > 0){
                      System.out.println("Estudiante eliminado correctamente !");
                  } else {
                      System.out.println("No se encontro ningun estudiante con ese ID");
                  }
              }
            */
              // Operacion Insert
            System.out.println("Inserte los siguientes datos:");
            System.out.println("Nombre:");
            String nombre = input.next();
            System.out.println("edad:");
            int edad = input.nextInt();
            System.out.println("Ciudad:");
            String ciudad = input.next();
            System.out.println("Cedula:");
            int cedula = input.nextInt();
            System.out.println("Contraseña:");
            String contrasena = input.next();

            String Sql_query_insert = "INSERT INTO estudiantes (nombre,edad,ciudad,cedula,contrasena) VALUES (?,?,?,?,?)";
            try (PreparedStatement pstmt = conn.prepareStatement(Sql_query_insert)){
                pstmt.setString(1,nombre);
                pstmt.setInt(2,edad);
                pstmt.setString(3,ciudad);
                pstmt.setInt(4,cedula);
                pstmt.setString(5,contrasena);

                int filasInsertadas = pstmt.executeUpdate();
                if (filasInsertadas > 0){
                    System.out.println("Estudiante insertado correctamente !");
                } else {
                    System.out.println("No se pudo insertar el estudiante");
                }
            }

            // Operacion Update

            System.out.println("Datos a actualizar");
            System.out.println("Nuevo nombre:");
            String nuevo_nombre = input.next();
            System.out.println("Nueva edad:");
            int nueva_edad = input.nextInt();
            System.out.println("Nueva Ciudad:");
            String nueva_ciudad = input.next();
            System.out.println("Nueva cedula:");
            int nueva_cedula = input.nextInt();
            System.out.println("Nueva contraseña:");
            String nueva_contrasena = input.next();
            System.out.println("Ingrese el ID del estudainite que desee eliminar");
            int eliminarID_estudiante_2 = input.nextInt();

            String sqlUpdate = "UPDATE estudiantes SET nombre=?, edad=?, ciudad=?, cedula=?, contrasena=? WHERE id_estudiante=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
                pstmt.setString(1, nuevo_nombre);
                pstmt.setInt(2, nueva_edad);
                pstmt.setString(3, nueva_ciudad);
                pstmt.setInt(4, nueva_cedula);
                pstmt.setString(5, nueva_contrasena);
                pstmt.setInt(6,eliminarID_estudiante_2);

                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Estudiante actualizado correctamente !");
                } else {
                    System.out.println("No se pudo actualizar el estudiante");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
