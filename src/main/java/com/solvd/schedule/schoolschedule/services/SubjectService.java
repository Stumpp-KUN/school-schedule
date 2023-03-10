package com.solvd.schedule.schoolschedule.services;

import com.solvd.schedule.schoolschedule.models.Subjects;
import com.solvd.schedule.schoolschedule.repositorys.ISubjectsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SubjectService {

    private ISubjectsRepository iSubjectsRepository;

    public SubjectService(ISubjectsRepository iSubjectsRepository) {
        this.iSubjectsRepository = iSubjectsRepository;
    }

    @Transactional
    public Subjects saveSubjects(Subjects subjects) {
        return iSubjectsRepository.save(subjects);
    }

    public Subjects getSubjects(long id) {
        Optional<Subjects> subjects = iSubjectsRepository.findById(id);
        if (subjects.isEmpty()) return null;
        return subjects.get();
    }

    @Transactional
    public Subjects updateSubjects(Subjects subjects) {
        return iSubjectsRepository.save(subjects);
    }

    @Transactional
    public void deleteSubjects(long id) {
        iSubjectsRepository.deleteById(id);
    }

    public List<Subjects> getAll() {
        List<Subjects> subjects = (List<Subjects>) iSubjectsRepository.findAll();
        return subjects;
    }

    public int countAll() {
        List<Subjects> subjects = (List<Subjects>) iSubjectsRepository.findAll();
        return subjects.size();
    }
}
