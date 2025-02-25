package com.example.FBI_own.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TaskItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String imageUrl;



    public TaskItem(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }

    public String getTitle() {
        return title; }
    public void setTitle(String title) {
        this.title = title; }

    public String getDescription() {
        return description; }
    public void setDescription(String description) {
        this.description = description; }
}


