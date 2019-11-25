import React, { useState, useEffect } from "react";

// SERVICES
import locationService from '../../services/locationService';

function LocationComponent() {
  const [locations, setLocations] = useState(null);

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

  const renderLocation = location => {
    return (
      <li key={location.loc_id} className="list__item product">
        <h3 className="product__name">{location.loc_name}</h3>
        <p className="product__description">LNG: {location.loc_lng} LAT: {location.loc_lat}</p>
      </li>
    );
  };

  return (
    <div className="App">
      <ul className="list">
        {(locations && locations.length > 0) ? (
          locations.map(location => renderLocation(location))
        ) : (
          <p>No locations found</p>
        )}
      </ul>
    </div>
  );
}

export default LocationComponent;