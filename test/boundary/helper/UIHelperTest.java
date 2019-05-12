package test.boundary.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import ddc.boundary.helper.UIHelper;

class UIHelperTest {
	
	@Test
	void testRepeat() {
		String expected = "ababab";
		String actual = new UIHelper().repeat("ab", 3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testWriteHorizontalBorder() {
		System.out.println("\n\n\n> test of writeHorizontalBorder\n");
		new UIHelper().writeHorizontalBorder();
	}
	
	@Test
	void testWriteTextCenterWith() {
		System.out.println("\n\n\n> test of writeTextCenterWith\n");
		new UIHelper().writeTextCenterWith("TEXT-CENTER-WITH", 1);
	}
	
	@Test
	void testWriteTextLeft() {
		System.out.println("\n\n\n> test of writeTextLeft");
		new UIHelper().writeTextLeft("text-left");
	}
	
	@Test
	void testWriteTitle() {
		System.out.println("\n\n\n> test of WriteTitle\n");
		new UIHelper().writeTitle("TITLE");
	}
	
	@Test
	void testWriteFormHeader() {
		System.out.println("\n\n\n> test of writeFormHeader\n");
		new UIHelper().writeFormHeader("form-header");
	}
	
	@Test
	void testReadInput() {
		System.out.println("\n\n\n> test of readInput\n");
		String expected = "input-text";
		UIHelper ui = new UIHelper();
		ui.scan = new Scanner(expected);
		String actual = ui.readInput("label");
		assertEquals(expected, actual);
	}
	
	@Test
	void testWriteFooter() {
		System.out.println("\n\n\n> test of writeFooter\n");
		new UIHelper().writeFooter();
	}
}
