package com.codingdojo.lookify.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;


@Service
public class SongService {
   private final SongRepository songRepository;
    
   public SongService(SongRepository songRepository) {
	   this.songRepository = songRepository;
   }
   public List<Song> allSongs() {
	   return songRepository.findAll();
   }
   
	public Song createSong(Song a) {
		return songRepository.save(a);
	}
	
   public Song findSong(Long id) {
	   Optional<Song> optionalSong = songRepository.findById(id);
       if(optionalSong.isPresent()) {
           return optionalSong.get();
       } 
       else {
           return null;
       		}
    }
   
   public void deleteSong(Long id) {
	   songRepository.deleteById(id);
   }
   public List<Song> findTopTen(){
   return this.songRepository.findTop10ByOrderByRatingDesc();
   }
   
   public List<Song> songsByArtist(String artist){
		 return songRepository.findSongsByArtistContaining(artist);
}
  
}

