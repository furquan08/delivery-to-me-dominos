package com.jos.dem.springboot.cucumber.model;

import java.util.List;

public class Response{
	private List<String> address;
	private String displayName;
	private double latitude;
	private String placeId;
	private String marketCode;
	private boolean containsSearchLocation;
	private double distanceFromSearchLocation;
	private String storeId;
	private double longitude;

	public List<String> getAddress(){
		return address;
	}

	public String getDisplayName(){
		return displayName;
	}

	public double getLatitude(){
		return latitude;
	}

	public String getPlaceId(){
		return placeId;
	}

	public String getMarketCode(){
		return marketCode;
	}

	public boolean isContainsSearchLocation(){
		return containsSearchLocation;
	}

	public double getDistanceFromSearchLocation(){
		return distanceFromSearchLocation;
	}

	public String getStoreId(){
		return storeId;
	}

	public double getLongitude(){
		return longitude;
	}
}