package App;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game_Engine {

	private static Scanner input;
	private static User currentUser;
	private static ArrayList<Question> questionsList = new ArrayList<>();
	private static int points = 0;

	// Menu Of Main Page
	public static void DisplayMenu() {
		System.out.println("Welcome to Trivia World");
		System.out.println("1 : Log In");
		System.out.println("2 : Register");
		System.out.println("3 : Exit");
		System.out.println("Select:");
	}

	// Select Login User
	public static void logInMenu() {
		System.out.println("1 : Log-in as Manager");
		System.out.println("2 : Log-in as Player");
		System.out.println("Select: ");
		selectAccType(SelectMenuOptions());
	}

	// Select the User is Manager or Player
	public static void selectAccType(int choice) {
		switch (choice) {
		case 1:
			asManager();
			break;
		case 2:
			asPlayer();
			break;
		default:
			System.out.println("Select from above menu");
			logInMenu();
			break;
		}
	}

	// Display Player Menu
	private static void asPlayer() {
		System.out.println("*Loged-in as Player*");
		boolean created = false;
		currentUser = new Player();
		try {
			created = currentUser.login();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (created) {
			QuestionMenu();
		}
	}

	// Display Manager Menu
	private static void asManager() {
		System.out.println("*Loged-in as Manager*");
		boolean created = false;
		currentUser = new Manager();
		try {
			created = currentUser.login();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (created) {
			// QuestionMenu();
		}
	}

	// Question Menu
	private static void QuestionMenu() {
		System.out.println("Select Genre you would like to play");
		System.out.println("1 : General Knowledge");
		System.out.println("2 : Sports");
		System.out.println("3 : Movies");
		System.out.println("Select :");
		chooseQuestion(SelectMenuOptions());
	}

	// Select User
	public static int SelectMenuOptions() {
		input = new Scanner(System.in);
		int choice = input.nextInt();
		return choice;
	}

	// Choosing Question using Switch
	private static void chooseQuestion(int choice) {
		Question tempQuestion = new Question();

		switch (choice) {
		case 1:
			try {
				questionsList = tempQuestion.getQuestions("gk");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				questionsList = tempQuestion.getQuestions("sp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				questionsList = tempQuestion.getQuestions("mov");
			} catch (IOException e) {
				e.printStackTrace();
			}
			break;
		default:
			QuestionMenu();
			break;
		}
		if (!questionsList.isEmpty()) {
			displayQuestions(0);
		}
	}

	private static void displayQuestions(int index) {
		System.out.println(questionsList.get(index));
		System.out.println("Select :");
		checkAnswer(questionsList.get(index).answer, SelectMenuOptions(), index);
	}

	private static void checkAnswer(String option, int ans, int index) {

		if (Integer.toString(ans).equals(option)) {
			System.out.println("Correct ans ");
			System.out.println("Current Score : " + ++points);
			if (questionsList.size() != index + 1) {
				displayQuestions(++index);
			} else {
				printResult(points);
			}
		} else {
			System.out.println("Wrong ans ");
			System.out.println("Current Score : " + points);
			if (questionsList.size() != index + 1) {
				displayQuestions(++index);
			} else {
				printResult(points);
			}
		}
	}

	private static void printResult(int points) {
		System.out.println("Your Total Score is : " + points);
	}

	// Creating Player When you select register
	public static void createPlayer() {
		Player tempPlayer = new Player();
		boolean created = false;
		try {
			created = tempPlayer.createPlayer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (created) {
			currentUser = tempPlayer;
			QuestionMenu();
		}
	}
}
