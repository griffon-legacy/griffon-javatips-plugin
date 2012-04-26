package com.wordpress.tipsforjava.util;

import java.util.Comparator;
import java.util.List;

/**
 *  Sort an object based on a specified column within the object.
 *  The object must be either a List or an Array. Several sort
 *  properties can be set:
 *
 *  a) ascending (default true)
 *  b) ignore case (default true)
 *  c) nulls last (default true)
 *
 *  @author Rob Camick
 *  @author Darryl Burke
 */
public class ColumnComparator implements Comparator
{
	private int column;
	private boolean isAscending;
	private boolean isIgnoreCase;
	private boolean isNullsLast = true;

	/*
	 *  The specified column will be sorted using default sort properties.
	 */
	ColumnComparator(int column)
	{
		this(column, true);
	}

	/*
	 *  The specified column wil be sorted in the specified order
	 *  with the remaining default properties
	 */
	ColumnComparator(int column, boolean isAscending)
	{
		this(column, isAscending, true);
	}

	/*
	 *  The specified column wil be sorted in the specified order and
	 *  case sensitivity with the remaining default properties
	 */
	ColumnComparator(int column, boolean isAscending, boolean isIgnoreCase)
	{
		setColumn( column );
		setAscending( isAscending );
		setIgnoreCase( isIgnoreCase );
	}

	/*
	 *  Set the column to be sorted
	 */
	public void setColumn(int column)
	{
		this.column = column;
	}

	/*
	 *  Set the sort order
	 */
	public void setAscending(boolean isAscending)
	{
		this.isAscending = isAscending;
	}

	/*
	 *  Set whether case should be ignored when sorting Strings
	 */
	public void setIgnoreCase(boolean isIgnoreCase)
	{
		this.isIgnoreCase = isIgnoreCase;
	}

	/*
	 *  Set nulls position in the sort order
	 */
	public void setNullsLast(boolean isNullsLast)
	{
		this.isNullsLast = isNullsLast;
	}

	/*
	 *  Implement the Comparable interface
	 */
	@SuppressWarnings("unchecked")
	public int compare(Object a, Object b)
	{
		//  The object to be sorted must be a List or an Array

		Object o1 = null;
		Object o2 = null;

		if (a instanceof List)
		{
			List list1 = (List)a;
			List list2 = (List)b;

			o1 = list1.get(column);
			o2 = list2.get(column);
		}

		if (a.getClass().isArray())
		{
			Object[] a1 = (Object[])a;
			Object[] a2 = (Object[])b;

			o1 = a1[column];
			o2 = a2[column];
		}

		// Treat empty strings like nulls

		if (o1 instanceof String && ((String)o1).length() == 0)
		{
			o1 = null;
		}

		if (o2 instanceof String && ((String)o2).length() == 0)
		{
			o2 = null;
		}

		// Handle sorting of null values

		if (o1 == null && o2 == null) return 0;

		if (o1 == null) return isNullsLast ? 1 : -1;

		if (o2 == null) return isNullsLast ? -1 : 1;

		//  Compare objects

		Object c1;
		Object c2;

		if (isAscending)
		{
			c1 = o1;
			c2 = o2;
		}
		else
		{
			c1 = o2;
			c2 = o1;
		}

		if (c1 instanceof Comparable)
		{
			if (c1 instanceof String
			&&  isIgnoreCase)
				return ((String)c1).compareToIgnoreCase((String)c2);
			else
				return ((Comparable)c1).compareTo(c2);
		}
		else  // Compare as a String
		{
			if (isIgnoreCase)
				return c1.toString().compareToIgnoreCase(c2.toString());
			else
				return c1.toString().compareTo(c2.toString());
		}
	}
}
