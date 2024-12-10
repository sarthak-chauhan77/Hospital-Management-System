package Hospital.Management.System;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Dbutil {

    // Method to convert ResultSet to TableModel
    public static DefaultTableModel resultSetTableModel(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Create a table model
        DefaultTableModel tableModel = new DefaultTableModel();

        // Add column names to the table model
        for (int column = 1; column <= columnCount; column++) {
            tableModel.addColumn(metaData.getColumnName(column));
        }

        // Add rows to the table model
        while (resultSet.next()) {
            Object[] row = new Object[columnCount];
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                row[columnIndex - 1] = resultSet.getObject(columnIndex);
            }
            tableModel.addRow(row);
        }

        return tableModel;
    }
}
