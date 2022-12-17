import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artistName;
    //private String lyrics;

    ArrayList<Song> songs ;

    public Album(String name, String artistName) {
        this.name = name;
        this.artistName = artistName;
        this.songs = new ArrayList<>();  //mistake point
    }

    public boolean findSong(String title){
        for(Song song : songs) {
            if (song.getTitle().equals(title)) {
                return true;
            }
        }
          return false;
    }
    public void addSongToAlbum(String title, double duration){
           if(findSong(title) == true){
               System.out.println("Song is already exists");
           }
           else{
               Song newSong = new Song(title, duration);
               songs.add(newSong);
               System.out.println("Song has been added successfully");
           }
    }
    public void addToPlayList(String title, LinkedList<Song> playList){
           for(Song song : this.songs){
               if(song.getTitle().equals(title))
                   playList.add(song);
           }
    }
    public void addToPlayList(int trackNo, ArrayList<Song> playList){
                int index = trackNo-1;
                if(index >= 0 && index < songs.size()) {
                    //Getting song object
                    Song song = this.songs.get(index);
                    playList.add(song);
                }
         }
    }

