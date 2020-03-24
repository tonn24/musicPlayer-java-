package com.company;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("ATLiens", "Outkast");
        album.addSong("You May Die(Intro)", 1.05);
        album.addSong("Two Dope Boyz (In a Cadillac)", 2.46);
        album.addSong("ATLiens", 3.50);
        album.addSong("Wheelz of Steel", 4.03);
        album.addSong("Jazzy Belle", 4.12);
        albums.add(album);

        album = new Album("Stankonia", "Outkast");
        album.addSong("Gasoline Dreams", 3.34);
        album.addSong("So Fresh, So Clean", 4.00);
        album.addSong("Ms. Jackson", 3.50);
        album.addSong("B.O.B.", 4.00);
        album.addSong("Jazzy Belle", 4.12);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("ATLiens", playlist);
        albums.get(0).addToPlaylist("Elevators", playlist); //Does not exist
        albums.get(0).addToPlaylist(5, playlist);
        albums.get(0).addToPlaylist(3, playlist);
        albums.get(0).addToPlaylist(4, playlist);
        albums.get(0).addToPlaylist(2, playlist);

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner s = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if(playlist.size() == 0) {
            System.out.println("No songs in playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit) {
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if(!forward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                    }
                    break;
                case 2:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Current song is " + listIterator.previous().toString());
                    } else {
                        System.out.println("You have reached to the beginning of the list");
                        forward = true;
                    }
                    break;
                case 3:
                    if(forward) {
                        if(listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if(listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if(playlist.size() > 0) {
                        listIterator.remove();
                        if(listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if(listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list songs int the playlist\n" +
                "5 - print available actions" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playlist) {
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("==============================");
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("==============================");
    }
}
