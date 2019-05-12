package ddc.boundary.helper;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class UIHelper {
	public Scanner scan = new Scanner(System.in);
	public PrintStream out = System.out;
	public int width = 60;
	public String borderChar = "+";
	public int borderWith = 1;
	public int horizontalPaddingWidth = 4;
	public String horizontalPadding = repeat(" ", horizontalPaddingWidth);
	public int verticalPaddingNr = 1;
	public String horizontalBorder = repeat(borderChar, width);
	
	public String repeat(String text, int nr) {
		return String.join("", Collections.nCopies(nr, text));
	}
	
	public void writeBR(int nr) {
		for(int i = 0; i < nr; ++i) out.println();
	}
	
	public void writeHorizontalBorder() {
		out.println(horizontalBorder);
	}
	
	public void writeTextLeft(String text) {
		int rightLength = width - borderWith - horizontalPadding.length() - text.length() - borderWith;
		out.println(borderChar + horizontalPadding + text + repeat(" ", rightLength) + borderChar);
	}
	
	public void writeTextCenterWith(String text, int padding) {
		int leftLength = (int) Math.ceil(1. * (width - text.length() - 2 * padding) / 2);
		int rightLength = (int) Math.floor(1. * (width - text.length() - 2 * padding) / 2);
		String leftString = String.join("", Collections.nCopies(leftLength, borderChar));
		String rightString = String.join("", Collections.nCopies(rightLength, borderChar));
		String paddingString = String.join("", Collections.nCopies(padding, " "));
		out.println(leftString + paddingString + text + paddingString + rightString);
	}

	/**
	 * affiche l'entête de la page
	 * @param title est le titre de la page
	 */
	public void writeTitle(String title) {
		writeHorizontalBorder();
		writeBR(1);
		writeTextCenterWith(title, 1);
		writeBR(1);
		writeHorizontalBorder();
	}
	
	public void writeFormHeader(String title) {
        writeTextLeft("");;
        writeTextLeft(title);
	}
	
	public String readInput(String label) {
        writeTextLeft(label);
        String string = scan.nextLine();
        return string;
	}
	
	public void writeFooter() {
        writeBR(1);;
        writeHorizontalBorder();
	}

}
