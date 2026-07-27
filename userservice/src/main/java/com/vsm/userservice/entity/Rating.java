package com.vsm.userservice.entity;


public class Rating {
	
	private long ratingid;
	private long userid;
	private long hotelid;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	
	public long getRatingid() {
		return ratingid;
	}
	public void setRatingid(long ratingid) {
		this.ratingid = ratingid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public long getHotelid() {
		return hotelid;
	}
	public void setHotelid(long hotelid) {
		this.hotelid = hotelid;
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
	
	
	
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public Rating(long ratingid, long userid, long hotelid, int rating, String feedback, Hotel hotel) {
		super();
		this.ratingid = ratingid;
		this.userid = userid;
		this.hotelid = hotelid;
		this.rating = rating;
		this.feedback = feedback;
		this.hotel = hotel;
	}
	public Rating() {
		super();
		
	}
	
	

}
