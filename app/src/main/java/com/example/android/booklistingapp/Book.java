package com.example.android.booklistingapp;

/**
 * Created by Mj0o0oD on 16/09/2017.
 */

public class Book {

    /**
     * Constant value that represents no image was provided for this book
     */
    private static final String NO_IMAGE_URL_PROVIDED = "None";

    /**
     * Title of the book
     */
    private String title;

    /**
     * Author/s name/s of the book
     */
    private String[] authors;

    /**
     * Number of pages in the book
     */
    private int pageCount;

    /**
     * Image's URL of the book
     */
    private String imageUrl = "None";

    /**
     * Website URL of the book
     */
    private String url;

    /**
     * Constructs a new {@link Book} object.
     *
     * @param bookTitle is the title of the book
     * @param bookAuthors is the author/s who/s wrote the book
     * @param bookPageCount is the number of pages in the book
     * @param bookImageUrl is the image URL of the book
     * @param bookUrl is the book URL to find more details about the book
     */
    public Book(String bookTitle, String[] bookAuthors, int bookPageCount, String bookImageUrl, String bookUrl) {
        title = bookTitle;
        authors = bookAuthors;
        pageCount = bookPageCount;
        imageUrl = bookImageUrl;
        url = bookUrl;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the author/s of the book.
     */
    public String[] getAuthors() {
        return authors;
    }

    /**
     * Returns the number of pages in the book.
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Returns the image URL of the book.
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * Returns the website URL to find more information about the book.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Returns only one String of all authors
     */
    public String getStringOfAllAuthors() {

        if (authors != null && authors.length > 1) {
            String allAuthors = "";
            for (String author : authors) {
                if (allAuthors.equals(""))
                    allAuthors += author;
                else
                    allAuthors += ", " + author;
            }
            return allAuthors;
        } else if (authors != null && authors.length == 1)
            return authors[0];
        else
            return "";
    }

    /**
     * Returns whether or not there is an image for this book.
     */
    public boolean hasImage() {
        return !(imageUrl.equalsIgnoreCase(NO_IMAGE_URL_PROVIDED)) && !(imageUrl.isEmpty());
    }
}
