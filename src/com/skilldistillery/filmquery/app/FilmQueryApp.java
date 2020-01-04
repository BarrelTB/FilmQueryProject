package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}


	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("+----------------------------+");
		System.out.println("|Welcome to the Film DataBase|");
		System.out.println("+----------------------------+");
		System.out.println("|Please pick one option below|");
		System.out.println("+----------------------------+");
		System.out.println("|1. Look up a Film by Film ID|");
		System.out.println("|2. Look up a Film by keyword|");
		System.out.println("|3. Exit the Film Application|");
		System.out.println("+----------------------------+");
		int choice = input.nextInt();
		switch (choice) {
			case 1:
				filmById(input);
				break;
			case 2:
				filmByKeyword(input);
				break;
			case 3:
			default:
				System.out.println("+-------------------------------------------------+");
				System.out.println("|Thank you for using our Film DataBase Application|");
				System.out.println("+-------------------------------------------------+");
				break;
		}
	}

	private void filmById(Scanner input) {
		boolean notValid = true;
		while (notValid) {
			System.out.println("+---------------------------------------+");
			System.out.println("|Please enter any Film ID you would like|");
			System.out.println("+---------------------------------------+");
			int filmId = input.nextInt();

			Film film = db.findFilmById(filmId);
			if (film == null) {
				System.out.println("+---------------------------+");
				System.out.println("|That is not a valid Film ID|");
				System.out.println("|Please enter another number|");
				System.out.println("+---------------------------+");
				notValid = true;
			} else {
				System.out.println(film);
				System.out.println("Actors In Film: ");
				for (Actor actor : film.getlActor()) {
					System.out.println(actor);
				}
				notValid = false;
				
			}
		}

	}

	private void filmByKeyword(Scanner input) {
		boolean notValid = true;
		List<Film> films = new ArrayList<>();
		while (notValid) {
			System.out.println("+---------------------------------------+");
			System.out.println("|Please enter any Keyword you would like|");
			System.out.println("+---------------------------------------+");
			String keyWord = input.next();

			films = db.findFilmByKeyWord(keyWord);
			if (films.isEmpty()) {
				System.out.println("+---------------------------+");
				System.out.println("|That is not a valid Keyword|");
				System.out.println("|Please type another Keyword|");
				System.out.println("+---------------------------+");
				notValid = true;
			} else {
				for (Film film2 : films) {
					System.out.println(film2);
					System.out.println("Actors In Film: ");
					for (Actor actor : film2.getlActor()) {
						System.out.println(actor);
					}
				}
				notValid = false;
				
			}
		}

	}

//	private void test() {
		// TEST for FIND FILM BY ID
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    System.out.println("Actors In Film: ");
//    for (Actor actor : film.getlActor()) {
//		System.out.println(actor);
//	}
		
		// TEST for FIND ACTOR BY ID
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    System.out.println("Films by Actor:");
//    for(Film film: actor.getFilms()) {
//    	System.out.println(film);
//    	System.out.println();
//    }
		
		// TEST for FIND ACTORS BY FILM ID
//    List<Actor> lactor = new ArrayList<>();
//    lactor = db.findActorsByFilmId(1);
//    for (Actor actor : lactor) {
//		System.out.println(actor);
//	}
		
		// TEST for FIND FILMS BY ACTOR ID
//	  List<Film> lFilm = new ArrayList<>();
//	  lFilm = db.findFilmsByActorId(1);
//	  for (Film film : lFilm) {
//		System.out.println(film);
//		System.out.println();
//	}
//	}
}
