package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        //USER CREATION
        User user1 = new User("Chack", "Norris", (byte) 45);
        User user2 = new User("Jack", "Nicolson", (byte) 50);
        User user3 = new User("Jan", "Vandam", (byte) 55);
        User user4 = new User("Bruce", "Lee", (byte) 30);
        //Users Data creation
        String user1Name = "Chack";
        String user1secondName = "Norris";
        Byte user1Age = 45;

        String user2Name = "Jack";
        String user2secondName = "Nicolson";
        Byte user2Age = 50;

        String user3Name = "Jan";
        String user3secondName = "Vandam";
        Byte user3Age = 55;

        String user4Name = "Bruce";
        String user4secondName = "Lee";
        Byte user4Age = 30;


        try {
            Statement statement = util.getConnection().createStatement();
            // TABLE CREATION
            statement.execute("CREATE TABLE if not exists katausers (id int not null AUTO_INCREMENT, " +
                    "name varchar(40), " +
                    "secondName varchar(40), " +
                    "age int, " +
                    "primary key (id))");

            // Users adding v1
/*            statement.execute("insert into katausers (name, secondName, age) values ('Chack', 'Norris', '45')");
            System.out.println("User с именем Chack добавлен в базу данных");
            statement.execute("insert into katausers (name, secondName, age) values ('Jack', 'Nicolson', '50')");
            System.out.println("User с именем Jack добавлен в базу данных");
            statement.execute("insert into katausers (name, secondName, age) values ('Jan', 'Vandam', '55')");
            System.out.println("User с именем Jan добавлен в базу данных");
            statement.execute("insert into katausers (name, secondName, age) values ('Bruce', 'Lee', '30')");
            System.out.println("User с именем Bruce добавлен в базу данных");
            System.out.println("---------------------------------------------------------------");*/

            // Users adding v2
/*            statement.execute("insert into katausers (name, secondName, age) values ('" + user1.getName() + "', '" + user1.getLastName() + "', '" + user1.getAge() + "')");
            System.out.printf("User с именем - добавлен в базу данных\n", user1.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user2.getName() + "', '" + user2.getLastName() + "', '" + user2.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user2.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user3.getName() + "', '" + user3.getLastName() + "', '" + user3.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user3.getName());
            statement.execute("insert into katausers (name, secondName, age) values ('" + user4.getName() + "', '" + user4.getLastName() + "', '" + user4.getAge() + "')");
            System.out.printf("User с именем %s добавлен в базу данных\n", user4.getName());
            System.out.println("---------------------------------------------------------------");*/


            // Users adding usibg preparedStatement
            PreparedStatement preparedStatement1 = util.getConnection().prepareStatement("insert into katausers values (?,?,?,?)");
            preparedStatement1.setInt(1,1);
            preparedStatement1.setString(2, user1.getName());
            preparedStatement1.setString(3, user1.getLastName());
            preparedStatement1.setInt(4, user1.getAge());
            preparedStatement1.execute();
            System.out.printf("User с именем %s добавлен в базу данных\n", user1.getName());

            PreparedStatement preparedStatement2 = util.getConnection().prepareStatement("insert into katausers values (?,?,?,?)");
            preparedStatement2.setInt(1,2);
            preparedStatement2.setString(2, user2.getName());
            preparedStatement2.setString(3, user2.getLastName());
            preparedStatement2.setInt(4, user2.getAge());
            preparedStatement2.execute();
            System.out.printf("User с именем %s добавлен в базу данных\n", user2.getName());

            PreparedStatement preparedStatement3 = util.getConnection().prepareStatement("insert into katausers values (?,?,?,?)");
            preparedStatement3.setInt(1,3);
            preparedStatement3.setString(2, user3.getName());
            preparedStatement3.setString(3, user3.getLastName());
            preparedStatement3.setInt(4, user3.getAge());
            preparedStatement3.execute();
            System.out.printf("User с именем %s добавлен в базу данных\n", user3.getName());

            PreparedStatement preparedStatement4 = util.getConnection().prepareStatement("insert into katausers values (?,?,?,?)");
            preparedStatement4.setInt(1,4);
            preparedStatement4.setString(2, user4.getName());
            preparedStatement4.setString(3, user4.getLastName());
            preparedStatement4.setInt(4, user4.getAge());
            preparedStatement4.execute();
            System.out.printf("User с именем %s добавлен в базу данных\n", user4.getName());
            System.out.println("---------------------------------------------------------------");


            // User1 extract from DB
            ResultSet resultSet1 = statement.executeQuery("select * from katausers where id = 1");
            resultSet1.next();
            user1.setId(resultSet1.getLong("ID"));
            user1.setName(resultSet1.getString("name"));
            user1.setLastName(resultSet1.getString("secondName"));
            user1.setAge((byte)resultSet1.getInt("age"));
            System.out.println(user1);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet2 = statement.executeQuery("select * from katausers where id = 2");
            resultSet2.next();
            user2.setId(resultSet2.getLong("ID"));
            user2.setName(resultSet2.getString("name"));
            user2.setLastName(resultSet2.getString("secondName"));
            user2.setAge((byte)resultSet2.getInt("age"));
            System.out.println(user2);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet3 = statement.executeQuery("select * from katausers where id = 3");
            resultSet3.next();
            user3.setId(resultSet3.getLong("ID"));
            user3.setName(resultSet3.getString("name"));
            user3.setLastName(resultSet3.getString("secondName"));
            user3.setAge((byte)resultSet3.getInt("age"));
            System.out.println(user3);
            System.out.println("---------------------------------------------------------------");

            // User2 extract from DB
            ResultSet resultSet4 = statement.executeQuery("select * from katausers where id = 4");
            resultSet4.next();
            user4.setId(resultSet4.getLong("ID"));
            user4.setName(resultSet4.getString("name"));
            user4.setLastName(resultSet4.getString("secondName"));
            user4.setAge((byte)resultSet4.getInt("age"));
            System.out.println(user4);
            System.out.println("---------------------------------------------------------------");


            //Extract all users from DB
            ResultSet resultSet = statement.executeQuery("select * from katausers");
            while ((resultSet.next())) {
                User user = new User();
                user.setId(resultSet.getLong("ID"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("secondName"));
                user.setAge((byte)resultSet.getInt("age"));
                System.out.println(user);
            }
            System.out.println("---------------------------------------------------------------");

            /*// Specified user extract from DB
            ResultSet resultSetIndifidual = statement.executeQuery("select * from katausers where id = 1");
            resultSetIndifidual.next();
            user1.setId(resultSetIndifidual.getLong("ID"));
            user1.setName(resultSetIndifidual.getString("name"));
            user1.setLastName(resultSetIndifidual.getString("secondName"));
            user1.setAge((byte)resultSetIndifidual.getInt("age"));
            System.out.println(user1);
            System.out.println("---------------------------------------------------------------");*/


            //  userLIST extract from DB
            ResultSet resultSettoList = statement.executeQuery("select * from katausers");
            while (resultSettoList.next()) {
                User user = new User();
                List<User> userList = new ArrayList<>();
                userList.add(new User(resultSettoList.getString("name"), resultSettoList.getString("secondName"),
                        (byte)resultSettoList.getInt("age")));
                for (User list : userList) {
                    System.out.println(list);
                }
            }
            System.out.println("---------------------------------------------------------------");


            //Delete user with ID
            statement.execute("delete from katausers where id=1");



            // Table clean
            statement.execute("TRUNCATE TABLE katausers");

            //Table delete
            statement.execute("DROP TABLE katausers");














        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
