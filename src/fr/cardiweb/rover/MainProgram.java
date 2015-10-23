package fr.cardiweb.rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainProgram {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("test"));

			// first line
			String firstLine = br.readLine();
			if (firstLine == null) {
				return;
			}
			String[] strValues = firstLine.split(" ");
			int maxX = Integer.parseInt(strValues[0]);
			int maxY = Integer.parseInt(strValues[1]);

			while (true) {
				
				// first line of rover
				String line1 = br.readLine();
				if (line1 == null) {
					break;
				}
				strValues = line1.split(" ");
				int x = Integer.parseInt(strValues[0]);
				int y = Integer.parseInt(strValues[1]);
				String orientation = strValues[2];

				// second line of rover
				String line2 = br.readLine();
				if (line2 == null) {
					break;
				}
				IRobot rover = new Rover(x, y, orientation, maxX, maxY);
				strValues = line2.split("");
				for (int j = 0; j < strValues.length; j++) {
					switch (strValues[j]) {
					case "G":
						rover.turnLeft();
						break;
					case "D":
						rover.turnRight();
						break;
					case "A":
						rover.goForward();
						break;
					}
				}
				
				System.out.println(rover.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
	}

}
