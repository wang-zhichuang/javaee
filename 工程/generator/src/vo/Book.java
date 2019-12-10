package vo;

public class Book {
String bookId,bookName,author;

public Book(String bookId, String bookName, String author) {
	super();
	this.bookId = bookId;
	this.bookName = bookName;
	this.author = author;
}

public Book() {
	super();
}

public String getBookId() {
	return bookId;
}

public void setBookId(String bookId) {
	this.bookId = bookId;
}

public String getBookName() {
	return bookName;
}

public void setBookName(String bookName) {
	this.bookName = bookName;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}


}
