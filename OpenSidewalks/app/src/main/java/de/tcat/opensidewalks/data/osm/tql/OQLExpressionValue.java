package de.tcat.opensidewalks.data.osm.tql;

public interface OQLExpressionValue extends BooleanExpressionValue
{
	String toOverpassQLString();
}
