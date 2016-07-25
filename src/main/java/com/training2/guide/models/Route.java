/**
 * This class Route
 * @author Kirill Bugrim on 20.07.2016.
 * @version 1.1
 */

package com.training2.guide.models;
import java.util.List;

public class Route {

        private Station station;
        private List<NeighborStation> neighborStationList;

        public Route() {
        }

        public Station getStation() {
                return station;
        }

        public void setStation(Station station) {
                this.station = station;
        }

        public List<NeighborStation> getNeighborStationList() {
                return neighborStationList;
        }

        public void setNeighborStationList(List<NeighborStation> neighborStationList) {
                this.neighborStationList = neighborStationList;
        }
}
