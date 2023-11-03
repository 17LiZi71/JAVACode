package RentCar.vehicle;

    public abstract class Vehicle {
        private String vehicleId;
        private String brand;
        private int perRent;
        private String type;
        public Vehicle() {
        }

        public Vehicle(String vehicleId, String brand, int perRent,String type) {
            this.vehicleId = vehicleId;
            this.brand = brand;
            this.perRent = perRent;
            this.type = type;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getPerRent() {
            return perRent;
        }

        public void setPerRent(int perRent) {
            this.perRent = perRent;
        }

        @Override
        public String toString() {
            return "Vehicle [vehicleId=" + vehicleId + ", brand=" + brand + ", perRent=" + perRent + "]";
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

