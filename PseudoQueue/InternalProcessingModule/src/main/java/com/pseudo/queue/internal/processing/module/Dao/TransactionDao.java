package com.pseudo.queue.internal.processing.module.Dao;

import com.pseudo.queue.internal.processing.module.Configuration.MySQLConfiguration;
import com.pseudo.queue.internal.processing.module.Model.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class TransactionDao {

    @Autowired
    private MySQLConfiguration mySQLConfiguration;

    public void saveTransactionData(TransactionData transactionData) throws SQLException {
        Connection con = mySQLConfiguration.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Transaction_Data (Account_Number,Amount,Type,Currency,Account_From) VALUES (?,?,?,?,?)");

        preparedStatement.setString(1, transactionData.getAccountNumber());
        preparedStatement.setInt(2, transactionData.getAmount());
        preparedStatement.setString(3, transactionData.getType());
        preparedStatement.setString(4, transactionData.getCurrency());
        preparedStatement.setString(5, transactionData.getAccountFrom());

        preparedStatement.executeUpdate();
    }
}
