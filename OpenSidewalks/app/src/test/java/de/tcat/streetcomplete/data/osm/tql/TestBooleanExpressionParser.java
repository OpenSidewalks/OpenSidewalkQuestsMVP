package de.tcat.opensidewalks.data.osm.tql;

import de.tcat.opensidewalks.data.osm.tql.BooleanExpression;
import de.tcat.opensidewalks.data.osm.tql.BooleanExpressionBuilder;
import de.tcat.opensidewalks.data.osm.tql.BooleanExpressionValue;
import de.tcat.opensidewalks.data.osm.tql.StringWithCursor;

public class TestBooleanExpressionParser
{
	public static BooleanExpression<BooleanExpressionValue> parse(String input)
	{
		BooleanExpressionBuilder<BooleanExpressionValue> builder = new BooleanExpressionBuilder<>();
		StringWithCursor reader = new StringWithCursor(input);
		while(!reader.isAtEnd())
		{
			if(reader.nextIsAndAdvance('*')) builder.addAnd();
			else if(reader.nextIsAndAdvance('+')) builder.addOr();
			else if(reader.nextIsAndAdvance('(')) builder.addOpenBracket();
			else if(reader.nextIsAndAdvance(')')) builder.addCloseBracket();
			else builder.addValue(new TestBooleanExpressionValue(String.valueOf(reader.advance())));
		}
		return builder.getResult();
	}
}
