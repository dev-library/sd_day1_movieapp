package com.samsungdisplay.movie;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.samsungdisplay.movie.entity.Movie;
import com.samsungdisplay.movie.repository.MovieRepository;

@SpringBootApplication
public class MovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
	//여기부터
    @Bean
    public CommandLineRunner initData(MovieRepository movieRepository) {
        return args -> {
            List<Movie> movies = List.of(
                new Movie(null, "기생충", "봉준호", LocalDate.of(2019, 5, 30)),
                new Movie(null, "괴물", "봉준호", LocalDate.of(2006, 7, 27)),
                new Movie(null, "올드보이", "박찬욱", LocalDate.of(2003, 11, 21)),
                new Movie(null, "범죄와의 전쟁", "윤종빈", LocalDate.of(2012, 2, 2)),
                new Movie(null, "도둑들", "최동훈", LocalDate.of(2012, 7, 25)),
                new Movie(null, "암살", "최동훈", LocalDate.of(2015, 7, 22)),
                new Movie(null, "택시운전사", "장훈", LocalDate.of(2017, 8, 2)),
                new Movie(null, "7번방의 선물", "이환경", LocalDate.of(2013, 1, 23)),
                new Movie(null, "극한직업", "이병헌", LocalDate.of(2019, 1, 23)),
                new Movie(null, "서울의 봄", "김성수", LocalDate.of(2023, 11, 22))
            );
            movieRepository.saveAll(movies);
        };
    }
    // 여기까지 붙여넣기
}
