package com.hotel.management.rating.service.ratingEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="HOTEL_MANAGEMENT_RATING")
public class RatingEntity {

	@Id
	@Column(name="RATING_ID")
	private String ratingId;
	
	@Column(name="RATING_USER_ID")
	private String userId;
	
	@Column(name="RATING_HOTEL_ID")
	private String hotelId;
	
	@Column(name="RATING")
	private int rating;
	
	@Column(name="RATING_FEEDBACK")
	private String feedback;

	public String getRatingId() {
		return ratingId;
	}

	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@Override
	public String toString() {
		return "RatingEntity [ratingId=" + ratingId + ", userId=" + userId + ", hotelId=" + hotelId + ", rating="
				+ rating + ", feedback=" + feedback + "]";
	}
	
}
