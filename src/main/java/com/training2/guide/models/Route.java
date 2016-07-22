package com.training2.guide.models;

import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class Route {

        private Station station;
        private List<Station> neighborStations;
        private List<Integer> distanceList;

        public Station getStation() {
                return station;
        }

        public void setStation(Station station) {
                this.station = station;
        }

        public List<Station> getNeighborStations() {
                return neighborStations;
        }

        public void setNeighborStations(List<Station> neighborStations) {
                this.neighborStations = neighborStations;
        }

        public List<Integer> getDistanceList() {
                return distanceList;
        }

        public void setDistanceList(List<Integer> distanceList) {
                this.distanceList = distanceList;
        }

        @Override
        public String toString() {
                return "Route: " +
                        "station=" + station +
                        ", neighbor Addresses=" + neighborStations +
                        ", distanceList=" + distanceList;
        }
}
