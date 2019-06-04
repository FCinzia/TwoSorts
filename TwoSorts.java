/**
 
 * @author Cinzia Ferri 
 * @version 1.0
 * @since 2016-11-09
 
 * Draws rectangles using array of integers and sorts the arrays.
 
   Algorithm:
   1) create two arrays
   2) display the arrays
   3) sort one item at a time in the array using insertion sort and the other array using selection sort
   4) repaint the array for each pass
   5) check that arrays are sorted
   6) repaint the array with another color
 
 */

import javax.swing.JFrame;

/**
 * TwoSorts.java --- Two Sorts Driver
 *
 * @author    Cinzia Ferri 
 * @version   1.0
 * @due       2016-11-22
 */
public class TwoSorts {
    /**
     * Draws array of ints(represented as bars), sorts them
     * @param arg A string array containing
     * the command line arguments.
     * @exception Any exception
     * @return No return value.
     */
	public static void main(String args[]) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TwoSortsPanel panel = new TwoSortsPanel();
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		System.out.println("");
		for (int b : panel.selectionArray) {
			System.out.print(b + " ");
		}
	}
}
