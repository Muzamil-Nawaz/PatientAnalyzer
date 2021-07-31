
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HabermanSurvivalStatisticsDriver {

    public static void main(String[] args) {
        Patient[] patients = new Patient[500];
        try {
            File f = new File("haberman.txt");
            Scanner sc = new Scanner(new FileReader(f));
            int count = 0;
            while (sc.hasNext()) {

                String rowValues[] = sc.next().split(",");
                int age = Integer.parseInt(rowValues[0]);
                int year = Integer.parseInt(rowValues[1]);
                int positiveNodes = Integer.parseInt(rowValues[2]);
                int flag = Integer.parseInt(rowValues[3]);
                boolean survival = false;
                if (flag == 1) {
                    survival = true;
                } else if (flag == 2) {
                    survival = false;
                }

                Patient p = new Patient(age, year, positiveNodes, survival);
                patients[count] = p;
                count++;
            }

            double[] avgs = getAverage(patients);
            System.out.println("Total number of patients processed: " + count);
            System.out.println("Average positive axillary nodes: ");
            System.out.println("\tFive or more year survival: " + avgs[0]);
            System.out.println("\tTotal number of patients processed: " + avgs[1]);

            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HabermanSurvivalStatisticsDriver.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static double[] getAverage(Patient[] patients) {

        double avg1, avg2;
        int count1 = 0, count2 = 0;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < patients.length; i++) {
            Patient p = patients[i];
            if (p == null) {
                break;
            }
            if (p.survivedFiveYears) {
                count1++;
                sum1 += p.getPositiveNodes();
            } else if (!p.survivedFiveYears) {
                count2++;
                sum2 += p.getPositiveNodes();
            }
        }
        avg1 = (double) sum1 / count1;
        avg2 = (double) sum2 / count2;

        return new double[]{avg1, avg2};
    }

}
