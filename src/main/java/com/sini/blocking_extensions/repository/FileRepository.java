package com.sini.blocking_extensions.repository;

import com.sini.blocking_extensions.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
