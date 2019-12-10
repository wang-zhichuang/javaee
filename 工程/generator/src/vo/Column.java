package vo;

public class Column {
String columnName;
String columnType;

public Column() {
	super();
}
public Column(String columnName, String columnType) {
	super();
	this.columnName = columnName;
	this.columnType = columnType;
}
public String getColumnName() {
	return columnName;
}
public void setColumnName(String columnName) {
	this.columnName = columnName;
}
public String getColumnType() {
	return columnType;
}
public void setColumnType(String columnType) {
	this.columnType = columnType;
}
@Override
public String toString() {
	return "Column [columnName=" + columnName + ", columnType=" + columnType + "]";
}

}
