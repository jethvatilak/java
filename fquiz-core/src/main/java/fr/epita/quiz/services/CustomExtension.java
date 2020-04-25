package fr.epita.quiz.services;

import java.io.IOException;

public class CustomExtension extends IOException {
	public CustomExtension(String message) {
		super(message);
	}
}

