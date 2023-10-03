package com.checku.core.mysubject.application;

import com.checku.core.mysubject.domain.MySubject;
import com.checku.core.mysubject.domain.MySubjectCreateCommand;
import com.checku.core.mysubject.service.port.MySubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class MySubjectCommandService {

    private final MySubjectRepository mySubjectRepository;

    public MySubject create(MySubjectCreateCommand mySubjectCreateCommand) {
        MySubject mySubject = MySubject.create(mySubjectCreateCommand);
        return mySubjectRepository.save(mySubject);
    }

    public void delete(Long id) {
        // 검증 로직 추가?
        mySubjectRepository.deleteById(id);
    }
}
