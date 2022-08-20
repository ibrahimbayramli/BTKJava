import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement =null;
        ResultSet resultSet;

        try {
            connection=dbHelper.getConnection();
            statement=connection.prepareStatement("INSERT INTO city (city_id,city,country_id,last_update) " +
                    "VALUES (601,'Kocaeli',110,'2006-02-15 09:45:25.000000')");
            statement.executeUpdate("INSERT INTO city (city_id,city,country_id,last_update) " +
                    "VALUES (601,'Kocaeli',110,'2006-02-15 09:45:25.000000')");
            System.out.println("Guncellendi");


        }catch (SQLException e){
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }


    }
    public static void selectDemo() throws SQLException{
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement =null;
        ResultSet resultSet;

        try {
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM city WHERE city_id>=450");
            ArrayList<City> cities=new ArrayList<City>();

            while (resultSet.next()){
                cities.add(new City(resultSet.getString("city_id"),
                        resultSet.getString("city"),
                        resultSet.getString("country_id"),
                        resultSet.getString("last_update")));
            }
            System.out.println(cities.size());
        }catch (SQLException e){
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }
    }
}