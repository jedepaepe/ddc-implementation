package ddc.boundary.helper;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

public class UIHelper {
	/**
	 * instance globale du UIHelper
	 * TODO : remplacer par le pattern singleton
	 */
	public static UIHelper instance = new UIHelper();
	
	public Scanner scan = new Scanner(System.in);
	public PrintStream out = System.out;
	public int width = 60;
	public String borderChar = "+";
	public int borderWith = 1;
	public int horizontalPaddingWidth = 4;
	public String horizontalPadding = repeat(" ", horizontalPaddingWidth);
	public int verticalPaddingNr = 1;
	public String horizontalBorder = repeat(borderChar, width);
	public String prompt = ">";
	
	public void writeException(Exception ex) {
		writeTextLeft(ex.getMessage());
		ex.printStackTrace(out);		
	}
	
	public String repeat(String text, int nr) {
		return String.join("", Collections.nCopies(nr, text));
	}
	
	public void writeBR(int nr) {
		for(int i = 0; i < nr; ++i) out.println(borderChar + repeat(" ", width - 2 * borderChar.length()) + borderChar);
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
		String leftString = repeat(borderChar, leftLength);
		String rightString = repeat(borderChar, rightLength);
		String paddingString = repeat(" ", padding);
		out.println(leftString + paddingString + text + paddingString + rightString);
	}

	/**
	 * affiche l'entête de la page
	 * @param title est le titre de la page
	 */
	public void writeTitle(String title) {
		writeHorizontalBorder();
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
	
	public void writeInputLabel(String label, int padding) {
		out.print(borderChar + repeat(" ", padding) + label + prompt + " ");
	}
	
	public String readInput(String label) {
        writeInputLabel(label, 1);
        String string = scan.nextLine();
        return string;
	}
	
	public String readMultiChoix(String label, Map<String, String> choixMap, int padding) throws Exception {
		writeTextLeft(label);
		for(Map.Entry<String, String> choix : choixMap.entrySet()) {
			writeTextLeft(choix.getValue() + " > " + choix.getKey());
		}
		writeInputLabel("", 1);
		String choix = scan.nextLine();
		
		// validation
		if(choixMap.containsKey(choix)) return choix;
		// TODO gestion de l'erreur
		else throw new Exception("choix invalide");
	}
	
	public void writeFooter() {
        writeBR(1);;
        writeHorizontalBorder();
        writeHorizontalBorder();
	}
}
