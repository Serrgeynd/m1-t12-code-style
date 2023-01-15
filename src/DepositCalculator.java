import java.util.Scanner;

public class DepositCalculator {
    double сalculateComplexPercent(double newAmount, double newYearRate, int depositPeriod) {
        double monthOutDeposit = newAmount * Math.pow((1 + newYearRate/ 12), 12 *depositPeriod);
            return makeRound(monthOutDeposit, 2);
  }

    double сalculateSimplePercent(double newAmount, double newYearRate, int depositPeriod) {
        return makeRound(newAmount+newAmount * newYearRate *depositPeriod, 2);
    }

    double makeRound(double value, int places) {
        double scale = Math.pow(value, places);
            return Math.round(value * scale) / scale;
}

    void calculateDepositParameter() {
        int period;
        int action ;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите сумму вклада в рублях:");
        int newAmount = scanner.nextInt();
            System.out.println("Введите срок вклада в годах:");
            period = scanner.nextInt();
            System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
            action = scanner.nextInt();
        double outDeposit = 0;

        if (action == 1) {
            outDeposit = сalculateSimplePercent(newAmount, 0.06, period);
        }else if (action == 2) {
            outDeposit = сalculateComplexPercent(newAmount, 0.06, period); }
        System.out.println("Результат вклада: " + newAmount + " за " + period + " лет превратятся в " + outDeposit);
    }

public static void main(String[]args) {
    new DepositCalculator().calculateDepositParameter();
    }
}
