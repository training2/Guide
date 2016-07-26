/**
 * This class inserts data in database
 * @author Kirill Bugrim on 20.07.2016.
 * version 1.1
 */

package com.training2.guide.util;
import com.training2.guide.dao.jdbc.mysql.*;

public class InitDB {

    public static void init(){
        new CityDao().create();
        new PassangerDao().create();
        new StationDAO().create();
        new PassangerPathDao().createPath();
        new TransportDAO().create();
        new PassangerPathDao().initTransportRoute();
        new NeighborStationDAO().create();
        new RouteDAO().create();
    }
}
