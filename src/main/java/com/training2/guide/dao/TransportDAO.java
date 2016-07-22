package com.training2.guide.dao;

import com.training2.guide.models.Address;
import com.training2.guide.models.Transport;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.training2.guide.util.dao.constants.TransportDaoConstants.*;

/**
 * Created by Kirill on 20.07.2016.
 */
public class TransportDAO extends AbstractDao<Transport, Integer> {

    @Override
    public List<Transport> getListById(Integer addressId) {
        List<Transport> transportList = new ArrayList<>();
        List<Address> addressList = new ArrayList<>();
        Transport transport = new Transport();
        Address address = new Address();
        PreparedStatement preparedStatement = getPreparedStatement(GET_TRANSPORT_BY_ADDRESS_ID);
        try {
            preparedStatement.setInt(1, addressId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int transportId = resultSet.getInt("id");
                transport.setId(transportId);
                transport.setTransportType(resultSet.getString("transportType"));
                preparedStatement = getPreparedStatement(GET_ADDRESS_BY_TRANSPORT);
                preparedStatement.setInt(1, transportId);
                ResultSet addressResultSet = preparedStatement.executeQuery();
                while(addressResultSet.next()) {
                    address.setId(addressResultSet.getInt("id"));
                    address.setCity(addressResultSet.getString("city"));
                    address.setStreet(addressResultSet.getString("street"));
                    addressList.add(address);
                    address = new Address();
                }
                transport.setAddressList(addressList);
                transportList.add(transport);
                transport = new Transport();
                addressList = new ArrayList<>();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transportList;
    }

    @Override
    public Transport getById(Integer id) {
        return null;
    }
}



