import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    //Creating Arraylist as albums
    public static ArrayList<Album> albums = new ArrayList<>();

    //Main method
    public static void main(String[] args) {

        //Creating album1
        Album album = new Album("Album1","AC/DC");

        //adding song to album
        album.addSongToAlbum("TNT",4.5);
        album.addSongToAlbum("Highway to hell",3.5);
        album.addSongToAlbum("ThunderStruck",5.0);
        albums.add(album); //adding album to arraylist

        //Creating album2
        album = new Album("Album2","Eminem");

        //adding song to album
        album.addSongToAlbum("Rap god",4.5);
        album.addSongToAlbum("Not Afraid",3.5);
        album.addSongToAlbum("Lose yourself",4.5);
        albums.add(album); //adding album to arraylist

        //Creating playlist1
        LinkedList<Song> playList_1 = new LinkedList<>();

        //getting song from albums(arraylist) and adding at playlist
        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway to hell",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList("Lose yourself",playList_1);
        play(playList_1); //Calling play method

    }

    private static void play(LinkedList<Song> playList) {
        printMenu();
        ListIterator<Song> listIterator = playList.listIterator();
        boolean forward = true; //one step ahead already

        if(playList.size() > 0){
            System.out.println("Playing the first song");
            System.out.println(listIterator.next().toString());

        }else{
            System.out.println("Playlist is empty");
            return;
        }
        System.out.println("Enter your option: ");
        boolean quit = false;
        Scanner sc = new Scanner(System.in);

        while(!quit){
            int option = sc.nextInt();

            switch(option) {
                case 0:
                    quit = true;
                    break;

                case 1:  //playing next song
                    if (forward == false) {
                        listIterator.next();
                        forward = true;
                    } else if (listIterator.hasNext()) {
                        System.out.println("Next song" + listIterator.next().toString());
                        forward = true;
                    } else {
                        System.out.println("You are at the last song");
                        forward = false;
                    }
                    break;

                case 2:  //playing previous song
                    if (forward == true) { //extra 1 step ahead
                        listIterator.previous(); //back to 1 step
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Playing previous song" + listIterator.previous().toString());
                        forward = false;
                    } else {
                        System.out.println("You are at first song");
                        forward = false;
                    }
                    break;

                case 3: //to replay the current song
                    if (forward == true) {
                        if (listIterator.hasPrevious()) { //checking either more song present in prev or not
                            System.out.println("Repeating the current song" + listIterator.previous().toString());
                            forward = false;
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Repeating the current song" + listIterator.next().toString());
                            forward = true;
                        }
                    }
                    break;

                case 4:   //list of all songs
                    System.out.println("List of all songs");
                    printSongs(playList);
                    break;
                case 5:   //print all available options
                    System.out.println("Printing all available options : ");
                    printMenu();
                //case 6:   //deleting current song
            }
        }
    }
    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList){
            System.out.println(song.toString()+" ");
        }
    }

    private static void printMenu(){
            System.out.println("Available options\n press");
            System.out.println("0 - to quit\n"+
                    "1 - to play next song\n"+
                    "2 - to play previous song\n"+
                    "3 - to replay the current song\n"+
                    "4 - list of all songs \n"+
                    "5 - print all available options\n"+
                    "6 - delete current song");
    }
}