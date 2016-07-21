package com.training2.guide.models;

import java.util.List;

/**
 * Created by Kirill on 20.07.2016.
 */
public class Route {

        private Address address;
        private List<Address> neighborAddresses;
        private List<Integer> distanceList;

        public Address getAddress() {
                return address;
        }

        public void setAddress(Address address) {
                this.address = address;
        }

        public List<Address> getNeighborAddresses() {
                return neighborAddresses;
        }

        public void setNeighborAddresses(List<Address> neighborAddresses) {
                this.neighborAddresses = neighborAddresses;
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
                        "address=" + address +
                        ", neighbor Addresses=" + neighborAddresses +
                        ", distanceList=" + distanceList;
        }
}
