package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Notes;
import com.project.service.NoteService;

@CrossOrigin("*")
@RestController
public class NotesController {
	
	@Autowired
	NoteService notesServ;
	
	@GetMapping("/notes")
	public List<Notes> getNotes(){
		return notesServ.readAll();
		
	}
	
	@PostMapping("/notes")
	public Notes addNote(@RequestBody Notes note) {
		return notesServ.saveNote(note);
	}
	
	@GetMapping("/notes/{id}")
	public Notes getNote(@PathVariable Long id) {
		return notesServ.readNote(id);
	}
	
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long id){
		notesServ.removeNote(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		
	}
	
	@PutMapping("/notes")
	public Notes updatedNote(@RequestBody Notes updatedNotes) {
		return notesServ.saveNote(updatedNotes);
	}

}
