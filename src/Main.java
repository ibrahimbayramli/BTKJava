import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement =null;
        ResultSet resultSet;

        try {
            String sql="DELETE FROM city WHERE city_id>601";
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Silindi.");


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
        public static void insertDemo() throws SQLException {
            Connection connection=null;
            DbHelper dbHelper=new DbHelper();
            Statement statement =null;
            ResultSet resultSet;

            try {
                String sql="INSERT INTO city (city,country_id,last_update) " +
                        "VALUES ('Kocaeli',109,'2006-02-15 09:45:25.000000')";
                connection=dbHelper.getConnection();
                statement=connection.createStatement();
                statement.executeUpdate(sql);

                System.out.println("Eklendi.");


            }catch (SQLException e){
                dbHelper.showErrorMessage(e);
            }
            finally {
                connection.close();
            }


        }




        public static void updateDemo() throws SQLException {
            Connection connection = null;
            DbHelper dbHelper = new DbHelper();
            Statement statement = null;
            ResultSet resultSet;

            try {
                String sql = "UPDATE city SET city = 'Kocaeli guncel' WHERE city_id=603";
                connection = dbHelper.getConnection();
                statement = connection.createStatement();
                statement.executeUpdate(sql);

                System.out.println("Guncellendi.");


            } catch (SQLException e) {
                dbHelper.showErrorMessage(e);
            } finally {
                connection.close();
            }

        }

    public static void deleteDemo() throws SQLException {
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement =null;
        ResultSet resultSet;

        try {
            String sql="DELETE FROM city WHERE city_id>601";
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            statement.executeUpdate(sql);

            System.out.println("Silindi.");


        }catch (SQLException e){
            dbHelper.showErrorMessage(e);
        }
        finally {
            connection.close();
        }


    }

}