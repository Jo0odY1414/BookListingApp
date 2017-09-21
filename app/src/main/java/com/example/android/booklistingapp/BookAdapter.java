package com.example.android.booklistingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Mj0o0oD on 17/09/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {



    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        if(currentBook.hasImage()){
            // Find the ImageView with view ID book image
            ImageView bookImageView = listItemView.findViewById(R.id.book_image_view);
            // Display the book image of the current book in that ImageView
            Picasso.with(getContext()).load(currentBook.getImageUrl()).into(bookImageView);
        }

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Display the title of the current book in that TextView
        titleView.setText(String.valueOf(currentBook.getTitle()));

        // Find the TextView with view ID author/s
        TextView authorsView = (TextView) listItemView.findViewById(R.id.authors_text_view);
        // Get all authors and concat it  with "by" word
        String allAuthors = "by " + String.valueOf(currentBook.getStringOfAllAuthors());
        // Display the author/s of the current book in that TextView
        authorsView.setText(allAuthors);

        // Find the TextView with view ID pageCount
        TextView pageCountView = (TextView) listItemView.findViewById(R.id.pages_count_text_view);
        // Concat number of pages with "pages" word
        String pageCount = String.valueOf(currentBook.getPageCount()) + " pages";
        // Display the author/s of the current book in that TextView
        pageCountView.setText(pageCount);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
