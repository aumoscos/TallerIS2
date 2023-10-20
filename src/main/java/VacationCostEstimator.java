import java.util.Scanner;

abstract class VacationCostEstimator {
    public static void main(final String[] args) {
        final int destinationMax = 3;
        final int maxTravelers = 80;
        final int travelersPromoLowerBound = 4;
        final int travelersPromoUpperBound = 10;
        final int costParis = 500;
        final int costNY = 600;
        final double discount10 = 0.1;
        final double discount20 = 0.2;
        final int minDuration = 7;
        final int penaltyStandard = 200;
        final int maxDuration = 30;
        Scanner scanner = new Scanner(System.in);
        int destination = -1;
        while  (destination < 0 || destination > destinationMax) {
        System.out.print("Enter the destination of the vacation"
        + " (1.- Paris / 2.- New York City / 3.- Others): ");
        destination = scanner.nextInt();
        }
        int numTravelers = 0;
        while (numTravelers <= 0) {
        System.out.print("Enter the number of travelers: ");
        numTravelers = scanner.nextInt();
        }
        int duration = 0;
        while (duration <= 0) {
        System.out.print("Enter the duration of the vacation in days: ");
        duration = scanner.nextInt();
        }
        scanner.close();
        final int baseCost = 1000;
        int additionalCost = 0;
        if (destination == 1) {
            additionalCost = costParis;
        } else if (destination == 2) {
            additionalCost = costNY;
        }
        if (numTravelers <= 0 || duration <= 0 || numTravelers > maxTravelers) {
            System.out.println("Invalid input. "
          + "Please check the number of travelers, duration, or destination.");
            System.out.println("Total cost: -1");
            return;
        }
        double discount = 0;
        if (numTravelers > travelersPromoLowerBound
        && numTravelers <= travelersPromoUpperBound) {
            discount = discount10;
        } else if (numTravelers > travelersPromoUpperBound) {
            discount = discount20;
        }
        int penaltyFee = (duration < minDuration) ? penaltyStandard : 0;
        int promotionDiscount = ((duration > maxDuration)
        || (numTravelers == 2)) ? penaltyStandard : 0;
        int totalCost = (int) Math.round((baseCost
        + additionalCost - promotionDiscount + penaltyFee) * (1 - discount));
        System.out.println("Total cost: $" + totalCost);
    }
}
