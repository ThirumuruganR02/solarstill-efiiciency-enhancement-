import java.util.Scanner;

public class SolarStillOptimizer {

    // Function to calculate optimal mirror angle
    public static double calculateOptimalMirrorAngle(double solarIncidenceAngle) {
        return solarIncidenceAngle / 2.0;
    }

    // Function to calculate estimated efficiency
    public static double calculateEfficiency(double solarIncidenceAngle, double mirrorAngle) {
        // Simple demo model for project explanation
        double baseEfficiency = 30.0;
        double angleFactor = Math.cos(Math.toRadians(solarIncidenceAngle - 2 * mirrorAngle));
        double efficiency = baseEfficiency + (angleFactor * 20.0);

        // Keep efficiency within realistic bounds
        if (efficiency > 60.0) {
            efficiency = 60.0;
        }
        if (efficiency < 20.0) {
            efficiency = 20.0;
        }

        return efficiency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Solar Still Efficiency Optimizer ===");
        System.out.print("Enter number of solar incidence scenarios: ");
        int n = scanner.nextInt();

        double[] solarAngles = new double[n];
        double[] mirrorAngles = new double[n];
        double[] efficiencies = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter solar incidence angle for scenario " + (i + 1) + ": ");
            solarAngles[i] = scanner.nextDouble();

            mirrorAngles[i] = calculateOptimalMirrorAngle(solarAngles[i]);
            efficiencies[i] = calculateEfficiency(solarAngles[i], mirrorAngles[i]);
        }

        System.out.println("\n=== Optimization Results ===");
        System.out.printf("%-10s %-20s %-20s%n", "Scenario", "Mirror Angle (deg)", "Efficiency (%)");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-20.2f %-20.2f%n",
                    (i + 1), mirrorAngles[i], efficiencies[i]);
        }

        double maxEfficiency = efficiencies[0];
        int bestScenario = 0;

        for (int i = 1; i < n; i++) {
            if (efficiencies[i] > maxEfficiency) {
                maxEfficiency = efficiencies[i];
                bestScenario = i;
            }
        }

        System.out.println("\n=== Best Scenario ===");
        System.out.println("Scenario: " + (bestScenario + 1));
        System.out.println("Solar Incidence Angle: " + solarAngles[bestScenario] + " deg");
        System.out.println("Optimal Mirror Angle: " + mirrorAngles[bestScenario] + " deg");
        System.out.println("Peak Efficiency: " + String.format("%.2f", maxEfficiency) + "%");

        scanner.close();
    }
}