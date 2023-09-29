package com.checku.core.mysubject.infrastructure;

import com.checku.core.common.BaseTimeEntity;
import com.checku.core.mysubject.domain.MySubject;

import javax.persistence.*;

@Entity
@Table(name = "my_subject")
public class MySubjectEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subject_number", nullable = false)
    private String subjectNumber;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    public MySubject toModel() {
        return MySubject.builder()
                .id(id)
                .subjectNumber(subjectNumber)
                .userId(userId)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    public static MySubjectEntity from(MySubject mySubject) {
        MySubjectEntity mySubjectEntity = new MySubjectEntity();
        mySubjectEntity.id = mySubject.getId();
        mySubjectEntity.subjectNumber = mySubject.getSubjectNumber();
        mySubjectEntity.createdAt = mySubject.getCreatedAt();
        mySubjectEntity.updatedAt = mySubject.getUpdatedAt();
        return mySubjectEntity;
    }
}
