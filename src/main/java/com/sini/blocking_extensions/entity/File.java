package com.sini.blocking_extensions.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String originalFilename; // 김시은

    @Column(nullable = false)
    private String keyName; // 김시은jpg823049823

    @Column(nullable = false)
    private String filePath; // s3dla4l23mf

    @Column(nullable = false)
    private String type; // jpg

    public File(String originalFilename, String keyName, String filePath, String fileType) {
        this.originalFilename = originalFilename;
        this.keyName = keyName;
        this.filePath = filePath;
        this.type = type;
    }
}
