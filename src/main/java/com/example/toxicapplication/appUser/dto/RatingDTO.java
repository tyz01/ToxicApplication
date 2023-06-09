package com.example.toxicapplication.appUser.dto;

import lombok.Data;

@Data
public class RatingDTO {
    private Long idProfile;
    private Long idPhoto;
    private String profileName;
    private double ratingUser;
    private long topUser;
    private Long idPhotoCircle;
    private byte[] photoRectangle;
}
