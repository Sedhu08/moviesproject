package com.example.moviedb.config;

import com.example.moviedb.domain.CastMember;
import com.example.moviedb.domain.Genre;
import com.example.moviedb.domain.Movie;
import com.example.moviedb.repository.CastMemberRepository;
import com.example.moviedb.repository.GenreRepository;
import com.example.moviedb.repository.MovieRepository;

import jakarta.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@Component
public class DataSeeder implements CommandLineRunner {

        private final MovieRepository movieRepository;
        private final GenreRepository genreRepository;
        private final CastMemberRepository castMemberRepository;

        public DataSeeder(MovieRepository movieRepository, GenreRepository genreRepository,
                        CastMemberRepository castMemberRepository) {
                this.movieRepository = movieRepository;
                this.genreRepository = genreRepository;
                this.castMemberRepository = castMemberRepository;
        }

        @Override
        @Transactional
        public void run(String... args) throws Exception {
                if (movieRepository.count() == 0) {

                        Genre action = genreRepository.save(new Genre(null, "Action"));
                        Genre sciFi = genreRepository.save(new Genre(null, "Sci-Fi"));
                        Genre drama = genreRepository.save(new Genre(null, "Drama"));
                        Genre thriller = genreRepository.save(new Genre(null, "Thriller"));
                        Genre comedy = genreRepository.save(new Genre(null, "Comedy"));
                        Genre horror = genreRepository.save(new Genre(null, "Horror"));
                        Genre animation = genreRepository.save(new Genre(null, "Animation"));
                        Genre adventure = genreRepository.save(new Genre(null, "Adventure"));

                        CastMember keanuReeves = castMemberRepository
                                        .save(new CastMember(null, "Keanu Reeves", "Actor"));
                        CastMember laurenceFishburne = castMemberRepository
                                        .save(new CastMember(null, "Laurence Fishburne", "Actor"));
                        CastMember leonardoDiCaprio = castMemberRepository
                                        .save(new CastMember(null, "Leonardo DiCaprio", "Actor"));
                        CastMember tomHanks = castMemberRepository.save(new CastMember(null, "Tom Hanks", "Actor"));
                        CastMember bradPitt = castMemberRepository.save(new CastMember(null, "Brad Pitt", "Actor"));
                        CastMember morganFreeman = castMemberRepository
                                        .save(new CastMember(null, "Morgan Freeman", "Actor"));
                        CastMember jonahHill = castMemberRepository.save(new CastMember(null, "Jonah Hill", "Actor"));
                        CastMember heathLedger = castMemberRepository
                                        .save(new CastMember(null, "Heath Ledger", "Actor"));
                        CastMember christianBale = castMemberRepository
                                        .save(new CastMember(null, "Christian Bale", "Actor"));
                        CastMember mattDamon = castMemberRepository.save(new CastMember(null, "Matt Damon", "Actor"));
                        CastMember natPortman = castMemberRepository
                                        .save(new CastMember(null, "Natalie Portman", "Actress"));
                        CastMember cateBlanchett = castMemberRepository
                                        .save(new CastMember(null, "Cate Blanchett", "Actress"));
                        CastMember jodieFoster = castMemberRepository
                                        .save(new CastMember(null, "Jodie Foster", "Actress"));
                        CastMember anthonyHopkins = castMemberRepository
                                        .save(new CastMember(null, "Anthony Hopkins", "Actor"));
                        CastMember willSmith = castMemberRepository.save(new CastMember(null, "Will Smith", "Actor"));
                        CastMember robertDowneyJr = castMemberRepository
                                        .save(new CastMember(null, "Robert Downey Jr.", "Actor"));
                        CastMember scarJohansson = castMemberRepository
                                        .save(new CastMember(null, "Scarlett Johansson", "Actress"));

                        save(movieRepository, "The Matrix",
                                        "A computer hacker learns about the true nature of his reality and his role in the war against its controllers.",
                                        LocalDate.of(1999, 3, 31), 8.7,
                                        Set.of(action, sciFi), Set.of(keanuReeves, laurenceFishburne));

                        save(movieRepository, "John Wick",
                                        "An ex-hit-man comes out of retirement to track down the gangsters that killed his dog.",
                                        LocalDate.of(2014, 10, 24), 7.4,
                                        Set.of(action, drama), Set.of(keanuReeves));

                        save(movieRepository, "Inception",
                                        "A thief who steals corporate secrets through dream-sharing technology is given the task of planting an idea.",
                                        LocalDate.of(2010, 7, 16), 8.8,
                                        Set.of(sciFi, thriller), Set.of(leonardoDiCaprio));

                        save(movieRepository, "Forrest Gump",
                                        "The life story of a man with a low IQ but good intentions running through several decades of American history.",
                                        LocalDate.of(1994, 7, 6), 8.8,
                                        Set.of(drama, comedy), Set.of(tomHanks));

                        save(movieRepository, "Fight Club",
                                        "An insomniac office worker and a devil-may-care soap maker form an underground fight club.",
                                        LocalDate.of(1999, 10, 15), 8.8,
                                        Set.of(drama, thriller), Set.of(bradPitt));

                        save(movieRepository, "Se7en",
                                        "Two detectives, a rookie and a veteran, hunt a serial killer who uses the seven deadly sins as motives.",
                                        LocalDate.of(1995, 9, 22), 8.6,
                                        Set.of(thriller, horror), Set.of(bradPitt, morganFreeman));

                        save(movieRepository, "The Wolf of Wall Street",
                                        "Based on the true story of Jordan Belfort, from his rise to a wealthy stockbroker to his fall involving corruption.",
                                        LocalDate.of(2013, 12, 25), 8.2,
                                        Set.of(drama, comedy), Set.of(leonardoDiCaprio, jonahHill));

                        save(movieRepository, "The Dark Knight",
                                        "When the menace known as the Joker emerges, Batman must accept one of the greatest psychological tests of his ability to fight injustice.",
                                        LocalDate.of(2008, 7, 18), 9.0,
                                        Set.of(action, thriller, drama), Set.of(heathLedger, christianBale));

                        save(movieRepository, "The Martian",
                                        "An astronaut becomes stranded on Mars after his team assumes him dead and must rely on his ingenuity to survive.",
                                        LocalDate.of(2015, 10, 2), 8.0,
                                        Set.of(sciFi, adventure), Set.of(mattDamon));

                        save(movieRepository, "Black Swan",
                                        "A committed dancer wins the role of a lifetime only to find herself slowly losing her mind.",
                                        LocalDate.of(2010, 12, 3), 8.0,
                                        Set.of(drama, thriller, horror), Set.of(natPortman));

                        save(movieRepository, "The Lord of the Rings: The Fellowship of the Ring",
                                        "A hobbit shares an adventurous journey with a fellowship to destroy a powerful ring and save Middle-earth.",
                                        LocalDate.of(2001, 12, 19), 8.8,
                                        Set.of(adventure, drama), Set.of(cateBlanchett));

                        save(movieRepository, "The Silence of the Lambs",
                                        "A young FBI cadet must receive the help of an incarcerated and manipulative cannibal killer to catch another serial killer.",
                                        LocalDate.of(1991, 2, 14), 8.6,
                                        Set.of(thriller, horror), Set.of(jodieFoster, anthonyHopkins));

                        save(movieRepository, "Interstellar",
                                        "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
                                        LocalDate.of(2014, 11, 7), 8.6,
                                        Set.of(sciFi, drama), Set.of(mattDamon));

                        save(movieRepository, "Pulp Fiction",
                                        "The lives of two mob hitmen, a boxer, a gangster and his wife intertwine in four tales of violence and redemption.",
                                        LocalDate.of(1994, 10, 14), 8.9,
                                        Set.of(drama, thriller), Set.of(bradPitt));

                        save(movieRepository, "The Pursuit of Happyness",
                                        "A struggling salesman takes custody of his son as he's poised to begin a life-changing professional endeavor.",
                                        LocalDate.of(2006, 12, 15), 8.0,
                                        Set.of(drama), Set.of(willSmith));

                        save(movieRepository, "Iron Man",
                                        "After being held captive in an Afghan cave, an engineer builds a mechanized suit of armor to escape and becomes a superhero.",
                                        LocalDate.of(2008, 5, 2), 7.9,
                                        Set.of(action, sciFi), Set.of(robertDowneyJr, scarJohansson));

                        save(movieRepository, "The Avengers",
                                        "Earth's mightiest heroes must come together and learn to fight as a team to stop the mischievous Loki.",
                                        LocalDate.of(2012, 5, 4), 8.0,
                                        Set.of(action, sciFi), Set.of(robertDowneyJr, scarJohansson));

                        save(movieRepository, "Toy Story",
                                        "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him as top toy in a boy's room.",
                                        LocalDate.of(1995, 11, 22), 8.3,
                                        Set.of(animation, comedy, adventure), Set.of(tomHanks));

                        save(movieRepository, "Shutter Island",
                                        "In 1954, a U.S. Marshal investigates the disappearance of a murderer who escaped from a hospital for the criminally insane.",
                                        LocalDate.of(2010, 2, 19), 8.1,
                                        Set.of(thriller, horror, drama), Set.of(leonardoDiCaprio));

                        save(movieRepository, "Cast Away",
                                        "A FedEx executive must transform himself physically and emotionally to survive a crash landing on a deserted island.",
                                        LocalDate.of(2000, 12, 22), 7.8,
                                        Set.of(drama, adventure), Set.of(tomHanks));

                        save(movieRepository, "Good Will Hunting",
                                        "Will Hunting, a janitor at MIT, has a gift for mathematics but needs help from a therapist to find direction in his life.",
                                        LocalDate.of(1997, 12, 5), 8.3,
                                        Set.of(drama), Set.of(mattDamon));

                        save(movieRepository, "The Shawshank Redemption",
                                        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                                        LocalDate.of(1994, 10, 14), 9.3,
                                        Set.of(drama), Set.of(morganFreeman));
                }
        }

        private void save(MovieRepository repo,
                        String title, String description,
                        LocalDate releaseDate, double rating,
                        Set<Genre> genres, Set<CastMember> cast) {
                Movie m = new Movie();
                m.setTitle(title);
                m.setDescription(description);
                m.setReleaseDate(releaseDate);
                m.setRating(rating);
                m.setGenres(genres);
                m.setCast(cast);
                repo.save(m);
        }
}
