package ch16.exam;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PhotoAlbum {
    private List<Photo> album;

    public void addPhoto(Photo photo, Consumer<Photo> consumer) {
        consumer.accept(photo);
    }

    public void printFiltered(Predicate<Photo> filter, Consumer<Photo> printer) {

    }
}
