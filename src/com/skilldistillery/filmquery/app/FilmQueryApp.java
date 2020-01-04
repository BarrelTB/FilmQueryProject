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
    app.test();
//    app.launch();
  }

  private void test() {
	  //TEST for FIND FILM BY ID
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//    System.out.println("Actors In Film: ");
//    for (Actor actor : film.getlActor()) {
//		System.out.println(actor);
//	}
	  
	  //TEST for FIND ACTOR BY ID
//    Actor actor = db.findActorById(1);
//    System.out.println(actor);
//    System.out.println("Films by Actor:");
//    for(Film film: actor.getFilms()) {
//    	System.out.println(film);
//    	System.out.println();
//    }
	  
	  //TEST for FIND ACTORS BY FILM ID
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
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    
  }

}
