import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * TwoSortsPanel.java --- Draws rectangles using array of integers and sorts the arrays.
 *
 * @author    Cinzia Ferri and Justin Lee
 * @version   1.0
 * @due       2016-11-22
 */
public class TwoSortsPanel extends JPanel {
    
    Random rand = new Random();
    JButton nextButton = new JButton("Sort me");
    
    int arraySize = rand.nextInt(30) + 10;;
    int[] insertionArray = new int[arraySize]; // Math.rand 10-30
    int[] selectionArray = new int[arraySize];
    int numberOfClicks = 1;
    
    //----------------------------------------------------------------------------------------------
    // TwoSortsPanel Constructor
    //----------------------------------------------------------------------------------------------
    public TwoSortsPanel() {
        setBackground(Color.yellow);
        setPreferredSize(new Dimension(1000, 300));
        
        JLabel statusLabel = new JLabel("TOP-Selection Sort *** BOTTOM-Insertion Sort");
        
        // Populate the two arrays
        instantiateArray();
        
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numberOfClicks++;
                
                // Start a pass for insertion sort and Selection sort
                selectionSort(selectionArray);
                insertionSort(insertionArray);
                repaint();
                
            }
        });
        add(statusLabel);
        add(nextButton);
    }
    
    //----------------------------------------------------------------------------------------------
    // Selection sort method
    //----------------------------------------------------------------------------------------------
    public void selectionSort(int[] arr) {
        for (int i = 0; i < numberOfClicks - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;
            
            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
            
        }
    }
    
    //----------------------------------------------------------------------------------------------
    // Insertion sort method
    //----------------------------------------------------------------------------------------------
    public void insertionSort(int array[]) {
        int n = numberOfClicks;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j - 1;
            while ((i > -1) && (array[i] > key)) {
                array[i + 1] = array[i];
                i--;
            }
            array[i + 1] = key;
        }
    }
    
    //----------------------------------------------------------------------------------------------
    // Create an array of random numbers
    //----------------------------------------------------------------------------------------------
    public void instantiateArray() {
        for (int j = 0; j < arraySize; j++) {
            
            // Generate random number
            int random = rand.nextInt(90) + 10;
            
            // Check if the numbers are exclusive
            if (isSingle(random) == true) {
                
                // Place values into both arrays
                insertionArray[j] = random;
                selectionArray[j] = random;
            } else {
                j -= 1;
            }
        }
    }
    
    //----------------------------------------------------------------------------------------------
    // Check if array is sorted
    //----------------------------------------------------------------------------------------------
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }
    
    //----------------------------------------------------------------------------------------------
    // Return true if there are no matching numbers in the array
    //----------------------------------------------------------------------------------------------
    public boolean isSingle(int i) {
        int checker = 0;
        
        for (int h = 0; h < insertionArray.length; h++) {
            if (i == insertionArray[h]) {
                checker++;
            }
        }
        
        if (checker > 0) {
            checker = 0;
            return false;
        }
        return true;
    }
    
    //----------------------------------------------------------------------------------------------
    // Paint Component
    //----------------------------------------------------------------------------------------------
    public void paintComponent(Graphics page) {
        page.setColor(Color.red);
        super.paintComponent(page);
        
        // Check if both arrays are sorted
        if (isSorted(insertionArray) == true && isSorted(selectionArray) == true) {
            System.out.print(isSorted(insertionArray));
            System.out.print(isSorted(selectionArray));
            page.setColor(Color.gray);
            nextButton.setText("Done");
            nextButton.setEnabled(false);
            int spacing = 0;
            for (int a : selectionArray) {
                page.fillRect(spacing + 200, 140 - a, 15, a);
                spacing += 20;
            }
            
            page.setColor(Color.gray);
            int spacing2 = 0;
            for (int a : insertionArray) {
                page.fillRect(spacing2 + 200, 140 + 5, 15, a);
                spacing2 += 20;
            }
        }
        
        else {
            int spacing = 0;
            for (int a : selectionArray) {
                page.fillRect(spacing + 200, 140 - a, 15, a);
                spacing += 20;
            }
            
            int spacing2 = 0;
            for (int a : insertionArray) {
                page.fillRect(spacing2 + 200, 140 + 5, 15, a);
                spacing2 += 20;
            }
        }
    }
}
