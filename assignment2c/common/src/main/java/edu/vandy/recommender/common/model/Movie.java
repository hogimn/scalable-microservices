package edu.vandy.recommender.common.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Movie title and vector as stored and returned from the database
 * microservice.
 */
@Entity
@Table(name = "MOVIE")
public class Movie
// Implement an interface that enables two Movie objects to be
// compared and checked for equality.
// TODO -- you fill in here
implements Comparable<Movie>
{
    /**
     * The movie name.
     */
    @Id
    public String id;

    /**
     * The encoding of the movie properties.
     */
    @SuppressWarnings("JpaAttributeTypeInspection")
    public List<Double> vector;

    /**
     * A default constructor is needed.
     */
    public Movie() {
    }

    /**
     * Initialize field in a {@link Movie}.
     */
    public Movie(String id, List<Double> vector) {
        this.id = id;
        this.vector = vector;
    }

    /**
     * Create a {@link Movie} from a {@link Map.Entry}.
     *
     * @param movie The {@link Map.Entry}
     */
    public Movie(Map.Entry<String, List<Double>> movie) {
        id = movie.getKey();
        vector = movie.getValue();
    }

    /**
     * Perform a case-insensitive comparison of this {@link Movie}
     * with the {@code other} {@link Movie} based on their IDs.
     *
     * @param other The {@link Movie} to compare to this {@link Movie}
     * @return A negative integer, zero, or a positive integer as this
     * movie's ID is less than, equal to, or greater than the
     * specified movie's ID (ignoring case)
     */
    // TODO -- you fill in here.
    @Override
    public int compareTo(Movie other) {
        return this.id.compareToIgnoreCase(other.id);
    }

    /**
     * Overrides the {@code equals()} method to compare two {@link
     * Movie} objects based on their {@code id} only.
     *
     * @param object The other {@link Object} to compare with this
     *              object
     * @return true if the object ids are equal, false otherwise
     */
    // TODO -- you fill in here.
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof Movie))
            return false;

        return this.id.equals(((Movie) object).id);
    }

    /**
     * @return A hash of the {@link Movie} {@code id} (title)
     */
    // TODO -- you fill in here.
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
