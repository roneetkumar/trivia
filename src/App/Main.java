package App;

public class Main {
	public static void main(String[] args) {

		Game_Engine.DisplayMenu();

		int choice = Game_Engine.SelectMenuOptions();

		switch (choice) {
		case 1:
			Game_Engine.logInMenu();
			break;
		case 2:
			Game_Engine.createPlayer();
			break;
		case 3:
			System.out.println("Thank you for playing Trivia!");
			break;
		default:
			break;
		}
	}
}
