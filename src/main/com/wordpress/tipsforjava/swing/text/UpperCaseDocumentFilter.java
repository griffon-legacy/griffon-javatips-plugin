package com.wordpress.tipsforjava.swing.text;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

/**
 *  The UpperCaseDocumentFilter converts all characters to upper case before
 *  the characters are inserted into the Document.
 *
 *  @author Rob Camick
 *  @author Darryl Burke
 */
public class UpperCaseDocumentFilter extends ChainedDocumentFilter
{
	/**
	 *  Standard constructor for stand alone usage
	 */
	public UpperCaseDocumentFilter()
	{
	}

	/**
	 *	Constructor used when further filtering is required after this
	 *  filter has been applied.
	 */
	public UpperCaseDocumentFilter(DocumentFilter filter)
	{
		super(filter);
	}

	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
		throws BadLocationException
	{
		if (str != null)
		{
			String converted = convertString(str);
			super.insertString(fb, offs, converted, a);
		}
	}

	public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a)
		throws BadLocationException
	{
		if (str != null)
		{
			String converted = convertString(str);
			super.replace(fb, offs, length, converted, a);
		}
	}

	/**
	 *  Convert each character in the input string to upper case
	 *
	 *  @param  mixedCase a String of mixed case characters
	 *  @return an upper cased String
	 */
	private String convertString(String mixedCase)
	{
		char[] upperCase = mixedCase.toCharArray();

		for (int i = 0; i < upperCase.length; i++)
		{
			upperCase[i] = Character.toUpperCase(upperCase[i]);
		}

		return new String( upperCase );
	}
}
