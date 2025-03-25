package bt4;

public class Report {
    public static void generateReport(String name, int age, double[] scores) {
        printStudentInfo(name, age);
        double averageScore = calculateAverageScore(scores);
        printAverageScore(averageScore);
        printGradeEvaluation(averageScore);
    }

    private static void printStudentInfo(String name, int age) {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    private static double calculateAverageScore(double[] scores) {
        double total = 0;
        for (double score : scores) {
            total += score;
        }
        return total / scores.length;
    }

    private static void printAverageScore(double averageScore) {
        System.out.println("Average Score: " + averageScore);
    }

    private static void printGradeEvaluation(double averageScore) {
        if (averageScore >= 8) {
            System.out.println("Grade: Excellent");
        } else if (averageScore >= 5) {
            System.out.println("Grade: Good");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}
