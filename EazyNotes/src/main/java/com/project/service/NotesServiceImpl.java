package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Notes;
import com.project.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NoteService{
	
	@Autowired
	NotesRepository noteRepo;
	@Override
	public List<Notes> readAll() {
		return noteRepo.findAll();
	}
	@Override
	public Notes saveNote(Notes note) {
		return noteRepo.save(note);
		}
	@Override
	public Notes readNote(Long id) {
		return noteRepo.findById(id).orElseThrow(()->new RuntimeException("Note is not present for the id "+id));
		
	}
	@Override
	public void removeNote(Long id) {
		Notes existingNote = readNote(id);
		noteRepo.delete(existingNote);
		
	}

}
