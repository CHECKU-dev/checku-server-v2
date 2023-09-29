package com.checku.core.mysubject.service.port;

import com.checku.core.mysubject.domain.MySubject;

public interface MySubjectRepository {

    MySubject save(MySubject mySubject);
}
