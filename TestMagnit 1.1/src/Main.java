
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by arsen on 10.11.2018.
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите login");
        String login = scan.next();
        System.out.println("Введите password");
        String password = scan.next();
        System.out.println("Введите число N");
        int number = scan.nextInt();
        System.out.println("Введено число " + number);
        SQLCon sqlConf = new SQLCon();
        sqlConf.setN(number);
        sqlConf.setLoginSQL(login);
        sqlConf.setPasswordSQL(password);
        new SQLCon(sqlConf.getUrl(), sqlConf.getLoginSQL(), sqlConf.getPasswordSQL(), sqlConf.getN());

    }
}
