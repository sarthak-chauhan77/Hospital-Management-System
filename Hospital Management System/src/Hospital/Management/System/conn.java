package Hospital.Management.System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection connection;
    Statement statement;

    public conn() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOSPITAL_MANAGEMENT_SYSTEM", "root",
                    "business@12377#*SK");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
