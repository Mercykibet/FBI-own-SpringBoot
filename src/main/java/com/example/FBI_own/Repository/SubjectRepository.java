package com.example.FBI_own.Repository;

import com.example.FBI_own.Entity.SubjectEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEvent,Long> {


}
