import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Demo {
    //clase Song
    public static class Song {
        private static int counter = 0; //Variable que incrementará conforme se agreguen canciones
        public int id;
        public String name;
        public int duration; //en segundos
        public Song (String name, int duration){
            this.id = ++counter; //Se le asignará el contador para que cada canción tenga un id distinto
            this.name = name;
            this.duration = duration;
        }

        public String getNombre(){
            return name;
        }

        public int getDuration(){
            return duration;
        }
    }

    //Generar arbol binario
    public static class TreeSong {
        Song cancion;
        TreeSong left;
        TreeSong right;

        public TreeSong(Song cancion){
            this.cancion = cancion;
            this.left = null;
            this.right = null;
        }
    }

    public static class MusicTree {
        private TreeSong root;

        public MusicTree(){
            root = null;
        }

        
    }

    //agregarCancion(song)
    public static class MusicPlayList {
        private List<Song> songs;

        public MusicPlayList(){
            songs = new ArrayList<>();
        }

        public void agregarCancion(Song cancion){
            songs.add(cancion); //Arreglo que irá agregando las canciones a una playlist
        }

        public List<Song> obtenerSongs(){
            return songs; //Retorna todas las canciones de la Playlist
        }

        //ordenPoNombre()
        public List<Song> ordenPorNombre(){
            Collections.sort(songs, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    return s1.getNombre().compareToIgnoreCase(s2.getNombre());
                }
            });

            return songs;
        }

        public List<Song> ordenPorDuracion(){
            Collections.sort(songs, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    return Integer.compare(s1.getDuration(), s2.getDuration());
                }
            });

            return songs;
        }

    }

    //crearArbol(songs)

     
    public static void main(String[] args){

        MusicPlayList Playlist = new MusicPlayList();

        //Caso de Prueba
        //Crear cancion 1 y 2
        Song song1 = new Song("Ares", 205); 
        Song song2 = new Song("Ansiedad", 180);

        //Agregar a la Playlist
        Playlist.agregarCancion(song1); 
        Playlist.agregarCancion(song2);

        //Mostrar la Playlist
        /*List<Song> Canciones = Playlist.obtenerSongs();
        System.out.println("Aquí está la Playlist!");
        System.out.println("");
        for (Song cancion : Canciones){
            System.out.println("Nombre: " + cancion.name + ", Duracion: " + cancion.duration + " segs.");
        }*/

        System.out.println("");
        //Mostrar la Playlist en orden lexicografico
        /*List<Song> sortedSongs = Playlist.ordenPorNombre();
        //imprimir las canciones por orden
        System.out.println("Aquí están las canciones en orden!");
        System.out.println("");
        for(Song song : sortedSongs) {
            System.out.println(song.getNombre());
        }*/

        //* * * * * * * * * * * * * * * * *
        Integer op;
        //Opciones, mostrar la playlist, mostrar por orden lex y duracion
        Scanner scanner = new Scanner (System.in);
        System.out.println("Bienvenido a Mussa!! Qué deseas hacer?");
        System.out.println("");
        System.out.println("1. Mostrar tu playList!");
        op = scanner.nextInt();
        
            if(op == 1){
                System.out.println("Ok! elige una opcion!");
                System.out.println("1. Playlist completa");
                System.out.println("2. Orden por nombre");
                System.out.println("3. Orden por duración");
                op = scanner.nextInt();

                if(op == 1) {
                    List<Song> Canciones = Playlist.obtenerSongs();
                    System.out.println("Aquí está la Playlist!");
                    System.out.println("");
                    for (Song cancion : Canciones){
                    System.out.println("Nombre: " + cancion.name + ", Duracion: " + cancion.duration + " segs.");
                    }
                } else if (op == 2) {
                    List<Song> sortedSongs = Playlist.ordenPorNombre();
                    System.out.println("Aquí están las canciones en orden!");
                    System.out.println("");
                    for(Song song : sortedSongs) {
                    System.out.println("Nombre: "+ song.getNombre() + " / " + "Duración: "+ song.getDuration() + " segundos.");
                    }
                } else if (op == 3) {
                    List<Song> sortedNumSongs = Playlist.ordenPorDuracion();
                    System.out.println("Aquí están las canciones en orden por su duración!");
                    System.out.println("");
                    for(Song song: sortedNumSongs) {
                        System.out.println("Nombre: "+ song.getNombre() + " / " + "Duración: "+ song.getDuration() + " segundos.");
                    }
                }
            }

    }
}
