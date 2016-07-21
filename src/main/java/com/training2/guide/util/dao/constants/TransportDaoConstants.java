package com.training2.guide.util.dao.constants;

public interface TransportDaoConstants {

    String GET_TRANSPORT_BY_ADDRESS_ID = "select t.id, t.transportType from transport t inner join transport_address ta on (t.id = ta.transport_id)" +
            "inner join address a on (a.id = ta.address_id) where (a.id = ?)";
    String GET_ADDRESS_BY_TRANSPORT = "select a.id, a.city, a.street, t.id as 'transport_id' from transport t inner join transport_address ta on (t.id = ta.transport_id)\n" +
            "inner join address a on (a.id = ta.address_id) where (t.id = ?)";
}
