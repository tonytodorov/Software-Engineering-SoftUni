# Lab: Iterators and Comparators

## 1. Book
Create a class Book from the UML diagram below:

|  Book   |
|  ------- |
|  - title: String <br> - year: int <br>- authors: List<String>              |
|  - setTitle(String) <br> - setYear(String) <br> - setAuthors(String...) <br> + getTitle(): String <br> + getYear(): int <br> + getAuthors(): List<String>                |

## 2. Library
Create a class Library from the UML diagram below:

|  Library  |
|  ------- |
|  - books: Book[] <br> + iterator(): Iterator<Book>  |

|  LibIterator  |
|  ------- |
|  - counter: int <br> + hasNext(): boolean <br> + next(): Book |



## 3. Comparable Book

Expand Book by implementing Comparable.

The book has to be compared by title. When the title is equal, compare them by year.

Expand Book from UML diagram below:

|  Book   |
|  ------- |
|  - title: String <br> - year: int <br>- authors: List<String>              |
|  - setTitle(String) <br> - setYear(String) <br> - setAuthors(String...) <br> + getTitle(): String <br> + getYear(): int <br> + getAuthors(): List<String>   <br> + compareTo(Book): int             |

