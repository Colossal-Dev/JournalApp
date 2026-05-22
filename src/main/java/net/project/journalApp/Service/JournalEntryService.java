package net.project.journalApp.Service;

import lombok.extern.slf4j.Slf4j;
import net.project.journalApp.Repository.JournalEntryRepository;
import net.project.journalApp.entity.JournalEntry;
import net.project.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void saveEntry (JournalEntry journalEntry, String username) {
      try{
          User user = userService.findByUsername(username);
          journalEntry.setDate(LocalDateTime.now());
          JournalEntry saved = journalEntryRepository.save(journalEntry);
          user.getJournalEntries().add(saved);
//          user.setUsername(null);
          userService.saveEntry(user);

      } catch (Exception e) {
          log.error(e.getMessage());
          throw new RuntimeException("An error occured while saving the entry,",e);
      }
    }
    // I create this only for put mapping
    public void saveEntry (JournalEntry journalEntry) {

       journalEntryRepository.save(journalEntry);

    }
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String username) {
        boolean removed = false;
        try {
            User user  = userService.findByUsername(username);
           removed = user.getJournalEntries().removeIf(x->x.getId().equals(id));
            if(removed) {
                userService.saveEntry(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            log.error("Error",e);
            throw new RuntimeException("an error occur while deleting the entry ",e);
        }
        return removed;

    }
}
