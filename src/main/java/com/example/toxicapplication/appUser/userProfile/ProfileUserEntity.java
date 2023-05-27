package com.example.toxicapplication.appUser.userProfile;

import com.example.toxicapplication.appUser.AppUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@Data
public class ProfileUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @Column
    private double ratingUser;
    @Column
    private long topUser;
    @Column(name = "all_id_photo_user")
    private String allIdPhotoUser;

    public ProfileUserEntity(AppUser appUser) {
        this.appUser = appUser;
        this.allIdPhotoUser = "";
    }

    public List<Long> getAllIdPhotoUser() {
        if (allIdPhotoUser.isEmpty()) {
            return new ArrayList<>();
        }
        return Arrays.stream(allIdPhotoUser.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public void setAllIdPhotoUser(List<Long> photoIds) {
        this.allIdPhotoUser = photoIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}