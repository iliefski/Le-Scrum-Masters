package model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.le_scrum_masters.notpokemongo.R;

import java.util.ArrayList;
import java.util.List;

import static com.le_scrum_masters.notpokemongo.R.drawable.parkis;

/**
 * Created by Albin on 2016-09-29.
 */
public class NPGPointOfInterest implements PointOfInterest {
    private String name;
    private String address;
    private String id;
    private List<Integer> placeType;
    private Bitmap image;
    private int icon;
    private LatLng coords;
    private Boolean completed = false;
    private Boolean isOnMap = false;
    private int activePlaceType = 2;


    public NPGPointOfInterest(String name, String address, String id, LatLng latlng){
        this.name = name;
        this.address = address;
        this.id = id;
        this.coords = latlng;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public LatLng getCoords() {
        return this.coords;
    }


    /*
    Existing placetypes:
        cafe - 15
        Campground - 16
        Department store - 29
        Food - 38
        Hospital - 50
        Library - 55

     */
    @Override
    public void setPlaceTypes(List<Integer> types) {
        this.placeType = types;

        if (placeType.contains(Place.TYPE_CAFE)){
            activePlaceType = Place.TYPE_CAFE;
            setIcon(R.drawable.cafe);
        } else if (placeType.contains(Place.TYPE_CAMPGROUND)){
            activePlaceType = Place.TYPE_CAMPGROUND;
            setIcon(R.drawable.tree);
        } else if (placeType.contains(Place.TYPE_DEPARTMENT_STORE)){
            activePlaceType = Place.TYPE_DEPARTMENT_STORE;
            setIcon(R.drawable.mmonument);
        } else if (placeType.contains(Place.TYPE_FOOD)){
            activePlaceType = Place.TYPE_FOOD;
            setIcon(R.drawable.cutlery);
        } else if (placeType.contains(Place.TYPE_HOSPITAL)){
            activePlaceType = Place.TYPE_HOSPITAL;
            setIcon(R.drawable.ffountain_2);
        } else if (placeType.contains(Place.TYPE_LIBRARY)){
            activePlaceType = Place.TYPE_LIBRARY;
            setIcon(R.drawable.cchapel);
        } else{
            setIcon(R.drawable.pplayground);
        }

    }

    @Override
    public List<Integer> getPlaceTypes() {
        return placeType;
    }

    @Override
    public int getActivePlaceType(){
        return this.activePlaceType;
    }

    @Override
    public void setImage(Bitmap image) {
        this.image = image;
    }

    private void setIcon(int drawableID) {
        this.icon = drawableID;
    }

    @Override
    public int getIcon(){
        return this.icon;
    }

    @Override
    public Bitmap getImage() {
        return image;
    }

    @Override
    public Boolean isCompleted() {
        return completed;
    }

    @Override
    public void setCompleted(Boolean bool){
        completed = bool;
        setIcon(R.drawable.checkgreen);
        if (placeType.contains(Place.TYPE_FOOD)) {
            setIcon(R.drawable.cutlerygold);
        } else {
            setIcon(R.drawable.checkgreen);
        }
    }

    public void setIsOnMap(Boolean bool){
        isOnMap = bool;
    }

    public Boolean isOnMap(){
        return this.isOnMap;
    }
}
