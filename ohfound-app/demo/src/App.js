import React, { useState } from 'react';
import ReactMapGL, {Marker, Popup} from "react-map-gl";
import SearchField from "react-search-field";

import * as itemData from './data/lostitems.json';

export default function App() {
  const [viewport, setViewport] = useState({
      latitude: 46.602493,
      longitude: 13.843117,
      width: "100vw",
      height: "100vh",
      zoom: 14
  });

  const [selectedItem, setSelectedItem] = useState(null);

  function handlePopupClose() {
    setSelectedItem(null);
  }

  const handleSliderChange = e => {
    setViewport({
      ...viewport,
      [e.target.name]: e.target.value
    });
    console.log("slider val " +e.target.value);
  };

  const handleChange = e => {
    console.log('setting level', e.target.value)
  };

  return (
    <div>
      <div className="sb-class">
        <SearchField
            placeholder="Search..."
            searchText="Search..."
            classNames="full-width-sb"
        />
      </div>
      <ReactMapGL
      {...viewport}
      mapboxApiAccessToken={process.env.REACT_APP_MAPBOX_TOKEN}
      mapStyle="mapbox://styles/pratljad/ck365eg270es51cpioo1agftc"
      onViewportChange={viewport => {
        setViewport(viewport);
      }}
      >
        
        {itemData.features.map(item => (
          <Marker
            key={item.properties.ITEM_ID}
            latitude={item.geometry.latitude}
            longitude={item.geometry.longitude}
          >
            <button className="marker-btn"
              onClick={e => {
                e.preventDefault();
                setSelectedItem(item);
              }}
            >
              <img src="/icons/marker_icon_2.svg" alt="Lost Item" />
            </button>
          </Marker>
        ))}

        {selectedItem ? (
            <Popup 
            latitude={selectedItem.geometry.latitude} 
            longitude={selectedItem.geometry.longitude}
            onClose={handlePopupClose}
            >
              <div>
                <h3>Item: {selectedItem.properties.ITEM_NAME}</h3>
                <ul>
                {selectedItem.properties.ITEM_DESCRIPTION.map(description => (
                  <li>{description}</li>
                ))}
                </ul>
              </div>
            </Popup>
          ) : null 
        }
        <div>
        <p className="whiteTxt">Zoom Level{viewport.zoom}: <input type="range" min="1" max="20" value={viewport.zoom} className="slider" orient="vertical" step="1" onChange={(e)=>{console.log("changed " + e.target.value);}}onMouseUp={(e) => {handleSliderChange(e)}}></input></p>
        
      </div>
      </ReactMapGL>
      
    </div>
  );

}
