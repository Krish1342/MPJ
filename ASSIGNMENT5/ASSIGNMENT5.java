package HelloWorld;

class HillStations {
    public void famousFood() {
        System.out.println("Different hill stations are famous for different foods.");
    }

    public void famousFor() {
        System.out.println("Hill stations are famous for natural beauty and climate.");
    }
}

class Manali extends HillStations {
    @Override
    public void famousFood() {
        System.out.println("Manali famous food: Siddu and Trout Fish.");
    }

    @Override
    public void famousFor() {
        System.out.println("Manali is famous for snow mountains and Solang Valley.");
    }
}

class Mussoorie extends HillStations {
    @Override
    public void famousFood() {
        System.out.println("Mussoorie famous food: Momos and Aloo ke Gutke.");
    }

    @Override
    public void famousFor() {
        System.out.println("Mussoorie is famous for Kempty Falls and pleasant weather.");
    }
}

class Gulmarg extends HillStations {
    @Override
    public void famousFood() {
        System.out.println("Gulmarg famous food: Rogan Josh and Kashmiri Kahwa.");
    }

    @Override
    public void famousFor() {
        System.out.println("Gulmarg is famous for skiing and scenic meadows.");
    }
}

public class ASSIGNMENT5 {
    public static void showStation(HillStations station, String stationName) {
        System.out.println("\n=== " + stationName + " ===");
        station.famousFood();
        station.famousFor();
    }

    public static void main(String[] args) {
        System.out.println("*** ASSIGNMENT 5: HILL STATIONS (RUNTIME POLYMORPHISM) ***");

        HillStations station;

        station = new Manali();
        showStation(station, "MANALI");

        station = new Mussoorie();
        showStation(station, "MUSSOORIE");

        station = new Gulmarg();
        showStation(station, "GULMARG");
    }
}
