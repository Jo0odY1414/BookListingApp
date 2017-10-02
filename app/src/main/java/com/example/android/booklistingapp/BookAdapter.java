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

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

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
    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.book_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        // Find the book at the given position
        Book currentBook = getItem(position);

        // Display the title of the current book in that TextView
        holder.titleTextView.setText(currentBook.getTitle());

        // Get all authors and concat it  with "by" word
        String allAuthors = "by " + String.valueOf(currentBook.getStringOfAllAuthors());
        // Display the author/s of the current book in that TextView
        holder.authorsTextView.setText(allAuthors);

        // Concat number of pages with "pages" word
        String pageCount = String.valueOf(currentBook.getPageCount()) + " pages";
        // Display the number of pages of the current book in that TextView
        holder.pageCountTextView.setText(pageCount);


        if (currentBook.hasImage()) {
            // Display the book image of the current book in that ImageView
            Picasso.with(getContext()).load(currentBook.getImageUrl()).into(holder.imageView);
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        // Return the view that is now showing the appropriate data
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.title_text_view)
        TextView titleTextView;
        @BindView(R.id.authors_text_view)
        TextView authorsTextView;
        @BindView(R.id.pages_count_text_view)
        TextView pageCountTextView;
        @BindView(R.id.book_image_view)
        ImageView imageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
