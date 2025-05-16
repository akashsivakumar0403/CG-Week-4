import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " (Rating = " + rating + ")";
    }

    public double getRating() {
        return rating;
    }
}

public class BookRecommender {
    public static List<List<BookRecommendation>> paginate(List<BookRecommendation> books, int pageSize) {
        List<List<BookRecommendation>> pages = new ArrayList<>();
        for (int i = 0; i < books.size(); i += pageSize) {
            pages.add(books.subList(i, Math.min(i + pageSize, books.size())));
        }
        return pages;
    }

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.4),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.1),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.8),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 3.9),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.3),
                new Book("1984", "George Orwell", "Science Fiction", 4.7),
                new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.0),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.2),
                new Book("Solaris", "Stanislaw Lem", "Science Fiction", 4.3)
        );

        List<Book> filtered = books.stream().filter(b -> b.getGenre().equalsIgnoreCase("Science Fiction") && b.getRating() > 4.0).collect(Collectors.toList());

        List<BookRecommendation> recommendations = filtered.stream().map(b -> new BookRecommendation(b.getTitle(), b.getRating())).collect(Collectors.toList());

        recommendations.sort(Comparator.comparingDouble(BookRecommendation::getRating).reversed());

        List<BookRecommendation> top10 = recommendations.stream().limit(10).collect(Collectors.toList());

        List<List<BookRecommendation>> pages = paginate(top10, 5);

        for (int i = 0; i < pages.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            pages.get(i).forEach(System.out::println);
        }
    }
}
