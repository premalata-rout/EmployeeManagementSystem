package Service;

import Entity.Employe;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Service {

    private static Connection con;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded!!!");

            //2nde step
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school",
                    "postgres", "123");

            System.out.println("Connection established!!!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int save(Employe employe) {

        int res = 0;

        String sql = "INSERT INTO employe values(?,?,?,?)";

        try {
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, employe.getId());
            pstm.setString(2, employe.getName());
            pstm.setInt(3, employe.getAge());
            pstm.setInt(4, employe.getSalary());

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }


    // UPDATE

    public int update(Employe employe) {

        int res = 0;

        String sql = "UPDATE employe SET name=?, age=?, salary=? WHERE id=?";

        try {

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, employe.getName());
            pstm.setInt(2, employe.getAge());
            pstm.setInt(3, employe.getSalary());
            pstm.setInt(4, employe.getId());

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }


    // DELETE

    public int delete(int id) {

        int res = 0;

        String sql = "DELETE FROM employe WHERE id=?";

        try {

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, id);

            res = pstm.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }


    public List<Employe> fetchall() {

        String sql = "SELECT * from employe";

        List<Employe> employes = new ArrayList<>();

        try {
            Statement stm = con.createStatement();

            java.sql.ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                // int id=rs.getInt(1);

                employes.add(
                        new Employe(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getInt(3),
                                rs.getInt(4)
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employes;
    }
}