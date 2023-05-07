package edu.vandy.recommender.client;

import edu.vandy.recommender.common.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;

import java.io.IOException;
import java.util.List;

import static edu.vandy.recommender.utils.ExceptionUtils.rethrowSupplier;

/**
 * This class is a proxy to the {@code Movies} microservice.
 */
@Component
public class DatabaseSyncProxy {
    /**
     * Create an instance of the {@link DatabaseAPI} Retrofit client,
     * which is then used to making HTTP requests to the {@code
     * GatewayApplication} RESTful microservice.
     */
    @Autowired
    DatabaseAPI mDatabaseAPI;

    /**
     * Get a {@link List} containing the requested {@link Movie}
     * objects.
     *
     * @param route The microservice that performs the request, which
     *              is dynamically inserted into the URI via the
     *              {@code Path} annotation
     * @return An {@link Call} object that yields a {@link List}
     *         containing all the {@link Movie} objects on success and
     *         an error message on failure
     */
    List<Movie> getMovies(String route) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.getMovies(route).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * query {@link String}.
     *
     * @param route The microservice that performs the request
     * @param query The {@link String} to search for
     * @return An {@link Call} object that yields a {@link List}
     *         containing the {@link Movie} objects that match the
     *         {@code query} on success and an error message on
     *         failure
     */
    List<Movie> searchMovies(String route,
                             String query) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMovies(route, query).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * {@link List} of queries.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return An {@link Call} object that yields a {@link List}
     *         containing the {@link Movie} objects that match the
     *         {@code queries} on success and an error message on
     *         failure
     */
    List<Movie> searchMovies(String route,
                             List<String> queries) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMovies(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Get a {@link List} containing the requested {@link Movie}
     * objects.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request, which
     *              is dynamically inserted into the URI via the
     *              {@code Path} annotation
     * @return An {@link Call} object that yields a {@link List}
     *         containing all the {@link Movie} objects on success and
     *         an error message on failure
     */
    List<Movie> getMoviesTimed(String route) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.getMoviesTimed(route).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * query {@link String}.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request
     * @param query The {@link String} to search for
     * @return An {@link Call} object that yields a {@link List}
     *         containing the {@link Movie} objects that match the
     *         {@code query} on success and an error message on
     *         failure
     */
    List<Movie> searchMoviesTimed(String route,
                                  String query) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesTimed(route, query).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * {@link List} of queries.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return An {@link Call} object that yields a {@link List}
     *         containing the {@link Movie} objects that match the
     *         {@code queries} on success and an error message on
     *         failure
     */
    List<Movie> searchMoviesTimed(String route,
                                  List<String> queries) {
        // TODO -- you fill in here.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesTimed(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new IOException("Request failed: " + response.code());
            }
        }).get();
    }
}

