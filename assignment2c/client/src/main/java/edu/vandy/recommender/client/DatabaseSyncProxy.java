package edu.vandy.recommender.client;

import edu.vandy.recommender.common.Movie;
import edu.vandy.recommender.utils.CallUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

import static edu.vandy.recommender.utils.ExceptionUtils.rethrowSupplier;

/**
 * This class is a proxy to the {@code Database} microservice.
 */
@Component
@ComponentScan("edu.vandy.recommender")
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
     * objects on success or throws {@link IOException} on failure.
     *
     * @param route The microservice that performs the request, which
     *              is dynamically inserted into the URI via the
     *              {@code Path} annotation
     * @return A {@link List} containing all the {@link Movie} objects
     *         on success.
     */
    List<Movie> getMovies(String route) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.
        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.getMovies(route).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * query {@link String} on success or throws {@link IOException}
     * on failure.
     *
     * @param route The microservice that performs the request
     * @param query The {@link String} to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match the {@code query} on success
     */
    List<Movie> searchMovies(String route,
                             String query) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.
        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMovies(route, query).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing any given
     * {@link List} of queries on success or throws {@link
     * IOException} failure.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match any {@code queries} on success and an error
     *         message on failure
     */
    List<Movie> searchMovies(String route,
                             List<String> queries) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.
        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMovies(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing all given
     * {@link List} of queries on success or throws {@link
     * IOException} failure.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match all {@code queries} on success and an error
     *         message on failure
     */
    List<Movie> searchMoviesEx(String route,
                               List<String> queries) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesEx(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Get a {@link List} containing the requested {@link Movie}
     * objects on success or throws {@link IOException} on failure.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request, which
     *              is dynamically inserted into the URI via the
     *              {@code Path} annotation
     * @return A {@link List} containing all the {@link Movie} objects
     *         on success
     */
    List<Movie> getMoviesTimed(String route) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.getMoviesTimed(route).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing the given
     * query {@link String} on success or throws {@link IOException}
     * on failure.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request
     * @param query The {@link String} to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match the {@code query} on success
     */
    List<Movie> searchMoviesTimed(String route,
                                  String query) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesTimed(route, query).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing any given
     * {@code queries} in the {@link List} on success or throws {@link
     * IOException} on failure.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match any {@code queries} on success
     */
    List<Movie> searchMoviesTimed(String route,
                                  List<String> queries) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesTimed(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }

    /**
     * Search for movie titles in the database containing all given
     * {@code queries} in the {@link List} on success or throws {@link
     * IOException} on failure.
     *
     * This endpoint also records the execution run time of this call
     * via the {@code Timer} microservice.
     *
     * @param route The microservice that performs the request
     * @param queries The {@link List} queries to search for
     * @return A {@link List} containing the {@link Movie} objects
     *         that match all {@code queries} on success
     */
    List<Movie> searchMoviesExTimed(String route,
                                    List<String> queries) {
        // TODO -- you fill in here by replacing 'return null' with
        // the appropriate helper method provided by CallUtils.

        return rethrowSupplier(() -> {
            var response = mDatabaseAPI.searchMoviesExTimed(route, queries).execute();
            if (response.isSuccessful()) {
                return response.body();
            } else {
                throw new RuntimeException("Request failed: " + response.code());
            }
        }).get();
    }
}


