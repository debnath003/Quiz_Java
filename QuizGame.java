import java.util.Scanner;

public class QuizGame {

    // Method that asks questions and uses switch-case for each answer
    public static int askQuestion(String question, String[] options, int correctOption) {
        Scanner sc = new Scanner(System.in);
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }

        // Asking for the user's input
        System.out.print("Please choose the correct option (1-4): ");
        int choice = sc.nextInt();

        // Using switch-case to check the answer
        switch (choice) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (choice == correctOption) {
                    System.out.println("Correct!");
                    return 1; // return 1 for a correct answer
                } else {
                    System.out.println("Wrong!");
                    return 0; // return 0 for a wrong answer
                }
            default:
                System.out.println("Invalid choice! Please select a number between 1 and 4.");
                return 0; // return 0 for an invalid choice (treated as wrong)
        }
    }

    public static void main(String[] args) {
        // Total score tracking
        int correctAnswers = 0;
        int wrongAnswers = 0;

        // Questions and options
        String[] questions = {
            "What is the capital of France?",
            "Who developed the theory of relativity?",
            "Which planet is known as the Red Planet?",
            "What is the largest mammal?",
            "In which year did World War II end?",
            "What is the chemical symbol for water?",
            "Which country is known as the Land of the Rising Sun?",
            "Who wrote 'Romeo and Juliet'?",
            "What is the hardest natural substance on Earth?",
            "Which gas is most abundant in the Earth's atmosphere?"
        };

        String[][] options = {
            {"Berlin", "Madrid", "Paris", "Rome"},
            {"Isaac Newton", "Albert Einstein", "Galileo Galilei", "Marie Curie"},
            {"Venus", "Mars", "Jupiter", "Saturn"},
            {"Elephant", "Blue Whale", "Giraffe", "Shark"},
            {"1942", "1945", "1948", "1950"},
            {"O2", "H2O", "CO2", "N2"},
            {"China", "India", "Japan", "Korea"},
            {"William Shakespeare", "Charles Dickens", "Mark Twain", "J.K. Rowling"},
            {"Gold", "Iron", "Diamond", "Graphite"},
            {"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}
        };

        int[] correctAnswersKeys = {3, 2, 2, 2, 2, 2, 3, 1, 3, 2}; // Indices of correct options for each question

        // Loop through the 10 questions
        for (int i = 0; i < 10; i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            int result = askQuestion(questions[i], options[i], correctAnswersKeys[i]);

            if (result == 1) {
                correctAnswers++;
            } else {
                wrongAnswers++;
            }
        }

        // Final Stats
        System.out.println("\nQuiz Over!");
        System.out.println("You got " + correctAnswers + " out of 10 questions correct.");
        System.out.println("You got " + wrongAnswers + " questions wrong.");

        // Calculate and display percentage
        double scorePercentage = (correctAnswers / 10.0) * 100;
        System.out.println("Your score: " + scorePercentage + "%");
    }
}
