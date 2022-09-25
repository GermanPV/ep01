package com.isil.jdbc;

import java.sql.*;

public class MainApp {
    public static void main(String[]args) throws Exception {
        String jdbcUrl = "jdbc:mysql://localhost:3306/practica";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");

        //Statement st = con.createStatement();
        //ResultSet rs = st.executeQuery("select * from Bebidas");
        //creando registro//
        //int filasAfectadas= st.executeUpdate("insert into Bebidas values(1,'Sprite','4444','Vancouver')");

        //editando//
        //int filasAfectadas= st.executeUpdate("update Bebidas set name='Redbull' where name='Maltin'");

        //eliminar//
        //int filasAfectadas= st.executeUpdate("delete from Bebidas where idUser=1");//


        //ahora con prepared //

        /*--PreparedStatement preparedStatement = con.prepareStatement("insert into Bebidas values(?,?,?,?)");
        preparedStatement.setInt(1, 8);
        preparedStatement.setString(2, "BigCola");
        preparedStatement.setString(3,"1234");
        preparedStatement.setString(4,"Mexico");

        int filasAfectadas= preparedStatement.executeUpdate();--*/
        //System.out.println("Filas afectadas: "+filasAfectadas);
    }

    public static void testCallableStatement(Connection connection) throws Exception{

        CallableStatement cs = connection.prepareCall("{call getAllUsers()}");
        ResultSet rs = cs.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("name") + " " +
                    rs.getString("phone") + " " +
                    rs.getString("country") + " " +
                    rs.getString("enable"));
        }

    }

}
