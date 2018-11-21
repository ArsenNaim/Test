

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.*;

public class SQLCon {
    private final String url = "jdbc:mysql://localhost:3306/test";
    private String loginSQL;
    private String passwordSQL;
    private int n;

    //--------------------------------------------------------------------------------------------------------------
    public SQLCon() {

    }

    public SQLCon(String url, String loginSQL, String passwordSQL, int n) throws ClassNotFoundException {
        Class.forName("org.gjt.mm.mysql.Driver");
        try (Connection con = DriverManager.getConnection(url, loginSQL, passwordSQL)) {
            System.out.println("we're connected");
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT 1 from test");
            ;
            if (resultSet != null) {
                statement.executeUpdate("TRUNCATE table test");
            }
            int scetchik = 0;
            int y = 0;
            int a = n % 50;
            System.out.println(a);
            int b = (n - a) / 50;
            System.out.println("Задачка");
            while (scetchik != b) {
                statement.executeUpdate("INSERT INTO test VALUES (DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT),(DEFAULT)");
                System.out.println("Разбивка по 50----" + scetchik);
                scetchik++;
            }
            while (y != a) {
                statement.executeUpdate("INSERT INTO test VALUES (DEFAULT )");
                System.out.println("Разбивка по единицам----" + scetchik);
                y++;
            }
            resultSet = statement.executeQuery("SELECT FIELD FROM test");
            DocFactory docFactory = new DocFactory();
            Document document = docFactory.Doc(resultSet);
            TransformFactory transformFactory = new TransformFactory();
            long finalResult = transformFactory.transFactory(document);

            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println("Арифметическия сумма значений всех атрибутов  " + finalResult);
            con.close();
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Введен не верный логин или пароль к базе");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
//--------------------------------------------------------------------------------------------------------------


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public String getUrl() {
        return url;
    }

    public String getLoginSQL() {
        return loginSQL;
    }

    public void setLoginSQL(String loginSQL) {
        this.loginSQL = loginSQL;
    }

    public String getPasswordSQL() {
        return passwordSQL;
    }

    public void setPasswordSQL(String passwordSQL) {
        this.passwordSQL = passwordSQL;
    }
}
