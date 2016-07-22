package com.training2.guide.dao;

import com.training2.guide.models.Address;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static com.training2.guide.util.dao.constants.AddressDaoConstants.*;

/**
 * Created by Kirill on 20.07.2016.
 */
public class AddressDAO extends AbstractDao<Address, Integer> {

    public AddressDAO() {

    }

    @Override
     public Address getById(Integer adr) {
        Address address = new Address();
        PreparedStatement preparedStatement = getPreparedStatement(GET_ALL_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, adr);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                address.setId(result.getInt("id"));
                address.setCity(result.getString("city"));
                address.setStreet(result.getString("street"));
            }
            if (preparedStatement !=null) preparedStatement.close();
            if (result!=null) result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public List<Address> getListById(Integer id) {
        return null;
    }
}

