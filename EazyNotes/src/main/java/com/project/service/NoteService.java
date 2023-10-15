package com.project.service;

import java.util.List;

import com.project.entity.Notes;

public interface NoteService {
	
	List<Notes> readAll();
	Notes saveNote(Notes note);
	Notes readNote(Long id);
	void removeNote(Long id);

}
