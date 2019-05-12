package test.boundary.helper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import ddc.boundary.helper.UIHelper;

class UIHelperTest {
	
	@Test
	public void testRepeat() {
		String expected = "ababab";
		String actual = UIHelper.instance.repeat("ab", 3);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWriteHorizontalBorder() {
		System.out.println("\n\n\n> test of writeHorizontalBorder\n");
		UIHelper.instance.writeHorizontalBorder();
	}
	
	@Test
	public void testWriteTextCenterWith() {
		System.out.println("\n\n\n> test of writeTextCenterWith\n");
		UIHelper.instance.writeTextCenterWith("TEXT-CENTER-WITH", 1);
	}
	
	@Test
	public void testWriteTextLeft() {
		System.out.println("\n\n\n> test of writeTextLeft");
		UIHelper.instance.writeTextLeft("text-left");
	}
	
	@Test
	public void testWriteTitle() {
		System.out.println("\n\n\n> test of WriteTitle\n");
		UIHelper.instance.writeTitle("TITLE");
	}
	
	@Test
	public void testWriteFormHeader() {
		System.out.println("\n\n\n> test of writeFormHeader\n");
		UIHelper.instance.writeFormHeader("form-header");
	}
	
	@Test
	public void testWriteInputLabel() {
		System.out.println("\n\n\n> test writeInputLabel\n");
		UIHelper.instance.writeInputLabel("label", 1);
	}
	
	@Test
	public void testReadInput() {
		System.out.println("\n\n\n> test of readInput\n");
		String expected = "input-text";
		UIHelper ui = UIHelper.instance;
		ui.scan = new Scanner(expected);
		String actual = ui.readInput("label");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testWriteFooter() {
		System.out.println("\n\n\n> test of writeFooter\n");
		UIHelper.instance.writeFooter();
	}
	
	@Test
	public void testReadMultiChoix() throws Exception {
		System.out.println("\n\n\n> test of readMultiChoix\n");
		String expected = "C";
		UIHelper ui = UIHelper.instance;
		ui.scan = new Scanner("C");
		Map<String, String> multiChoix = new LinkedHashMap<String, String>();
		multiChoix.put("A", "choix a");
		multiChoix.put("B", "choix b");
		multiChoix.put("C", "choix c");
		multiChoix.put("D", "choix d");
		String actual = ui.readMultiChoix("Choississez parmi les options suivantes", multiChoix, 1);
		assertEquals(expected, actual);
	}
}
