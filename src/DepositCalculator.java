import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int period) {
        double payout = amount * Math.pow((1 + yearRate / 12), 12 * period);
        return round(payout, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double payout = amount + amount * yearRate * depositPeriod;
        return round(payout, 2);
    }

    double round(double value, int decimalPlaces) {
        double scale = Math.pow(10, decimalPlaces);
        return Math.round(value * scale) / scale;
    }

    void calculateDepositIncome() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        int period = scanner.nextInt();
        System.out.println("Выберите тип вклада: \n 1 - вклад с обычным процентом \n 2 - вклад с капитализацией:");
        int depositType = scanner.nextInt();
        double totalPayout = 0;
        if (depositType == 1) {
            totalPayout = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            totalPayout = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + totalPayout);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculateDepositIncome();
    }
}
