package qapitol.demo.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qapitol.demo.app.entity.Blogger;
import qapitol.demo.app.repository.BloggerRepository;

@RestController
@RequestMapping("/blogger")
public class DemoController {

	@Autowired
	BloggerRepository bloggerRepository;

	@GetMapping("/")
	public ResponseEntity<List<Blogger>> allblogger() {
		List<Blogger> allblogger = bloggerRepository.findAll();
		System.out.println(ResponseEntity.status(200).body(allblogger));
		return ResponseEntity.status(200).body(allblogger);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Blogger> oneblogger(@PathVariable("id") Integer id) {
		if (bloggerRepository.exists(id)) {
			return ResponseEntity.status(200).body(bloggerRepository.findOne(id));
		} else {
			return ResponseEntity.status(404).build();
		}
	}

	@PostMapping()
	public ResponseEntity<Blogger> saveArticle(@RequestBody Blogger blogger) {
		return ResponseEntity.status(201).body(bloggerRepository.save(blogger));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity changearticle(@RequestBody Blogger blogger, @PathVariable int id) {

		if (bloggerRepository.exists(id) == true) {
			return ResponseEntity.status(200).body(bloggerRepository.save(blogger));
		} else {
			return ResponseEntity.status(404).build();
		}

	}

	@DeleteMapping(path = "/{id}")
	public boolean deletearticle(@PathVariable("id") Integer id) {
		boolean response = false;
		if (bloggerRepository.exists(id)) {
			bloggerRepository.delete(id);
			response = true;
		}
		return response;
	}

}
