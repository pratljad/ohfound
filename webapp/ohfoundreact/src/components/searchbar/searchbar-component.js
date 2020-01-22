import React, { useState, useEffect } from "react";
import locationService from '../../services/locationService.js';
import LoginMenubarComponent from '../login/login-menubar-component.js';
import LegendComponent from '../legend/legend-component.js';

const SearchBarComponent = ({onLocationUpdate}) => {
    const [locations, setLocations] = useState(null);
    const [currentLocation, setCurrentLocation] = useState({
        loc_id: 0,
        loc_name: "",
        loc_lat: 0,
        loc_lng: 0
    });

    const mySBStyle = {
        width: "25%",
        margin: "25px"
    };

    const myLocationListStyle = {
        width: "50%",
        color: "white",
        margin: "25px"
    };

    useEffect(() => {
        if(!locations) {
          getLocations();
        }
    })

    const getLocations = async () => {
        let res = await locationService.getAllLocations();
        console.log(res);
        setLocations(res);
    }
    
    const handleInputChange = e => {
        if(e.key == "Enter") {
            checkLocation(e.target.value);
        }

    }

    //check if location exists in the database
    const checkLocation = async (locationName) => {
        var res = await locationService.getAllLocations();
        
       
        console.log(res)
        setLocations(res);  
        
        if(locations != null) {
            var searchedLocation = locations.find(locationNameCollection => {
                if(locationNameCollection.loc_name.toLowerCase() ==  locationName.toLowerCase())
                    return locationNameCollection;
            });
        }
        

        if(searchedLocation != undefined) {
            setCurrentLocation(searchedLocation);
            onLocationUpdate(searchedLocation);
            console.log("Current Location");
            console.log(searchedLocation);
        }
    }

    //Function that builds the location markers
    const renderLocation = (location) => {
        console.log("loc");
        console.log(location);
        return (
            <li key={location.loc_id} className="list__item product">
              <h3 className="product__name">{location.loc_name}</h3>
              <p className="product__description">LNG: {location.loc_lng} LAT: {location.loc_lat}</p>
            </li>
        );
    }

    return (
        <section>
            <div style={{width: "100%"}}>
                <input type="search" name="mySB" style={mySBStyle} placeholder="Search..." onKeyDown={handleInputChange} />
                <LegendComponent />
            </div>
            
            <div style={myLocationListStyle} >
            {(currentLocation != null) ? (
                renderLocation(currentLocation)
            ) : (
            <p>searched location null</p>
            )}
            </div>
        </section>
    );
}

export default SearchBarComponent;