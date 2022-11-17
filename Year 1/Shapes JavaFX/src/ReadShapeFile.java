
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author Mocock
 *
 */

import javafx.scene.paint.Color;
import java.io.*;
import java.util.Scanner;

public class ReadShapeFile {

	/**
	 * Reads the data file used by the program and returns the constructed queue
	 * Uses a case statement to determine the shape being created
	 * 
	 * @param in the scanner of the file
	 * @return the queue represented by the data file
	 */
	private static Queue<ClosedShape> readDataFile(Scanner in) {
		Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();
		/*
		read in the shape files and place them on the Queue
		 */
		while (in.hasNextLine()) {
			String currentLine = in.nextLine();
			Scanner line = new Scanner(currentLine);

			String shapeName = line.next();
			switch (shapeName) {
				case "circle":
					Circle circle = makeCircle(line);
					shapeQueue.enqueue(circle);
					System.out.println(circle.toString());
					break;
				case "oval":
					Oval oval = makeOval(line);
					shapeQueue.enqueue(oval);
					System.out.println(oval.toString());
					break;
                case "square":
                	Square square = makeSquare(line);
					shapeQueue.enqueue(square);
                    System.out.println((square).toString());
                    break;
                case "rect":
                	Rect rect = makeRect(line);
					shapeQueue.enqueue(rect);
                    System.out.println(rect.toString());
                    break;
				case "text":
					Text text = makeText(line);
					shapeQueue.enqueue(text);
					System.out.println(text.toString());
					break;
			}

		}
		in.close();

		return shapeQueue;
	}


	/**
	 * Method that sets the values for a circle and creates it
	 * @param line
	 * @return A circle object
	 */
	public static Circle makeCircle(Scanner line) {
		int x = line.nextInt();
		int y = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean isFilled = line.nextBoolean();
		int diameter = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = line.nextInt();
		line.close();
		Circle circle = new Circle(insertionTime, x, y, vx, vy, diameter, colour, isFilled);
		return circle;
	}

	/**
	 * Method that sets the values for an oval and creates it
	 * @param line
	 * @return an oval object
	 */
	public static Oval makeOval(Scanner line) {
		int x = line.nextInt();
		int y = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean isFilled = line.nextBoolean();
		int width = line.nextInt();
		int height = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = line.nextInt();
		line.close();
		Oval oval = new Oval(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
		return oval;
	}

    /**
     * Method that sets the values for a square and creates it
     * @param line
     * @return a square object
     */
	public static Square makeSquare(Scanner line) {
        int x = line.nextInt();
        int y = line.nextInt();
        int vx = line.nextInt();
        int vy = line.nextInt();
        boolean isFilled = line.nextBoolean();
        int side = line.nextInt();
        int r = line.nextInt();
        int g = line.nextInt();
        int b = line.nextInt();
        Color colour = Color.rgb(r, g, b);
        int insertionTime = line.nextInt();
        line.close();
        Square square = new Square(insertionTime, x, y, vx, vy, side, colour, isFilled);
        return square;
    }

    /**
     * Method that sets the values for a rectangle and creates it
     * @param line
     * @return a rect object
     */
    public static Rect makeRect(Scanner line) {
        int x = line.nextInt();
        int y = line.nextInt();
        int vx = line.nextInt();
        int vy = line.nextInt();
        boolean isFilled = line.nextBoolean();
        int width = line.nextInt();
        int height = line.nextInt();
        int r = line.nextInt();
        int g = line.nextInt();
        int b = line.nextInt();
        Color colour = Color.rgb(r, g, b);
        int insertionTime = line.nextInt();
        line.close();
        Rect rectangle = new Rect(insertionTime, x, y, vx, vy, width, height, colour, isFilled);
        return rectangle;
    }

	/**
	 * Method that sets the values for a rectangle and creates it
	 * @param line
	 * @return a text object
	 */
    public static Text makeText(Scanner line) {
		int x = line.nextInt();
		int y = line.nextInt();
		int vx = line.nextInt();
		int vy = line.nextInt();
		boolean isFilled = line.nextBoolean();
		String str = line.next();
		int maxWidth = line.nextInt();
		int r = line.nextInt();
		int g = line.nextInt();
		int b = line.nextInt();
		Color colour = Color.rgb(r, g, b);
		int insertionTime = line.nextInt();
		line.close();
		Text text = new Text(insertionTime, x, y, vx, vy, str, colour, isFilled, maxWidth);
		return text;
	}

	/**
	 * Method to read the file and return a queue of shapes from this file. The
	 * program should handle the file not found exception here and shut down the
	 * program gracefully.
	 * 
	 * @param filename the name of the file
	 * @return the queue of shapes from the file
	 */
	public static Queue<ClosedShape> readDataFile(String filename) {

		File shapeFile = new File(filename);
	    Scanner in = null;

		try {
			in = new Scanner(shapeFile);
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found");
			System.exit(0);
		}
	    
	    return ReadShapeFile.readDataFile(in);
	}

}
