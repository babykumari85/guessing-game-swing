import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class GuessingGame extends JFrame {
	private JTextField txtGuess; // text field for user's guess
	private JLabel lblOutPut; // label for the too hight/ too low output
	private int theNumber;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";

		try {

			// check the guess for too high/too low
			int guess = Integer.parseInt(guessText);

			// too high
			if (guess > theNumber) {
				message = guess + "was too high. guess again";
				lblOutPut.setText(message);
			}
			// low low
			else if (guess < theNumber) {
				message = guess + " was too low. guess again ";
				lblOutPut.setText(message);
			}

			else // guessed correctly
			{
				message = guess + " was correct. you win! Let's play again!";
				lblOutPut.setText(message);
				newGame();
			}
		} catch (Exception e) {
			lblOutPut.setText("Enter a whole a number between 1 and 100.");
		} finally {
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}

	}

	public void newGame() {
		theNumber = (int) (Math.random() * 100 + 1);

	}

	public GuessingGame() {
		setBackground(new Color(0, 153, 0));
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLACK);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 8));
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setBounds(0, 10, 424, 26);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(34, 80, 369, -54);
		getContentPane().add(panel);

		JLabel lblGuessTheNumber = new JLabel("Guess the number between 1 and 100:");
		lblGuessTheNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGuessTheNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGuessTheNumber.setLabelFor(this);
		lblGuessTheNumber.setBounds(10, 47, 294, 26);
		getContentPane().add(lblGuessTheNumber);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuess.setBackground(Color.WHITE);
		txtGuess.setBounds(313, 45, 71, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkGuess();
			}
		});
		btnGuess.setBackground(Color.WHITE);
		btnGuess.setForeground(Color.BLACK);
		btnGuess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnGuess.setBounds(132, 105, 124, 32);
		getContentPane().add(btnGuess);

		lblOutPut = new JLabel("Enter a number above and click guess!");
		lblOutPut.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutPut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOutPut.setBounds(50, 170, 327, 26);
		getContentPane().add(lblOutPut);
		getContentPane()
				.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { lblNewLabel, lblGuessTheNumber }));
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(400, 250));
		theGame.setVisible(true);
	}
}
