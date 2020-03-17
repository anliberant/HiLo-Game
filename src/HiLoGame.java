import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class HiLoGame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5783252699226579291L;
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int numberOfTries;
	private JButton btnHidden;

	private int theNumber;

	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if (guess < theNumber) {
				message = guess + " is to low. Try again.";
				numberOfTries++;
			} else if (guess > theNumber) {
				message = guess + " is to high. Try again";
				numberOfTries++;
			} else {
				message = guess + " is correct. You win. You tried: " + ++numberOfTries + " times. Let's play again!";
				btnHidden.setVisible(true);
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}

	public void newGame() {
		btnHidden.setVisible(false);
		theNumber = (int) (Math.random() * 99) + 1;
	}

	public HiLoGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(58, 32, 316, 32);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 96, 231, 16);
		getContentPane().add(lblNewLabel_1);

		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(269, 94, 60, 22);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);

		JButton btnGuess = new JButton("Guess!");
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(167, 144, 97, 25);
		getContentPane().add(btnGuess);

		btnHidden = new JButton("Play again");
		btnHidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
		btnHidden.setBounds(167, 166, 97, 32);
		btnHidden.setVisible(false);
		getContentPane().add(btnHidden);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(12, 201, 408, 16);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiLoGame hm = new HiLoGame();
		hm.newGame();
		hm.setSize(new Dimension(450, 300));
		hm.setVisible(true);
	}
}
