import React, { useState, useEffect } from 'react';
import ReactMapGL, {Marker, Popup} from "react-map-gl";

import inseratService from '../../services/inseratService.js';

import SearchBarComponent from '../searchbar/searchbar-component.js';


const MapComponent = () => {
    const [inserate, setInserate] = useState(null);
    const [viewport, setViewport] = useState({
        latitude: 46.602493,
        longitude: 13.843117,
        width: "100vw",
        height: "100vh",
        zoom: 14
    });
    
    const [selectedItem, setSelectedItem] = useState(null);
    const [searchedLocation, setSearchedLocation] = useState({
        loc_id: 1,
        loc_name: "Standard",
        loc_lat: 46.6141921,
        loc_lng: 13.8496302
    });

    const [selectedSearchedLocation, setSelectedSearchedLocation] = useState(null);

    const colorWhite = {
        color: "white"
    }
    

    function handlePopupClose() {
        setSelectedItem(null);
    }

    function handleLocationPopupClose() {
        setSelectedSearchedLocation(null);
    }

    useEffect(() => {
        
        if(!inserate) {
            getInserate();
        }
    })

    const getInserate = async () => {
        let res = await inseratService.getAllInserate();
        console.log("IN GET INSERATE: " + res);
        setInserate(res);
    }



    const renderInserat = inserat => {
        //console.log(selectedItem);
        return (
            <Marker
                key={inserat.in_id}
                latitude={inserat.coordinates[0]}
                longitude={inserat.coordinates[1]}
            >
                <button className="marker-btn"
                onClick={e => {
                    e.preventDefault();
                    setSelectedItem(inserat);
                }}
                >
                <img src="/icons/marker_icon_2.svg" alt="Lost Item" />
                </button>
            </Marker>
        );
    };

    const renderLocations = location => {
        console.log("in render", location);

        
        return (
            <Marker
                key={location.loc_id}
                latitude={location.loc_lat}
                longitude={location.loc_lng}
            >
                <button className="marker-btn"
                    onClick={e=>{
                        e.preventDefault();
                        //setSearchedLocation(location);
                        setSelectedSearchedLocation(location);
                        console.log("bttn click");
                        console.log(selectedSearchedLocation);
                    }}
                >
                <img src="/icons/marker_icon.svg" alt="Location searched" />
                </button>
            </Marker>
        );
    };

    const onLocationUpdate = (location) => {
        console.log("in parent");
        console.log(location);
        setSearchedLocation(prevLocation => Object.assign(prevLocation, location));
        setViewport({
            latitude: location.loc_lat,
            longitude: location.loc_lng,
            width: "100vw",
            height: "100vh",
            zoom: 14}
        );
        renderLocations(searchedLocation);
        console.log("after render searched location");
        console.log(searchedLocation);

 
    }

  return (
    <div>

        <ReactMapGL
                {...viewport}
                mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
                mapStyle="mapbox://styles/pratljad/ck365eg270es51cpioo1agftc"
                onViewportChange={viewport => {
                setViewport(viewport);
                }}

        >
            
        
        
        <SearchBarComponent onLocationUpdate={onLocationUpdate}/>
            {(searchedLocation) ? (
                console.log("update", searchedLocation),
                //renderLocations(searchedLocation)
                renderLocations(searchedLocation)
            ) : (
                <p style={colorWhite}> No location searched</p>
            )}

            {(inserate && inserate.length > 0) ? (
            inserate.map(inserat => renderInserat(inserat))
            ) : (
            <p>No inserate found</p>
            )}

            { selectedItem ? (
                <Popup 
                    latitude={selectedItem.coordinates[0]} 
                    longitude={selectedItem.coordinates[1]}
                    onClose={handlePopupClose}
                >
                    <div>
                        <h3>{selectedItem.in_typ}: {selectedItem.in_title}</h3>
                    </div>
                </Popup>
            ) : null }

            { selectedSearchedLocation ? (
                <Popup 
                    latitude={selectedSearchedLocation.loc_lat} 
                    longitude={selectedSearchedLocation.loc_lng}
                    onClose={handleLocationPopupClose}
                >
                    <div>
                        <h1>Location {selectedSearchedLocation.loc_name}</h1>
                        <h2>ID: {selectedSearchedLocation.loc_id}</h2>
                        <h3>Latitude: {selectedSearchedLocation.loc_lat}</h3>
                        <h3>Longitude: {selectedSearchedLocation.loc_lng}</h3>
                    </div>
                </Popup>
            ) : null }
        </ReactMapGL>
    </div>
  );

}
/*
<ReactMapGL
                {...viewport}
                mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
                mapStyle="mapbox://styles/pratljad/ck365eg270es51cpioo1agftc"
                onViewportChange={viewport => {
                setViewport(viewport);
                }}
                ref={(c) => this._map = c}
            >
            
        </ReactMapGL>
        */
export default MapComponent;
