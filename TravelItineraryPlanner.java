import java.util.*;
import java.text.*;

public class TravelItineraryPlanner {

    static class Itinerary {
        String destination;
        Date startDate;
        Date endDate;
        String preferences;
        double budget;

        public Itinerary(String destination, Date startDate, Date endDate, String preferences, double budget) {
            this.destination = destination;
            this.startDate = startDate;
            this.endDate = endDate;
            this.preferences = preferences;
            this.budget = budget;
        }

        public void displayItinerary() {
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
            System.out.println("\nYour Travel Itinerary:");
            System.out.println("Destination: " + destination);
            System.out.println("Start Date: " + sdf.format(startDate));
            System.out.println("End Date: " + sdf.format(endDate));
            System.out.println("Preferences: " + preferences);
            System.out.println("Estimated Budget: $" + String.format("%.2f", budget));
            System.out.println("Weather Forecast: " + getWeatherForecast(destination));
            System.out.println("Suggested Activities: " + suggestActivities(preferences));
            System.out.println("\nEnjoy your trip!");
        }

        private String getWeatherForecast(String destination) {

            if (destination.toLowerCase().contains("beach")) {
                return "Sunny with a chance of light winds";
            } else if (destination.toLowerCase().contains("mountain")) {
                return "Cool with possible showers";
            } else {
                return "Mild and clear skies";
            }
        }

        private String suggestActivities(String preferences) {
            if (preferences.toLowerCase().contains("adventure")) {
                return "Hiking, Zip-lining, Rock Climbing";
            } else if (preferences.toLowerCase().contains("relaxation")) {
                return "Spa, Beach Lounging, Yoga";
            } else {
                return "Sightseeing, City Tours, Museums";
            }
        }
    }

    private static Itinerary getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String destination;
        Date startDate = null;
        Date endDate = null;
        String preferences;
        double budget = 0;


        System.out.print("Enter your destination: ");
        destination = scanner.nextLine();

        try {
            System.out.print("Enter start date (MM/dd/yyyy): ");
            String start = scanner.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            startDate = sdf.parse(start);

            System.out.print("Enter end date (MM/dd/yyyy): ");
            String end = scanner.nextLine();
            endDate = sdf.parse(end);
        } catch (ParseException e) {
            System.out.println("Invalid date format! Please try again.");
            return null;
        }

        System.out.print("Enter your preferences (e.g., adventure, relaxation, cultural): ");
        preferences = scanner.nextLine();

        System.out.print("Enter your estimated budget: $");
        budget = scanner.nextDouble();

        return new Itinerary(destination, startDate, endDate, preferences, budget);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Travel Itinerary Planner!");

        Itinerary itinerary = getUserInput();

        if (itinerary != null) {
            itinerary.displayItinerary();
        }
    }
}
