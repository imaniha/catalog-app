package org.akt.demo;

import org.akt.domain.Book;
import org.akt.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testData")
public class BookDataLoader {
    private final BookRepository bookRepository;
    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        var book1 = Book.of("1231231234", "Northern Lights", "Lyra Silverstar", 9.90);
        var book2 = Book.of("1231231235", "Disc World", "Terry Pratchett", 9.90);
        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}
