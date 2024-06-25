import java.util.Scanner;

public class DataAnalysisQuiz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define quiz questions and answers
        String[] questions = {
                "What is the process of collecting, cleaning, and organizing data for analysis? \nA) Data visualization \nB) Data wrangling \nC) Data mining \nD) Data modeling",
                "What type of data analysis technique summarizes the central tendency of a dataset? \nA) Descriptive analysis \nB) Predictive analysis \nC) Prescriptive analysis \nD) Diagnostic analysis",
                "Which chart is commonly used to represent the frequency of categorical data? \nA) Bar chart \nB) Line chart \nC) Pie chart \nD) Scatter plot",
                "The process of identifying outliers and inconsistencies in data is called: \nA) Data exploration \nB) Data cleaning \nC) Data transformation \nD) Data validation",
                "What is the primary goal of exploratory data analysis (EDA)? \nA) To build a predictive model \nB) To identify patterns and trends \nC) To test hypotheses \nD) To create visualizations for presentations"
        };

        char[] correctAnswers = {'B', 'A', 'C', 'B', 'B'};
        int totalQuestions = questions.length;
        int score = 0;

        for (int i = 0; i < totalQuestions; i++) {
            System.out.println(questions[i]);
            char userAnswer = scanner.nextLine().toUpperCase().charAt(0);

            // Validate user input
            if (!isValidAnswer(userAnswer)) {
                System.out.println("Invalid input. Please enter A, B, C, or D.");
                continue;
            }

            // Check answer and update score
            if (userAnswer == correctAnswers[i]) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswers[i]);
            }
        }

        // Calculate and display final score
        double percentageScore = (double) score / totalQuestions * 100;
        System.out.println("Your final score is " + score + " out of " + totalQuestions + " (" + percentageScore + "%)");
    }

    // Function to validate user input (A, B, C, or D)
    private static boolean isValidAnswer(char answer) {
        return answer == 'A' || answer == 'B' || answer == 'C' || answer == 'D';
    }
}