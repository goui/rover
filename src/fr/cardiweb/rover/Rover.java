package fr.cardiweb.rover;

import java.util.Arrays;
import java.util.List;

public class Rover implements IRobot {

	private int _currentX;

	private int _currentY;

	private int _currentOrientationIndex;

	private int _maxX;

	private int _maxY;

	private static List<String> _orientations = Arrays.asList("N", "E", "S",
			"W");

	public Rover(int x_p, int y_p, String orientation_p, int maxX_p, int maxY_p) {
		_currentX = x_p;
		_currentY = y_p;
		_currentOrientationIndex = _orientations.indexOf(orientation_p);
		_maxX = maxX_p;
		_maxY = maxY_p;
	}

	@Override
	public void turnLeft() {
		if (_currentOrientationIndex == 0) {
			_currentOrientationIndex = 3;
		} else {
			_currentOrientationIndex--;
		}
	}

	@Override
	public void turnRight() {
		if (_currentOrientationIndex == 3) {
			_currentOrientationIndex = 0;
		} else {
			_currentOrientationIndex++;
		}
	}

	@Override
	public void goForward() {
		switch (_currentOrientationIndex) {
		case 0:
			if (_currentY < _maxY) {
				_currentY++;
			}
			break;
		case 1:
			if (_currentX < _maxX) {
				_currentX++;
			}
			break;
		case 2:
			if (_currentY > 0) {
				_currentY--;
			}
			break;
		case 3:
			if (_currentX > 0) {
				_currentX--;
			}
			break;
		}
	}

	@Override
	public String toString() {
		return _currentX + " " + _currentY + " "
				+ _orientations.get(_currentOrientationIndex);
	}

}
