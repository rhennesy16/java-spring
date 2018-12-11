package com.codingdojo.lookify.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
        this.songService = songService;
    }

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
        List<Song> songs = songService.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        this.songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id")Long id,Model model) {
		Song songinfo = songService.findSong(id);
		model.addAttribute("song", songinfo);
		return "song.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong() {
		return "new.jsp";
	}
	
	@RequestMapping(value="/songs/new", method= RequestMethod.POST)
	public String makeSong(@RequestParam(value="title")String title,@RequestParam(value="artist")String artist, @RequestParam(value="rating")int rating) {
		Song song = new Song(title,artist,rating);
		songService.createSong(song);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value="/search", method= RequestMethod.POST)
	public String search (@RequestParam(value= "artist")String artist) {
		return "redirect:/search/" +artist;
	}
	
	@RequestMapping("/search/{artist}")
    public String artistSearch(@PathVariable("artist") String artist, Model model) {
        List<Song> songs = songService.songsByArtist(artist);
        model.addAttribute("songs", songs);
        model.addAttribute("artist",artist);
        return "search.jsp";
	}
	
	@RequestMapping("/trending")
    public String trending(Model model) {
        List<Song> songs = songService.findTopTen();
        model.addAttribute("songs", songs);
        return "trending.jsp";
	}
}
	
	
	
	

